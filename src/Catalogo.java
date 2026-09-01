import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Catalogo {
    private Repository<Movie> movieRepository;

    public Catalogo(List<Movie> peliculasIniciales){
        movieRepository = new Repository<>();
        for (Movie m : peliculasIniciales) {
            movieRepository.add(m);
        }
    }

    public void agregarPelicula(Movie movie) {
        if (movie.getRating() < 0 || movie.getRating() > 10){
            throw new InvalidRatingException("Rating invalido: " + movie.getRating());
        }
        movieRepository.add(movie);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Map<String, Long> contarPorGenero() {
        return movieRepository.findAll().stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
    }

    public Optional<Movie> buscarPorTitulo(String titulo) {
        for(Movie movie : movieRepository.findAll()) {
            if (titulo.equals(movie.getTitle())){
                return Optional.of(movie);
            }
        }
        return Optional.empty();
    }

    public Movie buscarPorTituloOLanzar(String titulo) {
        for(Movie movie : movieRepository.findAll()) {
            if (titulo.equals(movie.getTitle())){
                return movie;
            }
        }
        throw new MovieNotFoundException("Pelicula no encontrada: " + titulo);
    }

    public List<Movie> recomendar(Predicate<Movie> criterio) {

        return movieRepository.findAll().stream().filter(criterio).sorted(Comparator.comparing(Movie::getRating).reversed()).collect(Collectors.toList());

    }

    public String tituloDeLaMasVieja() {
        return movieRepository.findAll().stream().min(Comparator.comparing(Movie::getYear)).map(Movie::getTitle).orElseThrow(() -> new MovieNotFoundException("No hay pelicula mas vieja"));
    }
}
