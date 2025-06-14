package ExamPrep.aquarium;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public int getFins() {
        return this.fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Fish: %s%n", this.name))
                .append(String.format("Color: %s%n", this.color))
                .append(String.format("Number of fins: %d", this.fins));

        return sb.toString();
    }

}
