package boardserivice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.Board;

public class BoardListService implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getInstance();
		List<Board> boardList=bDao.getBoardAll();
		request.setAttribute("boardList", boardList); //request의 속성으로 값("boardList") 저장, boardList이름으로 저장
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response); //다음 페이지(포워딩)
		
	}
	

}
