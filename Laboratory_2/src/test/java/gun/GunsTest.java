package gun;

import comparators.GunComparator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import parsers.SaxParser;
import validator.XMLValidator;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GunsTest {

    public static Guns guns = new ObjectFactory().createGuns();

    @BeforeAll
    public static void getFromXml() throws IOException, ParserConfigurationException, SAXException {
        InputStream in_xml = new FileInputStream("src/main/resources/Gun.xml");
        InputStream in_xsd = new FileInputStream("src/main/resources/Gun.xsd");
        XMLValidator xml = new XMLValidator();
        xml.validateAgainstXSD(in_xml,in_xsd);
        SaxParser saxParser = new SaxParser();
        List<Gun> gun = new ArrayList<>();
        gun.addAll(saxParser.parse("src/main/resources/Gun.xml").getGun());
        guns.setGun(gun);
        in_xml.close();
        in_xsd.close();
    }

    @AfterAll
    public static void clear(){
        guns.getGun().clear();
    }

    @Test
    void sortByTCC() {
        Guns gunSorted = new ObjectFactory().createGuns();
        guns.sortByTCC();
        BigDecimal previous = guns.getGun().get(0).getTTC().getSightingRange();
        for (int i = 1; i < guns.getGun().size(); i++){
            assertTrue(previous.compareTo(guns.getGun().get(i).getTTC().getSightingRange()) == -1);
            previous = guns.getGun().get(i).getTTC().getSightingRange();
        }
    }
}