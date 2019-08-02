package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException; 
} //memberServlet - doget이나 dopost에서 길게 쓰지 않고 여기서 작성할 것임 
