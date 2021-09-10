package stone;

import java.awt.*;

public class Stone {
    private Price price;
    private Weight weight;
    private Image image;
    public Stone(Price price, Weight weight, Image image){
        this.price = new Price(price.GetValue());
        this.weight = new Weight(weight.GetValue());
        this.image = image;
    }

    public Weight GetWeight(){
        return weight;
    }

    public Price GetPrice(){
        return price;
    }

    public Weight SetWeight(Weight weight){
        return this.weight = new Weight(weight.GetValue());
    }

    public Price SetPrice(Price price){
        return this.price = new Price(price.GetValue());
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
