package ut6.pkg2_interfaces;
/**
 *
 * @author Hari
 */
//Creamos un archivo interface. Los jefes implementarán los métodos de trabajadores pero también de su propia interfaz
public interface Jefes extends Trabajadores{
    
    //Aunque no pongamos public abstract, java lo da por hecho
    String tomarDecisiones(String decision);
}
