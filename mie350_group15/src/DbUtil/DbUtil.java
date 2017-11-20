package DbUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;




public class DbUtil {
	/**
	 * This class handles the database connection.
	 * 
	 * DO NOT modify this file unless you have set a username and password to
	 * your database files. (This is not needed if you have created your
	 * database files with Microsoft Access.
	 */

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Properties prop = new Properties();
				InputStream inputStream = DbUtil.class.getClassLoader()
						.getResourceAsStream("/db.properties");
				prop.load(inputStream);
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				Class.forName(driver);
				connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Kelvin/Documents/GitHub/mie350group15/mie350_group15/src/db/mie350_group15.mdb;memory=false"); 
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}
}
