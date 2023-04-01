package in.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JdbcUtil {
	
	//No one can create object of JdbcUtil causes of Private Constructor
	private JdbcUtil(){
		
	}
	
	static
	{
		//loading and register the Driver
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnction() throws SQLException, IOException
	{
		// Take the data from properties file
		FileInputStream fis = new FileInputStream("E:\\Eclipse-Workspace\\JdbcCRUDApp\\src\\in\\com\\properties\\application.properties");
		Properties properties = new Properties();
		
		properties.load(fis);
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
		return connection;
	}
	
	public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException
	{
		if (connection != null) {
			connection.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}
		

}
