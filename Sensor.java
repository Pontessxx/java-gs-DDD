package br.com.fiap.bean;

public class Sensor {
    private int id;
    private String nome;
    private double latitude;
    private double longitude;
    private double valor;

    public Sensor(int id, String nome, double latitude, double longitude, double valor) {
        this.id = id;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.valor = valor;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", valor=" + valor +
                '}';
    }

    // Métodos Operacionais

    /**
     * Método que calcula a distância a partir de outro sensor.
     * @param outroSensor Outro objeto Sensor para calcular a distância.
     * @return Distância entre os sensores.
     */
    public double calcularDistancia(Sensor outroSensor) {
        double latDiff = Math.toRadians(this.latitude - outroSensor.latitude);
        double lonDiff = Math.toRadians(this.longitude - outroSensor.longitude);
        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2) +
                   Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(outroSensor.latitude)) *
                   Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double R = 6371; // Raio da Terra em km
        return R * c;
    }

    /**
     * Método que verifica se o valor do sensor está acima de um limite.
     * @param limite Limite a ser verificado.
     * @return True se o valor do sensor estiver acima do limite, False caso contrário.
     */
    public boolean valorAcimaDe(double limite) {
        return this.valor > limite;
    }

    /**
     * Método que atualiza o valor do sensor, com sobrecarga para aceitar diferentes tipos de entrada.
     * @param valor Novo valor do sensor.
     */
    public void atualizarValor(double valor) {
        this.valor = valor;
    }

    /**
     * Método que atualiza o valor do sensor a partir de uma string.
     * @param valorString Novo valor do sensor em formato string.
     */
    public void atualizarValor(String valorString) {
        try {
            double valor = Double.parseDouble(valorString);
            this.valor = valor;
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. O valor deve ser um número.");
        }
    }
}
