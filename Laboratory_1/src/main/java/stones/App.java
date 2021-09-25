package stones;
import database.DBConnection;
import gui.MainWindow;

import java.util.Vector;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args )
    {
        DBConnection a = new DBConnection();
        a.readInfo();
        Necklace necklace = new Necklace(a.readInfo());
        MainWindow mw = new MainWindow(necklace);
    }
}
