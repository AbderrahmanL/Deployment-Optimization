package Infrastructure;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by t460p on 12/01/2018.
 */
public class Deployment {
    Collection<Host> hosts;
    public static double communicationCost;

    public static void generateInitialSolution(){

    }

    public void updateCommunicationCost(){

    }



    public void initializeCommunicationCost(){
        Collection<Host> copieHosts = new ArrayList<>();
        communicationCost = 0;
        double speed = 0;
        double dataSize = 0;
        copieHosts.addAll(hosts);
        for (Host host : copieHosts){
            for (Host h : copieHosts){
                if (!host.equals(h)) {
                    if (InputManager.interServer.containsKey(Shared.generateId(host.getServer().getId(),h.getServer().getId()))) {
                        speed = InputManager.interServer.get(Shared.generateId(host.getServer().getId(),h.getServer().getId())).getDebit();
                    } else {
                        speed = InputManager.interServer.get(Shared.generateId(h.getServer().getId(),host.getServer().getId())).getDebit();
                    }
                    for (Process proc : host.getProcesses()){
                        for (Process p : h.getProcesses()){
                            if (InputManager.interProcess.containsKey(Shared.generateId(proc.getId(),p.getId()))) {
                                dataSize = InputManager.interProcess.get(Shared.generateId(proc.getId(),p.getId())).getCommunicationDataSize();
                            } else {
                                dataSize = InputManager.interProcess.get(Shared.generateId(p.getId(),proc.getId())).getCommunicationDataSize();
                            }
                            communicationCost += dataSize/speed;
                        }
                    }
                }
            }
            copieHosts.remove(host);
        }
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
}
