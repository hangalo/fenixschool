/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

/**
 *
 * @author HP
 */
public class TipoDisciplina {
    private Integer idTipoDisciplina;
    private String tipoDisciplina;
    
    public TipoDisciplina(){}

    public TipoDisciplina(Integer idTipoDisciplina, String tipoDisciplina) {
        this.idTipoDisciplina = idTipoDisciplina;
        this.tipoDisciplina = tipoDisciplina;
    }

    public Integer getIdTipoDisciplina() {
        return idTipoDisciplina;
    }

    public void setIdTipoDisciplina(Integer idTipoDisciplina) {
        this.idTipoDisciplina = idTipoDisciplina;
    }

    public String getTipoDisciplina() {
        return tipoDisciplina;
    }

    public void setTipoDisciplina(String tipoDisciplina) {
        this.tipoDisciplina = tipoDisciplina;
    }
    
    
}
