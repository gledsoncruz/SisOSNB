/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisos.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gledson
 */
public interface BaseInterfaceDAO<T, ID extends Serializable> {

    public void salvar(T obj);

    public void alterar(T obj);

    public void excluir(T obj);

    public T carregarPorId(Integer id);

    public List<T> carregarTodos();
}
