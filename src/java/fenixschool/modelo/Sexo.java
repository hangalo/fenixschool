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
public enum Sexo {

    MASCULINO("M", "Masculino"), FEMININO("F", "Feminino");

    private String abreviatura;
    private String extensao;

    private Sexo(String abreviatura, String extensao) {
        this.abreviatura = abreviatura;
        this.extensao = extensao;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

   
// Método auxiliar para interagir com o enum
    public static Sexo getAbreviatura(String id) {
        for (Sexo s : values()) {
            if (s.getAbreviatura().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

}
