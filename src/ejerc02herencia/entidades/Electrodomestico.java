/*Crear una superclase llamada Electrodoméstico con los siguientes atributos:
precio, color, consumo energético (letras entre A y F) y peso.
Los constructores que se deben implementar son los siguientes:
• Un constructor vacío.
• Un constructor con todos los atributos pasados por parámetro.
Los métodos a implementar son:
• Métodos getters y setters de todos los atributos.
• Método comprobarConsumoEnergetico(char letra): comprueba que la letra
es correcta, sino es correcta usara la letra F por defecto. Este método se debe
invocar al crear el objeto y no será visible.
10
• Método comprobarColor(String color): comprueba que el color es correcto, y
si no lo es, usa el color blanco por defecto. Los colores disponibles para los
electrodomésticos son blanco, negro, rojo, azul y gris. No importa si el nombre
está en mayúsculas o en minúsculas. Este método se invocará al crear el
objeto y no será visible.
• Metodo crearElectrodomestico(): le pide la información al usuario y llena el
electrodoméstico, también llama los métodos para comprobar el color y el
consumo. Al precio se le da un valor base de $1000.
• Método precioFinal(): según el consumo energético y su tamaño, aumentará
el valor del precio. Esta es la lista de precios:
 */
package ejerc02herencia.entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Electrodomestico {

    protected double precio;
    protected String color;
    protected double peso;
    protected String consumoEnergetico;

    public Electrodomestico() {
    }

    public Electrodomestico(double precio, String color, double peso, String consumoEnergetico) {
        this.precio = precio;
        this.color = color;
        this.peso = peso;
        this.consumoEnergetico = consumoEnergetico;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(String consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public void comprobarConsumoEnergetico(char letra) {

        String consumo = "ABCDEF";
        String letraString = Character.toString(letra);
        
        if (!consumo.contains(letraString.toUpperCase())) { //convierto el valor char a tipo String
            //System.out.println(String.valueOf("F"));
            this.consumoEnergetico = consumo.substring(5);
        } else {
            //System.out.println(String.valueOf(letra));
            //Character.valueOf(letra); //de string a cadena
            this.consumoEnergetico = letraString.toUpperCase(); //consumo.charAt(letra);
        }
    }

    public void comprobarColor(String color) {

        ArrayList<String> colores = new ArrayList<>();

        colores.add("BLANCO");
        colores.add("NEGRO");
        colores.add("ROJO");
        colores.add("AZUL");
        colores.add("GRIS");

        if (!(colores.contains(color.toUpperCase()))) {
            this.color = colores.get(0);
        } else {
            this.color = color;
        }

    }

    public Electrodomestico crearElectrodomestico(Electrodomestico el) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("El precio de base del electrodomestico es: 1000");
        el.precio = 1000;
        
        System.out.print("Ingrese el color del electrodomestico: ");
        el.comprobarColor(sc.next());
        
        System.out.print("Ingrese el consumo energetico del electrodomestico: ");
        el.comprobarConsumoEnergetico(sc.next().charAt(0));
        
        System.out.print("Ingrese el peso del electrodomestico: ");
        el.peso = sc.nextDouble();
        
        return el;
        
    }

    public double precioFinal() {

        double precioFinal = 0;

        switch (consumoEnergetico) {
            case "A":
                precioFinal = this.precio + 1000;
                break;
            case "B":
                precioFinal = this.precio + 800;
                break;
            case "C":
                precioFinal = this.precio + 600;
                break;
            case "D":
                precioFinal = this.precio + 500;
                break;
            case "E":
                precioFinal = this.precio + 300;
                break;
            case "F":
                precioFinal = this.precio + 100;
                break;
        }

        if (this.peso >= 1 && this.peso <= 19) {
            precioFinal += 100;
        } else if (this.peso >= 20 && this.peso <= 49) {
            precioFinal += 500;
        } else if (this.peso >= 50 && this.peso <= 79) {
            precioFinal += 800;
        } else if (this.peso >= 80) {
            precioFinal += 1000;
        }
        
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" + "precio=" + precio + ", color=" + color + ", peso=" + peso + ", consumoEnergetico=" + consumoEnergetico + '}';
    }

    
}
