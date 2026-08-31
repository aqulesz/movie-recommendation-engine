void main() {
    Catalogo catalogo = new Catalogo();

    System.out.println(catalogo.contarPorGenero());

    System.out.println(catalogo.buscarPorTitulo("Spider-man"));

    try {
        catalogo.agregarPelicula(new Movie("Bad Movie", "Drama", 2020, 15.0)); // rating inválido a propósito
    } catch (InvalidRatingException e) {
        System.out.println("Error al agregar: " + e.getMessage());
    }

    try {
        catalogo.buscarPorTituloOLanzar("Avengers"); // no existe, a propósito
    } catch (MovieNotFoundException e) {
        System.out.println("Error al buscar: " + e.getMessage());
    }


    List<Movie> buenasSuperheroes = catalogo.recomendar(m -> m.getGenre().equals("Superheroes") && m.getRating() > 7);
    System.out.println(buenasSuperheroes);

    List<Movie> pelisRecientes = catalogo.recomendar(m -> m.getYear() >= 2010);
    System.out.println(pelisRecientes);

    Optional<Movie> encontrada = catalogo.buscarPorTitulo("Inception");
    encontrada.ifPresentOrElse(
            movie -> System.out.println("Encontrada: " + movie),
            () -> System.out.println("No existe esa película")
    );
}
