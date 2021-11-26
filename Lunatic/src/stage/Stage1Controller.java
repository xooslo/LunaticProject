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

public class Stage1Controller {

	// 메인으로 돌아가는 버튼
	@FXML
	private Button mainBtn;
	// stage2버튼
	@FXML
	private Button stageBtn2;
	
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
	
	
//	ArrayList<String> input = new ArrayList<>();
//	Player player = new Player();

	
	
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
		System.out.println("dPpPP");
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
}
