package parsers;
import gun.*;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.stream.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class StaxParser extends Parser{

    private   ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Override
    public Guns parse(String fileName){
        Guns guns = new ObjectFactory().createGuns();
        String tempContent = null;
        Gun.TTC gunTTC = null;
        ObjectFactory objectFactory = new ObjectFactory();
        Gun gun = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLOutputFactory output = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = output.createXMLStreamWriter(out);
            writer.writeStartDocument("utf-8", "1.0");
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if ("Guns" == reader.getLocalName()) {
                            guns = objectFactory.createGuns();
                            writer.writeStartElement(reader.getLocalName());
                            writer.writeNamespace("xmlns","http://viktorkaramba.com.laboratory_2/guns");
                            writer.writeNamespace("xsd","http://www.w3.org/2001/XMLSchema-instance");
                            writer.writeAttribute( "xsd:schemaLocation","http://viktorkarmba.com.laboratory_2/guns Gun.xsd");
                        } else if ("Gun" == reader.getLocalName()) {
                            gun = objectFactory.createGun();
                            writer.writeStartElement(reader.getLocalName());
                            gun.setId(reader.getAttributeValue(0));
                            writer.writeAttribute("id",reader.getAttributeValue(0));
                            guns.getGun().add(gun);
                        } else if ("TTC" == reader.getLocalName()) {
                            gunTTC = objectFactory.createGunTTC();
                            writer.writeStartElement(reader.getLocalName());
                            gun.setTTC(gunTTC);
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        tempContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case "Model":
                                gun.setModel(tempContent);
                                writer.writeStartElement("Model");
                                writer.writeCharacters(tempContent);
                                writer.writeEndElement();
                                break;
                            case "Handy":
                                gun.setHandy(Handy.valueOf(tempContent));
                                writer.writeStartElement("Handy");
                                writer.writeCharacters(tempContent);
                                writer.writeEndElement();
                                break;
                            case "Origin":
                                gun.setOrigin(tempContent);
                                writer.writeStartElement("Origin");
                                writer.writeCharacters(tempContent);
                                writer.writeEndElement();
                                break;
                            case "Range":
                                gunTTC.setRange(Range.valueOf(tempContent));
                                writer.writeStartElement("Range");
                                writer.writeCharacters(tempContent);
                                writer.writeEndElement();
                                break;
                            case "SightingRange":
                                gunTTC.setSightingRange(BigDecimal.valueOf(Long.parseLong(tempContent)));
                                writer.writeStartElement("SightingRange");
                                writer.writeCharacters(tempContent);
                                writer.writeEndElement();
                                break;
                            case "PresenceOfClip":
                                gunTTC.setPresenceOfClip(Boolean.valueOf(tempContent));
                                writer.writeStartElement("PresenceOfClip");
                                writer.writeCharacters(tempContent);
                                writer.writeEndElement();
                                break;
                            case "AvailabilityOfOptics":
                                gunTTC.setAvailabilityOfOptics(Boolean.valueOf(tempContent));
                                writer.writeStartElement("AvailabilityOfOptics");
                                writer.writeCharacters(tempContent);
                                writer.writeEndElement();
                                gun.setTTC(gunTTC);
                                writer.writeEndElement();
                                break;
                            case "Material":
                                gun.setMaterial(tempContent);
                                writer.writeStartElement("Material");
                                writer.writeCharacters(tempContent);
                                writer.writeEndElement();
                                writer.writeEndElement();
                                break;
                        }
                        break;
                }
            }
            writer.writeEndDocument();
            writer.flush();
            writer.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guns;
    }

    public void createXMLSTAX(String fileName) {
        String xml = new String(out.toByteArray(), StandardCharsets.UTF_8);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        StringWriter output = new StringWriter();
        try {
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamSource source = new StreamSource(new StringReader(xml));
            transformer.transform(source, new StreamResult(output));
            String prettyPrintXML =  output.toString();
            Files.writeString(Paths.get(fileName), prettyPrintXML, StandardCharsets.UTF_8);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
