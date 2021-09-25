package stones;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;

/**
 * Basic class of the hierarchy
 * @author Svynar Viktor
 */

public class Stone {

    /** Using for store the price of stone*/
    private Price price;

    /** Using for store the weight of stone*/
    private Weight weight;

    /** Using for store the image of stone*/
    private Image image;

    /** Using for store the name of stone*/
    private String name;

    /** Initial field {@link Stone#price}, {@link Stone#weight}, {@link Stone#image}, {@link Stone#name}*/
    public Stone(){
        this.price = new Price(0);
        this.weight = new Weight(0);
        this.name = "Unknown";
        ImageIcon additional = new ImageIcon("Laboratory_1/src/main/resources/unknown.png");
        this.image = additional.getImage();
    }

    /** Initial field {@link Stone#price}, {@link Stone#weight}, {@link Stone#image}, {@link Stone#name}*/
    public Stone(Price price, Weight weight, Image image, String name){
        this.price = new Price(price.getValue());
        this.weight = new Weight(weight.getValue());
        this.image =image;
        this.name = name;
    }

    /** Initial field {@link Stone#price}, {@link Stone#weight}, {@link Stone#name}*/
    public Stone(Price price, Weight weight, String name){
        this.price = new Price(price.getValue());
        this.weight = new Weight(weight.getValue());
        this.name = name;
    }

    /** Initial field {@link Stone#price}, {@link Stone#weight}*/
    public Stone(Price price, Weight weight){
        this.price = new Price(price.getValue());
        this.weight = new Weight(weight.getValue());
    }

    /** Return value of field {@link Stone#weight}*/
    public Weight getWeight(){
        return weight;
    }

    /** Return value of field {@link Stone#price}*/
    public Price getPrice(){
        return price;
    }

    /** Set value of field {@link Stone#weight}*/
    public Weight setWeight(Weight weight){
        return this.weight = new Weight(weight.getValue());
    }

    /** Set value of field {@link Stone#price}*/
    public Price setPrice(Price price){
        return this.price = new Price(price.getValue());
    }

    /** Return value of field {@link Stone#image}*/
    public Image getImage() {
        return image;
    }

    /** Set value of field {@link Stone#image}*/
    public void setImage(Image image) {
        this.image = image;
    }

    /** Return value of field {@link Stone#name}*/
    public String getName() {
        return name;
    }

    /** Set value of field {@link Stone#name}*/
    public void setName(String name) {
        this.name = name;
    }
}
