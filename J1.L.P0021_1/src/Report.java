public class Report {
    private String name;
    private String courseName;
    private int total;

    public Report() {
    }

    public Report(String name, String courseName, int total) {
        this.name = name;
        this.courseName = courseName;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public String toString(){
        return String.format("%7s | %5s | %3d", name,courseName,total);
    }
    public boolean equals(Object o){
        if(o == null)   return false;
        if(o instanceof Report){
            Report x = (Report)o;
            return x.name.equalsIgnoreCase(this.name);
        }
        return false;
    }
}
