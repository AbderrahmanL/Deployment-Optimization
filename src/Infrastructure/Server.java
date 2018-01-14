package Infrastructure;

import java.util.Collection;
import java.util.List;

/**
 * Created by t460p on 12/01/2018.
 */
public class Server {
    private int id;
    private double processingPower;
    private double ressources;

    public Server(int id, double processingPower, double ressources) {
        this.id = id;
        this.processingPower = processingPower;
        this.ressources = ressources;
    }

    public double getProcessingPower() {
        return processingPower;
    }

    public void setProcessingPower(double processingPower) {
        this.processingPower = processingPower;
    }

    public double getRessources() {
        return ressources;
    }

    public void setRessources(double ressources) {
        this.ressources = ressources;
    }

    public int getId() {
        return id;
    }
}


