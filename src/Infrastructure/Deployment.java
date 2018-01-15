package Infrastructure;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by t460p on 12/01/2018.
 */
public class Deployment {
    Collection<Host> hosts;
    public static double communicationCost;

    public Deployment(){
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
                    if (InputManager.interServer.containsKey(String.valueOf(host.hashCode()) + String.valueOf(h.hashCode()))) {
                        speed = InputManager.interServer.get(String.valueOf(host.hashCode()) + String.valueOf(h.hashCode())).getDebit();
                    } else {
                        speed = InputManager.interServer.get(String.valueOf(h.hashCode()) + String.valueOf(host.hashCode())).getDebit();
                    }
                    for (Process proc : host.getProcesses()){
                        for (Process p : h.getProcesses()){
                            if (InputManager.interProcess.containsKey(String.valueOf(proc.hashCode()) + String.valueOf(p.hashCode()))) {
                                dataSize = InputManager.interProcess.get(String.valueOf(proc.hashCode()) + String.valueOf(p.hashCode())).getCommunicationDataSize();
                            } else {
                                dataSize = InputManager.interProcess.get(String.valueOf(p.hashCode()) + String.valueOf(proc.hashCode())).getCommunicationDataSize();
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
