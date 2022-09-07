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
@Table(name = "plan_gere")
@NamedQueries({
    @NamedQuery(name = "PlanGere.findAll", query = "SELECT p FROM PlanGere p"),
    @NamedQuery(name = "PlanGere.findByGereId", query = "SELECT p FROM PlanGere p WHERE p.gereId = :gereId"),
    @NamedQuery(name = "PlanGere.findByGereCodorg", query = "SELECT p FROM PlanGere p WHERE p.gereCodorg = :gereCodorg"),
    @NamedQuery(name = "PlanGere.findByGereGernac", query = "SELECT p FROM PlanGere p WHERE p.gereGernac = :gereGernac"),
    @NamedQuery(name = "PlanGere.findByGereGerare", query = "SELECT p FROM PlanGere p WHERE p.gereGerare = :gereGerare"),
    @NamedQuery(name = "PlanGere.findByGereArea", query = "SELECT p FROM PlanGere p WHERE p.gereArea = :gereArea"),
    @NamedQuery(name = "PlanGere.findByGereFech", query = "SELECT p FROM PlanGere p WHERE p.gereFech = :gereFech"),
    @NamedQuery(name = "PlanGere.findByAudiLogs", query = "SELECT p FROM PlanGere p WHERE p.audiLogs = :audiLogs")})
public class PlanGere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "gere_id")
    private Integer gereId;
    @Size(max = 10)
    @Column(name = "gere_codorg")
    private String gereCodorg;
    @Size(max = 100)
    @Column(name = "gere_gernac")
    private String gereGernac;
    @Size(max = 100)
    @Column(name = "gere_gerare")
    private String gereGerare;
    @Size(max = 100)
    @Column(name = "gere_area")
    private String gereArea;
    @Column(name = "gere_fech")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gereFech;
    @Size(max = 150)
    @Column(name = "audi_logs")
    private String audiLogs;

    public PlanGere() {
    }

    public PlanGere(Integer gereId) {
        this.gereId = gereId;
    }

    public Integer getGereId() {
        return gereId;
    }

    public void setGereId(Integer gereId) {
        this.gereId = gereId;
    }

    public String getGereCodorg() {
        return gereCodorg;
    }

    public void setGereCodorg(String gereCodorg) {
        this.gereCodorg = gereCodorg;
    }

    public String getGereGernac() {
        return gereGernac;
    }

    public void setGereGernac(String gereGernac) {
        this.gereGernac = gereGernac;
    }

    public String getGereGerare() {
        return gereGerare;
    }

    public void setGereGerare(String gereGerare) {
        this.gereGerare = gereGerare;
    }

    public String getGereArea() {
        return gereArea;
    }

    public void setGereArea(String gereArea) {
        this.gereArea = gereArea;
    }

    public Date getGereFech() {
        return gereFech;
    }

    public void setGereFech(Date gereFech) {
        this.gereFech = gereFech;
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
        hash += (gereId != null ? gereId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanGere)) {
            return false;
        }
        PlanGere other = (PlanGere) object;
        if ((this.gereId == null && other.gereId != null) || (this.gereId != null && !this.gereId.equals(other.gereId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cnt.planaccion.PlanGere[ gereId=" + gereId + " ]";
    }
    
}
