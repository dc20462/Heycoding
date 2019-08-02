package boardserivice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardserivice.BoardService;
import dao.BoardDAO;

public class BoardDeleteService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		String page=request.getParameter("page");
		BoardDAO bDao=BoardDAO.getInstance();
		bDao.boardDelete(bno);
		response.sendRedirect("boardList.do?page="+page);
		
	}

}
