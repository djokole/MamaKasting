/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Glumac;
import domen.Izabrani;
import forme.Produkcija.ProjekatForma;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Panda
 */
public class ModelFinal extends AbstractTableModel {
    
    ArrayList<Izabrani> izabrani;
    
    public ModelFinal() {
        izabrani = new ArrayList<>();
    }

    public ArrayList<Izabrani> getIzabrani() {
        return izabrani;
    }

    public void setIzabrani(ArrayList<Izabrani> izabrani) {
        this.izabrani = izabrani;
    }
     
    
    private String []index = new String[]{"Uloga", "Ime i Prezime"};
    
    @Override
    public int getRowCount() {
        return izabrani.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Izabrani i = izabrani.get(rowIndex);
        switch(columnIndex){
            case 0:
                return i.getUloga();
            case 1:
                return i.getG().getImePrezime();
            default:
                return null;
        }
    }

    public void dodajIzabranog(Izabrani i) {
        if(!izabrani.contains(i)){
            izabrani.add(i);
            fireTableDataChanged();
        }
    }
    
}
