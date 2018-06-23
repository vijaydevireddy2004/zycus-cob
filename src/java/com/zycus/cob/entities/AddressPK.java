package com.zycus.cob.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "customer_id")
    private String customerId;
    @Basic(optional = false)
    @Column(name = "address_id")
    private String addressId;

    public AddressPK() {
    }

    public AddressPK(String customerId, String addressId) {
        this.customerId = customerId;
        this.addressId = addressId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressPK)) {
            return false;
        }
        AddressPK other = (AddressPK) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zycus.cob.entities.AddressPK[ customerId=" + customerId + ", addressId=" + addressId + " ]";
    }

}
