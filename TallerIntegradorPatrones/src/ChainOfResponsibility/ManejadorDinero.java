/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

/**
 *
 * @author Administrador
 */
public class ManejadorDinero implements Manejador {

    private Manejador next;
    protected int cantidad;
    protected double denominacion;
    public int dinero;

   
/*
    public boolean retirar(int monto) {
        if (dinero == 0) {
            return false;
        }
        this.dinero -= dinero;
        return true;
    }

    public boolean depositar(int monto, int denominacion) {
        if(denominacion==0||dinero==0)
            return false;
        this.dinero += dinero;
        return true;

    }
*/
    @Override
    public boolean retirar(double monto) {
        if (dinero == 0 || monto <= 0) {
            return false;
        }
        
    }

    @Override
    public boolean depositar(double monto, int denominacion) {
        if (monto <= 0 || denominacion <= 0)
            return false;
        else
            return true;
    }

    @Override
    public void setNext(Manejador m) {
        this.next = m;
    }
}

