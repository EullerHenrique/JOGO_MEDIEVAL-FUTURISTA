package Model.Strategy.Strategy_3_Ataque.Product_Robo.Concrete_Product_Robo__Contrete_Strategy_3_Ataque;


import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_3_Ataque.Ataque;
import Model.Strategy.Strategy_3_Ataque.Product_Robo.Arma_Do_Robo;

public class Raio_Paralisante_Fraco extends Arma_Do_Robo {

    public Raio_Paralisante_Fraco(Personagem atacante) {
        super(atacante);
        setDanoAtaque(5);
    }

    public void atacar(Personagem atacado) {

        setAtacado(atacado);


        if (validar(atacado)) {

            //Recupera os golpes
            Ataque ataque = getAtacante().getAtaque();

            //Atribui o ataque e os golpes (ÚTIL SOMENTE PARA A VIEW (DisplayInformacoesPersonagem) PRESENTE NA CLASSE
            //PERSONAGEM e NA VIEW PRESENTE NA CLASSE ATAQUE (DisplayProcura)
            //(Permite que o danoGolpeTolal e os golpes sejam acessados)

            getAtacante().setAtaque(this);

            getAtacante().getViewPersonagem().DisplayAntesAtaque(atacado);

            if (atacado.getEscudo() == null) {
                setDanoTotal(getDanoGolpeTotal() + getDanoAtaque());
            } else {
                if (atacado.getEscudo().getLifeEscudoTotal() > getDanoGolpeTotal() + getDanoAtaque()) {
                    setDanoTotal(0);
                } else {
                    setDanoTotal(getDanoGolpeTotal() + getDanoAtaque() - atacado.getEscudo().getLifeEscudoTotal());
                    getAtacante().getAtaqueInicial().setDanoGolpeTotal(getDanoGolpeTotal());
                }
            }



            //Atribui os golpes de volta (ÚTIL NO CÓDIGO DA CLASSE PERSONAGEM STATE)
            //                           (ÚTIL NO PRÓXIMO ATAQUE, POIS O PRÓXIMO ATAQUE CONTERÁ OS MESMOS GOLPES)

            getAtacante().setAtaque(ataque);


            atacado.setLife(atacado.getLife() - getDanoTotal());


            getAtacante().getViewPersonagem().DisplayDepoisAtaque(getDanoGolpeTotal(), atacado, getDanoTotal());





        }
    }
}
