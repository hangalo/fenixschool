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
    private String numeroAluno;
    private String nomeAluno;
    private String sobrenomeAluno;
    private Date dataNascimentoAluno;
    private Sexo sexo;
    private String casaAluno;
    private String bairroAluno;
    private String distritoAluno;
    private Municipio municipioAluno;
    private byte [] fotoAluno;
    private String urlfotoAluno;
    private String telefoneFixoAluno;
    private String telefoneMovelAluno;
    private String emailAluno;
    private Profissao profissaoAluno;

    public Aluno() {
    }

    public Aluno(int idAluno, String numeroAluno, String nomeAluno, String sobrenomeAluno, Date dataNascimentoAluno, Sexo sexo, String casaAluno, String bairroAluno, String distritoAluno, Municipio municipioAluno, byte[] fotoAluno, String urlfotoAluno, String telefoneFixoAluno, String telefoneMovelAluno, String emailAluno, Profissao profissaoAluno) {
        this.idAluno = idAluno;
        this.numeroAluno = numeroAluno;
        this.nomeAluno = nomeAluno;
        this.sobrenomeAluno = sobrenomeAluno;
        this.dataNascimentoAluno = dataNascimentoAluno;
        this.sexo = sexo;
        this.casaAluno = casaAluno;
        this.bairroAluno = bairroAluno;
        this.distritoAluno = distritoAluno;
        this.municipioAluno = municipioAluno;
        this.fotoAluno = fotoAluno;
        this.urlfotoAluno = urlfotoAluno;
        this.telefoneFixoAluno = telefoneFixoAluno;
        this.telefoneMovelAluno = telefoneMovelAluno;
        this.emailAluno = emailAluno;
        this.profissaoAluno = profissaoAluno;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNumeroAluno() {
        return numeroAluno;
    }

    public void setNumeroAluno(String numeroAluno) {
        this.numeroAluno = numeroAluno;
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
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idAluno;
        hash = 41 * hash + Objects.hashCode(this.numeroAluno);
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
        if (!Objects.equals(this.numeroAluno, other.numeroAluno)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aluno{" + "numeroAluno=" + numeroAluno + ", nomeAluno=" + nomeAluno + '}';
    }
    
    
    
    
}
