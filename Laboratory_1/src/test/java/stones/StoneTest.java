package stones;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;



class StoneTest {
    Price price1 = new Price(4000);
    Price price2 = new Price(1000);
    Price price3 = new Price(35000);
    Weight weight1 = new Weight(2);
    Weight weight2 = new Weight(4);
    Weight weight3 = new Weight(1);
    Stone stone1 = new Stone(price1,weight1);
    Stone stone2 = new Stone(price2,weight2);
    Stone stone3 = new Stone(price3,weight3);
    Stone stone4 = new Stone(price2,weight1);
    Stone stone5 = new Stone(price3,weight1);
    Stone stone6 = new Stone(price1,weight3);
    Stone stone8 = new Stone(price3,weight2);
    Stone stone9 = new Stone(price1,weight2);
    Stone stone10 = new Stone(price2,weight3);

    @Test
    void getWeight() {
        assertEquals(stone1.getWeight().getValue(),weight1.getValue());
    }

    @Test
    void getPrice() {
        assertEquals(stone1.getPrice().getValue(),price1.getValue());
    }

    @Test
    void setWeight() {
        Stone stone = new Stone();
        stone.setWeight(weight2);
        assertEquals(stone.getWeight().getValue(),weight2.getValue());
    }

    @Test
    void setPrice() {
        Stone stone = new Stone();
        stone.setPrice(price2);
        assertEquals(stone.getPrice().getValue(),price2.getValue());
    }

    @Test
    void getImage() {
        ImageIcon chainAdditional = new ImageIcon("src/main/resources/chain.png");
        Image image = chainAdditional.getImage();
        Stone stone = new Stone();
        stone.setImage(image);
        assertEquals(stone.getImage(),image);
    }

    @Test
    void setImage() {
        ImageIcon chainAdditional = new ImageIcon("src/main/resources/chain.png");
        Image image = chainAdditional.getImage();
        Stone stone = new Stone();
        stone.setImage(image);
        assertEquals(stone.getImage(),image);
    }

    @Test
    void getName() {
        Stone stone = new Stone();
        assertEquals(stone.getName(),"Unknown");
    }

    @Test
    void setName() {
        Stone stone = new Stone();
        stone.setName("Ruby");
        assertEquals(stone.getName(),"Ruby");
    }
}