package busquedaconcurrencia;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusquedaHilos implements Runnable {
    private String[] singleData;
    private String[] query;
    private JsonParser parser;
    private BusquedaConcurrencia bc;
	
    public BusquedaHilos(final byte singleAmount, final String[] query, final JsonParser parser) {
        this.bc = new BusquedaConcurrencia();
		this.singleData = new String[singleAmount];
		this.query = query;
		this.parser = parser;
		new Thread(this, "1").start();
		new Thread(this, "2").start();
    }
    
    @Override
    public void run() {
		empezarBusqueda();
    }
	
	public synchronized void empezarBusqueda() {
		while (!parser.isClosed()) {

            // leer el elemento
            JsonToken token = null;
                    try {
                        token = parser.nextToken();
                    } catch (IOException ex) {
                        Logger.getLogger(BusquedaHilos.class.getName()).log(Level.SEVERE, null, ex);
                    }
            // si la llamada a nextToken devuelve null, se ha alcanzado el final del fichero
            if (token == null)
                break;

                    try {
                        // Procesar el elemento leido
                        bc.procesaValorJSON(token, parser, singleData, (byte)0, query);
                    } catch (IOException ex) {
                        Logger.getLogger(BusquedaHilos.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
        }
	}

}