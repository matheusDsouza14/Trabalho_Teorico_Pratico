package main.java.org.example;
public class Veiculo {
    private String placa;
    protected String modelo;
    private int horaDeEntrada;
    private int horaDeSaida;
    private int minutoDeEntrada;
    private int minutoDeSaida;
    public Veiculo() {
        this.placa = null;
        this.modelo = null;
        this.horaDeEntrada = 0;
        this.horaDeSaida = 0;
        this.minutoDeEntrada = 0;
        this.minutoDeSaida = 0;
    }
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
    public int getHoraDeEntrada() {
        return horaDeEntrada;
    }
    public void setHoraDeEntrada(int horaDeEntrada) {
        this.horaDeEntrada = horaDeEntrada;
    }
    public int getHoraDeSaida() {
        return horaDeSaida;
    }
    public void setHoraDeSaida(int horaDeSaida) {
        this.horaDeSaida = horaDeSaida;
    }
    public int getMinutoDeEntrada() {
        return minutoDeEntrada;
    }
    public void setMinutoDeEntrada(int minutoDeEntrada) {
        this.minutoDeEntrada = minutoDeEntrada;
    }

    public int getMinutoDeSaida() {
        return minutoDeSaida;
    }
    public void setMinutoDeSaida(int minutoDeSaida) {
        this.minutoDeSaida = minutoDeSaida;
    }
}
