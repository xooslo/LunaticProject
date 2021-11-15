package stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class StageController implements Initializable {

	// 설정버튼
	@FXML
	private Button setBtn;

	// 메인으로 돌아가는 버튼
	@FXML
	private Button mainBtn1;
	@FXML
	private Button mainBtn;

	// story1버튼
	@FXML
	private Button story1Btn;

	// stage버튼
	@FXML
	private Button stageBtn;

	// stage2버튼
	@FXML
	private Button stageBtn2;

	// stage4버튼
	@FXML
	private Button stageBtn4;

	// 엔딩버튼
	@FXML
	private Button endingBtn;

	// 루트1버튼
	@FXML
	private Button root1Btn;
	
	// 루트1버튼
	@FXML
	private Button root2Btn;

	// 상점 버튼1
	@FXML
	private Button store1Btn;

	// 상점 버튼2
	@FXML
	private Button store2Btn;
	
	@FXML
	private ImageView imgPlayer;

	// 설정창으로 이동하는 화면전환코드
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

	// 메인창으로 이동하는 화면전환코드
	public void getMainScene() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/work/MainScene_afterLogin.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) mainBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("LUNATIC");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 메인창으로 이동하는 화면전환코드 (png 이미지 없는 버전 분리함)
		public void getMainSceneNone() {
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/work/MainScene_afterLogin.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) mainBtn1.getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.setTitle("LUNATIC");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	// StageScene 이동하는 화면전환코드
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

	// StageScene2 이동하는 화면전환코드
	public void getstageScene2() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/stage/StageScene2.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) stageBtn2.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("stage2");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// StageScene4 이동하는 화면전환코드
	public void getstageScene4() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/stage/StageScene4.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) stageBtn4.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("stage4");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// StoryScene 이동하는 화면전환코드
	public void getstoryScene() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/story/StoryScene.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) story1Btn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("story");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	
	//루트2로 가는 화면전환 코드
	public void getroot2() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/story/Root2.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) root2Btn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("root2");
			
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

	// 첫번째 상점 화면전환 코드
	public void getstore1() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/store/StoreScene.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) store1Btn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("store1");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 두번째 상점 화면전환 코드
	public void getstore2() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/store/StoreScene2.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) store2Btn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("store2");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imgPlayer.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				handleImgPlayer(event);
			}
		});
	}
		
	public void handleImgPlayer(KeyEvent event) {
		KeyCode keyCode = event.getCode();
		System.out.println(keyCode);
		
		if (KeyCode.UP.equals(keyCode)) {
			imgPlayer.setY(imgPlayer.getY() - 10);
		} else if (KeyCode.DOWN.equals(keyCode)) {
			imgPlayer.setY(imgPlayer.getY() + 10);
		} else if (KeyCode.LEFT.equals(keyCode)) {
			imgPlayer.setX(imgPlayer.getX() - 10);
		} else if (KeyCode.RIGHT.equals(keyCode)) {
			imgPlayer.setX(imgPlayer.getX() + 10);
		}
	}
	

}
