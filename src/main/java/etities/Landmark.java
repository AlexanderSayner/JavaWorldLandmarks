package main.java.etities;

public class Landmark {
	// Сущность представляет из себя объект в таблице landmark

	// SELECT MAX(landmark_id) FROM landmark; +1
	private int id;

	// Обязательное поле
	private String name;

	// Если true - место историческое
	private Boolean isHistorical = true;

	// Обязательное поле
	private String description;

	// История достопримечательность, можно опустить
	private String history = null;

	// Средняя оценка пользователей
	private int rate = 5;

	// Обязательное поле - категория места
	private String category;

	// Если true - подходит для семейного посещения
	private Boolean family = true;

	// Комментарии
	// ArrayList<Comment> = null;
	
	// -------------------------------------------------------------
	// Для удобства вставки имён полей в запросы
	// -------------------------------------------------------------

	public final String FieldName_Id = "landmark_id";

	public final String FieldName_Name = "landmark_name";

	public final String FieldName_IsHistoric = "landmark_isHistoric";

	public final String FieldName_Description = "landmark_description";

	public final String FieldName_History = "landmark_history";

	public final String FieldName_Rate = "landmark_rate";

	public final String FieldName_Category = "landmark_category";

	public final String FieldName_Family = "landmark_family";

	public final String FieldName_CommentId = "landmark_commentId";

	// -------------------------------------------------------------
	// Смысловые методы
	// -------------------------------------------------------------

	// Сразу готовая строка для вставки данных sql
	public String toSqlInsertString() {
		String str = "\'" + String.valueOf(this.id) + "\'," + "\'" + this.name + "\'," + "\'"
				+ String.valueOf(this.isHistorical) + "\'," + "\'" + this.description + "\'," + "\'" + this.history
				+ "\'," + "\'" + String.valueOf(this.rate) + "\'," + "\'" + this.category + "\'," + "\'"
				+ String.valueOf(this.family) + "\';";
		// нереализованное поле Comment
		return str;
	}

	// Правильно возращает значения полей в одной строке
	@Override
	public String toString() {
		return String.valueOf(this.id) + " | " + this.name + " | " + String.valueOf(this.isHistorical) + " | "
				+ this.description + " | " + this.history + " | " + String.valueOf(this.rate) + " | " + this.category
				+ " | " + String.valueOf(this.family);
	}

	// -------------------------------------------------------------
	// getterr'ы & setter'ы
	// -------------------------------------------------------------

	// id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id > 0) {
			this.id = id;
		}
	}

	// name

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	// isHistorical

	public Boolean getIsHistorical() {
		return isHistorical;
	}

	public void setIsHistorical(Boolean isHistorical) {
		this.isHistorical = isHistorical;
	}

	// description

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description != null) {
			this.description = description;
		}
	}

	// history

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	// rate

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	// category

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		if (category != null) {
			this.category = category;
		}
	}

	// family

	public Boolean getFamily() {
		return family;
	}

	public void setFamily(Boolean family) {
		this.family = family;
	}
}
