package fenixschool.modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class EncarregadoEducacao implements Serializable{

<<<<<<< HEAD
    private Integer id_encarregado_educacao;
    private String nome_encarregado;
    private String sobrenome_encarregado;
    private Profissao id_profissao_encarregado;
    private Sexo sexo_encarregado;
    private String casa_encarregado;
    private String rua_encarregado;
    private String bairro_encarregado;
    private String distrito_urbano_encarregado;
    private String telemovel_principal_encarregado;
    private String telemovel_alternativo_encarregado;
    private String email_principal_encarregado;
    private String email_alternativo_encarregado;
    private byte[] foto_encarregado;
    private String url_foto_encarregado;
=======
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
>>>>>>> b69123825d74c301d4e3c6e31184abbfab901fc2
    private Municipio municipio;

    public EncarregadoEducacao() {
    }

<<<<<<< HEAD
    public EncarregadoEducacao(Integer id_encarregado_educacao, String nome_encarregado, String sobrenome_encarregado, Profissao id_profissao_encarregado, Sexo sexo_encarregado, String casa_encarregado, String rua_encarregado, String bairro_encarregado, String distrito_urbano_encarregado, String telemovel_principal_encarregado, String telemovel_alternativo_encarregado, String email_principal_encarregado, String email_alternativo_encarregado, byte[] foto_encarregado, String url_foto_encarregado, Municipio municipio) {
        this.id_encarregado_educacao = id_encarregado_educacao;
        this.nome_encarregado = nome_encarregado;
        this.sobrenome_encarregado = sobrenome_encarregado;
        this.id_profissao_encarregado = id_profissao_encarregado;
        this.sexo_encarregado = sexo_encarregado;
        this.casa_encarregado = casa_encarregado;
        this.rua_encarregado = rua_encarregado;
        this.bairro_encarregado = bairro_encarregado;
        this.distrito_urbano_encarregado = distrito_urbano_encarregado;
        this.telemovel_principal_encarregado = telemovel_principal_encarregado;
        this.telemovel_alternativo_encarregado = telemovel_alternativo_encarregado;
        this.email_principal_encarregado = email_principal_encarregado;
        this.email_alternativo_encarregado = email_alternativo_encarregado;
        this.foto_encarregado = foto_encarregado;
        this.url_foto_encarregado = url_foto_encarregado;
        this.municipio = municipio;
=======
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
>>>>>>> b69123825d74c301d4e3c6e31184abbfab901fc2
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

<<<<<<< HEAD
    public Profissao getId_profissao_encarregado() {
        return id_profissao_encarregado;
    }

    public void setId_profissao_encarregado(Profissao id_profissao_encarregado) {
        this.id_profissao_encarregado = id_profissao_encarregado;
    }

    public Sexo getSexo_encarregado() {
        return sexo_encarregado;
    }

    public void setSexo_encarregado(Sexo sexo_encarregado) {
        this.sexo_encarregado = sexo_encarregado;
    }

    public String getCasa_encarregado() {
        return casa_encarregado;
    }

    public void setCasa_encarregado(String casa_encarregado) {
        this.casa_encarregado = casa_encarregado;
    }

    public String getRua_encarregado() {
        return rua_encarregado;
    }

    public void setRua_encarregado(String rua_encarregado) {
        this.rua_encarregado = rua_encarregado;
    }

    public String getBairro_encarregado() {
        return bairro_encarregado;
    }

    public void setBairro_encarregado(String bairro_encarregado) {
        this.bairro_encarregado = bairro_encarregado;
    }

    public String getDistrito_urbano_encarregado() {
        return distrito_urbano_encarregado;
    }

    public void setDistrito_urbano_encarregado(String distrito_urbano_encarregado) {
        this.distrito_urbano_encarregado = distrito_urbano_encarregado;
    }

    public String getTelemovel_principal_encarregado() {
        return telemovel_principal_encarregado;
    }

    public void setTelemovel_principal_encarregado(String telemovel_principal_encarregado) {
        this.telemovel_principal_encarregado = telemovel_principal_encarregado;
    }

    public String getTelemovel_alternativo_encarregado() {
        return telemovel_alternativo_encarregado;
    }

    public void setTelemovel_alternativo_encarregado(String telemovel_alternativo_encarregado) {
        this.telemovel_alternativo_encarregado = telemovel_alternativo_encarregado;
    }

    public String getEmail_principal_encarregado() {
        return email_principal_encarregado;
    }

    public void setEmail_principal_encarregado(String email_principal_encarregado) {
        this.email_principal_encarregado = email_principal_encarregado;
    }

    public String getEmail_alternativo_encarregado() {
        return email_alternativo_encarregado;
    }

    public void setEmail_alternativo_encarregado(String email_alternativo_encarregado) {
        this.email_alternativo_encarregado = email_alternativo_encarregado;
    }

    public byte[] getFoto_encarregado() {
        return foto_encarregado;
    }

    public void setFoto_encarregado(byte[] foto_encarregado) {
        this.foto_encarregado = foto_encarregado;
    }

    public String getUrl_foto_encarregado() {
        return url_foto_encarregado;
    }

    public void setUrl_foto_encarregado(String url_foto_encarregado) {
        this.url_foto_encarregado = url_foto_encarregado;
    }

=======
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

>>>>>>> b69123825d74c301d4e3c6e31184abbfab901fc2
    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
<<<<<<< HEAD
        hash = 97 * hash + Objects.hashCode(this.id_encarregado_educacao);
        hash = 97 * hash + Objects.hashCode(this.nome_encarregado);
        hash = 97 * hash + Objects.hashCode(this.sobrenome_encarregado);
        hash = 97 * hash + Objects.hashCode(this.id_profissao_encarregado);
        hash = 97 * hash + Objects.hashCode(this.sexo_encarregado);
        hash = 97 * hash + Objects.hashCode(this.casa_encarregado);
        hash = 97 * hash + Objects.hashCode(this.rua_encarregado);
        hash = 97 * hash + Objects.hashCode(this.bairro_encarregado);
        hash = 97 * hash + Objects.hashCode(this.distrito_urbano_encarregado);
        hash = 97 * hash + Objects.hashCode(this.telemovel_principal_encarregado);
        hash = 97 * hash + Objects.hashCode(this.telemovel_alternativo_encarregado);
        hash = 97 * hash + Objects.hashCode(this.email_principal_encarregado);
        hash = 97 * hash + Objects.hashCode(this.email_alternativo_encarregado);
        hash = 97 * hash + Arrays.hashCode(this.foto_encarregado);
        hash = 97 * hash + Objects.hashCode(this.url_foto_encarregado);
=======
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
>>>>>>> b69123825d74c301d4e3c6e31184abbfab901fc2
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
<<<<<<< HEAD
        if (!Objects.equals(this.nome_encarregado, other.nome_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.sobrenome_encarregado, other.sobrenome_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.casa_encarregado, other.casa_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.rua_encarregado, other.rua_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.bairro_encarregado, other.bairro_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.distrito_urbano_encarregado, other.distrito_urbano_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.telemovel_principal_encarregado, other.telemovel_principal_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.telemovel_alternativo_encarregado, other.telemovel_alternativo_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.email_principal_encarregado, other.email_principal_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.email_alternativo_encarregado, other.email_alternativo_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.url_foto_encarregado, other.url_foto_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.id_encarregado_educacao, other.id_encarregado_educacao)) {
            return false;
        }
        if (!Objects.equals(this.id_profissao_encarregado, other.id_profissao_encarregado)) {
            return false;
        }
        if (this.sexo_encarregado != other.sexo_encarregado) {
            return false;
        }
        if (!Arrays.equals(this.foto_encarregado, other.foto_encarregado)) {
            return false;
        }
=======
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
>>>>>>> b69123825d74c301d4e3c6e31184abbfab901fc2
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
