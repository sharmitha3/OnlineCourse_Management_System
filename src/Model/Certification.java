package Model;

public class Certification {
    private Long id;
    private String code;

    public Certification(Long id, String code){
        this.id = id;
        this.code = code;
    }

    public String getCode(){ return code; }

    public String toString(){
        return code;
    }
}

