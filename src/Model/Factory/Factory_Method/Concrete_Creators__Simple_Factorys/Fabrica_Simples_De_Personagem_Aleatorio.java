package Model.Factory.Factory_Method.Concrete_Creators__Simple_Factorys;

import Model.Chain_Of_Responsability.Handler.Escudo;
import Model.Decorator.ConcreteDecorators.Gancho;
import Model.Decorator.ConcreteDecorators.Joelhada;
import Model.Decorator.ConcreteDecorators.Nocaute;
import Model.Factory.Abstract_Factory.Abstract_Factory.Fabrica_De_Jogo;
import Model.Factory.Abstract_Factory.Concrete_Factorys.Fabrica_De_Jogo_Futurista;
import Model.Factory.Abstract_Factory.Concrete_Factorys.Fabrica_De_Jogo_Medieval;
import Model.Factory.Factory_Method.Creator.Fabrica_De_Personagem_Aleatorio;
import Model.Observer.Observer_Inimigo.Inimigo;
import Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Inimigo_Forte;
import Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Inimigo_Fraco;
import Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Inimigo_Normal;
import Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Inimigo_Forte;
import Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Inimigo_Fraco;
import Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Inimigo_Normal;
import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Forte;
import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Fraco;
import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts.Arqueiro_Normal;
import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Forte;
import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Fraco;
import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts.Robo_Normal;
import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_3_Ataque.Ataque;

import java.util.Random;

public class Fabrica_Simples_De_Personagem_Aleatorio extends Fabrica_De_Personagem_Aleatorio {

    private static Fabrica_Simples_De_Personagem_Aleatorio instancia = null;

    public static Fabrica_Simples_De_Personagem_Aleatorio getInstance(){
        if(instancia == null){
            instancia = new Fabrica_Simples_De_Personagem_Aleatorio();
        }
        return instancia;
    }

    public Personagem createPersonagem(Personagem personagemPrincipal, String nome, Fabrica_De_Jogo f) {
        Ataque ataque;
        Personagem p = null;
        Random random = new Random();
        double N = random.nextDouble();

            if (N <= 0.2) {
                if (personagemPrincipal == null) {
                    p = f.createPersonagem(null, nome, "Fraco");
                } else {
                    p = f.createPersonagem(personagemPrincipal, nome, "Fraco");
                }
                Escudo escudo_1 = f.createEscudo("Fraco");
                p.setEscudo(escudo_1);

                ataque = new Joelhada(p);
                p.setAtaque(ataque);

            } else if (N > 0.2 && N <= 0.4) {

                if (personagemPrincipal == null) {
                    p = f.createPersonagem(null, nome, "Fraco");
                }else{
                    p = f.createPersonagem(personagemPrincipal, nome, "Fraco");
                }
                Escudo escudo_1 = f.createEscudo("Fraco");
                Escudo escudo_2 = f.createEscudo("Fraco");
                escudo_1.setSucessor(escudo_2);

                p.setEscudo(escudo_1);

                ataque = new Joelhada(p);
                ataque = new Joelhada(ataque);

                p.setAtaque(ataque);


            } else if (N > 0.4 && N <= 0.6) {

                if (personagemPrincipal == null) {
                    p = f.createPersonagem(null, nome, "Fraco");
                }else{
                    p = f.createPersonagem(personagemPrincipal, nome, "Fraco");
                }

                Escudo escudo_1 = f.createEscudo("Fraco");
                Escudo escudo_2 = f.createEscudo("Fraco");
                Escudo escudo_3 = f.createEscudo("Fraco");

                escudo_1.setSucessor(escudo_2);
                escudo_2.setSucessor(escudo_3);
                p.setEscudo(escudo_1);

                ataque = new Joelhada(p);
                ataque = new Joelhada(ataque);
                ataque = new Gancho(ataque);

                p.setAtaque(ataque);

            } else if (N > 0.6 && N <= 0.8) {

                if (personagemPrincipal == null) {
                    p = f.createPersonagem(null, nome, "Normal");
                }else{
                    p = f.createPersonagem(personagemPrincipal, nome, "Normal");
                }

                Escudo escudo_1 = f.createEscudo("Fraco");
                Escudo escudo_2 = f.createEscudo("Fraco");
                Escudo escudo_3 = f.createEscudo("Fraco");
                Escudo escudo_4 = f.createEscudo("Normal");

                escudo_1.setSucessor(escudo_2);
                escudo_2.setSucessor(escudo_3);
                escudo_3.setSucessor(escudo_4);

                p.setEscudo(escudo_1);

                ataque = new Joelhada(p);
                ataque = new Joelhada(ataque);
                ataque = new Gancho(ataque);
                ataque = new Gancho(ataque);

                p.setAtaque(ataque);

            } else if (N > 0.8 && N < 1.0) {

                if (personagemPrincipal == null) {
                    p = f.createPersonagem(null, nome, "Forte");
                }else {
                    p = f.createPersonagem(personagemPrincipal, nome, "Forte");
                }

                Escudo escudo_1 = f.createEscudo("Fraco");
                Escudo escudo_2 = f.createEscudo("Fraco");
                Escudo escudo_3 = f.createEscudo("Fraco");
                Escudo escudo_4 = f.createEscudo("Normal");
                Escudo escudo_5 = f.createEscudo("Forte");

                escudo_1.setSucessor(escudo_2);
                escudo_2.setSucessor(escudo_3);
                escudo_3.setSucessor(escudo_4);
                escudo_4.setSucessor(escudo_5);

                p.setEscudo(escudo_1);

                ataque = new Joelhada(p);
                ataque = new Joelhada(ataque);
                ataque = new Gancho(ataque);
                ataque = new Gancho(ataque);
                ataque = new Nocaute(ataque);

                p.setAtaque(ataque);

            }

        return p;
    }
}
