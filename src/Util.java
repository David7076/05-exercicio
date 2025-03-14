import javax.swing.*;
//import da classe e com * você importa todos os métodos estáticos
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Util {
    private Bilhete[] bilhetes = new Bilhete[5];
    private int index = 0;
    public void menu() {
        String aux = "\nEscolha uma opção: ";
        aux += "\n1. Emitir bilhete";
        aux += "\n2. Carregar bilhete";
        aux += "\n3. Consultar saldo";
        aux += "\n4. Passar na catraca";
        aux += "\n5. Finalizar";
        int opcao;

        while (true) {
            opcao = parseInt(showInputDialog(aux));
            if (opcao == 5)
                break;
            else if (opcao > 5 || opcao < 1)
                showMessageDialog(null, "O número deve estar entre 1 e 5");
            else {
                switch (opcao) {
                    case 1:
                        emitirBilhete();
                        break;
                }
            }
        }
    }

    public void emitirBilhete() {
        String nome = showInputDialog("Nome: ");
        String perfil = showInputDialog("Perfil --> Comum ou Estudante ou Professor");
        long cpf = parseLong(showInputDialog("CPF: "));
        Usuario usuario = new Usuario(nome,cpf, perfil);
        bilhetes[index] = new Bilhete(usuario);
        index++;
    }
}
