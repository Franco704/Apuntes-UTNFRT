---
materia: Probabilidad y Estadística
fecha: 2026-04-06
tipo: #practica
---
# 📈 Trabajo Práctico 1 (Parte I)

![TP1P1](../../Bibliografia/Trabajo%20Práctico%201_I%20Parte.pdf)

## 🧠 Introducción Teórica
**La Estadística:** Es una rama científica de la matemática, nos ayudará a la obtención, el ordenamiento de conjuntos de datos. Dichos datos nos servirán para predecir fenómenos que podemos observar y nos ayudan a conseguir conclusiones de un estudio de agentes determinados.

Se divide en dos:
1. **Descriptiva:** Se refiere a los métodos de recolección, organización, resumen y presentación de un conjunto de datos (Gráficos y Tablas).
2. **Inferencial:** Se refiere a los métodos utilizados para poder hacer predicciones, generalizar y obtener conclusiones a partir de los datos analizados teniendo en cuenta el grado de incertidumbre existente.

### Definiciones Clave
- **Variable estadística:** Conjunto de distintos valores numéricos que adopta un carácter cuantitativo. Pueden ser:
	- *Cualitativas:* No se pueden medir numéricamente.
	- *Cuantitativas:* Tienen valor medido.
- **Individuo:** Cualquier elemento que tenga información sobre el fenómeno que se estudia.
- **Población:** Conjunto de todos los individuos que poseen información sobre el fenómeno que se estudia.
- **Datos estadísticos:** Son medidas y/o números recopilados a partir de la observación:
	- *Discretos:* Son respuestas numéricas que surgen de un proceso conteo.
	- *Continuos:* Son respuestas numéricas que surgen de un proceso de medición.

---

## 📊 Organización y Representación de Datos
Organizar cantidades de datos para poder plasmarlos en una tabla o una gráfica nos permitirá luego tomar decisiones de ser necesario.

### 1. En Datos Discretos
*(Ejemplo dado en clase: Una encuesta con valores de 1 a 9 de 150 encuestados).*

* **Frecuencia Absoluta ($f$):** Su gráfica es la de barras.
* **Frecuencia Acumulada Absoluta ($F$):** Su gráfica es la escalonada (sin pintar abajo).
* **Frecuencia Relativa:** $$f_r = \frac{f}{n}$$
* **Frecuencia Acumulada Relativa:** $$F_r = \frac{F}{n}$$

### 2. En Datos Continuos
*(Ejemplo dado en clase: Atletas que bajaban Kg. Al ser un número no exacto son continuos: 60,5kg; 72,3kg; etc).*

Para organizar los intervalos de clase utilizamos las siguientes fórmulas:

* **Rango:** $$R = X_{max} - X_{min}$$
* **Número de Intervalos ($k$):** Se calcula usando la **Regla de Sturges** (el resultado se debe redondear al entero): $$k = 1 + 3,322 \log(n)$$ *(También se puede sacar con tabla).*
* **Amplitud o Longitud de clase ($L$):** (Se redondea). $$L = \frac{R}{k}$$

**Procedimiento:** Nos fijamos los límites inferiores y superiores y armamos la tabla de frecuencias. 
- La gráfica principal es el **Histograma**. 
- Para la frecuencia acumulada se arma la escalera completa (todo el área de abajo pintada).

---

## 📝 Resolución TP Parte 1

**Ejercicio 2:**
a) Son datos Discretos.
c) Son 7 valores diferentes.
d) Cálculo de Frecuencia Relativa: $f_r = \frac{f}{n}$
* Ejemplo para el valor 0: $$f_r = \frac{4}{25} = 0,16$$