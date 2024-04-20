package Logico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Grafo {
    private List<Ubicacion> vertices; // Lista de v�rtices (ubicaciones) en el grafo
    private Map<Ubicacion, List<Arista>> adyacencias; // Mapa de adyacencias (aristas) para cada v�rtice

    // Constructor de la clase Grafo.

    public Grafo() {
        vertices = new ArrayList<>();
        adyacencias = new HashMap<>();
    }


     // Agrega un v�rtice (ubicaci�n) al grafo.

    public void agregarVertice(Ubicacion ubicacion) {
        vertices.add(ubicacion);
        adyacencias.put(ubicacion, new ArrayList<>()); // Inicializa la lista de adyacencias vac�a
    }

     // Agrega una arista (conexi�n) entre dos v�rtices (ubicaciones) en el grafo.

    public void agregarArista(Ubicacion origen, Ubicacion destino, double distancia) {
        Arista arista = new Arista(origen, destino, distancia);
        adyacencias.get(origen).add(arista); // Agrega la arista a la lista de adyacencias del v�rtice origen
    }


     //Obtiene la lista de v�rtices (ubicaciones) en el grafo.

    public List<Ubicacion> getVertices() {
        return vertices;
    }

     // Obtiene la lista de aristas adyacentes a un v�rtice (ubicaci�n) dado.
     

    public List<Arista> getAristasAdyacentes(Ubicacion ubicacion) {
        return adyacencias.get(ubicacion);
    }
}