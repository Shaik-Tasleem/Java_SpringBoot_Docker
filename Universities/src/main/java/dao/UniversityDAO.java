package dao;

import model.University;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UniversityDAO {

    public void saveUniversity(University university) {
        String query = "INSERT INTO universities (name, country, website) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, university.getName());
            stmt.setString(2, university.getCountry());
            stmt.setString(3, university.getWebsite());
            System.out.println("inserted");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally throw a custom exception here
        }
    }

    public List<University> getSavedUniversities() {
        List<University> universities = new ArrayList<>();
        String query = "SELECT * FROM universities";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                University university = new University();
                university.setId(rs.getInt("id"));
                university.setName(rs.getString("name"));
                university.setCountry(rs.getString("country"));
                university.setWebsite(rs.getString("website"));
                universities.add(university);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return universities;
    }

    public void deleteUniversity(int id) {
        String query = "DELETE FROM universities WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public University getUniversityById(int id) {
        University university = null;
        String query = "SELECT * FROM universities WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                university = new University();
                university.setId(rs.getInt("id"));
                university.setName(rs.getString("name"));
                university.setCountry(rs.getString("country"));
                university.setWebsite(rs.getString("website"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return university;
    }

    public void updateUniversity(University university) {
        String query = "UPDATE universities SET name = ?, country = ?, website = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, university.getName());
            stmt.setString(2, university.getCountry());
            stmt.setString(3, university.getWebsite());
            stmt.setInt(4, university.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
