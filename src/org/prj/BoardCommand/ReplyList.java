package org.prj.BoardCommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardDAO.BoardDAO;
import org.prj.BoardDTO.BoardDTO;

public class ReplyList implements BoardCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");

		int cGroup = Integer.parseInt(request.getParameter("cGroup"));

		PrintWriter out = response.getWriter();
		out.write(getJSON(cGroup));
		out.close();

	}

	public String getJSON(int cGroup) {
		StringBuffer result = new StringBuffer("");
		result.append("{'result':[");

		BoardDAO dao = BoardDAO.getInstance();

		ArrayList<BoardDTO> reply = dao.replyList(cGroup);
		
		for (BoardDTO dto : reply) {
			Date today = new Date();
			Timestamp regDate = dto.getRegDate();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
			
			String regTime="";
			if(date.format(today).equals(date.format(regDate))){		//오늘 등록한 댓글이면 시간, 아니면 날짜 보여줌
				regTime=time.format(regDate);
			} else {
				regTime=date.format(regDate);
			}
			
			result.append("[{'value':'" + dto.getContent() + "'},");
			result.append("{'value':'" + dto.getUsername() + "'},");
			result.append("{'value':'" + regTime + "'},");
			result.append("{'value':'" + dto.getcGroup()+ "'},");
			result.append("{'value':'" + dto.getHit()+ "'},");
			result.append("{'value':'" + dto.getIndent()+ "'},");
			result.append("{'value':'" + dto.getLikeCnt()+ "'},");
			result.append("{'value':'" + dto.getNo() + "'},");
			result.append("{'value':'" + dto.getStep() + "'},");
			result.append("{'value':'" + dto.getTitle() + "'}],");
		}
		result.append("]}");
		return result.toString();
	}

}
