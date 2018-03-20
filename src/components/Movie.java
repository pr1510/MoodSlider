package components;

public class Movie {

	private String name;
	private String level;
	private String mood;
	private String path;
	private String id;
	private Boolean state;
	private String description;
	
	public Movie()
	{
		state=true;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public String getMood() {
		return mood;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
	public void setId(String id)
	{
		this.id=id;
	}
	
	public String getId()
	{
		return id;
	}
	
	public boolean getState()
	{
		return state;
	}
	
	public void setState(Boolean state)
	{
		this.state = state;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getLevel()
	{
		return level;
	}
}
