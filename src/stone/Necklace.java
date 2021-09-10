package stone;

import java.util.Vector;

public class Necklace {
    private Vector<Stone> stones;

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
        int additional = 0;
        for(int i = 0; i<stones.size(); i++){
            additional += stones.get(i).GetWeight().GetValue();
        }
        generalWeight.SetValue(additional);
        return generalWeight;
    }

    //Function for get general price of all rocks
    public Price GeneralPrice(){
        Price generalPrice = new Price();
        for(int i = 0; i<stones.size(); i++){
           generalPrice.sum(stones.get(i).GetPrice().GetValue());
        }
        return generalPrice;
    }

    //Function for sort rocks by weight
    public Vector<Stone> SortByWeight(){
        Vector<Stone> SortedByWeight = new Vector<Stone>(stones.size());
        return SortedByWeight;
    }
}
