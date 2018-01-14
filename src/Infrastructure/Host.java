package Infrastructure;

import java.util.Collection;

/**
 * Created by t460p on 12/01/2018.
 */
public class Host {
    private Collection<Process> processes;
    private Server server;

    public double executionCost(){
        return 0;
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
