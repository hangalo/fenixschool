/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author HACKER
 */
public class Aluno{
    private int idAluno;
    private String nomeAluno;
    private String sobrenomeAluno;
    private Date dataNascimentoAluno;
    private String nomeDoPai;
    private String nomeDaMae;
    private String biAluno;
    private Date dataEmissaoBi;
    private String localEmissaoBi; 
    private String passaportAluno;
    private Date dataEmissaoPassaporte;
    private String localEmissaoPassaporte;
    private String casaAluno;
    private String bairroAluno;
    private String distritoAluno;
    private String comunaAluno;
    private Municipio municipioAluno;
    private byte [] fotoAluno;
    private String urlfotoAluno;
    private String telefoneFixoAluno;
    private String telefoneMovelAluno;
    private String emailAluno;
    private Profissao profissaoAluno;
    private Sexo sexo;    
    private String loginAluno;
    private String passwordAluno;

    public Aluno() {
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getSobrenomeAluno() {
        return sobrenomeAluno;
    }

    public void setSobrenomeAluno(String sobrenomeAluno) {
        this.sobrenomeAluno = sobrenomeAluno;
    }

    public Date getDataNascimentoAluno() {
        return dataNascimentoAluno;
    }

    public void setDataNascimentoAluno(Date dataNascimentoAluno) {
        this.dataNascimentoAluno = dataNascimentoAluno;
    }

    public String getBiAluno() {
        return biAluno;
    }

    public void setBiAluno(String biAluno) {
        this.biAluno = biAluno;
    }

    public String getPassaportAluno() {
        return passaportAluno;
    }

    public void setPassaportAluno(String passaportAluno) {
        this.passaportAluno = passaportAluno;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCasaAluno() {
        return casaAluno;
    }

    public void setCasaAluno(String casaAluno) {
        this.casaAluno = casaAluno;
    }

    public String getBairroAluno() {
        return bairroAluno;
    }

    public void setBairroAluno(String bairroAluno) {
        this.bairroAluno = bairroAluno;
    }

    public String getDistritoAluno() {
        return distritoAluno;
    }

    public void setDistritoAluno(String distritoAluno) {
        this.distritoAluno = distritoAluno;
    }

    public Municipio getMunicipioAluno() {
        return municipioAluno;
    }

    public void setMunicipioAluno(Municipio municipioAluno) {
        this.municipioAluno = municipioAluno;
    }

    public byte[] getFotoAluno() {
        return fotoAluno;
    }

    public void setFotoAluno(byte[] fotoAluno) {
        this.fotoAluno = fotoAluno;
    }

    public String getUrlfotoAluno() {
        return urlfotoAluno;
    }

    public void setUrlfotoAluno(String urlfotoAluno) {
        this.urlfotoAluno = urlfotoAluno;
    }

    public String getTelefoneFixoAluno() {
        return telefoneFixoAluno;
    }

    public void setTelefoneFixoAluno(String telefoneFixoAluno) {
        this.telefoneFixoAluno = telefoneFixoAluno;
    }

    public String getTelefoneMovelAluno() {
        return telefoneMovelAluno;
    }

    public void setTelefoneMovelAluno(String telefoneMovelAluno) {
        this.telefoneMovelAluno = telefoneMovelAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public Profissao getProfissaoAluno() {
        return profissaoAluno;
    }

    public void setProfissaoAluno(Profissao profissaoAluno) {
        this.profissaoAluno = profissaoAluno;
    }

    public String getLoginAluno() {
        return loginAluno;
    }

    public void setLoginAluno(String loginAluno) {
        this.loginAluno = loginAluno;
    }

    public String getPasswordAluno() {
        return passwordAluno;
    }

    public void setPasswordAluno(String passwordAluno) {
        this.passwordAluno = passwordAluno;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public Date getDataEmissaoBi() {
        return dataEmissaoBi;
    }

    public void setDataEmissaoBi(Date dataEmissaoBi) {
        this.dataEmissaoBi = dataEmissaoBi;
    }

    public String getLocalEmissaoBi() {
        return localEmissaoBi;
    }

    public void setLocalEmissaoBi(String localEmissaoBi) {
        this.localEmissaoBi = localEmissaoBi;
    }

    public Date getDataEmissaoPassaporte() {
        return dataEmissaoPassaporte;
    }

    public void setDataEmissaoPassaporte(Date dataEmissaoPassaporte) {
        this.dataEmissaoPassaporte = dataEmissaoPassaporte;
    }

    public String getLocalEmissaoPassaporte() {
        return localEmissaoPassaporte;
    }

    public void setLocalEmissaoPassaporte(String localEmissaoPassaporte) {
        this.localEmissaoPassaporte = localEmissaoPassaporte;
    }

    public String getComunaAluno() {
        return comunaAluno;
    }

    public void setComunaAluno(String comunaAluno) {
        this.comunaAluno = comunaAluno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idAluno;
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
        final Aluno other = (Aluno) obj;
        if (this.idAluno != other.idAluno) {
            return false;
        }
        return true;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Aluno{" + "nomeAluno=" + nomeAluno + ", sobrenomeAluno=" + sobrenomeAluno + '}';
    }
}