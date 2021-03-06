package Infrastructure;

import java.util.Collection;

/**
 * Created by t460p on 12/01/2018.
 */
public class Host {
    private Collection<Process> processes;
    private Server server;

    public double executionCost(){
        double cost = 0;
        for (Process p : processes){
            cost += p.getWorkLoad();
        }
        return cost;
    }

    public double allocatedRessources(){
        double allocated = 0;
        for (Process p : processes){
            allocated += p.getRequiredRessources();
        }
        return allocated;
    }

    public boolean addProcess(Process p){
        if ( ((executionCost() + p.getWorkLoad()) > server.getProcessingPower()) && ( (allocatedRessources()+p.getRequiredRessources()) <server.getRessources()))
            return false;
        processes.add(p);
        return true;
    }

    public Collection<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(Collection<Process> processes) {
        this.processes = processes;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
