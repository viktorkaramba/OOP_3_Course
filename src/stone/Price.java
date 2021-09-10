package stone;

public class Price {
    private double value;

    public Price(double value){
        this.value = value;
    }

    public double GetValue(){
        return this.value;
    }
    public void SetValue(double value){
        this.value = value;
    }

    public void sum(double value){
        this.value += value;
    }

    public Price(){
        this.value = 0.0f;
    }




}
