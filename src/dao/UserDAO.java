package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import util.DBConnection;

public class UserDAO {
	
	public boolean registerUser(User user) {
		// Checking the username is already present or not.
		String checksql = "SELECT username FROM users WHERE username = ?";
		
		// get from the db 
		try(Connection conn = DBConnection.getConnection(); /* Check the DB Connection */
				PreparedStatement stm = conn.prepareStatement(checksql) /*For Execute the SQL statement*/)
		{
			// Check the Username id already present
			stm.setString(1,user.getUsername());
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				System.out.println("[!] Username is Already Exists : So Try Another Name [!]");
				return false;
			}
			else
			{
				String sql = "INSERT INTO users (username,password_hash,role) VALUES (?,?,?)";
				PreparedStatement insert_smt = conn.prepareStatement(sql);
				insert_smt.setString(1, user.getUsername());
				insert_smt.setString(2, user.getPassword());
				insert_smt.setString(3, user.getRole());
				
				return insert_smt.executeUpdate() > 0; // If Execute successfull return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public User loginUser(String username) {
		// Login to user
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password_hash"),
                    rs.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
}
