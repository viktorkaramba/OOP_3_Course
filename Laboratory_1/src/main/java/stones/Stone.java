package stones;

import java.awt.*;
import java.util.Comparator;

public class Stone {
    private Price price;
    private Weight weight;
    private Image image;
    private String name;

    public Stone(Price price, Weight weight, Image image, String name){
        this.price = new Price(price.GetValue());
        this.weight = new Weight(weight.GetValue());
        this.image = image;
        this.name = name;
    }

    public Stone(Price price, Weight weight, String name){
        this.price = new Price(price.GetValue());
        this.weight = new Weight(weight.GetValue());
        this.name = name;
    }

    public Stone(Price price, Weight weight){
        this.price = new Price(price.GetValue());
        this.weight = new Weight(weight.GetValue());
    }

    public Stone(Price price){
        this.price = new Price(price.GetValue());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
