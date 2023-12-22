package org.studyeasy.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.studyeasy.config.DatabaseConfig;
import org.studyeasy.entity.*;




public class UserModel {
	
  public List<User> listuser() throws SQLException, InstantiationException, IllegalAccessException{
	  List<User> listusers=new ArrayList<User>();
	  Connection con=DatabaseConfig.getConnection();
	  Statement st=null;
	  ResultSet rs=null;
	  
	  String query="select user_id,username,email from user";
	  
	  try {
		  st= con.createStatement();
		  rs=st.executeQuery(query);
		  
		  while(rs.next()){
			 int id=rs.getInt("user_id");
			  String name=rs.getString("username");
			  String email=rs.getString("email");
			  listusers.add(new User(id,name,email));
		  }
		  
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
	  
	return listusers;
	  
  }
  
  public void addUser(User newuser) throws InstantiationException, IllegalAccessException, SQLException {
	  Connection connect=null;
	  PreparedStatement statement=null;
	  
	  connect=DatabaseConfig.getConnection();
	  String username=newuser.getUsername();
	  String email=newuser.getEmail();
	  String query="Insert into user(username,email) values (?,?)";
	  
	 statement=connect.prepareStatement(query);
	 statement.setString(1, username);
	 statement.setString(2, email);
	 statement.execute();
	 
	
	
	  
  }
  
  
  public void updateUser(User updateuser) throws InstantiationException, IllegalAccessException, SQLException {
	  Connection connect=null;
	  PreparedStatement statement=null;
	  
	  connect=DatabaseConfig.getConnection();
	  int userId=updateuser.getUser_id();
	  String email=updateuser.getEmail();
	  String username=updateuser.getUsername();
	  String query="update user set username=?,email=? where user_id=?";
	  
	  
		 statement=connect.prepareStatement(query);
		 statement.setString(1, username);
		 statement.setString(2, email);
		 statement.setInt(3, userId);
		 statement.executeUpdate();
  }
  
 public void deleteUser(int userid)throws InstantiationException, IllegalAccessException, SQLException {
	  Connection connect=null;
	  PreparedStatement statement=null;
	  
	  connect=DatabaseConfig.getConnection();
	  
	  String query="delete from user where user_id=?";
	 
	  statement = connect.prepareStatement(query);
	  statement.setInt(1, userid );
	  statement.execute();
 }
  
}
