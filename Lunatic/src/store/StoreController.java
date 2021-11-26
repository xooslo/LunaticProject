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
	
	String loginfo_id = null;
	String loginfo_nick = null;

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
		//포션은 사지는데 다른 계정에도 똑같이 들어감 
		//pstmt.executequery(); 를 pstmt.executeUpdate(); 로 바꿈
		String insertPotion = "INSERT INTO `items` (`item`, `player_id`) VALUES ('item','" + loginfo_id + "') ";
		
		try {
			pstmt = con.prepareStatement(insertPotion);
			pstmt.executeUpdate();
			
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
		
		String getItemsSQL = "SELECT `item` FROM `items`";
		
		try {
			pstmt = con.prepareStatement(getItemsSQL);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				System.out.println("---------------333");
				result.add(rs.getString("item"));
			}
			
			items = FXCollections.observableArrayList(result);
			list.setItems(items);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//  로그인포 
  public void getLogInfo() {
      //DB
      JDBCUtil db = new JDBCUtil();
      Connection con = db.getConnection();

      PreparedStatement pstmt = null;

      String logGetSql = "SELECT * FROM log_info";

      ResultSet rs = null;

      try {

          //log get
          pstmt  = con.prepareStatement(logGetSql);
          rs = pstmt.executeQuery();

          while (rs.next()) {
              String log_id = rs.getString("id");
              String log_nick = rs.getString("nick");
              
              System.out.println(log_id + ", " + log_nick);
          }
          
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("삽입 실패!");
      }
  }
}
