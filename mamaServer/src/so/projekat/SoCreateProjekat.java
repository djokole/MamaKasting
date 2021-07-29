/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.projekat;

import domen.Projekat;
import so.AbstractSO;

/**
 *
 * @author Panda
 */
public class SoCreateProjekat extends AbstractSO{

    @Override
    protected void validate(Object entity) throws Exception {
        if(!(entity instanceof Projekat))
            throw new Exception("Prosledjeni objekat nije klase Projekat");
    }

    @Override
    protected void execute(Object entity) throws Exception {
        DBBroker.insert((Projekat)entity);
    }
    
}
