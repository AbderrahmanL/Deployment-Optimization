package Infrastructure;

import java.util.ArrayList;
import java.util.Collection;

public class InputManager {
    public static Collection<Communication> interProcess = new ArrayList<>();
    public static Collection<Connexion> interServer = new ArrayList<>();
    public static Collection<Process> processes;
    public static Collection<Server> servers;

    public static void fillLists(){
        //TODO read processes
        //TODO read servers
        Collection<Server> copieServers = new ArrayList<>();
        copieServers.addAll(servers);
        for (Server server : copieServers){
            for (Server serv : copieServers)
            {
                if (server.equals(serv))
                    continue;
                else {
                    //TODO replace Math.random() with the value from input
                    Connexion conn = new Connexion(Math.random() * 100, server, serv);
                    interServer.add(conn);
                }
            }
            copieServers.remove(server);
        }

        Collection<Process> copieProcesses = new ArrayList<>();
        for (Process process : copieProcesses){
            for (Process proc : copieProcesses)
            {
                if (process.equals(proc))
                    continue;
                else {
                    //TODO replace Math.random() with the value from input
                    Communication comm = new Communication(Math.random() * 100, process, proc);
                    interProcess.add(comm);
                }
            }
            copieProcesses.remove(process);
        }

    }
}
