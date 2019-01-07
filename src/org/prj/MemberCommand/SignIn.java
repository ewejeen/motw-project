package org.prj.MemberCommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.PrivateKey;

import javax.crypto.Cipher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prj.MemberDAO.MemberDAO;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SignIn implements MemberCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String securedName = request.getParameter("securedName");
		String securedPw = request.getParameter("securedPw");

		HttpSession session = request.getSession();
		PrivateKey privateKey = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
		session.removeAttribute("__rsaPrivateKey__"); // 키의 재사용을 막는다. 항상 새로운 키를 받도록 강제.

		if (privateKey == null) {
			throw new RuntimeException("암호화 비밀키 정보를 찾을 수 없습니다.");
		}
		try {
			String username = decryptRsa(privateKey, securedName);
			String userPw = decryptRsa(privateKey, securedPw);
			request.setAttribute("decryptedName", username);
			request.setAttribute("decryptedPw", userPw);

			String decryptedName = (String) request.getAttribute("decryptedName");
			String decryptedPw = (String) request.getAttribute("decryptedPw");

			MemberDAO dao = MemberDAO.getInstance();
			int result = dao.signIn(decryptedName, decryptedPw);
			String url = "";

			if (result == 1) {
				session.setMaxInactiveInterval(60 * 10); // 10분 간 로그인 세션 유지
				session.setAttribute("sessionId", username);
				url = "/index.jsp";
			} else {
				url = "/signInFailed.jsp";
			}
			request.setAttribute("url", url);

		} catch (Exception e) {
			throw new ServletException(e.getMessage(), e);
		}
	}

	private String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {
		System.out.println("will decrypt : " + securedValue);
		Cipher cipher = Cipher.getInstance("RSA");
		byte[] encryptedBytes = hexToByteArray(securedValue);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		String decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.
		return decryptedValue;
	}

	/**
	 * 16진수 문자열을 byte 배열로 변환한다.
	 */
	public static byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() % 2 != 0) {
			return new byte[] {};
		}

		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < hex.length(); i += 2) {
			byte value = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
			bytes[(int) Math.floor(i / 2)] = value;
		}
		return bytes;
	}

	/**
	 * BigInteger를 사용해 hex를 byte[] 로 바꿀 경우 음수 영역의 값을 제대로 변환하지 못하는 문제가 있다.
	 */
	@Deprecated
	public static byte[] hexToByteArrayBI(String hexString) {
		return new BigInteger(hexString, 16).toByteArray();
	}

	public static String base64Encode(byte[] data) throws Exception {
		BASE64Encoder encoder = new BASE64Encoder();
		String encoded = encoder.encode(data);
		return encoded;
	}

	public static byte[] base64Decode(String encryptedData) throws Exception {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decoded = decoder.decodeBuffer(encryptedData);
		return decoded;
	}

}
