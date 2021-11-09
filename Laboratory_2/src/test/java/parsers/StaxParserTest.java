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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class StaxParserTest {

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

    }

    @Test
    void parse() {
        try {
            StaxParser staxParser = new StaxParser();
            Vector<Gun> guns = new Vector<>();
            guns.addAll(staxParser.parse("src/main/resources/Gun.xml").getGun());
            staxParser.createXML("src/main/resources/StAXParser.xml",guns);
            InputStream in_xml = new FileInputStream("src/main/resources/StAXParser.xml");
            InputStream in_xsd = new FileInputStream("src/main/resources/Gun.xsd");
            XMLValidator xml = new XMLValidator();
            assertTrue(xml.validateAgainstXSD(in_xml,in_xsd));
            in_xml.close();
            in_xsd.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void createXMLSTAX() {
        try {
            StaxParser staxParser = new StaxParser();
            Vector<Gun> guns = new Vector<>();
            guns.addAll(staxParser.parse("src/main/resources/Gun.xml").getGun());
            staxParser.createXMLSTAX("src/main/resources/StAXParser.xml");
            InputStream in_xml = new FileInputStream("src/main/resources/StAXParser.xml");
            InputStream in_xsd = new FileInputStream("src/main/resources/Gun.xsd");
            XMLValidator xml = new XMLValidator();
            assertTrue(xml.validateAgainstXSD(in_xml,in_xsd));
            in_xml.close();
            in_xsd.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}