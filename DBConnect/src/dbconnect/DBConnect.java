package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author MR
 */
public class DBConnect extends Application {
    Statement statement;
    public Button btn = new Button();
    public Button btn2 = new Button("Logout");
    Stage Dashboard = new Stage();
    
    public TextField tfUsername = new TextField("");
    public TextField tfPass = new TextField("");
    
    
    
    public void Dashboard(){
        StackPane root = new StackPane();
        root.getChildren().add(btn2);
        
        Scene scene = new Scene(root, 300, 250);
        
        Dashboard.setTitle("Dashboard");
        Dashboard.setScene(scene);
        Dashboard.show();
    }
            
            
    
    @Override
    public void start(Stage primaryStage) {
        DBConnect();
        btn.setText("Login");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("call");
                    String username = tfUsername.getText();
                    String pass = tfPass.getText();
                    String insertquery = "select * from user where uname = '"+username+"'";
                    ResultSet result = statement.executeQuery(insertquery);
                    if(result.next()){
                        System.out.println(result.getString(3));
                        if(result.getString(3).equals(pass)){
                            primaryStage.hide();
                            Dashboard();
                        }else{
                            btn.setText("No User Found");
                        }
                    }else{
                        btn.setText("No User Found");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Problem to Show Data");
                }
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.show();
                Dashboard.hide();
            }
        });
        
        StackPane root = new StackPane();
        
        GridPane gp = new GridPane();
        
        gp.add(tfUsername, 0, 0);
        gp.add(tfPass, 0, 1);
        gp.add(btn, 0, 3);
        
        root.getChildren().add(gp);
        
        Scene scene = new Scene(root, 500, 250);
        
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void DBConnect(){
        try {
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/fxapp","root","");
            statement = conn.createStatement();
            System.out.println("Database Connected");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database Not Connected");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
