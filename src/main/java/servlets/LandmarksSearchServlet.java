package main.java.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.etities.Landmark;
import main.java.services.LandmarkAskQueryService;

/**
 * Servlet implementation class LandmarksSearchServlet
 */
@WebServlet(description = "It's looking for the closest landmark to word user asks", urlPatterns = {
		"/LandmarksSearchServlet" })
public class LandmarksSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String codeword = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LandmarksSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (this.codeword != "") {
			// Инициализирую список
			List<Landmark> landmarks = null;
			// Делаю запрос
			LandmarkAskQueryService landmarkAskQuery = new LandmarkAskQueryService();
			landmarks = landmarkAskQuery.getLandmarksBySearch(this.codeword);
			// Проверяю, не пуст ли ответ
			if (landmarks != null) {
				//Передаю список в jsp на вывод
				request.setAttribute("landmarkList", landmarks);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/LandmarksList.jsp");
				requestDispatcher.forward(request, response);
			}
			// В ротивном случае сообщить о том, что выводить нечего 
			else {
				errorMessage(request, response);
			}
		} else {
			errorMessage(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Кириллица, работай
		request.setCharacterEncoding("UTF-8");
		// Забираю поисковый запрос в глобальную переменную
		this.codeword = (String) request.getParameter("codeword");
		doGet(request, response);

	}

	/*
	 * 
	 */
	private void errorMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Query resault is empty, nothing to see");
	}

}
