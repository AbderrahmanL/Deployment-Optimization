package Infrastructure;

/**
 * Created by t460p on 12/01/2018.
 */
public class Communication {
    private String id;
    private double communicationDataSize;
    private Process first;
    private Process second;

    public Communication(double communicationDataSize, Process first, Process second) {
        this.id = Shared.generateId(first.getId(),second.getId());
        this.communicationDataSize = communicationDataSize;
        this.first = first;
        this.second = second;
    }

    public double getCommunicationDataSize() {
        return communicationDataSize;
    }

    public void setCommunicationDataSize(double communicationDataSize) {
        this.communicationDataSize = communicationDataSize;
    }

    public Process getFirst() {
        return first;
    }

    public void setFirst(Process first) {
        this.first = first;
    }

    public Process getSecond() {
        return second;
    }

    public void setSecond(Process second) {
        this.second = second;
    }

    public String getId() {
        return id;
    }
}
