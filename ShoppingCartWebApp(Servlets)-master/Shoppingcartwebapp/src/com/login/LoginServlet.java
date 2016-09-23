package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @param dispatcher
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("usrname");
		String password = request.getParameter("psw");
		System.out.println(username);

		LoginDAO logindao = new LoginDAO();
		RequestDispatcher dispatcher;
		PrintWriter writer = response.getWriter();
		if (logindao.isValidUser(username, password) == true) {
			writer.println("Please enter valid credientials");

			dispatcher = request.getRequestDispatcher("LoginHomeRegistration.html");
			dispatcher.forward(request, response);
		} else {

			writer.println("Please enter valid credientials");

			dispatcher = request.getRequestDispatcher("LoginHomeRegistration.html");
			dispatcher.include(request, response);
		}
	}

}
