package itscoronatime;

public class Coronavirus extends Entity {

    String image = "image/Ghost.png";
    boolean canDie = false;

    public Coronavirus(int x, int y){
        setLocation(x,y);
        setVisibility(true);
    }

    //when hazmat suit is collected, allow virus to be killed
    public void scare(Person person){
        canDie = true;
    }


    public boolean isScared(Person person){
        return canDie;
    }

    public String getImageName(){
        return image;
    }

    //hazmat suit is off, allow virus to kill person
    public void kill(Person person){
        canDie = false;
    }
}
