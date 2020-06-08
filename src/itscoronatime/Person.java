package itscoronatime;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Person extends Entity {
    private int m_lives;
    private int m_score;
    private boolean m_isdead;
    private String imageName = "image/CoronaMan.png";
    private int current = 0;
    private int[] countDownArray = new int[] {8,8,8,8,8,8,8,8,8,8,8,8
            ,7,7,7,7,7,7,7,7,7,7,7,7
            ,6,6,6,6,6,6,6,6,6,6,6,6,
            5,5,5,5,5,5,5,5,5,5,5,5,
            4,4,4,4,4,4,4,4,4,4,4,4,
            3,3,3,3,3,3,3,3,3,3,3,3,
            2,2,2,2,2,2,2,2,2,2,2,2,
            1,1,1,1,1,1,1,1,1,1,1,1,
            0,0,0,0,0,0,0,0,0,0,0,0};

    public Person(int x, int y, int width, int height) {
        setLocation(x, y);
        setWidth(width);
        setHeight(height);
        m_lives = 3;
        m_score = 0;
        m_isdead = false;
    }

    public int countDown(){
        int toReturn = countDownArray[current];
        current++;
        return toReturn;
    }

    public void resetTimer(){
        current = 0;
    }

    public String getImageName() { return imageName; }

    public int getLives() { return m_lives; }

    public int getScore() { return m_score; }

    public void incScore(int amount) { m_score += amount; }

    public void decLives() { m_lives--; }

    public void incLives() { m_lives++; }

    public boolean isDead() { return m_isdead; }

    public void setDead() { m_isdead = true; }

}
