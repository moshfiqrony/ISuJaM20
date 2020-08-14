package fx.pkg14082020;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Fx14082020 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Logout");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage logoutStage = new Stage();
                logoutStage.setTitle("Do you really want to Logout?");
                Button yes = new Button("Yes");
                StackPane logoutPane = new StackPane();
                logoutPane.getChildren().add(yes);
                Scene logoutScene = new Scene(logoutPane, 200, 200);
                logoutStage.setScene(logoutScene);
                logoutStage.show();
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("IUBAT");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
