package fenixschool.modelo;

import java.util.Objects;

public class EncarregadoEducacao {
    private Integer id_encarregado_educacao;
    private String nome_encarregado;
    private String sobrenome_encarregado;
    private Profissao id_profissao;
    private Sexo id_sexo;

    public EncarregadoEducacao() {
    }

    public EncarregadoEducacao(Integer id_encarregado_educacao, String nome_encarregado, String sobrenome_encarregado, Profissao id_profissao, Sexo id_sexo) {
        this.id_encarregado_educacao = id_encarregado_educacao;
        this.nome_encarregado = nome_encarregado;
        this.sobrenome_encarregado = sobrenome_encarregado;
        this.id_profissao = id_profissao;
        this.id_sexo = id_sexo;
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

    public Profissao getId_profissao() {
        return id_profissao;
    }

    public void setId_profissao(Profissao id_profissao) {
        this.id_profissao = id_profissao;
    }

    public Sexo getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(Sexo id_sexo) {
        this.id_sexo = id_sexo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id_encarregado_educacao);
        hash = 53 * hash + Objects.hashCode(this.nome_encarregado);
        hash = 53 * hash + Objects.hashCode(this.sobrenome_encarregado);
        hash = 53 * hash + Objects.hashCode(this.id_profissao);
        hash = 53 * hash + Objects.hashCode(this.id_sexo);
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
        final EncarregadoEducacao other = (EncarregadoEducacao) obj;
        if (!Objects.equals(this.id_encarregado_educacao, other.id_encarregado_educacao)) {
            return false;
        }
        if (!Objects.equals(this.nome_encarregado, other.nome_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.sobrenome_encarregado, other.sobrenome_encarregado)) {
            return false;
        }
        if (!Objects.equals(this.id_profissao, other.id_profissao)) {
            return false;
        }
        if (!Objects.equals(this.id_sexo, other.id_sexo)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "EncarregadoEducacao{" + "nome_encarregado=" + nome_encarregado + '}';
    }
    
    
    
}
