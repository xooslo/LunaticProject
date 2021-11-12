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
	
	
	//설정창으로 이동하는 화면전환코드
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
	//로그인창으로 이동하는 화면전환코드
	public void getLoginScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/join/LoginScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("濡쒓렇�씤");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	//회원가입창으로 이동하는 화면전환코드
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
	//메인창으로 이동하는 화면전환코드
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
	//how to창 이동하는 화면전환코드
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
	//StageScene 이동하는 화면전환코드
	public void getskip1Scene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/stage/StageScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) skip1Btn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("skip1");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	//StoryScene 이동하는 화면전환코드
	public void getstoryScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/story/StoryScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) storyBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("story");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
}
