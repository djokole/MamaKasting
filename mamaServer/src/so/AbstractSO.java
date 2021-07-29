/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;

public abstract class AbstractSO {
    
    protected DBBroker DBBroker;

    public AbstractSO() {
        DBBroker = new DBBroker();
    }

    public final void templateExecute(Object entity) throws Exception {
        try {
            startTransaction();
            validate(entity);
            execute(entity);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        } finally {
            disconnect();
        }
    }

    private void startTransaction() throws Exception {
        DBBroker.connect();
    }

    // Operation-specific method
    protected abstract void validate(Object entity) throws Exception;

    // Operation-specific method
    protected abstract void execute(Object entity) throws Exception;

    private void commitTransaction() throws Exception {
        DBBroker.commit();
    }

    private void rollbackTransaction() throws Exception {
        DBBroker.rollback();
    }

    private void disconnect() throws Exception {
        DBBroker.disconnect();
    }

}
