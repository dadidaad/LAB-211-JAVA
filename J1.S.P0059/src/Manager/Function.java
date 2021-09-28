package Manager;

import Entity.Person;
import static Manager.Main.sc;
import java.util.*;
import java.io.*;

public class Function {

    Validate vld = new Validate();

    public void sortbyMoney(List<Person> list) {
        Collections.sort(list, (Person o1, Person o2) -> {
            if (o1.getMoney() > o2.getMoney()) {
                return 1;
            } else if (o1.getMoney() < o2.getMoney()) {
                return -1;
            } else {
                return 0;
            }
        });
    }

    public List<Person> getPerson(String path, double money) {
        List<Person> t = new ArrayList<>();
        while (true) {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    file.createNewFile();
                    throw new MyException("Path is not exist!");
                }
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] info = line.trim().split("[;]");
                    String name = info[0].trim();
                    String address = info[1].trim();
                    String xMoney = info[2].trim();
                    double moneyinfile;
                    if (vld.isDouble(xMoney)) {
                        moneyinfile = Double.parseDouble(xMoney);
                    } else {
                        moneyinfile = 0;
                    }
                    if (moneyinfile < 0) {
                        moneyinfile = 0;
                    }
                    if (moneyinfile >= money) {
                        t.add(new Person(name, address, moneyinfile));
                    }
                }
                br.close();
                reader.close();
            } catch (IOException e) {
                System.out.println("Can’t read file");
                continue;
            } catch (NumberFormatException e) {
                continue;
            } catch (MyException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        sortbyMoney(t);
        return t;
    }

    public void displayData() {
        List<Person> list = new ArrayList<>();
        System.out.println("--------- Person info ---------");
        System.out.print("Enter path: ");
        String path = vld.enterPath();
        double money = vld.enterMoney();
        list = getPerson(path, money);
        System.out.println("------------- Result ----------");
        System.out.println("Name        Address 	Money");
        for (Person x : list) {
            System.out.println(x.toString());
        }
        System.out.println();
        System.out.println("Max: " + list.get(list.size() - 1).getName());
        System.out.println("Min: " + list.get(0).getName());
    }

    public static boolean checkAplabet(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder removeDuplicates(String txt, String splitterRegex) {
        List<String> values = new ArrayList<String>();
        String[] splitted = txt.split(splitterRegex);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitted.length; ++i) {
            if (!values.contains(splitted[i]) && checkAplabet(splitted[i])) {
                values.add(splitted[i]);
                sb.append(' ');
                sb.append(splitted[i]);
            }
        }
        return sb;

    }

    public static boolean copyWordOneTimes(String source, String destination) {
        File oldFile = new File(source);
        if (!oldFile.exists()) {
            System.out.println("Path doesn't exist");
            try {
                oldFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
        StringBuilder result = new StringBuilder();
        try {
            String currentLine;
            FileReader reader = new FileReader(oldFile);
            BufferedReader br = new BufferedReader(reader);
            while ((currentLine = br.readLine()) != null) {
                result.append(currentLine).append(" ");
            }
            result = removeDuplicates(result.toString(), "[!,? ._'@;\\s]+");
        } catch (IOException e) {
            System.err.println("Can’t read file");
            return false;
        }
        try {
            File newFile = new File(destination);
            if (!newFile.exists()) {
                try {
                    newFile.createNewFile();
                } catch (IOException e) {
                    System.out.println("Can’t read file");
                    return false;
                }
            }
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(result.substring(1));
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Can’t write file");
            return false;
        } catch (NullPointerException e) {
            System.out.println("Old file is empty");
            return false;
        }
        return true;
    }

    public void writeDatatoNewFile() {
        System.out.println("------------- Copy text --------------");
        System.out.print("Enter source: ");
        String source = vld.enterPath();
        System.out.print("Enter new file name: ");
        String newSource = vld.enterPath();
        boolean check = copyWordOneTimes(source, newSource);
        if (check == true) {
            System.out.println("copy done!");
        }
    }
}
