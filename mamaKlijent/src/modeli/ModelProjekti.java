/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import Connection.Session;
import controller.ClientController;
import domen.Glumac;
import domen.Produkcija;
import domen.Projekat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Panda
 */
public class ModelProjekti extends AbstractTableModel {
    List<Projekat> listaProjekata;
    String[] index = new String[]{"Ime Projekta","Glavni Muski Glumac", "Glavna Zenska Glumica", "Sporedna uloga 1", "Sporedna uloga 2", "Sporedna uloga 3"};
    
    public ModelProjekti() throws Exception {
        listaProjekata = new ArrayList();
        List<Projekat> sviProjekti = ClientController.getInstance().getAllProjekti();
        Produkcija trenutno = (Produkcija) Session.getInstance().getTrenutnoUlogovan();
        int trenutnoID = trenutno.getProdukcijaID();
        for(Projekat p : sviProjekti)
            if(p.getProdukcijaID() == trenutnoID)
                listaProjekata.add(p);
    }

    @Override
    public String getColumnName(int i) {
        return index[i];
    }
    
    
    @Override
    public int getRowCount() {
        return listaProjekata.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Projekat p = listaProjekata.get(rowIndex);
        try {
            List<Glumac> listaGlumaca = ClientController.getInstance().getAllGlumci();
            switch(columnIndex) {
            case 0:
                return p.getImeProjekta();
            case 1:
                for(Glumac g : listaGlumaca)
                    if(g.getGlumacID() == p.getGlavniMuski())
                        return g.getImePrezime();
            case 2:
                for(Glumac g : listaGlumaca)
                    if(g.getGlumacID() == p.getGlavniZenski())
                        return g.getImePrezime();
            case 3:
                for(Glumac g : listaGlumaca)
                    if(g.getGlumacID() == p.getSporedna1())
                        return g.getImePrezime();
            case 4:
                for(Glumac g : listaGlumaca)
                    if(g.getGlumacID() == p.getSporedna2())
                        return g.getImePrezime();
            case 5:
                for(Glumac g : listaGlumaca)
                    if(g.getGlumacID() == p.getSporedna3())
                        return g.getImePrezime();
        }
        } catch (Exception ex) {
            Logger.getLogger(ModelProjekti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;    
    }


    public void obrisiProjekat(int row) throws Exception {
       if(row == -1)
           throw new Exception("No unit selected");
       Projekat deleted = listaProjekata.remove(row);
       ClientController.getInstance().deleteProjekat(deleted);
       fireTableDataChanged();
    }
    
}
