/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author Dario Triviño
 */
public class CuentaAdapter implements Cuenta {

    protected Account cuenta;
    protected Currency moneda;

    public CuentaAdapter(int id, double monto) {
        cuenta = new Account(id, monto);
        this.moneda = Currency.getInstance(Locale.US);
    }

    public Account getCuenta() {
        return cuenta;
    }

    public int getId() {
        return cuenta.getId();

    }

    public double getAmount() {
        return cuenta.getAmount();
    }

    
    
    
    
    @Override
    public double balance() {
        return cuenta.getAmount();
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0) {
            return false;
        }
        cuenta.withdraw(monto);
        return true;
    }

    @Override
    public boolean depositar(double n, double denominacion) {
        if (n <= 0 || denominacion <= 0) {
            return false;
        }
        double totalDeposito = n * denominacion;
        cuenta.deposit(totalDeposito);
        return true;
    }

}
