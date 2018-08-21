/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Objects;

/**
 *
 * @author PENA
 */
public class NotaBoletim {

    private Integer idNotaBoletim;
    private BoletimNota boletinNota;
    private Nota nota;

    public NotaBoletim() {
    }

    public NotaBoletim(Integer idNotaBoletim, BoletimNota boletinNota, Nota nota) {
        this.idNotaBoletim = idNotaBoletim;
        this.boletinNota = boletinNota;
        this.nota = nota;
    }

    public Integer getIdNotaBoletim() {
        return idNotaBoletim;
    }

    public void setIdNotaBoletim(Integer idNotaBoletim) {
        this.idNotaBoletim = idNotaBoletim;
    }

    public BoletimNota getBoletinNota() {
        return boletinNota;
    }

    public void setBoletinNota(BoletimNota boletinNota) {
        this.boletinNota = boletinNota;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idNotaBoletim);
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
        final NotaBoletim other = (NotaBoletim) obj;
        if (!Objects.equals(this.idNotaBoletim, other.idNotaBoletim)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NotaBoletim{" + "nota=" + nota + '}';
    }

   
}
