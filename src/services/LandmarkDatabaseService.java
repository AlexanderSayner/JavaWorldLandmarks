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
	public List<Landmark> getAllPersons() throws LandmarkDataSourceException {
		// Возращает все позиции из базы
		List<Landmark> landmarks = new ArrayList<Landmark>();
		
		try {
            this.databaseFacade.connect(this.databaseLogin, this.databasePassword);
            Connection connection = this.databaseFacade.getConnection();
            if(connection != null) {
                Statement statement = connection.createStatement();
                String sql = "select * from " + "landmark";
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()) {
                    Landmark landmark = new Landmark();
                    landmark.setId(resultSet.getInt(landmark.getFieldName_Id()));
                    landmark.setName(resultSet.getString(landmark.getFieldName_Name()));
                    landmark.setIsHistorical(resultSet.getBoolean(landmark.getFieldName_IsHistoric()));
                    landmark.setDescription(resultSet.getString(landmark.getFieldName_Description()));
                    landmark.setHistory(resultSet.getString(landmark.getFieldName_History()));
                    landmark.setRate(resultSet.getInt(landmark.getFieldName_Rate()));
                    landmark.setCategory(resultSet.getString(landmark.getFieldName_Category()));
                    landmark.setFamily(resultSet.getBoolean(landmark.getFieldName_Family()));
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
