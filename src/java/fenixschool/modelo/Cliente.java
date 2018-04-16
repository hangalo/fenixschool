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
public class Cliente {
  
    
    private int idCliente;
    private String nomeCliente;
    private String sobrenomeCliente;
    private String telemovelCliente;
    private String telefoneCliente;
    private String emailCliente;
    private String casaCliente;
    private String bairroCliente;
    private String ruaCliente;
    private Municipio municipio;
    private TipoCliente tipoCliente;

    public Cliente() {
    }

    public Cliente(int idCliente, String nomeCliente, String sobrenomeCliente, String telemovelCliente, String telefoneCliente, String emailCliente, String casaCliente, String bairroCliente, String ruaCliente, Municipio municipio, TipoCliente tipoCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.telemovelCliente = telemovelCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
        this.casaCliente = casaCliente;
        this.bairroCliente = bairroCliente;
        this.ruaCliente = ruaCliente;
        this.municipio = municipio;
        this.tipoCliente = tipoCliente;
    }
    
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getSobrenomeCliente() {
        return sobrenomeCliente;
    }

    public void setSobrenomeCliente(String sobrenomeCliente) {
        this.sobrenomeCliente = sobrenomeCliente;
    }

    public String getTelemovelCliente() {
        return telemovelCliente;
    }

    public void setTelemovelCliente(String telemovelCliente) {
        this.telemovelCliente = telemovelCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCasaCliente() {
        return casaCliente;
    }

    public void setCasaCliente(String casaCliente) {
        this.casaCliente = casaCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getRuaCliente() {
        return ruaCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nomeCliente=" + nomeCliente + ", sobrenomeCliente=" + sobrenomeCliente + '}';
    }


    
   
}
