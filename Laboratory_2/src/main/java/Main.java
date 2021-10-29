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


public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        InputStream in_xml = new FileInputStream("src/main/resources/Gun.xml");
        InputStream in_xsd = new FileInputStream("src/main/resources/Gun.xsd");
        XMLValidator xml = new XMLValidator();
        xml.validateAgainstXSD(in_xml,in_xsd);
        SaxParser saxParser = new SaxParser();
        DomParser domParser = new DomParser();
        StaxParser staxParser = new StaxParser();
        List<Gun> gunListSax = new ArrayList<>();
        List<Gun> gunListDom = new ArrayList<>();
        List<Gun> gunListStax = new ArrayList<>();
        gunListSax.addAll(saxParser.parse("src/main/resources/Gun.xml").getGun());
        gunListDom.addAll(domParser.parse("src/main/resources/Gun.xml").getGun());
        gunListStax.addAll(staxParser.parse("src/main/resources/Gun.xml").getGun());
        System.out.println("SAX");
        GunComparator gunComparator = new GunComparator();
        gunListSax.sort(gunComparator);
        for(Gun gun: gunListSax){
            System.out.println(gun.toString());
        }
        System.out.println("DOM");
        gunListDom.sort(gunComparator);
        for(Gun gun: gunListDom){
            System.out.println(gun.toString());
        }
        System.out.println("StAX");
        gunListStax.sort(gunComparator);
        for(Gun gun: gunListStax){
            System.out.println(gun.toString());
        }
//        Gun.TTC gunTTC1 = new Gun.TTC();
//        BigDecimal number1 = new BigDecimal(322);
//        gunTTC1.setSightingRange(number1);
//        Gun.TTC gunTTC2 = new Gun.TTC();
//        BigDecimal number2 = new BigDecimal(132);
//        gunTTC2.setSightingRange(number2);
//        Gun.TTC gunTTC3 = new Gun.TTC();
//        BigDecimal number3 = new BigDecimal(511);
//        gunTTC3.setSightingRange(number3);
//        Vector<Gun.TTC> ttcVector = new Vector<>();
//        ttcVector.add(gunTTC1);
//        ttcVector.add(gunTTC2);
//        ttcVector.add(gunTTC3);
//        TTCComparator ttcComparator = new TTCComparator();
//        ttcVector.sort(ttcComparator);
//        for(Gun.TTC ttc: ttcVector){
//            System.out.println(ttc.toString());
//        }
//        Gun gun1 = new Gun();
//        gun1.setTTC(gunTTC1);
//        Gun gun2 = new Gun();
//        gun2.setTTC(gunTTC2);
//        Gun gun3 = new Gun();
//        gun3.setTTC(gunTTC3);
//        Vector<Gun> gunVector = new Vector<>();
//        gunVector.add(gun1);
//        gunVector.add(gun2);
//        gunVector.add(gun3);
//        GunComparator gunComparator = new GunComparator();
//        gunVector.sort(gunComparator);
//        for(Gun gun: gunVector){
//            System.out.println(gun.toString());
//        }
    }
}
