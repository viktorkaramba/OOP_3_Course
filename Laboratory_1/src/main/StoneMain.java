package main;

import database.DBConnection;
import stone.*;

import java.util.ArrayList;
import java.util.Vector;

public class StoneMain {
    public static  void main(String[] args){

        DBConnection a = new DBConnection();
        a.readInfo();
        Price price1 = new Price(100);
        Price price2 = new Price(55);
        Price price3 = new Price(12);
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
