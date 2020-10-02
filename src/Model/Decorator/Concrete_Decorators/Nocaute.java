package Model.Decorator.Concrete_Decorators;

import Model.Decorator.Decorator.Golpe;
import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_3_Ataque.Ataque;

public class Nocaute extends Golpe {

    public Nocaute(Ataque ataque) {
        super(ataque);
        setDanoGolpe(15);
    }

    public Nocaute(Personagem personagem){
        setDanoGolpe(15);
        setAtacante(personagem);
    }

    public void atacar(Personagem atacado) {


        //Se o golpe não possuir algo no atributo ataque, o atributo ataque deve receber o ataque inicial do personagem em questão
        //Se o golpe possuir algo no atributo ataque e esse ataque for diferente do ataque inicial do personagem
        //(isso ocorre quando o personagem muda de estado), o atributo ataque deve receber o novo ataque inicial do personagem

        if(getAtaque() == null || (getAtaque() != null && getAtacante()!= null && getAtacante().getAtaqueInicial() != getAtaque())){
            setAtaque(getAtacante().getAtaqueInicial());
        }

        if(getAtaque() != null) {
            getAtaque().setDanoGolpeTotal(getDanoGolpeTotal() + getDanoGolpe());
            getAtaque().setGolpes(getGolpes() + getClass().getSimpleName() + " (Dano: " + getDanoGolpe() + " life (s))\n");
            getAtaque().atacar(atacado);
        }

        //Apaga o conteúdo do atributo escudos  (Dessa maneira, quando um golpe for adicionado e depois removido
        //                                      o atributo não irá manter o golpe adicionado anteriormente)
        setGolpes("");

        //Reinicia o valor do atributo LifeEscudoTotal (Dessa maneira, quando um golpe for adicioando e depois removido
        //                                              o atributo não irá manter o valor do golpe anterior)
        setDanoGolpeTotal(0);

    }

}
