import java.sql.SQLException;

import book.db.*;
public class maintest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBClass db= new DBClass();
		db.createConnection();
	}

}
