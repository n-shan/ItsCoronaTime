package itscoronatime;

public class Person extends Entity {
    private int m_lives;
    private int m_score;
    private String imageName = "image/CoronaMan.png";

    public Person(int x, int y, int width, int height) {
        setLocation(x, y);
        setWidth(width);
        setHeight(height);
        m_lives = 3;
        m_score = 0;
    }

    public String getImageName() { return imageName; }

    public int getLives() { return m_lives; }

    public int getScore() { return m_score; }


}
