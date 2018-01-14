package Infrastructure;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by t460p on 12/01/2018.
 */
public class Deployment {
    Collection<Host> hosts;
    double CommunicationCost;

    public Deployment(){
    }

    public void updateCommunicationCost(){

    }


    public double totalExecutionCost(){
        double totalCost = 0;
        for (Host h : hosts){
            totalCost += h.executionCost();
        }
        return totalCost;
    }

    public Collection<Host> getHosts() {
        return hosts;
    }

    public void setHosts(Collection<Host> hosts) {
        this.hosts = hosts;
    }

    public double getCommunicationCost() {
        return CommunicationCost;
    }
}
