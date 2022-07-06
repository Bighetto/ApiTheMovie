package biga.movie.api.controller;

import biga.movie.api.model.Movies;
import biga.movie.api.model.TheMovieDb;
import biga.movie.api.service.MoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class MoviesController {

    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/listMovies")
    public ResponseEntity<List<Movies>> listMovies(){

        List<Movies> movies = moviesService.getMovies();

        return ResponseEntity.ok(movies);
    }

    @GetMapping(path = "/getId/{id}")
    public ResponseEntity<Optional<Movies>> getById(@PathVariable Integer id){

        Optional<Movies> movie = moviesService.getById(id);

        return ResponseEntity.ok(movie);
    }

    @GetMapping(path = "/api/{id}")
    public ResponseEntity<TheMovieDb> consumeApi(@PathVariable Integer id){
        return ResponseEntity.ok(moviesService.consumoApi(id));
    }

    @PostMapping(path = "/insertMovie/{id}")
    public ResponseEntity<Movies> insertMovie(@PathVariable Integer id, UriComponentsBuilder uriComponentsBuilder){

        TheMovieDb theMovieDb = moviesService.consumoApi(id);

        URI uri = uriComponentsBuilder.path("/getId/{id}").buildAndExpand(theMovieDb.getId()).toUri();

        return ResponseEntity.created(uri).body(moviesService.save(theMovieDb.converter()));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Integer id){

        return ResponseEntity.ok(moviesService.delete(id));

    }

}
