package biga.movie.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "popularidade")
    private BigDecimal popularidade;

    @Column(name = "linguagem")
    private String linguagem;

    public Movies(){
    }

    public Movies(Integer id, String titulo, String descricao, BigDecimal popularidade, String linguagem) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.popularidade = popularidade;
        this.linguagem = linguagem;
    }

    public void converter(TheMovieDb theMovieDb){
        this.id = theMovieDb.getId();
        this.linguagem = theMovieDb.getOriginalLanguage();
        this.descricao = theMovieDb.getOverview();
        this.popularidade = theMovieDb.getPopularity();
        this.titulo = theMovieDb.getTitle();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(BigDecimal popularidade) {
        this.popularidade = popularidade;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", popularidade=" + popularidade +
                ", linguagem='" + linguagem + '\'' +
                '}';
    }
}
