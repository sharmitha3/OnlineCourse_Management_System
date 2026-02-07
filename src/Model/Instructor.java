package Model;

public class Instructor {
    private Long id;
    private String name;

    public Instructor(Long id,String name)
    {
        this.id=id;
        this.name=name;
    }

    public Long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return id +" " + name;
    }

}
