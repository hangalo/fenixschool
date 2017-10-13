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
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author informatica
 */
@Named(value = "resourcesFiles")
@SessionScoped
public class ResourcesFiles implements Serializable {

    Locale currentLocale;
    ResourceBundle mrb; // form messages
    ResourceBundle arb; // form application

    public ResourcesFiles() {
    }

    @PostConstruct
    public void init() {
        saveLocale();
    }

    

    public void saveLocale() {
        currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        mrb = ResourceBundle.getBundle("properties.messages", currentLocale);
         arb = ResourceBundle.getBundle("properties.application", currentLocale);
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }
    
    public ResourceBundle getMrb() {
        return mrb;
    }

    public void setMrb(ResourceBundle mrb) {
        this.mrb = mrb;
    }

    public ResourceBundle getArb() {
        return arb;
    }

    public void setArb(ResourceBundle arb) {
        this.arb = arb;
    }
    
    // Devolce a mensagem Mrb
    
    public String getMessageMrb(String message){
    return mrb.getString(message);
    }
    
    // devolve a mensagem Arb
    
    
    public String getMessageArb(String message){
    return mrb.getString(message);
    }
    
}
