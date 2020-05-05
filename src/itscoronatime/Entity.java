package itscoronatime;

public interface Entity {
    public boolean isVisible();
    public void setVisibility(boolean isVisible);

    public int getXLocation();
    public int getYLocation();
    public void setLocation(int x, int y);
}
