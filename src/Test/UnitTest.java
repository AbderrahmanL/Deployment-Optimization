package Test;

import Infrastructure.Deployment;
import Infrastructure.Host;
import Infrastructure.Server;

import java.util.HashMap;

public class UnitTest {
    public static void main(String[] args){
        Server s1 = new Server();
        Server s2 = new Server();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.hashCode()+s2.hashCode());
    }
}
