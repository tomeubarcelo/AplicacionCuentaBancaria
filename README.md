# Tarea PROG 05

## Aplicación cuenta bancaria

Se trata de desarrollar una aplicación Java en consola que permita gestionar dos cuentas bancarias: cuenta A y cuenta B. Mediante un menú se podrán realizar determinas operaciones, todas sobre la cuenta A:

1. Ver el número de cuenta completo (CCC - Código Cuenta Cliente).
2. Ver el titular de la cuenta.
3. Ver el código de la entidad.
4. Ver el código de la oficina.
5. Ver el número de la cuenta (solamente el número de cuenta, sin entidad, oficina ni dígitos de control).
6. Ver los dígitos de control de la cuenta.
7. Realizar un ingreso. Habrá que solicitar por teclado la cantidad que se desea ingresar. Siempre se mostrará el saldo final.
8. Retirar efectivo. Una vez mostrado el saldo inicial, habrá que solicitar por teclado la cantidad que se desea retirar. Siempre se mostrará el saldo final.
9. Transferencia entre cuentas.  Se transferirá la cantidad deseada a la cuenta B. Siempre se mostrará el saldo final de las dos cuentas.
10. Salir de la aplicación.

Antes de que aparezca este menú, el programa tendrá que solicitar al usuario los siguientes datos para la Cuenta A y para la Cuenta B:
- Nombre del titular de la cuenta (con un máximo de caracteres).
- Código cuenta cliente (CCC) de la cuenta completo (entidad-oficina-dígitos de control-cuenta).

El programa deberá asegurarse que el CCC es válido mediante la comprobación de:
- El formato (cuatro dígitos de entidad, cuatro dígitos de oficina, dos dígitos de control y diez dígitos de número de cuenta).
- Los dígitos de control son válidos.

Además del programa principal de la aplicación (clase con una función main), habrá que escribir una clase CuentaBancaria que proporcione todas las herramientas necesarias para trabajar con este tipo de información:
- Constructor (o constructores) adecuados.
- Almacenamiento del nombre del titular (atributos).
- Almacenamiento del código de cuenta (atributos).
- Almacenamiento del saldo actual (atributos).
- Gestión de ingresos y depósitos (métodos de interfaz pública).
- Obtención del saldo (métodos de interfaz pública).
- Obtención de información sobre la cuenta: número de la cuenta, entidad, oficina, titular, etc. (métodos de interfaz pública).
- Aquellas herramientas auxiliares necesarias para poder trabajar cómodamente con el objeto. Algunas de esas herramientas podrán ser públicos y otras quizá no. Algunas podrán ser específicas de clase y otras podrán ser de objeto (métodos de objeto privados, métodos estáticos públicos, etc.).

Para trabajar con el número de cuenta debes utilizar el modelo de Código Cuenta Cliente (CCC), que está formado por cuatro campos: entidad - sucursal - dígito de control - número de cuenta. La idea es que puedas introducir el código de cuenta completo y que la clase disponga de un mecanismo para comprobar que ese código es válido. Si el código no es válido, se debería generar una excepción (y por supuesto no almacenar ese código de cuenta). Para ello podrías tener, por ejemplo, un método estático que permita validar códigos de cuenta.

En general, deberías incluir excepciones para controlar aquellos casos en los que el uso de un método no sea posible (intentar sacar más dinero del que hay en el saldo, intentar introducir un titular con más caracteres de los permitidos, intentar ingresar o retirar una cantidad negativa, etc.).

El código fuente Java de esta clase debería incluir comentarios en cada atributo (o en cada conjunto de atributos) y método (o en cada conjunto de métodos del mismo tipo) indicando su utilidad. El programa principal también debería incluir algunos comentarios explicativos sobre su funcionamiento y la utilización de objetos de la clase CuentaBancaria.

El proyecto deberá contener al menos dos archivos fuente Java:
- Programa principal (clase con método main: AplicacionCuentaBancaria.java).
- La clase CuentaBancaria (CuentaBancaria.java).
