package Infrastructure;

import java.util.Collection;
import java.util.List;

/**
 * Created by t460p on 12/01/2018.
 */
public class Server {

    private double processingPower;
    private double ressources;
    private Collection<Connexion> connexions;

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

    public Collection<Connexion> getConnexions() {
        return connexions;
    }

    public void setConnexions(Collection<Connexion> connexions) {
        this.connexions = connexions;
    }
}


