package work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.AppUtill;
import util.JDBCUtil;

public class Controller {
	
	//설정버튼
	@FXML
	private Button setBtn;
	
	//로그인버튼
	@FXML
	private Button loginBtn;
	@FXML
	private Button startToLogin;
	@FXML
	private Button loadToLogin;
	
	//회원가입버튼
	@FXML
	private Button joinBtn;
	
	//메인으로 돌아가는 버튼
	@FXML
	private Button mainBtn;
	@FXML
	private Button endingToMain;
	@FXML
	private Button logoutBtn;
	
	//HOW TO에 가는 버튼
	@FXML
	private Button howplayBtn;
	
	//story1버튼
	@FXML
	private Button story1Btn;
	
	//불러오기 버튼
	@FXML
	private Button loadBtn;
	
	
	//설정창으로 이동하는 화면전환코드
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
	
	
	//로그인창으로 이동하는 화면전환코드
	public void getLoginScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/join/LoginScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("로그인");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	//로그인 전 스타트 버튼을 누르면 로그인창으로 이동하는 화면전환코드
			public void startToLoginScene() {
			      try {
			         Parent login = FXMLLoader.load(getClass().getResource("/join/LoginScene.fxml"));
			         Scene scene = new Scene(login);
			         Stage primaryStage = (Stage) startToLogin.getScene().getWindow();
			         primaryStage.setScene(scene);
			         primaryStage.setTitle("로그인");
			         AppUtill.alert("게임을 이용하기 전 로그인 해주세요.", null);
			         
			      } catch (Exception e) {
			         e.printStackTrace();
			      }
			   }
			
	//로그인 전 불러오기 버튼을 누르면 로그인창으로 이동하는 화면전환코드
			public void loadToLoginScene() {
				try {
					Parent login = FXMLLoader.load(getClass().getResource("/join/LoginScene.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) loadToLogin.getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("로그인");
					AppUtill.alert("게임을 불러오려면 로그인을 진행 해주세요.", null);
					
				} catch (Exception e) {
					e.printStackTrace();
					}
				}
	
	//회원가입창으로 이동하는 화면전환코드
	public void getJoinScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/join/JoinScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) joinBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("회원가입");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	
	//메인창으로 이동하는 화면전환코드
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
	
	//메인창으로 이동하는 화면전환코드
		public void endingSceneToMain() {
		      try {
		         Parent login = FXMLLoader.load(getClass().getResource("/work/MainScene_afterLogin.fxml"));
		         Scene scene = new Scene(login);
		         Stage primaryStage = (Stage) endingToMain.getScene().getWindow();
		         primaryStage.setScene(scene);
		         primaryStage.setTitle("LUNATIC");
		         
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
	
	//로그아웃 후 메인창으로 이동하는 화면전환코드
		public void logoutScene() {
			JDBCUtil db = new JDBCUtil();
			Connection con = db.getConnection();
			
			PreparedStatement pstmt = null;
			String logOutSql = "delete from log_info";
			
			  try {
			     Parent login = FXMLLoader.load(getClass().getResource("/work/MainScene.fxml"));
			     Scene scene = new Scene(login);
			     Stage primaryStage = (Stage) logoutBtn.getScene().getWindow();
			     primaryStage.setScene(scene);
			     primaryStage.setTitle("LUNATIC");
			     AppUtill.alert("로그아웃 되었습니다.", null);
			     
			     pstmt  = con.prepareStatement(logOutSql);
			     pstmt.executeUpdate();
			         
			  } catch (Exception e) {
			     e.printStackTrace();
			  }
		}
	
	//how to창 이동하는 화면전환코드
	public void getHowPlayScene() {
	      try {
	         Parent login = FXMLLoader.load(getClass().getResource("/work/HowPlayScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) howplayBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("How To play");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	
	
	//StoryScene 이동하는 화면전환코드
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
	
	//불러오기 버튼 클릭했을 때
	public void loadBtnHandler() {
		System.out.println("load!");
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		
		PreparedStatement pstmt = null;
		String getLogId = "SELECT id FROM log_info";
		
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(getLogId);
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) {
				String log_id = rs.getString("id");
				
				String loadGameSql = "SELECT `id`, `stage`, `potion`, `accessory`, `skin`, `weapon`, `player_id` FROM save WHERE player_id='" + log_id + "';";

				try {
					pstmt  = con.prepareStatement(loadGameSql);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						String stage = rs.getString("stage");
						String potion = rs.getString("potion");
						String accessory = rs.getString("accessory");
						String skin = rs.getString("skin");
						String weapon = rs.getString("weapon");
						
						System.out.println(stage + ", " + potion + ", " + accessory + ", " + skin + ", " + weapon);
						
						
						// 해당 화면으로 화면전환
						try {
							Parent login;
							if (stage.equals("1")) {
								login = FXMLLoader.load(getClass().getResource("/stage/StageScene.fxml"));	
							} else {
								login = FXMLLoader.load(getClass().getResource("/stage/StageScene" + stage + ".fxml"));	
							}
							Scene scene = new Scene(login);
							Stage primaryStage = (Stage) story1Btn.getScene().getWindow();
					        primaryStage.setScene(scene);
					        primaryStage.setTitle("stage" + stage);
					        
					     } catch (Exception e) {
					        e.printStackTrace();
					     }
						 
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("실패!");
				} 

					
			} else {
				Alert pleaseLoginALert = new Alert(AlertType.INFORMATION);
				pleaseLoginALert.setTitle("로그인 필요");
				pleaseLoginALert.setHeaderText("불러올 정보가 없습니다");
				pleaseLoginALert.setContentText("로그인 후 불러오기를 해주세요.");
				pleaseLoginALert.show();	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패!");
		}
	}
}
