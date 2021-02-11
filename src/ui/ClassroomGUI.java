package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Classroom;
import model.Student;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;


public class ClassroomGUI {

	  @FXML
	    private TextField txtUserName;

	   @FXML
	   private PasswordField txtPassword;
	   
	   @FXML
	    private TextField registerNameTxt;

	    @FXML
	    private PasswordField registerPasswordTxt;

	    @FXML
	    private TextField profileTxT;

	    @FXML
	    private DatePicker dateTxT;

	    @FXML
	    private ChoiceBox<?> browserBox;
	    
	    @FXML
	    private Label userNameLabel;

	    @FXML
	    private ImageView pfpView;
	    
	    @FXML
	    private TableView<Student> studentsLists;

	    @FXML
	    private TableColumn<Student, String> userNameTable;

	    @FXML
	    private TableColumn<Student, String> genderTable;

	    @FXML
	    private TableColumn<Student, String> careerTable;

	    @FXML
	    private TableColumn<Student, String> birthdayTable;

	    @FXML
	    private TableColumn<Student, String> browserTable;
	    
	    @FXML
	    private Pane mainPane;
	    
	    @FXML
	    private BorderPane mainBorderPanel;

	    
	    private Classroom classroom; 
	    
	    public ClassroomGUI(Classroom cr) {
	    	
	    	classroom = cr;
	    	
	    }
	    /*
	    public void initialize(){
	    	
	    }*/
	    private void initializeStundentsList(){
	    	ObservableList<Student> observableList;
	    	observableList = FXCollections.observableArrayList(classroom.getStudents());
	    	
	    	studentsLists.setItems(observableList);
	    	userNameTable.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
	    	genderTable.setCellValueFactory(new PropertyValueFactory<Student,String>("Genre"));
	    	careerTable.setCellValueFactory(new PropertyValueFactory<Student,String>("Career"));
	    	birthdayTable.setCellValueFactory(new PropertyValueFactory<Student,String>("Birthday"));
	    	browserTable.setCellValueFactory(new PropertyValueFactory<Student,String>("Browser"));
	    }
	    
	    @FXML
	    void loadRegister(ActionEvent event) throws IOException {
	    FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("Register.fxml"));
	    	
	    	fxmlLoader3.setController(this);
	    	Parent addStudentPane = fxmlLoader3.load();
	    	mainBorderPanel.getChildren().clear();
	    	mainBorderPanel.setCenter(addStudentPane);
	    	
	    }
	    @FXML
	    void loadStudentsList(ActionEvent event) throws IOException{
	    
	    	
	    	
	    	
	    }
}
