package Manager;

import Enitty.Task;
import java.util.*;


public class TaskManager {
    ArrayList<Task> list = new ArrayList<>();
    Validate vld = new Validate();
    boolean check;
    public int addTask(String requirementName, String assignee, String taskTypeID, String reviewer, String date, String planFrom, String planTo){
        int lastIndex = list.indexOf(list.get(list.size() - 1));
        Task x = new Task(lastIndex +1 ,taskTypeID, requirementName, assignee, date, Double.parseDouble(planFrom), Double.parseDouble(planTo), reviewer);
        return lastIndex + 1;
    }
    public boolean searchID(int id, HashMap<Integer, Task> map){
        Set<Integer> key = map.keySet();
        for (Integer x : key) {
            if(x == id){
                return true;
            }
        }
        return false;
    }
    public void deleteTask(String id){
        try{
            int xId= Integer.parseInt(id);
            if(!searchID(xId, map)) throw new MyException("Can not find ID in data");
            else{
                map.remove(xId);
                check = true;
            }
        }
        catch(NumberFormatException e){
            System.out.println("Wrong format");
            check = false;
        }
        catch(MyException e){
            System.out.println(e.getMessage());
            check = false;
        }
    }
    public void getDataTasks(){
        Set<Integer> key = map.keySet();
        for (Integer x : key) {
            System.out.println(x +"     " + map.get(x).toString());
        }
    }
}
