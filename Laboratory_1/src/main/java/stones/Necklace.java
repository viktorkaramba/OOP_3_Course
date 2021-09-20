package stones;

import java.io.IOException;
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

    public Necklace(){
       this.stones = new Vector<Stone>(15);
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
            generalWeight.sum(stones.get(i).getWeight().getValue());
        }
        return generalWeight;
    }

    //Function for get general price of all rocks
    public Price generalPrice(){
        Price generalPrice = new Price();
        for(int i = 0; i<stones.size(); i++){
           generalPrice.sum(stones.get(i).getPrice().getValue());
        }
        return generalPrice;
    }


    //Function for sort stone by price
    public void sortByPrice(){
        PriceComparator myPriceComparator = new PriceComparator();
        stones.sort(myPriceComparator);
    }

    public Vector<Stone> searchByRange(Weight weight1, Weight weight2) {
        Vector<Stone> suitableStones = new Vector<Stone>();
        for (int i = 0; i < stones.size(); i++) {
            if ((stones.get(i).getWeight().getValue() >= weight1.getValue())
                    && (stones.get(i).getWeight().getValue() <= weight2.getValue())) {
                suitableStones.add(stones.get(i));
            }
        }
        return suitableStones;
    }
}
