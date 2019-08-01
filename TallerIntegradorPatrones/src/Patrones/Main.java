/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import Adapter.CuentaAdapter;
import ChainOfResponsibility.ManejadorDinero;
import Singleton.AtmUK;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("****MENU****");
        System.out.println("1. Seleccione una cuenta");
        System.out.println("2. Realice su transacciones");
        System.out.println("3. Salir");
        System.out.println("Escoga una opcion");
    }

    public static void main(String[] args) {
        // Crear un único cajero Automático de dólares con 100 billetes de 20, 100 de 10, 
        // 10 monedas de 0.50, 10 de 0.25 y 1000 de 0.05
        AtmUK cajeroSingle = AtmUK.getInstance();
        cajeroSingle.setDinero(10000);
        ManejadorDinero m1 = new ManejadorDinero(100, 20);
        ManejadorDinero m2 = new ManejadorDinero(100, 10);
        ManejadorDinero m3 = new ManejadorDinero(10, 0.50);
        ManejadorDinero m4 = new ManejadorDinero(10, 0.25);
        ManejadorDinero m5 = new ManejadorDinero(1000, 0.05);
        m1.setNext(m2);
        m2.setNext(m3);
        m3.setNext(m4);
        m4.setNext(m5);
        System.out.println("Manejadores:" + m1);
        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        /*Primer Parametro id de la cuenta, Segundo Parametro cantidad de dinero en su cuenta*/
        CuentaAdapter c1 = new CuentaAdapter(1, 100.00);
        CuentaAdapter c2 = new CuentaAdapter(2, 150.75);
        CuentaAdapter c3 = new CuentaAdapter(3, 115.10);
        CuentaAdapter c4 = new CuentaAdapter(4, 900.80);
        CuentaAdapter c5 = new CuentaAdapter(5, 775.25);
        CuentaAdapter c6 = new CuentaAdapter(6, 1000.00);
        CuentaAdapter c7 = new CuentaAdapter(7, 650.05);
        CuentaAdapter c8 = new CuentaAdapter(11, 888.40);
        CuentaAdapter c9 = new CuentaAdapter(12, 700.00);
        CuentaAdapter c10 = new CuentaAdapter(110, 699.70);
        ArrayList<CuentaAdapter> cuentas = new ArrayList<>();
        cuentas.add(c1);
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
        int opt =0;
        while (opt !=3) {
            menu();
            opt = sc.nextInt();
            switch(opt){
                case 1:
                    System.out.println("Ingrese el id de la cuenta que desea elegir");
                    int id = sc.nextInt();
                    for (CuentaAdapter cuenta : cuentas) {
                        if(cuenta.getId()==id){
                            AtmUK.transaction(cuenta);
                        }
                        
                    }
                    
                    
                break;
                    
            
            
            }
            
        }
        // Mostrar el menú para realizar transacciones en el cajero automático
    }

}
