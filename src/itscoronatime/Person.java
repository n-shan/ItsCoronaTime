package itscoronatime;

public class Person extends Entity {
    private int m_lives;
    private int m_score;
    private String imageName = "image/PacMan.png";
    private int m_x, m_y, m_width, m_height;

    public Person(int x, int y, int width, int height)
    {
        m_x = x;
        m_y = y;
        m_width = width;
        m_height = height;
        m_lives = 3;
        m_score = 0;
    }

    public String getImageName()
    {
        return imageName;
    }

    public int getLives()
    {
        return m_lives;
    }

    public int getScore()
    {
        return m_score;
    }

    public int getX()
    {
        return m_x;
    }

    public int getY()
    {
        return m_y;
    }

    public int getWidth() { return m_width; }

    public int getHeight() { return m_height; }

    public void setX(int x) { m_x = x; }

    public void setY(int y) { m_y = y; }

}
