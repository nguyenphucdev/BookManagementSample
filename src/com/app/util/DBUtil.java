package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.model.Books;

/**
 *
 * @author Phuc
 */
public class DBUtil {
	
	 Connection con = null;
	  PreparedStatement pstmt = null;
	public Connection createConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/sachdb", "postgres", "dtbt");
//		connection.setAutoCommit(false);

		return connection;
	}

	// we get values from servlet by passing bean object to insert details method
	public int insertDetails(Books bb) throws SQLException,
			ClassNotFoundException {
		int i=0;
		 try{
		con = createConnection();
		String sql = "INSERT INTO sach (id,tensach,theloai,nxb,giabia,tomtat) "
	               + "VALUES (nextval('sach_id_seq'::regclass), '"+bb.getName()+"', '"+bb.getCategory()+"', '"+bb.getPublisher()+"', '"+bb.getPrice()+"','"+bb.getSummary()+"' )";
		pstmt = con.prepareStatement(sql);

		i = pstmt.executeUpdate();
		
		 }catch(Exception e){
    		 e.printStackTrace();
    	 }
		 finally{
	    	 try{
	    		 if(pstmt != null)  pstmt.close();
	    		 if(con != null ) con.close();
	    	 }catch(Exception e){
	    		 e.printStackTrace();
	    	 }
	     }
	return i;
	}
	public Books getDetails(int id)throws SQLException, ClassNotFoundException
    {
		 
		 
	     try{
	    	//here we will write code to get a single record from database
	         con = createConnection();
	          pstmt = con.prepareStatement("select * from sach where id=?");
	          pstmt.setInt(1, id);
	          ResultSet rs = pstmt.executeQuery();
	        //  List<Books> list = new ArrayList<Books>();
	          Books bb = new Books();
	          while(rs.next())
	          {
	              
	          	bb.setId (Integer.parseInt(rs.getString(1)));
	  			bb.setName(rs.getString(2));
	  			bb.setCategory(rs.getString(3));
	  			bb.setPublisher(rs.getString(4));
	  			bb.setPrice(rs.getString(5));
	  			bb.setSummary(rs.getString(6));
	          }
	          return bb;
	     }finally{
	    	 try{
	    		 if(pstmt != null)  pstmt.close();
	    		 if(con != null ) con.close();
	    	 }catch(Exception e){
	    		 e.printStackTrace();
	    	 }
	     }
       
    }
	public List<Books> getAlldetails(Books bb) throws SQLException,
			ClassNotFoundException {
		
		Connection con = createConnection();
		PreparedStatement pstmt = con
				.prepareStatement("select * from sach");
		ResultSet rs = pstmt.executeQuery();
		List<Books> list = new ArrayList<Books>();
		while (rs.next()) {
			bb.setId (Integer.parseInt(rs.getString(1)));
			bb.setName(rs.getString(2));
			bb.setCategory(rs.getString(3));
			bb.setPublisher(rs.getString(4));
			bb.setPrice(rs.getString(5));
			bb.setSummary(rs.getString(6));
			list.add(bb);

		}
		return list;
	}
	  public List<Books> getAlldetails()throws SQLException, ClassNotFoundException
	    {
		
	     try{
	    	  con = createConnection();
		        pstmt = con.prepareStatement("select * from sach");
		        ResultSet rs = pstmt.executeQuery();
		        List <Books> list = new ArrayList<Books>();
		        while(rs.next())
		        {
		            Books bb = new Books();
		            bb.setId (Integer.parseInt(rs.getString(1)));
					bb.setName(rs.getString(2));
					bb.setCategory(rs.getString(3));
					bb.setPublisher(rs.getString(4));
					bb.setPrice(rs.getString(5));
					bb.setSummary(rs.getString(6));
					list.add(bb);

		        }
		        return list;
	     }finally{
	    	 try{
	    		 if(pstmt != null)  pstmt.close();
	    		 if(con != null ) con.close();
	    	 }catch(Exception e){
	    		 e.printStackTrace();
	    	 }
	     }
	        
	    }
	  public void UpateDetails(Books book, int id)
	    {
		 
	       try{
	    	    con = createConnection();
		        PreparedStatement pstmt = con.prepareStatement("update sach set tensach=?,theloai=?,nxb=?,giabia=?,tomtat=? where id=? ");
		        //set values to prepared statement object by getting values from bean object
		       
		        
		        pstmt.setString (1,book.getName() );
		        pstmt.setString (2,book.getCategory() );
		        pstmt.setString (3,book.getPublisher() );
		        pstmt.setString (4,book.getPrice() );
		        pstmt.setString (5,book.getSummary() );
		        pstmt.setInt (6,id );

		        pstmt.executeUpdate();
		        pstmt.close();
	       }catch(Exception e){
	    	   e.printStackTrace();
	       }finally{
				try {
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       }
	       
	        
	         
	    }
	      public void deleteDetails(int id)throws SQLException, ClassNotFoundException
	    {
	       //here we will write code to get a single record from database
	       Connection con = createConnection();
	        PreparedStatement pstmt = con.prepareStatement("delete * from sach where id=?");
	        pstmt.setInt(1, id);
	               
	    }
	

}
