package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.University;

import java.io.IOException;

import dao.UniversityDAO;

/**
 * Servlet implementation class AddUniversityServlet
 */
public class AddUniversityServlet extends HttpServlet {
    private final UniversityDAO universityDAO = new UniversityDAO();

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUniversityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String name = request.getParameter("name");
	        String country = request.getParameter("country");
	        String website = request.getParameter("website");

	        University university = new University(0, name, country, website); // ID will be auto-generated
	        universityDAO.saveUniversity(university);
	        response.sendRedirect("savedUniversities");
}
}
