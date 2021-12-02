package uk.epl.player;
public abstract class Player {
    private String name;
    private int jerseyNumber;

    private int[] abilities = new int[3];
    final int SPEED = 0; final int STAMINA = 1; final int PASSING = 2;

    Position position;

    public class Position {
        public int x;
        public int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public Player(String name, int jerseyNumber, int speed, int stamina, int passing){
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.abilities[SPEED] = speed;
        this.abilities[STAMINA] = stamina;
        this.abilities[PASSING] = passing;
        this.position = new Position(0,0);
    }
    public String getName() { return name; }
    public int getJerseyNumber() { return jerseyNumber; }
    public Position getPosition(){
        return new Position(position.x, position.y);
    }

    public void moveUp(){
        float move_delta = getMoveDelta();
        position.y = (int)(position.y - move_delta);
        decreaseStamina();
    }

    public void moveDown(){
        float move_delta = getMoveDelta();
        position.y = (int)(position.y + move_delta);
        decreaseStamina();
    }

    public void moveLeft(){
        float move_delta = getMoveDelta();
        position.x = (int)(position.x - move_delta);
        decreaseStamina();
    }

    public void moveRight(){
        float move_delta = getMoveDelta();
        position.x = (int)(position.x + move_delta);
        decreaseStamina();
    }

    public void setPosition(int x, int y){
        position.x = x;
        position.y = y;
    }
    public void setName(String name) { this.name = name; }
    public void setJerseyNumber(int jerseyNumber) { this.jerseyNumber = jerseyNumber; }
    public void setAbilities(int speed, int stamina, int passing) {
        abilities[SPEED] = speed;
        abilities[STAMINA] = stamina;
        abilities[PASSING] = passing;
    }
    public abstract String getRole();

    @Override
    public String toString(){
        return String.format("Player Name='%s, JerseyNumber=%d" +
                        " Position (%d , %d) %s SPEED=%.1f, , STAMINA=%.1f, , PASSING=%.1f"
                , getName(), getJerseyNumber(), getPosition().x, getPosition().y, getRole(),
                getSpeed(), getStamina(), getPassing());
    }

    private void decreaseStamina(){
        abilities[STAMINA] = (int) (abilities[STAMINA] - 2);
    }
    private float getMoveDelta(){
        return 1 + getSpeed() / 100 * getStamina() / 100;
    }
    protected float getPassing() {
        return (float)abilities[PASSING];
    }
    protected float getSpeed(){
        return (float)abilities[SPEED];
    }
    protected float getStamina(){
        return (float)abilities[STAMINA];
    }
}
