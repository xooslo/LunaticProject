package work;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

	@FXML
	private Button setBtn;
	@FXML
	private Button loginBtn;
	@FXML
	private Button joinBtn;
	
	public void getSettingScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/work/SettingScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) setBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("설정");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	public void getLoginScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/work/LoginScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("로그인");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	public void getJoinScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/join/JoinScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) joinBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("회원가입");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
}
