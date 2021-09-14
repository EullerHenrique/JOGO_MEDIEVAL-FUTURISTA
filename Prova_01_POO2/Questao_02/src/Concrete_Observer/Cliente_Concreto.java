package Concrete_Observer;

import Observer.Cliente;
import Suject.Servidor;

public class Cliente_Concreto implements Cliente {

    private Servidor servidor;
    private String nome;

    public Cliente_Concreto(String nome, Servidor servidor) {
        this.nome = nome;
        this.servidor = servidor;
        this.servidor.registerObserver(this);
    }

    public void update(String valor){
        System.out.println("Olá, "+ nome+ "! \n\nAs ações a seguir foram atualizadas: \n\nAção: Preço novo \n\n"+ valor+"\n\n");
    }
}
