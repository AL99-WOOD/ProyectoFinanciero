package pe.edu.unsch;

public class CuentaBancaria {

    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }

    public void transferir(
            CuentaBancaria destino,
            double monto) {

        if (monto > 0 && monto <= saldo) {

            this.saldo -= monto;

            destino.depositar(monto);

        }

    }

    public boolean pagarServicio(String servicio, double monto) {

        if (servicio == null || servicio.isBlank()) {
            return false;
        }

        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }

        return false;
    }

    public double getSaldo() {
        return saldo;
    }
}
