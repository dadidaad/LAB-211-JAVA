public class FruitMenu {
    FruitShop fs = new FruitShop();
    Validate vld = new Validate();
    public void createFruit(){
        while(true){
        System.out.print("Enter ID of fruit: ");
        String xId = vld.checkInput();
        System.out.print("Enter name of fruit: ");
        String xName = vld.checkInput();
        System.out.print("Enter price of fruit: ");
        int xPrice = vld.checkInt();
        System.out.print("Enter quantity of fruit: ");
        int xQuan = vld.checkInt();
        System.out.print("Enter Origin of fruit: ");
        String xOrigin = vld.checkInput();
        boolean checkExist = fs.create(xId, xName, xPrice, xQuan, xOrigin);
        if(checkExist == false){
            System.out.println("ID has been exist in List");
            continue;
        }
        System.out.print("Do you want to continue(Y/N): ");
        char choice = vld.checkChoice();
        if(choice == 'Y'){
            continue;
        }
        else
            System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ |  ++ Price ++ |");
            fs.showList();
            break;
        }
    }
    public void viewOrder(){
        fs.viewOrders();
    }
    public void shopping(){
        fs.showShopping();
        while(true){
            System.out.print("Your choice: ");
            int indexOfItem = vld.checkInt();
            Fruit x = fs.searchChoice(indexOfItem);
            if(x == null){
                System.out.println("Store is empty");
                break;
            }
            System.out.println("You select: " + x.getFruitName());
            System.out.print("Please input quantity: ");
            int xQuan;
            while(true){
                xQuan = vld.checkInt();
                if(xQuan > x.getQuan()){
                    System.out.println("There only " + x.getQuan() +" in store! Try again");
                    continue;
                }
                break;
            }
            fs.addOrder(x, xQuan);
            System.out.print("Do you want to order now(Y/N): ");
            char choice = vld.checkChoice();
            if(choice == 'N'){
                continue;
            }
            else{
                System.out.println("Product | Quantity | Price | Amount");
                System.out.println("Total: "+ fs.getTotalOrder()+"$");
                System.out.print("Input your name: ");
                String xName = vld.checkInput();
                fs.shopping(xName);
                break;
            }
        }
    }
    public void mainMenu(){
        while(true){
            System.out.println("FRUIT SHOP SYSTEM\n" +
                                "1.	Create Fruit\n" +
                                "2.	View orders\n" +
                                "3.	Shopping (for buyer)\n" +
                                "4.	Exit\n" +
                                " (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).");
            System.out.print("Your choice: ");
            int choice = vld.checkInt();
            if(choice == 4) break;
            switch(choice){
                case 1:
                    createFruit();
                    break;
                case 2:
                    viewOrder();
                    break;
                case 3:
                    shopping();
                    break;
                default:
                    System.out.println("Don't have this option!");
                    break;
            }
        }
    }
}
