package Infrastructure;

import java.util.Collection;

/**
 * Created by t460p on 12/01/2018.
 */
public class Process {
    private int id;
    private double workLoad;
    private double requiredRessources;

    public Process(int id, double workLoad, double requiredRessources) {
        this.id = id;
        this.workLoad = workLoad;
        this.requiredRessources = requiredRessources;
    }

    public double getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(double workLoad) {
        this.workLoad = workLoad;
    }

    public double getRequiredRessources() {
        return requiredRessources;
    }

    public void setRequiredRessources(double requiredRessources) {
        this.requiredRessources = requiredRessources;
    }

    public int getId() {
        return id;
    }
}
