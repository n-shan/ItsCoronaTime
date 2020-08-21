package itscoronatime;

public class Coronavirus extends Entity {

    private String image = "image/Ghost.png";
    private boolean canDie = false;
    private boolean isInCage;

    public Coronavirus(int x, int y){
        setLocation(x,y);
        setWidth(50);
        setHeight(50);
        setVisibility(true);
        isInCage = true;
    }

    public String getImageName(){
        return image;
    }

    public void setIsInCage(boolean isInCage) {
        this.isInCage = isInCage;
    }

    public boolean getIsInCage() {
        return isInCage;
    }
}
