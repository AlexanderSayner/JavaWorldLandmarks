package main.java.services.interfaces;

import java.util.List;

import main.java.etities.Landmark;
import main.java.exceptions.LandmarkDataSourceException;

public interface LandmarkService {
	List<Landmark> getResultByQuery(String query) throws LandmarkDataSourceException;
}
