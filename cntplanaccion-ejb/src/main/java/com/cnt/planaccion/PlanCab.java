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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "plan_cab" , schema="plancge")
@NamedQueries({
    @NamedQuery(name = "PlanCab.findAll", query = "SELECT p FROM PlanCab p"),
    @NamedQuery(name = "PlanCab.findByPlanaccId", query = "SELECT p FROM PlanCab p WHERE p.planaccId = :planaccId"),
    @NamedQuery(name = "PlanCab.findByPlanaccCod", query = "SELECT p FROM PlanCab p WHERE p.planaccCod = :planaccCod"),
    @NamedQuery(name = "PlanCab.findByPlanaccConcl", query = "SELECT p FROM PlanCab p WHERE p.planaccConcl = :planaccConcl"),
    @NamedQuery(name = "PlanCab.findByPlanaccRecom", query = "SELECT p FROM PlanCab p WHERE p.planaccRecom = :planaccRecom"),
    @NamedQuery(name = "PlanCab.findByPlanaccFechini", query = "SELECT p FROM PlanCab p WHERE p.planaccFechini = :planaccFechini"),
    @NamedQuery(name = "PlanCab.findByPlanaccFechfin", query = "SELECT p FROM PlanCab p WHERE p.planaccFechfin = :planaccFechfin"),
    @NamedQuery(name = "PlanCab.findByPlanaccRespced", query = "SELECT p FROM PlanCab p WHERE p.planaccRespced = :planaccRespced"),
    @NamedQuery(name = "PlanCab.findByPlanaccGernced", query = "SELECT p FROM PlanCab p WHERE p.planaccGernced = :planaccGernced"),
    @NamedQuery(name = "PlanCab.findByPlanccCodorg", query = "SELECT p FROM PlanCab p WHERE p.planccCodorg = :planccCodorg"),
    @NamedQuery(name = "PlanCab.findByPlanaccCaso", query = "SELECT p FROM PlanCab p WHERE p.planaccCaso = :planaccCaso"),
    @NamedQuery(name = "PlanCab.findByAudiLogs", query = "SELECT p FROM PlanCab p WHERE p.audiLogs = :audiLogs"),
    @NamedQuery(name = "PlanCab.findByPlanaccPorcum", query = "SELECT p FROM PlanCab p WHERE p.planaccPorcum = :planaccPorcum"),
    @NamedQuery(name = "PlanCab.findByPlanaccNrodoc", query = "SELECT p FROM PlanCab p WHERE p.planaccNrodoc = :planaccNrodoc"),
    @NamedQuery(name = "PlanCab.findByPlanaccPlanacc", query = "SELECT p FROM PlanCab p WHERE p.planaccPlanacc = :planaccPlanacc")})
public class PlanCab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "planacc_id")
    private Integer planaccId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "planacc_cod")
    private String planaccCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "planacc_concl")
    private String planaccConcl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "planacc_recom")
    private String planaccRecom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planacc_fechini")
    @Temporal(TemporalType.DATE)
    private Date planaccFechini;
    @Column(name = "planacc_fechfin")
    @Temporal(TemporalType.DATE)
    private Date planaccFechfin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "planacc_respced")
    private String planaccRespced;
    @Size(max = 10)
    @Column(name = "planacc_gernced")
    private String planaccGernced;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "plancc_codorg")
    private String planccCodorg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planacc_caso")
    private int planaccCaso;
    @Size(max = 150)
    @Column(name = "audi_logs")
    private String audiLogs;
    @Column(name = "planacc_porcum")
    private Integer planaccPorcum;
    @Size(max = 3000)
    @Column(name = "planacc_nrodoc")
    private String planaccNrodoc;
    @Size(max = 5000)
    @Column(name = "planacc_planacc")
    private String planaccPlanacc;
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne(optional = false)
    private PlanEst estId;

    public PlanCab() {
    }

    public PlanCab(Integer planaccId) {
        this.planaccId = planaccId;
    }

    public PlanCab(Integer planaccId, String planaccCod, String planaccConcl, String planaccRecom, Date planaccFechini, String planaccRespced, String planccCodorg, int planaccCaso) {
        this.planaccId = planaccId;
        this.planaccCod = planaccCod;
        this.planaccConcl = planaccConcl;
        this.planaccRecom = planaccRecom;
        this.planaccFechini = planaccFechini;
        this.planaccRespced = planaccRespced;
        this.planccCodorg = planccCodorg;
        this.planaccCaso = planaccCaso;
    }

    public Integer getPlanaccId() {
        return planaccId;
    }

    public void setPlanaccId(Integer planaccId) {
        this.planaccId = planaccId;
    }

    public String getPlanaccCod() {
        return planaccCod;
    }

    public void setPlanaccCod(String planaccCod) {
        this.planaccCod = planaccCod;
    }

    public String getPlanaccConcl() {
        return planaccConcl;
    }

    public void setPlanaccConcl(String planaccConcl) {
        this.planaccConcl = planaccConcl;
    }

    public String getPlanaccRecom() {
        return planaccRecom;
    }

    public void setPlanaccRecom(String planaccRecom) {
        this.planaccRecom = planaccRecom;
    }

    public Date getPlanaccFechini() {
        return planaccFechini;
    }

    public void setPlanaccFechini(Date planaccFechini) {
        this.planaccFechini = planaccFechini;
    }

    public Date getPlanaccFechfin() {
        return planaccFechfin;
    }

    public void setPlanaccFechfin(Date planaccFechfin) {
        this.planaccFechfin = planaccFechfin;
    }

    public String getPlanaccRespced() {
        return planaccRespced;
    }

    public void setPlanaccRespced(String planaccRespced) {
        this.planaccRespced = planaccRespced;
    }

    public String getPlanaccGernced() {
        return planaccGernced;
    }

    public void setPlanaccGernced(String planaccGernced) {
        this.planaccGernced = planaccGernced;
    }

    public String getPlanccCodorg() {
        return planccCodorg;
    }

    public void setPlanccCodorg(String planccCodorg) {
        this.planccCodorg = planccCodorg;
    }

    public int getPlanaccCaso() {
        return planaccCaso;
    }

    public void setPlanaccCaso(int planaccCaso) {
        this.planaccCaso = planaccCaso;
    }

    public String getAudiLogs() {
        return audiLogs;
    }

    public void setAudiLogs(String audiLogs) {
        this.audiLogs = audiLogs;
    }

    public Integer getPlanaccPorcum() {
        return planaccPorcum;
    }

    public void setPlanaccPorcum(Integer planaccPorcum) {
        this.planaccPorcum = planaccPorcum;
    }

    public String getPlanaccNrodoc() {
        return planaccNrodoc;
    }

    public void setPlanaccNrodoc(String planaccNrodoc) {
        this.planaccNrodoc = planaccNrodoc;
    }

    public String getPlanaccPlanacc() {
        return planaccPlanacc;
    }

    public void setPlanaccPlanacc(String planaccPlanacc) {
        this.planaccPlanacc = planaccPlanacc;
    }

    public PlanEst getEstId() {
        return estId;
    }

    public void setEstId(PlanEst estId) {
        this.estId = estId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planaccId != null ? planaccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanCab)) {
            return false;
        }
        PlanCab other = (PlanCab) object;
        if ((this.planaccId == null && other.planaccId != null) || (this.planaccId != null && !this.planaccId.equals(other.planaccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cnt.planaccion.PlanCab[ planaccId=" + planaccId + " ]";
    }
    
}
