package itscoronatime;

public abstract class Entity {
    private int x,y;
    private boolean isVisible;

    public boolean isVisible() {
        return isVisible;
    }
    public void setVisibility(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public int getXLocation() {
        return x;
    }
    public int getYLocation() {
        return y;
    }
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
