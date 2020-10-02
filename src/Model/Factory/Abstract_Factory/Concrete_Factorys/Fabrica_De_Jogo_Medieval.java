package Model.Factory.Abstract_Factory.Concrete_Factorys;


import Model.Chain_Of_Responsability.Handler.Escudo;
import Model.Chain_Of_Responsability.Product_Arqueiro.Concrete_Product_Arqueiro__Concrete_Handler.Escudo_Forte;
import Model.Chain_Of_Responsability.Product_Arqueiro.Concrete_Product_Arqueiro__Concrete_Handler.Escudo_Fraco;
import Model.Chain_Of_Responsability.Product_Arqueiro.Concrete_Product_Arqueiro__Concrete_Handler.Escudo_Normal;
import Model.Factory.Abstract_Factory.Abstract_Factory.Fabrica_De_Jogo;
import Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Inimigo_Forte;
import Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Inimigo_Fraco;
import Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Inimigo_Normal;
import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Forte;
import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Fraco;
import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Normal;
import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_3_Ataque.Product_Arqueiro.Concrete_Product_Robo__Contrete_Strategy_3_Ataque.Arco_E_Flecha_Forte;
import Model.Strategy.Strategy_3_Ataque.Product_Arqueiro.Concrete_Product_Robo__Contrete_Strategy_3_Ataque.Arco_E_Flecha_Fraco;
import Model.Strategy.Strategy_3_Ataque.Product_Arqueiro.Concrete_Product_Robo__Contrete_Strategy_3_Ataque.Arco_E_Flecha_Normal;

public class Fabrica_De_Jogo_Medieval extends Fabrica_De_Jogo {

    public static Fabrica_De_Jogo_Medieval instancia = null;

    public static Fabrica_De_Jogo_Medieval getInstance(){
        if(instancia == null){
            instancia = new Fabrica_De_Jogo_Medieval();
        }
        return instancia;
    }

    public Personagem createPersonagem(Personagem personagemPrincipal, String nome, String estado) {

        if(personagemPrincipal == null) {
            return switch (estado) {
                case "Fraco" -> new Arqueiro_Fraco(nome);
                case "Normal" -> new Arqueiro_Normal(nome);
                case "Forte" -> new Arqueiro_Forte(nome);
                default -> null;
            };
        }else{
            return switch (estado) {
                case "Fraco" -> new Arqueiro_Inimigo_Fraco(personagemPrincipal, nome);
                case "Normal" -> new Arqueiro_Inimigo_Normal(personagemPrincipal, nome);
                case "Forte" -> new Arqueiro_Inimigo_Forte(personagemPrincipal, nome);
                default -> null;
            };
        }

    }

    public void createArma(Personagem personagem, String estado){
        switch (estado) {
            case "Fraco" ->  personagem.setAtaqueInicial(new Arco_E_Flecha_Fraco(personagem));
            case "Normal" -> personagem.setAtaqueInicial(new Arco_E_Flecha_Normal(personagem));
            case "Forte" -> personagem.setAtaqueInicial(new Arco_E_Flecha_Forte(personagem));
        }
    }

    public Escudo createEscudo(String estado) {
            return switch (estado) {
                case "Fraco" -> new Escudo_Fraco();
                case "Normal" -> new Escudo_Normal();
                case "Forte" -> new Escudo_Forte();
                default -> null;
            };
    }


}
