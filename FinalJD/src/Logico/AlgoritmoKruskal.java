package Logico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class AlgoritmoKruskal implements Algoritmo {
    private Grafo arbolDeExpansionMinima;


    public List<Ubicacion> calcularRuta(Grafo grafo, Ubicacion origen, Ubicacion destino) {
        // El algoritmo de Kruskal no se utiliza para calcular rutas entre dos ubicaciones específicas
        return null;
    }


    public Grafo optimizarRutas(Grafo grafo) {
        // Inicialización del árbol de expansión mínima
        arbolDeExpansionMinima = new Grafo();

        // Estructura de datos para realizar la unión de conjuntos
        Map<Ubicacion, Ubicacion> padres = new HashMap<>();
        Map<Ubicacion, Integer> rangos = new HashMap<>();

        // Inicializar la estructura de datos de unión de conjuntos
        for (Ubicacion vertice : grafo.getVertices()) {
            padres.put(vertice, vertice);
            rangos.put(vertice, 0);
        }

        // Cola de prioridad para mantener las aristas ordenadas por distancia
        PriorityQueue<Arista> colaDeAristas = new PriorityQueue<>(Comparator.comparingDouble(Arista::getDistancia));
        colaDeAristas.addAll(grafo.getAristasAdyacentes(null)); //pendiente arreglar esto

        while (!colaDeAristas.isEmpty() && arbolDeExpansionMinima.getVertices().size() < grafo.getVertices().size()) {
            // Obtener la arista de menor peso
            Arista aristaMinima = colaDeAristas.poll();

            // Encontrar los conjuntos representantes de los vértices de la arista
            Ubicacion representanteOrigen = encontrarRepresentante(padres, aristaMinima.getOrigen());
            Ubicacion representanteDestino = encontrarRepresentante(padres, aristaMinima.getDestino());

            // Si los vértices pertenecen a diferentes conjuntos, agregar la arista al árbol de expansión mínima
            if (!representanteOrigen.equals(representanteDestino)) {
                arbolDeExpansionMinima.agregarVertice(aristaMinima.getOrigen());
                arbolDeExpansionMinima.agregarVertice(aristaMinima.getDestino());
                arbolDeExpansionMinima.agregarArista(aristaMinima.getOrigen(), aristaMinima.getDestino(), aristaMinima.getDistancia());

                // Unir los conjuntos de los vértices
                union(padres, rangos, representanteOrigen, representanteDestino);
            }
        }

        return arbolDeExpansionMinima;
    }


     // Obtiene el árbol de expansión mínima calculado por el algoritmo de Kruskal.
 
    public Grafo getArbolDeExpansionMinima() {
        return arbolDeExpansionMinima;
    }

    private Ubicacion encontrarRepresentante(Map<Ubicacion, Ubicacion> padres, Ubicacion vertice) {
        // Encontrar el representante del conjunto al que pertenece el vértice
        if (!padres.get(vertice).equals(vertice)) {
            padres.put(vertice, encontrarRepresentante(padres, padres.get(vertice)));
        }
        return padres.get(vertice);
    }

    private void union(Map<Ubicacion, Ubicacion> padres, Map<Ubicacion, Integer> rangos, Ubicacion representante1, Ubicacion representante2) {
        // Unir dos conjuntos mediante la unión por rango
        int rango1 = rangos.get(representante1);
        int rango2 = rangos.get(representante2);

        if (rango1 > rango2) {
            padres.put(representante2, representante1);
        } else if (rango1 < rango2) {
            padres.put(representante1, representante2);
        } else {
            padres.put(representante2, representante1);
            rangos.put(representante1, rango1 + 1);
        }
    }
}