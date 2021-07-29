/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.projekat;

import domen.Projekat;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Panda
 */
public class SoGetAllProjekti extends AbstractSO {
    List<Projekat> list;
    
    @Override
    protected void validate(Object entity) throws Exception {
        if(!(entity instanceof Projekat))
            throw new Exception("Prosledjeni objekat nije klase projekat");
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = (List<Projekat>)(List<?>) DBBroker.getAll((Projekat)entity);
    }
    
    public List<Projekat> getList() {
        return list;
    }
    
}
