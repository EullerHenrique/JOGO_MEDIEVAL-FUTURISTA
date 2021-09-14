package Context;

import Concrete_States.S1;
import State.Estado;

public class Automato_Finito {

    private Estado estado;
    private String cadeia;

    public Automato_Finito() {
        this.estado = new S1(this);
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCadeia() {
        return cadeia;
    }
    public void setCadeia(String cadeia) {
        this.cadeia = cadeia;
    }

    public void validar_cadeia(String cadeia){

        this.cadeia = cadeia;

        if(this.getEstado().validar_cadeia()){
            System.out.println("A cadeia de caracteres" + " \" "+ cadeia + " \" " + " é válida!!\n\n");
        }else{
            System.out.println("A cadeia de caracteres" + " \" "+ cadeia + " \" " + " não é válida!!\n\n");
        }

        //Reinicia o automato finito
        setEstado(new S1(this));

    }


}
