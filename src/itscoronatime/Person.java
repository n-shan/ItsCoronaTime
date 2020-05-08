package itscoronatime;

public class Person extends Entity {
    private int lives;
    private int score;
    private String imageName = "image/PacMan.png";
    private int xPos, yPos;

    public Person(int x, int y)
    {
        xPos = x;
        yPos = y;
        lives = 3;
        score = 0;
    }

    public String getImageName()
    {
        return imageName;
    }

    public int getLives()
    {
        return lives;
    }

    public int getScore()
    {
        return score;
    }

    public int getX()
    {
        return xPos;
    }

    public int getY()
    {
        return yPos;
    }

}
