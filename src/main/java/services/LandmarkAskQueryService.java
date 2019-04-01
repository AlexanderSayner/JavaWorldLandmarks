package main.java.services;

import main.java.etities.*;
import main.java.exceptions.LandmarkDataSourceException;
import main.java.services.interfaces.LandmarkQueriesService;

import java.util.List;

public class LandmarkAskQueryService implements LandmarkQueriesService {
	// Отфильтровать данный символ
	private final String semicolon = ";";
	// Поиск по части слова
	private final String searchQuery = "SELECT * FROM landmark WHERE landmark_name LIKE \'%";
	// Верю, что база не такая большая
	private final String selectAllQuery = "SELECT * FROM landmark;";

	public List<Landmark> getAllLandmarks() {
		LandmarkDatabaseService landmarkDatabaseService = new LandmarkDatabaseService();
		List<Landmark> landmarks = null;
		try {
			landmarks = landmarkDatabaseService.getResultByQuery(this.selectAllQuery);
		} catch (LandmarkDataSourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return landmarks;
	}

	public List<Landmark> getLandmarksBySearch(String codeword) {
		// Составляет запрос по поиску фрагмента слова
		if (codeword.indexOf(this.semicolon) == -1) {
			String query = this.searchQuery + codeword + "%\';";
			LandmarkDatabaseService landmarkDatabaseService = new LandmarkDatabaseService();
			List<Landmark> searchResult = null;
			try {
				searchResult = landmarkDatabaseService.getResultByQuery(query);
			} catch (LandmarkDataSourceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			return searchResult;
		} else {
			return null;
		}
	}
}
