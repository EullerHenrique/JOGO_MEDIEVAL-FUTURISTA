package Model.State.Concrete_States;

import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.Strategy.Context__Personagem.Personagem;
import Model.State.State_Personagem_State.PersonagemState;
import Model.Strategy.Strategy_3_Ataque.Ataque;
import Model.Strategy.Strategy_3_Ataque.Product_Arqueiro.Concrete_Product_Robo__Contrete_Strategy_3_Ataque.Arco_E_Flecha_Normal;
import Model.Strategy.Strategy_3_Ataque.Product_Robo.Concrete_Product_Robo__Contrete_Strategy_3_Ataque.Raio_Paralisante_Normal;

public class Normal extends PersonagemState {

    public Normal(Personagem personagem) {
        super(personagem);

        //Recupera os golpes
        Ataque ataque = null;
        if(getPersonagem().getAtaque() != null) {
            ataque = getPersonagem().getAtaque();
        }

        getPersonagem().setCorrida(new Model.Strategy.Concrete_Strategy_2_Corrida.Normal(getPersonagem()));
        getPersonagem().setPulo(new Model.Strategy.Concrete_Strategy_1_Pulo.Normal(getPersonagem()));

        if(getPersonagem().getClass().getSuperclass().getSimpleName().equals("Robo") || getPersonagem().getClass().getSuperclass().getSimpleName().equals("Robo_Inimigo")) {

            getPersonagem().setAtaqueInicial(new Raio_Paralisante_Normal(getPersonagem()));

        }else if(getPersonagem().getClass().getSuperclass().getSimpleName().equals("Arqueiro") || getPersonagem().getClass().getSuperclass().getSimpleName().equals("Arqueiro_Inimigo")) {

            getPersonagem().setAtaqueInicial(new Arco_E_Flecha_Normal(getPersonagem()));

        }


            //Atribui os golpes
        if(ataque != null) {
            getPersonagem().setAtaque(ataque);
        }else{
            //Atribui o ataque
            getPersonagem().setAtaque(getPersonagem().getAtaqueInicial());

        }


    }

    public void verificarAlteracaoEstado(){

        //Forte
        if (getPersonagem().getLife() > (70*getPersonagem().getLifeMaxima()/100)) {
            getPersonagem().setPersonagemState(new Forte(getPersonagem()));
            getPersonagem().getPersonagemState().verificarAlteracaoEstado();
        }
        //Fraco
        else if(getPersonagem().getLife() < (31*getPersonagem().getLifeMaxima()/100)){
            getPersonagem().setPersonagemState(new Fraco(getPersonagem()));
            getPersonagem().getPersonagemState().verificarAlteracaoEstado();
        }

    }

}
