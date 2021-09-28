package Manager;

import static Manager.Main.sc;

public class TaskView {
    TaskManager tm = new TaskManager();
    Validate vld = new Validate();
    public void createTask(){
        System.out.println("------------Add Task---------------");
        String requirementName, assignee, taskTypeID, reviewer, date, planFrom, planTo;
        while(true){
            System.out.print("Requirement Name: ");
            requirementName = vld.checkInput();
            System.out.print("Task Type: ");
            taskTypeID = vld.checkTaskType();
            System.out.print("Date: ");
            date = vld.checkDate();
            while(true){
                System.out.print("From: ");
                planFrom = vld.checkPlan();
                System.out.print("To: ");
                planTo = vld.checkPlan();
                if(vld.checkPlanFromTo(planFrom, planTo)){
                   break; 
                }
            }
            System.out.print("Assignee: ");
            assignee = vld.checkInput();
            System.out.print("Reviewer: ");
            reviewer = vld.checkInput();
            int key = tm.addTask(requirementName, assignee, taskTypeID, reviewer, date, planFrom, planTo);
            if(key == -1){
                continue;
            }
            break;
        }
    }
    public void inputID(){
        String id;
        while(true){
            System.out.print("ID: ");
            id = sc.nextLine();
            tm.deleteTask(id);
            if(tm.check == true){
                System.out.println("Delete successfully");
                break;
            }
        }
    }
    public void display(){
        System.out.println("----------------------------------------- Task ---------------------------------------\n" +
                            "ID 	Name			Task Type	Date		Time		Assignee	Reviewer");
        tm.getDataTasks();
        System.out.println();
    }
    public void menu(){
        System.out.println("========= Task program =========");
        while(true){
            try{
                System.out.println("1.	Add Task\n" +
                                "2.	Delete task\n" +
                                "3.	Display Task\n" +
                                "4.	exit");
                System.out.print(">>Your choice: ");
                int choice = Integer.parseInt(sc.nextLine());
                if(choice == 4) break;
                switch(choice){
                    case 1:
                        createTask();
                        break;
                    case 2:
                        inputID();
                        break;
                    case 3:
                        display();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Don't have this choice!");
                        break;
                }
            }catch(NumberFormatException e){
                System.out.println("Wrong format");
                continue;
            }
        }
    }
}
