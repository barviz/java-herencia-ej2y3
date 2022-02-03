/*
A continuación se debe crear una subclase llamada Lavadora, con el atributo
carga, además de los atributos heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la carga y el resto de atributos heredados. Recuerda que
debes llamar al constructor de la clase padre.
Los métodos que se implementara serán:
• Método get y set del atributo carga.
• Método crearLavadora (): este método llama a crearElectrodomestico() de la
clase padre, lo utilizamos para llenar los atributos heredados del padre y
después llenamos el atributo propio de la lavadora.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500,
si la carga es menor o igual, no se incrementará el precio. Este método debe
llamar al método padre y añadir el código necesario. Recuerda que las
condiciones que hemos visto en la clase Electrodoméstico también deben
afectar al precio.
*/

package ejerc02herencia.entidades;

import java.util.Scanner;

public class Lavadora extends Electrodomestico{

    protected Double carga;

    public Lavadora() {
    }

    public Lavadora(Double carga, double precio, String color, double peso, String consumoEnergetico) {
        super(precio, color, peso, consumoEnergetico);
        this.carga = carga;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }
    
    public Lavadora crearLavadora(Lavadora lav){
        
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        
        super.crearElectrodomestico(lav);
        
        System.out.print("Ingrese la carga de la lavadora: ");
        lav.carga = sc.nextDouble();
        
        return lav;
    }
    
    @Override
    public double precioFinal(){
        
        double precioFinal = super.precioFinal();

        if (this.carga > 30) {
            precioFinal += 500;
        }
        
        return precioFinal;
    }

    @Override
    public String toString() {
        return super.toString() + " Lavadora{" + "carga=" + carga + '}';
    }


}
