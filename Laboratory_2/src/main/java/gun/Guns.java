//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.28 at 05:30:35 PM EEST 
//


package gun;

import comparators.GunComparator;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Gun" type="{http://viktorkaramba.com.laboratory_2/gun}Gun" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "gun"
})
@XmlRootElement(name = "Guns")
public class Guns {

    @XmlElement(name = "Gun", required = true)
    protected List<Gun> gun;

    /**
     * Gets the value of the gun property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gun property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGun().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Gun }
     * 
     * 
     */
    public List<Gun> getGun() {
        if (gun == null) {
            gun = new ArrayList<Gun>();
        }
        return this.gun;
    }

    public void setGun(List<Gun> guns) {
        if (gun == null) {
            gun = new ArrayList<Gun>();
        }
        gun.addAll(guns);
    }

    public void sortByTCC(){
        GunComparator gunComparator = new GunComparator();
        gun.sort(gunComparator);
    }
}