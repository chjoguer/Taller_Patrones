/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

public interface Manejador {

    public boolean retirar(double monto);
    public boolean depositar(double monto, double denominacion);
    public void setNext(Manejador m);
    public double getDenominacion();
    public int getCantidad();
    public Manejador getNext();


}
