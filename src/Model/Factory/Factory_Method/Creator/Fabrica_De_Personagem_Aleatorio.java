package Model.Factory.Factory_Method.Creator;

import Model.Factory.Abstract_Factory.Abstract_Factory.Fabrica_De_Jogo;
import Model.Observer.Observer_Inimigo.Inimigo;
import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.Strategy.Context__Personagem.Personagem;

public abstract class Fabrica_De_Personagem_Aleatorio {

    public abstract Personagem createPersonagem(Personagem personagemPrincipal, String nome, Fabrica_De_Jogo f);

}
