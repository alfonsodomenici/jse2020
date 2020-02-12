/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "t_Options")
@NamedQueries({
    @NamedQuery(name = "TOptions.findAll", query = "SELECT t FROM TOptions t")})
public class TOptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOptions")
    private Integer idOptions;
    @Column(name = "mesi_calcolo_riordino")
    private Integer mesiCalcoloRiordino;
    @Size(max = 45)
    @Column(name = "dominio")
    private String dominio;
    @Column(name = "qtaXpack")
    private Integer qtaXpack;

    public TOptions() {
    }

    public TOptions(Integer idOptions) {
        this.idOptions = idOptions;
    }

    public Integer getIdOptions() {
        return idOptions;
    }

    public void setIdOptions(Integer idOptions) {
        this.idOptions = idOptions;
    }

    public Integer getMesiCalcoloRiordino() {
        return mesiCalcoloRiordino;
    }

    public void setMesiCalcoloRiordino(Integer mesiCalcoloRiordino) {
        this.mesiCalcoloRiordino = mesiCalcoloRiordino;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public Integer getQtaXpack() {
        return qtaXpack;
    }

    public void setQtaXpack(Integer qtaXpack) {
        this.qtaXpack = qtaXpack;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOptions != null ? idOptions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TOptions)) {
            return false;
        }
        TOptions other = (TOptions) object;
        if ((this.idOptions == null && other.idOptions != null) || (this.idOptions != null && !this.idOptions.equals(other.idOptions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.tss.jpa.entities.TOptions[ idOptions=" + idOptions + " ]";
    }
    
}
