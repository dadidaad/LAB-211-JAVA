package Manager;

import Entity.Student;
import java.util.*;

public class StudentManager {

    ArrayList<Student> list;
    ListTest lt = new ListTest();

    public StudentManager() {
        list = new ArrayList<>();
        lt.add(list);
    }

    public int create(String id, String name, int semester, String course) {
        int n = list.size();
        if (list.isEmpty()) {
            list.add(new Student(id, name, course, semester));
        } else {
            boolean check = true;
            for (Student x : list) {
                if ((id.equalsIgnoreCase(x.getId()) && name.equalsIgnoreCase(x.getName())
                        && semester == x.getSemester() && course.equalsIgnoreCase(x.getCourseName()))
                        || (id.equalsIgnoreCase(x.getId()) && !name.equalsIgnoreCase(x.getName()))) {
                    check = false;
                }
            }
            if (check == true) {
                list.add(new Student(id, name, course, semester));
            } else {
                return -1;
            }
        }
        return n;
    }

    public void displayList() {
        for (Student x : list) {
            System.out.println(x.toString());
        }
    }

    public ArrayList findAndSort(String name) {
        if (list.isEmpty()) {
            return null;
        }
        
        ArrayList<Student> newList = new ArrayList<>();
        for (Student x : list) {
            if (x.getName().toLowerCase().contains(name.toLowerCase())) {
                newList.add(x);
            }
        }
        if (newList.isEmpty()) {
            return null;
        }
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return newList;
    }

    public Student searchByID(String id) {
        for (Student x : list) {
            if (id.equalsIgnoreCase(x.getId())) {
                return x;
            }
        }
        return null;
    }

    public Student update(String id, String name, int semester, String course) {
        Student y = searchByID(id);
        int index = list.indexOf(y);
        if(name.equals("")){
            name = y.getName();
        }
        if(course.equals("")){
            course = y.getCourseName();
        }
        y = new Student(id, name, course, semester);
        for (Student x : list) {
            if(x.getId().equals(id)){
                x.setName(name);
                list.set(list.indexOf(x), x);
            }
        }
        list.set(index, y);
        return y;
    }

    public void delete(String id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                list.remove(i);
            }
        }
    }

    public void report() {
        if (list.isEmpty()) {
            return;
        }
        int total = 1;
        Collections.sort(list, (Student s1, Student s2) -> {
            int x = s1.getId().compareTo(s2.getId());
            if (x == 0) {
                x = s1.getCourseName().compareTo(s2.getCourseName());
            }
            return x;
        });
        for (int i = 0; i < list.size(); ++i) {
            String id1 = list.get(i).getId();
            String id2 = list.get((i + 1) % list.size()).getId();
            if (id1.equals(id2)) {
                String course1 = list.get(i).getCourseName();
                String course2 = list.get(i + 1).getCourseName();
                if (course1.equals(course2)) {
                    ++total;
                    continue;
                }
            }
            System.out.println(list.get(i).report() + " " + total);
            total = 1;
        }
    }
}
