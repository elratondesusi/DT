package abductionapi.factory;

import abductionapi.container.AbducibleContainer;
import abductionapi.manager.AbductionManager;

/**
 * AbductionManagerAndAbducibleContainerFactory generic interface.
 * @author Zuzana Hlávková, hlavkovazuz@gmail.com
 *
 * @param <ABDUCTION_MANAGER> AbductionManager type parameter
 * @param <ABDUCIBLE_CONTAINER> AbducibleContainer type parameter
 */
public interface AbductionManagerAndAbducibleContainerFactory<ABDUCTION_MANAGER , ABDUCIBLE_CONTAINER extends AbducibleContainer> {

    /**
     * Creates an abducible manager.
     * @return a new instance of AbducibleContainer.
     */
    public ABDUCIBLE_CONTAINER createAbducibleContainer();

    /**
     * Creates an abduction manager.
     * @return a new instance of AbductionManager.
     */
    public ABDUCTION_MANAGER createAbductionManager();
}
