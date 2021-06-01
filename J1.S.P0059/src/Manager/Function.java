package Manager;

import Entity.Person;
import static Manager.Main.sc;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Function {
    List<Person> t = new ArrayList<>();
    Validate vld = new Validate();
    
    
    public String enterPath(){
        String path;
        while(true){
            try{
                path = sc.nextLine().trim();
                if(vld.checkString(path)) throw new MyException("Not empty!!");     
            }
            catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return path;
    }
    
    
    public double enterMoney(){
        double money;
        while(true){
            try{
                System.out.print("Enter money: ");
                money = Double.parseDouble(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Wrong format!!");
                continue;
            }
            break;
        }
        return money;
    }
    
    
    public void sortbyMoney(List<Person> list){
        Collections.sort(list, (Person o1, Person o2) -> {
            if(o1.getMoney() > o2.getMoney())    return 1;
            else if(o1.getMoney() < o2.getMoney())   return -1;
            else return 0;
        });
    }
    

    public void readFile(String path){
        while(true){
            try{
                File file = new File(path);
                if(!file.exists()){
                    file.createNewFile();
                    throw new MyException("Path is not exist!");
                }
                Scanner read = new Scanner(file);
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                String line = "";
                while((line = br.readLine()) != null){
                    String[] info = line.trim().split("[;]");
                    String name = info[0].trim();
                    String address = info[1].trim();
                    String xMoney = info[2].trim();
                    double money;
                    if(vld.isDouble(xMoney)){
                        money = Double.parseDouble(xMoney);
                    }
                    else{
                        money = 0;
                    }
                    if(money < 0){
                        money = 0;
                    }
                    t.add(new Person(name, address, money));
                }
            } catch (IOException e) {
                System.out.println("Can’t read file");
                continue;
            } catch(NumberFormatException e){
                continue;
            } catch (MyException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }
    
    public void displayData(){
        try{
            List<Person> list = new ArrayList<>();
            System.out.println("--------- Person info ---------");
            System.out.print("Enter path: ");
            String path = enterPath();
            double money = enterMoney();
            readFile(path);
            System.out.println("------------- Result ----------");
            System.out.println("Name        Address 	Money");
            for (Person x : t) {
                if(x.getMoney() > money){
                    list.add(x);
                    System.out.println(x.toString());
                }
            }
            sortbyMoney(list);
            System.out.println();
            System.out.println("Max: " + list.get(list.size() - 1).getName());
            System.out.println("Min: " + list.get(0).getName());
        }
        catch(Exception e){
            System.out.println("File is empty");
        }
    }
    
    public String copyData(String source){
        File oldFile = new File(source);
        if(!oldFile.exists()){
            System.out.println("Path doesn't exist");
            try{
                oldFile.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }
        String result = "";
        try{
            HashSet<String> set = new HashSet<>();
            Scanner read = new Scanner(oldFile);
            while(read.hasNextLine()){
                Scanner s = new Scanner(read.nextLine());
                while(s.hasNext()){
                    String word = s.next();
                    set.add(word + " ");
                }
                for(String content : set){
                    result += content;
                }
                result += "\n";
            }
            read.close();
        }    
        catch(IOException e){
            System.err.println("Can’t read file");
        }
        return result;
    }
    public void writeDatatoNewFile(){
        System.out.println("------------- Copy text --------------");
        System.out.print("Enter source: ");
        String source = enterPath();
        String content = copyData(source);
        System.out.print("Enter new file name: ");
        String newSource = enterPath();
        try{
            File newFile = new File(newSource);
            if(!newFile.exists()){
                try{
                    newFile.createNewFile();
                }
                catch(IOException e){
                    System.out.println("Can’t read file");
                }
            }
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            fw.close();
            System.out.println("Copy done...");
        }
        catch(IOException e){
            System.out.println("Can’t write file"); 
        }
        catch(NullPointerException e){
            System.out.println("Old file is empty");
        }
    }
}
