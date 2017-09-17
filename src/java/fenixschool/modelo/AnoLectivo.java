/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class AnoLectivo {
    private int IdAnoLectivo;
    private String anoLectivo;
    private Date inicioAnoLetivo;
    private Date fimAnoLetivo;

    public AnoLectivo() {
    }

    public AnoLectivo(int IdAnoLectivo, String anoLectivo, Date inicioAnoLetivo, Date fimAnoLetivo) {
        this.IdAnoLectivo = IdAnoLectivo;
        this.anoLectivo = anoLectivo;
        this.inicioAnoLetivo = inicioAnoLetivo;
        this.fimAnoLetivo = fimAnoLetivo;
    }

    public int getIdAnoLectivo() {
        return IdAnoLectivo;
    }

    public void setIdAnoLectivo(int IdAnoLectivo) {
        this.IdAnoLectivo = IdAnoLectivo;
    }

    public String getAnoLectivo() {
        return anoLectivo;
    }

    public void setAnoLectivo(String anoLectivo) {
        this.anoLectivo = anoLectivo;
    }

    public Date getInicioAnoLetivo() {
        return inicioAnoLetivo;
    }

    public void setInicioAnoLetivo(Date inicioAnoLetivo) {
        this.inicioAnoLetivo = inicioAnoLetivo;
    }

    public Date getFimAnoLetivo() {
        return fimAnoLetivo;
    }

    public void setFimAnoLetivo(Date fimAnoLetivo) {
        this.fimAnoLetivo = fimAnoLetivo;
    }
    
    
}
