package parsers;
import gun.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DomParser extends Parser{
    private List<Gun> gunList = new ArrayList<>();
    Document document;

    @Override
    public Guns parse(String fileName) {
        Guns guns = new ObjectFactory().createGuns();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File(fileName));
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            NodeList gunNodes = root.getElementsByTagName("Gun");
            for (int i = 0; i < gunNodes.getLength(); i++){
                Gun gun = new ObjectFactory().createGun();
                Element deviseElement = (Element) gunNodes.item(i);
                gun.setId(deviseElement.getAttribute("id"));
                gun.setModel(getChildValue(deviseElement, "Model"));
                gun.setHandy(Handy.valueOf(getChildValue(deviseElement, "Handy")));
                gun.setOrigin(getChildValue(deviseElement, "Origin"));
                Gun.TTC gunTTC = new ObjectFactory().createGunTTC();
                Element optionsElement = getChild(deviseElement, "TTC");
                gunTTC.setRange(Range.valueOf(getChildValue(optionsElement, "Range")));
                gunTTC.setSightingRange(BigDecimal.valueOf(Long.parseLong(getChildValue(optionsElement, "SightingRange"))));
                gunTTC.setPresenceOfClip(Boolean.valueOf(getChildValue(optionsElement, "PresenceOfClip")));
                gunTTC.setAvailabilityOfOptics(Boolean.valueOf(getChildValue(optionsElement, "AvailabilityOfOptics")));
                gun.setTTC(gunTTC);
                gun.setMaterial(getChildValue(deviseElement, "Material"));
                guns.getGun().add(gun);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return guns;
    }


    private String getChildValue(Element parent, String childName) {
        Element child = getChild(parent, childName);
        Node node = child.getFirstChild();
        return node.getNodeValue();
    }

    private Element getChild(Element parent, String childName) {
        NodeList nodeList = parent.getElementsByTagName(childName);
        return (Element) nodeList.item(0);
    }


    public void createXMLDOM(String fileName){
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(fileName));
            transformer.transform(domSource, streamResult);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
