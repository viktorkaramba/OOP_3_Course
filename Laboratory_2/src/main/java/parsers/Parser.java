package parsers;

import gun.Gun;
import gun.Guns;
import gun.Handy;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import java.io.FileOutputStream;
import java.util.Vector;

public abstract class Parser {
    public abstract Guns parse(String fileName);

    public void createXML(String fileName, Vector<Gun> guns){
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(fileName));
            writer.writeStartDocument("utf-8", "1.0");
            writer.writeStartElement("Guns");
            writer.writeNamespace("xmlns","http://viktorkaramba.com.laboratory_2/guns");
            writer.writeNamespace("xsd","http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute( "xsd:schemaLocation","http://viktorkarmba.com.laboratory_2/guns Gun.xsd");
            for (Gun gun : guns) {
                writer.writeStartElement("Gun");
                writer.writeAttribute("id", String.valueOf(gun.getId()));
                writer.writeStartElement("Model");
                writer.writeCharacters(gun.getModel());
                writer.writeEndElement();
                writer.writeStartElement("Handy");
                writer.writeCharacters(gun.getHandy().toString());
                writer.writeEndElement();
                writer.writeStartElement("Origin");
                writer.writeCharacters(gun.getOrigin());
                writer.writeEndElement();
                writer.writeStartElement("TTC");
                writer.writeStartElement("Range");
                writer.writeCharacters(gun.getTTC().getRange().toString());
                writer.writeEndElement();
                writer.writeStartElement("SightingRange");
                writer.writeCharacters(gun.getTTC().getSightingRange().toString());
                writer.writeEndElement();
                writer.writeStartElement("PresenceOfClip");
                writer.writeCharacters(String.valueOf(gun.getTTC().isPresenceOfClip()));
                writer.writeEndElement();
                writer.writeStartElement("AvailabilityOfOptics");
                writer.writeCharacters(String.valueOf(gun.getTTC().isAvailabilityOfOptics()));
                writer.writeEndElement();
                writer.writeEndElement();
                writer.writeStartElement("Material");
                writer.writeCharacters(gun.getMaterial());
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndDocument();
            writer.close();
        } catch (Exception e) {
        }
    }
}
