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
//			loader.setLocation(getClass().getResource("/work/SettingScene.fxml"));
//			loader.setLocation(getClass().getResource("/work/HowPlayScene.fxml"));
//			loader.setLocation(getClass().getResource("/join/LoginScene.fxml"));
//			loader.setLocation(getClass().getResource("/join/JoinScene.fxml"));
//			loader.setLocation(getClass().getResource("/stage/StageScene.fxml"));
//			loader.setLocation(getClass().getResource("/stage/StageScene2.fxml"));
//			loader.setLocation(getClass().getResource("/stage/StageScene3.fxml"));
//			loader.setLocation(getClass().getResource("/stage/StageScene4.fxml"));
//			loader.setLocation(getClass().getResource("/stage/StageScene5.fxml")); 
//			loader.setLocation(getClass().getResource("/story/Ending.fxml"));
//			loader.setLocation(getClass().getResource("/story/StoryScene.fxml"));
//			loader.setLocation(getClass().getResource("/story/StoryScene2.fxml"));
//			loader.setLocation(getClass().getResource("/story/Root1.fxml")); 
//			loader.setLocation(getClass().getResource("/story/Root2.fxml")); 
//			loader.setLocation(getClass().getResource("/store/StoreScene.fxml"));
//			loader.setLocation(getClass().getResource("/store/StoreScene2.fxml")); 
			loader.setLocation(getClass().getResource("/work/Ending.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			
			Scene scene = new Scene(root,1200,800);
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
