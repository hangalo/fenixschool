package fenixschool.modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class EncarregadoEducacao implements Serializable{

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
    private Municipio municipio;

    public EncarregadoEducacao() {
    }

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
    }

    public Integer getId_encarregado_educacao() {
        return id_encarregado_educacao;
    }

    public void setId_encarregado_educacao(Integer id_encarregado_educacao) {
        this.id_encarregado_educacao = id_encarregado_educacao;
    }

    public String getNome_encarregado() {
        return nome_encarregado;
    }

    public void setNome_encarregado(String nome_encarregado) {
        this.nome_encarregado = nome_encarregado;
    }

    public String getSobrenome_encarregado() {
        return sobrenome_encarregado;
    }

    public void setSobrenome_encarregado(String sobrenome_encarregado) {
        this.sobrenome_encarregado = sobrenome_encarregado;
    }

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

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (!Objects.equals(this.municipio, other.municipio)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EncarregadoEducacao{" + "nome_encarregado=" + nome_encarregado + '}';
    }

    
}
