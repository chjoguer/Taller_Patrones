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
public class ManejadorDinero implements Manejador{
    private Manejador next;
    protected int cantidad;
    protected double denominacion;

    @Override
    public boolean retirar(int monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean depositar(int monto, int denominacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNext(Manejador m) {
        this.next = m;
    }
}