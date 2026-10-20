package pe.edu.unsch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CuentaBancariaTest {

    @Test
    void retirarConSaldoSuficiente() {

        CuentaBancaria cuenta =
                new CuentaBancaria(1000);

        cuenta.retirar(200);

        assertEquals(800, cuenta.getSaldo());

    }

    @Test
    void retirarConSaldoInsuficiente() {

        CuentaBancaria cuenta = new CuentaBancaria(100);

        cuenta.retirar(500);

        assertEquals(100, cuenta.getSaldo());

    }

    @Test
    void retirarMontoNegativo() {

        CuentaBancaria cuenta = new CuentaBancaria(1000);

        cuenta.retirar(-200);

        assertEquals(1000, cuenta.getSaldo());

    }

    @Test
    void depositarMontoValido() {

        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500);
        assertEquals(1500, cuenta.getSaldo());

    }

    @Test
    void transferirDinero() {

        CuentaBancaria origen =
                new CuentaBancaria(1000);

        CuentaBancaria destino =
                new CuentaBancaria(500);

        origen.transferir(destino, 200);

        assertEquals(800, origen.getSaldo());

        assertEquals(700, destino.getSaldo());

    }

    @Test
    void pagarServicioConSaldoSuficiente() {

        CuentaBancaria cuenta = new CuentaBancaria(500);

        boolean pagado = cuenta.pagarServicio("Luz", 120);

        assertTrue(pagado);
        assertEquals(380, cuenta.getSaldo());

    }

    @Test
    void pagarServicioConSaldoInsuficiente() {

        CuentaBancaria cuenta = new CuentaBancaria(100);

        boolean pagado = cuenta.pagarServicio("Agua", 250);

        assertFalse(pagado);
        assertEquals(100, cuenta.getSaldo());

    }

    @Test
    void pagarServicioConMontoInvalido() {

        CuentaBancaria cuenta = new CuentaBancaria(500);

        boolean pagado = cuenta.pagarServicio("Internet", -50);

        assertFalse(pagado);
        assertEquals(500, cuenta.getSaldo());

    }

    @Test
    void pagarServicioSinNombreDeServicio() {

        CuentaBancaria cuenta = new CuentaBancaria(500);

        assertFalse(cuenta.pagarServicio("  ", 50));
        assertFalse(cuenta.pagarServicio(null, 50));
        assertEquals(500, cuenta.getSaldo());

    }

}
