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
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/sachdb", "postgres", "dtbt");
		return connection;
	}

	// we get values from servlet by passing bean object to insertdetails method
	public int insertDetails(Books bb) throws SQLException,
			ClassNotFoundException {
		Connection con = createConnection();
		PreparedStatement pstmt = con
				.prepareStatement("insert into userdetails values(?,?,?,?)");
		// set values to prepared statement object by getting values from bean
		// object
		pstmt.setString(1, bb.getName());
		pstmt.setString(2, bb.getCategory());

		int i = pstmt.executeUpdate();
		return i;

	}

	public List<Books> getAlldetails(Books ubean) throws SQLException,
			ClassNotFoundException {

		Connection con = createConnection();
		PreparedStatement pstmt = con
				.prepareStatement("select * from userdetails");
		ResultSet rs = pstmt.executeQuery();
		List<Books> list = new ArrayList<Books>();
		while (rs.next()) {
			ubean.setName(rs.getString(1));
			ubean.setCategory(rs.getString(2));

			list.add(ubean);

		}
		return list;
	}

	public Books getDetails(String uname) throws SQLException,
			ClassNotFoundException {
		// here we will write code to get a single record from database
		Connection con = createConnection();
		PreparedStatement pstmt = con
				.prepareStatement("select * from userdetails where user_name=?");
		pstmt.setString(1, uname);
		ResultSet rs = pstmt.executeQuery();
		List<Books> list = new ArrayList<Books>();
		Books ubean = new Books();
		while (rs.next()) {

			ubean.setName(rs.getString(1));
			ubean.setCategory(rs.getString(2));

		}
		ubean.setAction("update");
		return ubean;
	}

	public void UpateDetails(String name, Books ubean) throws SQLException,
			ClassNotFoundException {

		Connection con = createConnection();
		PreparedStatement pstmt = con
				.prepareStatement("update userdetails set date_of_birth=?,e_mail=?,phone_no=? where user_name=? ");
		// set values to prepared statement object by getting values from bean
		// object
		pstmt.setString(1, ubean.getName());
		pstmt.setString(2, ubean.getCategory());
		pstmt.setString(4, name);
		pstmt.executeUpdate();

	}

	public void deleteDetails(String uname) throws SQLException,
			ClassNotFoundException {
		// here we will write code to get a single record from database
		Connection con = createConnection();
		PreparedStatement pstmt = con
				.prepareStatement("delete * from userdetails where user_name=?");
		pstmt.setString(1, uname);

	}

}
