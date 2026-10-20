package pe.edu.unsch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaBancariaTest {

    @Test
    void depositoDebeIncrementarSaldo() {

        CuentaBancaria cuenta = new CuentaBancaria(100);

        cuenta.depositar(50);

        assertEquals(150, cuenta.obtenerSaldo());
    }

    @Test
    void retiroDebeDisminuirSaldo() {

        CuentaBancaria cuenta = new CuentaBancaria(100);

        cuenta.retirar(30);

        assertEquals(70, cuenta.obtenerSaldo());
    }
}
