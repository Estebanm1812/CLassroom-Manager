package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Classroom;

public class Main extends Application{
	
	private Classroom classRoom;
	private ClassroomGUI classroomGUI;
	
	public Main(){
		classRoom = new Classroom();
		classroomGUI = new ClassroomGUI(classRoom);
		
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Login.fxml"));
		
		fxmlLoader2.setController(classroomGUI);
		
	
		
		Parent root2 = fxmlLoader2.load();
		
		
		Scene scene2 = new Scene(root2);
		
		primaryStage.setTitle("Classroom Manager");
		primaryStage.setScene(scene2);
		primaryStage.show();
		
		
		
	}

}
