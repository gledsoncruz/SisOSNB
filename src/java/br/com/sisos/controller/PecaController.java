/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sisos.controller;

import br.com.sisos.dao.PecaDAO;
import br.com.sisos.model.Peca;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author gledson
 */
@ManagedBean
@SessionScoped
public class PecaController{


    private Peca peca = new Peca();
    private PecaDAO pecaDAO = new PecaDAO();

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }


    public void salvar(){
        
        this.pecaDAO.salvar(peca);
        this.peca = new Peca();
    }


}
