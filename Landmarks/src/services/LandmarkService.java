package services;

import java.util.List;

import etities.Landmark;
import exceptions.LandmarkDataSourceException;

public interface LandmarkService {
	List<Landmark> getAllLandmarks() throws LandmarkDataSourceException;
    Landmark getLandmarkByID(Integer id) throws LandmarkDataSourceException;
}
