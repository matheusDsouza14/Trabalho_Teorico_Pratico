package main.java.org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
public class Estacionamento {
    Scanner input = new Scanner(System.in);
    ArrayList<Veiculo> Veiculos = new ArrayList<>();
    int vagasSobrando;
    public void BemVindo(){
        int totalVagas;
        System.out.println("Bem vindo ao EstacionamentoRegister2000");
        System.out.println("Digite a capacidade do estacionamento: ");
        totalVagas = input.nextInt();
        vagasSobrando = totalVagas;
    }
    private double calculoHoras(LocalTime horaInicial , LocalTime horaFinal){
        long minutosTotais = ChronoUnit.MINUTES.between(horaInicial,horaFinal);
        double valorPriHora = 12.0;
        double valorPorHoraAdicional = 8.0;
        double horasCobradas = Math.floor(minutosTotais/60.0); // Divide os minutos por 60(para calcular hora) e arredonda para cima se der virgula
        double valorTotal = 0;
        if (minutosTotais <= 0) {//Se for menor ou igual a 0 retorna nada
            return 0.0;
        }
        if (horasCobradas == 1) {
            valorTotal = valorPriHora;
        } else {
            valorTotal = valorPorHoraAdicional + ((horasCobradas - 1) * valorPorHoraAdicional); //Calcula o valor da primeira hora mais o resto das horas faltantes multiplicado pro 8
        }
        return valorTotal;
    }
    public void RegistrarEntradaVeiculo(){
        if(vagasSobrando > 0){
            Veiculo novoVeiculo = new Veiculo();
            String horaEntradaString;
            System.out.println("Digite o modelo do veiculo: ");
            novoVeiculo.setModelo(input.next());
            System.out.println("Digite o placa do veiculo: ");
            novoVeiculo.setPlaca(input.next());
            System.out.println("Digite a hora de entrada do veiculo (HH:MM) digite 'agora' para definir como tempo atual: : ");
            if(input.next().equals("agora")){
                novoVeiculo.setHoraDeEntrada(LocalTime.now());
                vagasSobrando--;
            }else{
                horaEntradaString = input.next();
                LocalTime horaEntrada = LocalTime.parse(horaEntradaString); //Coverte para Date Time
                novoVeiculo.setHoraDeEntrada(horaEntrada);
                Veiculos.add(novoVeiculo);
                vagasSobrando--;
                System.out.println("Veiculo cadastrado com sucesso");
            }

        }else{
            System.out.println("Não há vagas");
        }
    }
    public void RegistrarSaidaVeiculo() {
        if(Veiculos.isEmpty()){
            System.out.println("Nenhum veiculo registrado");
        }else{
            String horaSaidaString;
            System.out.println("Digite a placa do veiculo: ");
            String placa = input.next();
            boolean veiculoAchado = false;
            int i;
            for (i = 0; i < Veiculos.size(); i++){
                if(Veiculos.get(i).getPlaca().equals(placa)){
                    veiculoAchado = true;
                }
            }
            if (veiculoAchado == true) {
                System.out.println("Veiculo encontrado com sucesso");
                System.out.println("Digite a hora de saida do veiculo (HH:MM) digite 'agora' para definir como tempo atual: ");
                String horaSaida = input.next();
                if(input.next().equals("agora")){
                    Veiculos.get(i).sethoraDeSaida(LocalTime.now());
                }else{
                    horaSaidaString = input.next();
                    LocalTime horaDSaida = LocalTime.parse(horaSaidaString); //Coverte para Date Time
                    Veiculos.get(i).sethoraDeSaida(horaDSaida);
                    double horasCobradas = Math.floor(ChronoUnit.MINUTES.between(Veiculos.get(i).getHoraDeEntrada(),Veiculos.get(i).gethoraDeSaida())/60.0); // Calcula as horas
                    Veiculos.get(i).setvalorPago(calculoHoras(Veiculos.get(i).getHoraDeEntrada(),Veiculos.get(i).gethoraDeSaida()));
                }
            }else{
                System.out.println("Nenhum veiculo corresponde com a placa");
            }

        }
    }
    public void mostrarVeiculos() {
        if (Veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo encontrado");
        } else {
            for (int i = 0; i < Veiculos.size(); i++) {
                System.out.println("- Veiculo " + (i + 1));
                System.out.println("Placa: " + Veiculos.get(i).getPlaca());
                System.out.println("Modelo: " + Veiculos.get(i).getModelo());
                System.out.println("Hora entrada: " + Veiculos.get(i).getHoraDeEntrada());
                if(Veiculos.get(i).getHoraDeEntrada() != null){
                    System.out.println("Hora saida: " + Veiculos.get(i).gethoraDeSaida());
                }else{
                    System.out.println("Hora de saida: O veiculo ainda está no estacionamento");
                }
            }
        }
    }
    public void quantVagasDisponiveis(){
        System.out.println("Vagas disponiveis: "+ vagasSobrando);
    }
    public void pesquisaVeiculoPlaca(){
        if(Veiculos.isEmpty()){
            System.out.println("Nenhum veiculo encontrado");
        }else{
            for (int i = 0; i < Veiculos.size(); i++) {
                System.out.println("- Veiculo " + (i + 1));
                System.out.println("Placa: " + Veiculos.get(i).getPlaca());
                System.out.println("Modelo: " + Veiculos.get(i).getModelo());
                System.out.println("Hora entrada: " + Veiculos.get(i).getHoraDeEntrada());
                if(Veiculos.get(i).getHoraDeEntrada() != null){
                    System.out.println("Hora saida: " + Veiculos.get(i).gethoraDeSaida());
                }else{
                    System.out.println("Hora de saida: O veiculo ainda está no estacionamento");
                }
            }
        }
    }
    public void RelatorioFaturamento(){

    }
}