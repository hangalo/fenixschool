
package fenixschool.modelo;


public class Municipio {
    private Integer idMunicipio;
    private String nomeMunicipio;
    private Provincia provinciaMunicipio;

    public Municipio() {
    }

    public Municipio(Integer idMunicipio, String nomeMunicipio, Provincia provinciaMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.provinciaMunicipio = provinciaMunicipio;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Provincia getProvinciaMunicipio() {
        return provinciaMunicipio;
    }

    public void setProvinciaMunicipio(Provincia provinciaMunicipio) {
        this.provinciaMunicipio = provinciaMunicipio;
    }

   
    
}
