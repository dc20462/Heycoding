package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.Member;

public class MemberUpdateFormService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao=MemberDAO.getInstance();
		String id=request.getParameter("id");
		Member member = dao.getMember(id);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/member/update.jsp").forward(request, response);
		//받는 것은 update.jsp의 ${member.id}
		
	}

}
