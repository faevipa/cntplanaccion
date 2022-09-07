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
@Table(name = "plan_func")
@NamedQueries({
    @NamedQuery(name = "PlanFunc.findAll", query = "SELECT p FROM PlanFunc p"),
    @NamedQuery(name = "PlanFunc.findByFuncId", query = "SELECT p FROM PlanFunc p WHERE p.funcId = :funcId"),
    @NamedQuery(name = "PlanFunc.findByFuncCed", query = "SELECT p FROM PlanFunc p WHERE p.funcCed = :funcCed"),
    @NamedQuery(name = "PlanFunc.findByFuncNom", query = "SELECT p FROM PlanFunc p WHERE p.funcNom = :funcNom"),
    @NamedQuery(name = "PlanFunc.findByFuncCarg", query = "SELECT p FROM PlanFunc p WHERE p.funcCarg = :funcCarg"),
    @NamedQuery(name = "PlanFunc.findByFuncEmail", query = "SELECT p FROM PlanFunc p WHERE p.funcEmail = :funcEmail"),
    @NamedQuery(name = "PlanFunc.findByFuncTipo", query = "SELECT p FROM PlanFunc p WHERE p.funcTipo = :funcTipo"),
    @NamedQuery(name = "PlanFunc.findByFuncFech", query = "SELECT p FROM PlanFunc p WHERE p.funcFech = :funcFech"),
    @NamedQuery(name = "PlanFunc.findByAudiLogs", query = "SELECT p FROM PlanFunc p WHERE p.audiLogs = :audiLogs")})
public class PlanFunc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "func_id")
    private Integer funcId;
    @Size(max = 10)
    @Column(name = "func_ced")
    private String funcCed;
    @Size(max = 100)
    @Column(name = "func_nom")
    private String funcNom;
    @Size(max = 100)
    @Column(name = "func_carg")
    private String funcCarg;
    @Size(max = 50)
    @Column(name = "func_email")
    private String funcEmail;
    @Column(name = "func_tipo")
    private Character funcTipo;
    @Column(name = "func_fech")
    @Temporal(TemporalType.TIMESTAMP)
    private Date funcFech;
    @Size(max = 150)
    @Column(name = "audi_logs")
    private String audiLogs;

    public PlanFunc() {
    }

    public PlanFunc(Integer funcId) {
        this.funcId = funcId;
    }

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    public String getFuncCed() {
        return funcCed;
    }

    public void setFuncCed(String funcCed) {
        this.funcCed = funcCed;
    }

    public String getFuncNom() {
        return funcNom;
    }

    public void setFuncNom(String funcNom) {
        this.funcNom = funcNom;
    }

    public String getFuncCarg() {
        return funcCarg;
    }

    public void setFuncCarg(String funcCarg) {
        this.funcCarg = funcCarg;
    }

    public String getFuncEmail() {
        return funcEmail;
    }

    public void setFuncEmail(String funcEmail) {
        this.funcEmail = funcEmail;
    }

    public Character getFuncTipo() {
        return funcTipo;
    }

    public void setFuncTipo(Character funcTipo) {
        this.funcTipo = funcTipo;
    }

    public Date getFuncFech() {
        return funcFech;
    }

    public void setFuncFech(Date funcFech) {
        this.funcFech = funcFech;
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
        hash += (funcId != null ? funcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanFunc)) {
            return false;
        }
        PlanFunc other = (PlanFunc) object;
        if ((this.funcId == null && other.funcId != null) || (this.funcId != null && !this.funcId.equals(other.funcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cnt.planaccion.PlanFunc[ funcId=" + funcId + " ]";
    }
    
}
