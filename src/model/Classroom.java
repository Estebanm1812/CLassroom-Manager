package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

	private static List<Student> students;
	
	public Classroom() {
		students = new ArrayList<Student>();
	}
	public static void addStudent(String userName, String password, Career [] career,String genre, String birthday, String browser, String link ) {
		
		students.add(new Student(userName, password, genre, browser, career, birthday, link));
		
	}
	public List<Student> getStudents(){
		
		return students;
		
	}
	public static boolean findStudent(String userName, String password) {
		
		boolean found = false;
		
		boolean nameFound = false;
		
		boolean passwordFound = false;
		
		for(int i=0; i <= students.size();i++) {
		
			if((students.get(i).getName()).equals(userName) == (true)) {
				nameFound = true;
			}else {
				nameFound = false;
			}
			
			if ((students.get(i).getPassword()).equals(password) == (true)){
				passwordFound = true;
			}else {
				passwordFound = false;
				
			}
		}
		if((nameFound == true) && (passwordFound == true)) {
			found = true;
		}else {
			found = false;
		}
		
		return found;
	}
}
