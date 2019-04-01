package main.java.services;

import java.util.List;

import main.java.etities.Landmark;
import main.java.exceptions.LandmarkDataSourceException;

public interface LandmarkService {
	List<Landmark> getAllLandmarks() throws LandmarkDataSourceException;
    Landmark getLandmarkByID(Integer id) throws LandmarkDataSourceException;
}
