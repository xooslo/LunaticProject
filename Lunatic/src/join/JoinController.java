package join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.AppUtill;
import util.JDBCUtil;

public class JoinController {

	@FXML
	private Button mainBtn;
	
	public void getMainScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/work/MainScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) mainBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("LUNATIC");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	@FXML
	private TextField nick;
	@FXML
	private TextField id;
	@FXML
	private PasswordField pw;
	@FXML
	private Button joinBtn;
	
	@FXML
	private void initialize() {
//		System.out.println("initialize");
//		
//		//log_info 삭제 
//		JDBCUtil db = new JDBCUtil();
//		Connection con = db.getConnection();
//		
//		PreparedStatement pstmt = null;
//		String logOutSql = "delete from log_info";
//
//		try {
//			pstmt  = con.prepareStatement(logOutSql);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("실패!");
//		} 
	}
	
	public void addPlayer() {
		String nickName = nick.getText();
		String name = id.getText();
		String password = pw.getText();
		
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		
		if (name.isEmpty() || nickName.isEmpty() || password.isEmpty()) {
			AppUtill.alert("모든 란을 정확히 채워주세요.", null);
		}
		
		if(name.equals(" ") || nickName.equals(" ") || password.equals(" ")) {
			AppUtill.alert("모든 란에 공백이 없게 다시 입력해주세요.", null);
			
		}
	
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO player VALUES (?,?,?)";
//		String sql = "INSERT INTO `player`(`id`, `nick`, `password`) VALUES ('"+ name +"', '"+ nickName +"', '"+ password +"');";
	
		try { 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, nickName);
			pstmt.setString(3, password);
			pstmt.executeUpdate();
			AppUtill.alert("로그인 후 게임을 이용하실 수 있습니다.", "가입 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			AppUtill.alert("데이터 삽입에 실패했습니다.", null);
		}
	}
	
	// 로그인에서 사용할 메소드
		public void getScene(String url, Button btn) {
			try {
				Parent main = FXMLLoader.load(getClass().getResource(url));
				Scene scene = new Scene(main);
				Stage primaryStage = (Stage) btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	@FXML
	private TextField loginId;
	@FXML
	private PasswordField loginPw;
	@FXML
	private Button loginBtn;
	
	// 유저 로그인
	public void loginPlayer() {
		String name = loginId.getText();
		String password = loginPw.getText();
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		int cnt = 0;
			
		if (name.isEmpty() || password.isEmpty()) {
			AppUtill.alert("아이디와 비밀번호에 빈칸이 없게 모두 입력해주세요.", null);
			return;
		}
			
		if(con == null) {
			AppUtill.alert("데이터 베이스 연결에 실패했습니다.", null);
			return;
		}
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT `id`, `password` FROM `player` WHERE id = '"+ name +"' AND password = '"+ password +"';";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
					
				String ckId = rs.getString("id");
				String ckPs = rs.getString("password");
				if(name.equals(ckId) || password.equals(ckPs)) {
					cnt++;
					
					
					//로그인 세션
					String logSetSql = "insert into log_info(`id`) value('" + ckId + "')";

					try {
						pstmt  = con.prepareStatement(logSetSql);
						pstmt.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("실패!");
					} 
					
					
					AppUtill.alert("로그인 성공", null);
					getScene("/work/MainScene_afterLogin.fxml", loginBtn);
					break;
				}
			}
			if(cnt != 1) {
				AppUtill.alert("아이디와 비밀번호를 다시 확인해주세요.", null);
			}
			
			} catch (Exception e) {
			e.printStackTrace();
			AppUtill.alert("데이터 삽입 실패", null);
			return;
				
		}
	}

}
