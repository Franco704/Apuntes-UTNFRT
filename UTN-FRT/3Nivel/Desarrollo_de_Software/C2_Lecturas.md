---
materia: Desarrollo de Software
unidad: 1
tipo: #lectura/resumen
---
#  Resumen de Lecturas: [Unidad 1](Unidad%201.md) (Clase 2)

> [!INFO]  Fuente
> **Libro:** Pro Git, 2da Edición.
> **Capítulos:** 1 y 2 (Sin incluir Etiquetado).

##  CAPÍTULO UNO: Sistemas de Control de Versiones - Introducción

En esta lectura cubriremos los sistemas de control de versiones (VCSs), los fundamentos de Git, junto a su uso básico.

### Evolución del Control de Versiones
Un control de versiones es un sistema que registra los cambios realizados en un archivo o conjunto de archivos a lo largo del tiempo, de modo que permite recuperar versiones específicas más adelante.

* **Locales (VCS):** Es un método utilizado por muchas personas que trata de copiar los archivos de otro directorio. Es sencillo pero propenso a errores (es fácil olvidar en qué directorio nos encontramos y guardar un archivo erróneo o sobrescribir alguno). Por esto se desarrollaron VCS locales con una base de datos donde se lleva el registro de los cambios. (La más popular fue RCS, que recrea archivos a partir de parches).
* **Centralizados (CVCS):** Permiten la colaboración entre desarrolladores mediante un único servidor que contiene todos los archivos versionados y clientes que descargan los archivos desde ahí. *Ventajas:* Las personas saben en qué están trabajando otros y los administradores tienen control detallado. *Desventaja:* El servidor es un punto crítico; si falla, significa grandes pérdidas de tiempo y recursos.
* **Distribuidos (DVCS):** Ofrecen soluciones a los CVCS. Los clientes no solo descargan la última copia, sino que replican completamente el repositorio. Los fallos en el servidor dejan de tener tanto peso porque cada clon es una copia completa de los datos. Permiten manejar numerosos repositorios remotos y flujos de trabajo avanzados.

### Historia y Fundamentos de Git
Git nació de la comunidad de Linux (liderada por Linus Torvalds) tras un conflicto con BitKeeper (que dejó de ser gratuito). La comunidad desarrolló una herramienta propia basándose en lo aprendido. Objetivos iniciales: velocidad, diseño sencillo, soporte para miles de ramas paralelas, completamente distribuido y capaz de manejar grandes proyectos eficientemente.

**¿Cómo maneja la información?**
* A diferencia de otros sistemas que almacenan la información como una lista de cambios (parches), Git la maneja como un conjunto de **copias instantáneas** (snapshots) de un sistema de archivos miniatura.
* Casi todas las operaciones son locales (no necesita conectarse al servidor para leer la base de datos).
* Todo es verificado mediante una suma de comprobación (*checksum* usando SHA-1). Es imposible cambiar contenidos sin que Git lo sepa, ya que guarda todo por el valor del hash, no por el nombre del archivo.

> [!IMPORTANT] Los 3 Estados Principales de Git
> 1. **Confirmado (Commited):** Los datos están almacenados de manera segura en la BD local.
> 2. **Modificado (Modified):** Se modificaron archivos pero todavía no fueron confirmados en la BD.
> 3. **Preparado (Staged):** Se marcó un archivo modificado en su versión actual para que vaya en tu próxima confirmación.

![Estados Principales](../../Bibliografia/Pasted%20image%2020260404154123.png)

---

##  CAPÍTULO DOS: Fundamentos de Git

*(Nota: Para este resumen omitiré la instalación y configuración de Git).*

### Creación y Guardado
* **Obteniendo un repo:**
    * Directorio existente: `git init` (crea un subdirectorio nuevo llamado `.git`).
    * Desde otro servidor: `git clone [url]`.
* **Guardando cambios:** Cada archivo puede estar rastreado (*tracked files*), o sin rastrear (*untracked*).
    ![Ciclos de Vida de los Archivos](../../Bibliografia/Pasted%20image%2020260404163027.png)
* **Revisando el Estado:** Para determinar en qué estado están los archivos utilizaremos `git status`.
* **Rastrear / Preparar:** Para comenzar a rastrear un archivo o prepararlo, utilizaremos el comando `git add`.
* **Confirmando cambios:** Cualquier cosa que no esté preparada no será confirmada. Utilizaremos `git commit`.
* **Ignorar archivos:** Utilizaremos un archivo llamado `.gitignore` que posee una lista de patrones de expresiones regulares (ej. `*.a` para ignorar todos los `.a`).

### Gestión de Archivos y Revisión
* **Eliminando archivos:** `git rm` (lo elimina de los archivos rastreados y del directorio de trabajo).
* **Cambiando el nombre:** Git no rastrea explícitamente los cambios de nombre, para ello utilizaremos `git mv [origen] [destino]`.
* **Ver el historial:** La herramienta básica es `git log`, posee opciones útiles para filtrar.
    ![Opciones1](../../Bibliografia/Pasted%20image%2020260404164128.png)
    ![Opciones 2](../../Bibliografia/Pasted%20image%2020260404164200.png)
    ![Opciones 3](../../Bibliografia/Pasted%20image%2020260404164312.png)

### Deshacer Cambios
*(A veces no es posible recuperar algo luego de que lo deshacemos).*
* **Reconfirmar:** Si te equivocas en el mensaje de confirmación o olvidas agregar un archivo, podemos reconfirmar con `git commit --ammend`.
* **Deshacer un archivo preparado:** Para deshacer las preparaciones utilizaremos `git reset HEAD [archivo]`. Ejecutarlo sin opciones no es peligroso porque solo toca el área de preparación. *Peligro:* Llamarlo con `--hard` toca el directorio de trabajo.
* **Deshacer un archivo modificado:** Mediante `git checkout -- [archivo]` revertimos los cambios. *Peligro:* Cualquier cambio hecho a ese archivo desaparecerá.

### Trabajando con Remotos
Para colaborar necesitamos gestionar repositorios remotos (versiones hospedadas en internet o red).
* **Ver remotos:** Usaremos `git remote` (muestra los nombres) o `git remote -v` (muestra las URLs asociadas).
* **Añadir remotos:** `git remote add [nombre] [url]`.
* **Traer y Combinar:** `git fetch [nombre-remoto]` (se traerá todos los datos pero no los combina) o `git pull` (trae y combina automáticamente la rama remota con la actual).
* **Enviar a tus remotos:** `git push [nombre-remoto] [nombre-rama]`.
* **Inspeccionar:** `git remote show [nombre-remoto]`.
* **Eliminar y Renombrar:** `git remote rename`.

### Alias de Git
Se pueden configurar algunos alias para no escribir todos los comandos por completo.
![Uso de Alias](../../Bibliografia/Pasted%20image%2020260404170141.png)

---

## CAPÍTULO DOS: Análisis y Diseño Orientado a Objetos

> [!INFO]  Fuente
> **Libro:** Análisis y diseño orientado a objetos 2da Edición.
> **Capítulo:** 2.

###  Generaciones de los lenguajes de programación
* **Lenguajes de primera generación (1954-1958):**
	* FOLTRAN 1: Expresiones matemáticas.
	* ALGOL 58: Expresiones matemáticas.
	* Flowmatic: Expresiones matemáticas.
	* IPL V: Expresiones matemáticas.
* **Lenguajes de segunda generación (1959-1961):**
	* FOLTRAN 2: Subrutinas, compilación separada.
	* ALGOL 60: Estructura en bloques, tipos de datos.
	* COBOL: Descripción de datos, manejo de ficheros.
	* Lisp: Procesamiento de listas, punteros, recolección de basura.
* **Lenguajes de tercera generación (1962-1970):**
	* PL/1: FORTRAN + ALGOL + COBOL.
	* ALGOL 68: Sucesor riguroso de ALGOL 60.
	* Pascal: Sucesor sencillo de ALGOL 60.
	* Simula: Clases, abstracción de datos.
* **El Hueco Generacional (1970-1980):**
	* Se inventaron muchos lenguajes diferentes, pero pocos perduraron.

### Fundamentos del modelo de objetos
El modelo de objetos ha demostrado ser un concepto unificador en la informática, aplicable no sólo a los lenguajes de programación, sino también al diseño de interfaces de usuario, base de datos e incluso arquitecturas de computadoras. El diseño orientado a objetos representa un desarrollo evolutivo, no revolucionario; no rompe con los avances del pasado, sino que se basa en avances ya probados.

---

### POO, DOO y AOO

**Programación Orientada a Objetos (POO):**
> [!QUOTE] Definición
> *Es un método de implementación en el que los programas se organizan como colecciones cooperativas de objetos, cada uno de los cuales representa una instancia de alguna clase, y cuyas clases son, todas ellas, miembros de una jerarquía de clases unidas mediante relaciones de herencia.*

* Posee tres partes importantes: (1) Utiliza objetos, no algoritmos, como sus bloques lógicos de construcción fundamentales; (2) Cada objeto es una instancia de alguna clase; y (3) Las clases están relacionadas con otras clases por medio de relaciones de herencia. 
* La programación sin herencia es explícitamente no orientada a objetos; se denomina programación con tipos abstractos de datos.

**Diseño Orientado a Objetos (DOO):**
> [!QUOTE] Definición
> *Es un método de diseño que abarca al proceso de descomposición orientada a objetos y una notación para describir los modelos lógico y físico, así como los modelos estático y dinámico del sistema que se diseña.*

* Hay dos partes importantes: (1) Da lugar a una descomposición orientada a objetos y (2) Utiliza diversas notaciones para expresar diferentes modelos del diseño lógico (estructura de clases y objetos) y físico (arquitectura de módulos y procesos) de un sistema, además de los aspectos estáticos y dinámicos del sistema.

**Análisis Orientado a Objetos (AOO):**
> [!QUOTE] Definición
> *El análisis orientado a objetos es un método de análisis que examina los requisitos desde la perspectiva de las clases y objetos que se encuentran en el vocabulario del dominio del problema.*

* Los productos del análisis orientado a objetos sirven como modelos de los que se puede partir a un diseño orientado a objetos; los productos del diseño orientado a objetos pueden utilizarse entonces como anteproyectos para la implementación completa de un sistema utilizando métodos de programación orientada a objetos.

---

### Elementos del modelo de objetos

**Tipos de paradigmas de programación:**
* Orientados a procedimientos | Algoritmos.
* Orientados a objetos | Clases y objetos.
* Orientados a lógica | Objetivos, a menudo expresados como cálculo de predicados.
* Orientados a reglas | Reglas si-entonces (`if-then`).
* Orientados a restricciones | Relaciones invariantes.

Cada uno de esos estilos de programación se basa en su propio marco de referencia conceptual. Cada uno requiere una actitud mental diferente, una forma distinta de pensar en el problema. Para todas las cosas orientadas a objetos, el marco de referencia conceptual es el modelo de objetos. 

Hay cuatro elementos **fundamentales** en este modelo (un modelo que carezca de cualquiera de estos elementos no es orientado a objetos):
1. Abstracción
2. Encapsulamiento
3. Modularidad
4. Jerarquía

Hay tres elementos **secundarios** del modelo de objetos (cada uno es una parte útil del modelo, pero no esencial):
1. Tipos (tipificación)
2. Concurrencia
3. Persistencia

#### 1. Abstracción
> [!QUOTE]
> *Una abstracción denota las características esenciales de un objeto que lo distinguen de todos los demás tipos de objeto y proporciona así fronteras conceptuales nítidamente definidas respecto a la perspectiva del observador.*

![Abstraccion](../../Bibliografia/Pasted%20image%2020260404191438.png)

* La decisión sobre el conjunto adecuado de abstracciones para determinado dominio es el problema central del diseño orientado a objetos.
* **Tipos de abstracción:**
	* **De entidades:** Un objeto que representa un modelo útil de una entidad del dominio del problema o del dominio de la solución.
	* **De acciones:** Un objeto que proporciona un conjunto generalizado de operaciones, y todas ellas desempeñan funciones del mismo tipo.
	* **De máquinas virtuales:** Un objeto que agrupa operaciones, todas ellas virtuales utilizadas por algún nivel superior de control, u operaciones que utilizan todas algún conjunto de operaciones de nivel inferior.
	* **De Coincidencia:** Un objeto que almacena un conjunto de operaciones que no tienen relación entre sí.
* Un **cliente** es cualquier objeto que utiliza los recursos de otro objeto (denominado servidor).
* Un concepto central a la idea de abstracción es el de la **invariancia**. Un invariante es una condición booleana cuyo valor de verdad debe mantenerse. Para cualquier operación asociada con un objeto, es necesario definir precondiciones (invariantes asumidos por la operación) y postcondiciones (invariantes satisfechos por la operación). La violación de un invariante rompe el contrato asociado con una abstracción. Si se viola una precondición, esto significa que un cliente no ha satisfecho su parte del convenio, y por tanto el servidor no puede proceder con confiabilidad.

#### 2. Encapsulamiento
> [!QUOTE]
> *La abstracción se centra en el comportamiento observable de un objeto, mientras el encapsulamiento se centra en la implementación que da lugar a este comportamiento. El encapsulamiento se consigue a menudo mediante la ocultación de información, que es el proceso de ocultar todos los secretos de un objeto que no contribuyen a sus características esenciales; típicamente, la estructura de un objeto está oculta, así como la implantación de sus métodos.*

![Encapsulamiento](../../Bibliografia/Pasted%20image%2020260404192905.png)

* El encapsulamiento proporciona barreras explícitas entre abstracciones diferentes y por tanto conduce a una clara separación de intereses.

#### 3. Modularidad
> [!QUOTE]
> *El acto de fragmentar un programa en componentes individuales puede reducir su complejidad en algún grado.*

* Se crea una serie de fronteras bien definidas y documentadas dentro del programa. Estas fronteras o interfaces, tienen un incalculable valor cara a la comprensión del programa.

![Modularidad](../../Bibliografia/Pasted%20image%2020260404193332.png)

* Las conexiones entre módulos son las suposiciones que cada módulo hace acerca de todos los demás.
* La modularidad es la propiedad que tiene un sistema que ha sido descompuesto en un conjunto de módulos cohesivos y débilmente acoplados.

#### 4. Jerarquía
> [!QUOTE]
> *La jerarquía es una clasificación u ordenación de abstracciones.*

* Las dos jerarquías más importantes en un sistema complejo son su estructura de clases (la jerarquía de clases) y su estructura de objetos (la jerarquía de partes).
* La **herencia** es la jerarquía de clases más importante, es un elemento esencial de los sistemas orientados a objetos. Básicamente la herencia define una relación entre clases, en la que una clase comparte la estructura de comportamiento definida en una o más clases. La herencia representa así una jerarquía de abstracciones, en la que una subclase hereda de una o más superclases.

![Jerarquia](../../Bibliografia/Pasted%20image%2020260404194210.png)

* A medida que se desarrolla la jerarquía de herencias, la estructura y comportamiento comunes a diferentes clases tenderá a migrar hacia superclases comunes.

#### 5. Tipos (tipificación)
> [!QUOTE]
> *Un tipo es una caracterización precisa de propiedades estructurales o de comportamiento que comparten una serie de entidades.*
> *Los tipos son la puesta en vigor de la clase de los objetos, de modo que los objetos de tipos distintos no pueden intercambiarse o, como mucho, pueden intercambiarse solo de formas muy restringidas.*

![Tipificacion](../../Bibliografia/Pasted%20image%2020260404194849.png)

* Los tipos permiten expresar las abstracciones de manera que el lenguaje de programación en el que se implantan puede utilizarse para apoyar las decisiones de diseño.
* **Beneficios del uso de lenguajes con tipos estrictos:** * Sin la comprobación de tipos, un programa puede "estallar" de forma misteriosa en ejecución en la mayoría de los lenguajes.
	* En la mayoría de los sistemas, el ciclo editar-compilar-depurar es tan tedioso que la detección temprana de errores es indispensable.
	* La declaración de tipos ayuda a documentar los programas.
	* La mayoría de los compiladores pueden generar un código más eficiente si se han declarado los tipos.

#### 6. Concurrencia
> [!QUOTE]
> *La concurrencia es la propiedad que distingue un objeto activo de uno que no está activo.*

* Para ciertos tipos de problema, un sistema automatizado puede tener que manejar muchos eventos diferentes simultáneamente. Otros problemas pueden implicar tantos cálculos que excedan la capacidad de cualquier procesador individual. 
* En ambos casos, es natural considerar el uso de un conjunto distribuido de computadores para la implantación que se persigue o utilizar procesadores capaces de realizar multitarea. Un solo proceso es la raíz a partir de la cual se producen acciones dinámicas independientes dentro del sistema.

![Concurrencia](../../Bibliografia/Pasted%20image%2020260404200914.png)

* Se distingue entre concurrencia pesada y ligera:
	* **Proceso pesado:** Manejado de forma independiente por el sistema operativo de destino, abarca su propio espacio de direcciones. La comunicación suele ser costosa, involucrando a alguna forma de comunicación interproceso.
	* **Proceso ligero:** Suele existir dentro de un solo proceso del sistema operativo en compañía de otros procesos ligeros, que comparten el mismo espacio de direcciones. La comunicación es menos costosa y suele involucrar datos compartidos.

#### 7. Persistencia
> [!QUOTE]
> *La persistencia es la propiedad de un objeto por la que su existencia trasciende el tiempo (es decir, el objeto continúa existiendo después de que su creador deja de existir) y/o el espacio (es decir, la posición del objeto varia con respecto al espacio de direcciones en el que fue creado).*

* Un objeto de software ocupa una cierta cantidad de espacio y existe durante una cierta cantidad de tiempo. Hay un espacio continuo de existencia del objeto, este espectro de persistencia abarca lo siguiente:
	1. Resultados transitorios en la evaluación de expresiones.
	2. Variables locales en la activación de procedimientos.
	3. Variables propias, globales y elementos del montículo cuya duración difiere de su ámbito.
	4. Datos que existen entre ejecuciones de un programa.
	5. Datos que existen entre varias versiones de un programa.
	6. Datos que sobreviven al programa.

![Persistencia](../../Bibliografia/Pasted%20image%2020260404201459.png)

* Los lenguajes de programación tradicionales suelen tratar solamente los tres primeros tipos de persistencia de objetos; la persistencia de los tres últimos tipos pertenece típicamente al dominio de la tecnología de bases de datos.
* La unificación de los conceptos de concurrencia y objetos da lugar a los lenguajes concurrentes de programación orientada a objetos.