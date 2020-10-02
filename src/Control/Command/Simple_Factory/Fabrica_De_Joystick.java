package Control.Command.Simple_Factory;


import Control.Command.Concrete_Comands.*;
import Control.Command.Control.Joystick;
import Control.Command.Macro.Macro;
import Model.Strategy.Context__Personagem.Personagem;

public class Fabrica_De_Joystick {

    public static Joystick criarJoystick(Personagem personagem, Personagem[] inimigo){

        Joystick joystick = new Joystick();

        joystick.setCommand(new MoverEsquerda(personagem));
        joystick.setCommand(new MoverDireita(personagem));
        joystick.setCommand(new MoverCima(personagem));
        joystick.setCommand(new MoverBaixo(personagem));

        joystick.setCommand(new Atacar(personagem, inimigo[0]));
        joystick.setCommand(new Atacar(personagem, inimigo[1]));
        joystick.setCommand(new Atacar(personagem, inimigo[2]));

        joystick.setCommand(new Magia(personagem, inimigo[0]));
        joystick.setCommand(new Magia(personagem, inimigo[1]));
        joystick.setCommand(new Magia(personagem, inimigo[2]));


        Macro macroL = new Macro();
        macroL.add(new MoverEsquerda(personagem));
        macroL.add(new MoverEsquerda(personagem));
        macroL.add(new MoverEsquerda(personagem));
        macroL.add(new MoverEsquerda(personagem));
        macroL.add(new MoverEsquerda(personagem));
        macroL.add(new MoverEsquerda(personagem));


        Macro macroR = new Macro();
        macroR.add(new MoverDireita(personagem));
        macroR.add(new MoverDireita(personagem));
        macroR.add(new MoverDireita(personagem));
        macroR.add(new MoverDireita(personagem));
        macroR.add(new MoverDireita(personagem));
        macroR.add(new MoverDireita(personagem));

        joystick.setMacroL(macroL);
        joystick.setMacroR(macroR);

        return joystick;

    }

}
