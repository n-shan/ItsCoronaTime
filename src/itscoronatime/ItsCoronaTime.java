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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ItsCoronaTime extends Application {

    private int moveSpeed = 10;
    private Toiletpaper pelletArr[] = new Toiletpaper[212];
    private Image pelletImageArr[] = new Image[212];
    private ImageView pelletImageViewArr[] = new ImageView[212];



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

    public void setpellets(ImageView arr[]){
        //pellets for first top row

        arr[0].setX(50);
        arr[0].setY(110);

        for(int i = 1 ; i < 12; i++){
            arr[i].setX(arr[i - 1].getX() + 35);
            arr[i].setY(110);
        }

        // pellets for other half of top row

        arr[12].setX(940);
        arr[12].setY(110);

        for(int i = 13 ; i < 24; i++){
            arr[i].setX(arr[i - 1].getX() - 35);
            arr[i].setY(110);
        }

        // pellets for next row
        arr[24].setX(50);
        arr[24].setY(220);

        for(int i = 25; i < 37; i ++){
            arr[i].setX(arr[i - 1].getX() + 35);
            arr[i].setY(220);

        }

        // pellets for half of next row
        arr[37].setX(940);
        arr[37].setY(220);

        for(int i = 38 ; i < 50; i++){
            arr[i].setX(arr[i - 1].getX() - 35);
            arr[i].setY(220);
        }

        // pellets for left long column

        arr[50].setX(225);
        arr[50].setY(259);

        for(int i = 51; i < 65; i++){
            arr[i].setY(arr[i-1].getY() + 39);
            arr[i].setX(225);
        }

        //pellets for right long column

        arr[65].setX(765);
        arr[65].setY(259);

        for(int i = 66; i < 80; i++){
            arr[i].setY(arr[i-1].getY() + 39);
            arr[i].setX(765);
        }

        //pellets for first bottom row

        arr[80].setX(50);
        arr[80].setY(650);

        for(int i = 81; i < 85; i++){
            arr[i].setX(arr[i - 1].getX() + 35);
            arr[i].setY(650);
        }

        //pellets for first bottom row cont

        arr[85].setX(265);
        arr[85].setY(650);

        for(int i = 86; i < 91; i++){
            arr[i].setX(arr[i - 1].getX() + 35);
            arr[i].setY(650);
        }

        //pellets for first bottom row right

        arr[91].setX(940);
        arr[91].setY(650);

        for(int i = 92; i < 97; i++){
            arr[i].setX(arr[i-1].getX() - 35);
            arr[i].setY(650);
        }

        //pellets for first bottom row right continued
        arr[97].setX(730);
        arr[97].setY(650);

        for(int i = 98; i < 103; i++){
            arr[i].setX(arr[i-1].getX() - 35);
            arr[i].setY(650);
        }

        // pellets for section top left
        arr[103].setX(50);
        arr[103].setY(298);

        for(int i = 104; i < 108; i++){
            arr[i].setY(arr[i-1].getY() - 39);
            arr[i].setX(50);

        }

        //pellets for section top right
        arr[108].setX(940);
        arr[108].setY(298);

        for(int i = 109; i < 112; i++){
            arr[i].setY(arr[i-1].getY() - 39);
            arr[i].setX(940);

        }

        //pellets for top left bottom row

        arr[112].setX(85);
        arr[112].setY(300);

        for(int i = 113; i < 117; i++){
            arr[i].setX(arr[i - 1].getX() + 35);
            arr[i].setY(300);

        }

        //pellets for top right bottom row
        arr[117].setX(905);
        arr[117].setY(300);

        for(int i = 118; i < 121; i++){
            arr[i].setX(arr[i - 1].getX() - 35);
            arr[i].setY(300);
        }

        //pellet for top left middle section

        arr[121].setX(225);
        arr[121].setY(145);

        for(int i = 122; i < 123; i++){
            arr[i].setY(arr[i - 1].getY() + 39);
            arr[i].setX(225);

        }

        // pellets for top left right middle section
        arr[123].setX(435);
        arr[123].setY(145);

        for(int i = 124; i < 125; i++){
            arr[i].setY(arr[i - 1].getY() + 39);
            arr[i].setX(435);
        }

        //pellets for top right left section
        arr[125].setX(555);
        arr[125].setY(145);

        for(int i = 126; i < 127; i++){
            arr[i].setY(arr[i - 1].getY() + 39);
            arr[i].setX(555);

        }

        //pellets for top right middle section
        arr[127].setX(765);
        arr[127].setY(145);

        for(int i = 128; i < 129; i++){
            arr[i].setY(arr[i - 1].getY() + 39);
            arr[i].setX(765);
        }

        // pellets for left column inner section

        arr[129].setX(330);
        arr[129].setY(262);

        for(int i = 130; i < 131; i++){
            arr[i].setY(arr[i - 1].getY() + 39);
            arr[i].setX(330);
        }

        //pellets for right column inner section

        arr[131].setX(660);
        arr[131].setY(262);

        for(int i = 132; i < 133; i++){
            arr[i].setY(arr[i - 1].getY() + 39);
            arr[i].setX(660);
        }

        //pellets for left row inner section

        arr[133].setX(330);
        arr[133].setY(301);

        for(int i = 134; i < 137; i++){
            arr[i].setX(arr[i - 1].getX() + 39);
            arr[i].setY(301);

        }

        //pellets for right row inner section

        arr[137].setX(621);
        arr[137].setY(301);

        for(int i = 138; i < 140; i++){
            arr[i].setX(arr[i - 1].getX() - 39);
            arr[i].setY(301);
        }

        //pellets for super bottom row

        arr[140].setX(50);
        arr[140].setY(900);

        for(int i = 141; i <= 164; i++){
            arr[i].setX(arr[i - 1].getX() + 39);
            arr[i].setY(900);

        }

        // pellets for bottom middle row
        arr[165].setX(265);
        arr[165].setY(728);

        for (int i = 166; i < 178; i++){
            arr[i].setX(arr[i - 1].getX() + 39);
            arr[i].setY(728);
        }

        // pellets for bottom left, left column
        arr[178].setX(50);
        arr[178].setY(689);

        for(int i = 179; i < 180; i++){
            arr[i].setX(50);
            arr[i].setY(arr[i - 1].getY() + 39);
        }

        // pellets for bottom right, right column
        arr[180].setX(940);
        arr[180].setY(689);

        for(int i = 181; i < 182; i++){
            arr[i].setX(940);
            arr[i].setY(arr[i - 1].getY() + 39);

        }


        //pellets for bottom right, middle right row

        arr[182].setX(905);
        arr[182].setY(728);

        for(int i = 183; i < 184; i++){
            arr[i].setX(arr[i - 1].getX() - 35);
            arr[i].setY(728);

        }

        //pellets for bottom left, middle left row

        arr[184].setX(85);
        arr[184].setY(728);

        for(int i = 185; i < 186; i++){
            arr[i].setX(arr[i - 1].getX() + 35);
            arr[i].setY(728);

        }

        //single pellet bottom left

        arr[186].setX(120);
        arr[186].setY(767);

        //single pellet bottome left middle
        arr[187].setX(340);
        arr[187].setY(767);

        //single pellet bottom right middle

        arr[188].setX(655);
        arr[188].setY(767);

        //single pellet bottom right right
        arr[189].setX(870);
        arr[189].setY(767);

        //middle bottom left row

        arr[190].setX(50);
        arr[190].setY(810);

        for(int i = 191; i < 195; i++){
            arr[i].setX(arr[i - 1].getX() + 35);
            arr[i].setY(810);

        }

        //middle bottom left middle row

        arr[195].setX(330);
        arr[195].setY(810);

        for(int i = 196; i < 199; i++){
            arr[i].setX(arr[i - 1].getX() + 35);
            arr[i].setY(810);
        }

        //middle bottom right middle row

        arr[199].setX(550);
        arr[199].setY(810);

        for(int i = 200; i < 203; i++){
            arr[i].setX(arr[i - 1].getX() + 35);
            arr[i].setY(810);
        }

        //middle bottom right right row

        arr[203].setX(800);
        arr[203].setY(810);

        for(int i = 204; i < 208; i++){
            arr[i].setX(arr[i - 1].getX() + 35);
            arr[i].setY(810);
        }

        //single pellet bottom left
        arr[208].setX(50);
        arr[208].setY(850);

        arr[209].setX(440);
        arr[209].setY(850);

        arr[210].setX(550);
        arr[210].setY(850);

        arr[211].setX(940);
        arr[211].setY(850);
        
        
        //sets location for actual pellets
        for(int i = 0; i < arr.length; ++i)
        {
            pelletArr[i].setLocation((int)arr[i].getX(), (int)arr[i].getY());
        }
        
    }

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
//        for(int i = 470; i <= 530; i+=moveSpeed)
//        {
//            for(int j = 430; j <= 440; j+=moveSpeed)
//            {
//                walls[i/moveSpeed][j/moveSpeed] = true;
//            }
//        }

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
        else if(direction == "UP")
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
        else if(direction == "LEFT")
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
        else if(direction == "RIGHT")
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

    public void moveEntity(Entity entity)
    {
        if(entity.getDirection() == "RIGHT")
        {
            if(canMove(entity, "RIGHT"))
            {
                if(entity.getX()+moveSpeed >= 950)
                {
                    entity.setLocation(0+moveSpeed, entity.getY());
                }
                else
                {
                    entity.setLocation(entity.getX()+moveSpeed, entity.getY());
                }
            }
        }
        else if(entity.getDirection() == "LEFT")
        {
            if(canMove(entity, "LEFT"))
            {
                if(entity.getX()-moveSpeed <= 0)
                {
                    entity.setLocation(940, entity.getY());
                }
                else{
                    entity.setLocation(entity.getX()-moveSpeed, entity.getY());
                }
            }
        }
        else if(entity.getDirection() == "DOWN")
        {
            if(canMove(entity, "DOWN"))
            {
                entity.setLocation(entity.getX(), entity.getY()+moveSpeed);
            }
        }
        else if(entity.getDirection() == "UP")
        {
            if(canMove(entity, "UP"))
            {
                entity.setLocation(entity.getX(), entity.getY()-moveSpeed);
            }
        }
    }
    
    public boolean canCollectToiletPaper(Person p)
    {
        if(p.getDirection() == "DOWN")
        {
            for(int i = 0; i <= p.getWidth(); i+=moveSpeed) //checks everywhere inside of person
            {
                for(int j = 0; j < pelletArr.length; ++j)
                {
                    if(!pelletArr[j].hasBeenCollected() && (p.getX()+i)/moveSpeed == pelletArr[j].getX()/moveSpeed && (p.getY()+p.getHeight())/moveSpeed == pelletArr[j].getY()/moveSpeed)
                    {
                        pelletArr[j].collect();
                        pelletImageViewArr[j].setVisible(false);
                        return true;
                    }
                }
            }
            return false;
        }
        else if(p.getDirection() == "UP")
        {
            for(int i = 0; i <= p.getWidth(); i+=moveSpeed)
            {
                for(int j = 0; j < pelletArr.length; ++j)
                {
                    if(!pelletArr[j].hasBeenCollected() && (p.getX()+i)/moveSpeed == pelletArr[j].getX()/moveSpeed && (p.getY()-moveSpeed)/moveSpeed == pelletArr[j].getY()/moveSpeed)
                    {
                        pelletArr[j].collect();
                        pelletImageViewArr[j].setVisible(false);
                        return true;
                    }
                }
            }
            return false;
        }
        else if(p.getDirection() == "LEFT")
        {
            for(int i = 0; i <= p.getWidth(); i+=moveSpeed)
            {
                for(int j = 0; j < pelletArr.length; ++j)
                {
                    if(!pelletArr[j].hasBeenCollected() && (p.getX()-moveSpeed)/moveSpeed == pelletArr[j].getX()/moveSpeed && (p.getY()+i)/moveSpeed == pelletArr[j].getY()/moveSpeed)
                    {
                        pelletArr[j].collect();
                        pelletImageViewArr[j].setVisible(false);
                        return true;
                    }
                }
            }
            return false;
        }
        else if(p.getDirection() == "RIGHT")
        {
            for(int i = 0; i <= p.getWidth(); i+=moveSpeed)
            {
                for(int j = 0; j < pelletArr.length; ++j)
                {
                    if(!pelletArr[j].hasBeenCollected() && (p.getX()+p.getWidth())/moveSpeed == pelletArr[j].getX()/moveSpeed && (p.getY()+i)/moveSpeed == pelletArr[j].getY()/moveSpeed)
                    {
                        pelletArr[j].collect();
                        pelletImageViewArr[j].setVisible(false);
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public void collectToiletPaper(Person p)
    {
        //if it doesn't collect any
        //toiletpaper then do nothing
        if(!canCollectToiletPaper(p))
        {
            return;
        }
        p.incScore(10);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        setWalls();

        Person person = new Person(30, 90, 50, 50);

        Pane gamePane = new Pane();

        //play corona time music
        String musicFile = "its-corona-time-music.mp3";

        Media media = new Media(new File(musicFile).toURI().toString());


        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.play();


        //create pellet arrays to hold all toiletpaper (pellets)

        


        //create ToiletPaper entities

        for(int i = 0; i < pelletArr.length; i++){

            pelletArr[i] = new Toiletpaper();
            pelletImageArr[i] = new Image(pelletArr[i].getImageName(), pelletArr[i].getWidth(), pelletArr[i].getHeight(), false, false);
            pelletImageViewArr[i] = new ImageView(pelletImageArr[i]);

            pelletImageViewArr[i].setX(pelletArr[i].getX());
            pelletImageViewArr[i].setY(pelletArr[i].getY());
        }


        setpellets(pelletImageViewArr);


        for(int i = 0; i < pelletImageViewArr.length; i++){
            gamePane.getChildren().addAll(pelletImageViewArr[i]);
        }



        //create person
        Image personImage = new Image(person.getImageName(), person.getWidth(), person.getHeight(), false, false);
        ImageView personImageView = new ImageView(personImage);
        personImageView.setX(person.getX());
        personImageView.setY(person.getY());

        //create coronaVirus
        Coronavirus rona1 = new Coronavirus(400, 460);
        rona1.setDirection("RIGHT");
        Coronavirus rona2 = new Coronavirus(475, 375);
        rona2.setDirection("LEFT");
        rona2.setIsInCage(false);
        Coronavirus rona3 = new Coronavirus(475, 460);
        rona3.setDirection("UP");
        Coronavirus rona4 = new Coronavirus(550, 460);
        rona4.setDirection("LEFT");
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
        Text scoreBoard = new Text(430, 60, String.format("%06d", person.getScore()));
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
                    person.setDirection("DOWN");
                }
                else if(event.getCode() == KeyCode.UP)
                {
                    person.setDirection("UP");
                }
                else if(event.getCode() == KeyCode.LEFT)
                {
                    person.setDirection("LEFT");
                }
                else if(event.getCode() == KeyCode.RIGHT)
                {
                    person.setDirection("RIGHT");
                }
                System.out.println("X: " + person.getX() + " Y: " + person.getY());
            }
        });

        Timeline musicTimeLine = new Timeline(new KeyFrame(Duration.seconds(60), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                mediaPlayer.play();
            }
        }));
        musicTimeLine.setCycleCount(Timeline.INDEFINITE);
        musicTimeLine.play();

        new Thread(() -> {
            Timeline personTimeline = new Timeline(new KeyFrame(Duration.seconds(.1), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    //makes person move
                    moveEntity(person);
                    personImageView.setX(person.getX());
                    personImageView.setY(person.getY());

                    //checks to see if person is colleting toilet paper
                    collectToiletPaper(person);

                    //updates the scoreboard
                    scoreBoard.setText(String.format("%06d", person.getScore()));
                }
            }));
            personTimeline.setCycleCount(Timeline.INDEFINITE);
            personTimeline.play();
        }).start();

        String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};

        new Thread(() -> {
            Timeline virusTimeline = new Timeline(new KeyFrame(Duration.seconds(.3), new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    if(!startScreen) {
                        if(canMove(rona2, rona2.getDirection())) {
                            moveEntity(rona2);
                            ronaImageView2.setX(rona2.getX());
                            ronaImageView2.setY(rona2.getY());
                        }
                        else {
                            while(!canMove(rona2, rona2.getDirection())) {
                                Random rand = new Random();
                                int randNum;
                                randNum = rand.nextInt(4);
                                rona2.setDirection(directions[randNum]);
                            }
                        }

                    }
                }
            }));
            virusTimeline.setCycleCount(Timeline.INDEFINITE);
            virusTimeline.play();
        }).start();

        new Thread(() -> {
            Timeline virusTimeline = new Timeline(new KeyFrame(Duration.seconds(.3), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(!startScreen) {
                        if(rona3.getIsInCage()) {
                            if(rona3.getY() > 375) {
                                moveEntity(rona3);
                                ronaImageView3.setX(rona3.getX());
                                ronaImageView3.setY(rona3.getY());
                            }
                            else {
                                rona3.setIsInCage(false);
                                rona3.setDirection("RIGHT");
                            }
                        }
                        else {
                            if(canMove(rona3, rona3.getDirection())) {
                                moveEntity(rona3);
                                ronaImageView3.setX(rona3.getX());
                                ronaImageView3.setY(rona3.getY());
                            }
                            else {
                                while(!canMove(rona3, rona3.getDirection())) {
                                    Random rand = new Random();
                                    int randNum;
                                    randNum = rand.nextInt(4);
                                    rona3.setDirection(directions[randNum]);
                                }
                            }
                        }
                    }
                }
            }));
            virusTimeline.setCycleCount(Timeline.INDEFINITE);
            virusTimeline.play();
        }).start();

        new Thread(() -> {
            Timeline virusTimeline = new Timeline(new KeyFrame(Duration.seconds(.3), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(!startScreen && !rona3.getIsInCage()) {
                        if(rona1.getIsInCage()) {
                            if(rona1.getX() < 475) {
                                moveEntity(rona1);
                                ronaImageView1.setX(rona1.getX());
                                ronaImageView1.setY(rona1.getY());
                            }
                            else if(rona1.getX() >= 475 && rona1.getY() > 375) {
                                rona1.setDirection("UP");
                                moveEntity(rona1);
                                ronaImageView1.setX(rona1.getX());
                                ronaImageView1.setY(rona1.getY());
                            }
                            else {
                                rona1.setIsInCage(false);
                                rona1.setDirection("LEFT");
                            }
                        }
                        else {
                            if(canMove(rona1, rona1.getDirection())) {
                                moveEntity(rona1);
                                ronaImageView1.setX(rona1.getX());
                                ronaImageView1.setY(rona1.getY());
                            }
                            else {
                                while(!canMove(rona1, rona1.getDirection())) {
                                    Random rand = new Random();
                                    int randNum;
                                    randNum = rand.nextInt(4);
                                    rona1.setDirection(directions[randNum]);
                                }
                            }
                        }
                    }
                }
            }));
            virusTimeline.setCycleCount(Timeline.INDEFINITE);
            virusTimeline.play();
        }).start();

        new Thread(() -> {
            Timeline virusTimeline = new Timeline(new KeyFrame(Duration.seconds(.3), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(!startScreen && !rona1.getIsInCage()) {
                        if(rona4.getIsInCage()) {
                            if(rona4.getX() > 475) {
                                moveEntity(rona4);
                                ronaImageView4.setX(rona4.getX());
                                ronaImageView4.setY(rona4.getY());
                            }
                            else if(rona4.getX() <= 475 && rona4.getY() > 375) {
                                rona4.setDirection("UP");
                                moveEntity(rona4);
                                ronaImageView4.setX(rona4.getX());
                                ronaImageView4.setY(rona4.getY());
                            }
                            else {
                                rona4.setIsInCage(false);
                                rona4.setDirection("RIGHT");
                            }
                        }
                        else {
                            if(canMove(rona4, rona4.getDirection())) {
                                moveEntity(rona4);
                                ronaImageView4.setX(rona4.getX());
                                ronaImageView4.setY(rona4.getY());
                            }
                            else {
                                while(!canMove(rona4, rona4.getDirection())) {
                                    Random rand = new Random();
                                    int randNum;
                                    randNum = rand.nextInt(4);
                                    rona4.setDirection(directions[randNum]);
                                }
                            }
                        }
                    }
                }
            }));
            virusTimeline.setCycleCount(Timeline.INDEFINITE);
            virusTimeline.play();
        }).start();
    }
}
