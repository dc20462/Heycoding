package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.Member;

public class MemberJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setGender(request.getParameter("gender"));
		member.setAddr(request.getParameter("addr"));
		member.setTel(request.getParameter("tel"));
		MemberDAO dao=MemberDAO.getInstance();
		dao.insertMember(member);

		//작업 후 list.jsp로 간다
		response.sendRedirect("member?command=list");
	
	}
}
