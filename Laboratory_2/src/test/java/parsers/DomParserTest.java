package parsers;

import gun.Gun;
import gun.Guns;
import gun.ObjectFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import validator.XMLValidator;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DomParserTest {

    public static Guns guns = new ObjectFactory().createGuns();

    @BeforeAll
    public static void getFromXml() throws IOException, ParserConfigurationException, SAXException {
        InputStream in_xml = new FileInputStream("src/main/resources/Gun.xml");
        InputStream in_xsd = new FileInputStream("src/main/resources/Gun.xsd");
        XMLValidator xml = new XMLValidator();
        xml.validateAgainstXSD(in_xml,in_xsd);
        in_xml.close();
        in_xsd.close();
    }

    @AfterAll
    public static void clear(){
        guns.getGun().clear();
    }

    @Test
    void parse() {
        DomParser domParser = new DomParser();
        List<Gun> gun = new ArrayList<>();
        gun.addAll(domParser.parse("src/main/resources/Gun.xml").getGun());
        guns.setGun(gun);
    }
}