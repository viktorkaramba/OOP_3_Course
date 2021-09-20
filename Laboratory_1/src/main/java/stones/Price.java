package stones;

public class Price {
    private double value;

    public Price(double value){
        this.value = value;
    }

    public double getValue(){
        return this.value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public void sum(double value){
        this.value += value;
    }

    public Price(){
        this.value = 0.0f;
    }

}
