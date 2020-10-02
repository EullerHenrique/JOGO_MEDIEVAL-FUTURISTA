package Model.State.Concrete_States;

import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.Strategy.Concrete_Strategy_2_Corrida.Rapida;
import Model.Strategy.Context__Personagem.Personagem;
import Model.State.State_Personagem_State.PersonagemState;
import Model.Strategy.Strategy_3_Ataque.Ataque;
import Model.Strategy.Strategy_3_Ataque.Product_Arqueiro.Concrete_Product_Robo__Contrete_Strategy_3_Ataque.Arco_E_Flecha_Forte;
import Model.Strategy.Strategy_3_Ataque.Product_Robo.Concrete_Product_Robo__Contrete_Strategy_3_Ataque.Raio_Paralisante_Forte;

public class Forte extends PersonagemState {

    public Forte(Personagem personagem) {
        super(personagem);

        //Recupera os golpes
        Ataque ataque = null;
        if (getPersonagem().getAtaque() != null) {
            ataque = getPersonagem().getAtaque();
        }

        getPersonagem().setCorrida(new Rapida(getPersonagem()));
        getPersonagem().setPulo(new Model.Strategy.Concrete_Strategy_1_Pulo.Alto(getPersonagem()));

        if(getPersonagem().getClass().getSuperclass().getSimpleName().equals("Robo") || getPersonagem().getClass().getSuperclass().getSimpleName().equals("Robo_Inimigo")) {

            getPersonagem().setAtaqueInicial(new Raio_Paralisante_Forte(getPersonagem()));

        }else if(getPersonagem().getClass().getSuperclass().getSimpleName().equals("Arqueiro") || getPersonagem().getClass().getSuperclass().getSimpleName().equals("Arqueiro_Inimigo")) {

            getPersonagem().setAtaqueInicial(new Arco_E_Flecha_Forte(getPersonagem()));

        }

        //Atribui os golpes
        if (ataque != null) {
            getPersonagem().setAtaque(ataque);
        } else {
            //Atribui o ataque
            getPersonagem().setAtaque(getPersonagem().getAtaqueInicial());
        }

    }

    public void verificarAlteracaoEstado() {

        //Normal
        if (getPersonagem().getLife() < (71 * getPersonagem().getLifeMaxima() / 100)) {

            getPersonagem().setPersonagemState(new Model.State.Concrete_States.Normal(getPersonagem()));
            getPersonagem().getPersonagemState().verificarAlteracaoEstado();
        }



    }

}
