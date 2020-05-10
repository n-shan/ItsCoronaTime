package itscoronatime;

public class HazmatSuit extends Entity {
    private String image = "image/PowerPellet.png";
    private final int pointVal = 50;
    private boolean isCollected;

    HazmatSuit(int x, int y) {
        setLocation(x, y);
        setVisibility(true);
        isCollected = false;
    }
    public void collect() {
        isCollected = true;
    }
    public String getImageName() {
        return image;
    }
}
