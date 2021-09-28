package Manager;

import Entity.Student;
import java.util.ArrayList;

public class ListTest {


    void add(ArrayList<Student> st) {
        st.add(new Student("123", "Nguyen Van A", "java", 1));
        st.add(new Student("223", "Nguyen Van B", "java", 2));
        st.add(new Student("123", "Nguyen Van A", "java", 3));
        st.add(new Student("129", "Nguyen Van C", ".net", 1));
        st.add(new Student("331", "Nguyen Van A", "java", 1));
        st.add(new Student("222", "Nguyen van D", "c++", 1));
        st.add(new Student("222", "Nguyen Van D", "c++", 2));
        st.add(new Student("123", "Nguyen Van A", "java", 4));
    }
}
