/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisos.dao;

import br.com.sisos.model.Peca;
import br.com.sisos.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gledson
 */
public class PecaDAO implements BaseInterfaceDAO<Peca, Serializable> {

    private static Session session;
    private Transaction transacao;

    public void salvar(Peca obj) {
        session = HibernateUtil.getSessionFactory().openSession();
        transacao = session.beginTransaction();
        session.save(obj);
        session.flush();
        transacao.commit();
        session.close();
    }

    public void alterar(Peca obj) {
        session = HibernateUtil.getSessionFactory().openSession();
        transacao = session.beginTransaction();
        session.update(obj);
        session.flush();
        transacao.commit();
        session.close();
    }

    public void excluir(Peca obj) {
        session = HibernateUtil.getSessionFactory().openSession();
        transacao = session.beginTransaction();
        session.delete(obj);
        session.flush();
        transacao.commit();
        session.close();
    }

    public Peca carregarPorId(Integer id) {
         session = HibernateUtil.getSessionFactory().openSession();
        transacao = session.beginTransaction();
        Peca peca = new Peca();
        peca = (Peca) session.load(Peca.class, id);
        session.flush();
        transacao.commit();
        session.close();
        return peca;
    }

    public List<Peca> carregarTodos() {
        session = HibernateUtil.getSessionFactory().openSession();
        transacao = session.beginTransaction();
        Criteria criteria = session.createCriteria(Peca.class);
        List<Peca> pecas = new ArrayList<Peca>();
        pecas = criteria.list();
        session.flush();
        transacao.commit();
        session.close();
        return pecas;
    }
}
