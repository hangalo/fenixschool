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
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PENA
 */
@Named(value = "encarregadoEducacaoMBean")
@RequestScoped
public class EncarregadoEducacaoMBean {

    private EncarregadoEducacao encarregadoEducacao = new EncarregadoEducacao();
    EncarregadoEducacaoDAO encarregadoEducacaoDAO = new EncarregadoEducacaoDAO();
    private List<EncarregadoEducacao> encarregadosEducacao = new ArrayList<>();
    
    ProfissaoDAO profissaoDAO = new ProfissaoDAO();
    private List<Profissao> profissoes = new ArrayList<>();
    

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
    
    public  void guardar(ActionEvent evt){
        encarregadoEducacaoDAO.save(encarregadoEducacao);
        encarregadoEducacao = new EncarregadoEducacao();
    }

    public List<Profissao> getProssifoes() {
        profissoes = profissaoDAO.findAll();
        return profissoes;
    }

    public void setProssifoes(List<Profissao> profissoes) {
        this.profissoes = profissoes;
    }
}
