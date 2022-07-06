package biga.movie.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties
public class TheMovieDb {

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("original_title")
    private String title;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("popularity")
    private BigDecimal popularity;

    @JsonProperty("id")
    private Integer id;


    public TheMovieDb(){
    }

    public TheMovieDb(String originalLanguage, String title, String overview, BigDecimal popularity, Integer id) {
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
        this.id = id;
    }

    public Movies converter(){

        Movies filme = new Movies(this.id, this.title, "teste descricao", this.popularity,this.originalLanguage );

        return filme;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public BigDecimal getPopularity() {
        return popularity;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TheMovieDb{" +
                "originalLanguage='" + originalLanguage + '\'' +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", id=" + id +
                '}';
    }
}
