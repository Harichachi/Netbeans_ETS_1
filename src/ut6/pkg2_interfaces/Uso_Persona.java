package ut6.pkg2_interfaces;
/**
 *
 * @author Hari
 */
//Estoy usando el mismo proyecto del ejercicio anterior
abstract class Persona{
    private final String nombre;
    
    public Persona(String nom){
        nombre = nom;
    }
    //Getter
    public String dameNombre(){
        return nombre;
    }
    public abstract String dameDescripcion();
}

//Decimos que empleado implementa Comparable para que pueda implementar el sort. También implementa trabajadores
class Empleado extends Persona implements Comparable,Trabajadores{
    double sueldo;
    
    //Constructor
    public Empleado(String nom,double suel){
        super(nom);
        sueldo = suel;
    }
    public String dameDescripcion(){
        return "Este empleado tiene un sueldo =  "+sueldo;
    }
    
    //Getter
    public double dameSueldo(){
        return sueldo;
    }
    //Incluimos la interfaz CompareTo
    public int compareTo(Object objeto){
        //Hacemos un casteo
        Empleado emp = (Empleado) objeto;
        //Hacemos un if para ordenar el array por sueldo
        if(this.sueldo<emp.sueldo){
            return -1;
        }
        if(this.sueldo>emp.sueldo){
            return 1;
        }
        return 0;
    }
    //Implementamos el método estableceBonus
    public double estableceBonus(double gratificacion){
        return Trabajadores.bonusBase+gratificacion;
    }
}

//Le decimos que esta clase implementa la interfaz jefes que hemos creado
class Jefatura extends Empleado implements Jefes{
    private final double sueldo;
    
    //Constructor
    public Jefatura(String nom, double sue){
        super(nom,sue);
        sueldo = sue;
    }

    public String dameDescripcion(){
        return "Este jefe tiene un sueldo " + sueldo;
    }
    
    //Getter
    public double dameSueldo(){
        return sueldo;
    }
    //Hacemos que implemente el método tomarDecisiones
    public String tomarDecisiones(String decision){
        return "Un miembro de la dirección ha tomado la decisión: "+decision;
    }
    //Hcemos que implemente el método estableceBonus
    public double estableceBonus(double gratificacion){
        double prima = 2000;
        
        return Trabajadores.bonusBase+gratificacion+prima;
    }
}

public class Uso_Persona {

    public static void main(String[] args) {
        
        Empleado[] personas = new Empleado[5];
        
        //Rellenamos el array
        personas[0] = new Jefatura ("Luis",2000);
        personas[1] = new Jefatura ("Lorena",3000);
        personas[2] = new Empleado ("María",500);
        personas[3] = new Empleado ("Jose",850);
        personas[4] = new Empleado ("Carlos",1500);
        
        //Vamos a ordenarlos
        //Arrays.sort(personas);
        
        //Recorremos el array con un bucle for-each para imprimir la información
        System.out.println("-----------------Empleados ordenados por sueldo-----------------");
        for (Persona p : personas) {
            System.out.println(p.dameNombre() + "," + p.dameDescripcion());
        }
                
        //Vamos a aprender a usar el instance of
        System.out.println("-----------------Aprendiendo el uso de instaceof-----------------");
        Jefatura director = new Jefatura ("Mercedes",5000); //Creamos un director 
        Comparable ejemplo = new Empleado ("Manuel",950);
        
        if(director instanceof Empleado){
            System.out.println("Es de tipo empleado");
        }
        
        if(ejemplo instanceof Comparable){
            System.out.println("Implementa la interfaz Comparable");
        }
        
        //Vamos a imprimir una decisión que haya tomado el director
        System.out.println("-----------------Decision del jefe-----------------");
        System.out.println(director.tomarDecisiones("Dar más días de vacaciones a los empleados"));
        
        //Vamos a imprimir los bonus de los trabajadores
        System.out.println("-----------------Bonus-----------------");
        System.out.println("El jefe "+director.dameNombre()+" tiene un bonus de "+director.estableceBonus(500));
        System.out.println(personas[3].dameNombre()+" tiene un bonus de "+personas[3].estableceBonus(100));
    }
    
}