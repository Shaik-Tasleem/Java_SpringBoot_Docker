package Apimovie;

import java.util.List;

public class TvShowDto {
    
    private String title;
    private String releaseYear;
    private List<String> genres;
    private String synopsis;

    public TvShowDto() {
    }

    public TvShowDto(String title, String releaseYear, List<String> genres, String synopsis) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "TvShowDto{" +
                "title='" + title + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", genres=" + genres +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
