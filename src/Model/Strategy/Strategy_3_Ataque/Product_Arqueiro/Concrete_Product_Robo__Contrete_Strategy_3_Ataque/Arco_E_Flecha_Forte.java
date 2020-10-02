package Model.Strategy.Strategy_3_Ataque.Product_Arqueiro.Concrete_Product_Robo__Contrete_Strategy_3_Ataque;
import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_3_Ataque.Ataque;
import Model.Strategy.Strategy_3_Ataque.Product_Arqueiro.Arma_Do_Arqueiro;
import View.View_Personagem;

public class Arco_E_Flecha_Forte extends Arma_Do_Arqueiro {


    public Arco_E_Flecha_Forte(Personagem atacante) {
        super(atacante);
        setDanoAtaque(15);
    }


    public void atacar(Personagem atacado) {

        setAtacado(atacado);

        if (validar(atacado)) {

            //Recupera os golpes
            Ataque ataque = getAtacante().getAtaque();


            //Atribui o ataque e os golpes (ÚTIL SOMENTE PARA A VIEW (DisplayInformacoesPersonagem) PRESENTE NA CLASSE PERSONAGEM e NA VIEW PRESENTE NA CLASSE ATAQUE (DisplayProcura)
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


