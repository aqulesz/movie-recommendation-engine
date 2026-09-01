import java.util.*;

public class Usuario {
    private String nombre;
    private List<Movie> historialVistas = new ArrayList<>();
    private List<Movie> watchlist = new ArrayList<>();

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void marcarComoVista(Movie movie) {
        historialVistas.add(movie);
    }

    public void agregarWatchlist(Movie movie) {
        watchlist.add(movie);
    }

    public List<Movie> getHistorialVistas() {
        return historialVistas;
    }

    public List<Movie> getWatchlist() {
        return watchlist;
    }

    public String getNombre() {
        return nombre;
    }
}
