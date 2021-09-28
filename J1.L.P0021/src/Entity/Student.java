package Entity;

public class Student {
    private String id;
    private String name;
    private int semester;
    private String courseName;

    public Student() {
    }

    public Student(String id, String name, String courseName, int semester) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return String.format("%7s | %7s | %3d | %7s",id,name,semester,courseName);
    }
    public String report(){
        return String.format("%7s | %7s | %7s | ", id, name, courseName);
    }
}
