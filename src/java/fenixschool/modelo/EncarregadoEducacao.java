package fenixschool.modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class EncarregadoEducacao implements Serializable{

    private Integer idEncarregadoEducacao;
    private String nomeEncarregado;
    private String sobrenomeEncarregado;
    private Profissao profissao;
    private Sexo sexo;
    private String casaEncarregado;
    private String ruaEncarregado;
    private String bairroEncarregado;
    private String distritoUrbanoEncarregado;
    private String telemovelPrincipalEncarregado;
    private String telemovelAlternativoEncarregado;
    private String emailPrincipalEncarregado;
    private String emailAlternativoEncarregado;
    private byte[] fotoEncarregado;
    private String urlFotoEncarregado;
    private Municipio municipio;

    public EncarregadoEducacao() {
    }

    public EncarregadoEducacao(Integer idEncarregadoEducacao, String nomeEncarregado, String sobrenomeEncarregado, Profissao profissao, Sexo sexo, String casaEncarregado, String ruaEncarregado, String bairroEncarregado, String distritoUrbanoEncarregado, String telemovelPrincipalEncarregado, String telemovelAlternativoEncarregado, String emailPrincipalEncarregado, String emailAlternativoEncarregado, byte[] fotoEncarregado, String urlFotoEncarregado, Municipio municipio) {
        this.idEncarregadoEducacao = idEncarregadoEducacao;
        this.nomeEncarregado = nomeEncarregado;
        this.sobrenomeEncarregado = sobrenomeEncarregado;
        this.profissao = profissao;
        this.sexo = sexo;
        this.casaEncarregado = casaEncarregado;
        this.ruaEncarregado = ruaEncarregado;
        this.bairroEncarregado = bairroEncarregado;
        this.distritoUrbanoEncarregado = distritoUrbanoEncarregado;
        this.telemovelPrincipalEncarregado = telemovelPrincipalEncarregado;
        this.telemovelAlternativoEncarregado = telemovelAlternativoEncarregado;
        this.emailPrincipalEncarregado = emailPrincipalEncarregado;
        this.emailAlternativoEncarregado = emailAlternativoEncarregado;
        this.fotoEncarregado = fotoEncarregado;
        this.urlFotoEncarregado = urlFotoEncarregado;
        this.municipio = municipio;
    }

   

    public Integer getIdEncarregadoEducacao() {
        return idEncarregadoEducacao;
    }

    public void setIdEncarregadoEducacao(Integer idEncarregadoEducacao) {
        this.idEncarregadoEducacao = idEncarregadoEducacao;
    }

    public String getNomeEncarregado() {
        return nomeEncarregado;
    }

    public void setNomeEncarregado(String nomeEncarregado) {
        this.nomeEncarregado = nomeEncarregado;
    }

    public String getSobrenomeEncarregado() {
        return sobrenomeEncarregado;
    }

    public void setSobrenomeEncarregado(String sobrenomeEncarregado) {
        this.sobrenomeEncarregado = sobrenomeEncarregado;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCasaEncarregado() {
        return casaEncarregado;
    }

    public void setCasaEncarregado(String casaEncarregado) {
        this.casaEncarregado = casaEncarregado;
    }

    public String getRuaEncarregado() {
        return ruaEncarregado;
    }

    public void setRuaEncarregado(String ruaEncarregado) {
        this.ruaEncarregado = ruaEncarregado;
    }

    public String getBairroEncarregado() {
        return bairroEncarregado;
    }

    public void setBairroEncarregado(String bairroEncarregado) {
        this.bairroEncarregado = bairroEncarregado;
    }

    public String getDistritoUrbanoEncarregado() {
        return distritoUrbanoEncarregado;
    }

    public void setDistritoUrbanoEncarregado(String distritoUrbanoEncarregado) {
        this.distritoUrbanoEncarregado = distritoUrbanoEncarregado;
    }

    public String getTelemovelPrincipalEncarregado() {
        return telemovelPrincipalEncarregado;
    }

    public void setTelemovelPrincipalEncarregado(String telemovelPrincipalEncarregado) {
        this.telemovelPrincipalEncarregado = telemovelPrincipalEncarregado;
    }

    public String getTelemovelAlternativoEncarregado() {
        return telemovelAlternativoEncarregado;
    }

    public void setTelemovelAlternativoEncarregado(String telemovelAlternativoEncarregado) {
        this.telemovelAlternativoEncarregado = telemovelAlternativoEncarregado;
    }

    public String getEmailPrincipalEncarregado() {
        return emailPrincipalEncarregado;
    }

    public void setEmailPrincipalEncarregado(String emailPrincipalEncarregado) {
        this.emailPrincipalEncarregado = emailPrincipalEncarregado;
    }

    public String getEmailAlternativoEncarregado() {
        return emailAlternativoEncarregado;
    }

    public void setEmailAlternativoEncarregado(String emailAlternativoEncarregado) {
        this.emailAlternativoEncarregado = emailAlternativoEncarregado;
    }

    public byte[] getFotoEncarregado() {
        return fotoEncarregado;
    }

    public void setFotoEncarregado(byte[] fotoEncarregado) {
        this.fotoEncarregado = fotoEncarregado;
    }

    public String getUrlFotoEncarregado() {
        return urlFotoEncarregado;
    }

    public void setUrlFotoEncarregado(String urlFotoEncarregado) {
        this.urlFotoEncarregado = urlFotoEncarregado;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idEncarregadoEducacao);
        hash = 97 * hash + Objects.hashCode(this.nomeEncarregado);
        hash = 97 * hash + Objects.hashCode(this.sobrenomeEncarregado);
        hash = 97 * hash + Objects.hashCode(this.profissao);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.casaEncarregado);
        hash = 97 * hash + Objects.hashCode(this.ruaEncarregado);
        hash = 97 * hash + Objects.hashCode(this.bairroEncarregado);
        hash = 97 * hash + Objects.hashCode(this.distritoUrbanoEncarregado);
        hash = 97 * hash + Objects.hashCode(this.telemovelPrincipalEncarregado);
        hash = 97 * hash + Objects.hashCode(this.telemovelAlternativoEncarregado);
        hash = 97 * hash + Objects.hashCode(this.emailPrincipalEncarregado);
        hash = 97 * hash + Objects.hashCode(this.emailAlternativoEncarregado);
        hash = 97 * hash + Arrays.hashCode(this.fotoEncarregado);
        hash = 97 * hash + Objects.hashCode(this.urlFotoEncarregado);
        hash = 97 * hash + Objects.hashCode(this.municipio);
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
        final EncarregadoEducacao other = (EncarregadoEducacao) obj;
        if (!Objects.equals(this.nomeEncarregado, other.nomeEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.sobrenomeEncarregado, other.sobrenomeEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.casaEncarregado, other.casaEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.ruaEncarregado, other.ruaEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.bairroEncarregado, other.bairroEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.distritoUrbanoEncarregado, other.distritoUrbanoEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.telemovelPrincipalEncarregado, other.telemovelPrincipalEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.telemovelAlternativoEncarregado, other.telemovelAlternativoEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.emailPrincipalEncarregado, other.emailPrincipalEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.emailAlternativoEncarregado, other.emailAlternativoEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.urlFotoEncarregado, other.urlFotoEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.idEncarregadoEducacao, other.idEncarregadoEducacao)) {
            return false;
        }
        if (!Objects.equals(this.profissao, other.profissao)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Arrays.equals(this.fotoEncarregado, other.fotoEncarregado)) {
            return false;
        }
        if (!Objects.equals(this.municipio, other.municipio)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  this.nomeEncarregado;
    }

    
}
