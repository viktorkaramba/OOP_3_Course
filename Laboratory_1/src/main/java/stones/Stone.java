package stones;

import java.awt.*;
import java.util.Comparator;

public class Stone {
    private Price price;
    private Weight weight;
    private Image image;
    private String name;

    public Stone(Price price, Weight weight, Image image, String name){
        this.price = new Price(price.getValue());
        this.weight = new Weight(weight.getValue());
        this.image =image;
        this.name = name;
    }

    public Stone(Price price, Weight weight, String name){
        this.price = new Price(price.getValue());
        this.weight = new Weight(weight.getValue());
        this.name = name;
    }

    public Stone(Price price, Weight weight){
        this.price = new Price(price.getValue());
        this.weight = new Weight(weight.getValue());
    }

    public Stone(){
        this.price = new Price(0);
        this.weight = new Weight(0);
        this.name = "Unknown";
    }


    public Weight getWeight(){
        return weight;
    }

    public Price getPrice(){
        return price;
    }

    public Weight setWeight(Weight weight){
        return this.weight = new Weight(weight.getValue());
    }

    public Price setPrice(Price price){
        return this.price = new Price(price.getValue());
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
