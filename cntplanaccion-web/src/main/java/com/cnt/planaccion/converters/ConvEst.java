/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnt.planaccion.converters;

import com.cnt.planaccion.PlanEst;
import com.cnt.planaccion.PlanTipoinf;
import com.cnt.planaccion.controllers.PlanEstFacade;
import com.cnt.planaccion.controllers.PlanTipoinfFacade;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fvillavicencio
 */

@Named("convTipo")
@RequestScoped
public class ConvEst implements Converter<PlanTipoinf>{
    
    @Inject
    private PlanTipoinfFacade adminTipo;
    
    //Viene de la pantalla
    @Override
    public PlanTipoinf getAsObject(FacesContext fc, UIComponent uic, String valorPantalla) {
       PlanTipoinf estado = null;
       if(valorPantalla != null){
           estado = adminTipo.consultaPorId(Integer.parseInt(valorPantalla));
       }
       return estado;
    }

    //Viene de la bdd
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, PlanTipoinf valorBdd) {
        String idEstado = "";
        if(valorBdd != null){
            idEstado = valorBdd.getTipoinfId();
        }
        return idEstado;
    }
    
}
