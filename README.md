# ProyectoFinanciero

[![CI Java Maven](https://github.com/AL99-WOOD/proyectofinanciero/actions/workflows/ci.yml/badge.svg)](https://github.com/AL99-WOOD/proyectofinanciero/actions/workflows/ci.yml)

Sistema financiero de ejemplo para los Laboratorios de Construcción y Evolución de Software.

La clase `CuentaBancaria` permite depositar, retirar y transferir entre cuentas. Cada cambio se valida automáticamente con JUnit 5 en GitHub Actions, y JaCoCo mide la cobertura de las pruebas.

## Requisitos

- JDK 17 o superior. El código se compila con `maven.compiler.release` 17, así que también funciona con el JDK 21 o 27 de IntelliJ.
- Maven 3.9+
- Git

## Uso

```bash
mvn clean test
```

El reporte de cobertura queda en `target/site/jacoco/index.html`.

## Estructura

```
src
├── main/java/pe/edu/unsch/CuentaBancaria.java
└── test/java/pe/edu/unsch/CuentaBancariaTest.java
.github/workflows/ci.yml   ← pipeline de integración continua
```

## Ramas

| Rama | Contenido |
|---|---|
| `main` | Versión integrada |
| `feature-transferencia` | Retiro (Lab 02) y transferencia entre cuentas (Lab 03) |

## Nota sobre JaCoCo y JDK recientes

La guía usa JaCoCo 0.8.12, que oficialmente soporta hasta Java 22. Las clases del proyecto se compilan para Java 17, por lo que el reporte se genera también con JDK más nuevos. Si al ejecutar las pruebas con JDK 26 o 27 aparece un error de JaCoCo como `Unsupported class file major version`, cambia la versión del plugin a `0.8.15` en el `pom.xml`.
