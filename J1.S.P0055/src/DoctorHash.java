
import java.util.*;

public class DoctorHash {

    HashMap<String, Doctor> hm = new HashMap<String, Doctor>();
    public static Scanner sc = new Scanner(System.in);

    public boolean checkAvailability(int Availability) {
        if (Availability < 0) {
            return false;
        }
        return true;
    }

    public boolean addDoctor(Doctor x) {
        if (x == null) {
            System.out.println("Data does not exist");
            return false;
        }
        if (!checkAvailability(x.getAvailability())) {
            System.out.println("Availability must >= 0");
            return false;
        }
        if (hm.containsKey(x.getCode())) {
            System.out.println("Doctor code " + x.getCode() + " is duplicate");
            return false;
        } else {
            hm.put(x.getCode(), x);
        }
        return true;
    }

    public boolean searchByCode(String xCode) {
        Set<String> key = hm.keySet();
        for (String code : key) {
            if (xCode.equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public void displayData(HashMap<String, Doctor> hashmap) {
        Set<String> key = hashmap.keySet();
        for (String keyValue : key) {
            Doctor x = hashmap.get(keyValue);
            System.out.println(x.toString());
        }
    }

    public Doctor getByCode(String xCode) {
        Doctor x = new Doctor();
        x = hm.get(xCode);
        return x;
    }

    public boolean updateDoctor(Doctor x) {
        String key = x.getCode();
        if (hm.isEmpty()) {
            return false;
        }
        if (x == null) {
            return false;
        }
        if (!searchByCode(key)) {
            return false;
        }
        Doctor y = x;
        if (x.getName().equals("")) {
            y.setName(getByCode(key).getName());
        }
        if (x.getSpecialization().equals("")) {
            y.setSpecialization(getByCode(key).getSpecialization());
        }
        if (x.getAvailability() == 0) {
            y.setAvailability(getByCode(key).getAvailability());
        }
        hm.replace(key, y);
        return true;
    }

    public boolean deleteDoctor(Doctor x) {
        if (hm.isEmpty()) {
            return false;
        }
        if (x == null) {
            return false;
        }
        if (!searchByCode(x.getCode())) {
            return false;
        }
        hm.remove(x.getCode(), x);
        return true;
    }

    public boolean checkInput(String input) {
        Set<String> key = hm.keySet();
        for (String code : key) {
            Doctor x = hm.get(code);
            if (input.equalsIgnoreCase(code) || input.equalsIgnoreCase(x.getName()) || input.equalsIgnoreCase(x.getSpecialization()) || input.equals(String.valueOf(x.getAvailability()))) {
                return true;
            }
        }
        return false;
    }

    public HashMap<String, Doctor> searchDoctor(String input) {
        if (hm.isEmpty()) {
            return null;
        }
        HashMap<String, Doctor> newHm = new HashMap<>();
        Set<String> key = hm.keySet();
        if (input.equals("") || !checkInput(input)) {
            newHm.putAll(hm);
        } else {
            for (String code : key) {
                Doctor x = hm.get(code);
                if (input.equals(code) || input.equalsIgnoreCase(x.getName()) || input.equalsIgnoreCase(x.getSpecialization()) || input.equals(String.valueOf(x.getAvailability()))) {
                    newHm.put(code, x);
                }
            }
        }
        return newHm;
    }
}
