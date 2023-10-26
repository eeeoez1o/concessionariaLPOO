package carros;

public class Carro {
    int codigo;
    String modelo;
    boolean locado;
    int numDias;

    public static int numLocados = 0;
    private static double diaria = 200.00;

    public Carro(int codigo, String modelo) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.locado = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isLocado() {
        return locado;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public static int getNumLocados() {
        return numLocados;
    }

    public static double getDiaria() {
        return diaria;
    }

    @Override
    public String toString() {
        return "Carro [codigo=" + codigo + ", modelo=" + modelo + ", locado=" + locado + ", numDias=" + numDias + "]";
    }

    public boolean locar(int numDias) {
        if (!this.isLocado()) {
            locado = true;
            this.setNumDias(numDias);
            numLocados++;
            return true;
        } else {
            return false;
        }
    }

    public double devolver() {
        if (this.isLocado()) {
            this.locado = false;
            numLocados--;
            return this.getNumDias() * diaria;
        } else {
            return 0;
        }
    }

}
