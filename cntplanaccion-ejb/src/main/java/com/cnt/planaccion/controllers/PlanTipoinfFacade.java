/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnt.planaccion.controllers;

import com.cnt.planaccion.PlanTipoinf;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fvillavicencio
 */
@Stateless
public class PlanTipoinfFacade extends AbstractFacade<PlanTipoinf> {

    @PersistenceContext(unitName = "cntplanaccionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanTipoinfFacade() {
        super(PlanTipoinf.class);
    }
    
}
