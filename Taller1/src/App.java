import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = {"Mercurio", "Venus", "Marte", "Jupiter", "Saturno"};
    static double[] distancias = {77.0, 61.0, 54.6, 965.0, 1256.0};
    static String[] navesEspaciales = {"Voyager", "Vostok", "Atlantis"};
    static double[] velocidades = {14000.0, 11000.0, 12800.0};
    static double[] probabilidadLluvia = {99, 90, 100};
    static double[] consumoCombustible = {140.0, 110.0, 128000.0}; //En millones de Kilometros
    static double[] tiempoDeViaje = {147, 110, 128, 390, 17245};
    static String opcionPlaneta;
    static String opcionNave;
    
    static int naveopcion;// apunta a la posicion de la nava mas no al nombre 
    static int planetaopcion; //este indica la posicion del planeta seleccionado 
    static int saludNave = 100;
    static int escudos = 50;
    

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
            System.out.println((i + 1) + ". " + planetas[i] + " (Distancia: " + distancias[i] + " Tiempo en días: " + tiempoDeViaje[i]);
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

    public static int escogerNave(){
        System.out.println("Seleccion nave espacial");

        for (int i =0; i < navesEspaciales.length; i++) {
            System.out.println("Nave " + (i + 1) + ". " + navesEspaciales[i] + "- Velocidad: " + velocidades[i]);
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
            System.out.println("Genial, elegiste la nave número: " + navesEspaciales[opcion - 1]);
            naveopcion = opcion -1;
        }
        return opcion - 3;
   }

    public static void simularViaje() {
        System.out.println("---Iniciando Viaje----");
        Random random = new Random();
        for (int progreso = 0; progreso <= 100; progreso+=10){
            System.out.println("Progreso de tu viaje: " + progreso);                           
            if (progreso == 50) {
                System.out.println("Mitad del camino alcanzado");
            }
            if (random.nextInt(20) < 3) {
                lluviaDeAsteroides();
            } 
            try { Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println("Error, imposible simular.");
            }     
        }
        System.out.println("Llegaste a tu destino, magnifico!");
    }
    
    public static void monitoreador() { 
        System.out.println( "---Inicializando viaje---");
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


    public static void calcularRecursos() {

        double combustible = consumoCombustible[naveopcion];
        double oxigeno = distancias[planetaopcion] * 100;  //por cada millon de km, se necesita 100 unidades de oxigeno 
        System.out.println("La cantidad de unidades de oxigeno "+ combustible);
        System.out.println("La cantidad de unidades de oxigeno necesario es: " + oxigeno);

    }

    public static void lluviaDeAsteroides() { {
        System.out.println("¡Alerta! ¡Lluvia de asteroides detectada!");
    
        // Generar una intensidad aleatoria
        int intensidad = random.nextInt(5) + 1; // Intensidad de 1 a 5
        System.out.println("Intensidad de la lluvia: " + intensidad);
    
        // Simular daño a la nave
        int dañoEstructura = intensidad * 10;
        int dañoEscudos = intensidad * 5;
        int consumoCombustible = intensidad * 20;
    
        // Aplicar el daño
        saludNave -= dañoEstructura;
        escudos -= dañoEscudos;
        int combustible = consumoCombustible;
    
        System.out.println("Daño a la estructura: " + dañoEstructura);
        System.out.println("Daño a los escudos: " + dañoEscudos);
        System.out.println("Consumo de combustible: " + consumoCombustible);
    
        // Verificar si la nave ha sido destruida
        if (saludNave <= 0) {
            System.out.println("¡La nave ha sido destruida!");
            // Terminar la simulación
        }
    }
        
    
}   