/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import Adapter.CuentaAdapter;
import ChainOfResponsibility.ManejadorDinero;
import Singleton.AtmUK;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear un único cajero Automático de dólares con 100 billetes de 20, 100 de 10, 
        // 10 monedas de 0.50, 10 de 0.25 y 1000 de 0.05
        AtmUK cajeroSingle = AtmUK.getInstance();
        cajeroSingle.setDinero(10000);
        cajeroSingle.addManejador(new ManejadorDinero(100, 20));
        cajeroSingle.addManejador(new ManejadorDinero(100, 10));
        cajeroSingle.addManejador(new ManejadorDinero(10, 0.50));
        cajeroSingle.addManejador(new ManejadorDinero(10, 0.25));
        cajeroSingle.addManejador(new ManejadorDinero(1000, 0.05));

        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        CuentaAdapter c1 = new CuentaAdapter(001, 100.00);
        CuentaAdapter c2 = new CuentaAdapter(001, 150.75);
        CuentaAdapter c3 = new CuentaAdapter(001, 115.10);
        CuentaAdapter c4 = new CuentaAdapter(001, 900.80);
        CuentaAdapter c5 = new CuentaAdapter(001, 775.25);
        CuentaAdapter c6 = new CuentaAdapter(001, 1000.00);
        CuentaAdapter c7 = new CuentaAdapter(001, 650.05);
        CuentaAdapter c8 = new CuentaAdapter(001, 888.40);
        CuentaAdapter c9 = new CuentaAdapter(001, 700.00);
        CuentaAdapter c10 = new CuentaAdapter(001, 699.70);
        // Menú principal para seleccionar una de las 10 cuentas solo con el id
        AtmUK.transaction(c1.getCuenta());
        // Mostrar el menú para realizar transacciones en el cajero automático
    }

}
