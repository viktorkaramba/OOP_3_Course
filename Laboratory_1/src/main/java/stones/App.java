package stones;
import database.DBConnection;
import gui.MainWindow;

import java.util.Vector;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MainWindow mw = new MainWindow();
        DBConnection a = new DBConnection();
        a.readInfo();
        Price price1 = new Price(100);
        Price price2 = new Price(55);
        Price price3 = new Price(120);
        Weight weight1 = new Weight(1);
        Weight weight2 = new Weight(2);
        Weight weight3 = new Weight(3);
        Stone firstStone = new Stone(price1,weight1 );
        Stone secondStone = new Stone(price3,weight3 );
        Stone thirdStone = new Stone(price2,weight2);
        Vector<Stone> stones = new Vector<Stone>(3);
        stones.add(firstStone);
        stones.add(secondStone);
        stones.add(thirdStone);
        Necklace necklace = new Necklace(stones);
        necklace.sortByPrice();

        for (Stone h: necklace.getStones()) {
            System.out.println(h.GetPrice().GetValue()+" "+h.GetWeight().GetValue());
        }

        Vector<Stone> result = new Vector<Stone>(necklace.searchByRange(weight1,weight2));
        for (Stone h: result) {
            System.out.println(h.GetPrice().GetValue()+" "+h.GetWeight().GetValue());
        }

    }
}
