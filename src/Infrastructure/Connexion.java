package Infrastructure;

/**
 * Created by t460p on 12/01/2018.
 */
public class Connexion {
    private double debit;
    private Server first;
    private Server second;

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
}
