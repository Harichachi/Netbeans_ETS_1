package ut6.pkg2_interfaces;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
/**
 *
 * @author Hari
 */
//Creamos una clase que nos de la hora
class DameLaHora implements ActionListener{
    
    public void actionPerformed(ActionEvent o){
        
        //Instanciamos un objeto de la clase Date (da la hora actual)
        Date ahora = new Date();
        System.out.println("Esta es la hora cada 6 segundos: "+ahora);
    }
}
public class Temporizador {

    public static void main(String[] args) {
        
        //Instanciamos un objeto de tipo DameLaHora
        DameLaHora oyente = new DameLaHora();
        //Instanciamos un objeto de tipo timer. Cada 6 segundos se ejecutará una acción
        Timer miTemporizador = new Timer(6000,oyente);
        //Ahora hacemos que comience 
        miTemporizador.start();
        //Para que continue la ejecución hasta que lo paremos... JOptionPane pertenece a java.swing
        JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
        
        System.exit(0);
        System.out.println("Cambio nuevo para el commit");
        System.out.println("Cambio nuevo para el segundo commit");
    }
    
}
