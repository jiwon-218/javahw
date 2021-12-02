package uk.epl.player;
public class Midfielder extends Player {
    private int PASS_POINT = 10;
    public Midfielder(String name, int jerseyNumber, int speed, int stamina, int passing){
        super(name, jerseyNumber, speed, stamina, passing);
    }

    @Override
    public String getRole(){
        return "Midfielder";
    }

    @Override
    public float getPassing(){
        return super.getSpeed() + PASS_POINT;
    }
}
