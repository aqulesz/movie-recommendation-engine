import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CatalogoTest {

    private List<Movie> datosDePrueba() {
        return List.of(
                new Movie("Spider-man", "Superheroes", 2002, 8.0),
                new Movie("Batman", "Superheroes", 2012, 9.0),
                new Movie("Inception", "Mistery", 2009, 8.0)
        );
    }

    @Test
    public void buscarPorTituloOLanzar_siNoExiste_lanzaExcepcion() {
        Catalogo catalogo = new Catalogo(datosDePrueba());

        assertThrows(MovieNotFoundException.class, () -> {
            catalogo.buscarPorTituloOLanzar("PeliculaQueNoExiste");
        });
    }

    @Test
    public void recomendar_superheroes_devuelveOrdenadoPorRatingDescendente() {
        Catalogo catalogo = new Catalogo(datosDePrueba());

        List<Movie> resultado = catalogo.recomendar(m -> m.getGenre().equals("Superheroes"));

        assertEquals("Batman", resultado.get(0).getTitle());
        assertEquals(2, resultado.size());
    }

    @Test
    public void agregarPelicula_LanzarExcepcionSiEsRatingInvalido() {
        Catalogo catalogo = new Catalogo(datosDePrueba());

        assertThrows(InvalidRatingException.class, () -> {
            catalogo.agregarPelicula(new Movie("Monster Inc.", "Kids", 2007, 15));
        });
    }
}
