package carros;

public class CarroVip extends Carro {

    private static double diaria = 350.00;

    public CarroVip(int codigo, String modelo) {
        super(codigo, modelo);

    }

    @Override
    public double devolver() {
        if (this.isLocado()) {
            this.locado = false;
            numLocados--;
            double valorLocacao = (diaria * getNumDias());
            return valorLocacao;
        } else {
            return 0;
        }
    }
}
