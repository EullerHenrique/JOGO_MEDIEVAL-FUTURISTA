package Main;

import Concrete_Observer.Cliente_Concreto;
import Concrete_Subject.Servidor_Concreto;
import Observer.Cliente;
import Suject.Servidor;

public class Main {
    public static void main(String[] args) {
        Servidor servidor = new Servidor_Concreto();

        Cliente joao = new Cliente_Concreto("João", servidor);
        Cliente maria = new Cliente_Concreto("Maria", servidor);
        Cliente jose = new Cliente_Concreto("José", servidor);
        Cliente josefa = new Cliente_Concreto("Josefa", servidor);


        servidor.setValor("Petrobras", 20.54);
        servidor.setValor("Petrobras", 123.22);

        servidor.setValor("Vale", 30.01);
        servidor.setValor("Vale", 123.212);


        servidor.setValor("OCX", 47.59);
        servidor.setValor("OCX", 555.12);


        servidor.setValor("Apple",100.54);
        servidor.setValor("Apple", 200.56);

        servidor.setValor("Petrobras", 10000.0000);





    }
}
