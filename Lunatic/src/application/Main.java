package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(getClass().getResource("/work/MainScene.fxml"));
//			loader.setLocation(getClass().getResource("/work/LoginScene.fxml"));
			loader.setLocation(getClass().getResource("/work/SettingScene.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			
//			Scene scene = new Scene(root,1200,800);
			Scene scene = new Scene(root,350,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Lunatic");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
