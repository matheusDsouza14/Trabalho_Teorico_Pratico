package main.java.org.example;
import java.time.LocalTime;
public class Veiculo {
    private String placa;
    protected String modelo;
    private LocalTime horaDeEntrada;
    private LocalTime horaDeSaida;
    private double valorPago;
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public LocalTime getHoraDeEntrada() {
        return horaDeEntrada;
    }
    public void setHoraDeEntrada(LocalTime horaDeEntrada) {
        this.horaDeEntrada = horaDeEntrada;
    }
    public LocalTime gethoraDeSaida() {
        return horaDeSaida;
    }
    public void sethoraDeSaida(LocalTime horaSaida) {
        this.horaDeSaida = horaSaida;
    }
    public double getvalorPago() {
        return valorPago;
    }
    public void setvalorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
