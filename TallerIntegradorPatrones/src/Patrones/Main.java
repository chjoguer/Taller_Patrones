/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import Adapter.CuentaAdapter;
import ChainOfResponsibility.Manejador;
import ChainOfResponsibility.ManejadorDinero;
import Singleton.AtmUK;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("****MENU****");
        System.out.println("Escoga una opcion");
        System.out.println("1.Realizar transacción");
        System.out.println("3. Salir");
    }

    public static void main(String[] args) {
        // Crear un único cajero Automático de dólares con 100 billetes de 20, 100 de 10, 
        // 10 monedas de 0.50, 10 de 0.25 y 1000 de 0.05
        AtmUK cajeroSingle = AtmUK.getInstance();
        //ajeroSingle.setDinero(10000);

        Manejador m1 = new ManejadorDinero(100, 20);
        Manejador m2 = new ManejadorDinero(100, 10);
        Manejador m3 = new ManejadorDinero(10, 0.50);
        Manejador m4 = new ManejadorDinero(10, 0.25);
        Manejador m5 = new ManejadorDinero(1000, 0.05);

        //cajeroSingle.addManejador(m1);
        // cajeroSingle.addManejador(m2);
        //cajeroSingle.addManejador(m3);
        //cajeroSingle.addManejador(m4);
        //cajeroSingle.addManejador(m5);
        m1.setNext(m2);
        m2.setNext(m3);
        m3.setNext(m4);
        m4.setNext(m5);
        cajeroSingle.addManejador(m1);

       // System.out.println("Manejadores:" + cajeroSingle.toString());
        //System.out.println("Total: " + cajeroSingle.getTotal());
        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        /*Primer Parametro id de la cuenta, Segundo Parametro cantidad de dinero en su cuenta*/
        ArrayList<CuentaAdapter> cuentas = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            CuentaAdapter c1 = new CuentaAdapter(i, i * 100);
            cuentas.add(c1);

        }

        CuentaAdapter c2 = new CuentaAdapter(2, 150.75);
        CuentaAdapter c3 = new CuentaAdapter(3, 115.10);
        CuentaAdapter c4 = new CuentaAdapter(4, 900.80);
        CuentaAdapter c5 = new CuentaAdapter(5, 775.25);
        CuentaAdapter c6 = new CuentaAdapter(6, 1000.00);
        CuentaAdapter c7 = new CuentaAdapter(7, 650.05);
        CuentaAdapter c8 = new CuentaAdapter(11, 888.40);
        CuentaAdapter c9 = new CuentaAdapter(12, 700.00);
        CuentaAdapter c10 = new CuentaAdapter(110, 699.70);
        // cuentas.add(c1);
        cuentas.add(c2);
        cuentas.add(c3);
        cuentas.add(c4);
        cuentas.add(c5);
        cuentas.add(c6);
        cuentas.add(c7);
        cuentas.add(c8);
        cuentas.add(c9);
        cuentas.add(c10);

        // Menú principal para seleccionar una de las 10 cuentas solo con el i
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        do{
            menu();
            opt = sc.nextInt();
            switch (opt) {

                case 1:
                    System.out.println("Para realizar una transacción ingrese el id de la cuenta que desea elegir");
                    int id = sc.nextInt();
                    CuentaAdapter c=null;
                    for (CuentaAdapter cuenta : cuentas) {
                        if (cuenta.getId() == id) {
                            c = cuenta;
                            //cajeroSingle.transaction(cuenta);
                            break;
                        }
                    }
                    if(c!=null)
                       cajeroSingle.transaction(c);
                    else
                        System.out.println("No existe cuenta con ese id");
                    
                    break;
                case 2:
                    System.out.close();
                    break;
            }
        }while (opt!=3); 
           // Object nextElement = en.nextElement();
            
        
        // Mostrar el menú para realizar transacciones en el cajero automático
    }
}
