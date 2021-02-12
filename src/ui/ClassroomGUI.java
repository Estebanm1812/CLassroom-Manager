package ui;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Career;
import model.Classroom;
import model.Student;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.stage.FileChooser.ExtensionFilter;

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
	    private ComboBox<String> browserBox;
	    
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
	    
	    @FXML
	    private CheckBox softwareCheckBox;

	    @FXML
	    private CheckBox telematicCheckBox;

	    @FXML
	    private CheckBox industrialCheckBox;

	    @FXML
	    private RadioButton maleButton;

	    @FXML
	    private ToggleGroup genderGloup;

	    @FXML
	    private RadioButton femaleButton;

	    @FXML
	    private RadioButton otherButton;
	    
	    private Classroom classroom;
	    
	    Career [] career;
	    
	    public ClassroomGUI(Classroom cr) {
	    	
	    	classroom = cr;
	    	career = new Career[2];
	    }
	    /*
	    public void initialize(){
	    	
	    }*/
	    @SuppressWarnings("unused")
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
	    	
	    
	    	maleButton.setToggleGroup(genderGloup);
	    	

	    	femaleButton.setToggleGroup(genderGloup);
	    	
	  
	    	otherButton.setToggleGroup(genderGloup);
	    	
	    	browserBox.getItems().addAll("Chrom","Opera","Microsoft Edge", "Safari");
	    	
	    	
	    	
	    }
	    @FXML
	    void loadStudentsList(ActionEvent event) throws IOException{
	    
	    	String userName = txtUserName.getText();
	    	String passWord = txtPassword.getText();
	    	boolean canContiue = Classroom.findStudent(userName,passWord);
	    	
	    	
	    			if(canContiue == true) {
	    				FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("StudentsList.fxml"));
	    				fxmlLoader4.setController(this);
	    				Parent addListPanel = fxmlLoader4.load();
	    				mainBorderPanel.getChildren().clear();
	    				mainBorderPanel.setCenter(addListPanel);
	    			}else {
	    			
	    				Alert alert = new Alert(AlertType.INFORMATION);
	    				alert.setTitle("Information Dialog");
	    				alert.setHeaderText(null);
	    				alert.setContentText("The information is wrong or the Student doesnt Exist, please verified");
	    				alert.showAndWait();
	    			}	
	    	}
	    @FXML
	    void loadPfP(ActionEvent event)throws IOException {
	    	
	    	FileChooser fileChooser = new FileChooser();
	    	fileChooser.getExtensionFilters().addAll( 
	    			 new FileChooser.ExtensionFilter("All Images", "*.*"),
	                 new FileChooser.ExtensionFilter("JPG", "*.jpg"),
	                 new FileChooser.ExtensionFilter("PNG", "*.png")
	         );
	    					
			File selectedFile = fileChooser.showOpenDialog(null);
	        if(selectedFile != null) {
	        
	        profileTxT.setText(selectedFile.getPath());
	        
	        }
	        
	    }
	    @FXML
	    void returnToLogin(ActionEvent event) throws IOException {
	    FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("Login.fxml"));
		    	
		    	fxmlLoader4.setController(this);
		    	Parent loginPanel = fxmlLoader4.load();
		    	mainBorderPanel.getChildren().clear();
		    	mainBorderPanel.setCenter(loginPanel);
		    		
	    }
	    
	    @FXML
	    void createStudent(ActionEvent event)throws IOException {
	    	
	    String userName = registerNameTxt.getText();
	    String password = registerPasswordTxt.getText();
	    String pfp = profileTxT.getText();
	    String genre = "Other";
	    if(maleButton.isSelected()) {
	    	
	    	genre = "Male";
	    	}else if(femaleButton.isSelected()){
	    		
	    	genre = "Female";	
	    	}else {
	    	genre = "Other";	
	    		
	    	}
	    if(softwareCheckBox.isSelected()) {
	    	
	    	boolean out = false;
	    	int pos = 0;
	    	for(int i=0; i < career.length && out ==false;i++) {
	    	
	    	if(career[i]==null) {
	    			out = true;
	    			pos = i;
	    			
	    			}
	    		}
	    	career[pos] = Career.SOFTWAREENGINEERING;
	    	}else if(telematicCheckBox.isSelected()) {
	    		boolean out = false;
		    	int pos = 0;
		    	for(int i=0; i < career.length && out ==false;i++) {
		    	
		    	if(career[i]==null) {
		    			out = true;
		    			pos = i;
		    			
		    			}
		    		}
		    	career[pos] = Career.TELEMATICENGINEERING;
	    		
	    	}else if(industrialCheckBox.isSelected()) {
	    		boolean out = false;
		    	int pos = 0;
		    	for(int i=0; i < career.length && out ==false;i++) {
		    	
		    	if(career[i]==null) {
		    			out = true;
		    			pos = i;
		    			
		    			}
		    		}
		    	career[pos] = Career.INDUSTRIALINGEERING;
	    	}
	    	String date = dateTxT.getValue().toString();
	    }
	    
	    
	    
}
