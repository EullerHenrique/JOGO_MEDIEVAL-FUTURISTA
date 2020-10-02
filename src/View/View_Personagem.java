package View;


import Model.Strategy.Context__Personagem.Personagem;

public class View_Personagem {

    private Personagem personagem;

    public View_Personagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public void DisplayNome(){
        System.out.println("\n==================\n");
        System.out.println("NOME: " + personagem.getNome());
        System.out.println("\n==================\n");
    }

    public void DisplayTipo(){
        System.out.println("\n==================\n");
        System.out.println("TIPO\n");
        System.out.println("Tipo do " + personagem.getNome() + "\n");
        System.out.println("TIPO GERAL: "+getClass().getSuperclass().getSimpleName());
        System.out.println("TIPO ESPECÍFICO: "+getClass().getSimpleName());
        System.out.println("\n==================\n");

    }

    public void DisplayTipoAtaque(){
        System.out.println("\n==================\n");
        System.out.println("ATAQUE\n");
        System.out.println("Ataque do (a) " + personagem.getNome() + "\n");
        System.out.println("Tipo de ataque: "+ personagem.getAtaqueInicial().getClass().getSimpleName());
        System.out.println("Dano do ataque: " + personagem.getAtaqueInicial().getDanoAtaque());
        System.out.println("\n==================\n");

    }

    public void DisplayTipoCorrida(){
        System.out.println("\n==================\n");
        System.out.println("CORRIDA\n");
        System.out.println("Corrida do (a) " + personagem.getNome() + "\n");
        System.out.println("Tipo de corrida: "+personagem.getCorrida().getClass().getSimpleName());
        System.out.println("Deslocamento da corrida: "+personagem.getCorrida().getMove());
        System.out.println("\n==================\n");

    }

    public void DisplayTipoPulo(){
        System.out.println("\n==================\n");
        System.out.println("PULO\n");
        System.out.println("Pulo do (a) " + personagem.getNome() + "\n");
        System.out.println("Tipo de pulo: "+personagem.getPulo().getClass().getSimpleName());
        System.out.println("\n==================\n");

    }

    public void DisplayPosicao(){
        System.out.println("\n==================\n");
        System.out.println("POSIÇÃO\n");
        System.out.println("Posição do (a) " + personagem.getNome() + "\n");

        System.out.println("Coordenada X  = "  +  personagem.getCoordenada_x());
        System.out.println("Coordenada Y  = "  +  personagem.getCoordenada_y());
        System.out.println("\n==================\n");

    }

    public void DisplayLife(){
        System.out.println("\n==================\n");
        System.out.println("LIFE\n");
        System.out.println("Life do (a) " + personagem.getNome()+ " = " + personagem.getLife());
        System.out.println("\n==================\n");


    }

    public void DisplayEscudo(){
        System.out.println("\n==================\n");
        System.out.println("ESCUDO\n");
        System.out.println("Escudo (s) do (a) " + personagem.getNome() + " : \n\n");
        System.out.println(personagem.getEscudo().getEscudos());
        System.out.println("\nLife (s) do (s) escudo (s): " + personagem.getEscudo().getLifeEscudoTotal());
        System.out.println("\n==================\n");

    }

    public void DisplayGolpe(){
        System.out.println("\n==================\n");
        System.out.println("GOLPE\n");
        System.out.println("Golpe (s) do (a) "+personagem.getNome()+" : \n\n");
        System.out.println(personagem.getAtaque().getGolpes());
        System.out.println("\nDano do (s) golpe (s) : "+personagem.getAtaque().getDanoGolpeTotal() +" life (s)");
        System.out.println("\n==================\n");

    }


    public void DisplayEstado() {
        System.out.println("\n==================\n");
        System.out.println("ESTADO\n");
        System.out.println("Estado do (a) " + personagem.getNome() + "\n");
        System.out.println("ESTADO INICIAL: " + personagem.getPersonagemStateInicial().getClass().getSimpleName());
        System.out.println("ESTADO ATUAL: " + personagem.getPersonagemState().getClass().getSimpleName());
        System.out.println("\n==================\n");

    }


    public void DisplayInformacoesPersonagem(){
        System.out.println("\n======================================================================================\n");
        DisplayNome();
        DisplayTipo();
        DisplayTipoAtaque();
        DisplayTipoCorrida();
        DisplayTipoPulo();
        DisplayPosicao();
        DisplayLife();
        if(personagem.getEscudo()!= null && personagem.getEscudo().getLifeEscudoTotal() != 0){
            DisplayEscudo();
        }

        if(personagem.getAtaque().getDanoGolpeTotal() != 0) {
            DisplayGolpe();
        }

        DisplayEstado();
        System.out.println("\n======================================================================================\n");
    }

    public void DisplayCorrida(String direcao, int move){
        System.out.println("\n--------------------------------------------------------------------------------------\n");
        System.out.println("CORRIDA\n");
        switch (direcao) {
            case "Direita" -> System.out.println("Corrida " + personagem.getCorrida().getClass().getSimpleName() + " (+ " + move + "x ) " + "do (a) " + personagem.getNome() + " para " + direcao + "\n");
            case "Esquerda" -> System.out.println("Corrida " + personagem.getCorrida().getClass().getSimpleName() + " (- " + move + "x ) " + " do (a) " + personagem.getNome() + " para " + direcao + "\n");
            case "Cima" -> System.out.println("Corrida " + personagem.getCorrida().getClass().getSimpleName() + " (+ " + move + "y ) " + " do (a) " + personagem.getNome() + " para " + direcao + "\n");
            case "Baixo" -> System.out.println("Corrida " + personagem.getCorrida().getClass().getSimpleName() + " (- " + move + "y )" + " do (a) " + personagem.getNome() + " para " + direcao + "\n");
        }
        System.out.println("\n---------------------------------------------------------------------------------------\n");
    }

    public void DisplayErroMorteCorrida(){
        System.out.println("\n======================================================================================\n");
        System.out.println("A corrida " + "do(a) " + personagem.getNome() + " não pode ser realizado (a), pois o (a) " + personagem.getNome() + " morreu ! ");
        System.out.println("\n======================================================================================\n");
    }

    public void DisplayPulo(){
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("PULO\n");
        System.out.println("Pulo "+personagem.getPulo().getClass().getSimpleName()+" do (a) "+ personagem.getNome());
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public void DisplayErroMortePulo(){
        System.out.println("\n======================================================================================\n");
        System.out.println("O pulo " + "do(a) " + personagem.getNome() + " não pode ser realizado (a), pois o (a) " + personagem.getNome() + " morreu ! ");
        System.out.println("\n======================================================================================\n");
    }

    public void DisplayAntesAtaque(Personagem atacado){
        System.out.println("\n======================\n");
        System.out.println("ANTES DO ATAQUE");
        System.out.println("\n======================\n");

        System.out.println("INFORMAÇÕES DO ATACANTE\n");
        System.out.println("-----------------------------------");

        DisplayInformacoesPersonagem();

        System.out.println("\nINFORMAÇÕES DO ATACADO\n");
        System.out.println("-----------------------------------");

        atacado.getViewPersonagem().DisplayInformacoesPersonagem();
    }

    public void DisplayDepoisAtaque(int danoGolpeTotal, Personagem atacado, int danoTotal){

        System.out.println("\n====================================================================================================================\n");

        System.out.println("ATAQUE\n");
        if(atacado.getEscudo() !=  null) {
            System.out.println("Dano total ( Ataque (" + personagem.getAtaqueInicial().getDanoAtaque() + ") + Golpe (s) (" + danoGolpeTotal + ") - Escudo (s) (" + atacado.getEscudo().getLifeEscudoTotal() + ") ) : " + danoTotal + " life(s) " + "\n");
        }else{
            System.out.println("Dano total ( Ataque (" + personagem.getAtaqueInicial().getDanoAtaque() + ") + Golpe (s) (" + danoGolpeTotal + ") - Escudo (s) (0) ) : " + danoTotal + " life(s) " + "\n");
        }
        System.out.println("\n====================================================================================================================\n");

        System.out.println("\n====================\n");
        System.out.println("DEPOIS DO ATAQUE");
        System.out.println("\n====================\n");

        System.out.println("\nINFORMAÇÕES DO ATACADO\n");
        System.out.println("-----------------------------------");

        atacado.getViewPersonagem().DisplayInformacoesPersonagem();

        if (atacado.getLife() == 0) {
            DisplayMorte(atacado);
        }
    }

    public void DisplayErroMorteAtaque(){
        System.out.println("\n======================================================================================\n");
        System.out.println("O ataque " +" não pode ser realizado (a), pois o (a) personagem atacante: " + personagem.getNome() + " morreu ! ");
        System.out.println("\n======================================================================================\n");
    }

    public void DisplayMorte(Personagem atacado){
        System.out.println("\n=====================================================================================\n");
        System.out.println("O (a) " + atacado.getNome() + " morreu! ");
        System.out.println("\n=====================================================================================\n");
    }


    public void DisplayTraicao(Personagem atacado){
        System.out.println("\n======================================================================================\n");
        System.out.println("TRAIÇÃO\n");
        System.out.println("Um " + personagem.getClass().getSuperclass().getSuperclass().getSimpleName() +" não pode atacar outro "+ atacado.getClass().getSuperclass().getSuperclass().getSimpleName());
        System.out.println("\n======================================================================================\n");
    }

    public void DisplayProcura(Personagem atacado){

        System.out.println("\n======================================================================================\n");
        System.out.println("PROCURA\n");
        System.out.println("O (a) " +personagem.getNome() + " irá procurar o (a) "+atacado.getNome()+"\n");

        System.out.println("ATACANTE\n");
        DisplayPosicao();
        System.out.println("ATACADO\n");
        atacado.getViewPersonagem().DisplayPosicao();


    }

    public void DisplayEncontro(Personagem atacado){

        System.out.println("\n======================================================================================\n");
        System.out.println("Encontro\n");
        System.out.println("O (a) " +personagem.getNome() + " encontrou o (a) "+atacado.getNome()+"\n");

        System.out.println("ATACANTE");
        DisplayPosicao();
        System.out.println("ATACADO");
        atacado.getViewPersonagem().DisplayPosicao();

        System.out.println("\n======================================================================================\n");

    }


}
