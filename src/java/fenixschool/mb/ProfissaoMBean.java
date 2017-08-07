/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.ProfissaoDAO;
import fenixschool.modelo.Profissao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PENA
 */
@Named(value = "profissaoMBean")
@RequestScoped
public class ProfissaoMBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private Profissao profissao = new Profissao();
     ProfissaoDAO profissaoDAO = new ProfissaoDAO();
    private List<Profissao> profissoes = new ArrayList<>();

    public ProfissaoMBean() {
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public List<Profissao> getProfissoes() {
        profissoes = profissaoDAO.findAll();
        return profissoes;
    }

    public void setProfissoes(List<Profissao> profissoes) {
        this.profissoes = profissoes;
    }

    public void guardar(ActionEvent evt) {
        profissaoDAO.save(profissao);
        profissao = new Profissao();
    }

}
