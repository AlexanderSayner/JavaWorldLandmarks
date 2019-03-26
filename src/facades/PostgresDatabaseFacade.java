package facades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.DatabaseException;

public class PostgresDatabaseFacade implements DatabaseFacade {
    private String className = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://";
    private String server = "127.0.0.1:5432/";
    private String database = "landmarks";
    private Connection connection = null;

    // изменяет значение поля сервера бд
    public void connect(String server, String database, String login, String password) {
    	this.server = server;
    	this.database = database;
    	try {
			this.connect(login,password);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // изменяет значение поля с названием бд
    public void connect(String database, String login, String password) {
    	this.database = database;
    	try {
			this.connect(login,password);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    // устанавливает и тестирует соединение, статус выводится в консоль
    public void connect(String login, String password) throws DatabaseException {
    	this.url += this.server + this.database;
    	
    	System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					this.url, login,
					password);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			this.connection = connection;
		} else {
			System.out.println("Failed to make connection!");
		}
    }

    @Override
    // если вдруг подключение понабится
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    // надо отсоединяться
    public void disconnect() {
        if(this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException sqle) {
                this.connection = null;
                sqle.printStackTrace();
            }
        }
    }
}

