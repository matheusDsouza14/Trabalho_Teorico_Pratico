package main.java.org.example;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
public class Estacionamento{
    Scanner input = new Scanner(System.in);
    ArrayList<Veiculo> Veiculo = new ArrayList<Veiculo>();
    int vagasDisponiveis;
    int total_arrecadado;
    int total_veiculos;
    public void quantidadeVeiculos(){

        System.out.println("Digite a quantidade de veiculos: ");
        Veiculo.add();
    }
    public void RegistrarEntradaVeiculo(){
        System.out.println("Digite a placa do veiculo");
        veiculo.setPlaca(input.next());
        System.out.println("Digite o modelo do veiculo");
        veiculo.setModelo(input.next());
        System.out.println("Digite o hora de entrada do veiculo");
        veiculo.setHoraDeEntrada(input.nextInt());
        System.out.println("Digite o minuto de saida do veiculo");
        veiculo.setHoraDeEntrada(input.nextInt());
        System.out.println("Veiculo Registrado");
    }
    public void RegistrarSaidaVeiculo(){

    }
    public void quantVagasDisponiveis(){

    }
    public void veiculosPresentes(){

    }
    public void pesquisaVeiculoPlaca(){

    }
    public void RealtorioFaturamento(){

    }
}
