package View;


import Model.Observer.Observer_Inimigo.Inimigo;
import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Arqueiro;
import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Robo;
import Model.Strategy.Context__Personagem.Personagem;

import javax.swing.*;
import java.awt.*;



public  class Desenho extends JPanel {

    private Personagem personagem;
    private Personagem[] inimigo;
    private String[] informacoes= new String[4];
    private Image imagem[] = new Image[5];
    private int x[] = new int[4];
    private int y[] = new int [4];

    public Desenho(Personagem personagem, Personagem[] inimigo){
        this.personagem = personagem;
        this.inimigo = inimigo;

        if(personagem instanceof Arqueiro && inimigo[0] instanceof Inimigo && inimigo[1] instanceof Inimigo && inimigo[2] instanceof  Inimigo){
            loadImagem("src/View/Imagens/jogo_medieval.png", 4);
        }else if(personagem instanceof Robo){
            loadImagem("src/View/Imagens/jogo_futurista.png", 4);
        }

    }

    public String toStringInformacoes(Personagem personagem){
        return "Informações do "+ personagem.getClass().getSuperclass().getSuperclass().getSimpleName()
                +" | Nome: "+personagem.getNome()
                +" | Life: "+personagem.getLife()
                +" | Tipo: "+personagem.getClass().getSimpleName()
                +" | Poder de ataque "+personagem.getAtaqueInicial().getDanoAtaque()
                +" | Poder de golpe: "+personagem.getAtaqueInicial().getDanoGolpeTotal()
                +" | Poder de defesa: "+personagem.getEscudoInicial().getLifeEscudoTotalFinal()
                +" | Velocidade: "+personagem.getCorrida().getMove()
                +" | Estado: "+personagem.getPersonagemState().getClass().getSimpleName();


    }

    public void loadInformacoes(){
        this.informacoes[0] = toStringInformacoes(personagem);
        this.informacoes[1] = toStringInformacoes(inimigo[0]);
        this.informacoes[2] = toStringInformacoes(inimigo[1]);
        this.informacoes[3] = toStringInformacoes(inimigo[2]);
    }
    public void loadCoordenadas(){
        this.x[0] = personagem.getCoordenada_x();
        this.x[1] = inimigo[0].getCoordenada_x();
        this.x[2] = inimigo[1].getCoordenada_x();
        this.x[3] = inimigo[2].getCoordenada_x();

        this.y[0] = personagem.getCoordenada_y();
        this.y[1] = inimigo[0].getCoordenada_y();
        this.y[2] = inimigo[1].getCoordenada_y();
        this.y[3] = inimigo[2].getCoordenada_y();
    }
    public void loadImagem(String url, int i){

        ImageIcon ii = null;

        if(personagem instanceof Arqueiro) {
            ii = new ImageIcon(url);
        }else if(personagem instanceof Robo){
            ii = new ImageIcon(url);
        }

        if(ii != null) {
            imagem[i] = ii.getImage();
        }

    }
    public void loadImagens(){
        if(personagem instanceof Arqueiro && inimigo[0] instanceof Inimigo && inimigo[1] instanceof Inimigo && inimigo[2] instanceof  Inimigo){
            loadImagem("src/View/Imagens/personagem_principal_arqueiro.png", 0);
            loadImagem("src/View/Imagens/inimigo_arqueiro_1.png", 1);
            loadImagem("src/View/Imagens/inimigo_arqueiro_2.png", 2);
            loadImagem("src/View/Imagens/inimigo_arqueiro_3.png", 3);
        }else if(personagem instanceof Robo && inimigo[0] instanceof Inimigo && inimigo[1] instanceof Inimigo && inimigo[2] instanceof  Inimigo){
            loadImagem("src/View/Imagens/personagem_principal_robo.png", 0);
            loadImagem("src/View/Imagens/inimigo_robo_1.png", 1);
            loadImagem("src/View/Imagens/inimigo_robo_2.png", 2);
            loadImagem("src/View/Imagens/inimigo_robo_3.png", 3);
        }
    }

    public void paintComponent(Graphics g) {
        g.setFont(new Font("default", Font.BOLD, 12));
        g.setColor(Color.BLUE);

        g.drawImage(imagem[4], 0,0, this);

        g.drawString(informacoes[0], 40, 50);
        g.drawString(informacoes[1], 40, 100);
        g.drawString(informacoes[2], 40, 150);
        g.drawString(informacoes[3], 40, 200);

        g.drawImage(imagem[0], x[0],y[0], this);
        g.drawImage(imagem[1], x[1],y[1], this);
        g.drawImage(imagem[2], x[2],y[2], this);
        g.drawImage(imagem[3], x[3],y[3], this);

    }

    public Desenho desenhar() {

        loadInformacoes();
        loadCoordenadas();
        loadImagens();

        return this;
    }

}
