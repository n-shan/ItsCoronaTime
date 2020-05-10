package itscoronatime;

public abstract class Entity {
    private int x,y, width, height;
    private boolean isVisible;

    public boolean isVisible() {
        return isVisible;
    }
    public void setVisibility(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
