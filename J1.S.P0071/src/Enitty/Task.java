package Enitty;

import java.util.Date;

public class Task {
    private int id;
    private String taskType;
    private String requirementName;
    private String assignee;
    private String date;
    private double planFrom;
    private double planTo;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String taskType, String requirementName, String assignee, String date, double planFrom, double planTo, String reviewer) {
        this.id = id;
        int xTaskType = Integer.parseInt(taskType);
        switch(xTaskType){
            case 1:
                this.taskType = "Code";
                break;
            case 2:
                this.taskType = "Test";
                break;
            case 3:
                this.taskType = "Design";
                break;
            case 4:
                this.taskType = "Review";
                break;
        }
        this.requirementName = requirementName;
        this.assignee = assignee;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }
    
    public String getTaskType() {
        return taskType;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getDate() {
        return date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public String getReviewer() {
        return reviewer;
    }
    public String toString(){
        return String.format("%13s     %12s    %18s   %6.1f     %13s   %14s", requirementName, taskType, date, planTo - planFrom, assignee, reviewer);
    }
}
