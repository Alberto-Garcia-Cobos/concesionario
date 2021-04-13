
package progr09_Ejerci1;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


 /**
  * Clase principal del programa del ejercicio 1 del tema 9 de programación.
  * Al inicial el programa nos pedira un nombre, el cual será el nombre del archivo
  * que se ira guardando todos los datos introducidos.
  * Se trata de un concesionario en el cual los vehículos introducidos se guardarán en una
  * lista ordenada por su matricula.
  * Se deben de introducir los datos especificos sobre el vehículo y su dueño.
  * Presentara por pantalla 6 opciones y dependiendo de que opcion utilize el usuario
  * le pedira o le mostrara ciertos datos.
  * En el caso 1: Le pedira todos los datos del vehículo
  * En el caso 2: Listara todos los vehículos del concesionario.
  * En el caso 3: pedira una matricula y buscara el vehículo existente de no encontrarse
  * en el concesionario dará error.
  * En el caso 4: Pedira una matricula y los nuevos km y los actualizará, de no encontrarse
  * el vehículo en el concesionario saltará error.
  * En el caso 5: se pedira una matricula y si esta existe se borrara.
  * En el caso6: Terminara la aplicación.
  * @autor Alberto García Cobos
  * @version 12.1 13/03/2021
  * @param args no contiene argumentos
  * @throws Exception 
  */  
public class Main_Concesionario{
    public static void main(String[] args) throws Exception {
        //implementamos variables
        int opcion;
        Scanner teclado=new Scanner(System.in);
        Concesionario concesionario1=new Concesionario();//Constructor
        boolean error=false;
        boolean flag=false;       
        float precio=0f;
        String propietario;
        int kmNuevos;
        int numKm=0;
        boolean flag2=false;
        Pattern d;
        Matcher m;
        String matricula;
        String dni;
        
        //Pedimos el nombre del fichero
        System.out.println("Introduce el nombre del fichero: ");           
            
         
            
            //Constructor de tipo File para guardar la dirección donde introducir los ficheros
            File direccion=new File(".."+ File.separator+ teclado.next());
           teclado.nextLine();
           
            
        if(direccion.exists()==true){
           try{
                
                ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream(direccion));
			
                Concesionario personal_recuperado=(Concesionario) recuperando_fichero.readObject();
			
                recuperando_fichero.close();
			
		for(int i=0;i<personal_recuperado.getVehiculos().size();i++) {
				
			System.out.println(personal_recuperado.getVehiculos().get(i));
			}
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        }else if (direccion.exists()==false){
             //Creamos el fichero
            try{
            direccion.createNewFile();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        
        }
        
    //Comienzo del programa, muestra las opciones a ejecutar.
        do{
           System.out.println("Elige una opción: \n 1 Nuevo Vehiculo: \n 2 Lista de vehículos: "
           + "\n 3 Busqueda de vehículo: \n 4 Modificar km: \n 5 Borrar vehiculo: \n 6 Salir: ");
           opcion=Integer.parseInt(teclado.nextLine());

       switch(opcion){
            //Comienzo del bucle para introducir los datos del caso 1
            case 1:
                    
                    //Introducimos la marca del vehiculo
                    System.out.println("Introduce Marca del vehículo");
                    String marca=(teclado.next());
                    teclado.nextLine();
                    //Introducimos número de matricula        
                    do{
                    System.out.println("Introduce Matricula (0000AAA)");
                    matricula=(teclado.next());
                    teclado.nextLine();
                     d=Pattern.compile("[0-9]{4}[A-Z]{3}");//Introducimos las codiciones de la matricula
                     m=d.matcher(matricula);
                    if (m.matches()){
                        //Comprobamos que no exista la matricula
                       if(concesionario1.buscaVehiculo(matricula)!=null){
                           System.out.println("El vehiculo ya existe");
                       }else flag=true;
                                            
                    }//Si la matricula no es valida comienza el bucle de nuevo
                    else System.out.println("La Matricula no es valida");

                    }while(m.matches()==false);
                    
                    //Introducimos los km del vehiculo.
                do{
                    try{
                    System.out.println("Introduce el número de km");
                    numKm=(teclado.nextInt());
                    teclado.nextLine();
                    error=false;
                    }catch(NumberFormatException e){//Ponemos la excepcion de no introducir un entero
                     
                    System.out.println(e.getMessage());}
                }while(error==true);
                
                //Introducimos la fecha de matriculación
                LocalDate fechaMatriculacion;
                do{
                  System.out.println("Introduce el año de matriculacion");
                  int anio=teclado.nextInt();
                  teclado.nextLine();
                  
                  System.out.println("Introduce el mes de matriculación");
                  int mes=teclado.nextInt();
                  teclado.nextLine();
                  
                  System.out.println("Introduce el dia de matriculación");
                  int dia=teclado.nextInt();
                  teclado.nextLine();
                  
                  fechaMatriculacion=LocalDate.of(anio, mes, dia);
                  if (fechaMatriculacion.isAfter(LocalDate.now())){
                      System.out.println("La fecha introducida es erronea");
                  }
                }while(fechaMatriculacion.isAfter(LocalDate.now()));
                
                                  
                    //Introducimos descripción del vehículo.
                    System.out.println("Introduce Descripción del vehículo");
                    String descripcion=(teclado.next());
                    teclado.nextLine();
                    
                    //Introducimos precio del vehículo.
                do{
                    try{               
                    System.out.println("Introduce el precio");
                    precio=(teclado.nextFloat());
                    teclado.nextLine();
                    error=false;
                    }catch(NumberFormatException e){//Implementamos excepción de no introducir un entero
                    System.out.println(e.getMessage());}
                }while(error==true);
                
                    //Introducimos nombre del propietario.
                do{
                    System.out.println("Introduce el nombre");
                    String nombre=(teclado.next());
                    teclado.nextLine();
                    System.out.println("Introduce el primer apellido");
                    String apellido1 = teclado.next();
                    teclado.nextLine();
                     System.out.println("Introduce el segundo apellido");
                     String apellido2 = teclado.next();
                    teclado.nextLine();
                    /*Creamos condiciones del nombre del propietario, donde 
                    debe cumplir que tiene 2 espacios en blanco para separar el
                    nombre de los 2 apellidos y que no debe de superar en 40 
                    caracteres el total
                    */
                    propietario=nombre.concat(apellido1).concat(apellido2);
                    if(propietario.length()>40){
                        System.out.println("Has introducido demasiados caracteres");
                    }else flag2=true;
                }while(flag2==false);
                
                   //Pedimos el DNI
                do{
                    System.out.println("Escriba su DNI:");
                    dni = teclado.nextLine();
                    System.out.println("dni:" + dni);
        
                    //Comprobamos si el dni suministrado es correcto
                  
                     d=Pattern.compile("[0-9]{8}[A-Za-z]");//Creamos condicion del DNI
                     m=d.matcher(dni);
                    if (m.matches()) System.out.println("");

                    else System.out.println("DNI, no es valido");
                    }while(m.matches()==false);
                    
                    concesionario1.insertarVehiculo(marca, matricula, numKm, fechaMatriculacion, descripcion, 
                            precio, propietario, dni);
                    break;

                    
                    //Caso 2 listaría todos los vehiculos del concesionario
            case 2:
                
                    concesionario1.listaVehiculos();
                    
                break;
                
                //Caso 3 buscaría la matricula en el concesionario
            case 3:
                
                    System.out.println("Introduce Matricula");
                    matricula=(teclado.next());
                    teclado.nextLine();
                    System.out.println(concesionario1.buscaVehiculo(matricula));
                 break;   
                //Caso 4 modificaría los km del vehículo de la matricula introducida
            case 4:       
                
               do{
                   System.out.println("Introduce Matricula");
                   matricula=(teclado.next());
                   teclado.nextLine();
               do{
                   System.out.println("Introduce los kilometros");
                   kmNuevos=(teclado.nextInt());
                   teclado.nextLine();
                   //Creamos condición de que los km introducidos son más de los que tenía.
                
                   if(kmNuevos<numKm){
                       System.out.println("Los km introducidos no son validos");
                   }
                }while(kmNuevos<numKm);
                   if(concesionario1.actualizaKm(matricula, kmNuevos) ==false){
                       System.out.println("La matricula no existe");
                   }
               }while (concesionario1.actualizaKm(matricula, kmNuevos)==false);
               
               concesionario1.actualizaKm(matricula, kmNuevos);
               break;
               
               //Caso 5 borra el vehículo si la matricula introducida existe.
            case 5:
                System.out.println("Introduce Matricula");
                    matricula=(teclado.next());
                concesionario1.borraVehiculo(matricula);
                System.out.println("Vehículo borrado");
              
               //Caso 6 fin del programa
            case 6:
                
                try{
                    ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream(direccion));
			
                    escribiendo_fichero.writeObject(concesionario1);
			
                    escribiendo_fichero.close();
                    
                }catch (FileNotFoundException ex){
                    
                    System.out.println(ex.getMessage());
                    
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
                    
                    System.out.println("Salir del programa");
                    break;
        }
            
       
       }while(opcion!=6);
                 
    }   
}
        