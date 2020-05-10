package itscoronatime;

public class Toiletpaper extends Entity {
    private String image = "image/Pellet.png";
    private boolean isCollected = false;
    private int pointVal = 10;

    public Toiletpaper(int x, int y){
        setLocation(x,y);
        setVisibility(true);
    }

    public void collect(){
        setVisibility(false);
        isCollected = true;

    }

    public String getImageName() {
        return image;
    }
}
