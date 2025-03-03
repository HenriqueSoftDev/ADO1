package aula4.ado;

import javax.swing.JOptionPane;

public class Ado1 {

    public static void main(String[] args) {

        int finaliza = 1;
        do {
            Usuario[] lista = new Usuario[3];

            JOptionPane.showInternalMessageDialog(null, "Bem vindo!!");

            Leitura(lista);

            int escolha = Menu();


            switch (escolha) {

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
                case 5:
                    ClassificarSenha(lista);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, ("OBRIGADO POR USAR O SISTEMA!"));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, ("OBRIGADO POR USAR O SISTEMA!"));
            }

            if (escolha != 6){
                String[] opcoes = {"Reiniciar", "Finalizar"};

                finaliza = JOptionPane.showOptionDialog(null,
                        "Escolha uma opção:",
                        "Aviso",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);

                if (finaliza == 1){
                    JOptionPane.showMessageDialog(null, ("OBRIGADO POR USAR O SISTEMA!"));
                }
            }

        }

        while (finaliza == 0);
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

    public static void ClassificarSenha(Usuario[] lista) {
        int tempSenha;
        for (int j = 0; j < lista.length; j++) {
            for (int i = j + 1; i < lista.length; i++) {
                if (Integer.toString(lista[i].senha).compareTo(Integer.toString(lista[j].senha)) < 0) {

                    tempSenha = lista[j].senha;
                    lista[j].senha = lista[i].senha;
                    lista[i].senha = tempSenha;
                }
            }
            JOptionPane.showMessageDialog(null,lista[j].getSenha());
        }
    }

    public static int Menu(){

        String[] opcoes = {"Imprimir", "Buscar Nome", "Buscar Senha", "Classificar por Nome", "Classificar por Senha", "Finalizar"};

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
