package stone;

public class Weight {
    private int value;

    public Weight(int value){
        this.value = value;
    }

    public int GetValue(){
        return this.value;
    }
    public void SetValue(int value){
        this.value = value;
    }

    public Weight(){
        this.value = 0;
    }
}
