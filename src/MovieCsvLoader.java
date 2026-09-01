import java.io.*;
import java.util.*;

public class MovieCsvLoader {
    public List<Movie> cargarDesdeArchivo(String path) {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                String title = partes[0];
                String genre = partes[1];
                int year = Integer.parseInt(partes[2]);
                double rate = Double.parseDouble(partes[3]);
                movies.add(new Movie(title,genre, year, rate));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo: " + path, e);
        }
        return movies;
    }
}
