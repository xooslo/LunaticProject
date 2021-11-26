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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import util.AppUtill;
import util.JDBCUtil;

public class StageController {

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

//	주인공 이미지뷰
	@FXML
	private ImageView charactor;
	
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
	
	//지금 로긴한 사람 로그인포 정보
	String log_id = null;
	String log_nick = null;
		
//	로그인포 
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
				log_id = rs.getString("id");	
				log_nick = rs.getString("nick");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삽입 실패!");
		}
		
		System.out.println(log_id + ", " + log_nick);
	}
		
	public void monterBtnHandler1() {
//		System.out.println("monter");
		
		int value = 10;
		//포인트+ 표시하기
		monterLabel1.setText("+" + value);
		//버튼 오파시티 0
		monter1.setOpacity(0);
		//포인트 올리기
		addCoin(value);
	}
	public void monterBtnHandler2() {
//		System.out.println("monter");
		
		int value = 10;
		//포인트+ 표시하기
		monterLabel2.setText("+" + value);
		//버튼 오파시티 0
		monter2.setOpacity(0);
		//포인트 올리기
		addCoin(value);
	}
	public void monterBtnHandler3() {
//		System.out.println("monter");
		
		int value = 15;
		//포인트+ 표시하기
		monterLabel3.setText("+" + value);
		//버튼 오파시티 0
		monter3.setOpacity(0);
		//포인트 올리기
		addCoin(value);
	}
	public void monterBtnHandler4() {
		System.out.println("monter");
		
		int value = 20;
		//포인트+ 표시하기
		monterLabel4.setText("+" + value);
		//버튼 오파시티 0
		monter4.setOpacity(0);
		//포인트 올리기
		addCoin(value);
	}
	public void monterBtnHandler5() {
//		System.out.println("monter");
		
		int value = 20;
		//포인트+ 표시하기
		monterLabel5.setText("+" + value);
		//버튼 오파시티 0
		monter5.setOpacity(0);
		//포인트 올리기
		addCoin(value);
	}
	
	
	// 코인 업데이트
	public void addCoin(int value) {
		getLogInfo();
		
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		
		PreparedStatement pstmt = null;
		String getCoin = "select coin from save where player_id='" + log_id + "'";
		
		ResultSet rs = null;
	
		try { 
			pstmt  = con.prepareStatement(getCoin);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
//				System.out.println(rs.getInt("coin"));
				
				int nowCoinValue = rs.getInt("coin");
				value = nowCoinValue + value;
				
				String sql = "UPDATE `save` SET `coin`=" + value + " WHERE player_id='" + log_id + "'";
				
				try {
					pstmt  = con.prepareStatement(sql);
					pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					AppUtill.alert("데이터 삽입에 실패했습니다.", null);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			AppUtill.alert("데이터 삽입에 실패했습니다.", null);
		}
	}
	
	
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
	

}
