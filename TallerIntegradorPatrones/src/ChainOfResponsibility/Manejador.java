/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

public interface Manejador
{
    public boolean retirar(int monto);
    public boolean depositar(int monto, int denominacion);
    public void setNext(Manejador m);
    
}