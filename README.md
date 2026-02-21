# ConversorMoneda

Aplicacion de consola en Java para convertir montos entre USD, ARS, BRL y COP usando la API de ExchangeRate-API. El flujo es interactivo mediante un menu y consulta tasas en tiempo real.

## Caracteristicas
- Conversion bidireccional entre USD y ARS/BRL/COP.
- Menu interactivo por consola.
- Resultado con monto y moneda destino.
- Consumo de API usando `java.net.http.HttpClient`.
- Parseo de respuesta con Gson.

## Requisitos
- Java 11 o superior (por el uso de `HttpClient`).
- Conexion a Internet.

## Configuracion
- No requiere pasos extra. La API key ya esta incluida en el codigo del proyecto para esta version.

## Uso
1. Ejecuta la aplicacion.
2. Selecciona una opcion del menu (1-7).
3. Ingresa el monto a convertir.
4. El resultado se mostrara en consola.

### Ejemplo de menu
```
************************************************************
Sea bienvenido/a al Conversor de Moneda =]

1) Dolar =>> Peso argentino
2) Peso argentino =>> Dolar
3) Dolar =>> Real brasileno
4) Real brasileno =>> Dolar
5) Dolar =>> Peso colombiano
6) Peso colombiano =>> Dolar
7) Salir

Elija una opcion valida:
************************************************************
```

### Ejemplo de salida
```
El valor 100.0 USD equivale a 87500.0 ARS
```

## Monedas soportadas
- USD (Dolar estadounidense)
- ARS (Peso argentino)
- BRL (Real brasileno)
- COP (Peso colombiano)

## Estructura del proyecto
```
src/
  main/
    Main.java
    Conversor.java
```

## Notas y limitaciones
- La disponibilidad y exactitud dependen del servicio externo (ExchangeRate-API).

## Creditos
Proyecto educativo para practicar consumo de APIs en Java y manejo de datos con Gson.

