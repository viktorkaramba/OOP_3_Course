package gui;

import stones.Necklace;
import stones.Weight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainWindow extends JFrame {
    private JButton generalWeight = new JButton("General weight");
    private JButton searchByRange = new JButton("Search by range");
    private JButton sortByPrice = new JButton("Sort by price");
    private JLabel resultGeneralWeight = new JLabel();
    private JTextField startValue = new JTextField();
    private JTextField endValue = new JTextField();
    private Necklace necklace;
    private NecklaceField necklaceField;
    private boolean isClick;

    public MainWindow(){
        this.isClick = false;
    }

    public MainWindow(Necklace necklace){
        this.necklace = necklace;
        this.isClick = false;
        this.necklaceField = new NecklaceField(necklace,this);
        init(this.necklace);
    }

    public String getStartValue(){
       return startValue.getText().toString();
    }

    public String getEndValue(){
        return endValue.getText().toString();
    }

    public boolean getIsClick(){
        return this.isClick;
    }

    public void init(Necklace necklace){
        setTitle("Stones");
        setSize(900,600);
        setLocation(400,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        generalWeight.setLocation(0, 510);
        generalWeight.addActionListener(new ButtonGeneralWeightListener());
        resultGeneralWeight.setLocation(150, 510);
        searchByRange.setLocation(300, 510);
        searchByRange.addActionListener(new ButtonSearchByRangeListener());
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
        add(necklaceField);
        setVisible(true);
        //setResizable(false);
    }

    class ButtonGeneralWeightListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String result = String.valueOf(necklace.generalWeight().getValue());
            resultGeneralWeight.setText(result);
        }
    }

    class ButtonSearchByRangeListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            isClick = true;
            System.out.println(isClick);
            System.out.println(getStartValue()+" "+ getEndValue());
        }
    }

}

