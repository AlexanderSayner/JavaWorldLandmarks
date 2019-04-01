package main.java.services.interfaces;

import java.util.List;

import main.java.etities.Landmark;

public interface LandmarkQueriesService {
	public List<Landmark> getAllLandmarks();

	public List<Landmark> getLandmarksBySearch(String codeword);
}
