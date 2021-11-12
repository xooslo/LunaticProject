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
	@FXML
	private Button mainBtn;
	@FXML
	private Button howplayBtn;
	@FXML
	private Button storyBtn;
	@FXML
	private Button skip1Btn;
	
	public void getSettingScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/work/SettingScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) setBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("�꽕�젙");
	         
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
	         primaryStage.setTitle("濡쒓렇�씤");
	         
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
	         primaryStage.setTitle("�쉶�썝媛��엯");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	public void getMainScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/work/MainScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) mainBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("LUNATIC");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	public void getHowPlayScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/work/HowPlayScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) howplayBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("How To play");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	public void getskip1Scene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/work/StageScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) skip1Btn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("skip1");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	public void getstoryScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/work/StoryScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) storyBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("story");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
}
