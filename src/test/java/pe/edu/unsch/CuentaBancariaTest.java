package pe.edu.unsch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CuentaBancariaTest {

    @Test
    void retirarConSaldoSuficiente() {

        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000);
        cuentaBancaria.retirar(200);
        assertEquals(800, cuentaBancaria.getSaldo());
    }

    @Test
    void retirarConSaldoInsuficiente() {

        CuentaBancaria cuentaBancaria = new CuentaBancaria(100);
        cuentaBancaria.retirar(500);
        assertEquals(100, cuentaBancaria.getSaldo());
    }

    @Test
    void retirarMontoNegativo() {

        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000);
        cuentaBancaria.retirar(-200);
        assertEquals(1000, cuentaBancaria.getSaldo());
    }

    @Test
    void depositarMontoValido() {

        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000);
        cuentaBancaria.depositar(500);
        assertEquals(1500, cuentaBancaria.getSaldo());
    }

    @Test
    void transferirDinero() {

        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000);
        CuentaBancaria destino = new CuentaBancaria(500);
        cuentaBancaria.transferir(destino, 200);
        assertEquals(800, cuentaBancaria.getSaldo());
        assertEquals(700, destino.getSaldo());
    }

    @Test
    void depositarMontoValidoRetornaTrue() {

        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000);
        assertTrue(cuentaBancaria.depositar(250));
        assertEquals(1250, cuentaBancaria.getSaldo());
    }

    @Test
    void depositarMontoNegativoNoModificaSaldo() {

        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000);
        assertFalse(cuentaBancaria.depositar(-100));
        assertEquals(1000, cuentaBancaria.getSaldo());
    }

    @Test
    void depositarMontoCeroNoModificaSaldo() {

        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000);
        assertFalse(cuentaBancaria.depositar(0));
        assertEquals(1000, cuentaBancaria.getSaldo());
    }

    @Test
    void depositarMontoInfinitoEsRechazado() {

        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000);
        assertFalse(cuentaBancaria.depositar(Double.POSITIVE_INFINITY));
        assertEquals(1000, cuentaBancaria.getSaldo());
    }
}
