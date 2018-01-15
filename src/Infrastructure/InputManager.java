package Infrastructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InputManager {
    public static Map<String,Communication> interProcess = new HashMap<>();
    public static Map<String,Connexion> interServer = new HashMap<>();
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
                if (!server.equals(serv)){
                    //TODO replace Math.random() with the value from input
                    Connexion conn = new Connexion(Math.random() * 100, server, serv);
                    interServer.put(conn.getId(),conn);
                }
            }
            copieServers.remove(server);
        }

        Collection<Process> copieProcesses = new ArrayList<>();
        for (Process process : copieProcesses){
            for (Process proc : copieProcesses)
            {
                if (!process.equals(proc)){
                    //TODO replace Math.random() with the value from input
                    Communication comm = new Communication(Math.random() * 100, process, proc);
                    interProcess.put(comm.getId(),comm);
                }
            }
            copieProcesses.remove(process);
        }

    }
}
