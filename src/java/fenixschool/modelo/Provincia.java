/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

/**
 *
 * @author informatica
 */
public class Provincia {
    private Integer idProvincia;
    private String nomeProvincia;
    

    public Provincia() {
    }

    public Provincia(Integer idProvincia, String nomeProvincia, Pais paisProvincia) {
        this.idProvincia = idProvincia;
        this.nomeProvincia = nomeProvincia;
        
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNomeProvincia() {
        return nomeProvincia;
    }

    public void setNomeProvincia(String nomeProvincia) {
        this.nomeProvincia = nomeProvincia;
    }

    @Override
    public String toString() {
        return this.nomeProvincia;
    }

   

   
   
}
