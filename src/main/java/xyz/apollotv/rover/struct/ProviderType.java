package xyz.apollotv.rover.struct;

public enum ProviderType {

    MOVIE(ContentType.MOVIE),
    TV(ContentType.TV),
    UNIVERSAL(ContentType.TV, ContentType.MOVIE);

    private ContentType[] types;

    ProviderType(ContentType... types){
        this.types = types;
    }

    public ContentType[] getTypes() {
        return types;
    }
}
