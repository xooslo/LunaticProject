package join;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	private TextField id;
	@FXML
	private TextField nick;
	@FXML
	private PasswordField ps;	
	@FXML
	private PasswordField ps2;
	@FXML
	private Button joinBtn;
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
	
	public void addPlayer() {
		String name = id.getText();
		String nickname = nick.getText();
		String password = ps.getText();
		String ckPs = ps2.getText();
		
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		
		if (name.isEmpty() || nickname.isEmpty() || password.isEmpty() || ckPs.isEmpty()) {
			AppUtill.alert("모든 란을 정확히 채워주세요.", null);
			return;
		}
		if(name.equals(" ") || nickname.equals(" ") || password.equals(" ") || ckPs.equals(" ")) {
			AppUtill.alert("모든 란에 공백이 없게 다시 입력해주세요.", null);
			return;
		}
	
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO player VALUES (?, ?, ?)";
	
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2,nickname);
			pstmt.setString(3, password);
			pstmt.setString(4, ckPs);
			pstmt.executeUpdate();
			AppUtill.alert("로그인 후 게임을 이용하실 수 있습니다.", "가입 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			AppUtill.alert("데이터 삽입에 실패했습니다.", null);
		}
	}
}
