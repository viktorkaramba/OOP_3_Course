package gui;

import stones.Necklace;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JButton generalWeight = new JButton("General weight");
    private JButton searchByRange = new JButton("Search by range");
    private JButton sortByPrice = new JButton("Sort by price");
    private JLabel resultGeneralWeight = new JLabel();
    private JTextField startValue = new JTextField();
    private JTextField endValue = new JTextField();


    public MainWindow(){

    }

    public MainWindow(Necklace necklace){
        init(necklace);
    }

    public void init(Necklace necklace){
        setTitle("Stones");
        setSize(900,600);
        setLocation(400,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        generalWeight.setLocation(0, 510);
        resultGeneralWeight.setLocation(150, 510);
        searchByRange.setLocation(300, 510);
        startValue.setLocation(475,510);
        endValue.setLocation(600,510);
        sortByPrice.setLocation(750, 510);
        generalWeight.setSize(150, 50);
        resultGeneralWeight.setSize(150, 50);
        searchByRange.setSize(150, 50);
        startValue.setSize(100,50);
        endValue.setSize(100,50);
        sortByPrice.setSize(150, 50);
        add(generalWeight);
        add(resultGeneralWeight);
        add(searchByRange);
        add(startValue);
        add(endValue);
        add(sortByPrice);
        add(new NecklaceField(necklace));
        setVisible(true);
        setResizable(false);
    }


}
