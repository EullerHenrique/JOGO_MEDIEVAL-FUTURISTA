package Model.Chain_Of_Responsability.Product_Robo.Concrete_Product_Robo__Concrete_Handler;


import Model.Chain_Of_Responsability.Product_Robo.Defesa_Do_Robo;
import Model.Strategy.Context__Personagem.Personagem;

public class Campo_Magnetico_Normal extends Defesa_Do_Robo {

    public Campo_Magnetico_Normal(){
        setLifeEscudo(4);
    }


    public void atacar(Personagem atacante, Personagem atacado) {

        if(getSucessor() != null){
            getSucessor().setLifeEscudoTotal(getLifeEscudoTotal() + getLifeEscudo());
            getSucessor().setEscudos(getEscudos()+ getClass().getSimpleName() + " (Proteção: " + getLifeEscudo() + " life (s)) \n");
            getSucessor().atacar(atacante, atacado);//O método atacar da classe Escudo é chamado
        }else{
            setLifeEscudoTotal(getLifeEscudoTotal() + getLifeEscudo());
            setEscudos(getEscudos()+getClass().getSimpleName() + " (Proteção: " + getLifeEscudo() + " life (s))\n");

            atacado.setEscudo(this);//Tal atribuição serve para o personagem atacado conseguir acessar as informações
            //                         da sua proteção (lifeEscudoTotal e escudos)

            atacante.getAtaque().atacar(atacado);//Se golpes tiverem sido adicionado, o metódo atacar da classe golpe
                                                // é chamado, caso contrário o método atacar da classe ataque é chamado

            atacado.getEscudoInicial().setLifeEscudoTotalFinal(getLifeEscudoTotal());// Útil na interface gráfica


            atacado.setEscudo(atacado.getEscudoInicial());//Tal atribuição serve para o encadeamento dos escudos ser
            //                                              reiniciado no próximo ataque


        }

        //Apaga o conteúdo do atributo escudos  (Dessa maneira, quando um novo ataque for realizado o atributo não irá
        //                                       manter os escudos adicionados no ataque anterior)
        //
        setEscudos("");



        //Reinicia o valor do atributo LifeEscudoTotal (Dessa maneira, quando somente um escudo for adicionado e um novo
        //                                              ataque for realizado, o atributo lifeEscudoTotal não irá manter
        //                                              o valor anterior, ou seja, o acumulo de valores a cada ataque não irá ocorrer)
        //                                              Esse problema não ocorre quando mais de um escudo é adicionado porque
        //                                              a cada ataque o encadeamento é reiniciado, com isso,
        //                                              o LifeEscudoTotal também é reiniciado, já que o valor presente
        //                                              no LifeEscudoTotal do escudo inicial sempre é zero.
        //
        setLifeEscudoTotal(0);




    }

}
