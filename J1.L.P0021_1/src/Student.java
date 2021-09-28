public class Student {
    private String id;
    private String name;
    private int semester;
    private String courseName;

    public Student() {
    }

    public Student(String id, String name, int semester, String courseName) {
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
    @Override
    public boolean equals(Object o){
        if(o == null)   return false;
        if(o instanceof Student){
            Student x = (Student)o;
            return x.id.equals(this.id);
        }
        return false;
    }
    
    
}
