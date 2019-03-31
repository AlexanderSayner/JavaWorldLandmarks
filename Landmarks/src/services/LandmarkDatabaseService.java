package services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import etities.Landmark;
import exceptions.*;
import facades.DatabaseFacade;
import facades.PostgresDatabaseFacade;

public class LandmarkDatabaseService implements LandmarkService {
	private DatabaseFacade databaseFacade = new PostgresDatabaseFacade();
	private final String databaseLogin = "landmarks";
	private final String databasePassword = "secret";

	@Override
	public List<Landmark> getAllLandmarks() throws LandmarkDataSourceException {
		// Возравщает все позиции из базы
		List<Landmark> landmarks = new ArrayList<Landmark>();

		try {
			this.databaseFacade.connect(this.databaseLogin, this.databasePassword);
			Connection connection = this.databaseFacade.getConnection();
			if (connection != null) {
				Statement statement = connection.createStatement();
				String sql = "select * from " + "landmark";
				ResultSet resultSet = statement.executeQuery(sql);
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
			throw new LandmarkDataSourceException("Unable to get person list from the database: " + de.getMessage());
		} catch (SQLException sqle) {
			throw new LandmarkDataSourceException("Error while operating with the database statement");
		} finally {
			this.databaseFacade.disconnect();
		}

		return landmarks;
	}

	@Override
	public Landmark getLandmarkByID(Integer id) throws LandmarkDataSourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
