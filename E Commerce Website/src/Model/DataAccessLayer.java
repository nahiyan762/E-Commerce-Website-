package Model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class DataAccessLayer {

	private Connection connection;
	private Statement statement;
	private String host = "localhost";
	private String database = "project";
	private String username = "root";
	private String password = "";
	private int port = 3306;
	
	public DataAccessLayer() 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://"+this.host+":"+this.port+"/"+this.database, this.username, this.password);
			this.statement = this.connection.createStatement();
			//System.out.println("Paise");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			//System.out.println("Pay nai");
		}
	}
	public Statement getStatement() {
		return statement;
	}
	
}
