package main.java.org.example;
import java.util.Scanner;
public class Main {
    static void main(String[] args){
        int escolha = Integer.MAX_VALUE;
        Estacionamento Estacionamento = new Estacionamento();
        Scanner input = new Scanner(System.in);
        Estacionamento.BemVindo();
        do {
            System.out.println("1 - Registrar entrada de veiculo");
            System.out.println("2 - Registrar saída de veículo");
            System.out.println("3 - Mostrar quantidade de vagas disponíveis");
            System.out.println("4 - Mostrar todos os veículos presentes");
            System.out.println("5 - Pesquisar veículo por placa");
            System.out.println("6 - Relatório de faturamento");
            System.out.println("0 - Sair");
            escolha  = input.nextInt();
            switch(escolha){
                case 1:
                    System.out.println("Registrar entrada de veiculo");
                    Estacionamento.RegistrarEntradaVeiculo();
                    System.out.println("-----------------------------------------------");
                    break;
                case 2:
                    System.out.println("Registrar saída de veículo");
                    Estacionamento.RegistrarSaidaVeiculo();
                    System.out.println("-----------------------------------------------");
                    break;
                case 3:
                    System.out.println("Mostrar quantidade de vagas disponíveis");
                    Estacionamento.quantVagasDisponiveis();
                    System.out.println("-----------------------------------------------");
                    break;
                case 4:
                    System.out.println("Mostrar todos os veículos presentes");
                    Estacionamento.mostrarVeiculos();
                    System.out.println("-----------------------------------------------");
                    break;
                case 5:
                    System.out.println("Pesquisar veículo por placa");
                    Estacionamento.pesquisaVeiculoPlaca();
                    System.out.println("-----------------------------------------------");
                    break;
                case 6:
                    System.out.println("Relatório de faturamento");
                    Estacionamento.RelatorioFaturamento();
                    System.out.println("-----------------------------------------------");
                    break;
            }
        }while (escolha != 0);
        System.out.println("Fim");
    }
}
