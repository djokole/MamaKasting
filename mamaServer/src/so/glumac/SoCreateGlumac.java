/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.glumac;

import domen.Glumac;
import so.AbstractSO;

/**
 *
 * @author Panda
 */
public class SoCreateGlumac extends AbstractSO {

    @Override
    protected void validate(Object entity) throws Exception {
        if(!(entity instanceof Glumac))
            throw new Exception("Prosledjeni objekat nije klase Glumac");
    }

    @Override
    protected void execute(Object entity) throws Exception {
        DBBroker.insert((Glumac)entity);
    }
    
}
