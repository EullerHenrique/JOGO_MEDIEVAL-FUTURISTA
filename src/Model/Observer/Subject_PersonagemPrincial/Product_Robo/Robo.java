package Model.Observer.Subject_PersonagemPrincial.Product_Robo;


import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;

public abstract class Robo extends PersonagemPrincipal {

    public Robo(String nome) {
        super(nome);
    }

    public abstract void GerarLife();

}
