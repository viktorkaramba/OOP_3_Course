package stones;

public class Weight {
    private int value;

    public Weight(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value = value;
    }
    public void sum(int value){
        this.value += value;
    }

    public Weight(){
        this.value = 0;
    }
}
