/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnt.cntplanaccion.beans;

import com.cnt.planaccion.PlanCab;
import com.cnt.planaccion.controllers.PlanCabFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fvillavicencio
 */
@Named
@ViewScoped
public class PlanaccionBean implements Serializable{
    private PlanCab plan;
    private PlanCab planSel;
    private List<PlanCab> listaPlanes;
    
    @Inject //Luego del constructor
    private PlanCabFacade adminPlan;
    
    public PlanaccionBean() {
        this.plan = new PlanCab(); //Encerando un registro de la tabla
        this.listaPlanes = new ArrayList<>(); //Encerando la lista
    }

    public PlanCab getPlan() {
        return plan;
    }

    public void setPlan(PlanCab plan) {
        this.plan = plan;
    }

    public PlanCab getPlanSel() {
        return planSel;
    }

    public void setPlanSel(PlanCab planSel) {
        this.planSel = planSel;
    }

    public List<PlanCab> getListaPlanes() {
        return listaPlanes;
    }

    public void setListaPlanes(List<PlanCab> listaPlanes) {
        this.listaPlanes = listaPlanes;
    }
    
    private void cargarPlanes() {
        this.listaPlanes = adminPlan.consultarTodos();
    }
    
     public void resetearFormulario() {
        this.plan = new PlanCab();
        this.planSel = null; //No selección
    }
    
    @PostConstruct
    public void inicializar() {
        cargarPlanes();
    }
}
