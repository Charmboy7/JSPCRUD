 package org.studyeasy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.studyeasy.entity.User;
import org.studyeasy.model.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page=request.getParameter("page");
//		response.getWriter().append("Served at: "+page).append(request.getContextPath());
		switch(page){
			case "home":{
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			}
			case "listusers":{
				List<User> users=new ArrayList<>();
				try {
					users=new UserModel().listuser();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("listusers", users);
				request.getRequestDispatcher("listusers.jsp").forward(request, response);
				break;
			}
			case "adduser":{
				request.getRequestDispatcher("adduser.jsp").forward(request, response);
				break;
			}
			case "updateuser":{
				request.getRequestDispatcher("updateuser.jsp").forward(request, response);
				break;
			}
			case "delete":{
				String id1=request.getParameter("user_id");
				int id=Integer.parseInt(id1);
				try {
					new UserModel().deleteUser(id);
				} catch (InstantiationException | IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<User> users=new ArrayList<>();
				try {
					users=new UserModel().listuser();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("listusers", users);
				request.getRequestDispatcher("listusers.jsp").forward(request, response);
				break;
			}
				
			default:{
				request.getRequestDispatcher("error.jsp").forward(request, response);
				break;
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String form=request.getParameter("form").toLowerCase();
		
		switch(form) {
		case "adduseroperation" :{
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			User user = new User(username, email);
			request.setAttribute("users", user);
			try {
				new UserModel().addUser(user);
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<User> users = new ArrayList<>();
			try {
				users = new UserModel().listuser();
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("listusers", users);
			request.getRequestDispatcher("listusers.jsp").forward(request, response);
			break;
		}
		case "updateuseroperation":{
			String id1=request.getParameter("user_id");
			int id=Integer.parseInt(id1);
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			User user = new User(id,username, email);
			request.setAttribute("users", user);
			
			
			try {
				new UserModel().updateUser(user);
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<User> users = new ArrayList<>();
			try {
				users = new UserModel().listuser();
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("listusers", users);
			request.getRequestDispatcher("listusers.jsp").forward(request, response);
			break;
		}
		}
	}

}
