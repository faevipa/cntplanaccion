/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnt.planaccion.controllers;

import com.cnt.planaccion.PlanGere;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fvillavicencio
 */
@Stateless
public class PlanGereFacade extends AbstractFacade<PlanGere> {

    @PersistenceContext(unitName = "cntplanaccionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanGereFacade() {
        super(PlanGere.class);
    }
    
}
