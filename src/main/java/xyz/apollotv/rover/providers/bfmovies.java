package xyz.apollotv.rover.providers;

import xyz.apollotv.rover.factory.SourceProviderFactory;
import xyz.apollotv.rover.struct.ContentRequest;
import xyz.apollotv.rover.struct.ProviderType;
import xyz.apollotv.rover.struct.SourceProvider;

public class bfmovies implements SourceProvider {

    static {
        SourceProviderFactory.getInstance().registerProvider(bfmovies.class);
    }

    @Override
    public ProviderType getProviderType() {
        return ProviderType.MOVIE;
    }

    @Override
    public Runnable scrape(ContentRequest request) {
        return () -> {
            // TODO: perform scraping.
        };
    }

}
