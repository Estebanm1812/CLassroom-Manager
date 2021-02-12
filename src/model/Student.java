package model;

public class Student {

	private String userName;
	
	private String password;
	
	private String genre;
	
	private String browser;
	
	private Career [] career;
	
	private String birthDay;
	
	private String pictureLink;
	
	public Student(String userName, String password, String genre, String browser, Career[] career, String birthDay, String pictureLink) {
		
		this.userName = userName;
		this.password = password;
		this.genre = genre;
		this.browser = browser;
		this.career[2] = career[2];
		this.birthDay = birthDay;
		this.pictureLink = pictureLink;
		
	}
	public String getName() {
		return userName;
	}
	public void setName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	}
