package uk.epl.player;

public class Forward extends Player {
    private int ACCELERATION_POINT = 10;
    public Forward(String name, int jerseyNumber, int speed, int stamina, int passing){
        super(name, jerseyNumber, speed, stamina, passing);
    }

    @Override
    public String getRole(){
        return "Forward";
    }

    @Override
    protected float getSpeed(){
        return super.getSpeed() + ACCELERATION_POINT;
    }
}
