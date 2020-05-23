package itscoronatime;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class ItsCoronaTime extends Application {

    private int moveSpeed = 10;



    //creates an array of booleans that will return if there is a wall at x,y space
    //size is determined by the total pixels of the arena dived by how many pixels person can move
    private boolean[][] walls = new boolean[1000/moveSpeed+1][1000/moveSpeed+1];


    public static void main(String[] args) { launch(args); }

    //adds in all the different pictures
    private Image startImage = new Image("image/StartScreen.png");
    private Image arenaImage = new Image("image/CoronaTimeArenaTemplate.jpeg");
    private boolean startScreen = true;


    //sets the walls for the arena
    //the i is for the x coordinate
    //the j is for the y coordinate
    public void setWalls()
    {
        //walls for section 0
        for(int i = 0; i <= 1000; i+=moveSpeed)
        {
            for(int j = 0; j <= 80; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 1
        for(int i = 100; i <= 190; i+=moveSpeed)
        {
            for(int j = 150; j <= 190; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 2
        for(int i = 280; i <= 400; i+=moveSpeed)
        {
            for(int j = 150; j <= 190; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 3
        for(int i = 490; i <= 510; i+=moveSpeed)
        {
            for(int j = 80; j <= 190; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 4
        for(int i = 590; i <= 730; i+=moveSpeed)
        {
            for(int j = 150; j <= 190; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 5
        for(int i = 810; i <= 900; i+=moveSpeed)
        {
            for(int j = 150; j <= 190; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 5
        for(int i = 810; i <= 900; i+=moveSpeed)
        {
            for(int j = 150; j <= 190; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 6
        for(int i = 100; i <= 190; i+=moveSpeed)
        {
            for(int j = 260; j <= 280; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 7
        for(int i = 280; i <= 300; i+=moveSpeed)
        {
            for(int j = 260; j <= 450; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 8
        for(int i = 280; i <= 400; i+=moveSpeed)
        {
            for(int j = 350; j <= 360; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 9
        for(int i = 380; i <= 620; i+=moveSpeed)
        {
            for(int j = 260; j <= 280; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 10
        for(int i = 490; i <= 510; i+=moveSpeed)
        {
            for(int j = 260; j <= 360; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 11
        for(int i = 600; i <= 730; i+=moveSpeed)
        {
            for(int j = 350; j <= 360; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 12
        for(int i = 700; i <= 730; i+=moveSpeed)
        {
            for(int j = 260; j <= 450; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 13
        for(int i = 810; i <= 1000; i+=moveSpeed)
        {
            for(int j = 350; j <= 450; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 14
        for(int i = 0; i <= 190; i+=moveSpeed)
        {
            for(int j = 350; j <= 450; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 15
        for(int i = 380; i <= 460; i+=moveSpeed)
        {
            for(int j = 430; j <= 440; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 16
        for(int i = 380; i <= 390; i+=moveSpeed)
        {
            for(int j = 430; j <= 530; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 17
        for(int i = 380; i <= 620; i+=moveSpeed)
        {
            for(int j = 530; j <= 530; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 18
        for(int i = 610; i <= 620; i+=moveSpeed)
        {
            for(int j = 430; j <= 530; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 19
        for(int i = 540; i <= 620; i+=moveSpeed)
        {
            for(int j = 430; j <= 440; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 20
        //going to need to have some special way to allow
        //corona virus to get through this wall but not person
        for(int i = 470; i <= 530; i+=moveSpeed)
        {
            for(int j = 430; j <= 440; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 21
        for(int i = 0; i <= 190; i+=moveSpeed)
        {
            for(int j = 520; j <= 620; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 22
        for(int i = 280; i <= 300; i+=moveSpeed)
        {
            for(int j = 520; j <= 620; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 23
        for(int i = 380; i <= 620; i+=moveSpeed)
        {
            for(int j = 600; j <= 620; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 24
        for(int i = 490; i <= 510; i+=moveSpeed)
        {
            for(int j = 620; j <= 700; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 25
        for(int i = 700; i <= 730; i+=moveSpeed)
        {
            for(int j = 520; j <= 620; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 26
        for(int i = 810; i <= 1000; i+=moveSpeed)
        {
            for(int j = 520; j <= 620; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 27
        for(int i = 100; i <= 190; i+=moveSpeed)
        {
            for(int j = 690; j <= 700; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 28
        for(int i = 170; i <= 190; i+=moveSpeed)
        {
            for(int j = 690; j <= 780; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 29
        for(int i = 280; i <= 400; i+=moveSpeed)
        {
            for(int j = 690; j <= 700; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 30
        for(int i = 600; i <= 730; i+=moveSpeed)
        {
            for(int j = 690; j <= 700; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 31
        for(int i = 810; i <= 830; i+=moveSpeed)
        {
            for(int j = 690; j <= 780; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 32
        for(int i = 810; i <= 900; i+=moveSpeed)
        {
            for(int j = 690; j <= 700; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 33
        for(int i = 920; i <= 1000; i+=moveSpeed)
        {
            for(int j = 770; j <= 780; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 34
        for(int i = 0; i <= 80; i+=moveSpeed)
        {
            for(int j = 770; j <= 780; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 35
        for(int i = 100; i <= 400; i+=moveSpeed)
        {
            for(int j = 860; j <= 870; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 36
        for(int i = 280; i <= 300; i+=moveSpeed)
        {
            for(int j = 770; j <= 870; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 37
        for(int i = 380; i <= 620; i+=moveSpeed)
        {
            for(int j = 770; j <= 780; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 38
        for(int i = 490; i <= 510; i+=moveSpeed)
        {
            for(int j = 770; j <= 870; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 39
        for(int i = 600; i <= 900; i+=moveSpeed)
        {
            for(int j = 860; j <= 870; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 40
        for(int i = 700; i <= 730; i+=moveSpeed)
        {
            for(int j = 770; j <= 870; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 41
        for(int i = 810; i <= 900; i+=moveSpeed)
        {
            for(int j = 260; j <= 280; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 42
        for(int i = 0; i <= 10; i+=moveSpeed)
        {
            for(int j = 80; j <= 300; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 43
        for(int i = 0; i <= 10; i+=moveSpeed)
        {
            for(int j = 620; j <= 890; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 44
        for(int i = 0; i <= 1000; i+=moveSpeed)
        {
            for(int j = 940; j < 1000; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 45
        for(int i = 990; i <= 1000; i+=moveSpeed)
        {
            for(int j = 620; j <= 890; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }

        //walls for section 46
        for(int i = 990; i <= 1000; i+=moveSpeed)
        {
            for(int j = 80; j <= 300; j+=moveSpeed)
            {
                walls[i/moveSpeed][j/moveSpeed] = true;
            }
        }
    }

    //checks to see if given entity can move
    public boolean canMove(Entity entity, String direction)
    {
        if(direction == "DOWN")
        {
            for(int i = 0; i <= entity.getWidth(); i+=moveSpeed)
            {
                if(walls[(entity.getX()+i)/moveSpeed][(entity.getY()+entity.getHeight()+moveSpeed)/moveSpeed])
                {
                    return false;
                }
            }
            return true;
        }
        if(direction == "UP")
        {
            for(int i = 0; i <= entity.getWidth(); i+=moveSpeed)
            {
                if(walls[(entity.getX()+i)/moveSpeed][(entity.getY()-moveSpeed)/moveSpeed])
                {
                    return false;
                }
            }
            return true;
        }
        if(direction == "LEFT")
        {
            for(int i = 0; i <= entity.getWidth(); i+=moveSpeed)
            {
                if(walls[(entity.getX()-moveSpeed)/moveSpeed][(entity.getY()+i)/moveSpeed])
                {
                    return false;
                }
            }
            return true;
        }
        if(direction == "RIGHT")
        {
            for(int i = 0; i <= entity.getWidth(); i+=moveSpeed)
            {
                if(walls[(entity.getX()+entity.getWidth()+moveSpeed)/moveSpeed][(entity.getY()+i)/moveSpeed])
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        setWalls();

        Person person = new Person(30, 90, 50, 50);

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


        //create scoreboard
        Text scoreBoard = new Text(425, 60, String.format("%06d", person.getScore()));
        scoreBoard.setFill(Color.WHITE);
        scoreBoard.setFont(Font.font(40));


        //add imageviews and scoreboard to pane
        gamePane.getChildren().addAll(hazmatImageView1, hazmatImageView2, hazmatImageView3, hazmatImageView4,
                ronaImageView1, ronaImageView2, ronaImageView3, ronaImageView4, personImageView, scoreBoard);

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
                    pane.getChildren().remove(startImage);
                    pane.getChildren().add(new ImageView(arenaImage));
                    stackPane.getChildren().add(gamePane);
                    startScreen = false;
                }
                if(event.getCode() == KeyCode.DOWN)
                {
                    if(canMove(person, "DOWN"))
                    {
                        person.setLocation(person.getX(), person.getY()+moveSpeed);
                        personImageView.setY(person.getY());
                    }

                }
                else if(event.getCode() == KeyCode.UP)
                {
                    if(canMove(person, "UP"))
                    {
                        person.setLocation(person.getX(), person.getY()-moveSpeed);
                        personImageView.setY(person.getY());
                    }

                }
                else if(event.getCode() == KeyCode.LEFT)
                {
                    if(canMove(person, "LEFT"))
                    {
                        if(person.getX()-moveSpeed <= 0)
                        {
                            person.setLocation(940, person.getY());
                        }
                        else{
                            person.setLocation(person.getX()-moveSpeed, person.getY());
                        }
                        personImageView.setX(person.getX());

                    }

                }
                else if(event.getCode() == KeyCode.RIGHT)
                {
                    if(canMove(person, "RIGHT"))
                    {
                        if(person.getX()+moveSpeed >= 950)
                        {
                            person.setLocation(0+moveSpeed, person.getY());
                        }
                        else
                        {
                            person.setLocation(person.getX()+moveSpeed, person.getY());
                        }
                        personImageView.setX(person.getX());
                    }

                }
                System.out.println("X: " + person.getX() + " Y: " + person.getY());
            }
        });

        Timeline virusTimeline = new Timeline(new KeyFrame(Duration.seconds(.5), new EventHandler<ActionEvent>() {

            Random rand = new Random();
            int[] moveChoices = {moveSpeed, -moveSpeed};
            int randXInt, randYInt;

            @Override
            public void handle(ActionEvent event) {

                if(!startScreen) {
                    randXInt = rand.nextInt(2);
                    randYInt = rand.nextInt(2);

                    //if(!walls[rona1.getX() + moveChoices[randXInt]][rona1.getY() + moveChoices[randYInt]])
                    if(true) {
                        rona1.setLocation(rona1.getX() + moveChoices[randXInt], rona1.getY() + moveChoices[randYInt]);
                        ronaImageView1.setX(rona1.getX());
                        ronaImageView1.setY(rona1.getY());
                    }

                    randXInt = rand.nextInt(2);
                    randYInt = rand.nextInt(2);

                    if(true) {
                        rona2.setLocation(rona2.getX() + moveChoices[randXInt], rona2.getY() + moveChoices[randYInt]);
                        ronaImageView2.setX(rona2.getX());
                        ronaImageView2.setY(rona2.getY());
                    }

                    randXInt = rand.nextInt(2);
                    randYInt = rand.nextInt(2);

                    if(true) {
                        rona3.setLocation(rona3.getX() + moveChoices[randXInt], rona3.getY() + moveChoices[randYInt]);
                        ronaImageView3.setX(rona3.getX());
                        ronaImageView3.setY(rona3.getY());
                    }

                    randXInt = rand.nextInt(2);
                    randYInt = rand.nextInt(2);

                    if(true) {
                        rona4.setLocation(rona4.getX() + moveChoices[randXInt], rona4.getY() + moveChoices[randYInt]);
                        ronaImageView4.setX(rona4.getX());
                        ronaImageView4.setY(rona4.getY());
                    }
                }
            }
        }));
        virusTimeline.setCycleCount(Timeline.INDEFINITE);
        virusTimeline.play();

    }
}
