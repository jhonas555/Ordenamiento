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
        // El algoritmo de Prim no se utiliza para calcular rutas entre dos ubicaciones espec�ficas
        return null;
    }


    public Grafo optimizarRutas(Grafo grafo) {
        // Inicializaci�n del �rbol de expansi�n m�nima
        arbolDeExpansionMinima = new Grafo();

        // Conjunto de v�rtices visitados
        Set<Ubicacion> visitados = new HashSet<>();

        // Cola de prioridad para mantener las aristas
        PriorityQueue<Arista> colaDeAristas = new PriorityQueue<>(Comparator.comparingDouble(Arista::getDistancia));

        // Elegir un v�rtice inicial y agregarlo al �rbol de expansi�n m�nima
        
        Ubicacion verticeInicial = grafo.getVertices().get(0);
        arbolDeExpansionMinima.agregarVertice(verticeInicial);
        visitados.add(verticeInicial);

        // Agregar todas las aristas adyacentes al v�rtice inicial a la cola de prioridad
        
        List<Arista> aristasAdyacentes = grafo.getAristasAdyacentes(verticeInicial);
        colaDeAristas.addAll(aristasAdyacentes);

        while (!colaDeAristas.isEmpty() && visitados.size() < grafo.getVertices().size()) {
            // Obtener la arista de menor peso
           
        	Arista aristaMinima = colaDeAristas.poll();

            // Obtener los v�rtices de la arista m�nima
            
            Ubicacion origen = aristaMinima.getOrigen();
            Ubicacion destino = aristaMinima.getDestino();

            // Si el destino no ha sido visitado, agregar la arista al �rbol de expansi�n m�nima
            
            if (!visitados.contains(destino)) {
                arbolDeExpansionMinima.agregarVertice(destino);
                arbolDeExpansionMinima.agregarArista(origen, destino, aristaMinima.getDistancia());
                visitados.add(destino);

                // Agregar las aristas adyacentes al nuevo v�rtice a la cola de prioridad
                List<Arista> nuevasAristas = grafo.getAristasAdyacentes(destino);
                colaDeAristas.addAll(nuevasAristas);
            }
        }

        return arbolDeExpansionMinima;
    }


     // Obtiene el �rbol de expansi�n m�nima calculado por el algoritmo de Prim.

    public Grafo getArbolDeExpansionMinima() {
        return arbolDeExpansionMinima;
    }
}
