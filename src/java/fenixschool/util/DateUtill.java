/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtill {
    public static Date strToDate(String data){
        if (data == null) {
            return null;
        }
        Date dataF = null;
        try {
         //  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            long timestemp = dateFormat.parse(data).getTime();
            dataF = new Date(timestemp);
        } catch (ParseException pe) {
            System.out.println("Erro ao converter String em data: " + pe.getLocalizedMessage());
        }
        return dataF;
    }
    
    public static String formataData(Date data){
        Calendar calendar = new GregorianCalendar();
       //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTime(data);
        
        return sdf.format(calendar.getTime());
    }
    
    
}
