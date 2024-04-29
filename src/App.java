import modelos.ConsultaCep;
import modelos.Endereco;

public class App {
    public static void main(String[] args) {

        ConsultaCep consultaCep = new ConsultaCep();
        Endereco novoEndereco = consultaCep.buscaEndereco("01001-022");
        System.out.println(novoEndereco);
    }
}
