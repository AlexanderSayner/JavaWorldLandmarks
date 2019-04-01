package main.java.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.java.etities.Landmark;
import main.java.exceptions.*;
import main.java.facades.DatabaseFacade;
import main.java.facades.PostgresDatabaseFacade;
import main.java.services.interfaces.LandmarkService;

public class LandmarkDatabaseService implements LandmarkService {
	private DatabaseFacade databaseFacade = new PostgresDatabaseFacade();
	private final String databaseLogin = "landmarks";
	private final String databasePassword = "secret";
		
	/*
	 * 
	 * 
	 */
	@Override
	public List<Landmark> getResultByQuery(String query) throws LandmarkDataSourceException {
		// Получает список сущностей по результатам запроса
		List<Landmark> landmarks = new ArrayList<Landmark>();

		try {
			this.databaseFacade.connect(this.databaseLogin, this.databasePassword);
			Connection connection = this.databaseFacade.getConnection();
			if (connection != null) {
				Statement statement = connection.createStatement();
				// Передаём полученный запрос
				ResultSet resultSet = statement.executeQuery(query);
				// Записываем сущности по одному в получившийся список
				while (resultSet.next()) {
					Landmark landmark = new Landmark();
					landmark.setId(resultSet.getInt(landmark.FieldName_Id));
					landmark.setName(resultSet.getString(landmark.FieldName_Name));
					landmark.setIsHistorical(resultSet.getBoolean(landmark.FieldName_IsHistoric));
					landmark.setDescription(resultSet.getString(landmark.FieldName_Description));
					landmark.setHistory(resultSet.getString(landmark.FieldName_History));
					landmark.setRate(resultSet.getInt(landmark.FieldName_Rate));
					landmark.setCategory(resultSet.getString(landmark.FieldName_Category));
					landmark.setFamily(resultSet.getBoolean(landmark.FieldName_Family));
					landmarks.add(landmark);
				}

			}
		} catch (DatabaseException de) {
			throw new LandmarkDataSourceException(
					"Unable to get landmarks list from the gotten query: " + de.getMessage());
		} catch (SQLException sqle) {
			throw new LandmarkDataSourceException("Error while operating with the database statement");
		} finally {
			this.databaseFacade.disconnect();
		}

		return landmarks;
	}
}
