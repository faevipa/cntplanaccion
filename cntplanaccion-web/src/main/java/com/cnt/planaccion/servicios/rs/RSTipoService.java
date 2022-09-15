/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnt.planaccion.servicios.rs;

import com.cnt.planaccion.PlanTipoinf;
import com.cnt.planaccion.controllers.PlanTipoinfFacade;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fvillavicencio
 */
@Path("tipo-rs")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class RSTipoService {
    @Inject
    private PlanTipoinfFacade adminTipo;
    
    @POST
    public String guardar(PlanTipoinf tipo) {
        try{
            adminTipo.guardar(tipo);
            return "Tipo guardado correctamente";
        }catch(Exception e){
            return "Error al guardar un tipo:" + e.getMessage();
        }
    }
    @PUT
    public String actualizar(PlanTipoinf tipo) {
        try{
            adminTipo.actualizar(tipo);
            return "Tipo actualizado correctamente";
        }catch(Exception e){
            return "Error al actualizar un tipo:" + e.getMessage();
        }
    }
    
    @GET
    public List<PlanTipoinf> consultarTodos() {
        return adminTipo.consultarTodos();
    }
    
    @GET
    @Path("/{id}")
    public PlanTipoinf consultarPorId(@PathParam("id") String id) {
        return adminTipo.consultaPorId(id);
    }
    
    @DELETE
    @Path("/{id}")
    public String eliminar(@PathParam("id") String id) {
        try {
            adminTipo.eliminar(adminTipo.consultaPorId(id));
            return "Cargo eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar el tipo:" + e.getMessage();
        }
    }
}