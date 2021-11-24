package store;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.JDBCUtil;

public class StoreController implements Initializable{

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
	public void getPotion() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT `nick` FROM `log_info`";
		// 데이터베이스에 저장되어 있는 포션의 최대값보다 +1 해서 넣기 시도
//		String insertPotion = "INSERT INTO `items` (`potion`) VALUES ";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 누가 포션을 샀는지  데이터베이스에 저장하기 위해서 로그인 인포에서 아이디 가져옴
			String userId = rs.getString("id");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터 베이스에 있는 아이템 리스트뷰에 표시하는 코드 넣을 곳
	// 문제점 = 데이터 베이스에 있는 아이템(포션, 칼, 코스튬) 등을 어떤 식으로 표시할지 감이 안옴
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
