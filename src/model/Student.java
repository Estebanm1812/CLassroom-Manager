package model;

public class Student {

	private String userName;
	
	private String password;
	
	private String genre;
	
	private String browser;
	
	private String career;
	
	private String birthDay;
	
	public Student(String userName, String password, String genre, String browser, String career, String birthDay) {
		
		this.userName = userName;
		this.password = password;
		this.genre = genre;
		this.browser = browser;
		this.career = career;
		this.birthDay = birthDay;
		
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
