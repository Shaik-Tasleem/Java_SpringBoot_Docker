package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.University;
import java.lang.reflect.Type;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.UniversityDAO;

/**
 * Servlet implementation class university
 */
public class university extends HttpServlet {
	private final UniversityDAO universityDAO = new UniversityDAO();
    private static final String API_URL = "http://universities.hipolabs.com/search?country=";


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        String jsonResponse = getUniversitiesFromAPI(country);

        // Parse JSON response to List<University>
        Gson gson = new Gson();
        Type universityListType = new TypeToken<List<University>>() {}.getType();
        List<University> universities = gson.fromJson(jsonResponse, universityListType);

        // Set universities list as request attribute and forward to JSP
        request.setAttribute("universities", universities);
        request.getRequestDispatcher("universitySearch.jsp").forward(request, response);
    }

    /**
     * Fetches universities JSON from the API.
     */
    private String getUniversitiesFromAPI(String country) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(API_URL + country);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * Handles the POST request by redirecting to doGet.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
