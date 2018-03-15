package Infrastructure;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static Infrastructure.Shared.randomWithRange;

public class InputManager {
    private static final int SERVERS_NUMBER = 30;
    private static final int PROCESSES_NUMBER = 50;
    public static Map<String,Communication> interProcess = new HashMap<>();
    public static Map<String,Connexion> interServer = new HashMap<>();
    public static Collection<Process> processes = new ArrayList<>();
    public static Collection<Server> servers = new ArrayList<>();

    public static void readServers(String filePath){
        String line = "";
        String[] coords;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            Gson gson = new Gson();
//			while((line = reader.readLine())!= null){
            for(int i = 0; i<SERVERS_NUMBER ; i++) {
                line = reader.readLine();
                servers.add(gson.fromJson(line,Server.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readProcesses(String filePath){
        String line = "";
        String[] coords;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            Gson gson = new Gson();
//			while((line = reader.readLine())!= null){
            for(int i = 0; i<PROCESSES_NUMBER ; i++) {
                line = reader.readLine();
                processes.add(gson.fromJson(line,Process.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillMaps(){
        readProcesses("src/Infrastructure/processes.json");
        readServers("src/Infrastructure/servers.json");
        Collection<Server> copieServers = new ArrayList<>();
        copieServers.addAll(servers);
        for (Server server : servers){
            for (Server serv : copieServers)
            {
                if (!server.equals(serv)){
                    //TODO replace Math.random() with the value from input
                    Connexion conn = new Connexion(randomWithRange(10,100), server, serv);
                    interServer.put(conn.getId(),conn);
                    System.out.println(new Gson().toJson(conn));
                }
            }
            copieServers.remove(server);
        }

        Collection<Process> copieProcesses = new ArrayList<>();
        copieProcesses.addAll(processes);
        for (Process process : processes){
            for (Process proc : copieProcesses)
            {
                if (!process.equals(proc)){
                    //TODO replace Math.random() with the value from input
                    Communication comm = new Communication(randomWithRange(4,2000), process, proc);
                    interProcess.put(comm.getId(),comm);
                    System.out.println(new Gson().toJson(comm));
                }
            }
            copieProcesses.remove(process);
        }

    }

    public static int calculateNumberOfLinks(){
        int s = 0;
        for (int i = SERVERS_NUMBER-1 ; i>0 ; i--){
            s+=i;
        }
        return s;
    }

    public static int calculateNumberOfComms(){
        int s = 0;
        for (int i = PROCESSES_NUMBER-1 ; i>0 ; i--){
            s+=i;
        }
        return s;
    }

    public static void readConxSpeed(String filePath){
        String line = "";
        String[] coords;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            Gson gson = new Gson();
//			while((line = reader.readLine())!= null){
            for(int i = 0; i<calculateNumberOfLinks() ; i++) {
                line = reader.readLine();
                interServer.put(gson.fromJson(line,Connexion.class).getId(),gson.fromJson(line,Connexion.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCommSize(String filePath){
        String line = "";
        String[] coords;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            Gson gson = new Gson();
//			while((line = reader.readLine())!= null){
            for(int i = 0; i<calculateNumberOfComms() ; i++) {
                line = reader.readLine();
                interProcess.put(gson.fromJson(line,Communication.class).getId(),gson.fromJson(line,Communication.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateServers(){
        for (int i=0; i<100 ; i++) {
            Gson gson = new Gson();
            Server rand = new Server(i, randomWithRange(1800, 3500), randomWithRange(8, 32));
            System.out.println(gson.toJson(rand));
        }
    }

    public static void generateProcesses(){
        for (int i=0; i<150 ; i++) {
            Gson gson = new Gson();
            Process rand = new Process(i, randomWithRange(400, 2800), randomWithRange(1, 24));
            System.out.println(gson.toJson(rand));
        }
    }
}
