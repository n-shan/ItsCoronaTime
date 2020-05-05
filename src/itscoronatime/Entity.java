package itscoronatime;

public interface Entity {
    public boolean isDead();
    public void setDead();

    public int getXLocation();
    public int getYLocation();
    public void setLocation(int x, int y);
}
