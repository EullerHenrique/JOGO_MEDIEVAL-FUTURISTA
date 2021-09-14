package Concrete_Subject;

import Observer.Cliente;
import Suject.Servidor;

import java.util.ArrayList;

public class Servidor_Concreto implements Servidor {

    private String valor = "";

    private ArrayList<Cliente> clientes =  new ArrayList<>();

    private ArrayList<String> acoes = new ArrayList<>();
    private ArrayList<Double> precos = new ArrayList<>();

    public String getValor() {

        this.valor = "";

        for(int i = 0; i < acoes.size(); i++){
            this.valor = this.valor + acoes.get(i) + ": " + precos.get(i) + "\n";
        }

        return valor;
    }

    public void setValor(String acao, double preco) {

        if(!acoes.isEmpty() ){

            int updated = 0;

            for (int i = 0; i < acoes.size(); i++) {

                if (acoes.get(i).equals(acao)) {

                    precos.set(i, preco); //Ação repetida -> Preço atualizado
                    updated = 1;
                    break;
                }

            }

            if(updated != 1){// Nova ação -> Novo preço
                acoes.add(acao);
                precos.add(preco);
            }

        }else{ // Primeira ação -> Primeiro preço
            acoes.add(acao);
            precos.add(preco);
        }

        this.notifyObservers();

    }

    public void registerObserver(Cliente cliente){
        clientes.add(cliente);
    }

    public void removeObserver(Cliente cliente){
        clientes.remove(cliente);
    }

    public void notifyObservers(){
        for(Cliente cliente: clientes){
            cliente.update(getValor());
        }
    }

}
