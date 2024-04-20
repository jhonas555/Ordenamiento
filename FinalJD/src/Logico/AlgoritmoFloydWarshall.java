package Logico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AlgoritmoFloydWarshall implements Algoritmo {
    private Map<Ubicacion, Map<Ubicacion, Double>> distancias;
    private Map<Ubicacion, Map<Ubicacion, Ubicacion>> predecesores;


    public List<Ubicacion> calcularRuta(Grafo grafo, Ubicacion origen, Ubicacion destino) {
        // Inicializar las estructuras de datos
        inicializarDistanciasYPredecesores(grafo);

        // Ejecutar el algoritmo de Floyd-Warshall
        ejecutarAlgoritmo(grafo);

        // Reconstruir la ruta más corta desde el origen hasta el destino
        return reconstruirRuta(origen, destino);
    }


    public void optimizarRutas(Grafo grafo) {
        // Inicializar las estructuras de datos
        inicializarDistanciasYPredecesores(grafo);

        // Ejecutar el algoritmo de Floyd-Warshall
        ejecutarAlgoritmo(grafo);
    }

    private void inicializarDistanciasYPredecesores(Grafo grafo) {
        distancias = new HashMap<>();
        predecesores = new HashMap<>();

        for (Ubicacion vertice1 : grafo.getVertices()) {
            distancias.put(vertice1, new HashMap<>());
            predecesores.put(vertice1, new HashMap<>());

            for (Ubicacion vertice2 : grafo.getVertices()) {
                if (vertice1.equals(vertice2)) {
                    distancias.get(vertice1).put(vertice2, 0.0);
                } else {
                    distancias.get(vertice1).put(vertice2, Double.POSITIVE_INFINITY);
                    predecesores.get(vertice1).put(vertice2, null);
                }
            }

            List<Arista> aristasAdyacentes = grafo.getAristasAdyacentes(vertice1);
            for (Arista arista : aristasAdyacentes) {
                Ubicacion origen = arista.getOrigen();
                Ubicacion destino = arista.getDestino();
                double distancia = arista.getDistancia();

                distancias.get(origen).put(destino, distancia);
                predecesores.get(origen).put(destino, origen);
            }
        }
    }

    private void ejecutarAlgoritmo(Grafo grafo) {
        List<Ubicacion> vertices = grafo.getVertices();

        for (Ubicacion verticeIntermedio : vertices) {
            for (Ubicacion verticeOrigen : vertices) {
                for (Ubicacion verticeDestino : vertices) {
                    double distanciaActual = distancias.get(verticeOrigen).get(verticeDestino);
                    double nuevaDistancia = distancias.get(verticeOrigen).get(verticeIntermedio) +
                            distancias.get(verticeIntermedio).get(verticeDestino);

                    if (nuevaDistancia < distanciaActual) {
                        distancias.get(verticeOrigen).put(verticeDestino, nuevaDistancia);
                        predecesores.get(verticeOrigen).put(verticeDestino, predecesores.get(verticeIntermedio).get(verticeDestino));
                    }
                }
            }
        }
    }

    private List<Ubicacion> reconstruirRuta(Ubicacion origen, Ubicacion destino) {
        List<Ubicacion> ruta = new ArrayList<>();
        Ubicacion actual = destino;

        while (!actual.equals(origen)) {
            ruta.add(0, actual);
            actual = predecesores.get(origen).get(actual);
        }

        ruta.add(0, origen);
        return ruta;
    }
}