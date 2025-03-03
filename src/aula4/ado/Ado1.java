package aula4.ado;

import javax.swing.JOptionPane;

public class Ado1 {

    public static void main(String[] args) {

        Usuario[] lista = new Usuario[3];

        JOptionPane.showInternalMessageDialog(null, "Bem vindo!!");

        Leitura(lista);

        int escolha = Menu();


        switch(escolha){

            case 1:
                Imprimir(lista);
                break;
            case 2:
                BuscaNome(lista);
                break;
            case 3:
                BuscaSenha(lista);
                break;
            case 4:
                ClassificarNome(lista);
                break;

        }


    }

    public static Usuario[] Leitura(Usuario[] lista) {

        //Laço para preencher o vetor
        for (int i = 0; i < lista.length; i++) {

            //Instanciando um objeto Usuario em cada posição
            lista[i] = new Usuario();

            //Solicitando o nome do usuario
            String nome = JOptionPane.showInputDialog(null, "Digite o nome");
            lista[i].setNome(nome);

            //Solicitando a senha do usuario
            int senha = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a senha"));
            lista[i].setSenha(senha);

        }
        return lista;
    }

    public static void Imprimir(Usuario[] lista) {

        for (int i = 0; i < lista.length; i++) {

            JOptionPane.showMessageDialog(null, "Nome: " + lista[i].getNome() + " Senha: " + lista[i].getSenha());

        }

    }

    public static void BuscaNome(Usuario[] lista) {

        String nome = JOptionPane.showInputDialog(null, "Insira o nome da busca");

        for (int i = 0; i < lista.length; i++) {

            if (nome.equals(lista[i].getNome())) {

                JOptionPane.showMessageDialog(null, lista[i].nome + " na posição " + (i+1) + " da lista");

            }

        }

    }

    public static void BuscaSenha(Usuario[] lista) {

        int senha = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a senha da busca"));

        for (int i = 0; i < lista.length; i++) {

            if (senha == lista[i].senha) {

                JOptionPane.showMessageDialog(null, lista[i].senha+" na posição "+(i+1)+" da lista");

            }

        }

    }

    public static void ClassificarNome(Usuario[] lista) {
        String tempNome;
        for (int j = 0; j < lista.length; j++) {
            for (int i = j + 1; i < lista.length; i++) {
                if (lista[i].getNome().compareTo(lista[j].getNome()) < 0) {

                    tempNome = lista[j].getNome();
                    lista[j].setNome(lista[i].getNome());
                    lista[i].setNome(tempNome);
                }
            }
            JOptionPane.showMessageDialog(null, lista[j].getNome());
        }
    }
    public static int Menu(){

        String[] opcoes = {"Imprimir", "Buscar Nome", "Buscar Senha", "Classificar por Nome"};

        int escolha = JOptionPane.showOptionDialog(null,
                "Escolha uma opção:",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);



        return escolha+1;

    }

}
