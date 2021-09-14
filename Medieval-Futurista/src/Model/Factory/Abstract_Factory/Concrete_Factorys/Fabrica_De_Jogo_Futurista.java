package Model.Factory.Abstract_Factory.Concrete_Factorys;


import Model.Chain_Of_Responsability.Handler.Escudo;
import Model.Chain_Of_Responsability.Product_Robo.Concrete_Product_Robo__Concrete_Handler.Campo_Magnetico_Forte;
import Model.Chain_Of_Responsability.Product_Robo.Concrete_Product_Robo__Concrete_Handler.Campo_Magnetico_Fraco;
import Model.Chain_Of_Responsability.Product_Robo.Concrete_Product_Robo__Concrete_Handler.Campo_Magnetico_Normal;
import Model.Factory.Abstract_Factory.Abstract_Factory.Fabrica_De_Jogo;
import Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Inimigo_Forte;
import Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Inimigo_Fraco;
import Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Inimigo_Normal;
import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Forte;
import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Fraco;
import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Normal;
import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_3_Ataque.Product_Robo.Concrete_Product_Robo__Contrete_Strategy_3_Ataque.Raio_Paralisante_Forte;
import Model.Strategy.Strategy_3_Ataque.Product_Robo.Concrete_Product_Robo__Contrete_Strategy_3_Ataque.Raio_Paralisante_Fraco;
import Model.Strategy.Strategy_3_Ataque.Product_Robo.Concrete_Product_Robo__Contrete_Strategy_3_Ataque.Raio_Paralisante_Normal;

public class Fabrica_De_Jogo_Futurista extends Fabrica_De_Jogo {


    public static Fabrica_De_Jogo_Futurista instancia = null;

    public static Fabrica_De_Jogo_Futurista getInstance(){
        if(instancia == null){
            instancia = new Fabrica_De_Jogo_Futurista();
        }
        return instancia;
    }


    public Personagem createPersonagem(Personagem personagemPrincipal, String nome, String estado) {

        if(personagemPrincipal == null) {
            return switch (estado) {
                case "Fraco" -> new Robo_Fraco(nome);
                case "Normal" -> new Robo_Normal(nome);
                case "Forte" -> new Robo_Forte(nome);
                default -> null;
            };
        }else{
            return switch (estado) {
                case "Fraco" -> new Robo_Inimigo_Fraco(personagemPrincipal, nome);
                case "Normal" -> new Robo_Inimigo_Normal(personagemPrincipal, nome);
                case "Forte" -> new Robo_Inimigo_Forte(personagemPrincipal, nome);
                default -> null;
            };
        }

    }

    public void createArma(Personagem personagem, String estado){
        switch (estado) {
            case "Fraco" ->  personagem.setAtaqueInicial(new Raio_Paralisante_Fraco(personagem));
            case "Normal" -> personagem.setAtaqueInicial(new Raio_Paralisante_Normal(personagem));
            case "Forte" -> personagem.setAtaqueInicial(new Raio_Paralisante_Forte(personagem));
        }
    }

    public Escudo createEscudo(String estado) {

        return switch (estado) {
            case "Fraco" -> new Campo_Magnetico_Fraco();
            case "Normal" -> new Campo_Magnetico_Normal();
            case "Forte" -> new Campo_Magnetico_Forte();
            default -> null;
        };
    }

}
