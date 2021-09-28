
import java.util.HashMap;
import java.util.Random;

public class DoctorView extends DoctorHash {

    public void listTest() {
        String[] code = {"DOC 1", "DOC 2", "DOC 3", "DOC 4", "DOC 1", "DOC 5"};
        String[] name = {"Lan", "Nghia", "Son", "Hoang", "Thai", "Lan"};
        String[] spec = {"Orthopedics", "Obstetrics", "orthodontic"};
        int[] ava = {1, 2, 3};
        for (int i = 0; i < code.length; i++) {
            int rnd = new Random().nextInt(spec.length);
            Doctor x = new Doctor(code[i], name[i], spec[rnd], ava[rnd]);
            boolean check = addDoctor(x);
        }
        displayData(hm);
    }

    public void addDoctor() {
        Doctor x = new Doctor();
        boolean check;
        System.out.println("--------- Add Doctor ----------");
        while (true) {
            try {
                System.out.print("Enter code: ");
                String xCode = sc.nextLine();
                System.out.print("Enter name: ");
                String xName = sc.nextLine();
                System.out.print("Enter specialization: ");
                String xSpe = sc.nextLine();
                System.out.print("Enter availability: ");
                int xAva = Integer.parseInt(sc.nextLine());
                if (xCode.equals("") || xName.equals("") || xSpe.equals("")) {
                    x = null;
                } else {
                    x = new Doctor(xCode, xName, xSpe, xAva);
                }
                System.out.println();
                sc.nextLine();
                check = addDoctor(x);
            } catch (NumberFormatException e) {
                System.out.println("Wrong format!! Try again!!");
                continue;
            }
            if (check == true) {
                System.out.println("Doctor added!!");
                break;
            }
        }
        displayData(hm);
    }

    public void updateDoctor() {
        System.out.println("--------- Update Doctor -------");
        int newAva = 0;
        System.out.print("Enter code: ");
        String xCode = sc.nextLine();
        System.out.print("Enter name: ");
        String newName = sc.nextLine();
        System.out.print("Enter specialization: ");
        String newSpec = sc.nextLine();
        System.out.print("Enter availability: ");
        //String newStrAva = sc.nextLine();
        try{
        newAva = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            newAva = 0 ;
        }
        Doctor x = new Doctor(xCode, newName, newSpec, newAva);
        boolean check = updateDoctor(x);
        if (check == true) {
            System.out.println("Update successfully");
        } else {
            System.out.println("Doctor code doesn’t exist");
        }
        displayData(hm);
    }

    public void deleteDoctor() {
        System.out.println("--------- Delete Doctor -------");
        System.out.print("Enter code: ");
        String xCode = sc.nextLine();
        Doctor x = getByCode(xCode);
        boolean check = deleteDoctor(x);
        if (check == true) {
            System.out.println("Delete successfully");
        } else {
            System.out.println("Doctor code doesn’t exist");
        }
        displayData(hm);
    }

    public void searchDoctor() {
        System.out.println("---------- Search Doctor --------");
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        HashMap<String, Doctor> searchHm = searchDoctor(input.trim());
        if (searchHm == null) {
            System.out.println("Database is not exist!");
        }
        displayData(searchHm);
    }
}
