package Manager;

import static Manager.Main.sc;

public class Program {
    Function f = new Function();
    public void menu(){
        while(true){
            try{
                System.out.println("========== File Processing =========");
                System.out.println("1. Find person info.");
                System.out.println("2. Copy Text to new file.");
                System.out.println("3. Exit.");
                System.out.print(">>Your choice: ");
                int choice = Integer.parseInt(sc.nextLine());
                if(choice == 3) break;
                switch(choice){
                    case 1: 
                        f.displayData();
                        sc.nextLine();
                        break;
                    case 2:
                        f.writeDatatoNewFile();
                        sc.nextLine();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Don't have this option!");
                        break;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Wrong format!");
                continue;
            }
        }
    }
}
