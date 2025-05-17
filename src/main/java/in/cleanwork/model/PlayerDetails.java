package in.cleanwork.model;

public class PlayerDetails {

    private final String name;
    private int position;

    public PlayerDetails(String name) {
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
    public String toString() {
        return "PlayerDetails{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
