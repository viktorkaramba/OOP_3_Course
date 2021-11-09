import comparators.GunComparator;

import gun.Gun;
import org.xml.sax.SAXException;
import parsers.DomParser;
import parsers.SaxParser;
import parsers.StaxParser;
import validator.XMLValidator;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        InputStream in_xml = new FileInputStream("src/main/resources/Gun.xml");
        InputStream in_xsd = new FileInputStream("src/main/resources/Gun.xsd");
        XMLValidator xml = new XMLValidator();
        xml.validateAgainstXSD(in_xml,in_xsd);
        SaxParser saxParser = new SaxParser();
        DomParser domParser = new DomParser();
        StaxParser staxParser = new StaxParser();
        Vector<Gun> gunSax = new Vector<>();
        Vector<Gun> gunDom = new Vector<>();
        Vector<Gun> gunStax = new Vector<>();
        gunSax.addAll(saxParser.parse("src/main/resources/Gun.xml").getGun());
        gunDom.addAll(domParser.parse("src/main/resources/Gun.xml").getGun());
        gunStax.addAll(staxParser.parse("src/main/resources/Gun.xml").getGun());
        System.out.println("SAX");
        GunComparator gunComparator = new GunComparator();
        gunSax.sort(gunComparator);
        for(Gun gun: gunSax){
            System.out.println(gun.toString());
        }
        saxParser.createXML("src/main/resources/SaxParser.xml",gunSax);
        System.out.println("DOM");

        gunDom.sort(gunComparator);
        for(Gun gun: gunDom){
            System.out.println(gun.toString());
        }
        domParser.createXML("src/main/resources/DomParser.xml", gunDom);
        System.out.println("StAX");
        gunStax.sort(gunComparator);
        for(Gun gun: gunStax){
            System.out.println(gun.toString());
        }
        staxParser.createXML("src/main/resources/StAXParser.xml", gunStax);
    }
}
