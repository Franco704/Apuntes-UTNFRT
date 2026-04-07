---
materia: Desarrollo de Software
unidad: 1
tipo: #practica/ejercicio
---
# Depuración de Código: Ejercicio 1 (Repaso POO)

> [!INFO]  Diagnóstico Inicial
> Inicialmente notamos que el programa no soluciona correctamente la situación problemática, realizando errores en los consumos en ambos tipos de vehículos. 
> Analizando el código encontramos **4 errores principales** que impiden que el programa dé los resultados esperados.

---

### 1. En la clase: `VehiculoCombustible`
La función `calcularConsumo(double kilometros)` realiza una resta sin sentido (`kilometrosPorLitro - litrosExtra`) y no toma en cuenta ni los kilómetros recorridos ni la antigüedad del vehículo.

**Código Original:**
![Error VehiculoCombustible](../../Bibliografia/Pasted%20image%2020260407114807.png)

**Solución:**
Arreglando dicha función nos quedaría:
![Corrección VehiculoCombustible](../../Bibliografia/Pasted%20image%2020260407115046.png)

---

### 2. En la clase: `VehiculoElectrico`
Encontramos múltiples errores en este método:
- Le falta el parámetro `(double kilometros)` a la función, por lo que no está sobrescribiendo el método de la clase padre.
- Suma literalmente `0.156` a la variable, en lugar de sumarle el 15% al total de consumo.
- Se nos solicitó que el consumo se dispare si la capacidad "supera los 1200", pero el código tiene incluido al 1200 (`>= 1200`), debería ser `>`.
- Falta calcular el consumo por cada 100 km.

**Código Original:**
![Error VehiculoElectrico](../../Bibliografia/Pasted%20image%2020260407115447.png)

**Solución:**
Arreglando la función nos quedaría:
![Corrección VehiculoElectrico](../../Bibliografia/Pasted%20image%2020260407115626.png)

---

### 3. En la clase: `ListarVehiculosView`
- En el método del botón `calcularConsumosActionPerformed`, el código extrae los kilómetros usando el índice erróneo (`7`: Litros Extra); el índice debería ser `8`.
- Al hacer un *cast* directo a `(Double)`, el programa tendrá un `ClassCastException` apenas el usuario modifique la celda escribiendo los kilómetros manualmente, ya que la tabla guardará los cambios como `String`.

**Código Original:**
![Error ListarVehiculosView](../../Bibliografia/Pasted%20image%2020260407120127.png)

**Solución:**
Arreglando la función nos quedaría:
![Corrección ListarVehiculosView](../../Bibliografia/Pasted%20image%2020260407120240.png)

---

### 4. En la clase: `Vehiculo`
La clase está declarada como `abstract` pero el método `calcularConsumo` devuelve `0` por defecto. Como sabemos que todos los hijos deben calcular su propio consumo de formas distintas, el método en el padre no debería tener un cuerpo.

**Código Original:**
![Error Vehiculo](../../Bibliografia/Pasted%20image%2020260407120417.png)

**Solución:**
Arreglando la función nos quedaría:
![Corrección Vehiculo](../../Bibliografia/Pasted%20image%2020260407120514.png)

---

##  Resultado Final
Finalmente logramos que el programa realice su cálculo correctamente:

![Resultado Correcto](../../Bibliografia/Pasted%20image%2020260407120800.png)