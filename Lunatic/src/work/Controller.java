package work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import util.JDBCUtil;

public class Controller {
	
	//설정버튼
	@FXML
	private Button setBtn;
	
	//로그인버튼
	@FXML
	private Button loginBtn;
	
	//회원가입버튼
	@FXML
	private Button joinBtn;
	
	//메인으로 돌아가는 버튼
	@FXML
	private Button mainBtn;
	
	//HOW TO에 가는 버튼
	@FXML
	private Button howplayBtn;
	
	//story1버튼
	@FXML
	private Button story1Btn;
	
	//불러오기 버튼
	@FXML
	private Button loadBtn;
	
	
	public void initialize() {
		System.out.println("initialize");
	
	}
	
	
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
	         Parent login = FXMLLoader.load(getClass().getResource("/work/MainScene.fxml"));
	         Scene scene = new Scene(login);
	         Stage primaryStage = (Stage) mainBtn.getScene().getWindow();
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("LUNATIC");
	         
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
