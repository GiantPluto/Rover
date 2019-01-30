package xyz.apollotv.rover.struct;

public class ContentRequest {

    private ContentType contentType;
    private String title;

    private String seasonNumber;
    private String episodeNumber;

    public ContentRequest(ContentType contentType, String title){
        this.contentType = contentType;
        this.title = title;
    }

    public ContentRequest(ContentType contentType, String title, String seasonNumber, String episodeNumber){
        this.contentType = contentType;
        this.title = title;

        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }

    public ContentType getContentType(){
        return this.contentType;
    }

    public String getTitle(){
        return this.title;
    }

    public String getSeasonNumber(){
        return this.seasonNumber;
    }

    public String getEpisodeNumber(){
        return this.episodeNumber;
    }

}
