
import java.util.*;

public class ManageEastAsiaCountries implements IManageEastAsiaCountries{
    List<EastAsiaCountries> t = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    @Override
    public void addCountryInformation(EastAsiaCountries country) throws Exception, InputMismatchException {
        while(t.size() != 2){
            try{
                System.out.print("Enter country ID: ");
                String xID = sc.next();
                sc.nextLine();
                System.out.print("Enter country name: ");
                String xName = sc.nextLine();
                System.out.print("Enter total area of country: ");
                Float xTotal = Float.parseFloat(sc.nextLine());
                if(xTotal <= 0) throw new MyException("Total area must be greater than 0");
                System.out.print("Enter country terrian: ");
                String xTerrian = sc.nextLine();
                country = new EastAsiaCountries(xID, xName, xTotal, xTerrian);
                if(t.contains(country)) throw new MyException("ID has exist in list");
                else
                    t.add(country);
            }
            catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
            catch(InputMismatchException e){
                System.out.println("Wrong format!!");
                continue;
            }
        }
    }            
    @Override
    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        EastAsiaCountries x = new EastAsiaCountries();
        if(t.size() == 0){
            System.out.println("No detail");
            return null;
        }
        return x;
    }

    @Override
    public EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        if(t.size() == 0){
            System.out.println("No detail!!");
            return null;
        }
        EastAsiaCountries[] arr = new EastAsiaCountries[t.size()];
        int count=0;
        for (EastAsiaCountries x : t) {
            if(x.getCountryName().equalsIgnoreCase(name)){
                arr[count++] = x;
            }
        }
        return arr;
    }
    @Override
    public EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception {
        Collections.sort(t, new Comparator<EastAsiaCountries>(){
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryCode().compareTo(o2.getCountryCode());
            }
            
        });
        Object[] arrOld = t.toArray();
        EastAsiaCountries[] arrNew = new EastAsiaCountries[t.size()];
        for (int i = 0; i < arrOld.length; i++) {
            arrNew[i] = (EastAsiaCountries)arrOld[i];
        }
        return arrNew;
    }
    public void program() throws Exception{
        System.out.println("                               MENU\n" +
"==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia\n" +
"2. Display the information of country you've just input\n" +
"3. Search the information of country by user-entered name\n" +
"4. Display the information of countries sorted name in ascending order  \n" +
"5. Exit ");
        EastAsiaCountries x = new EastAsiaCountries();
        System.out.println("==========================================================================");
        while(true){
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice == 5) break;
            switch(choice){
                case 1:
                    addCountryInformation(x);
                    break;
                case 2:
                    System.out.println("ID              Name            Total Area      Terrain         ");
                    for (EastAsiaCountries y : t) {
                        x = y;
                        x.display();
                    }
                    break;
                case 3:
                    System.out.print("Enter the name you want to search for: ");
                    String xName = sc.nextLine();
                    EastAsiaCountries[] arr = searchInformationByName(xName);
                    System.out.println("ID              Name            Total Area      Terrain         ");
                    for (int i = 0; i < arr.length; i++) {
                        arr[i].display();
                        break;
                    }
                    break;
                case 4:
                    EastAsiaCountries[] arr1 = sortInformationByAscendingOrder();
                    System.out.println("ID              Name            Total Area      Terrain         ");
                    for (int i = 0; i < arr1.length; i++) {
                        arr1[i].display();
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Wrong format!!");
                    break;
            }
        }
    }
    
}
