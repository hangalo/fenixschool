/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

/**
 *
 * @author HACKER
 */
public class Instituicao {

    private int idIsntituicao;
    private String nomeInstituicao;
    private String casaInstituicao;
    private String ruaInstituicao;
    private String bairroInstituicao;
    private String telefoneFixoInstituicao;
    private String telefoneUnitelInstituicao;
    private String telefoneMovicelInstituicao;
    private String emailInstituicao;
    private String homeInstituicao;
    private byte[] logoTipoInstituicao;
    private String urlLogoInstituicao;

    public Instituicao() {
    }

    public Instituicao(int idIsntituicao, String nomeInstituicao, String casaInstituicao, String ruaInstituicao, String bairroInstituicao, String telefoneFixoInstituicao, String telefoneUnitelInstituicao, String telefoneMovicelInstituicao, String emailInstituicao, String homeInstituicao, byte[] logoTipoInstituicao, String urlLogoInstituicao) {
        this.idIsntituicao = idIsntituicao;
        this.nomeInstituicao = nomeInstituicao;
        this.casaInstituicao = casaInstituicao;
        this.ruaInstituicao = ruaInstituicao;
        this.bairroInstituicao = bairroInstituicao;
        this.telefoneFixoInstituicao = telefoneFixoInstituicao;
        this.telefoneUnitelInstituicao = telefoneUnitelInstituicao;
        this.telefoneMovicelInstituicao = telefoneMovicelInstituicao;
        this.emailInstituicao = emailInstituicao;
        this.homeInstituicao = homeInstituicao;
        this.logoTipoInstituicao = logoTipoInstituicao;
        this.urlLogoInstituicao = urlLogoInstituicao;
    }

    public int getIdIsntituicao() {
        return idIsntituicao;
    }

    public void setIdIsntituicao(int idIsntituicao) {
        this.idIsntituicao = idIsntituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getCasaInstituicao() {
        return casaInstituicao;
    }

    public void setCasaInstituicao(String casaInstituicao) {
        this.casaInstituicao = casaInstituicao;
    }

    public String getRuaInstituicao() {
        return ruaInstituicao;
    }

    public void setRuaInstituicao(String ruaInstituicao) {
        this.ruaInstituicao = ruaInstituicao;
    }

    public String getBairroInstituicao() {
        return bairroInstituicao;
    }

    public void setBairroInstituicao(String bairroInstituicao) {
        this.bairroInstituicao = bairroInstituicao;
    }

    public String getTelefoneFixoInstituicao() {
        return telefoneFixoInstituicao;
    }

    public void setTelefoneFixoInstituicao(String telefoneFixoInstituicao) {
        this.telefoneFixoInstituicao = telefoneFixoInstituicao;
    }

    public String getTelefoneUnitelInstituicao() {
        return telefoneUnitelInstituicao;
    }

    public void setTelefoneUnitelInstituicao(String telefoneUnitelInstituicao) {
        this.telefoneUnitelInstituicao = telefoneUnitelInstituicao;
    }

    public String getTelefoneMovicelInstituicao() {
        return telefoneMovicelInstituicao;
    }

    public void setTelefoneMovicelInstituicao(String telefoneMovicelInstituicao) {
        this.telefoneMovicelInstituicao = telefoneMovicelInstituicao;
    }

    public String getEmailInstituicao() {
        return emailInstituicao;
    }

    public void setEmailInstituicao(String emailInstituicao) {
        this.emailInstituicao = emailInstituicao;
    }

    public String getHomeInstituicao() {
        return homeInstituicao;
    }

    public void setHomeInstituicao(String homeInstituicao) {
        this.homeInstituicao = homeInstituicao;
    }

    public byte[] getLogoTipoInstituicao() {
        return logoTipoInstituicao;
    }

    public void setLogoTipoInstituicao(byte[] logoTipoInstituicao) {
        this.logoTipoInstituicao = logoTipoInstituicao;
    }

    public String getUrlLogoInstituicao() {
        return urlLogoInstituicao;
    }

    public void setUrlLogoInstituicao(String urlLogoInstituicao) {
        this.urlLogoInstituicao = urlLogoInstituicao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idIsntituicao;
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
        final Instituicao other = (Instituicao) obj;
        if (this.idIsntituicao != other.idIsntituicao) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Instituicao{" + "nomeInstituicao=" + nomeInstituicao + '}';
    }
    
    

}
