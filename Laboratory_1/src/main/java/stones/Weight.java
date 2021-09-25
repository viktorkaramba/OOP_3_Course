package stones;

/**
 * Using for store price of stone
 * @author Svynar Viktor
 */
public class Weight {
    /** Using for store the value*/
    private int value;

    /** Initial field {@link Weight#value}*/
    public Weight(){
        this.value = 0;
    }

    /** Initial field {@link Weight#value}*/
    public Weight(int value){
        this.value = value;
    }

    /** Return value of field {@link Weight#value}*/
    public int getValue(){
        return this.value;
    }

    /** Set value of field {@link Weight#value}*/
    public void setValue(int value){
        this.value = value;
    }

    /** Increases the value of field{@link Weight#value}*/
    public void sum(int value){
        this.value += value;
    }

}
