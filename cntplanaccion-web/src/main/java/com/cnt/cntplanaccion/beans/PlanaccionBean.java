/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnt.cntplanaccion.beans;

import com.matoosfe.unomina.beans.util.AbstractManagedBean;
import com.cnt.planaccion.PlanCab;
import com.cnt.planaccion.PlanEst;
import com.cnt.planaccion.controllers.PlanCabFacade;
import com.cnt.planaccion.controllers.PlanEstFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author fvillavicencio
 */
@Named
@ViewScoped
public class PlanaccionBean extends AbstractManagedBean implements Serializable{
    private PlanCab plan;
    private PlanCab planSel;
    private List<PlanCab> listaPlanes;
    private List<SelectItem> listaEstados;
    private Integer idEst;
    
    @Inject //Luego del constructor
    private PlanCabFacade adminPlan;
    @Inject
    private PlanEstFacade adminEstados;
    
    public PlanaccionBean() {
        this.plan = new PlanCab(); //Encerando un registro de la tabla
        this.listaPlanes = new ArrayList<>(); //Encerando la lista
        this.listaEstados = new ArrayList<>();
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

    public List<SelectItem> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<SelectItem> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public Integer getIdEst() {
        return idEst;
    }

    public void setIdEst(Integer idEst) {
        this.idEst = idEst;
    }
    
    
    
    public void guardar() {
        try {
            PlanEst estTmp = new PlanEst(idEst);
            this.plan.setEstId(estTmp);
            if (plan.getPlanaccCod() != null) {
                //Actualizar
                adminPlan.actualizar(plan);
                anadirInfo("Cargo actualizado correctamente");
            } else {
                //Guardar
                adminPlan.guardar(plan);
                anadirInfo("Cargo guardado correctamente");
            }
            cargarPlanes();
            resetearFormulario();
        } catch (Exception e) {
            anadirError("Error al procesar la operación:" + e.getMessage());
        }
    }
    
    /**
     * Método para seleccionar un cargo
     *
     * @param ev
     */
    public void seleccionarFila(SelectEvent<PlanCab> ev) {
        this.planSel = ev.getObject();
    }
    
    public void editar() {
        if (planSel != null) {            
            this.plan = planSel;
            this.idEst = plan.getEstId().getEstId();
            cargarEstados();            
        } else {
            anadirError("Se debe seleccionar un plan");
        }
    }
    
    public void eliminar() {
        try {
            if (planSel != null) {
                adminPlan.eliminar(planSel);                
                resetearFormulario();
            } else {
                anadirError("Se debe seleccionar un plan");
            }
        } catch (Exception e) {
            anadirError("Error al eliminar:" + e.getMessage());
        }
    }
    
    private void cargarEstados() {
        this.listaEstados.clear();
        adminEstados.consultarTodos().forEach(est -> this.listaEstados
                .add(new SelectItem(est.getEstId(), est.getEstDesc())));
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
        cargarEstados();
    }
}
