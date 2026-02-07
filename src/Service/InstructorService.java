package Service;

import Model.Instructor;
import Repo.Respositorydb;

public class InstructorService {
    private Respositorydb repo;

    public InstructorService(Respositorydb repo) {
        this.repo = repo;
    }

    public void addInstructor(Long id, String name) {
        Instructor i = new Instructor(id, name);
        repo.instructors.add(i);
        System.out.println("Instructor added: " + i.getName());
    }

    public Instructor findInstructor(Long id) {
        for (Instructor i : repo.instructors) {
            if (i.getId().equals(id)) return i;
        }
        return null;
    }
}
