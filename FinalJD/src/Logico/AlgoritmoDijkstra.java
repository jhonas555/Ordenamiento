package Logico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class AlgoritmoDijkstra implements Algoritmo {

	
    public List<Ubicacion> calcularRuta(Grafo grafo, Ubicacion origen, Ubicacion destino) {
       
    	// Inicializaci�n de estructuras de datos
        Map<Ubicacion, Double> distancias = new HashMap<>();
        Map<Ubicacion, Ubicacion> predecesores = new HashMap<>();
        PriorityQueue<UbicacionConDistancia> colaDeVertices = new PriorityQueue<>();

        // Inicializar todos los v�rtices con distancia infinita
        for (Ubicacion vertice : grafo.getVertices()) {
            distancias.put(vertice, Double.POSITIVE_INFINITY);
        }

        // La distancia del v�rtice de origen a s� mismo es 0
        distancias.put(origen, 0.0);
        colaDeVertices.offer(new UbicacionConDistancia(origen, 0.0));

        while (!colaDeVertices.isEmpty()) {
            // Obtener el v�rtice con la menor distancia desde el origen
            UbicacionConDistancia actual = colaDeVertices.poll();
            Ubicacion ubicacionActual = actual.ubicacion;

            // Si ya llegamos al destino, reconstruir y devolver la ruta m�s corta
            if (ubicacionActual.equals(destino)) {
                return reconstruirRuta(origen, destino, predecesores);
            }

            // Revisar los v�rtices adyacentes
            List<Arista> aristasAdyacentes = grafo.getAristasAdyacentes(ubicacionActual);
            for (Arista arista : aristasAdyacentes) {
                Ubicacion vecino = arista.getDestino();
                double distanciaActual = distancias.get(ubicacionActual);
                double distanciaVecino = distancias.get(vecino);
                double nuevaDistancia = distanciaActual + arista.getDistancia();

                // Si hay un camino m�s corto hacia el vecino, actualizarlo
                if (nuevaDistancia < distanciaVecino) {
                    distancias.put(vecino, nuevaDistancia);
                    predecesores.put(vecino, ubicacionActual);
                    colaDeVertices.offer(new UbicacionConDistancia(vecino, nuevaDistancia));
                }
            }
        }

        // Si no se encontr� el destino, devolver una lista vac�a
        return new ArrayList<>();
    }


    public void optimizarRutas(Grafo grafo) {
        // El algoritmo de Dijkstra no se utiliza para optimizar rutas
    }

    private List<Ubicacion> reconstruirRuta(Ubicacion origen, Ubicacion destino, Map<Ubicacion, Ubicacion> predecesores) {
        List<Ubicacion> ruta = new ArrayList<>();
        Ubicacion actual = destino;

        while (!actual.equals(origen)) {
            ruta.add(0, actual);
            actual = predecesores.get(actual);
        }

        ruta.add(0, origen);
        return ruta;
    }

    // Clase auxiliar para representar una ubicaci�n con su distancia asociada
    private static class UbicacionConDistancia implements Comparable<UbicacionConDistancia> {
        Ubicacion ubicacion;
        double distancia;

        UbicacionConDistancia(Ubicacion ubicacion, double distancia) {
            this.ubicacion = ubicacion;
            this.distancia = distancia;
        }

        public int compareTo(UbicacionConDistancia otra) {
            return Double.compare(this.distancia, otra.distancia);
        }
    }
}
