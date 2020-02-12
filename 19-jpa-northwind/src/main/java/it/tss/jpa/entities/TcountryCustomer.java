/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_countryCustomer")
@NamedQueries({
    @NamedQuery(name = "TcountryCustomer.findAll", query = "SELECT t FROM TcountryCustomer t")})
public class TcountryCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_countryCustomer")
    private Integer idcountryCustomer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "country")
    private String country;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pricePack")
    private BigDecimal pricePack;

    public TcountryCustomer() {
    }

    public TcountryCustomer(Integer idcountryCustomer) {
        this.idcountryCustomer = idcountryCustomer;
    }

    public TcountryCustomer(Integer idcountryCustomer, String country) {
        this.idcountryCustomer = idcountryCustomer;
        this.country = country;
    }

    public Integer getIdcountryCustomer() {
        return idcountryCustomer;
    }

    public void setIdcountryCustomer(Integer idcountryCustomer) {
        this.idcountryCustomer = idcountryCustomer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getPricePack() {
        return pricePack;
    }

    public void setPricePack(BigDecimal pricePack) {
        this.pricePack = pricePack;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcountryCustomer != null ? idcountryCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcountryCustomer)) {
            return false;
        }
        TcountryCustomer other = (TcountryCustomer) object;
        if ((this.idcountryCustomer == null && other.idcountryCustomer != null) || (this.idcountryCustomer != null && !this.idcountryCustomer.equals(other.idcountryCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.tss.jpa.entities.TcountryCustomer[ idcountryCustomer=" + idcountryCustomer + " ]";
    }
    
}
