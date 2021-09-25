package stones;

import java.util.Vector;

/**
 *
 * @author Svynar Viktor
 */
public class Necklace {

    /** Using for store of stones*/
    private Vector<Stone> stones;

    /** Initial field {@link  Necklace#stones}*/
    public Necklace(){
        this.stones = new Vector<Stone>();
    }

    /** Initial field {@link  Necklace#stones}*/
    public Necklace(Vector<Stone> stones){
        this.stones = new Vector<Stone>(stones);
    }

    /** Return value of field {@link Necklace#stones}*/
    public Vector<Stone> getStones(){
        return this.stones;
    }

    /** Set value of field {@link  Necklace#stones}*/
    public void setStones(Vector<Stone> stones){
        this.stones = stones;
    }

    /**Function for add stone to vector*/
    public void addStone(Stone stone){
        stones.add(stone);
    }

    /** Function for get general weight of all stones*/
    public Weight generalWeight(){
        Weight generalWeight = new Weight();
        for(int i = 0; i<stones.size(); i++){
            generalWeight.sum(stones.get(i).getWeight().getValue());
        }
        return generalWeight;
    }

    /** Function for get general price of all stones*/
    public Price generalPrice(){
        Price generalPrice = new Price();
        for(int i = 0; i<stones.size(); i++){
           generalPrice.sum(stones.get(i).getPrice().getValue());
        }
        return generalPrice;
    }

    /** Function for sort stones by price*/
    public void sortByPrice(){
        PriceComparator myPriceComparator = new PriceComparator();
        stones.sort(myPriceComparator);
    }

    /** Function for search stones by range*/
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
