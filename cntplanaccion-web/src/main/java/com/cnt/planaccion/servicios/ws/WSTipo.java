/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.cnt.planaccion.servicios.ws;

import com.cnt.planaccion.PlanTipoinf;
import com.cnt.planaccion.controllers.PlanTipoinfFacade;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fvillavicencio
 */
@WebService(name = "ServiceTipo")
public class WSTipo {
       
    @Inject
    private PlanTipoinfFacade adminTipo;
   /**
     * Método para imprimir el nombre enviado como parámetro.
     *
     * @WebMethod es para configurar el nombre del método, si no se utiliza el
     * atributo operation name, el nombre de la operación es el nombre del
     * método. De igual manera para especificar el nombre de los parámetros se
     * utiliza la anotación @WebParam
     * @param txt
     * @return
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod
    public String guardarTipo(PlanTipoinf tipo) {
        String mensaje = null;
        try{
        adminTipo.guardar(tipo);
        mensaje = "Cargo guardado correctamente";
        }catch(Exception e){
            mensaje = "Error al guardar un tipo:" + e.getMessage();
        }
        return mensaje;
    }
    
    @WebMethod
    public String actualizarTipo(PlanTipoinf tipo) {
        String mensaje = null;
        try{
        adminTipo.actualizar(tipo);
        mensaje = "Cargo actualizado correctamente";
        }catch(Exception e){
            mensaje = "Error al actualizar un tipo:" + e.getMessage();
        }
        return mensaje;
    }
    
    @WebMethod
    public String eliminarTipo(PlanTipoinf tipo) {
        String mensaje = null;
        try{
        adminTipo.eliminar(tipo);
        mensaje = "Cargo eliminado correctamente";
        }catch(Exception e){
            mensaje = "Error al eliminar un cargo:" + e.getMessage();
        }
        return mensaje;
    }
    
    @WebMethod(operationName = "consultarTodos")
    public List<PlanTipoinf> consultar() throws Exception {
        List<PlanTipoinf> tipos = new ArrayList<>();
        try {
            tipos = adminTipo.consultarTodos();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return tipos;
    }
}
