package gui;
import stones.Necklace;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class NecklaceField  extends JPanel{

    private Image chain;
    private Necklace necklace;

    public NecklaceField(){
        setBackground(Color.lightGray);
        loadImages();
    }
    public NecklaceField(Necklace necklace){
        setBackground(Color.lightGray);
        loadImages();
        this.necklace = necklace;
    }

    public Image getChain() {
        return chain;
    }

    public void setChain(Image chain) {
        ImageIcon c = new ImageIcon("putin.png");
        this.chain = chain;
    }

    public void loadImages(){
        ImageIcon chainAdditional = new ImageIcon("src/main/resources/chain.png");
        this.chain = chainAdditional.getImage();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(chain, 40, 200, this);
        int x = 50;
        int y = 200;
        for (int i =0; i<necklace.getStones().size(); i++){
                g.drawImage(necklace.getStones().get(i).getImage(),x,y,this);
                x+=120;
        }
    }
}
