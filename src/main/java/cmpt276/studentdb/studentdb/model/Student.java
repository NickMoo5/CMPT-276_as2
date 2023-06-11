package cmpt276.studentdb.studentdb.model;

public class Student {
    private String name;
    private int height;
    private int weight;
    private String hair;

    public Student(String name, int height, int weight, String hair) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.hair = hair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }


}