package stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import util.AppUtill;
import util.JDBCUtil;

public class Stage1Controller {

	// 메인으로 돌아가는 버튼
	@FXML
	private Button mainBtn;
	// stage2버튼
	@FXML
	private Button stageBtn2;
	
//	몬스터 버튼
	@FXML
	private Button monter1;
	@FXML
	private Button monter2;
	@FXML
	private Button monter3;
	@FXML
	private Button monter4;
	@FXML
	private Button monter5;
	
//	몬스터 라벨
	@FXML
	private Label monterLabel1;
	@FXML
	private Label monterLabel2;
	@FXML
	private Label monterLabel3;
	@FXML
	private Label monterLabel4;
	@FXML
	private Label monterLabel5;
	
	//로그인포 아이디
	String player_id = null;
	
	
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
	
	public void addCoin(int value) {
		getLogInfo();
		
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String coinSql = "UPDATE `save` SET `coin`=" + value + " WHERE player_id='" + player_id + "'";
		
		
	
		try { 
			pstmt = con.prepareStatement(logInfoSql);
			rs = pstmt.executeQuery();
			
			String player_id = rs.getString("id");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			AppUtill.alert("데이터 삽입에 실패했습니다.", null);
		}
	}
	
	
	public void getLogInfo() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String logInfoSql = "select id from log_info";
		
		
	
		try { 
			pstmt = con.prepareStatement(logInfoSql);
			rs = pstmt.executeQuery();
			
			player_id = rs.getString("id");
		} catch (Exception e) {
			e.printStackTrace();
			AppUtill.alert("데이터 삽입에 실패했습니다.", null);
		}
	}
	
	public void monterBtnHandler1() {
		System.out.println("monter");
		//포인트+ 표시하기
		monterLabel1.setText("+10");
		//버튼 오파시티 0
		monter1.setOpacity(0);
		//포인트 올리기
		int value = 10;
		addCoin(value);
		
		
	}
	
	public void monterBtnHandler2() {
		System.out.println("monter");
		//포인트+ 표시하기
		monterLabel2.setText("+10");
		//버튼 오파시티 0
		monter2.setOpacity(0);
		
		//포인트 올리기
		
		
	}
	public void monterBtnHandler3() {
		System.out.println("monter");
		//포인트+ 표시하기
		monterLabel3.setText("+10");
		//버튼 오파시티 0
		monter3.setOpacity(0);
		//포인트 올리기
	}
	public void monterBtnHandler4() {
		System.out.println("monter");
		//포인트+ 표시하기
		monterLabel4.setText("+10");
		//버튼 오파시티 0
		monter4.setOpacity(0);
		//포인트 올리기
	}
	public void monterBtnHandler5() {
		System.out.println("monter");
		//포인트+ 표시하기
		monterLabel5.setText("+10");
		//버튼 오파시티 0
		monter5.setOpacity(0);
		//포인트 올리기
	}
}
