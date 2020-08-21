package itscoronatime;

public class Person extends Entity {
    private int lives;
    private int score;
    private boolean isDead;
    private String imageName = "image/CoronaMan.png";

    public Person(int x, int y, int width, int height) {
        setLocation(x, y);
        setWidth(width);
        setHeight(height);
        lives = 3;
        score = 0;
        isDead = false;
    }

    public String getImageName() { return imageName; }

    public int getLives() { return lives; }

    public int getScore() { return score; }

    public void incScore(int amount) { score += amount; }

    public void decLives() { lives--; }

    public void incLives() { lives++; }

    public boolean isDead() { return isDead; }

    public void setDead() { isDead = true; }

}
