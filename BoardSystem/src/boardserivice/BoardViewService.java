package boardserivice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardserivice.BoardService;
import dao.BoardDAO;
import dto.Board;
import dto.Reply;

public class BoardViewService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int page= Integer.parseInt(request.getParameter("page"));
		BoardDAO bDao = BoardDAO.getInstance();
		List<Reply> replyList = bDao.getReplyList(bno);
		
		Board board=bDao.getBoard(bno);
		if(board!=null) {
			bDao.read_count_update(bno); 
			//view 할때만. db안에 하면 수정 등을 할 때 read_count가 업데이트 되서.
		}
		//페이지 그려주기
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		request.setAttribute("replyList", replyList);		
		request.getRequestDispatcher("/board/view.jsp")
		.forward(request, response);
	}
}