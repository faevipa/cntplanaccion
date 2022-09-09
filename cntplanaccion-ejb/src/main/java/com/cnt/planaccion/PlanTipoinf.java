/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnt.planaccion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fvillavicencio
 */
@Entity
@Table(name = "plan_tipoinf" , schema="plancge")
@NamedQueries({
    @NamedQuery(name = "PlanTipoinf.findAll", query = "SELECT p FROM PlanTipoinf p"),
    @NamedQuery(name = "PlanTipoinf.findByTipoinfId", query = "SELECT p FROM PlanTipoinf p WHERE p.tipoinfId = :tipoinfId"),
    @NamedQuery(name = "PlanTipoinf.findByTipoinfDesc", query = "SELECT p FROM PlanTipoinf p WHERE p.tipoinfDesc = :tipoinfDesc"),
    @NamedQuery(name = "PlanTipoinf.findByTipoinfFech", query = "SELECT p FROM PlanTipoinf p WHERE p.tipoinfFech = :tipoinfFech"),
    @NamedQuery(name = "PlanTipoinf.findByAudiLogs", query = "SELECT p FROM PlanTipoinf p WHERE p.audiLogs = :audiLogs")})
public class PlanTipoinf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipoinf_id")
    private String tipoinfId;
    @Size(max = 80)
    @Column(name = "tipoinf_desc")
    private String tipoinfDesc;
    @Column(name = "tipoinf_fech")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tipoinfFech;
    @Size(max = 150)
    @Column(name = "audi_logs")
    private String audiLogs;

    public PlanTipoinf() {
    }

    public PlanTipoinf(String tipoinfId) {
        this.tipoinfId = tipoinfId;
    }

    public String getTipoinfId() {
        return tipoinfId;
    }

    public void setTipoinfId(String tipoinfId) {
        this.tipoinfId = tipoinfId;
    }

    public String getTipoinfDesc() {
        return tipoinfDesc;
    }

    public void setTipoinfDesc(String tipoinfDesc) {
        this.tipoinfDesc = tipoinfDesc;
    }

    public Date getTipoinfFech() {
        return tipoinfFech;
    }

    public void setTipoinfFech(Date tipoinfFech) {
        this.tipoinfFech = tipoinfFech;
    }

    public String getAudiLogs() {
        return audiLogs;
    }

    public void setAudiLogs(String audiLogs) {
        this.audiLogs = audiLogs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoinfId != null ? tipoinfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanTipoinf)) {
            return false;
        }
        PlanTipoinf other = (PlanTipoinf) object;
        if ((this.tipoinfId == null && other.tipoinfId != null) || (this.tipoinfId != null && !this.tipoinfId.equals(other.tipoinfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cnt.planaccion.PlanTipoinf[ tipoinfId=" + tipoinfId + " ]";
    }
    
}
