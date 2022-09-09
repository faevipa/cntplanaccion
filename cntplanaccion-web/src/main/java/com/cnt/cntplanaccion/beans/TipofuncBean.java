/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnt.cntplanaccion.beans;

import com.cnt.planaccion.PlanTipoinf;
import com.cnt.planaccion.controllers.PlanTipoinfFacade;
import com.matoosfe.unomina.beans.util.AbstractManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class TipofuncBean extends AbstractManagedBean implements Serializable{
    private PlanTipoinf tipoinf;
    private PlanTipoinf tipoinfsel;
    private List<PlanTipoinf> listaTipofunc;
    
    @Inject //Luego del constructor
    private PlanTipoinfFacade adminTipoFunc;
    
    public TipofuncBean() {
        this.tipoinf = new PlanTipoinf(); //Encerando un registro de la tabla
        this.listaTipofunc = new ArrayList<>(); //Encerando la lista
    }

    public PlanTipoinf getTipoinf() {
        return tipoinf;
    }

    public void setTipoinf(PlanTipoinf tipoinf) {
        this.tipoinf = tipoinf;
    }

    public PlanTipoinf getTipoinfsel() {
        return tipoinfsel;
    }

    public void setTipoinfsel(PlanTipoinf tipoinfsel) {
        this.tipoinfsel = tipoinfsel;
    }

    public List<PlanTipoinf> getListaTipofunc() {
        return listaTipofunc;
    }

    public void setListaTipofunc(List<PlanTipoinf> listaTipofunc) {
        this.listaTipofunc = listaTipofunc;
    }
    
    public void guardar() {
        try {
            if (tipoinf.getTipoinfId()!= null) {
                //Actualizar
                adminTipoFunc.actualizar(tipoinf);
                anadirInfo("Cargo actualizado correctamente");
            } else {
                //Guardar
                adminTipoFunc.guardar(tipoinf);
                anadirInfo("Cargo guardado correctamente");
            }
            cargarTipoFunc();
            resetearFormulario();
        } catch (Exception e) {
            anadirError("Error al procesar la operación:" + e.getMessage());
        }
    }
    
    private void cargarTipoFunc() {
        this.listaTipofunc = adminTipoFunc.consultarTodos();
    }
    
    /**
     * Método para seleccionar un cargo
     *
     * @param ev
     */
    public void seleccionarFila(SelectEvent<PlanTipoinf> ev) {
        this.tipoinfsel = ev.getObject();
    }

    /**
     * Método para cargar el cargo seleccionado
     */
    public void editar() {
        if (tipoinfsel != null) {
            this.tipoinf = tipoinfsel;
        } else {
            anadirError("Se debe seleccionar un cargo");
        }
    }
    
    public void eliminar() {
        try {
            if (tipoinfsel != null) {
                adminTipoFunc.eliminar(tipoinfsel);
                cargarTipoFunc();
                resetearFormulario();
            } else {
                anadirError("Se debe seleccionar un tipo de informe");
            }
        } catch (Exception e) {
            anadirError("Error al eliminar:" + e.getMessage());
        }
    }
    
     public void resetearFormulario() {
        this.tipoinf = new PlanTipoinf();
        this.tipoinfsel = null; //No selección
    }
    
    @PostConstruct
    public void inicializar() {
        cargarTipoFunc();
    }
}
