package ut6.pkg2_interfaces;
/**
 *
 * @author Hari
 */
public interface Trabajadores {
    
    double estableceBonus(double gratificacion);
    
    //Vamos a decir que ese bonus sea de un mínimo de 1500. Por defecto son public static final
    double bonusBase = 1500;
}
