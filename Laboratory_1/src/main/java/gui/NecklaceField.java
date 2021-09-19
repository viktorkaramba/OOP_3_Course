package gui;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class NecklaceField  extends JPanel{

    private Image chain;
    private Vector<Image> stoneImage;

    public NecklaceField(){
        setBackground(Color.lightGray);
        loadImages();
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
            g.drawImage(chain, 175, 100, this);
    }
}
