/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.EncarregadoEducacaoDAO;
import fenixschool.dao.ProfissaoDAO;
import fenixschool.modelo.EncarregadoEducacao;
import fenixschool.modelo.Profissao;
import fenixschool.modelo.Sexo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author PENA
 */
@Named(value = "encarregadoEducacaoMBean")
@RequestScoped
public class EncarregadoEducacaoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private EncarregadoEducacao encarregadoEducacao;

    private List<EncarregadoEducacao> encarregadosEducacao;
    private List<Profissao> profissoes;
    private ProfissaoDAO profissaoDAO;
    private EncarregadoEducacaoDAO encarregadoEducacaoDAO;

    @PostConstruct
    public void inicializar() {

        encarregadoEducacao = new EncarregadoEducacao();
        encarregadoEducacaoDAO = new EncarregadoEducacaoDAO();
        encarregadosEducacao = new ArrayList<>();

        profissaoDAO = new ProfissaoDAO();
        profissoes = new ArrayList<>();
    }

    public EncarregadoEducacao getEncarregadoEducacao() {
        return encarregadoEducacao;
    }

    public void setEncarregadoEducacao(EncarregadoEducacao encarregadoEducacao) {
        this.encarregadoEducacao = encarregadoEducacao;
    }

    public List<EncarregadoEducacao> getEncarregadosEducacao() {
        encarregadosEducacao = encarregadoEducacaoDAO.findAll();
        return encarregadosEducacao;
    }

    public void setEncarregadosEducacao(List<EncarregadoEducacao> encarregadosEducacao) {
        this.encarregadosEducacao = encarregadosEducacao;
    }

    public void guardar(ActionEvent evt) {
        encarregadoEducacaoDAO.save(encarregadoEducacao);
        encarregadoEducacao = new EncarregadoEducacao();
    }

    public List<Profissao> getProssifoes() {
        profissoes = profissaoDAO.findAll();
        return profissoes;
    }

     public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getAbreviatura()));
        }
        return list;
    }
    public void setProssifoes(List<Profissao> profissoes) {
        this.profissoes = profissoes;
    }
}
