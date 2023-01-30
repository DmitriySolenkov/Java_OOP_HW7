package Model;

public class Agent {
    private String name;

    public Agent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[Agent : " + name + " ]";
    }
}
