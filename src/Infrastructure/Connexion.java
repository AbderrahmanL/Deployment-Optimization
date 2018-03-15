package Infrastructure;

/**
 * Created by t460p on 12/01/2018.
 */
public class Connexion {
    private String id;
    private double debit;
    private Server first;
    private Server second;
    public Connexion( double debit, Server first, Server second) {
        this.id = Shared.generateId(first.getId(),second.getId());
        this.debit = debit;
        this.first = first;
        this.second = second;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public Server getFirst() {
        return first;
    }

    public void setFirst(Server first) {
        this.first = first;
    }

    public Server getSecond() {
        return second;
    }

    public void setSecond(Server second) {
        this.second = second;
    }

    public String getId() {
        return id;
    }
}
