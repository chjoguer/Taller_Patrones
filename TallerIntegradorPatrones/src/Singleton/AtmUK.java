/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import Adapter.CuentaAdapter;
import ChainOfResponsibility.Manejador;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Scanner;

public class AtmUK {

    protected final Locale currency = Locale.US;
    protected double dinero = 0;
    protected LinkedList<Manejador> manejadores; // Cada manejador puede entregar dinero de una sola denominación
    protected Manejador manejador = null;
    /*Implementacion del patron sigleton*/
    private static AtmUK instance;// se hace una instancia privada de ATM


    public Manejador getManejador() {
        return manejador;
    }

    public void setManejador(Manejador manejador) {

        this.manejador = manejador;
    }

    // -----------------
    private AtmUK() {
        manejadores = new LinkedList<>();
    }

    /*Se crea un metodo con el objetvo de acceder a solo una instancia de ATM*/
    //------------------
    public static AtmUK getInstance() {
        if (instance == null) {
            return new AtmUK();
        }
        return instance;

    }

    @Override
    public String toString() {
        return "AtmUK{" + "currency=" + currency + ", dinero=" + dinero + ", manejador=" + manejador + '}';
    }

    // -----------------
    public double getTotal() {
        return this.dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    // -----------------
    public boolean sacarDinero(double dinero) {
        if (manejador.retirar(dinero)) {
            this.dinero -= dinero;
            return true;
        }
        return false;
        // Todo: realizar el proceso de sacar de cada manejador la cantidad requerida
    }

    // ----------------- 
    public boolean ingresarDinero(int dinero, double denominacion) {
        this.dinero += dinero * denominacion;
        return manejador.depositar(dinero, denominacion);
        //  Sólo se puede depositar billetes de una sola denominación y agregarse al manejador correspondiente
    }

    public void addManejador(Manejador m) {
        if (manejador == null) {
            //dinero += m.getDenominacion()*m.getCantidad();//Con esto calculo la cantidad de dinero que tiene el cajero
            manejador = m;
            ///m.setNext(null);
        } else {
            for (Manejador n = manejador; n != null; n = m.getNext()) {
                //dinero += m.getDenominacion()*m.getCantidad();//Con esto calculo la cantidad de dinero que tiene el cajero
                if (manejador.getNext() == null) {
                    this.manejador.setNext(m);

                }
            }
        }
        cargarDineroManejadores();
    }

    public Manejador removeManejador(int i) {
        return manejadores.remove(i);
    }

    public void cargarDineroManejadores() {
        for (Manejador n = manejador; n != null; n = n.getNext()) {
            dinero += n.getCantidad() * n.getDenominacion();
        }

    }

    //Dentro de las transacciones se debe llamar al ATM para hacer el retiro o deposito de la cuenta correspondiente
    public void transaction(CuentaAdapter cuenta) {
        // here is where most of the work is
        double denominacion = 0;
        Scanner in = new Scanner(System.in);
        int choice;
        System.out.println("Please select an option");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Balance ATM");
        choice = in.nextInt();
        in.nextLine();
        switch (choice) {
            case 1:
                float amount=0;
                System.out.println("Please enter amount to withdraw: ");
                amount = in.nextFloat();
                in.nextLine();
                // verificar que se puede realizar el retiro del atm
                if (amount > cuenta.getAmount() || amount == 0) {
                    System.out.println("You have insufficient funds\n\n");
                    anotherTransaction(cuenta); // ask if they want another transaction
                } else {
                    // Todo: actualizar tanto la cuenta como el atm y de los manejadores
                    if(amount<cuenta.balance()){
                        cuenta.retirar(amount);
                        sacarDinero(choice);
                        this.dinero -= amount;
                        System.out.printf("Tu retiro es de $%.2f el balance de tu cueta es $%.2f\n",amount,cuenta.balance());

                    }else{
                        System.out.println("No hay suficiente dinero en el ATM");

                    }
                    anotherTransaction(cuenta);
                }
                break;
                
                
                
            case 2:
                // option number 2 is depositing 
                int deposit;
                System.out.println("Please enter amount you would wish to deposit: ");
                deposit = in.nextInt();
                System.out.println("xx "+deposit);
                in.nextLine();
                double n;
                System.out.print("Enter the denomination of your deposit: "); 
                n = in.nextInt();
                System.out.println("s "+n);
                in.nextLine();
                if(n==0||deposit==0){
                    System.out.println("Dominacion o la cantidad de dinero esta vacia");
                }else{
                    // Mostrar resumen de transacción o error
                    if(ingresarDinero(deposit, n)){
                        cuenta.depositar(deposit, n);
                        System.out.printf("Tu has depositado $%.2f y el balance de tu cuenta es $%.2f\n",(n*deposit),cuenta.balance());
                        System.out.println("You have withdrawn " +deposit);
                        System.out.println("Deposito Exitoso");
                    }else
                        System.out.println("No se pudo depositar");                    
                }
                anotherTransaction(cuenta);
                break;
                
                
                
            case 3:
                // Todo: mostrar el balance de la cuenta
                // "Your balance is "+balance
                System.out.println("El balance de tu cuenta es: " + cuenta.getAmount());
                anotherTransaction(cuenta);
                break;
                
                
                
            case 4:
                // Todo: mostrar el balance del ATM con los billetes en cada manejador
                System.out.printf("Balance del ATMEC es: $ %.2f\n", this.getTotal());

                anotherTransaction(cuenta);
                break;
            default:
                System.out.println("Invalid option:\n\n");
                anotherTransaction(cuenta);
                break;
        }
    }

    public void anotherTransaction(CuentaAdapter cuenta) {
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        Scanner in = new Scanner(System.in);
        int anotherTransaction = in.nextInt();
        switch (anotherTransaction) {
            case 1:
                transaction(cuenta); // call transaction method
                break;
            case 2:
                System.out.println("Thanks for choosing us. Good Bye!");
                break;
            default:
                System.out.println("Invalid choice\n\n");
                anotherTransaction(cuenta);
                break;
        }
    }

}
