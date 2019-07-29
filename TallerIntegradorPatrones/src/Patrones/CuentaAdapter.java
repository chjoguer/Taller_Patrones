/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author Dario Triviño
 */
public class CuentaAdapter implements Cuenta {
    protected Account cuenta;
    protected Currency moneda;
    
    public CuentaAdapter(int id,double monto){
        cuenta=new Account(id,monto);
        this.moneda=Currency.getInstance(Locale.US);
    }

    @Override
    public double balance() {
        return cuenta.getAmount();
    }

    @Override
    public boolean retira(double monto) {
        cuenta.withdraw(monto);
        return true;
    }

    @Override
    public boolean depositar(double n, double denominacion) {
        double totalDeposito=n*denominacion;
        cuenta.deposit(totalDeposito);
        return true;
    }
    
}
