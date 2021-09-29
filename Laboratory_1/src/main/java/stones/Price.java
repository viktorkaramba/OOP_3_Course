package stones;

/**
 * Using for store price of stone
 * @author Svynar Viktor
 */
public class Price {
    /** Using for store the value*/
    private double value;

    /** Initial field {@link Price#value}*/
    public Price(){
        this.value = 0;
    }

    /** Initial field {@link Price#value}*/
    public Price(double value){
        this.value = value;
    }

    /** Return value of field {@link Price#value}*/
    public double getValue(){
        return this.value;
    }

    /** Set value of field {@link Price#value}*/
    public void setValue(double value){
        this.value = value;
    }

    /** Increases the value of field{@link Price#value}*/
    public void sum(double value){
        this.value += value;
    }
}
