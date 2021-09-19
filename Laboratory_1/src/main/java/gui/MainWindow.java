package gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JButton generalPrice = new JButton("General price");
    private JButton searchByRange = new JButton("Search by range");
    private JButton sortByPrice = new JButton("Sort by price");
    private JLabel resultGeneralPrice = new JLabel();
    private JTextField startValue = new JTextField();
    private JTextField endValue = new JTextField();

    public MainWindow(){
        init();
    }

    public void init(){
        setTitle("Stones");
        setSize(900,600);
        setLocation(400,150);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        generalPrice.setLocation(0, 510);
        resultGeneralPrice.setLocation(150, 510);
        searchByRange.setLocation(300, 510);
        startValue.setLocation(475,510);
        endValue.setLocation(600,510);
        sortByPrice.setLocation(750, 510);
        generalPrice.setSize(150, 50);
        resultGeneralPrice.setSize(150, 50);
        searchByRange.setSize(150, 50);
        startValue.setSize(100,50);
        endValue.setSize(100,50);
        sortByPrice.setSize(150, 50);
        add(generalPrice);
        add(resultGeneralPrice);
        add(searchByRange);
        add(startValue);
        add(endValue);
        add(sortByPrice);
        add(new NecklaceField());
        setVisible(true);
        setResizable(false);
    }
}
