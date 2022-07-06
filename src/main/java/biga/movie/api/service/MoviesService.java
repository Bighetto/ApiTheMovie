package biga.movie.api.service;

import biga.movie.api.HttpConsumer.TheMovieDbRequest;
import biga.movie.api.model.Movies;
import biga.movie.api.model.TheMovieDb;
import biga.movie.api.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    private final MoviesRepository moviesRepository;
    private final TheMovieDbRequest theMovieDbRequest;

    public MoviesService(MoviesRepository moviesRepository, TheMovieDbRequest theMovieDbRequest) {
        this.moviesRepository = moviesRepository;
        this.theMovieDbRequest = theMovieDbRequest;
    }

    public List<Movies> getMovies(){
        return moviesRepository.findAll();
    }

    public Optional<Movies> getById(Integer id){

        Optional<Movies> byId = moviesRepository.findById(id);

        return byId;
    }

    public TheMovieDb consumoApi(Integer id){

        String url = "https://api.themoviedb.org/3/movie/"+ id.toString() + "?api_key=33f2e1ee832a66289efd7183c37d02da&language=pt-BR";
        Movies movies = new Movies();

        TheMovieDb theMovieDb = theMovieDbRequest.requestAdress(url);

        return theMovieDb;

    }

    public Movies save(Movies movies){
        return moviesRepository.save(movies);
    }

    public String delete(Integer id){

        moviesRepository.deleteById(id);

        return "Filme deletado com Sucesso!!";

    }

}
