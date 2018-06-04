package com.anya;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "RegistrServlet",
        urlPatterns = {"/hello"},
        loadOnStartup = 1)

public class RegistrServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            String sql = "INSERT INTO users (name, password) VALUES (?,?) ";
            Connection conn = DBConnentor.getDbConnection();
            PreparedStatement smt = conn.prepareStatement(sql);
            smt.setString(1, name);
            smt.setString(2, password);
            smt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
