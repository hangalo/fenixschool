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
public class CicloLectivo {

    private Integer idCicloLectivo;
    private String CicloLectivo;

    public CicloLectivo() {
    }

    public CicloLectivo(Integer idCicloLectivo, String CicloLectivo) {
        this.idCicloLectivo = idCicloLectivo;
        this.CicloLectivo = CicloLectivo;
    }

    public Integer getIdCicloLectivo() {
        return idCicloLectivo;
    }

    public void setIdCicloLectivo(int idCicloLectivo) {
        this.idCicloLectivo = idCicloLectivo;
    }

    public String getCicloLectivo() {
        return CicloLectivo;
    }

    public void setCicloLectivo(String CicloLectivo) {
        this.CicloLectivo = CicloLectivo;
    }

}
