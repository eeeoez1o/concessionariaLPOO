import java.util.ArrayList;
import carros.Carro;
import carros.CarroVip;
import io.InOut;

public class Concessionaria {
    private static ArrayList<Carro> carros = new ArrayList<Carro>();

    public static void main(String[] args) throws Exception {
        int opcao;
        do {

            opcao = InOut.leInt("1 - Cadastrar \n2 - Alugar \n3 - Devolver \n4 - Sair");

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    alugar();
                    break;
                case 3:
                    devolver();
                    break;
                case 4:
                    InOut.msgDeInformacao("Concessionaria", "Saindo...");
                    break;
                default:
                    InOut.msgDeAviso("Concessionaria", "Opção invalida, tente novamente");
            }

        } while (opcao != 4);
    }

    public static void cadastrar() {

        int codigoCarro = InOut.leInt("Digite o codigo do novo carro: ");

        if (pesquisa(codigoCarro) != -1) {
            InOut.msgDeAviso("Cadastrar", "Carro com codigo " + codigoCarro + " ja esta cadastrado");
        } else {

            int tipoCarro = InOut.leInt("Digite [1] para cadastrar um carro comum e [2] para um carro vip");

            if (tipoCarro == 1) {
                String modelo = InOut.leString("Digite o modelo do carro: ");

                Carro carro = new Carro(codigoCarro, modelo);

                carros.add(carro);
                InOut.msgDeInformacao("Cadastrar", "Carro cadastrado com sucesso!");

            } else if (tipoCarro == 2) {
                String modelo = InOut.leString("Digite o modelo do carro: ");

                Carro carro = new CarroVip(codigoCarro, modelo);

                carros.add(carro);
                InOut.msgDeInformacao("Cadastrar", "Carro cadastrado com sucesso!");

            } else {
                InOut.msgDeAviso("Cadastrar", "Opção invalida");

            }
        }
    }

    public static void alugar() {

        int codigoCarro = InOut.leInt("Digite o codigo do carro que deseja alugar");

        int posicaoCarro = pesquisa(codigoCarro);

        if (pesquisa(codigoCarro) == -1) {
            InOut.msgDeAviso("Alugar", "Carro nao esta cadastrado");
        } else {

            Carro carroCadastrado = carros.get(posicaoCarro);

            if (carroCadastrado.isLocado()) {
                InOut.msgDeAviso("Alugar", "Carro ja esta locado");
            } else {
                int numDias = InOut.leInt("Digite o numero de dias que pretende locar o carro: ");
                carroCadastrado.locar(numDias);

                InOut.msgDeInformacao("Alugar", "Carro alugado com sucesso");

            }
        }

    }

    public static void devolver() {
        int codigoCarro = InOut.leInt("Digite o codigo do carro que deseja devolver: ");
        int posicaoCarro = pesquisa(codigoCarro);

        Carro carroCadastrado = carros.get(posicaoCarro);

        if (carroCadastrado.isLocado()) {
            carroCadastrado.devolver();
            double devolucao = carroCadastrado.devolver();
            InOut.msgDeInformacao("Alugar", "Carro " + carroCadastrado.getModelo() + " Devolvido, valor a pagar: R$ "
                    + devolucao);
        } else {
            if (pesquisa(codigoCarro) == -1) {
                InOut.msgDeAviso("Devolver", "Este carro nao existe");
            } else {
                InOut.msgDeAviso("Devolver", "Carro nao esta locado");

            }
        }

    }

    public static int pesquisa(int codigo) {

        int i = 0;

        for (Carro carro : carros) {
            if (carro.getCodigo() == codigo) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
