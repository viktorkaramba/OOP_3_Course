package stones;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class NecklaceTest extends StoneTest{
    Vector<Stone> stones = new Vector<Stone>();
    void addStonesTest(){
        stones.add(stone1);
        stones.add(stone2);
        stones.add(stone3);
        stones.add(stone4);
        stones.add(stone5);
        stones.add(stone6);
    }


    @Test
    void getStones() {
        addStonesTest();
        Necklace necklace1 = new Necklace(stones);
        assertEquals(necklace1.getStones(), stones);
        for (int i = 0; i<necklace1.getStones().size(); i++){
            assertEquals(necklace1.getStones().get(i).getWeight().getValue(),stones.get(i).getWeight().getValue());
            assertEquals(necklace1.getStones().get(i).getPrice().getValue(),stones.get(i).getPrice().getValue());
            assertEquals(necklace1.getStones().get(i).getName(),stones.get(i).getName());
            assertEquals(necklace1.getStones().get(i).getImage(),stones.get(i).getImage());
        }
    }

    @Test
    void setStones() {
        addStonesTest();
        Necklace necklace = new Necklace();
        necklace.setStones(stones);
        assertEquals(necklace.getStones(), stones);
        for (int i = 0; i<necklace.getStones().size(); i++){
            assertEquals(necklace.getStones().get(i).getWeight().getValue(),stones.get(i).getWeight().getValue());
            assertEquals(necklace.getStones().get(i).getPrice().getValue(),stones.get(i).getPrice().getValue());
            assertEquals(necklace.getStones().get(i).getName(),stones.get(i).getName());
            assertEquals(necklace.getStones().get(i).getImage(),stones.get(i).getImage());
        }
    }

    @Test
    void addStone() {
        addStonesTest();
        Necklace necklace = new Necklace();
        necklace.addStone(stone1);
        necklace.addStone(stone2);
        necklace.addStone(stone3);
        necklace.addStone(stone4);
        necklace.addStone(stone5);
        necklace.addStone(stone6);
        assertEquals(necklace.getStones(), stones);
        for (int i = 0; i<necklace.getStones().size(); i++){
            assertEquals(necklace.getStones().get(i).getWeight().getValue(),stones.get(i).getWeight().getValue());
            assertEquals(necklace.getStones().get(i).getPrice().getValue(),stones.get(i).getPrice().getValue());
            assertEquals(necklace.getStones().get(i).getName(),stones.get(i).getName());
            assertEquals(necklace.getStones().get(i).getImage(),stones.get(i).getImage());
        }
    }

    @Test
    void generalWeight() {
        addStonesTest();
        Necklace necklace1 = new Necklace(stones);
        assertEquals(necklace1.generalWeight().getValue(),12);
    }

    @Test
    void generalPrice() {
        addStonesTest();
        Necklace necklace1 = new Necklace(stones);
        assertEquals(necklace1.generalPrice().getValue(),80000);
    }

    @Test
    void sortByPrice() {
        addStonesTest();
        Necklace necklace = new Necklace(stones);
        necklace.sortByPrice();
        Vector<Stone> sortedStones = new Vector<Stone>();
        sortedStones.add(stone2);
        sortedStones.add(stone4);
        sortedStones.add(stone1);
        sortedStones.add(stone6);
        sortedStones.add(stone3);
        sortedStones.add(stone5);
        assertEquals(necklace.getStones(), sortedStones);
        for (int i = 0; i<necklace.getStones().size(); i++){
            assertEquals(necklace.getStones().get(i).getPrice().getValue(),sortedStones.get(i).getPrice().getValue());
        }
    }

    @Test
    void searchByRange() {
        addStonesTest();
        Necklace necklace = new Necklace(stones);
        Vector<Stone> rangeStones = new Vector<Stone>();
        rangeStones.add(stone1);
        rangeStones.add(stone2);
        rangeStones.add(stone4);
        rangeStones.add(stone5);
        for(int i = 0; i<necklace.searchByRange(0.2,0.5).size(); i++) {
            assertEquals(necklace.searchByRange(0.2, 0.5),rangeStones);
        }
    }
}