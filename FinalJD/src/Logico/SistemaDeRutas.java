package Logico;

import java.util.List;

public class SistemaDeRutas {
    private Grafo grafo; // Grafo que representa el sistema de rutas
    private List<Algoritmo> algoritmos; // Lista de algoritmos disponibles para calcular rutas


     // Constructor de la clase SistemaDeRutas.

    public SistemaDeRutas(Grafo grafo, List<Algoritmo> algoritmos) {
        this.grafo = grafo;
        this.algoritmos = algoritmos;
    }


     // Calcula la ruta entre dos ubicaciones utilizando un algoritmo específico.
     
    public List<Ubicacion> calcularRuta(Ubicacion origen, Ubicacion destino, Algoritmo algoritmo) {
        // Lógica para calcular la ruta utilizando el algoritmo especificado
        return algoritmo.calcularRuta(grafo, origen, destino); //pendiente arreglar esto
    }


     // Optimiza las rutas en el sistema utilizando un algoritmo específico.

    /*
    public void optimizarRutas(Algoritmo algoritmo) {
        // Lógica para optimizar las rutas utilizando el algoritmo especificado
        algoritmo.optimizarRutas(grafo); //pendiente arreglar esto
    }

*/
     // Agrega una nueva ubicación al sistema de rutas.
 
    public void agregarUbicacion(Ubicacion ubicacion) {
        grafo.agregarVertice(ubicacion);
    }

     // Agrega una nueva conexión (arista) entre dos ubicaciones en el sistema de rutas.
     
 
    public void agregarConexion(Ubicacion origen, Ubicacion destino, double distancia) {
        grafo.agregarArista(origen, destino, distancia);
    }
}