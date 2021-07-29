/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.glumac;

import domen.Glumac;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Panda
 */
public class SoGetAllGlumci extends AbstractSO {
    private List<Glumac> list;
    
    @Override
    protected void validate(Object entity) throws Exception {
        if(!(entity instanceof Glumac))
            throw new Exception("Prosledjeni objekat nije klase glumac");
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = (List<Glumac>)(List<?>) DBBroker.getAll((Glumac)entity);
    }
    
    public List<Glumac> getList() {
        return list;
    }
    
}
