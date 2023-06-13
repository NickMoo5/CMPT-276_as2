package cmpt276.studentdb.studentdb.model;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int height;
    private int weight;
    private String hair;
    private float gpa;
    private String favProf;
    private String favIde;
    private String imgIdePath;

    public static final Map<String, String> IDE_STR_TO_IMG_PATH = Map.of(
            "VS Code", "vscode.png",
            "Notepad", "notepad.jpg",
            "Intellij", "intellij.jpg",
            "Microsoft Word", "word.png"
    );

    public static final Map<String, String> IMG_PATH_TO_IDE_STR = Map.of(
            "vscode.png", "VS Code",
            "notepad.jpg", "Notepad",
            "intellij.jpg", "Intellij",
            "word.png", "Microsoft Word"
    );
    
    public static final String IMG_PATH = "/images/";

    public Student() {
        
    }

    public Student(String name, int height, int weight, String hair, float gpa, String prof, String ide, String ideImgPath) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.hair = hair;
        this.gpa = gpa;
        this.favProf = prof;
        this.favIde = ide;
        this.imgIdePath = ideImgPath;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getFavProf() {
        return favProf;
    }

    public void setFavProf(String favProf) {
        this.favProf = favProf;
    }

    public String getFavIde() {
        return favIde;
    }

    public void setFavIde(String favIde) {
        this.favIde = favIde;
    }

    public String getImgIdePath() {
        return imgIdePath;
    }

    public void setImgIdePath(String imgIdePath) {
        this.imgIdePath = imgIdePath;
    }
}