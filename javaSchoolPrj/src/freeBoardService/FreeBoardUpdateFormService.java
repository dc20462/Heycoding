package freeBoardService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeBoardDAO;
import dto.FreeBoard;

public class FreeBoardUpdateFormService implements FreeBoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int page=Integer.parseInt(request.getParameter("page"));
		int bno=Integer.parseInt(request.getParameter("bno"));
		FreeBoardDAO bDao=FreeBoardDAO.getInstance();
		FreeBoard freeboard = bDao.getFreeBoard(bno);
		
		request.setAttribute("freeboard", freeboard);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/community/freeboard/freeboardUpdate.jsp").
		forward(request, response);
	}
}
