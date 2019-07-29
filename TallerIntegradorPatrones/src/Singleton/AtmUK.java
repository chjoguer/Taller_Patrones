/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;


import Patrones.Account;
import ChainOfResponsibility.Manejador;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AtmUK {
    protected final Locale currency=Locale.UK;
    protected double dinero = 0;
    protected ArrayList <Manejador> manejadores; // Cada manejador puede entregar dinero de una sola denominación
    protected Manejador manejador;
    /*Implementacion del patron sigleton*/
    private static AtmUK instance = new AtmUK();// se hace una instancia privada de ATM
    // -----------------
    private AtmUK() { 
      manejadores = new ArrayList<Manejador>();
    }
    /*Se crea un metodo con el objetvo de acceder a solo una instancia de ATM*/
    //------------------
    public static AtmUK getInstance(){
        return  instance;
    }
 

    // -----------------
    public double getTotal() {
        return this.dinero;
    }
    

    // -----------------
    public boolean sacarDinero(int dinero) {
        return manejador.retirar(dinero);
        // Todo: realizar el proceso de sacar de cada manejador la cantidad requerida
    }

    // ----------------- 
    public boolean ingresarDinero(int dinero, int denominacion) {
        return manejador.depositar(dinero, denominacion);
             // Todo: Sólo se puede depositar billetes de una sola denominación y agregarse al manejador correspondiente
    }

    public void addManejador(Manejador m){
        manejadores.add(m);
    }
    public Manejador removeManejador(int i){
        return manejadores.remove(i);
    }

    //Dentro de las transacciones se debe llamar al ATM para hacer el retiro o deposito de la cuenta correspondiente
    public static void transaction(Account cuenta){
        // here is where most of the work is
        int choice; 
        System.out.println("Please select an option"); 
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Balance ATM");
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        switch(choice){
            case 1:
                float amount; 
                System.out.println("Please enter amount to withdraw: "); 
                amount = in.nextFloat();
                if(amount > cuenta.getAmount() || amount == 0){
                    System.out.println("You have insufficient funds\n\n"); 
                    anotherTransaction(cuenta); // ask if they want another transaction
                } else {
                    // Todo: verificar que se puede realizar el retiro del atm

                    // Todo: actualizar tanto la cuenta como el atm y de los manejadores
                    // cuenta.retirar(amount);
                    // AtmUK.sacarDinero(amount);

                    // Todo: Mostrar resumen de transacción o error
                    // "You have withdrawn "+amount+" and your new balance is "+balance;
                    anotherTransaction(cuenta); 
                }
            break; 
            case 2:
                    // option number 2 is depositing 
                    float deposit; 
                    System.out.println("Please enter amount you would wish to deposit: "); 
                    deposit = in.nextFloat();
                    // Todo: actualizar tanto la cuenta como el atm
                    
                    // Todo: Mostrar resumen de transacción o error
                    // "You have withdrawn "+amount+" and your new balance is "+balance;
                    anotherTransaction(cuenta);
            break; 
            case 3:
                    // Todo: mostrar el balance de la cuenta
                    // "Your balance is "+balance
                    anotherTransaction(cuenta); 
            break;
            case 4:
                    // Todo: mostrar el balance del ATM con los billetes en cada manejador
                    anotherTransaction(cuenta); 
            break;
            default:
                    System.out.println("Invalid option:\n\n"); 
                    anotherTransaction(cuenta);
            break;
        }
    }
    public static void anotherTransaction(Account cuenta){
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        Scanner in = new Scanner(System.in);
        int anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
            transaction(cuenta); // call transaction method
        } else if(anotherTransaction == 2){
            System.out.println("Thanks for choosing us. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction(cuenta);
        }
    }

    
}
