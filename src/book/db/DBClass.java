package book.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import book.model.Books;

/**
 *
 * @author Phuc
 */
public class DBClass {
	public Connection createConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/sachdb", "postgres", "dtbt");
		connection.setAutoCommit(false);

		return connection;
	}

	// we get values from servlet by passing bean object to insert details method
	public int insertDetails(Books bb) throws SQLException,
			ClassNotFoundException {
		Connection con = createConnection();
		PreparedStatement pstmt = con
				.prepareStatement("insert into sach values(?,?,?,?,?,?)");
		// set values to prepared statement object by getting values from bean
		// object
		pstmt.setString(1, bb.getName());

		pstmt.setString(2, bb.getName());
		pstmt.setString(3, bb.getCategory());

		int i = pstmt.executeUpdate();
		return i;

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
	       
	        Connection con = createConnection();
	        PreparedStatement pstmt = con.prepareStatement("select * from sach");
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
	    }

	

}
