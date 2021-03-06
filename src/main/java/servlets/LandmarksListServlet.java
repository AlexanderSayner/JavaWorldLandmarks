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
import main.java.exceptions.LandmarkDataSourceException;
import main.java.services.LandmarkAskQueryService;
import main.java.services.LandmarkDatabaseService;

/**
 * Servlet implementation class LandmarksListServlet
 */
@WebServlet("/LandmarksListServlet")
public class LandmarksListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LandmarksListServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		List<Landmark> landmarks = null;

		LandmarkAskQueryService landmarkAskQuery = new LandmarkAskQueryService();
		landmarks = landmarkAskQuery.getAllLandmarks();

		request.setAttribute("landmarkList", landmarks);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/LandmarksList.jsp");
		requestDispatcher.forward(request, response);
	}

}
