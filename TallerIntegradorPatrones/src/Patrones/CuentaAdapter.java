/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import java.util.Locale;

/**
 *
 * @author Dario Triviño
 */
public class CuentaAdapter implements Cuenta {
    protected Account cuenta;
    protected Locale moneda;
    
    public CuentaAdapter(int id,double monto){
        cuenta=new Account(id,monto);
    }

    @Override
    public double balance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retira(int monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean depositar(int n, int denominacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
