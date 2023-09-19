
package sistemas.de.votaciones;

/**
 *
 * @author abrah
 */
import java.util.Scanner;
public class SistemasDeVotaciones {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
       
        System.out.println("Bienvenido al sistema de votaciones");
        System.out.println("Ingrese contraseña del sistema");
        
        String passSistem = scan.nextLine();
        
        System.out.println("Sistema de votaciones");
        System.out.println(" 1. Iniciar sesion");
        System.out.println(" 2. Crear usuario");
        
        int opcion1 = scan.nextInt();
        
        int i = 1;
        while (i<5){
            switch(opcion1){
                case 1:
                    i = 6;
                    System.out.println("Sistema de votaciones");
                    System.out.println("Iniciar sesion");
                    System.out.println("1. Administrador");
                    System.out.println("2. Registrador de votantes");
                    System.out.println("3. Votante");
                    System.out.println("4. Auditor");
                    System.out.println("Ingrese una opcion: ");
                    int opcI = scan.nextInt();
                    break;
                    
                case 2:
                    i=6;
                    System.out.println("Sistema de votaciones");
                    System.out.println("1. Agregar usuario");
                    System.out.println("2. Restablecer contraseña");
                    System.out.println("3. Modificar usuario");
                    System.out.println("4. Deshabilitar usuario");
                    break;
                default:
                System.out.println("Opcion incorrecta");
            
            // Ciclo para registro de usuarios;
               int c = 5;
               while (c < 5){
               
                   switch (opcR){
                       case 1:
                        System.out.println("Sistema de votaciones");
                        System.out.println(" Rol de usuario");
                        System.out.println("1. Administrador");
                        System.out.println("2. Registrador de votante");
                        System.out.println("3. Auditor");
                        int opcRol = scan.nextInt();
                        c=6;
                        break;
                        
                       case 2:
                           
                           break;
                   
                   }
               }
            
            
            
            
            
            
            
            };
        };
    }
    
}
