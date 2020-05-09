package itscoronatime;

public class HazmatSuit extends Entity {
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

}
