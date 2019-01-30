package xyz.apollotv.rover.struct;

public interface SourceProvider {

    ProviderType getProviderType();

    Runnable scrape(ContentRequest request);

}

