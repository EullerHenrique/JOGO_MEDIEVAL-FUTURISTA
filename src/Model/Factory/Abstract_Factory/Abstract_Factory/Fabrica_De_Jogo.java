package Model.Factory.Abstract_Factory.Abstract_Factory;

import Model.Chain_Of_Responsability.Handler.Escudo;
import Model.Observer.Observer_Inimigo.Inimigo;
import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.Strategy.Context__Personagem.Personagem;

public abstract class Fabrica_De_Jogo {

   public abstract Personagem createPersonagem(Personagem personagemPrincipal, String nome, String estado);

   public abstract void createArma(Personagem personagem, String estado);

   public abstract Escudo createEscudo(String estado);

}
