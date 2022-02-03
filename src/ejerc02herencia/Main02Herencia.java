/*
Finalmente, en el main debemos realizar lo siguiente:
Vamos a crear una Lavadora y un Televisor y llamar a los métodos necesarios
para mostrar el precio final de los dos electrodomésticos.

3. Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de
Electrodomésticos para guardar 4 electrodomésticos, ya sean lavadoras o
televisores, con valores ya asignados.
Luego, recorrer este array y ejecutar el método precioFinal() en cada
electrodoméstico. Se deberá también mostrar el precio de cada tipo de objeto,
es decir, el precio de todos los televisores y el de las lavadoras. Una vez hecho
eso, también deberemos mostrar, la suma del precio de todos los
Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de 2000
y un televisor de 5000, el resultado final será de 7000 (2000+5000) para
electrodomésticos, 2000 para lavadora y 5000 para televisor.
*/

package ejerc02herencia;

import ejerc02herencia.entidades.Electrodomestico;
import ejerc02herencia.entidades.Lavadora;
import ejerc02herencia.entidades.Televisor;
import java.util.ArrayList;

public class Main02Herencia {

    public static void main(String[] args) {
        
        Lavadora lav = new Lavadora();
        
        lav.crearLavadora(lav);
        System.out.println("\nEl precio total de la lavadora es: " + lav.precioFinal());
        
        System.out.println(" ");
        
        Televisor tv = new Televisor();
        
        tv.crearTelevisor(tv);
        System.out.println("\nEl precio total del televisor es: " + tv.precioFinal());
                
        ArrayList<Electrodomestico> elect = new ArrayList();
        
        Lavadora lav1 = new Lavadora(50.0, 1000, "Blanco", 100, "A");
        Lavadora lav2 = new Lavadora(100.0, 1000, "Rojo", 200, "B");
        Televisor tv1 = new Televisor(50.0, true, 1000, "Blanco", 60, "A");
        Televisor tv2 = new Televisor(30.0, false, 1000, "Rojo", 30, "F");
        
        elect.add(lav1);
        elect.add(lav2);
        elect.add(tv1);
        elect.add(tv2);
        
        double sumatoria = 0;
        
        for(Electrodomestico aux : elect){ 
            
            System.out.println("Precio de "+ aux + " : "+ aux.precioFinal());
            sumatoria += aux.precioFinal();
        }
        System.out.println("\nSuma de precios de todos los electrodomesticos: " + sumatoria);
    }
    
}
