/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

/**
 *
 * @author Dario Triviño
 */
public interface Cuenta {
    public double balance();
    
    public boolean retira(int monto);
    
    public boolean depositar(int n,int denominacion);
    
}
