package freeBoardService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeBoardDAO;
import dto.FreeBoard;
import dto.FreeReply;


public class FreeBoardViewService implements FreeBoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int page= Integer.parseInt(request.getParameter("page"));
		FreeBoardDAO bDao = FreeBoardDAO.getInstance();
		List<FreeReply> freereplyList = bDao.getReplyList(bno);
		
		FreeBoard freeboard=bDao.getFreeBoard(bno);
		if(freeboard!=null) {
			bDao.read_count_update(bno); 
		}
		//페이지 그려주기
		request.setAttribute("Freeboard", freeboard);
		request.setAttribute("page", page);
		request.setAttribute("FreereplyList", freereplyList);		
		request.getRequestDispatcher("/freeboard/freeboardView.jsp").forward(request, response);
	}
}
