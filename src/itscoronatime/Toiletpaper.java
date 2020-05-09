package itscoronatime;

public class Toiletpaper extends Entity {
    String image = "image/Pellet.png";
    boolean isCollected = false;

    private int pointVal = 10;

    public Toiletpaper(int x, int y){
        setLocation(x,y);
        setVisibility(true);
    }

    public void collect(Person person){
        setVisibility(false);
        isCollected = true;

    }

    public String getImage() {
        return image;
    }
}
