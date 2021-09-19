package stones;

import java.util.Vector;
import java.util.Comparator;

public class Necklace {
    private Vector<Stone> stones;

    public Vector<Stone> getStones(){
        return this.stones;
    }

    public void setStones(Vector<Stone> stones){
        this.stones = stones;
    }

    //Constructor with one parameter
    public Necklace(Vector<Stone> stones){
        this.stones = new Vector<Stone>(stones);
    }

    //Function for add rock to necklace
    public void addStone(Stone stone){
        stones.add(stone);
    }

    //Function for get general weight of all rocks
    public Weight generalWeight(){
        Weight generalWeight = new Weight();
        for(int i = 0; i<stones.size(); i++){
            generalWeight.sum(stones.get(i).GetWeight().GetValue());
        }
        return generalWeight;
    }

    //Function for get general price of all rocks
    public Price generalPrice(){
        Price generalPrice = new Price();
        for(int i = 0; i<stones.size(); i++){
           generalPrice.sum(stones.get(i).GetPrice().GetValue());
        }
        return generalPrice;
    }


    //Function for sort stone by price
    public void sortByPrice(){
        PriceComparator myPriceComparator = new PriceComparator();
        stones.sort(myPriceComparator);
    }

    public Vector<Stone> searchByRange(Weight weight1, Weight weight2){
        Vector<Stone> suitableStone = new Vector<Stone>();
        for(int i = 0; i<stones.size(); i++){
            if((stones.get(i).GetWeight().GetValue() >= weight1.GetValue())
                    && (stones.get(i).GetWeight().GetValue()<=weight2.GetValue()) ){
                suitableStone.add(stones.get(i));
            }
        }
        return suitableStone;
    }
}
