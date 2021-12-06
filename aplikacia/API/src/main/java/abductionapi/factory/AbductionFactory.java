package abductionapi.factory;


import abductionapi.manager.AbducibleManager;
import abductionapi.manager.AbductionManager;

/**
 * DLAbductionFactory interface.
 */
public interface AbductionFactory {

    /**
     * Creates an abducible manager.
     * @return new AbducibleManager
     */
    public AbducibleManager createAbducibleManager();

    /**
     * Creates an abduction manager.
     * @return new DLAbductionManager
     */
    public AbductionManager createDLAbductionManager();
}
