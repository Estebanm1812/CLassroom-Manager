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
		this.career = career;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	public String getBirthday() {
		return birthDay;
	}
	public void setBirthday(String birthday) {
		birthday = birthDay;
	}
	public String getPictureLink() {
		return pictureLink;
	}
	public void getPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}
	public String getCareer() {
		String careers = "";
		for(int i=0; i < career.length;i++) {
		
			if(career[i]!=null) {
			careers = career[i] + ", ";
			}	
		}
		return careers;
	}
	}
