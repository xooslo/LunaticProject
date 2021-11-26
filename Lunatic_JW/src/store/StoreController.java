package store;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StoreController {

	// stage3버튼
	@FXML
	private Button stageBtn3;

	// story2버튼
	@FXML
	private Button story2Btn;
	
	@FXML
	private Button potion;

	// StageScene3 이동하는 화면전환코드
	public void getstageScene3() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/stage/StageScene3.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) stageBtn3.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("stage3");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// StageScene3 이동하는 화면전환코드
	public void getstoryScene2() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/story/StoryScene2.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) story2Btn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("story2");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getpotion() {
		
	}

}
