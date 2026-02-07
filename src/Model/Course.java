package Model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private Long id;
    private String title;
    private Instructor instructor;
    private boolean paid;
    private List<String> assignments = new ArrayList<>();

    public Course(Long id, String title, Instructor instructor, boolean paid){
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.paid = paid;
    }

    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public Instructor getInstructor(){
        return instructor;
    }
    public boolean isPaid(){
        return paid;
    }

    public void addAssignment(String title){
        assignments.add(title);
    }

    public List<String> getAssignments(){
        return assignments;
    }

    public String toString(){
        return id + " " + title + " Paid:" + paid + " Instructor:" + instructor.getName();
    }
}
