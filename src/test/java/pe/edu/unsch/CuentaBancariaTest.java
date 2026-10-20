package pe.edu.unsch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaBancariaTest {

    @Test
    void retirarConSaldoSuficiente() {

        CuentaBancaria cuenta =
                new CuentaBancaria(1000);

        cuenta.retirar(200);

        assertEquals(800, cuenta.getSaldo());

    }

}
