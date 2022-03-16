package abductionapi.factory;


import abductionapi.manager.AbducibleContainer;
import abductionapi.manager.AbductionManager;

/**
 * AbductionManagerAndAbducibleContainerFactory interface.
 */
public interface AbductionManagerAndAbducibleContainerFactory {

    /**
     * Creates an abducible manager.
     * @return new AbducibleContainer
     */
    public AbducibleContainer createAbducibleContainer();

    /**
     * Creates an abduction manager.
     * @return new DLAbductionManager
     */
    public AbductionManager createAbductionManager();
}
