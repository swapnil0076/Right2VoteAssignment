import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    static Set<String> list = new HashSet<>();

    public static void solve(int tS,int je1,int ja){

        int tShirt = 50;
        int jeans = 80;
        int jacket = 100;
        int budget = 600;

        StringBuilder  sb = new StringBuilder();

        if((tShirt+jeans+jacket)>budget){
            return;
        }

        if(budget-(tShirt*tS+jeans*je1+jacket*ja) < tShirt && budget-(tShirt*tS+jeans*je1+jacket*ja) >= 0){
            int remaing = budget-(tShirt*tS+jeans*je1+jacket*ja);
            sb.append("tShirt :- " + tS +", jeans :- "+je1 +", jacket :-"+ja+" budget :- "+remaing+"\n");
            list.add(sb.toString());
            return;
        }

        if(tShirt*tS < budget) {
            solve(tS + 1, je1, ja);
        }

        if(jeans*je1 < budget) {
            solve(tS, je1 + 1, ja);
        }
        if(jacket*ja < budget) {
            solve(tS, je1, ja + 1);
        }


    }

    public static void main(String[] args) {

        solve(1,1,1);

        System.out.println(list);
    }
}