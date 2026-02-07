package Model;

public class Assignment {
    private String title;
    private boolean completed = false;
    private Integer marks = null;

    public Assignment(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }


    public boolean isCompleted(){
        return completed;
    }
    public void markCompleted(){
        completed = true;
    }

    public Integer getMarks(){
        return marks;
    }
    public void setMarks(int marks){
        this.marks = marks;
    }

    public String toString(){
        return title + " Completed:" + completed + " Marks:" + (marks!=null ? marks : "Not graded");
    }
}

