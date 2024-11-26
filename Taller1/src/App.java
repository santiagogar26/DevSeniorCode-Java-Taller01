import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = {"Mercurio", "Venus", "Marte", "Jupiter", "Saturno"};
    static double[] distancias = {77.0, 61.0, 54.6, 965.0, 1256.0};
    static String[] navesEspaciales = {"Voyager", "Vostok", "Atlantis"};
    static double[] tiempoDeViaje = {147, 110, 128, 390, 17245};

    public static void main(String[] args) throws Exception {

        int opcion;
        do{
            menu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    escogerPlaneta();
                    break;
                case 2:     
                    escogerNave();
                    break;
                default:
                    break;
            }


        }while(opcion !=4);
        
   }
    
    public static void menu() {
        System.out.println("/n¡Bienvenido al menú principal");
        System.out.println("1. Escoge tu planeta de destino");
        System.out.println("2. Simular un viaje");
        System.out.println("3. Datos de planetas");
        System.out.println("4. Salir");
        System.out.println("/nElige la opción que prefieras");  
   }



    public static void escogerPlaneta() {
        
    }

    public static void escogerNave() {
        System.out.println();
   }

    public static void calcularRecursos() {
    
   }



   //metodos auxiliares

    public static void imprimirDatoPlaneta(int posicion) {
        System.out.println("El planeta " + planetas[posicion] + "y está a una distancia de " + distancias[posicion]);
    }

    public static void main() {
        for (int i = 0; i < planetas.length; i++){
            imprimirDatoPlaneta(i);    
        }  
    }

    public static void planetasDisponibles() {
        System.out.println("Los planetas con disponibilidad son: " + planetas);
    }


    public static void imprimirNaves() {
        System.out.println("Las naves disponibles son: " + navesEspaciales);
    }

    //Evento aleatorio durante el viaje 
    public static void generarEventoAleatorio() {
        Random random = new Random();
        int probabilidadEvento = random.nextInt(100);
        if (probabilidadEvento < 20) { // 20% de probabiliadad de un evento
            Evento evento = new Evento("Tormenta solar");
            System.out.println("¡Evento inesperado! " + evento.descripcion);
            
        }
    }

    //Mostrar la barra de progreso del viaje
    /**
     * @param distanciaRecorrida
     * @param distanciaTotal
     */
    public static void mostrarProgreso(double distanciaRecorrida, double distanciaTotal) {
        int porcentaje = (int) ((distanciaRecorrida / distanciaTotal) * 100);
        StringBuilder barra = new StringBuilder();
        for (int i = 0; i < porcentaje; i++) {
            barra.append('█');  
                    
    }
    barra.append('>');
    for (int i = porcentaje; i < 100; i++) {
        barra.append(' ');
    }
    System.out.print("\r" + barra.toString()+ " " + porcentaje + "%");
    System.out.flush();
}
}   