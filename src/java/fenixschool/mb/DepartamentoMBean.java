/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.DepartamentoDAO;
import fenixschool.modelo.Departamento;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PENA
 */
@Named(value = "departamentoMBean")
@RequestScoped
public class DepartamentoMBean implements Serializable {

    private Departamento departamento = new Departamento();
     DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    private List<Departamento> departamentos = new ArrayList<>();

    public DepartamentoMBean() {
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void guardar(ActionEvent evt) {
        departamentoDAO.save(departamento);
        departamento = new Departamento();
    }

    public List<Departamento> getDepartamentos() {
        departamentos=departamentoDAO.findAll();
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    
}
