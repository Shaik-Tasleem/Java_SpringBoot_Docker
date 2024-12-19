package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.University;

import java.io.IOException;
import java.util.List;

import dao.UniversityDAO;

/**
 * Servlet implementation class SavedUniversitiesServlet
 */
public class SavedUniversitiesServlet extends HttpServlet {
	private final UniversityDAO universityDAO = new UniversityDAO();

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavedUniversitiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<University> universities = universityDAO.getSavedUniversities();
        request.setAttribute("universities", universities);
        request.getRequestDispatcher("savedUniversities.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("save".equals(action)) {
                String name = request.getParameter("name");
                String country = request.getParameter("country");
                String website = request.getParameter("website");
                
                if (name != null && country != null && website != null) {
                    universityDAO.saveUniversity(new University(name, country, website));
                }
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                universityDAO.deleteUniversity(id);
            }

            // After processing, retrieve the updated list of universities
            List<University> universities = universityDAO.getSavedUniversities();
            request.setAttribute("universities", universities);
            
            // Forward to the JSP page
            request.getRequestDispatcher("savedUniversities.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // Handle error appropriately
        }
    }

}
