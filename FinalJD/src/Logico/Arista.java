package Logico;

class Arista {
    private Ubicacion origen; // Ubicaci�n de origen de la arista
    private Ubicacion destino; // Ubicaci�n de destino de la arista
    private double distancia; // Distancia entre las ubicaciones de origen y destino


    public Arista(Ubicacion origen, Ubicacion destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }


     // Obtiene la ubicaci�n de origen de la arista.

    public Ubicacion getOrigen() {
        return origen;
    }


     // Establece la ubicaci�n de origen de la arista.

    public void setOrigen(Ubicacion origen) {
        this.origen = origen;
    }


     // Obtiene la ubicaci�n de destino de la arista.

    public Ubicacion getDestino() {
        return destino;
    }

     // Establece la ubicaci�n de destino de la arista.

    public void setDestino(Ubicacion destino) {
        this.destino = destino;
    }


     // Obtiene la distancia entre las ubicaciones de origen y destino.
    	 double getDistancia() {
    		 
        return distancia;
    }

     // Establece la distancia entre las ubicaciones de origen y destino.

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}