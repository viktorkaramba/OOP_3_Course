package parsers;
import gun.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class SaxParser extends Parser{
  private List<Gun> gunList = new ArrayList<>();
  private String current;
  private Gun gun = new Gun();
  private Gun.TTC ttc = new Gun.TTC();
  private boolean isTTC = false;
  private ObjectFactory objectFactory = new ObjectFactory();
  public ByteArrayOutputStream out = new ByteArrayOutputStream();

  @Override
  public Guns parse(String fileName) {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser parser = null;
    Guns guns = objectFactory.createGuns();
    try {
      parser = factory.newSAXParser();
      SaxHandler handler = new SaxHandler();
      parser.parse(new File(fileName), handler);
      guns.setGun(gunList);
    } catch (ParserConfigurationException e ) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return guns;
  }


  public void createXMLSAX(String fileName) {
    String xml = new String(out.toByteArray(), StandardCharsets.UTF_8);
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = null;
    StringWriter output = new StringWriter();
    try {
      transformer = transformerFactory.newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      StreamSource source = new StreamSource(new StringReader(xml));
      transformer.transform(source, new StreamResult(output));
      Files.writeString(Paths.get(fileName),
              output.toString(), StandardCharsets.UTF_8);
    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private class SaxHandler extends DefaultHandler{
    public XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    public XMLOutputFactory output = XMLOutputFactory.newInstance();

    public XMLStreamWriter writer;

    @Override
    public void startDocument(){
      try {
        writer = output.createXMLStreamWriter(out);
        writer.writeStartDocument("utf-8", "1.0");
        writer.writeStartElement("Guns");
        writer.writeNamespace("xmlns","http://viktorkaramba.com.laboratory_2/guns");
        writer.writeNamespace("xsd","http://www.w3.org/2001/XMLSchema-instance");
        writer.writeAttribute( "xsd:schemaLocation","http://viktorkarmba.com.laboratory_2/guns Gun.xsd");
        XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new FileInputStream("src/main/resources/Gun.xml"));
      } catch (XMLStreamException e) {
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      current = qName;
      if ("Gun".equals(qName)) {
        gun = objectFactory.createGun();
        gun.setId(attributes.getValue("id"));
        try {
          writer.writeStartElement(qName);
          writer.writeAttribute("id", attributes.getValue("id"));
        } catch (XMLStreamException e) {
          e.printStackTrace();
        }
      } else {
        if ("TTC".equals(qName)) {
          ttc = objectFactory.createGunTTC();
          try {
            writer.writeStartElement(qName);
          } catch (XMLStreamException e) {
            e.printStackTrace();
          }
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
          try {
            writer.writeStartElement("Model");
            writer.writeCharacters(new String(ch, start, length));
            writer.writeEndElement();
          } catch (XMLStreamException e) {
            e.printStackTrace();
          }
          break;
        case "Handy":
          gun.setHandy(Handy.valueOf(new String(ch, start, length)));
          try {
            writer.writeStartElement("Handy");
            writer.writeCharacters(Handy.valueOf(new String(ch, start, length)).toString());
            writer.writeEndElement();
          } catch (XMLStreamException e) {
            e.printStackTrace();
          }

          break;
        case "Origin":
          gun.setOrigin(new String(ch, start, length));
          try {
            writer.writeStartElement("Origin");
            writer.writeCharacters(new String(ch, start, length));
            writer.writeEndElement();
          } catch (XMLStreamException e) {
            e.printStackTrace();
          }
          break;
        case "Range":
          ttc.setRange(Range.valueOf(new String(ch, start, length)));
          try {
            writer.writeStartElement("Range");
            writer.writeCharacters(Range.valueOf(new String(ch, start, length)).toString());
            writer.writeEndElement();
          } catch (XMLStreamException e) {
            e.printStackTrace();
          }
          break;
        case "SightingRange":
          ttc.setSightingRange(BigDecimal.valueOf(Long.parseLong(new String(ch, start, length))));
          try {
            writer.writeStartElement("SightingRange");
            writer.writeCharacters(BigDecimal.valueOf(Long.parseLong(new String(ch, start, length))).toString());
            writer.writeEndElement();
          } catch (XMLStreamException e) {
            e.printStackTrace();
          }
          break;
        case "PresenceOfClip":
          ttc.setPresenceOfClip(Boolean.valueOf(new String(ch, start, length)));
          try {
            writer.writeStartElement("PresenceOfClip");
            writer.writeCharacters(new String(ch, start, length));
            writer.writeEndElement();
          } catch (XMLStreamException e) {
            e.printStackTrace();
          }
          break;
        case "AvailabilityOfOptics":
          ttc.setAvailabilityOfOptics(Boolean.valueOf(new String(ch, start, length)));
          try {
            writer.writeStartElement("AvailabilityOfOptics");
            writer.writeCharacters(Boolean.valueOf(new String(ch, start, length)).toString());
            writer.writeEndElement();
            writer.writeEndElement();
          } catch (XMLStreamException e) {
            e.printStackTrace();
          }
          gun.setTTC(ttc);
          break;
        case "Material":
          gun.setMaterial(new String(ch, start, length));
          gunList.add(gun);
          try {
            writer.writeStartElement("Material");
            writer.writeCharacters(new String(ch, start, length));
            writer.writeEndElement();
            writer.writeEndElement();
          } catch (XMLStreamException e) {
            e.printStackTrace();
          }
          break;
      }



    }

    @Override
    public void endDocument(){
      try {
        writer.writeEndDocument();
        writer.flush();
        writer.close();

      } catch (XMLStreamException e) {
        e.printStackTrace();
      }
    }

  }
}

