import database.DBConnection;
import gui.MainWindow;
import stones.Necklace;
import stones.Stone;

import java.util.Scanner;
import java.util.Vector;
import java.util.Random;
/**
 * Using for start the program
 * @author Svynar Viktor
 */
public class App 
{
    public static void main(String[] args )
    {
        DBConnection a = new DBConnection();
        Necklace necklace = new Necklace();
        for(int i = 0; i<a.readInfo().size(); i++) {
            Random value = new Random();
            int c = value.nextInt(9);
            if(c % 2 ==0) {
                necklace.addStone(a.readInfo().get(i));
            }
        }
        //MainWindow mw = new MainWindow(necklace);
        System.out.println("1. General weight\n2. General price\n3. Sort\n4. Search by range\n");
        int key;
        Scanner in = new Scanner(System.in);
        key = in.nextInt();
        switch (key){
            case 1:
                System.out.println(necklace.generalWeight().getValue() + " carats");
                break;
            case 2:
                System.out.println(necklace.generalPrice().getValue() + "$");
                break;
            case 3:
                necklace.sortByPrice();
                for(Stone s: necklace.getStones()){
                    System.out.println( s.getName() + " , " +  s.getPrice().getValue() + " , " + s.getWeight().getValue() + " , " + s.getTransparency());
                }
                break;
            case 4:
                double min = 0;
                double max = 0;
                Scanner inMin = new Scanner(System.in);
                if(inMin.hasNextDouble()) {
                    min = inMin.nextDouble();
                }
                Scanner inMax = new Scanner(System.in);
                if(inMax.hasNextDouble()) {
                    max = inMax.nextDouble();
                }
                System.out.println(max);
                Vector<Stone> stones = new Vector<Stone>(necklace.searchByRange(min,max));
                for(Stone s: stones){
                    System.out.println( s.getName() + " " +  s.getPrice().getValue() + " " + s.getWeight().getValue() + " " + s.getTransparency());
                }
                break;
        }
    }
}
