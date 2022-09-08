/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnt.planaccion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "plan_est" , schema="plancge")
@NamedQueries({
    @NamedQuery(name = "PlanEst.findAll", query = "SELECT p FROM PlanEst p"),
    @NamedQuery(name = "PlanEst.findByEstId", query = "SELECT p FROM PlanEst p WHERE p.estId = :estId"),
    @NamedQuery(name = "PlanEst.findByEstCod", query = "SELECT p FROM PlanEst p WHERE p.estCod = :estCod"),
    @NamedQuery(name = "PlanEst.findByEstDesc", query = "SELECT p FROM PlanEst p WHERE p.estDesc = :estDesc"),
    @NamedQuery(name = "PlanEst.findByEstFch", query = "SELECT p FROM PlanEst p WHERE p.estFch = :estFch"),
    @NamedQuery(name = "PlanEst.findByAudiLogs", query = "SELECT p FROM PlanEst p WHERE p.audiLogs = :audiLogs")})
public class PlanEst implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_id")
    private Integer estId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_cod")
    private Character estCod;
    @Size(max = 30)
    @Column(name = "est_desc")
    private String estDesc;
    @Column(name = "est_fch")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estFch;
    @Size(max = 150)
    @Column(name = "audi_logs")
    private String audiLogs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estId")
    private List<PlanCab> planCabList;

    public PlanEst() {
    }

    public PlanEst(Integer estId) {
        this.estId = estId;
    }

    public PlanEst(Integer estId, Character estCod) {
        this.estId = estId;
        this.estCod = estCod;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public Character getEstCod() {
        return estCod;
    }

    public void setEstCod(Character estCod) {
        this.estCod = estCod;
    }

    public String getEstDesc() {
        return estDesc;
    }

    public void setEstDesc(String estDesc) {
        this.estDesc = estDesc;
    }

    public Date getEstFch() {
        return estFch;
    }

    public void setEstFch(Date estFch) {
        this.estFch = estFch;
    }

    public String getAudiLogs() {
        return audiLogs;
    }

    public void setAudiLogs(String audiLogs) {
        this.audiLogs = audiLogs;
    }

    public List<PlanCab> getPlanCabList() {
        return planCabList;
    }

    public void setPlanCabList(List<PlanCab> planCabList) {
        this.planCabList = planCabList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanEst)) {
            return false;
        }
        PlanEst other = (PlanEst) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cnt.planaccion.PlanEst[ estId=" + estId + " ]";
    }
    
}
