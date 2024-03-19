package Movie_Ticket_Booking;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;



public class Database {
	Statement statement;
	Connection connection;

	// Database Connection
	public Database() {

		try {
			// below two lines are used for connectivity.
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-O793BPB:1433;DatabaseName= Movieticket;encrypt=true;trustServerCertificate=true;",
					"pritam", "123456");

			statement = connection.createStatement();

		} catch (Exception exception) {
			System.out.println(exception);
		}

	}

	// get password of corresponding login hashed password
	public String getOriginalUser(String cureentmail, String inputHashpassword) {
		try {

			String email = cureentmail;
			String Password = inputHashpassword;
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-O793BPB:1433;DatabaseName= Movieticket;encrypt=true;trustServerCertificate=true;",
					"pritam", "123456");
			statement = connection.createStatement();
			String st = "select Email from Userlogindata where Password='" + Password + "'  AND Email='" + email + "'";
			ResultSet rs = statement.executeQuery(st);

			while (rs.next()) {
				String E = rs.getString("Email");
				return E;
			}
			connection.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return null;

	}

	// finding name
	public String getUserName(String cureentmail) {

		String email = cureentmail;

		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-O793BPB:1433;DatabaseName= Movieticket;encrypt=true;trustServerCertificate=true;",
					"pritam", "123456");
			statement = connection.createStatement();
			String st = "select Name from Userlogindata where Email='" + email + "'";
			ResultSet rs = statement.executeQuery(st);

			while (rs.next()) {
				String p = rs.getString("Name");
				return p;

			}
			connection.close();

		} catch (Exception exception) {
			System.out.println(exception);
		}
		return null;
	}

	
	// Finding ongoing movie names
	public ArrayList<Movie> getOngoingMovies() {
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-O793BPB:1433;DatabaseName= Movieticket;encrypt=true;trustServerCertificate=true;",
					"pritam", "123456");
			Statement s = connection.createStatement();
			s.executeQuery("select Name from Movie where GETDATE()>screening_start and GETDATE()<=screening_end;");
			ResultSet rs =s.getResultSet();
			ArrayList<Movie> arrlist = new ArrayList<>();
			 while (rs.next()) {
				  String movie=rs.getString("Name");		  
			      Movie mv= new Movie(movie);
				  arrlist.add(mv);
				  }
				 return arrlist;
			///connection.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return null;
		

}

	public ArrayList<Movie> tobeReleased() {
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-O793BPB:1433;DatabaseName= Movieticket;encrypt=true;trustServerCertificate=true;",
					"pritam", "123456");
			Statement s = connection.createStatement();
			s.executeQuery("select Name ,screening_start from Movie where  GETDATE()<screening_start;");
			ResultSet rs =s.getResultSet();
			ArrayList<Movie> arrlist = new ArrayList<>();
			 while (rs.next()) {
				  String movie=rs.getString("Name");
				  String Date = rs.getString("screening_start");
				 Movie mv = new Movie(movie,Date);
				 arrlist.add(mv);
				  }
				  return arrlist;
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return null;
	}

public ArrayList<Movie> getallMoviedata() {
	try {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connection = DriverManager.getConnection(
				"jdbc:sqlserver://DESKTOP-O793BPB:1433;DatabaseName= Movieticket;encrypt=true;trustServerCertificate=true;",
				"pritam", "123456");
		Statement s = connection.createStatement();
		s.executeQuery("select * from Movie ");
		ResultSet rs =s.getResultSet();
		ArrayList<Movie> arrlist= new ArrayList<>();
		 while (rs.next()) {
			String name = rs.getString("Name");
			String Price = rs.getString("Price");	
			String Duration = rs.getString("Duration");
			String IMDb = rs.getString("IMDb");
			String screening_start = rs.getString("screening_start");		
			String screening_end = rs.getString("screening_end");
			Movie mv= new Movie(name,Price,Duration,IMDb,screening_start,screening_end);
			  arrlist.add(mv);	  
			  }
			 return arrlist;
		//connection.close();
	} catch (Exception exception) {
		System.out.println(exception);
	}
	return null;
	
}


}



