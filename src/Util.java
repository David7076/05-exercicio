import javax.swing.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


//import da classe e com * você importa todos os métodos estáticos
import static javax.swing.JOptionPane.*;


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
                    case 2:
                        carregar();
                        break;
                    case 3:
                        consultarSaldo();
                        break;
                    case 4:
                        passarNaCatraca();
                }
            }
        }
    }

    //Método para pesquisar o CPF
    public int pesquisarCPF() {
        long cpf = parseLong(showInputDialog("CPF para consulta: "));
        for (int i = 0; i < index; i++) {
            if(bilhetes[i].usuario.cpf == cpf) {
                return i;
            }
        }
        return -1;
    }

    //Método para emitir bilhete
    public void emitirBilhete() {
        if (index < bilhetes.length) {
            String nome = showInputDialog("Nome: ");
            String perfil = showInputDialog("Perfil --> Comum ou Estudante ou Professor");
            long cpf = parseLong(showInputDialog("CPF: "));
            Usuario usuario = new Usuario(nome, cpf, perfil);
            bilhetes[index] = new Bilhete(usuario);
            index++;
        } else {
            showMessageDialog(null, "Bilhete não emitido");
        }
    }

    //Método para carregar o saldo
    public void carregar() {
        int posicao = pesquisarCPF();
        double valor;
        if (posicao != -1) {
            valor = parseDouble(showInputDialog("Digite o valor do Saldo: "));
            bilhetes[posicao].carregar(valor);
        }
        else {
            showMessageDialog(null,"CPF não encontrado");
        }
    }
    //Método consultar saldo
    public void consultarSaldo() {
        int posicao = pesquisarCPF();
        if (posicao == -1)
            showMessageDialog(null, "Não existe bilhete para esse CPF");
        else
            showMessageDialog(null, "Saldo: " + bilhetes[posicao].Consultarsaldo());
    }

    //Método passar na catraca
    public void passarNaCatraca() {
        int posicao = pesquisarCPF();
        if(posicao == -1)
            showMessageDialog(null, "CPF não encontrado");
        else
            showMessageDialog(null, bilhetes[posicao].passarCatraca());
    }

}
