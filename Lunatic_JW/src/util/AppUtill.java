package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AppUtill {
	public static void alert(String msg, String header) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("알림창");
		alert.setHeaderText(header);
		alert.setContentText(msg);

		alert.show();
	}
}
