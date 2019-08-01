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
    public double dinero; 
    /*Constructor para luego instanciarlos en un arreglo de manejadores*/
    public ManejadorDinero(int cantidad,double dominacion){
        this.cantidad=cantidad;
        this.denominacion=dominacion;
        this.next = null;
    }
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
    //Se asume que se colocan los manejadores de mayor denominacion a menor denominacion
    @Override
    public boolean retirar(double monto) {
        if (monto == 0) {
            return true;
        } else if (monto < 0) {
            return false;
        } else if (this.dinero > 0) {
            double num_billetes = monto / this.denominacion;
            if (num_billetes > this.cantidad) {
                if (this.next.retirar(monto - this.dinero)) {
                    this.dinero = 0;
                    this.cantidad = 0;
                    return true;
                } else {
                    return false;
                }
            } else {
                monto -= this.denominacion * num_billetes;
            }
            if (monto == 0 || this.next.retirar(monto)) {
                this.dinero -= this.denominacion * num_billetes;
                this.cantidad -= num_billetes;
                return true;
            } else {
                return false;
            }
        } else if (this.next == null) {
            return false;
        } else {
            return this.next.retirar(monto);
        }
    }

    @Override
    public boolean depositar(double monto, double denominacion) {
        if (monto <= 0 || denominacion <= 0) {
            return false;
        } else if (denominacion == this.denominacion) {
            this.cantidad += monto / denominacion;
            this.dinero += monto;
            return true;
        } else if (this.next == null) {
            return false;
        } else {
            return this.next.depositar(monto, denominacion);
        }
    }


    @Override
    public void setNext(Manejador m) {
        this.next = m; 
 }

    public Manejador getNext() {
        return next;
    }
    

    @Override
    public String toString() {
        return "ManejadorDinero{" + "Cantidad: "+cantidad+"Denominacion: "+denominacion+"->next=" + getNext() + '}';
    }
    
    
    
}