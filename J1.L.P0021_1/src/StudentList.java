
import java.util.*;

public class StudentList {
    ArrayList<Student> t = new ArrayList<Student>();
    public static Scanner sc = new Scanner(System.in);
    public String stardardizedName(String name){
        name = name.trim().toLowerCase();
        name = name.replaceAll("//s+", " ");
        String[] temp = name.split(" ");
        name = "";
        for (int i = 0; i < temp.length; i++) {
            name += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if(i < temp.length - 1) name += " ";
            
        }
        return name;
    }
    public boolean checkCourseName(String xCourseName){
        xCourseName = xCourseName.toLowerCase();
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add(".net");
        list.add("c/c++");
        if(list.contains(xCourseName)){
            return true;
        }
        return false;
    }
    public void create(){
        Student x = new Student();
        int count=0;
        boolean isStop;
        while(true){
            isStop = false;
            try{
                System.out.print("Enter student ID: ");
                String id = sc.nextLine().toUpperCase().trim();
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                name = stardardizedName(name);
                System.out.print("Enter semester: ");
                int semester = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter course name(Java, .Net, C/C++): ");
                String courseName = sc.nextLine();
                if(checkCourseName(courseName) == false)    throw new MyException("Only 3 course");
                x = new Student(id, name, semester, courseName);
                System.out.println();
                if(t.contains(x))    throw new MyException("ID have been exist in list");
                else    t.add(x);
                ++count;
                if(count > 10){
                    System.out.print("Do you want to continue (Y/N)? ");
                    char choice = sc.next().toUpperCase().charAt(0);
                    sc.nextLine();
                    switch(choice){
                        case 'Y':
                            continue;
                        case 'N':
                            isStop = true;
                            break;
                        default:
                            isStop = true;
                            break;
                    }
                } 
            }
            catch(InputMismatchException e){
                System.out.println("Wrong format!!");
                System.out.println();
                sc.nextLine();
                continue;
            }
            catch(MyException e){
                System.out.println(e.getMessage());
                System.out.println();
                continue;
            }
            if(isStop == true)  break;
        }
    }
    public void FindAndSort(){
        if(t.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.print("Enter name to find: ");
        String xName = sc.nextLine();
        boolean isExist = false;
        for (Student x : t) {
            if(x.getName().contains(xName)){
                System.out.println(x.toString());
                isExist = true;
            }
        }
        if(isExist == false)    System.out.println("Can not find student in the list");
        else{
            Collections.sort(t, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2){
                return o1.getName().compareTo(o2.getName());
            }
        });
            System.out.println("Sorted succesfully");
            for (Student x : t) {
                System.out.println(x.toString());
            }
        }
        sc.nextLine();
    }
    public void UpdateAndDelete(){
        if(t.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.print("Enter ID to edit:");
        String id  = sc.nextLine().toUpperCase();
        boolean isExist = false;
        Student y = new Student();
        int index=0;
        for(Student x : t){
            if(x.getId().equalsIgnoreCase(id)){
                y = x;
                index = t.indexOf(x);
                isExist = true;
            }
        }
        if(isExist == false){
            System.out.println("Can't find student ID in list");
            return;
        }
        else{
            System.out.println("Do you want update(U) or delete(D) student:");
            char choice = sc.next().toUpperCase().charAt(0);
            sc.nextLine();
            switch(choice){
                case 'U':
                    while(true){
                        try{
                            System.out.print("New ID:");
                            String xId = sc.nextLine().toUpperCase().trim();
                            System.out.print("New name:");
                            String xName = sc.nextLine();
                            xName = stardardizedName(xName);
                            System.out.print("New Semester: ");
                            int xSemester = Integer.parseInt(sc.nextLine());
                            System.out.print("New course: ");
                            String xCourseName = sc.nextLine().trim();
                            if(checkCourseName(xCourseName) == false)    throw new MyException("Only 3 course");
                            y = new Student(xId, xName, xSemester, xCourseName);
                            t.set(index, y);
                            if(t.contains(y))    throw new MyException("ID have been exist in list");
                        }
                        catch(InputMismatchException e){
                            System.out.println("Wrong format!!");
                            sc.nextLine();
                            continue;
                        }
                        catch(MyException e){
                            System.out.println(e.getMessage());
                            sc.nextLine();
                            continue;
                        }
                        System.out.println("Updated succesfully!");
                        break;
                    }
                    break;
                case 'D':
                    t.remove(y);
                    System.out.println("Deleted succesfully");
                    break;
                default:
                    System.out.println("Wrong input!!");
                    break;
            }
            
        }
        sc.nextLine();
    }
    public void report(){
        if(t.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        ArrayList<Report> report = new ArrayList<Report>();
        Report student = new  Report();
        int total;
        for (int i = 0; i < t.size(); i++) {
            total = 0;
            for (int j = 0; j < t.size(); j++) {
                if(t.get(i).getName().equals(t.get(j).getName())){
                    ++total;
                }
            }
            student = new Report(t.get(i).getName(), t.get(i).getCourseName(), total);
            if(!report.contains(student)){
                report.add(student);
            }
        }
        for (Report x : report) {
            System.out.println(x.toString());
        }
    }
}
