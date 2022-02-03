/*Se debe crear también una subclase llamada Televisor con los siguientes
atributos: resolución (en pulgadas) y sintonizador TDT (booleano), además de los
atributos heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la resolución, sintonizador TDT y el resto de atributos
heredados. Recuerda que debes llamar al constructor de la clase padre.
Los métodos que se implementara serán:
• Método get y set de los atributos resolución y sintonizador TDT.
• Método crearTelevisor(): este método llama a crearElectrodomestico() de la
clase padre, lo utilizamos para llenar los atributos heredados del padre y
después llenamos los atributos del televisor.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
incrementará el precio un 30% y si tiene un sintonizador TDT incorporado,
aumentará $500. Recuerda que las condiciones que hemos visto en la clase
Electrodomestico también deben afectar al precio.
*/

package ejerc02herencia.entidades;

import java.util.Scanner;

public class Televisor extends Electrodomestico {

    protected Double resolucion;
    protected Boolean sintonizadorTDT;

    public Televisor() {
    }

    public Televisor(Double resolucion, Boolean sintonizadorTDT, double precio, String color, double peso, String consumoEnergetico) {
        super(precio, color, peso, consumoEnergetico);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public Double getResolucion() {
        return resolucion;
    }

    public void setResolucion(Double resolucion) {
        this.resolucion = resolucion;
    }

    public Boolean getSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setSintonizadorTDT(Boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }
    
    public Televisor crearTelevisor(Televisor tv){
        
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        
        super.crearElectrodomestico(tv);
        
        System.out.print("Ingrese la resolucion en pulgadas del televisor: ");
        tv.resolucion = sc.nextDouble();
        
        System.out.print("Si el televisor tiene un sintonizador incorporado ingrese 'true' sino 'false': ");
        tv.sintonizadorTDT = sc.nextBoolean();
        
        return tv;
        
    }
    
    @Override
    public double precioFinal(){
        
        double precioFinal = super.precioFinal();
        
        if (this.resolucion > 40) {
            precioFinal = (precioFinal * 30) / 100;
        }

        if (this.sintonizadorTDT == true) {
            precioFinal += 500;
        }

        return precioFinal;
        
    }

    @Override
    public String toString() {
        return super.toString() + " Televisor{" + "resolucion=" + resolucion + ", sintonizadorTDT=" + sintonizadorTDT + '}';
    }
    
    
}
