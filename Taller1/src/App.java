import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = {"Mercurio", "Venus", "Marte", "Jupiter", "Saturno"};
    static double[] distancias = {77.0, 61.0, 54.6, 965.0, 1256.0};
    static String[] navesEspaciales = {"Voyager", "Vostok", "Atlantis"};
    static double[] tiempoDeViaje = {147, 110, 128, 390, 17245};
    static String opcionPlaneta;
    static String opcionNave;

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
                case 3:
                    monitoreador();
                    break;
                case 4:
                    simularViaje();
                    break;
                default:
                    break;
            }
        }while(opcion !=5);
        
   }
    
    public static void menu() {
        System.out.println("¡Bienvenido al menú, continua con los pasos!");
        System.out.println("1. Seleccione un planeta de destino");
        System.out.println("2. Seleccione la nave espacial ");
        System.out.println("3. Monitoreo del viaje");
        System.out.println("4. Simular un viaje");
        System.out.println("5. Salir");
        System.out.println("Elige una opción que prefieras");  
   }

    public static int escogerPlaneta() {
        System.out.println("Seleccione tu planeta de destino");
        //Opciones planetas
        for (int i = 0; i < planetas.length; i++) {
            System.out.println((i + 1) + ". " + planetas[i] + " (Distancia: " + distancias[i] + " UA)");
        }
        
        // seleccion de planeta
        System.out.println("Ingrese el numero del planeta");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        //validador entrada usuario
        while (opcion < 1 || opcion > planetas.length) {
            System.out.println("Opción inválida. Ingrese un número entre 1 y " + planetas.length);
            opcion = scanner.nextInt();    
        }if (opcion <= 5){
            System.out.println("Has elegido el planeta: " + opcion + ".");
        }     
        return opcion - 1;
    }

    public static int escogerNave() {
        System.out.println("Seleccion nave espacial");

        for (int i =0; i < navesEspaciales.length; i++) {
            System.out.println((i + 1) + ". " + navesEspaciales[i]);
        }
        //seleccion de planeta
        System.out.println("Ingrese el número de la nave: "); 
        Scanner scanner = new Scanner(System.in); 
        int opcion = scanner.nextInt(); 
        
        //validador entrada usuario 
        while (opcion < 1 || opcion > navesEspaciales.length) { 
            System.out.println("Opción inválida. Ingrese un número entre 1 y " + navesEspaciales.length); 
            opcion = scanner.nextInt();
        } if (opcion <= 3){
            System.out.println("Genial, elegiste la nave número: " + opcion +".");
        }
        return opcion - 1;
   }

    public static void simularViaje() {
        System.out.println("Elige una de estas opciones: ");
        System.out.println("1. Elegir planeta");
        System.out.println("2. Elegir Nave");
        System.out.println("3. Calcular recursos");

        int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    escogerPlaneta();
                    break;
                case 2:
                    escogerNave();
                    break;
                case 3:
                    break;

                default: System.out.println("Opcion no valida, intenta de nuevo.");
                    break;
            }    
    }   

    public static void monitoreador() { 
        System.out.println( "---Incializando viaje---");
        Random random = new Random();
        for(int progreso = 0; progreso <= 100; progreso+=10){
            System.out.println("Progreso de tu viaje: " + progreso);    
            if (progreso == 50) {
                System.out.println("Mitad del camino alcanzado");
            }
            if (random.nextInt(10) < 3) {
                System.out.println("¡Evento inesperado! Gestionando ajustes...");
            } 
            try { Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println("Error, imposible simular.");
            } 
        }
        System.out.println("Llegaste a tu destino, magnifico!");
    }


    public static void calcularRecursos(int distancias) {
        
        double combustiblePorKilometro = 11_000;
        int alimentoPorDia = 3;
        int kilometrosPorDia = 66_666;

        double combustibleRequerido = distancias * combustiblePorKilometro;
        int diasDeVuelo = distancias / kilometrosPorDia;
        int comidaNecesaria = diasDeVuelo * alimentoPorDia;

        System.out.println("Lo simulación del viaje fue: ");
        System.out.println("La duración del viaje es de: " + diasDeVuelo + " días");
        System.out.println("El combustible necesario es de: " + combustibleRequerido + " unidades");
        System.out.println("La comida necesaria: " + comidaNecesaria + " raciones");
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
    for (int i = porcentaje; i <= 100; i++) {
        barra.append(' ');
    }
    System.out.print("\r" + barra.toString()+ " " + porcentaje + "%");
    System.out.flush();
}
}   