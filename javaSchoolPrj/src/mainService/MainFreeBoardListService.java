package mainService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeBoardDAO;
import dto.FreeBoard;
import dto.PageMaker;

public class MainFreeBoardListService implements MainService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("aaa");
		String spage=request.getParameter("page");
		//페이지가 널일때
		if(spage==null) {
			spage="1";
		}
		int page = Integer.parseInt(spage);
		FreeBoardDAO bDao = FreeBoardDAO.getInstance();
		int totalCount = bDao.getTotalCount(); 
		PageMaker pageMaker = new PageMaker(page, totalCount);
		List<FreeBoard> freeboardList=bDao.getFreeBoardPage(pageMaker.getStart(), pageMaker.getPageSize());
		for(int i=0; i<freeboardList.size();i++)
		{
			System.out.println(freeboardList.get(i).toString());
		}
		request.setAttribute("freeboardList", freeboardList); //request의 속성으로 값("boardList") 저장, boardList이름으로 저장
		request.setAttribute("pageMaker", pageMaker); 
		request.getRequestDispatcher("/community/freeboard/freeboardList.jsp")
		.forward(request, response); //다음 페이지(포워딩)

		
		
//		FreeBoardDAO bDao=FreeBoardDAO.getInstance();
//		List<FreeBoard> freeboardList=bDao.getFreeBoardAll();
//		request.setAttribute("freeboardList", freeboardList);
//		request.getRequestDispatcher("/freeboard/freeboardList.jsp").forward(request, response);
	}

	}
