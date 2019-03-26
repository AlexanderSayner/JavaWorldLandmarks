package etities;

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
	
	
	//-------------------------------------------------------------
	//  Смысловые методы
	//-------------------------------------------------------------
	
	// Сразу готовая строка для вставки данных sql
	public String toSqlInsertString() {
		String str = 
				"\'" + String.valueOf(this.id) + "\'," +
				"\'" + this.name + "\'," +
				"\'" + String.valueOf(this.isHistorical) + "\'," +
				"\'" + this.description + "\'," +
				"\'" + this.history + "\'," +
				"\'" + String.valueOf(this.rate) + "\'," + 
				"\'" + this.category + "\'," + 
				"\'" + String.valueOf(this.family) + "\';";
				// нереализованное поле Comment
		return str;
	}
	
	// Правильно возращает значения полей в одной строке
	@Override
    public String toString() {
		return String.valueOf(this.id) + " | " +
		this.name + " | " +
		String.valueOf(this.isHistorical) + " | " +
		this.description + " | " +
		this.history + " | " +
		String.valueOf(this.rate) + " | " + 
		this.category + " | " +
		String.valueOf(this.family);
	}	
	
	
	//-------------------------------------------------------------
	// getterr'ы & setter'ы
	//-------------------------------------------------------------
	
	// id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id > 0) {
			this.id = id;
		}
	}

	// name
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null) {
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
		if(description != null) {
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
		if(category != null) {
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
	
	
	//-------------------------------------------------------------
	// Для удобства вставки имён полей в запросы
	//-------------------------------------------------------------
	
	public String getFieldName_Id() {
		return "landmark_id";
	}
	
	public String getFieldName_Name() {
		return "landmark_name";
	}
	
	public String getFieldName_IsHistoric() {
		return "landmark_isHistoric";
	}
	
	public String getFieldName_Description() {
		return "landmark_description";
	}
	
	public String getFieldName_History() {
		return "landmark_history";
	}
	
	public String getFieldName_Rate() {
		return "landmark_rate";
	}
	
	public String getFieldName_Category() {
		return "landmark_category";
	}
	
	public String getFieldName_Family() {
		return "landmark_family";
	}
	 
	public String getFieldName_CommentId() {
		return "landmark_commentId";
	}
	
}
