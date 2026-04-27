public class Calculadora {
    public static void main(String[] args) {
        int a = 3;
        int b = 8;
        
       OperacionesMatematicas objcalc1 = new OperacionesMatematicas(a, b); 
        System.out.println("Suma" + objcalc1.sumar (a, b));
        System.out.println("resta: " + objcalc1.restar(a, b));
        System.out.println("multiplición: " + objcalc1.multiplicar(a, b));
        System.out.println("división: " + objcalc1.dividir(a, b));
        System.out.println("potencia: " + objcalc1.potencia(a, b));
 
    }
}


