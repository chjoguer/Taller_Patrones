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

    @Override
    public boolean retirar(int monto) {
        if (dinero == 0) {
            return false;
        }
        this.dinero -= dinero;
        return true;
    }

    @Override
    public boolean depositar(int monto, int denominacion) {
        if(denominacion==0||dinero==0)
            return false;
        this.dinero += dinero;
        return true;
    }

    @Override
    public void setNext(Manejador m) {
        this.next = m;
    }
}
