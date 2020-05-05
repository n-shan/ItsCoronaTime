package itscoronatime;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ItsCoronaTime extends Application {

    public static void main(String[] args) { launch(args); }

    //adds in all the different pictures
    private Image image = new Image("image/StartScreen.png");

    @Override
    public void start(Stage primaryStage) throws Exception {

        //starts the game
        //Arena arena = new Arena

        Pane pane = new Pane();

        pane.getChildren().add(new ImageView(image));

        Scene scene = new Scene(pane, 2220, 1248);

        primaryStage.setTitle("Its Corona Time");
        primaryStage.setScene(scene);
        primaryStage.show();

        //test for merged branch

    }
}
