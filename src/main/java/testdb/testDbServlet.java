package testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class testDbServlet
 */
@WebServlet("/testDbServlet")
public class testDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//setup connection variables
		String dUser = "javauser";
		String dpass = "password";
		String output = null;
				
				Statement tStatement=null;
				Connection tConnection = null;
				//ResultSet rs;
				
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");					
					tConnection= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe",dUser,dpass);

					/*	NOTE	
					 "jdbc:oracle:thin:@localhost:1521:xe","Admin","Password"
					 Connection URL:"jdbc:oracle:thin:@localhost:1521:xe"
					 API:jdbc
					 Database: oracle
					 The type of driver:thin
					 IP Address:@localhost
					 Port:1521
					 Oracle service ID: xe (enterprise eddition)
					 */
				
					//Statement tStatement=tConnection.createStatement(); //create query
					tStatement=tConnection.createStatement(); //create query
								
					String sql="select * from hr.CLIENT";
					//String sqlUPDATE="UPDATE CLIENTS SET CLIENTID=4 where CLIENTID=2";
					
					//stT2.executeUpdate(sqlUPDATE);
					//int a = stT2.executeUpdate(sqlUPDATE);
					//System.out.println(a);
					//ResultSet rs=stT1.executeQuery(sql);
					ResultSet rs=tStatement.executeQuery(sql);
					
				//	
					while(rs.next()){						
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5));
					output = output +rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5)+"\n";
					}
					//tConnection.close();
					
					System.out.println("Done!");
				// -- PrintWriter
					PrintWriter out = response.getWriter();
					out.println("Succesful connection.\n"+output);
					
				}
				catch (SQLException e){
					System.out.println(e);
				}
				catch(Exception e){
				System.out.println(e);
				//connT1.close();
				}
				finally{
					try {tConnection.close();
					}
					catch(SQLException e){
						System.out.println(e);
					}
				}
				
	}

}
