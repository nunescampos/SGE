package br.com.project.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispacha_erro")
public class ServletException extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletException() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		RequestDispatcher view = redirect(request);
		try {
			view.forward(request, response);
		} catch (javax.servlet.ServletException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		RequestDispatcher view = redirect(request);
		try {
			view.forward(request, response);
		} catch (javax.servlet.ServletException e) {
			e.printStackTrace();
		}
	}

	private RequestDispatcher redirect(HttpServletRequest request) {
		RequestDispatcher view = request.getRequestDispatcher("/error/error.jsf?faces-redirect=true&expired=true");
		return view;
	}

}
