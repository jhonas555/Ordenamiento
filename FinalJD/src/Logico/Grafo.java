package Logico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Grafo {
    private List<Ubicacion> vertices; // Lista de vértices (ubicaciones) en el grafo
    private Map<Ubicacion, List<Arista>> adyacencias; // Mapa de adyacencias (aristas) para cada vértice

    // Constructor de la clase Grafo.

    public Grafo() {
        vertices = new ArrayList<>();
        adyacencias = new HashMap<>();
    }


     // Agrega un vértice (ubicación) al grafo.

    public void agregarVertice(Ubicacion ubicacion) {
        vertices.add(ubicacion);
        adyacencias.put(ubicacion, new ArrayList<>()); // Inicializa la lista de adyacencias vacía
    }

     // Agrega una arista (conexión) entre dos vértices (ubicaciones) en el grafo.

    public void agregarArista(Ubicacion origen, Ubicacion destino, double distancia) {
        Arista arista = new Arista(origen, destino, distancia);
        adyacencias.get(origen).add(arista); // Agrega la arista a la lista de adyacencias del vértice origen
    }


     //Obtiene la lista de vértices (ubicaciones) en el grafo.

    public List<Ubicacion> getVertices() {
        return vertices;
    }

     // Obtiene la lista de aristas adyacentes a un vértice (ubicación) dado.
     

    public List<Arista> getAristasAdyacentes(Ubicacion ubicacion) {
        return adyacencias.get(ubicacion);
    }
}