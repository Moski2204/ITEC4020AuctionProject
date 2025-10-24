package com.example.demo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class UserDAO {

    //signup
    public void addUser(User user) {
        String sql = "INSERT INTO users (userName, email, passWord, firstName, lastName) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassWord());
             pstmt.setString(4, user.getFirstName());
             pstmt.setString(5, user.getLastName());
              
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getString("userName"),
                    rs.getString("passWord"),
                    rs.getString("email"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getInt("id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    //signin 
    public User getUserByLogin(String userName, String passWord) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userName);
            pstmt.setString(2, passWord);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getString("userName"),
                    rs.getString("passWord"),
                    rs.getString("email"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getInt("id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //forgetPassWord,
        public boolean forgetPassWord(String userName, String email, String firstName, String lastName, String newPassWord) {
        String sql = "SELECT * FROM users WHERE username = ? AND email = ? AND firstName = ? AND lastName = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userName);
            pstmt.setString(2, email);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                 User user = new User(
                    rs.getString("userName"),
                    rs.getString("passWord"),
                    rs.getString("email"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getInt("id")
                );

                changePassWord(newPassWord, user);

                //Password has been changed 
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Incorrect user info
        return false;
    }


    //helper method to forgetpassord
    public void changePassWord(String pW, User user){
        user.setPassWord(pW);
    }


}


