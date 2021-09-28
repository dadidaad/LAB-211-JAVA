package Manager;

import Entity.Employee;
import java.util.*;

public class EmployeeManager {

    ArrayList<Employee> list;

    public EmployeeManager() {
        list = new ArrayList<>();
        list.add(new Employee("123", "John", "Smith", "012345678", "johnsmith@a.com", "US", "07-06-1993", "Male", 1200, "Yes"));
        list.add(new Employee("223", "Alan", "Taylor", "093321233", "alantaylor@b.com", "Canada", "27-06-1995", "Female", 2300, "Yes"));
        list.add(new Employee("323", "Minh", "Tri", "032912331", "minhtri@c.com", "VN", "13-02-1991", "Male", 1000, "Yes"));
        list.add(new Employee("125", "Yuki", "Maura", "045312127", "yukimura@d.com", "England", "23-09-1994", "Female", 800, "No"));
        list.add(new Employee("133", "Barrela", "Nico", "091234513", "barrela@e.com", "Italia", "01-01-1996", "Male", 1500, "Yes"));
        list.add(new Employee("124", "Quedo", "Han", "099831232", "quedoman@a.com", "France", "13-09-1992", "Male", 1200, "Yes"));
    }

    public Employee checkID(String xID) {
        for (Employee x : list) {
            if (xID.equalsIgnoreCase(x.getId())) {
                return x;
            }
        }
        return null;
    }

    public boolean add(String id, String FirstName, String LastName, String phone, String email, String address, String DOB, String Sex, double salary, String engecy) {
        if (checkID(id) != null) {
            return false;
        }
        list.add(new Employee(id, FirstName, LastName, phone, email, address, DOB, Sex, salary, engecy));
        return true;
    }

    public void show() {
        for (Employee x : list) {
            System.out.println(x.toString());
        }
    }

    public Employee update(String id, String FirstName, String LastName, String phone, String email, String address, String DOB, String Sex, double salary, String engecy) {
        Employee x = checkID(id);
        int index = list.indexOf(x);
        x.setFirstName(FirstName);
        x.setLastName(LastName);
        x.setPhone(phone);
        x.setEmail(email);
        x.setAddress(address);
        x.setDOB(DOB);
        x.setSex(Sex);
        x.setEngecy(engecy);
        x.setSalary(salary);
        list.set(index, x);
        return list.get(index);
    }

    public void remove(String id) {
        Employee x = checkID(id);
        list.remove(x);
    }

    public ArrayList searchbyName(String name) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee x : list) {
            String fullname = x.getFirstName().concat(" " + x.getLastName());
            if (fullname.contains(name)) {
                result.add(x);
            }
        }
        return result;
    }

    public void sortbySalary() {
        Comparator<Employee> u = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                } else if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(list, u);
    }
}
