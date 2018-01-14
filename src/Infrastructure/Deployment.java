package Infrastructure;

import java.util.Collection;

/**
 * Created by t460p on 12/01/2018.
 */
public class Deployment {
    public double communicationCost(){
        return 0;
    }
    Collection<Host> hosts;
    public double totalExecutionCost(){
        return 0;
    }

    public Collection<Host> getHosts() {
        return hosts;
    }

    public void setHosts(Collection<Host> hosts) {
        this.hosts = hosts;
    }
}
