/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.lingua;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author informatica
 */
@Named(value = "idiomas")
@SessionScoped
public class Idiomas implements Serializable {

    @Inject
    ResourcesFiles rf;

    private String locale = Locale.getDefault().getDisplayLanguage();

    public Idiomas() {
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public synchronized String getLocale() {
        return locale;
    }

    public synchronized String changeLanguage() {
        return "changed";
    }

    public String englishAction() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(Locale.ENGLISH);
        this.locale = "en";
        rf.saveLocale();;
        return null;
    }
    
    
    
      public String portogheseAction() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(new Locale("pt"));
        this.locale = "pt";
        rf.saveLocale();;
        return null;
    }

}
