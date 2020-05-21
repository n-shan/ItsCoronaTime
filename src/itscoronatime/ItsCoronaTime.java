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

    private int moveSpeed = 10;



    //creates an array of booleans that will return if there is a wall at x,y space
    //size is determined by the total pixels of the arena dived by how many pixels person can move
    private boolean[][] walls = new boolean[1000/moveSpeed][1000/moveSpeed];


    public static void main(String[] args) { launch(args); }

    //adds in all the different pictures
    private Image startImage = new Image("image/StartScreen.png");
    private Image arenaImage = new Image("image/CoronaTimeArenaTemplate.jpeg");
    private boolean startScreen = true;

    public void setWalls()
    {
        //sets the top area of the map to have walls
        for(int i = 0; i < walls.length; ++i)
        {
            for(int j = 0; j < 100/moveSpeed; ++j)
            {
                walls[i][j] = true;
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        setWalls();

        Person person = new Person(50, 90, 50, 50);

        Pane gamePane = new Pane();

        //create person
        Image personImage = new Image(person.getImageName(), person.getWidth(), person.getHeight(), false, false);
        ImageView personImageView = new ImageView(personImage);
        personImageView.setX(person.getX());
        personImageView.setY(person.getY());

        //create coronaVirus
        Coronavirus rona1 = new Coronavirus(400, 460);
        Coronavirus rona2 = new Coronavirus(450, 460);
        Coronavirus rona3 = new Coronavirus(500, 460);
        Coronavirus rona4 = new Coronavirus(550, 460);
        //create coronaVirus images
        Image ronaImage1 = new Image(rona1.getImageName(), rona1.getWidth(), rona1.getHeight(), false, false);
        Image ronaImage2 = new Image(rona2.getImageName(), rona2.getWidth(), rona2.getHeight(), false, false);
        Image ronaImage3 = new Image(rona3.getImageName(), rona3.getWidth(), rona3.getHeight(), false, false);
        Image ronaImage4 = new Image(rona4.getImageName(), rona4.getWidth(), rona4.getHeight(), false, false);
        //create coronaVirus imageViewers
        ImageView ronaImageView1 = new ImageView(ronaImage1);
        ImageView ronaImageView2 = new ImageView(ronaImage2);
        ImageView ronaImageView3 = new ImageView(ronaImage3);
        ImageView ronaImageView4 = new ImageView(ronaImage4);
        //set ImageView locations
        ronaImageView1.setX(rona1.getX());
        ronaImageView1.setY(rona1.getY());

        ronaImageView2.setX(rona2.getX());
        ronaImageView2.setY(rona2.getY());

        ronaImageView3.setX(rona3.getX());
        ronaImageView3.setY(rona3.getY());

        ronaImageView4.setX(rona4.getX());
        ronaImageView4.setY(rona4.getY());

        //create hazmatsuits
        HazmatSuit hazmatSuit1 = new HazmatSuit(40, 155);
        HazmatSuit hazmatSuit2 = new HazmatSuit(930, 155);
        HazmatSuit hazmatSuit3 = new HazmatSuit(40, 690);
        HazmatSuit hazmatSuit4 = new HazmatSuit(930, 690);
        //create hazmatsuit images
        Image hazmatImage1 = new Image(hazmatSuit1.getImageName(), hazmatSuit1.getWidth(),
                hazmatSuit1.getHeight(), false, false);
        Image hazmatImage2 = new Image(hazmatSuit2.getImageName(), hazmatSuit2.getWidth(),
                hazmatSuit2.getHeight(), false, false);
        Image hazmatImage3 = new Image(hazmatSuit3.getImageName(), hazmatSuit3.getWidth(),
                hazmatSuit3.getHeight(), false, false);
        Image hazmatImage4 = new Image(hazmatSuit4.getImageName(), hazmatSuit4.getWidth(),
                hazmatSuit4.getHeight(), false, false);
        //create hazmarsuit imageviews
        ImageView hazmatImageView1 = new ImageView(hazmatImage1);
        ImageView hazmatImageView2 = new ImageView(hazmatImage2);
        ImageView hazmatImageView3 = new ImageView(hazmatImage3);
        ImageView hazmatImageView4 = new ImageView(hazmatImage4);
        //set imageview locations
        hazmatImageView1.setX(hazmatSuit1.getX());
        hazmatImageView1.setY(hazmatSuit1.getY());

        hazmatImageView2.setX(hazmatSuit2.getX());
        hazmatImageView2.setY(hazmatSuit2.getY());

        hazmatImageView3.setX(hazmatSuit3.getX());
        hazmatImageView3.setY(hazmatSuit3.getY());

        hazmatImageView4.setX(hazmatSuit4.getX());
        hazmatImageView4.setY(hazmatSuit4.getY());
        //add imageviews to plane
        gamePane.getChildren().addAll(hazmatImageView1, hazmatImageView2, hazmatImageView3, hazmatImageView4,
                ronaImageView1, ronaImageView2, ronaImageView3, ronaImageView4, personImageView);

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
                    stackPane.getChildren().add(gamePane);
                    startScreen = false;
                }
                if(event.getCode() == KeyCode.DOWN)
                {
                    if(person.getY() < 1000)
                    {
                        person.setLocation(person.getX(), person.getY()+moveSpeed);
                        personImageView.setY(person.getY());
                    }

                }
                else if(event.getCode() == KeyCode.UP)
                {
                    if(person.getY()+person.getHeight() > 0 && walls[person.getX()/moveSpeed][person.getY()/moveSpeed] == false)
                    {
                        person.setLocation(person.getX(), person.getY()-moveSpeed);
                        personImageView.setY(person.getY());
                    }

                }
                else if(event.getCode() == KeyCode.LEFT)
                {
                    if(person.getX() > 0)
                    {
                        person.setLocation(person.getX()-moveSpeed, person.getY());
                        personImageView.setX(person.getX());
                    }

                }
                else if(event.getCode() == KeyCode.RIGHT)
                {
                    if(person.getX()+person.getWidth() < 1000)
                    {
                        person.setLocation(person.getX()+moveSpeed, person.getY());
                        personImageView.setX(person.getX());
                    }

                }
            }
        });

    }
}
