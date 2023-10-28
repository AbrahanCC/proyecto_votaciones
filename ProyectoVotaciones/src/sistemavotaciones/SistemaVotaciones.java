package SistemaVotaciones;

import java.io.BufferedReader;// Lee texto que ingresa
import java.io.File;// permite manipular archivos
import java.io.FileReader;//lee caracteres del archivo
import java.io.FileWriter;//Escribe caracteres en el archivo
import java.io.IOException;//Contempla los errores de salida o entrada en el archivo
import java.io.PrintWriter;// reescribe texto
import java.nio.file.Files; // Es una libreria, se toma como clase, para compilar los datos para el archivo
import java.util.Scanner;
import java.util.logging.Level;// Llevan el control de los resgistros en el archivo
import java.util.logging.Logger;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;// Permite remplazar archivos en caso que ya existan, y no repetirlos

/**
*
* @author abrah
*/
        
        public class SistemaVotaciones {

        
        int Ingresar;
        int Agregar;
        String nombre, apellido, contrasena, email, dpi;
        boolean salir;
        File deshabilitar = new File ("deshabilitados.txt");
        File modificacionesnuevo = new File("modificaciones.txt");
        File reinicionuevo = new File ("reinicio.txt");
        
        int opcionVotante;
        String nombreVotante, apellidoVotante, dpiVotante, sexo, fechaNacimiento, direccion, departamento, municipio,pais;
        File modificar = new File ("modificacionVotantes.txt");
        File reiniciar = new File("contrasenaVotante.txt");
        File registrarfallecimiento = new File ("registrar.txt");
        
        // Constructor de la clase
        public SistemaVotaciones() {
        Ingresar = 0;
        Agregar = 0;
        }

        // Método para el menú principal
        public void menuPrincipal(File datosAdmin, FileWriter escribir, PrintWriter linea, File datosRegVotantes, File datosAuditor, String archivo) throws IOException {
        Scanner scan = new Scanner(System.in);

        int i = 1;

        while (i == 1) {
            System.out.println("Sistema de Votaciones");
            System.out.println("Registro de Usuarios");
  
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Modificar Usuario");
            System.out.println("3. Deshabilitar Usuario");
            System.out.println("4. Restablecer Contraseña");

            System.out.println("5. Salir");

            System.out.println("Ingrese una opción");
            int Opciones = scan.nextInt();

            switch (Opciones) {
                case 1:
                    System.out.println("Sistema de Votaciones");
                    System.out.println("Tipo de Usuario");

                    System.out.println("1. Administrador");
                    System.out.println("2. Registrador de Votantes");
                    System.out.println("3. Auditor");
                    
                    System.out.println("4. Regresar");
                    System.out.println("5. Salir.");

                    int tipoUsuario = scan.nextInt();

                    switch (tipoUsuario) {
                        case 1:
                            System.out.println("Ingrese los datos para la Cuenta Administrador");

                            System.out.println("Ingrese nombres: ");
                            scan.nextLine();
                            nombre = scan.nextLine();

                            System.out.println("Ingrese apellidos: ");
                            apellido = scan.nextLine();

                            System.out.println("Ingrese No DPI:");
                            dpi = scan.nextLine();

                            System.out.println("Ingrese Su Email:");
                            email = scan.nextLine();

                            System.out.println("Ingrese una contraseña:");
                            contrasena = scan.nextLine();

                            datosAdmin = new File("datosAdmin.txt");

                            try {
                                if (!datosAdmin.exists()) {
                                    datosAdmin.createNewFile();
                                }
                                escribir = new FileWriter(datosAdmin, true);
                                linea = new PrintWriter(escribir);
                                linea.print(nombre + "|");
                                linea.print(apellido + "|");
                                linea.print(dpi + "|");
                                linea.print(email + "|");
                                linea.print(contrasena + "|");
                                escribir.close();
                                linea.close();
                            } catch (IOException ex) {
                                Logger.getLogger(SistemaVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            System.out.println("Usuario Creado Exitosamente");
                            break;

                        case 2:
                            System.out.println("Ingrese los datos para la cuenta de Registrador de Votantes");

                            System.out.println("Ingrese nombres");
                            scan.nextLine();
                            nombre = scan.nextLine();

                            System.out.println("Ingrese apellidos");
                            apellido = scan.nextLine();

                            System.out.println("Ingrese su DPI");
                            dpi = scan.nextLine();

                            System.out.println("Ingrese su Email");
                            email = scan.nextLine();

                            System.out.println("Ingrese una contraseña");
                            contrasena = scan.nextLine();

                            datosRegVotantes = new File("RegistradorVotantes.txt");

                            try {
                                if (!datosRegVotantes.exists()) {
                                    datosRegVotantes.createNewFile();
                                }
                                escribir = new FileWriter(datosRegVotantes, true);
                                linea = new PrintWriter(escribir);
                                linea.print(nombre + "|");
                                linea.print(apellido + "|");
                                linea.print(dpi + "|");
                                linea.print(email + "|");
                                linea.print(contrasena + "|");
                                escribir.close();
                                linea.close();
                                
                            } 
                            catch (IOException ex) {
                                Logger.getLogger(SistemaVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println("Usuario Creado Exitosamente");
                            break;

                        case 3:
                            System.out.println("Ingrese los datos para la Cuenta Auditor");
                            
                            System.out.println("Ingrese nombres :");
                            scan.nextLine();
                            nombre = scan.nextLine();
                            
                            System.out.println("Ingrese apellidos :");
                            apellido = scan.nextLine();
                            
                            System.out.println("Ingrese No DPI:");
                            dpi = scan.nextLine();
                            
                            System.out.println("Ingrese su Email");
                            email = scan.nextLine();
                            
                            System.out.println("Ingrese una contraseña:");
                            contrasena = scan.nextLine();

                            datosAuditor = new File("datosAuditor.txt");

                            try {
                                if (!datosAuditor.exists()) {
                                    datosAuditor.createNewFile();
                                }
                                escribir = new FileWriter(datosAuditor, true);
                                linea = new PrintWriter(escribir);
                                linea.print(nombre + "|");
                                linea.print(apellido + "|");
                                linea.print(dpi + "|");
                                linea.print(email + "|");
                                linea.print(contrasena + "|");
                                escribir.close();
                                linea.close();
                            } catch (IOException ex) {
                                Logger.getLogger(SistemaVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println("Usuario Creado Exitosamente");
                            break;

                        case 4:
                            System.out.println("Regresar al menu principal");
                            salir = true;
                            break;

                        default:
                            System.out.println("Esa opcion no existe");
                            break;
                    }break;
                    
                    case 2:
                        i=2;

                        System.out.println("Sistema de Votaciones");
                        System.out.println("Modificar Datos de Usuario");
                        
                    try{
                        // Abre el archivo original para lectura;
                    FileReader leerDatos = new FileReader(archivo);
                    BufferedReader leyendoArchivo = new BufferedReader(leerDatos);

                    
                    // Crea un nuevo archivo de copia
                    File nuevoArchivo = new File("modificaciones.txt");
                    escribir = new FileWriter(nuevoArchivo);
                    linea = new PrintWriter(escribir);

                    String lin = "";
                    scan.nextLine();
                    int l = 0;

                    System.out.println("Ingrese email del usuario que se modificara");
                    String emailBuscado = scan.nextLine();

                    System.out.println("Ingrese el nuevo nombre");
                    String nuevoNombre = scan.nextLine();
        
                    System.out.println("Ingrese el nuevo apellido");        
                    String nuevoApellido = scan.nextLine();
        
                    System.out.println("Ingrese el nuevo DPI");        
                    String nuevoDPI = scan.nextLine();
        
                    System.out.println("Ingrese el nuevo email");       
                    String nuevoEmail = scan.nextLine();
        
                    System.out.println("Ingrese el nuevo nombre de usuario");        
                    String nuevoUsuario = scan.nextLine();
        
                    while ((lin = leyendoArchivo.readLine()) != null) {
           
                        String[] datos = lin.split("\\|");
            
                        if (datos.length >= 2 && datos[1].equals(emailBuscado)) {
                
                        // Encuentra el dato a modificar
                        String lineaModificada = nuevoNombre + "|" + nuevoApellido + "|" + nuevoDPI + "|" +
                        nuevoEmail + "|" + nuevoUsuario + "|";
                        
                        linea.println(lineaModificada);
                        System.out.println("Dato Encontrado y Modificado");
                        }
                        
                        else {
                        // Conserva la línea sin modificar
                        linea.println(lin);
                            }
                        }

                        Files.move(modificacionesnuevo.toPath(), modificacionesnuevo.toPath(), REPLACE_EXISTING);

                        }                   
                    catch (IOException ex) {
                    System.out.println("Error al modificar el usuario: " + ex.getMessage());
                        }
                    i=1;
                    break;
                        
                    case 3:
                        i=3;
                        System.out.println("Opcion aun no disponible");
                        break;
                        
                case 4:
                    i=4;
                    System.out.println("Sistema de Votaciones");
                    System.out.println("Restablecer Contraseña");
    
                    System.out.println("Ingrese su Email");    
                    String email = scan.nextLine();
    
    
                    try {       
                        // Abre el archivo original para lectura        
                        FileReader leerDatos = new FileReader(archivo);        
                        BufferedReader leyendoArchivo = new BufferedReader(leerDatos);
        
                        // Crea un nuevo archivo de copia        
                        File nuevoArchivo = new File("nueva_contrasena.txt");        
                        escribir = new FileWriter(nuevoArchivo);        
                        linea = new PrintWriter(escribir);
                
                        String lin = "";
        
                        boolean usuarioEncontrado = false;
               
                        System.out.println("Ingrese la nueva contraseña");        
                        String nuevaContrasena = scan.next();
                
                        while ((lin = leyendoArchivo.readLine()) != null) {
            
                            String[] datos = lin.split("\\|");
                        
                            if (datos.length >= 4 && datos[3].equals(email)) {
                            // Encuentra al usuario con el correo electrónico proporcionado y cambia su contraseña
                
                            linea.println(datos[0] + "|" + datos[1] + "|" + datos[2] + "|" + email + "|" + nuevaContrasena + "|");
                            System.out.println("Contraseña restablecida con éxito.");
                            usuarioEncontrado = true;
            
                            } else {
                            // Conserva la línea sin modificar
                            linea.println(lin);
                                }
                            }
        
                            if (!usuarioEncontrado) {
                            System.out.println("Usuario no encontrado con ese correo electrónico.");
                            }
        
                            // Reemplaza el archivo original con el archivo de copia
                            Files.move(reinicionuevo.toPath(), reinicionuevo.toPath(), REPLACE_EXISTING);
                            } catch (IOException ex) {
                            System.out.println("Error al restablecer la contraseña: " + ex.getMessage());
                            }
                            break;

                        case 5:
                            i=5;
                            System.out.println("Saliendo del sistema");
                            break;

                            default:
                            System.out.println("Esa opción no existe");
                            break;
            }
        }
    }
                       
                        // Este método permite a un registrador de votantes autenticarse y registrar votantes.
                        public void inicioSecion() {
                        Scanner scan = new Scanner(System.in);

                        System.out.println("Sistema de Votaciones");
                        System.out.println("Iniciar sesión como Registrador de Votantes");

                        // Solicitar el DPI y contraseña del registrador
                        System.out.println("Ingrese DPI del Registrador de Votantes:");
                        String dpi = scan.nextLine();

                        System.out.println("Ingrese la Contraseña del Registrador de Votantes:");
                        String contrasena = scan.nextLine();

                        if (autenticarRegistrador(dpi, contrasena)) {
                        System.out.println("Autenticación exitosa como Registrador de Votantes.");
            
                        
                        inicioSecion();
                        } else {
                            System.out.println("Error: Autenticación fallida. No eres un Registrador de Votantes válido.");
                            }
                        }

                            // Este método verifica si un registrador de votantes es válido.
                        private boolean autenticarRegistrador(String dpiRegistrador, String contrasenaRegistrador) {
                        try {
                        File archivoRegistradorVotantes = new File("RegistradorVotantes.txt");
                        Scanner scan = new Scanner(archivoRegistradorVotantes);

                        // Recorre el archivo en busca de coincidencias de autenticación
                        while (scan.hasNextLine()) {
                        String linea = scan.nextLine();
                        String[] datosRegistrador = linea.split("\\|");

                        // Verifica si los datos coinciden con un registrador de votantes
                        if (datosRegistrador.length >= 2 && datosRegistrador[0].equals(dpiRegistrador) && datosRegistrador[1].equals(contrasenaRegistrador)) {
                        return true; // Autenticación exitosa
                                }   
                            }
                        } catch (IOException ex) {
                        System.out.println("Error al autenticar al registrador: " + ex.getMessage());
                        }
                        
                            return false; // Autenticación fallida
                        }
                                
                        public void registroVotantes(FileWriter escribir, PrintWriter linea) {
                                
                        Scanner scan = new Scanner(System.in);
    
                        System.out.println("Sistema de Votaciones");
                        
                        System.out.println("1. Agregar Votante");
                        System.out.println("2. Modificar Votante");
                        System.out.println("3. Reiniciar contraseña Votante");
                        System.out.println ("4. Registrar fallecimiento de votante");
                        int opcionVotante = scan.nextInt();
    
                        switch (opcionVotante) {
                            case 1:
                                                    
                        System.out.println("Ingrese nombres: ");
                        String nombreVotante = scan.nextLine();

                        System.out.println("Ingrese apellidos: ");
                        String apellidoVotante = scan.nextLine();

                        System.out.println("Ingrese su numero de DPI: ");
                        String dpiVotante = scan.nextLine();

                        System.out.println("Ingrese sexo:");
                        String sexo = scan.nextLine();

                        System.out.println("Ingrese su fecha de nacimiento: ");
                        String fechaNacimiento = scan.nextLine();

                        System.out.println("Ingrese su direccion: ");
                        String direccion = scan.nextLine();

                        System.out.println("Ingrese departamento donde vive: ");
                        String departamento = scan.nextLine();

                        System.out.println("Ingrese municipio donde vive:");
                        String municipio = scan.nextLine();

                        System.out.println("Ingrese país donde vive: ");
                        String pais = scan.nextLine();

                        File datosVotantes = new File("datosVotantes.txt");

                        try{       
                            FileWriter escribirV = new FileWriter("datosVotantes.txt", true);
                            PrintWriter lineaV = new PrintWriter(escribir);
                            
                            linea.print(nombreVotante + "|");
                            linea.print(apellidoVotante + "|");
                            linea.print(dpiVotante + "|");
                            linea.print(sexo + "|");
                            linea.print(fechaNacimiento + "|");
                            linea.print(direccion + "|");
                            linea.print(departamento + "|");
                            linea.print(municipio + "|");
                            linea.print(pais + "|");
                            
                            escribirV.close();
                            lineaV.close();
                                    
                        }catch (IOException ex) {
                            Logger.getLogger(SistemaVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println("Votante registrado exitosamente");
                            
                        break;
                            
                        case 2:

                        System.out.println("Sistema de Votaciones");
                        System.out.println("Modificar datos votante");
                        
                            try{
                            // Abre el archivo original para lectura
                            File archivo = new File("datosVotantes.txt");
                            FileReader leerDatos = new FileReader(archivo);
                            BufferedReader leyendoArchivo = new BufferedReader(leerDatos);

                            // Crea un nuevo archivo de copia
                            File nuevoArchivo = new File("modificacionesVotante.txt");
                            FileWriter escribirMod = new FileWriter(nuevoArchivo);
                            PrintWriter lineaMod = new PrintWriter(escribirMod);

                    String lin = "";
                    scan.nextLine();
                    
                    
                        System.out.println("Ingrese el DPI del votante que se modificara: ");
                        String dpiBuscado = scan.nextLine();
                        
                        System.out.println("Ingrese nombres: ");
                        String nombresNuevo = scan.nextLine();

                        System.out.println("Ingrese apellidos: ");
                        String apellidosNuevo = scan.nextLine();

                        System.out.println("Ingrese su numero de DPI: ");
                        String dpiNuevo = scan.nextLine();

                        System.out.println("Ingrese sexo:");
                        String sexoNuevo = scan.nextLine();

                        System.out.println("Ingrese su fecha de nacimiento: ");
                        String fechaNacimientoNueva = scan.nextLine();

                        System.out.println("Ingrese su direccion: ");
                        String direccionNueva = scan.nextLine();

                        System.out.println("Ingrese departamento donde vive: ");
                        String departamentoNuevo = scan.nextLine();

                        System.out.println("Ingrese municipio donde vive:");
                        String municipioNuevo = scan.nextLine();

                        System.out.println("Ingrese país donde vive: ");
                        String paisNuevo = scan.nextLine();
                    
                    
                    while ((lin = leyendoArchivo.readLine()) != null) {
           
                        String[] datos = lin.split("\\|");
            
                        if (datos.length >= 2 && datos[1].equals(dpiBuscado)) {
                
                        // Encuentra el dato a modificar
                        String lineaModificada = nombresNuevo + "|" + apellidosNuevo + "|" + dpiNuevo + "|" +
                        sexoNuevo + "|" + fechaNacimientoNueva + "|"+ direccionNueva + "|" + departamentoNuevo + "|" 
                        + municipioNuevo+ "|"+ paisNuevo + "|";
                        
                        linea.println(lineaModificada);
                        System.out.println("Dato Encontrado y Modificado");
                        }
                        
                        else {
                        // Conserva la línea sin modificar
                        linea.println(lin);
                            }
                        }
                        escribirMod.close();
                        lineaMod.close();
                        Files.move(modificacionesnuevo.toPath(), modificacionesnuevo.toPath(), REPLACE_EXISTING);

                        }                   
                    catch (IOException ex) {
                    System.out.println("Error al modificar el usuario: " + ex.getMessage());
                        }
                    
                    break;
                        
                        
                case 3:
                   
                    System.out.println("Sistema de Votaciones");
                    System.out.println("Restablecer Contraseña");
    
                    System.out.println("Ingrese DPI votante");    
                    String dpi = scan.nextLine();
    
    
                    try {       
                        // Abre el archivo original para lectura
                        File archivo = new File("datosVotantes.txt");
                        FileReader leerDatos = new FileReader(archivo);
                        BufferedReader leyendoArchivo = new BufferedReader(leerDatos);

                        // Crea un nuevo archivo de copia
                        File nuevoArchivo = new File("contrasenaVotante.txt");
                        FileWriter escribirContrasena = new FileWriter(nuevoArchivo);
                        PrintWriter lineaContrasena = new PrintWriter(escribirContrasena);
                
                        String lin = "";
        
                        boolean usuarioEncontrado = false;
               
                        System.out.println("Ingrese la nueva contraseña");        
                        String nuevaContrasena = scan.next();
                
                        while ((lin = leyendoArchivo.readLine()) != null) {
            
                            String[] datos = lin.split("\\|");
                        
                            if (datos.length >= 4 && datos[3].equals(dpi)) {
                            // Encuentra al usuario con el correo electrónico proporcionado y cambia su contraseña
                
                            linea.println(datos[0] + "|" + datos[1] + "|" + datos[2] + "|" + dpi + "|" + nuevaContrasena + "|");
                            System.out.println("Contraseña restablecida con éxito.");
                            usuarioEncontrado = true;
            
                            } else {
                            // Conserva la línea sin modificar
                            linea.println(lin);
                                }
                            }
                            
                            escribirContrasena.close();
                            lineaContrasena.close();
        
                            if (!usuarioEncontrado) {
                            System.out.println("Usuario no encontrado con ese correo electrónico.");
                            }
        
                            // Reemplaza el archivo original con el archivo de copia
                            Files.move(archivo.toPath(), nuevoArchivo.toPath(), REPLACE_EXISTING);
                            } catch (IOException ex) {
                            System.out.println("Error al restablecer la contraseña: " + ex.getMessage());
                            }
                            break;
                            
                            case 4:
                            
                            System.out.println ("Opcion aun no disponible");
                    
                

                        default:
                           
                            System.out.println("Saliendo del sistema");
                            break;
                        }
                    }       
                
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
            //Inicio de sistema
        System.out.println("Bienvenido al sistema de Votaciones");
        System.out.println("Ingrese una contrasena para el sistema");
        
        SistemaVotaciones sistema = new SistemaVotaciones();
        
        File datosAdmin = new File("datosAdmin.txt");
        File datosRegVotantes = new File("datosRegVotantes.txt");
        File datosAuditor = new File("datosAuditor.txt");
        File datosVotantes = new File ("datosVotantes.txt");
        
        String archivo = "archivoUsuarios.txt";
        
        
        FileWriter escribir = null;
        PrintWriter linea = null;


        File archivoContrasena = new File("contrasenaInicial.txt");

        if (!archivoContrasena.exists()) {
            String contrasenaInicial = scan.nextLine();
            try {
                archivoContrasena.createNewFile();
                escribir = new FileWriter(archivoContrasena, true);
                linea = new PrintWriter(escribir);
                linea.println(contrasenaInicial);
                escribir.close();
                linea.close();

            } catch (IOException ex) {
                Logger.getLogger(SistemaVotaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //Fin del inicio de sistema
        
            try {
            // Llama al método menuPrincipal para iniciar el menú
            sistema.menuPrincipal(datosAdmin, escribir, linea, datosRegVotantes, datosAuditor, archivo);

            // Llama al método registroVotantes
            sistema.registroVotantes(escribir, linea);
        } 
            catch (IOException ex) {
            System.out.println("Error en el programa: " + ex.getMessage());
            
                   
                        System.out.println("Programa Finalizado");
                        }
                        
                    }
    }