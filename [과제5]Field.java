package uk.epl.game;

import uk.epl.player.Player;
import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Player> players = new ArrayList<>();

    public void add(Player player){
        players.add(player);
    }
    public void moveUp(int jerseyNumber){
        for (Player player : players) {
            if (jerseyNumber == player.getJerseyNumber()) player.moveUp();
        }
    }
    public void moveDown(int jerseyNumber) {
        for (Player player : players) {
            if (jerseyNumber == player.getJerseyNumber()) player.moveDown();
        }
    }
    public void moveLeft(int jerseyNumber) {
        for (Player player : players) {
            if (jerseyNumber == player.getJerseyNumber()) player.moveLeft();
        }
    }
    public void moveRight(int jerseyNumber) {
        for (Player player : players) {
            if (jerseyNumber == player.getJerseyNumber()) player.moveRight();
        }
    }
    public void start(){
        for (Player player : players){
            String position = player.getRole();
            switch(position){
                case "Forward": player.setPosition(34, 25); break;
                case "Midfielder": player.setPosition(34, 50); break;
                case "Defender": player.setPosition(34, 75); break;
            }
        }

    }
    public void stop(){

    }
    public void info(){
        for (Player player : players){
            System.out.println(player.toString());
        }
    }
}
