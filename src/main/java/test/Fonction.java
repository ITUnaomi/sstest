
package test;

import connexion.Connexion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import projgit.Personne;


public class Fonction {
    public boolean debutWeek(String date) throws ParseException {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dte = sdf.parse(date);
        sdf = new SimpleDateFormat("u");
        int day = new Integer(sdf.format(dte));
        if (day == 1) {

            return true;
        }
        return false;
    }

    public String testHeure(String heure) {
        try {
            heure = heure.replace('-', ':');
            heure = heure.replace('.', ':');
            SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
            if (heure.indexOf("A") > 0 || heure.indexOf("a") > 0) {
                Date date1 = parseFormat.parse(heure);
                return displayFormat.format(date1);
            } else if (heure.indexOf("P") > 0 || heure.indexOf("p") > 0) {
                Date date1 = parseFormat.parse(heure);
                return displayFormat.format(date1);
            }
            return heure;
        } catch (ParseException ex) {
            return null;
        }
    }
    
     public boolean Insert(Personne emp) {
        try {
            Connexion c = new Connexion();
            c.ConnectionDB();
            String r = c.createInsertStatement("Personne", new Personne());
            c.ConnectionDB();
            c.Insert(r);
            c.fermer();
            return true;
        }catch (Exception ex) {
            return false;
        }
    }
     
     public boolean WeekEnd(String date) throws ParseException{
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dte = sdf.parse(date);
        sdf = new SimpleDateFormat("u");
        int day=new Integer(sdf.format(dte));
        if(day==7 || day==6){
            return true;
        }
        return false;
    }
     
     
}
