package main.java.org.example;
import java.util.Scanner;
import java.util.ArrayList;
public class Estacionamento{
    Scanner input = new Scanner(System.in);
    ArrayList<Veiculo> Veiculos = new ArrayList<>();
    Veiculo novoVeiculo = new Veiculo();
    int totalVagas;
    int vagasTotais;
    int totalArrecadado;
    public void BemVindo(){
        int limiteEstacionamento = 0;
        System.out.println("Bem vindo ao EstacionamentoRegister2000");
        System.out.println("Digite a capacidade do estacionamento: ");
        limiteEstacionamento = input.nextInt();
        vagasTotais = limiteEstacionamento;
    }
    public void RegistrarEntradaVeiculo(){
        if(vagasTotais > 0){
            System.out.println("Digite o modelo do veiculo: ");
            novoVeiculo.setModelo(input.next());
            System.out.println("Digite o placa do veiculo: ");
            novoVeiculo.setPlaca(input.next());
            System.out.println("Digite a hora de entrda do veiculo: ");
            novoVeiculo.setHoraDeEntrada(input.nextInt());
            System.out.println("Digite o minuto de entrada do veiculo: ");
            novoVeiculo.setMinutoDeEntrada(input.nextInt());
            Veiculos.add(novoVeiculo);
            System.out.println("Veiculo cadastrado com sucesso");
            vagasTotais--;
        }else{
            System.out.println("Não há vagas");
        }

    }
    public void RegistrarSaidaVeiculo(){

    }
    public void quantVagasDisponiveis(){

    }
    public void veiculosPresentes(){

    }
    public void pesquisaVeiculoPlaca(){

    }
    public void lerVeiculos(){
        if(Veiculos.isEmpty()){
            System.out.println("Nenhum veiculo encontrado");
        }else{
            for(int i = 0; i < vagasTotais; i++){
                System.out.println("- Veiculo " + (i));
                System.out.println("Placa: "+Veiculos.get(i).getPlaca());
                System.out.println("Modelo: "+Veiculos.get(i).getModelo());
                System.out.println("Hora entrada: "+Veiculos.get(i).getHoraDeEntrada()+":"+Veiculos.get(i).getMinutoDeEntrada());
                if (Veiculos.get(i).getHoraDeSaida()!=0 && Veiculos.get(i).getMinutoDeSaida()!=0){
                    System.out.println("Hora de saida: "+Veiculos.get(i).getPlaca()+":"+Veiculos.get(i).getMinutoDeSaida());
                }else{
                    System.out.println("Hora de saida: O veiculo ainda está no estacionamento");
                }
            }
        }
    }
    public void RealtorioFaturamento(){

    }
}
