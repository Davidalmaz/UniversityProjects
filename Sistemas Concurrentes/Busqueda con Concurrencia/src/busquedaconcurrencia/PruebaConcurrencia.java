package busquedaconcurrencia;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;

import java.util.Scanner;

public class PruebaConcurrencia {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        final byte DATA_AMOUNT = 13;
        //1 = points                        //7 = designation           //13 = winery
        //2 = title                         //8 = variety
        //3 = description                   //9 = region_1
        //4 = taster_name                   //10 = region_2
        //5 = taster_twitter_handle         //11 = province
        //6 = price                         //12 = country

        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(new File("winemag-data-130k-v2.json"));

        //Dato query
        String query[] = new String[DATA_AMOUNT];
        Scanner sn = new Scanner(System.in);
        
        String opc;
        int opcion; //Guardaremos la opcion del usuario
		
		//Evitando constantes mágicas.
		final byte DO_SEARCH_NUMBER = 0;
 
           System.out.println("Escoja un campo para realizar la búsqueda");                
        while(true){
            
           System.out.println("1.Points");
           System.out.println("2.Title");
           System.out.println("3.Description");
           System.out.println("4.Taster Name");
           System.out.println("5.Taster Twitter Handle");
           System.out.println("6.Price");
           System.out.println("7.Designation");
           System.out.println("8.Variety");
           System.out.println("9.Region 1");
           System.out.println("10.Region 2");
           System.out.println("11.Province");
           System.out.println("12.Country");
           System.out.println("13.Winery");
           opcion = sn.nextInt();
           
		   if (opcion > DO_SEARCH_NUMBER && opcion <= DATA_AMOUNT) {
			   System.out.println("Ingrese el valor a buscar:");
			   query[opcion-1] = sc.nextLine();
                           System.out.println("Seleccione otro campo o presione '0' para realizar la búsqueda:");
                   }
		   else
			   if (opcion == DO_SEARCH_NUMBER)
				   break;
			   else
				   System.out.println("Intente otra vez.\n");
        }
		
            BusquedaHilos bh = new BusquedaHilos(DATA_AMOUNT, query, parser);
    }  
}