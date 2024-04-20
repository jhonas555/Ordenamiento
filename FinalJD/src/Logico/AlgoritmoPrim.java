package Logico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class AlgoritmoPrim implements Algoritmo {
    private Grafo arbolDeExpansionMinima;


    public List<Ubicacion> calcularRuta(Grafo grafo, Ubicacion origen, Ubicacion destino) {
        // El algoritmo de Prim no se utiliza para calcular rutas entre dos ubicaciones específicas
        return null;
    }


    public Grafo optimizarRutas(Grafo grafo) {
        // Inicialización del árbol de expansión mínima
        arbolDeExpansionMinima = new Grafo();

        // Conjunto de vértices visitados
        Set<Ubicacion> visitados = new HashSet<>();

        // Cola de prioridad para mantener las aristas
        PriorityQueue<Arista> colaDeAristas = new PriorityQueue<>(Comparator.comparingDouble(Arista::getDistancia));

        // Elegir un vértice inicial y agregarlo al árbol de expansión mínima
        
        Ubicacion verticeInicial = grafo.getVertices().get(0);
        arbolDeExpansionMinima.agregarVertice(verticeInicial);
        visitados.add(verticeInicial);

        // Agregar todas las aristas adyacentes al vértice inicial a la cola de prioridad
        
        List<Arista> aristasAdyacentes = grafo.getAristasAdyacentes(verticeInicial);
        colaDeAristas.addAll(aristasAdyacentes);

        while (!colaDeAristas.isEmpty() && visitados.size() < grafo.getVertices().size()) {
            // Obtener la arista de menor peso
           
        	Arista aristaMinima = colaDeAristas.poll();

            // Obtener los vértices de la arista mínima
            
            Ubicacion origen = aristaMinima.getOrigen();
            Ubicacion destino = aristaMinima.getDestino();

            // Si el destino no ha sido visitado, agregar la arista al árbol de expansión mínima
            
            if (!visitados.contains(destino)) {
                arbolDeExpansionMinima.agregarVertice(destino);
                arbolDeExpansionMinima.agregarArista(origen, destino, aristaMinima.getDistancia());
                visitados.add(destino);

                // Agregar las aristas adyacentes al nuevo vértice a la cola de prioridad
                List<Arista> nuevasAristas = grafo.getAristasAdyacentes(destino);
                colaDeAristas.addAll(nuevasAristas);
            }
        }

        return arbolDeExpansionMinima;
    }


     // Obtiene el árbol de expansión mínima calculado por el algoritmo de Prim.

    public Grafo getArbolDeExpansionMinima() {
        return arbolDeExpansionMinima;
    }
}
