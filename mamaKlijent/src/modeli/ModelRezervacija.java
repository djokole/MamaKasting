/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import controller.ClientController;
import domen.Glumac;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Panda
 */
public class ModelRezervacija extends AbstractTableModel {
    
    List<Glumac> listaGlumci;
    private String []index = new String[]{"Ime i Prezime","Pol","Visina","Tezina","Boja Ociju"};

    public ModelRezervacija() {
        try {
            listaGlumci = ClientController.getInstance().getAllGlumci();
        } catch (Exception ex) {
            Logger.getLogger(ModelRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getColumnName(int i) {
        return index[i];
    }
    
    @Override
    public int getRowCount() {
        return listaGlumci.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Glumac g = listaGlumci.get(row);
        switch(column){
            case 0:
                return g.getImePrezime();
            case 1:
                return g.getPol();
            case 2:
                return g.getVisina();
            case 3:
                return g.getTezina();
            case 4:
                return g.getBojaOciju();
            default:
                return null;
        }
    }
    
}
