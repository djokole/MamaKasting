/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.produkcija;

import domen.Produkcija;
import so.AbstractSO;

/**
 *
 * @author Panda
 */
public class SoCreateProdukcija extends AbstractSO {

    @Override
    protected void validate(Object entity) throws Exception {
        if(!(entity instanceof Produkcija))
            throw new Exception("Prosledjeni objekat nije klase produkcija");
    }

    @Override
    protected void execute(Object entity) throws Exception {
        DBBroker.insert((Produkcija)entity);
    }
    
}
