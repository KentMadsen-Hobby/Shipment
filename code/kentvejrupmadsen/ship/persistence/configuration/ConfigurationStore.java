    package kentvejrupmadsen.ship.persistence.configuration;


    import kentvejrupmadsen.ship.StateController;

    /**
     * @author Kent Madsen
     */
    public class ConfigurationStore
            implements StoreFacade
    {
        // Code / Constructors
        /**
         *
         */
        public ConfigurationStore()
        {

        }

        // Variables
        private static StoreFacade configuration = null;
        private StateController state = null;

        // Code
        @Override
        public boolean configure()
        {
            return false;
        }

        // Accessors
        @Override
        public void setStateController( StateController controller )
        {
            this.state = controller;
        }

        public StateController getState()
        {
            return state;
        }

        /**
         *
         * @return Configuration Store
         */
        public static StoreFacade getConfiguration()
        {
            if( ConfigurationStore.configuration == null )
            {
                ConfigurationStore.setConfiguration(
                        new ConfigurationStore() );
            }

            return configuration;
        }

        /**
         *
         * @param configuration
         */
        protected static void setConfiguration( ConfigurationStore configuration )
        {
             ConfigurationStore.configuration = configuration;
        }
    }
