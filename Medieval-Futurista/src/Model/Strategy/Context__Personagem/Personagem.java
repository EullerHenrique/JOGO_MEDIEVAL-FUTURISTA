package Model.Strategy.Context__Personagem;


import Model.Chain_Of_Responsability.Handler.Escudo;
import Model.State.State_Personagem_State.PersonagemState;
import Model.Strategy.Strategy_1_Pulo.Pulo;
import Model.Strategy.Strategy_2_Corrida.Corrida;
import Model.Strategy.Strategy_3_Ataque.Ataque;
import View.View_Personagem;

import java.util.Random;

public abstract class Personagem {
    private final String nome;
    private int life;
    private int lifeMaxima;

    private int coordenada_x;
    private int coordenada_y;


    private int coordenada_x_maxima;
    private int coordenada_y_maxima;

    private PersonagemState personagemStateInicial;
    private Ataque ataqueInicial;
    private Escudo escudoInicial;


    private Pulo pulo;
    private Corrida corrida;
    private Ataque ataque;
    private Escudo escudo;
    private PersonagemState personagemState;

    private View_Personagem viewPersonagem;


    public Personagem(String nome) {
        this.nome = nome;
        this.coordenada_x_maxima = 1000;
        this.coordenada_y_maxima = 500;
        this.lifeMaxima = 100;
        this.viewPersonagem = new View_Personagem(this);

        GerarLife();
        GerarCoordenadas();

    }

    public String getNome() {
        return nome;
    }

    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        if(life > 0) {
            this.life = Math.min(life, lifeMaxima);
        }else{
            this.life = 0;
        }

        if(getPersonagemState() != null){
            getPersonagemState().verificarAlteracaoEstado();
        }
    }

    public int getLifeMaxima() {
        return lifeMaxima;
    }
    public void setLifeMaxima(int lifeMaxima) {
        this.lifeMaxima = lifeMaxima;
        GerarLife();
    }

    public abstract void GerarLife();

    public void GerarCoordenadas(){

        Random random = new Random();
        this.coordenada_x = random.nextInt(coordenada_x_maxima);
        this.coordenada_y = random.nextInt(coordenada_y_maxima);

    }


    public void setCoordenadasMaximas(int coordenada_x_maxima, int coordenada_y_maxima){
        this.coordenada_x_maxima = coordenada_x_maxima;
        this.coordenada_y_maxima = coordenada_y_maxima;
        GerarCoordenadas();
    }

    public int getCoordenada_x() {
        return coordenada_x;
    }
    public void setCoordenada_x(int coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public int getCoordenada_y() {
        return coordenada_y;
    }
    public void setCoordenada_y(int coordenada_y) {
        this.coordenada_y = coordenada_y;
    }

    public PersonagemState getPersonagemStateInicial() {
        return personagemStateInicial;
    }

    public Ataque getAtaqueInicial() {
        return ataqueInicial;
    }
    public void setAtaqueInicial(Ataque ataqueInicial) {
        this.ataqueInicial = ataqueInicial;
    }

    public Escudo getEscudoInicial() {
        return escudoInicial;
    }

    public void setPulo(Pulo pulo) {
        this.pulo = pulo;
    }
    public Pulo getPulo() {
        return pulo;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }
    public Corrida getCorrida() {
        return corrida;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }
    public Ataque getAtaque() {
        return ataque;
    }

    public Escudo getEscudo() {
        return escudo;
    }
    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;

        if(escudoInicial == null){
            escudoInicial = escudo;
        }

        if(escudo == null){
            escudoInicial = null;
        }

    }

    public PersonagemState getPersonagemState() {
        return personagemState;
    }
    public void setPersonagemState(PersonagemState personagemState) {
        this.personagemState = personagemState;

        if(personagemStateInicial == null){
            personagemStateInicial = personagemState;
        }
    }

    public View_Personagem getViewPersonagem() {
        return viewPersonagem;
    }

    public void pular(){
        pulo.pular();
    }

    public void correr(String direcao){
        corrida.correr(direcao);
    }

    public void atacar(Personagem atacado){
        if (atacado.getEscudo() == null) {
            getAtaque().atacar(atacado);
        } else {
            atacado.getEscudo().atacar(this, atacado);
        }
    }

}
