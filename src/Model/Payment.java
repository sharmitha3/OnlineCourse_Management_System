package Model;

public class Payment {
    private Long id;
    private double amount;

    public Payment(Long id, double amount){
        this.id = id;
        this.amount = amount;
    }

    public String toString(){
        return "Payment:" + id + " Amount:" + amount;
    }
}

