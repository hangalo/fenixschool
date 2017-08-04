
package fenixschool.modelo;

import java.util.Objects;





public class Departamento {
    private Integer idDepartamento;
    private String nomeDepartamento;

    public Departamento() {
    }

    public Departamento(Integer idDepartamento, String nomeDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.idDepartamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        if (!Objects.equals(this.idDepartamento, other.idDepartamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departamento{" + "nomeDepartamento=" + nomeDepartamento + '}';
    }

    
    
    
    
}