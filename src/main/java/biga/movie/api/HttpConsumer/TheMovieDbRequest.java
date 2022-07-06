package biga.movie.api.HttpConsumer;

import biga.movie.api.model.TheMovieDb;
import com.google.gson.Gson;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class TheMovieDbRequest {

    private RestTemplate restTemplate;
    private Gson gson;

    public TheMovieDbRequest(RestTemplateBuilder restTemplateBuilder, Gson gson){
        this.restTemplate = restTemplateBuilder.build();
        this.gson = new Gson();
    }

    public TheMovieDb requestAdress(String url){
        return getAdress(url);
    }

    public TheMovieDb getAdress(String url){

        try {

            HttpEntity<TheMovieDb> request = new HttpEntity<>(buildHeaders());
            ResponseEntity<TheMovieDb> responseEntity =
                    restTemplate.exchange(url, HttpMethod.GET, request, TheMovieDb.class);
            // retorna o corpo de resposta
            return responseEntity.getBody();

        } catch (HttpStatusCodeException exception) {
            System.out.println(exception.getRawStatusCode());
            // http status code ex: 404 NOT_FOUND`
            System.out.println(exception.getStatusCode().toString());
            // get response body
            System.out.println(exception.getResponseBodyAsString());
            // get http headers
            HttpHeaders headers = exception.getResponseHeaders();
            assert headers != null;
            System.out.println(headers.get("Server"));
            return null;
        }
    }
    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        // singletonList - retornar uma lista contendo apenas o objeto especificado
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
