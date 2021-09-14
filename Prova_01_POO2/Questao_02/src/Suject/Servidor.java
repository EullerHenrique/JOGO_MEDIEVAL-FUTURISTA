package Suject;

import Observer.Cliente;

import java.util.ArrayList;

public interface Servidor {

    public void setValor(String acao, double preco);
    public String getValor();

    public void registerObserver(Cliente cliente);
    public void removeObserver(Cliente cliente);
    public void notifyObservers();

}
