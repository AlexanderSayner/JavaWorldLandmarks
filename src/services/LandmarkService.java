package services;

import java.util.List;

import etities.Landmark;
import exceptions.LandmarkDataSourceException;

public interface LandmarkService {
	List<Landmark> getAllPersons() throws LandmarkDataSourceException;
    Landmark getLandmarkByID(Integer id) throws LandmarkDataSourceException;
}
