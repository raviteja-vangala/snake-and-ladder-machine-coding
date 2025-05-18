package in.cleanwork.observer;

public class Player implements Observer {

    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void update(String message) {
        System.out.println(this.name + " : " + message);
    }
}