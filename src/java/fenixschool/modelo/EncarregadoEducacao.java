package fenixschool.modelo;

import java.io.Serializable;
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
    private String loginEncarregado;
    private String passwordEncarregado;
    
    public EncarregadoEducacao() {
    }

    public EncarregadoEducacao(Integer idEncarregadoEducacao, String nomeEncarregado, String sobrenomeEncarregado, Profissao profissao, Sexo sexo, String casaEncarregado, String ruaEncarregado, String bairroEncarregado, String distritoUrbanoEncarregado, String telemovelPrincipalEncarregado, String telemovelAlternativoEncarregado, String emailPrincipalEncarregado, String emailAlternativoEncarregado, byte[] fotoEncarregado, String urlFotoEncarregado, Municipio municipio, String loginEncarregado, String passwordEncarregado) {
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
        this.loginEncarregado = loginEncarregado;
        this.passwordEncarregado = passwordEncarregado;
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

    public String getLoginEncarregado() {
        return loginEncarregado;
    }

    public void setLoginEncarregado(String loginEncarregado) {
        this.loginEncarregado = loginEncarregado;
    }

    public String getPasswordEncarregado() {
        return passwordEncarregado;
    }

    public void setPasswordEncarregado(String passwordEncarregado) {
        this.passwordEncarregado = passwordEncarregado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idEncarregadoEducacao);
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
        if (!Objects.equals(this.idEncarregadoEducacao, other.idEncarregadoEducacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EncarregadoEducacao{" + "nomeEncarregado=" + nomeEncarregado + '}';
    }
}
