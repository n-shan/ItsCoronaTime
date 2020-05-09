package itscoronatime;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ItsCoronaTime extends Application {

    public static void main(String[] args) { launch(args); }

    //adds in all the different pictures
    private Image startImage = new Image("image/StartScreen.png");
    private Image arenaImage = new Image("image/CoronaTimeArenaTemplate.jpeg");
    private boolean startScreen = true;
    @Override
    public void start(Stage primaryStage) throws Exception {

        //starts the game
        //Arena arena = new Arena

        Person person = new Person(50, 90, 50, 50);

        Pane personPane = new Pane();

        Image personImage = new Image(person.getImageName(), person.getWidth(), person.getHeight(), false, false);
        ImageView imageView = new ImageView();
        imageView.setImage(personImage);
        imageView.setX(person.getX());
        imageView.setY(person.getY());
        personPane.getChildren().add(imageView);

        StackPane stackPane = new StackPane();



        Pane pane = new Pane();

        pane.getChildren().add(new ImageView(startImage));

        stackPane.getChildren().addAll(pane);

        Scene scene = new Scene(stackPane, 1000, 1000);

        primaryStage.setTitle("Its Corona Time");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(startScreen)
                {
                    System.out.println("Key pressed");
                    pane.getChildren().remove(startImage);
                    pane.getChildren().add(new ImageView(arenaImage));
                    stackPane.getChildren().add(personPane);
                    startScreen = false;
                }
                if(event.getCode() == KeyCode.DOWN)
                {
                    person.setY((int) (imageView.getY()+10));
                    imageView.setY(person.getY());
                }
                if(event.getCode() == KeyCode.UP)
                {
                    person.setY((int) (imageView.getY()-10));
                    imageView.setY(person.getY());
                }
                if(event.getCode() == KeyCode.LEFT)
                {
                    person.setX((int) (imageView.getX()-10));
                    imageView.setX(person.getX());
                }
                if(event.getCode() == KeyCode.RIGHT)
                {
                    person.setX((int) (imageView.getX()+10));
                    imageView.setX(person.getX());
                }
            }
        });

    }
}
