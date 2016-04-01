import java.util.*;

/**
 * Created by Umar on 01-Apr-16.
 */
public class TowerHanoi {
    static int N=8;
    public static Stack<Integer>[] hanoiTower = new Stack[4];
    public static List<List<Integer>>[] states = new List[4];
    public static List<HashMap<Integer,Integer>>[] moves = new List[4];
//    public static HashMap<String,List<>>
//    public static List<> [] state = new
    public static void main(String[] args)
    {
        hanoiTower[1] = new Stack<Integer>();
        hanoiTower[2] = new Stack<Integer>();
        hanoiTower[3] = new Stack<Integer>();
        states[1]= new ArrayList<>();
        states[2]= new ArrayList<>();
        states[3]= new ArrayList<>();
        moves[1]= new ArrayList<>();
        moves[2]= new ArrayList<>();
        moves[3]= new ArrayList<>();
        buildTower(8);
        DisplayStates();
        DisplayMoves();
    }
    public static void buildTower(int n)
    {
        for (int d = n; d > 0; d--)
            hanoiTower[1].push(d);
        SolveIt(n, 1, 2, 3);

    }
    public static void SolveIt(int n, int a, int b, int c)
    {
        if (n > 0)
        {
            SolveIt(n-1, a, c, b);

            int d = hanoiTower[a].pop();
            hanoiTower[c].push(d);
            // Store Moves
            HashMap<Integer,Integer> srctodes= new HashMap<>();
            srctodes.put(a,c);
            moves[a].add(srctodes);
            HashMap<Integer,Integer> dts= new HashMap<>();
            dts.put(c,a);
            moves[c].add(dts);
            // Stores state
            List<Integer> sa= new ArrayList<>();
            for(int i=0;i<hanoiTower[a].size();i++){
                sa.add(hanoiTower[a].get(i));
            }
            states[a].add(sa);

            List<Integer> sb= new ArrayList<>();
            for(int i=0;i<hanoiTower[b].size();i++){
                sb.add(hanoiTower[b].get(i));
            }
            states[b].add(sb);

            List<Integer> sc= new ArrayList<>();
            for(int i=0;i<hanoiTower[c].size();i++){
                sc.add(hanoiTower[c].get(i));
            }
            states[c].add(sc);
            SolveIt(n-1, b, a, c);
        }
    }
    public static void DisplayStates(){
        System.out.println("State of A");
         for (int i=0;i<states[1].size();i++){
             for (int j=0;j<states[1].get(i).size();j++){
                 System.out.print(states[1].get(i).get(j)+" ");
             }
             System.out.println();
         }
        System.out.println("\nState of B");
        for (int i=0;i<states[2].size();i++){
            for (int j=0;j<states[2].get(i).size();j++){
                System.out.print(states[2].get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println("\nState of C");
        for (int i=0;i<states[3].size();i++){
            for (int j=0;j<states[3].get(i).size();j++){
                System.out.print(states[3].get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public  static void DisplayMoves(){
        System.out.println("Moves From  1 to ");
        for (int i=0;i<moves[1].size();i++){
            System.out.println("1 TO "+moves[1].get(i).get(1));

        }
        System.out.println("Moves From  2 to ");
        for (int i=0;i<moves[2].size();i++){
            System.out.println("2 TO "+moves[2].get(i).get(2));

        }
        System.out.println("Moves From  3 to ");
        for (int i=0;i<moves[3].size();i++){
            System.out.println("3 TO "+moves[3].get(i).get(3));

        }
    }
}
