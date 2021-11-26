package story;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StoryController {

	// 엔딩버튼
	@FXML
	private Button endingBtn;

	// 루트1버튼
	@FXML
	private Button root1Btn;

	// stage버튼
	@FXML
	private Button stageBtn;

	// stage5버튼
	@FXML
	private Button stageBtn5;
	
//	주인공 이미지뷰
	@FXML
	private ImageView charactor;

	// Root1로 이동하는 화면전환 코드
	public void getroot1() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/story/Root1.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) root1Btn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("루트1");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Ending로 이동하는 화면전환 코드
	public void getEnding() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/story/Ending.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) endingBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("ending");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// StageScene로 이동하는 화면전환 코드
	public void getstageScene() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/stage/StageScene.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) stageBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("stage");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// stageScene5으로 이동하는 화면전환 코드
	public void getstageScene5() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/stage/StageScene5.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) stageBtn5.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("stage5");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
