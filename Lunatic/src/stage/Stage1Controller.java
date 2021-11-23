package stage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Stage1Controller {

	// 메인으로 돌아가는 버튼
	@FXML
	private Button mainBtn;
	// stage2버튼
	@FXML
	private Button stageBtn2;
	
//	ArrayList<String> input = new ArrayList<>();
//	Player player = new Player();

	
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
}
