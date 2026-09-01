# Movie Recommendation Engine

Motor de recomendación de películas en Java puro, construido como ejercicio
de consolidación de fundamentos: colecciones, excepciones custom, generics,
programación funcional (lambdas/Streams), y principios SOLID.

## Decisiones de diseño
- `Repository<T>` genérico para desacoplar la lógica de almacenamiento de
  Catalogo, siguiendo Dependency Inversion.
- `Optional<Movie>` en la búsqueda por título en vez de `null`, para forzar
  el manejo explícito del caso "no encontrado" en el código que consume el catálogo.
- Excepciones custom (RuntimeException) para errores de negocio (rating
  inválido, película no encontrada) en vez de checked exceptions.
- Carga de datos vía CSV en vez de hardcodeados, separando la fuente de
  datos de la lógica del catálogo.

## Tests
Tests unitarios con JUnit 5 sobre las validaciones y el motor de recomendación.