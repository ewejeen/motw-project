package org.prj.MovieCommand;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MovieDAO.MovieDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MovieRegister implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String directory = request.getRealPath("/upload/");
		File f = new File(directory);
		if(!f.exists()) {
			f.mkdirs();
		}
		/*String saveDir = "C:\\Users\\Administrator\\Desktop\\webProject\\personalPRJ\\WebContent\\img\\poster";*/
		int maxSize = 8 * 1024 * 1024; // 8MB
		String encoding = "UTF-8";

		MultipartRequest multi = new MultipartRequest(request, directory, maxSize, encoding,
				new DefaultFileRenamePolicy());

		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String catchph = multi.getParameter("catchph");
		String username = multi.getParameter("username");
		String rlsDate = multi.getParameter("rlsDate");
		String director = multi.getParameter("director");
		String stars = multi.getParameter("stars");
		String rotten = multi.getParameter("rotten");
		String imdb = multi.getParameter("imdb");
		String wiki = multi.getParameter("wiki");
		String youtube = multi.getParameter("youtube");

		String image = multi.getFilesystemName("image"); // 파일 이름 중복 시 처리 후 이름
		// String image2 = multi.getOriginalFileName("image"); //파일 이름 중복 시 처리 전 이름

		MovieDAO dao = MovieDAO.getInstance();
		int result = dao.write(title, content, catchph, username, image, director, stars, rlsDate, rotten, imdb, wiki,
				youtube);

		if (result == 1) {
			System.out.println("성공!");
			System.out.println(directory);
			System.out.println(image);
			System.out.println(request.getContextPath());
			request.setAttribute("url", "/movieList.mv");
		} else {
			System.out.println("실패!");
		}
	}
}
