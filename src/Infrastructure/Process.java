package Infrastructure;

import java.util.Collection;

/**
 * Created by t460p on 12/01/2018.
 */
public class Process {
    private double workLoad;
    private double requiredRessources;
    private Collection<Communication> communications;

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

    public Collection<Communication> getCommunications() {
        return communications;
    }

    public void setCommunications(Collection<Communication> communications) {
        this.communications = communications;
    }
}
