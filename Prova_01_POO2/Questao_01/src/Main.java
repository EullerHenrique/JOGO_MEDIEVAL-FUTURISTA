import Client.Usuario;
import Interface.Inter;

import javax.swing.*;

public class Main extends JFrame{

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        Inter inter = new Inter(usuario);
        inter.JanelaPrincipal();
    }
}