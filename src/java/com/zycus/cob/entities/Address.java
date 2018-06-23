package com.zycus.cob.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "address", catalog = "zycus_cob", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByCustomerId", query = "SELECT a FROM Address a WHERE a.addressPK.customerId = :customerId"),
    @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressPK.addressId = :addressId"),
    @NamedQuery(name = "Address.findByType", query = "SELECT a FROM Address a WHERE a.type = :type"),
    @NamedQuery(name = "Address.findByLine1", query = "SELECT a FROM Address a WHERE a.line1 = :line1"),
    @NamedQuery(name = "Address.findByLine2", query = "SELECT a FROM Address a WHERE a.line2 = :line2"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByState", query = "SELECT a FROM Address a WHERE a.state = :state"),
    @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country"),
    @NamedQuery(name = "Address.findByZipCode", query = "SELECT a FROM Address a WHERE a.zipCode = :zipCode"),
    @NamedQuery(name = "Address.findByLandmark", query = "SELECT a FROM Address a WHERE a.landmark = :landmark")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AddressPK addressPK;
    @Column(name = "type")
    private String type;
    @Column(name = "line1")
    private String line1;
    @Column(name = "line2")
    private String line2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "zip_code")
    private Integer zipCode;
    @Column(name = "landmark")
    private String landmark;

    public Address() {
    }

    public Address(AddressPK addressPK) {
        this.addressPK = addressPK;
    }

    public Address(String customerId, String addressId) {
        this.addressPK = new AddressPK(customerId, addressId);
    }

    public AddressPK getAddressPK() {
        return addressPK;
    }

    public void setAddressPK(AddressPK addressPK) {
        this.addressPK = addressPK;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressPK != null ? addressPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressPK == null && other.addressPK != null) || (this.addressPK != null && !this.addressPK.equals(other.addressPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zycus.cob.entities.Address[ addressPK=" + addressPK + " ]";
    }

}
