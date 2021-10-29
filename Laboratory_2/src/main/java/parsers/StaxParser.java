package parsers;
import gun.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import javax.xml.stream.*;

public class StaxParser {

    public Guns parse(String fileName) {
        Guns guns = new ObjectFactory().createGuns();
        String tempContent = null;
        Gun.TTC gunTTC = null;
        ObjectFactory objectFactory = new ObjectFactory();
        Gun gun = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if ("Guns" == reader.getLocalName()) {
                            guns = objectFactory.createGuns();
                        } else if ("Gun" == reader.getLocalName()) {
                            gun = objectFactory.createGun();
                            gun.setId(reader.getAttributeValue(0));
                            guns.getGun().add(gun);
                        } else if ("TTC" == reader.getLocalName()) {
                            gunTTC = objectFactory.createGunTTC();
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
                                break;
                            case "Handy":
                                gun.setHandy(Handy.valueOf(tempContent));
                                break;
                            case "Origin":
                                gun.setOrigin(tempContent);
                                break;
                            case "Range":
                                gunTTC.setRange(Range.valueOf(tempContent));
                                break;
                            case "SightingRange":
                                gunTTC.setSightingRange(BigDecimal.valueOf(Long.parseLong(tempContent)));
                                break;
                            case "PresenceOfClip":
                                gunTTC.setPresenceOfClip(Boolean.valueOf(tempContent));
                                break;
                            case "AvailabilityOfOptics":
                                gunTTC.setAvailabilityOfOptics(Boolean.valueOf(tempContent));
                                gun.setTTC(gunTTC);
                                break;
                            case "Material":
                                gun.setMaterial(tempContent);
                                break;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return guns;
    }
}
