package gui;
import stones.Necklace;
import stones.Weight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class NecklaceField  extends JPanel implements ActionListener {

    private Image chain;
    private Necklace necklace;
    private MainWindow mainWindow;

    public NecklaceField(){
        setBackground(Color.lightGray);
        loadImages();
    }

    public NecklaceField(Necklace necklace,MainWindow mainWindow){
        setBackground(Color.lightGray);
        loadImages();
        this.necklace = necklace;
        this.mainWindow = mainWindow;
    }

    public Image getChain() {
        return chain;
    }

    public void setChain(Image chain) {
        ImageIcon chainAdditional = new ImageIcon("src/main/resources/chain.png");
        this.chain = chainAdditional.getImage();
    }

    public void loadImages(){
        ImageIcon chainAdditional = new ImageIcon("src/main/resources/chain.png");
        this.chain = chainAdditional.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chain, 40, 200, this);
        int x = 50;
        int y = 200;
        for (int i =0; i<necklace.getStones().size(); i++){
             g.drawImage(necklace.getStones().get(i).getImage(),x,y,this);
             x+=120;
        }
        if(checkIsClick()){
            int x_1 = 100;
            int y_1 = 300;
            Weight first = new Weight(Integer.valueOf(mainWindow.getStartValue()));
            Weight second = new Weight(Integer.valueOf(mainWindow.getEndValue()));
            for (int i = 0; i<necklace.searchByRange(first, second).size(); i++){
                g.drawImage(necklace.searchByRange(first,second).get(i).getImage(),x_1,y_1,this);
                x_1+=120;
            }
        }
    }


    public boolean checkIsClick(){
        return mainWindow.getIsClick();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkIsClick();
        repaint();
    }

}
