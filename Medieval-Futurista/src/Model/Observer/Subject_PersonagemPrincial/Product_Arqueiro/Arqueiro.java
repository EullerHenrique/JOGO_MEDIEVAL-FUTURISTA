package Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro;


import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;

public abstract class Arqueiro extends PersonagemPrincipal {


    public Arqueiro(String nome) {
        super(nome);
    }


    public abstract void GerarLife();

}
