package main.java.org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
public class Estacionamento {
    Scanner input = new Scanner(System.in);
    ArrayList<Veiculo> Veiculos = new ArrayList<>();
    int vagasSobrando;
    DateTimeFormatter formatar = DateTimeFormatter.ofPattern("HH:mm");
    public void BemVindo() {
        int totalVagas;
        System.out.println("Bem vindo ao EstacionamentoRegister2000");
        System.out.println("Digite a capacidade do estacionamento: ");
        totalVagas = input.nextInt();
        vagasSobrando = totalVagas;
    }
    private double calculoHoras(LocalTime horaInicial, LocalTime horaFinal) {
        long minutosTotais = ChronoUnit.MINUTES.between(horaInicial, horaFinal);// Calcula a duração em minutos
        double valorPriHora = 12.0;
        double valorPorHoraAdicional = 8.0;
        double horasCobradas = Math.ceil(minutosTotais / 60.0); // Divide os minutos por 60(para calcular hora) e arredonda para cima se der virgula
        double valorTotal;
        if (minutosTotais <= 0) {//Se for menor ou igual a 0 retorna nada
            return 0.0;
        }
        if (horasCobradas == 1) {
            valorTotal = valorPriHora;
        } else {
            valorTotal = valorPriHora + ((horasCobradas - 1) * valorPorHoraAdicional); //Calcula o valor da primeira hora mais o resto das horas faltantes multiplicado por 8
        }
        return valorTotal;
    }
    public void RegistrarEntradaVeiculo() {
        if (vagasSobrando > 0) {
            Veiculo novoVeiculo = new Veiculo();
            System.out.println("Digite o modelo do veiculo: ");
            novoVeiculo.setModelo(input.next());
            System.out.println("Digite o placa do veiculo: ");
            novoVeiculo.setPlaca(input.next());
            System.out.println("Digite a hora de entrada do veiculo (HH:MM) digite 'agora' para definir como tempo atual: ");
            String horaEntradaString = input.next();
            if (horaEntradaString.equalsIgnoreCase("agora")) {
                novoVeiculo.setHoraDeEntrada(LocalTime.now());
                Veiculos.add(novoVeiculo);
                vagasSobrando--;
                System.out.println("Veiculo cadastrado com sucesso");
            } else {
                LocalTime horaEntrada = LocalTime.parse(horaEntradaString); //Coverte para Date Time
                novoVeiculo.setHoraDeEntrada(horaEntrada);
                Veiculos.add(novoVeiculo);
                vagasSobrando--;
                System.out.println("Veiculo cadastrado com sucesso");
            }

        } else {
            System.out.println("Não há vagas");
        }
    }
    public void RegistrarSaidaVeiculo() {
        if (Veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo registrado");
        } else {
            System.out.println("Digite a placa do veiculo: ");
            String placa = input.next();
            boolean veiculoAchado = false;
            for (int i = 0; i < Veiculos.size(); i++) {
                if (Veiculos.get(i).getPlaca().equals(placa)) {
                    veiculoAchado = true;
                }
                if (veiculoAchado == true) {
                    System.out.println("Veiculo encontrado com sucesso");
                    System.out.println("Digite a hora de saida do veiculo (HH:MM) digite 'agora' para definir como tempo atual: ");
                    String horaSaidaString = input.next();
                    if (horaSaidaString.equalsIgnoreCase("agora")) {
                        Veiculos.get(i).sethoraDeSaida(LocalTime.now());
                    } else {
                        LocalTime horaDSaida = LocalTime.parse(horaSaidaString); //Coverte para Date Time
                        Veiculos.get(i).sethoraDeSaida(horaDSaida);
                        double minutosCobrados = ChronoUnit.MINUTES.between(Veiculos.get(i).getHoraDeEntrada(), Veiculos.get(i).gethoraDeSaida());
                        double horasCobradas = Math.ceil(minutosCobrados / 60.0); // Divide os minutos por 60(para calcular hora) e arredonda para cima se der virgula
                        System.out.println("O veiculo ficou " + (int) minutosCobrados + " minutos no estacionamento e pagará por " + (int) horasCobradas + " horas");
                        Veiculos.get(i).setvalorPago(calculoHoras(Veiculos.get(i).getHoraDeEntrada(), Veiculos.get(i).gethoraDeSaida()));
                    }
                }
                if (!veiculoAchado) {
                    System.out.println("Nenhum veiculo corresponde com a placa");
                }
            }
        }
    }
    public void mostrarVeiculos () {
        if (Veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo encontrado");
        } else {
            for (int i = 0; i < Veiculos.size(); i++) {
                System.out.println("-----------------------------------------------");
                System.out.println("- Veiculo " + (i + 1));
                System.out.println("Placa: " + Veiculos.get(i).getPlaca());
                System.out.println("Modelo: " + Veiculos.get(i).getModelo());
                System.out.println("Hora entrada: " + Veiculos.get(i).getHoraDeEntrada().format(formatar)); //Pega a hora de saida do item relativo numero do indice indice pega as horas e formata automaticamente para o padrão Hora:Minuto
                if (Veiculos.get(i).gethoraDeSaida() != null) {
                    System.out.println("Hora saida: " + Veiculos.get(i).gethoraDeSaida().format(formatar));//Pega a hora de saida do item relativo numero do indice indice pega as horas e formata automaticamente para o padrão Hora:Minuto
                } else {
                    System.out.println("Hora de saida: O veiculo ainda está no estacionamento");
                }
                System.out.println("Valor a pagar: R$" + Veiculos.get(i).getvalorPago());
                System.out.println("-----------------------------------------------");
            }
        }
    }
    public void quantVagasDisponiveis () {
        System.out.println("Vagas disponiveis: " + vagasSobrando);
    }
    public void pesquisaVeiculoPlaca () {
        boolean veiculoAchado = false;
        if (Veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo cadastrado");
        } else {
            System.out.println("Digite a placa do veiculo: ");
            String placa = input.next();
            for (int i = 0; i < Veiculos.size(); i++) {
                if (Veiculos.get(i).getPlaca().equals(placa)) {
                    veiculoAchado = true;
                }
                if (veiculoAchado == true) {
                    System.out.println("- Veiculo " + (i + 1));
                    System.out.println("Placa: " + Veiculos.get(i).getPlaca());
                    System.out.println("Modelo: " + Veiculos.get(i).getModelo());
                    System.out.println("Hora entrada: " + Veiculos.get(i).getHoraDeEntrada().format(formatar));//Pega a hora de saida do item relativo numero do indice indice pega as horas e formata automaticamente para o padrão Hora:Minuto
                    if (Veiculos.get(i).gethoraDeSaida() != null) {
                        System.out.println("Hora saida: " + Veiculos.get(i).gethoraDeSaida().format(formatar));//Pega a hora de saida do item relativo numero do indice indice pega as horas e formata automaticamente para o padrão Hora:Minuto
                    } else {
                        System.out.println("Hora de saida: O veiculo ainda está no estacionamento");
                    }
                    System.out.println("Valor a pagar: R$" + Veiculos.get(i).getvalorPago());
                }
            }
            if (veiculoAchado = false) {
                System.out.println("Nenhum veiculo corresponde com a placa");
            }
        }
    }
    public void RelatorioFaturamento () {
        double faturamento = 0;
        for (int i = 0; i < Veiculos.size(); i++) {
            faturamento += Veiculos.get(i).getvalorPago();
        }
        System.out.println("Quantidades de carros: " + Veiculos.size());
        System.out.println("Faturamento: R$" + faturamento);
    }
}