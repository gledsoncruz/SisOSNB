/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sisos.util;

import br.com.sisos.model.Autorizacao;
import br.com.sisos.model.Cliente;
import br.com.sisos.model.Peca;
import br.com.sisos.model.Servico;
import br.com.sisos.model.ServicoPeca;
import br.com.sisos.model.ServicoStatus;
import br.com.sisos.model.Tecnico;
import br.com.sisos.model.TipoServico;
import br.com.sisos.model.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author gledson
 */
public class GerarTabelas {

    public static void main(String[] args){

        try {
        AnnotationConfiguration ac = new AnnotationConfiguration();
        ac.addAnnotatedClass(Autorizacao.class);
        ac.addAnnotatedClass(Cliente.class);
        ac.addAnnotatedClass(Peca.class);
        ac.addAnnotatedClass(Servico.class);
        ac.addAnnotatedClass(ServicoPeca.class);
        ac.addAnnotatedClass(ServicoStatus.class);
        ac.addAnnotatedClass(Tecnico.class);
        ac.addAnnotatedClass(TipoServico.class);
        ac.addAnnotatedClass(Usuario.class);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory = ac.configure().buildSessionFactory();
        SchemaExport se = new SchemaExport(ac);
        se.create(true, true);
    }catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
     }


    }


}
