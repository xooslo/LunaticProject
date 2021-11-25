package store;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
		
//		String sql = "SELECT `nick` FROM `log_info`";
		// 데이터베이스에 저장되어 있는 포션의 최대값보다 +1 해서 넣기 시도
		String insertPotion = "INSERT INTO `items` (`potion`) VALUES ";
		
		try {
			pstmt = con.prepareStatement(insertPotion);
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private Button useItemBtn;

//	public void useItems() {
//		JDBCUtil db = new JDBCUtil();
//		Connection con = db.getConnection();
//		PreparedStatement psmmt = null;
//		
//		String useSQL = "DELETE FROM `items` WHERE ";
//		
//	}
	
	@FXML
	private ListView<String> list;
	private ObservableList<String> items;
	
	// 데이터 베이스에 있는 아이템 리스트뷰에 표시하는 코드 넣을 곳
	// 문제점 = 아이템 테이블에 있는 모든 아이템을 가져오기 때문에 유저 구분이 안됨
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		
		String getItemsSQL = "SELECT `potions`, `sword`, `costume` FROM `items`";
		
		try {
			pstmt = con.prepareStatement(getItemsSQL);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				System.out.println("---------------333");
				result.add(rs.getString("potions"));
				result.add(rs.getString("sword"));
				result.add(rs.getString("costume"));
			}
			
			items = FXCollections.observableArrayList(result);
			list.setItems(items);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
