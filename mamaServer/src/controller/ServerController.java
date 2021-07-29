/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domen.Glumac;
import domen.Produkcija;
import domen.Projekat;
import java.util.List;
import so.glumac.SoCreateGlumac;
import so.glumac.SoDeleteGlumac;
import so.glumac.SoGetAllGlumci;
import so.produkcija.SoCreateProdukcija;
import so.produkcija.SoDeleteProdukcija;
import so.produkcija.SoGetAllProdukcije;
import so.produkcija.SoUpdateProdukcija;
import so.projekat.SoCreateProjekat;
import so.projekat.SoDeleteProjekat;
import so.projekat.SoGetAllProjekti;

/**
 *
 * @author Panda
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }
    
    public Glumac loginG(Glumac glumac) throws Exception {
        SoGetAllGlumci so = new SoGetAllGlumci();
        so.templateExecute(new Glumac());
        List<Glumac> list = so.getList();
        for(Glumac g : list)
            if(g.getUsername().equals(glumac.getUsername()) && g.getPassword().equals(glumac.getPassword()))
                return g;
        throw new Exception("Ne postoji glumac sa unetim kredencijalima");
    }
    
    public Produkcija loginP(Produkcija produkcija) throws Exception {
        SoGetAllProdukcije so = new SoGetAllProdukcije();
        so.templateExecute(new Produkcija());
        List<Produkcija> list = so.getList();
        for(Produkcija p : list)
            if(p.getUsername().equals(produkcija.getUsername()) && p.getPassword().equals(produkcija.getPassword()))
                return p;
        throw new Exception("Ne postoji produkcija sa unetim kredencijalima");
    }
    
    public void createGlumac(Glumac glumac) throws Exception {
        SoCreateGlumac so = new SoCreateGlumac();
        so.templateExecute(glumac);
    }
    
    public void createProdukcija(Produkcija produkcija) throws Exception {
        SoCreateProdukcija so = new SoCreateProdukcija();
        so.templateExecute(produkcija);
    }
    
    public void createProjekat(Projekat projekat) throws Exception {
        SoCreateProjekat so = new SoCreateProjekat();
        so.templateExecute(projekat);
    }
    
    public List<Glumac> getAllGlumci()throws Exception{
        SoGetAllGlumci so = new SoGetAllGlumci();
        so.templateExecute(new Glumac());
        return so.getList();
    }
    
    public List<Produkcija> getAllProdukcije()throws Exception{
        SoGetAllProdukcije so = new SoGetAllProdukcije();
        so.templateExecute(new Produkcija());
        return so.getList();
    }
    
    public List<Projekat> getAllProjekti()throws Exception{
        SoGetAllProjekti so = new SoGetAllProjekti();
        so.templateExecute(new Projekat());
        return so.getList();
    }
    
    public void deleteProdukcija(Produkcija produkcija)throws Exception{
        SoDeleteProdukcija so = new SoDeleteProdukcija();
        so.templateExecute(produkcija);
    }
    
    public void deleteGlumac(Glumac glumac)throws Exception{
        SoDeleteGlumac so = new SoDeleteGlumac();
        so.templateExecute(glumac);
    }
    
    public void deleteProjekat(Projekat projekat)throws Exception{
        SoDeleteProjekat so = new SoDeleteProjekat();
        so.templateExecute(projekat);
    }
    
    public void updateProdukcija(Produkcija produkcija)throws Exception{
        SoUpdateProdukcija so = new SoUpdateProdukcija();
        so.templateExecute(produkcija);
    }
}
