package State;

import Context.Automato_Finito;

public abstract class Estado {

    private Automato_Finito automato_finito;

    public Estado(Automato_Finito automato_finito) {
        this.automato_finito = automato_finito;
    }

    public Automato_Finito getAutomato_finito() {
        return automato_finito;
    }
    public void setAutomato_finito(Automato_Finito automato_finito) {
        this.automato_finito = automato_finito;
    }


    public abstract boolean validar_cadeia();

    public void show(){
        System.out.println(getAutomato_finito().getEstado().getClass().getSimpleName()+"\n");
        System.out.println("|\n"+getAutomato_finito().getCadeia().charAt(0)+"\nV\n");
    }

}
