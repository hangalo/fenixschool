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
public class PeriodoLectivo {
    private Integer idPeriodoLectivo;
    private String periodoLectivo;
    
    public PeriodoLectivo(){}

    public PeriodoLectivo(Integer idPeriodoLectivo, String periodoLectivo) {
        this.idPeriodoLectivo = idPeriodoLectivo;
        this.periodoLectivo = periodoLectivo;
    }

    public Integer getIdPeriodoLectivo() {
        return idPeriodoLectivo;
    }

    public void setIdPeriodoLectivo(Integer idPeriodoLectivo) {
        this.idPeriodoLectivo = idPeriodoLectivo;
    }

    public String getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(String periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }
    
    
    
}
