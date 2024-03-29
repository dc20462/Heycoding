package boardserivice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.Board;

public class BoardUpdateFormService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int page=Integer.parseInt(request.getParameter("page"));
		int bno=Integer.parseInt(request.getParameter("bno"));
		BoardDAO bDao=BoardDAO.getInstance();
		Board board = bDao.getBoard(bno);
		
		System.out.println("BNO"+board);
		
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		//update와 view 폼이 다른 부분. 나머지는 같다. 비슷해서 같이쓰기도 한다.
		request.getRequestDispatcher("board/update.jsp").
		forward(request, response);
	}

}
