package Interface;

import Client.Usuario;

import javax.swing.*;

public class Inter {

    private Usuario usuario;

    public Inter(Usuario usuario) {
        this.usuario = usuario;
    }

    public void JanelaPrincipal(){

        while (true) {

            Object[] options = {"Ordem de venda", "Ordem de compra"};
            String mensagem;

            int result = JOptionPane.showOptionDialog(null, "Olá!\n\nVoçê possui: " + "  "+usuario.getQtd() + " ações \n" +
                          "\n\n Voçê deseja cadastrar uma ordem de venda ou uma ordem de compra?\n\n",
                    "Mercado de ações", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                    null);

            if (result == 0) {

                mensagem = "Insira o código da ação que será colocada a venda";
                String codigo = inputString(mensagem);

                mensagem ="Insira quantas ações serão colocadas a venda";
                int qtd =  inputInt(mensagem);

                mensagem = "Insira o preço de cada ação que será colocada a venda";
                float preco = inputFloat(mensagem);

                if(usuario.vender(codigo, qtd, preco)) {
                    JOptionPane.showMessageDialog(null, "Ordem de venda cadastrada com sucesso!\n\n" +
                                    "Detalhes da venda: \n\n Código: " + codigo + "\n Quantidade: " + qtd + "\n Preço: " + preco, "Mercado de ações",
                            JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "Ordem de venda recusada, tente novamente!","Mercado de ações",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else if(result == 1){

                mensagem = "Insira o código da ação que será comprada";
                String codigo = inputString(mensagem);

                mensagem = "Insira quantas ações serão compradas";
                int qtd =  inputInt(mensagem);

                mensagem = "Insira o preço de cada ação que será comprada";
                float preco = inputFloat(mensagem);

                if(usuario.comprar(codigo, qtd, preco)){
                    JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!\n Agora voçe tem: "+usuario.getQtd()+" ação (es) ", "Mercado de ações",
                            JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Compra recusada, tente novamente! \n\n Opções de ações disponíveis: \n\n" + usuario.listar_acoes(), "Mercado de ações",
                            JOptionPane.ERROR_MESSAGE);
                }

            }else{
                System.exit(0);
            }
        }
    }


    public String inputString(String mensagem){

        String string = JOptionPane.showInputDialog(null, mensagem, "Mercado de ações", JOptionPane.QUESTION_MESSAGE);
        if(string == null){
            JanelaPrincipal();
        }

        return string;
    }


    public int inputInt(String mensagem){
        String string = JOptionPane.showInputDialog(null, mensagem, "Mercado de ações", JOptionPane.QUESTION_MESSAGE);
        int numero;

        if(string == null){
            JanelaPrincipal();
        }

        while(true) {
            try {
                numero = Integer.parseInt(string);
                break;
            } catch (NumberFormatException e) {
                string = JOptionPane.showInputDialog(null, mensagem, "Mercado de ações", JOptionPane.QUESTION_MESSAGE);
                if(string == null){
                    JanelaPrincipal();
                }
            }
        }
        return numero;
    }

    public float inputFloat(String mensagem){
        String string = JOptionPane.showInputDialog(null, mensagem, "Mercado de ações", JOptionPane.QUESTION_MESSAGE);
        float numero;

        if(string == null){
            JanelaPrincipal();
        }

        while(true) {
            try {
                numero = Float.parseFloat(string);
                break;
            } catch (NumberFormatException e) {
                string = JOptionPane.showInputDialog(null, mensagem, "Mercado de ações", JOptionPane.QUESTION_MESSAGE);
                if(string == null){
                    JanelaPrincipal();
                }
            }
        }
        return numero;
    }
}
