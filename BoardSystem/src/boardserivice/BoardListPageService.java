package boardserivice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.Board;
import dto.PageMaker;

public class BoardListPageService implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//페이지파라미터를 받음
		String spage=request.getParameter("page");
		//페이지가 널일때
		if(spage==null) {
			spage="1";
		}
		int page = Integer.parseInt(spage);
		BoardDAO bDao = BoardDAO.getInstance();
		int totalCount = bDao.getTotalCount();
		PageMaker pageMaker = new PageMaker(page, totalCount);
		List<Board> boardList=bDao.getBoardPage(pageMaker.getStart(), pageMaker.getPageSize());
		request.setAttribute("boardList", boardList); //request의 속성으로 값("boardList") 저장, boardList이름으로 저장
		request.setAttribute("pageMaker", pageMaker); 
		request.getRequestDispatcher("/board/boardList.jsp")
		.forward(request, response); //다음 페이지(포워딩)
		
	}
	

}
