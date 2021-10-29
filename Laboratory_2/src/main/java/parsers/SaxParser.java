package parsers;
import gun.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class SaxParser {
  private List<Gun> gunList = new ArrayList<>();
  private String current;
  private Gun gun = new Gun();
  private Gun.TTC ttc = new Gun.TTC();
  private boolean isTTC = false;
  private ObjectFactory objectFactory = new ObjectFactory();


  public Guns parse(String fileName) throws ParserConfigurationException, SAXException, IOException {
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser parser = factory.newSAXParser();
      SaxHandler handler = new SaxHandler();
      parser.parse(new File(fileName), handler);
      Guns guns = objectFactory.createGuns();
      guns.setGun(gunList);
      return guns;
  }

  private class SaxHandler extends DefaultHandler {


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      current = qName;
      if ("Gun".equals(qName)) {
        gun = objectFactory.createGun();
        gun.setId(attributes.getValue("id"));
      } else {
        if ("TTC".equals(qName)) {
          ttc = objectFactory.createGunTTC();
          isTTC = true;
        }
      }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
      if (isTTC) {
        gun.setTTC(ttc);
      }
      isTTC = false;
      current = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      switch (current) {
        case "Model":
          gun.setModel(new String(ch, start, length));
          break;
        case "Handy":
          gun.setHandy(Handy.valueOf(new String(ch, start, length)));
          break;
        case "Origin":
          gun.setOrigin(new String(ch, start, length));
          break;
        case "Range":
          ttc.setRange(Range.valueOf(new String(ch, start, length)));
          break;
        case "SightingRange":
          ttc.setSightingRange(BigDecimal.valueOf(Long.parseLong(new String(ch, start, length))));
          break;
        case "PresenceOfClip":
          ttc.setPresenceOfClip(Boolean.valueOf(new String(ch, start, length)));
          break;
        case "AvailabilityOfOptics":
          ttc.setAvailabilityOfOptics(Boolean.valueOf(new String(ch, start, length)));
          gun.setTTC(ttc);
          break;
        case "Material":
          gun.setMaterial(new String(ch, start, length));
          gunList.add(gun);
          break;
      }
    }
  }
}

