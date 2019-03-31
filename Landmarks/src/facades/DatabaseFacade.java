package facades;

import exceptions.DatabaseException;
import java.sql.Connection;

public interface DatabaseFacade {
	// Подключение к базе
	void connect(String login, String password) throws DatabaseException;

	// Получение объекта с подключением к бд
	Connection getConnection();

	// Обязательное отключение
	void disconnect();
}
