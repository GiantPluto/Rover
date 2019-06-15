package xyz.apollotv.rover.factory;

import xyz.apollotv.rover.struct.SourceProvider;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class SourceProviderFactory {

    /* Singleton */
    private static SourceProviderFactory instance;

    public static SourceProviderFactory getInstance() {
        if(instance != null) return instance;
        instance = new SourceProviderFactory();
        return instance;
    }
    /* ./Singleton */

    private List<String> providers;

    private SourceProviderFactory(){
        providers = new ArrayList<>();
    }

    /**
     * Register a {@link SourceProvider} with the SourceProviderFactory.
     *
     * <br>
     * <p><b>Example Usage:</b></p>
     * <pre>
     *     static {
     *         SourceProviderFactory.getInstance().registerProvider(myProvider.class);
     *     }
     * </pre>
     * @param providerClass The class to register with the provider.
     */
    public void registerProvider(Class providerClass){
        providers.add(providerClass.getName());
    }

    /**
     * Returns a {@link SourceProvider} if the provider was found and could be instantiated.
     * Otherwise, prints an exception message and stacktrace and returns null.
     *
     * @param providerClass The name of the class to instantiate.
     * @return {@link SourceProvider} or null
     */
    public SourceProvider getProvider(String providerClass){
        try {
            return (SourceProvider) Class.forName(providerClass).getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("Failed attempt to instantiate a scraper: " + providerClass);
            e.printStackTrace();
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            System.err.println("An error occurred whilst instantiating a scraper: " + providerClass);
            e.printStackTrace();
        }

        return null;
    }

    public void forEach(IteratorCallback callback){
        providers.forEach((provider) -> callback.execute(getProvider(provider)));
    }

}

