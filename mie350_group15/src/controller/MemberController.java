package controller;

import DAO.MemberDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */

//This is the servlet for member to the List of members and to be used to be output to index.jsp.
public class MemberController extends HttpServlet {
	private MemberDAO dao;
	private static String LIST_MEMBERS="/index.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        dao = new MemberDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this commented section below was for testing the DB connection
		/*java.sql.Statement statement;
		try {
			statement = dao.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Member");
			while (rs.next()){
				System.out.println(rs.getInt("ID"));
			}
			System.out.println("Going into DbUtil");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//here is where we enter the values from the DB into a List of members
		RequestDispatcher view = request
				.getRequestDispatcher(LIST_MEMBERS);
		request.setAttribute("members", dao.getAllMembers());
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this commented section below was for testing the DB connection
		/*
		java.sql.Statement statement;
		try {
			statement = dao.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Member");
			while (rs.next()){
				System.out.println(rs.getInt("ID"));
			}
			System.out.println("Going into DbUtil");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		RequestDispatcher view = request
				.getRequestDispatcher(LIST_MEMBERS);
		request.setAttribute("members", dao.getAllMembers());
		view.forward(request, response);
	}

}
