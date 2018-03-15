package Infrastructure;

public class Shared {
    public static String generateId(int a, int b){
        String tmp = ""+a;
        int zeros = 4-tmp.length();
        for (int i = 0 ; i<zeros ; i++){
            tmp = "0"+tmp;
        }
        tmp = b+tmp;
        zeros = 8-tmp.length();
        for (int i = 0 ; i<zeros ; i++){
            tmp = "0"+tmp;
        }
         return tmp;
    }

    static int randomWithRange(int min, int max)
    {
        int range = Math.abs(max - min);
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }
}
