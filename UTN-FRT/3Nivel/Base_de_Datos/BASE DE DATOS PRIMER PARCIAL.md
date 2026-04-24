# UNIDAD 1: ARCHIVOS
---
Un **ARCHIVO** o **FICHERO** es un conjunto finito de información estructurada en subconjuntos llamados **REGISTROS** los cuales suelen estar guardados en dispositivos secundarios de almacenamiento.
Un **REGISTRO** está formado por un conjunto de **CAMPOS** que toman un valor particular de un conjunto de valores posibles o **DOMINIO**.
Una **LLAVE** o **Clave** es un campo o conjunto de campos que permite identificar en forma univoca a un registro.

## REGISTROS LÓGICOS Y FÍSICOS

Un **REGISTRO LÓGICO** está formado por un conjunto de **CAMPOS** que toman un valor particular de un conjunto de valores posibles o **DOMINIO**.
Un **REGISTRO FÍSICO**, también denominado **BLOQUE o PAGINA**, es una unidad de transferencia entre el almacenamiento principal y el secundario.
Normalmente un registro físico contiene varios registros lógicos.

## ORGANIZACIÓN DE ARCHIVO Y MÉTODOS DE ACCESO

La **ORGANIZACIÓN DE ARCHIVO** implica un criterio para representar, almacenar y recuperar los registros de un archivo almacenados en un soporte físico.
El **MÉTODO DE ACCESO** refleja los pasos necesarios para almacenar y extraer los registros de un archivo.
Normalmente ambos conceptos están íntimamente relacionados, debido a que algunos métodos solo pueden aplicarse en algunas de las organizaciones de archivo.

## OPERACIONES SOBRE ARCHIVOS

Una **ORGANIZACIÓN DE ARCHIVO** debe ser capaz de realizar las siguientes operaciones sobre los archivos:
- **RECUPERACIÓN o CONSULTA (QUERY):** recuperar un conjunto de registros específicos en base a un criterio determinado.
- **ACTUALIZACIÓN:** operaciones que producen cambios en el archivo, las clasificamos en:
	- **INSERCIÓN:** implica el alta de un nuevo registro
	- **MODIFICACIÓN:** la modificación de valores de un registro existente
	- **ELIMINACIÓN:** baja o eliminación de un registro existente

## ORGANIZACIÓN DE ARCHIVOS

Los tipos principales de organización de archivos son:
- **ARCHIVOS DESORDENADOS O EN CUMULO:**
	- Sus registros se almacenan en el mismo orden que se insertan, no existe criterio de ordenación.
	- Inserción muy eficiente ya que el registro se inserta al final
	- Solo se puede aplicar la **búsqueda lineal**, implica leer uno por uno los registros. **Poco eficiente para grandes volúmenes de información**.
	- ![](../../Bibliografia/Pasted%20image%2020260423103258.png)
- **ARCHIVOS ORDENADOS O SECUENCIALES:**
	- Sus registros **se almacenan en forma ordenada** en base al valor de ciertos campos (los **llave**), formado por una **secuencia** por esta clave.
	- La inserción y el borrado son problemáticos ya que se debe mantener el orden.
	- Se puede aplicar la **búsqueda binaria**, ya que esta ordenado. Se posiciona en la mitad del archivo, y si no se encuentra el registro, y el valor de la clave es inferior, nos posicionamos en la mitad inferior y se repite el proceso (si es superior, mitad superior).
	- ![](../../Bibliografia/Pasted%20image%2020260423103546.png)
- **ARCHIVOS HASH:** 
	- También conocidos como **ARCHIVOS DE ACCESO DIRECTO**, consisten en particionar los registros mediante una **función hash -h(x)-** que toma como argumento el valor de la clave y nos devuelve una **dirección de memoria denominada bucket o cubeta**. 
	- Normalmente a cada valor de la función hash se la asocia a una **tabla hash**, en donde cada una de sus entradas tiene asociado un puntero por el cual se accede al bucket. 
	- ![](../../Bibliografia/Pasted%20image%2020260423104420.png)
	- La **elección de la FUNCION HASH** es **crítica** ya que **debe garantizar la distribución de la manera más uniforme** de los registros a lo largo del archivo.
	- Algunas Funciones Hash usuales:
		- **FUNCIÓN MODULO:** Consiste en dividir el valor de la clave por un número entero predeterminado y tomar el resto de la división entera como resultado.
		- **FUNCIÓN PLEGADO:** Al valor de la clave expresada en binario se la parte en secciones de la misma longitud, luego se suman éstas cuyo resultado es el valor de la función
	- **Colisiones:** **Las funciones hash no siempre garantizan una dirección univoca,** siendo posible que más de un registro tengan asignado la misma cubeta. En estos casos tenemos **registros sinónimos y se genera una colisión,** debiendo preverse un mecanismo de gestión de colisiones, tales como:
		- **DESBORDE ENCADENADO**
		- **ÁREA DE DESBORDE COMÚN**
		- **HASH MÚLTIPLE O REHASHING**
- **ARCHIVOS SECUENCIALES INDEXADOS**
	- Para acelerar las búsquedas, a un archivo secuencial se le suele agregar una estructura adicional, el **ÍNDICE,** eliminando la necesidad de recorrer secuencialmente el archivo de datos para acceder al registro.
	- El índice contiene dos registros: la clave y un puntero al archivo de datos.
	- Como el archivo de datos no cabe entero en la memoria principal, la idea es buscar en una estructura auxiliar más pequeña y acceder a los bloques necesarios de los datos
	- ![](../../Bibliografia/Pasted%20image%2020260423105305.png)

## TIPOS DE INDICES

- **INDICE PRINCIPAL O PRIMARIO:** Estructurado sobre la clave o llave, garantiza la univocidad entre un valor de la clave y un registro.
- **INDICE SECUNDARIO:** Se estructura sobre campos diferentes de la clave y puede contener valores no unívocos. Se usan para acelerar consultas por campos diferentes de la clave, sin embargo el elevado uso de estos índices puede degradar la performance del sistema.
- **INDEXADO PERFECTO - INDICES DENSOS:** En un indice denso, existe una correspondencia univoca entre un valor de la clave y un registro, tal esquema se denominada indexado perfecto, en donde el índice tiene tantos registros como el archivo de datos.
	- ![](../../Bibliografia/Pasted%20image%2020260423105653.png)
- **INDEXADO POR BLOQUES - INDICES ESCASOS O DISPERSOS:** Solo se almacenan algunos valores de la clave, que apunta a un bloque del archivo de datos. En el índice se almacena la clave mayor del bloque (cubrimiento), este esquema se llama indexado por bloques, donde el indice tiene tantos registros como bloques existen en el archivo de datos y suele emplearse cuando el índice es muy grande para caber completo en memoria principal.
	- ![](../../Bibliografia/Pasted%20image%2020260423105838.png)
- **INDEXADO POR NIVELES:** ![](../../Bibliografia/Pasted%20image%2020260423105920.png)
- **INDEXADO CON ÁRBOLES EN LOS INDICES:** Podemos utilizar árboles en los archivos índice. Un árbol se encuentra compuesto por una **jerarquía de nodos, los cuales, salvo el raíz, tienen ero o más nodos hijos. Un nodo sin hijos se llama nodo hoja o nodo terminal**. La **altura del árbol es el numero máximo de niveles entre el nodo raíz y los nodos hoja**, se procura que sea equilibrada y la mínima posible. El **grado del árbol es el numero máximo de hijos permitido por nodo**, cuando el grado es mayor se reduce la altura del árbol.
	- **INDICES CON ÁRBOLES AVL:** Un árbol binario de búsqueda, con la sencilla regla de que las claves menores se ubican a la izquierda del nodo y las mayores a la derecha, no se permite que la profundidad o altura entre los dos subárboles de un nodo sea superior a 1. **El registro de un índice de un árbol AVL es: **![](../../Bibliografia/Pasted%20image%2020260423110511.png) ![](../../Bibliografia/Pasted%20image%2020260423110533.png)
	- **INDICES CON ÁRBOLES B:** Para utilizar árboles con grado superior a 2, se utilizan los árboles b de orden m, de acuerdo a las siguientes reglas:
		- Si el nodo raíz no es un nodo hoja, debe tener al menos dos hijos.
		- Cada nodo, excepto el raíz y los nodos hoja, debe tener entre $m/2$ y $m$ punteros e hijos.
		- El numero de claves en un nodo hoja esta comprendido entre $(m-1)/2$ y $m-1$.
		- El numero de claves en un nodo que no sea hoja es uno menos que el numero de punteros.
		- El árbol debe estar equilibrado
		- Los nodos hoja están entrelazados según el orden de los valores de las claves.
	El registro del índice de un árbol B de orden M tiene la siguiente estructura:![](../../Bibliografia/Pasted%20image%2020260423110854.png)


# UNIDAD 2: INTRODUCCIÓN A LAS BASES DE DATOS
---
## INTRODUCCIÓN

**DATO:** Significa simplemente "hechos sin evaluar", son el motor que mueve al mundo de la informática.
**INFORMACIÓN:** Es un conjunto ordenado de datos, los cuales pueden recuperarse de acuerdo a la necesidad del usuario.
Para que los datos puedan ser procesados eficientemente y dar lugar a la información se deben organizar lógicamente en archivos.
- **CAMPO:** Es la unidad más pequeña a la cual uno puede referirse, es la que contiene el dato.
- **REGISTRO:** Un conjunto de campos con relación entre sí se agrupa como un registro.
- **ARCHIVO:** Es la colección de registros del mismo tipo.
**BASE DE DATOS:**
	 - Conjunto de datos organizados de tal manera que pueda extraerse información y se logre compartirla
	 - Colección de archivos interrelacionados creados y administrados por un DBMS
	 - Es una colección de datos almacenados y organizados con base en relaciones entre ellos mismos.
	 - Una colección de datos que es administrada por un sistema de administración de base de datos.
**SISTEMA DE ADMINISTRACIÓN DE BASE DE DATOS (DBMS):** El sistema de manejo de bases de datos es la porción más importante del software de un sistema de bases de datos, permite la creación, modificación y actualización de una BD.
Sus funciones: 
- Crear y organizar las bases de datos.
- Manejo de transacciones y control de Concurrencia o de los accesos simultáneos a la base de datos. Muy importante si varios usuarios comparten la utilización de una misma base de datos.
- Manejar los datos de acuerdo a las peticiones de los usuarios.
- Mantener la integridad y seguridad de los datos.
- Registrar el uso de las bases de datos.

## SISTEMA DE BASE DE DATOS

Es un sistema computarizado de información para el manejo de datos por medio de paquetes de software llamados Sistemas de Administración de Base de datos (DBMS).

**Transacción:** Significa, una petición en línea de la base de datos; involucra llamadas a rutinas del DBMS para operaciones E/S y alguna cantidad limitada de operaciones.

**Objetivos de un Sistema de Base de Datos: 
* **Independencia de Datos** (Física y Lógica)
* **Minimizar la Redundancia de datos**
* **Integridad de los Datos**: Se refiere a las medidas de seguridad usadas para mantener correctos los datos en la base de datos, mediante validación, integridad referencial y recuperación de la base.
* **Control de la Concurrencia y Simultaneidad:** Cuando varios usuarios traten de usar simultáneamente la misma base de datos, mediante secuenciar las actualizaciones.
* **Seguridad de los Datos:** Se refiere a la protección de la base contra accesos o modificaciones no autorizados mediante los seguros de control de acceso o poniendo los datos en claves cifradas.

**Administrador de la Base de Datos (DBA):**  Es aquella persona que tiene el control central del sistema de base de datos.
Sus funciones:
	- Definición del esquema.
	- Definición de la estructura del almacenamiento y del método de acceso. 
	- Modificación del esquema y de la organización física.
	- Concesión de autorización para el acceso a los datos.
	- Especificación de las restricciones de integridad.

## METAESTRUCTURA DE BASES DE DATOS

A partir de una estructura de archivos, es posible montar una metaestructura de bases de datos, la cual podemos tipificar en tres etapas:
- La Estructura General de Datos se define utilizando un Lenguaje de Definición de Datos (DDL).
- La Transformación de Datos se realiza usando un Lenguaje de Manipulacion de una DB (DML).
- Los métodos utilizados para la recuperaciión de subonjuntos de datos, basados en consultas a la DB especificas, se realiza mediante un Lenguaje de Consultas (DQL).
![](../../Bibliografia/Pasted%20image%2020260423115143.png)
Vamos a considerar que un DBMS, además de las tareas enunciadas anteriormente, consisten en un conjunto de recursos que colectivamente permiten:
- Almacenar una DB.
- Mantener la seguridad de una DB mediante el uso adecuado de restricciones de privacidad e integridad, como así también permitir respaldos de la información para la recuperación luego de fallas en hardware/software.
- Proveer las rutinas de E/S para facilitar el uso de la DB.

## Arquitectura Funcional de una Base de Datos

Esta arquitectura indica las diferentes funciones o facilidades presentes en una DB, teniendo en cuenta que tal arquitectura no refleja necesariamente la construcción física de la DB.
![](../../Bibliografia/Pasted%20image%2020260423115445.png)
- **Subsistema de Recuperación y Respaldo:** Es un módulo encargado de reconstruir una DB luego de fallas en hardware o software.
- **Subsistema de Privacidad:** Privacidad en una DB como la propiedad que refleja la medida en la que están protegidos los datos contra accesos no autorizados.
- **Subsistema de Integridad:** Integridad de una DB a la propiedad que refleja la medida en que la DB es un modelo seguro de aquella parte del universo que la misma representa.
- **Esquema Físico:** Es el encargado de la descripción de la estructura física de una DB, resultando así el esquema que contiene detalles específicos, tales como el tipo de archivos utilizado, formato de registros, factores de bloqueo, etc.
- **Esquema Conceptual:** Posee el mayor nivel de mayor abstracción y es el punto de partida en el diseño de una DB Desarrollado en Lenguaje Natural.
- **Esquema Lógico:** Es el esquema de una DB dado por "una descripción de los datos almacenados en una DB, con una especificación adecuada de tipo de datos y sus caminos de acceso". También contiene la restricciones de privacidad y de integridad.

## MODELO DE DATOS

Es un grupo de herramientas conceptuales para describir: los datos, sus relaciones, su semántica y sus limitaciones; de tal forma que facilita la interpretación de nuestro mundo real y su representación en forma de datos, en nuestro sistema informático.
![](../../Bibliografia/Pasted%20image%2020260423120756.png)


## RAID

**Redundant Array of Independent Disks**
Es un método de combinación de varios discos duros para formar una única unidad lógica en la que se almacenan los datos de forma redundante. Consta de dos o más discos que funcionan como un único dispositivo.
**¿Cómo trabaja RAID?:**  Los datos se desglosan en fragmentos y se escriben en varios discos de forma simultánea. RAID protege los datos contra el fallo de una unidad de disco duro. RAID Mantiene el servidor activo y en funcionamiento hasta que se sustituya la unidad defectuosa.
La utilización de sistemas de almacenamiento tolerantes al fallo es imprescindible actualmente en la configuración de un servidor de datos. Los datos deben estar disponibles en todo momento y asegurados contra incidencias.

**Tipos de RAID:** 
- **RAID 0: Disk Striping:** "La más alta transferencia, pero sin tolerancia a fallos". Es conocido como **"separación o fraccionamiento"**. Los datos se desglosan en pequeños fragmentos y se distribuyen entre varias unidades. Este nivel de array **no ofrece tolerancia al fallo.**
- **RAID 1: Mirroring:** "Redundancia. Más rápido que un disco y más seguro". Se basa en la utilización de discos adicionales sobre los que se realiza una copia en todo momento de los datos que se están modificando.
- **RAID 0+1 / RAID 0/1 o RAID 10:** Combinacion de los arrays anteriores, proporciona **velocidad y tolerancia al fallo**. Cada bloque es una copia exacta del otro, RAID 1, y dentro de cada bloque la escritura de datos se realiza en modo de bloques alternos, RAID 0.
- **RAID 5:** "Acceso independiente con paridad distribuida." **Optimiza la capacidad del sistema** permitiendo una utilización de hasta el 80% del conjunto de discos. RAID 5 es la solución más económica por megabyte, que ofrece la mejor relación de precio, rendimiento y disponibilidad.

**Ventajas de RAID:**
- **Tolerancia a fallos:** **RAID protege contra la pérdida de datos** y proporciona recuperación de datos en tiempo real.
- **Mejora del Rendimiento / Velocidad:** Una matriz consta de dos o más discos duros funcionan como un único dispositivo.
- RAID permite a varias unidades trabajar en paralelo, lo que **aumenta el rendimiento del sistema**.

## STORAGE AREA NETTWORK (SAN)

Es una Subred, separada de la red principal especializada en Almacenamiento.
Se construye sobre una interfaz de Fibra.
Admite mayores anchos de banda y mayores distancias entre dispositivos.
Conectividad sencilla y alto nivel de fiabilidad.
![](../../Bibliografia/Pasted%20image%2020260423123153.png)
**Network Attached Storage** es el nombre dado a una tecnología de almacenamiento dedicada a compartir la capacidad de almacenamiento de un computador (Servidor) con computadoras personales o servidores clientes a través de una red (normalmente TCP/IP), haciendo uso de un SO optimizado para dar acceso con alguno de sus protocolos como ser FTP o TFTP.
![](../../Bibliografia/Pasted%20image%2020260423123330.png)
**Almacenamiento en la nube (cloud storage)** es un modelo de almacenamiento de datos basado en redes, ideado en los años 60, donde los datos están alojados en espacios de almacenamiento virtualizados, por lo general aportado por terceros.


# UNIDAD 3: MODELO ENTIDAD-RELACIÓN
---
El modelo E-R fue desarrollado por Peter Chen, quien en un paper estableció los fundamentos de su modelo, los cuales a partir de entonces se han ampliado y modificado.
Este Modelo permite al diseñador concebir la BDa un nivel superior de abstracción, sin tener que considerar el hardware ni a los Usuarios. Se centra en un plano Infologico, utilizando un lenguaje natural que pueda ser interpretado fácilmente por los usuarios.
Es un modelo que se apoya en dos conceptos:
- **Entidad:** "Una cosa que se puede identificar claramente", **"Una entidad es algo que se puede identificar en el ambiente de trabajo de los usuarios; es decir, aquello a lo cual los usuarios quieren dar seguimiento. Puede ser un objeto real o abstracto"**
- **Relación:** "Una vinculación entre entidades". **"Son asociaciones entre dos o más entidades, no necesariamente distintas"**, Una relación puede involucrar muchas entidades. El número de Entidades que está en una relación es el Grado de la misma.

## Entidades

Ejemplo: PRODUCTO = A123Z654
Las entidades de determinado tipo se agrupan en clases de entidades. Así la clase de entidad EMPLEADO es un conjunto de todas las entidades EMPLEADOS, y **deben ser nomenclados en letras mayúsculas y por lo general en singular**
Una **clase de entidad** es un **conjunto de entidades** y se describe mediante la estructura o formato de las entidades en esa clase.
Una **Instancia de entidad es la representación de una entidad en particular**, tal como cliente 12345, lo cual se describe mediante los valores en los atributos de esta.

* **Atributos**: Las entidades tienen propiedad o atributos que describen las características de la entidad. Ej: NombredeEmpleado, FechadeContrato. Los atributos deben escribirse en Mayúsculas y Minúsculas.
* **Dominio y Valor:** Dominio es el conjunto de Valores homogéneos con un nombre, que poseen características comunes entre si. Ej: Dominio Empleado, Valores Juan, Diego, Ulises.
* **Identificadores**: Son Atributos que nombran o identifican las instancias de la entidad con el fin de brindar criterios de unicidad, un identificador puede ser único o compuesto. Si es Único su valor identificara solamente un ejemplo de entidad, en cambio si no lo es, el valor identificara una serie de instancias de clase. Ej: Instancia Empleado, Identificador DNIEmpleado.

## Relaciones

![](../../Bibliografia/Pasted%20image%2020260423134911.png)
**Tipos de Relaciones Binarias:**
Las relaciones binarias poseen instancias a ambos lados de la misma, la cual puede ser tipificada de la siguiente manera:
- **(1 : 1) o (Uno a Uno)**: En donde una instancia de un tipo se relaciona con una instancia de una sola entidad de otro tipo. ![](../../Bibliografia/Pasted%20image%2020260423140646.png)
- **(1 : N) o (Uno a Muchos):** En donde una instancia de entidad de un tipo se relaciona con otras instancias de otro tipo.![](../../Bibliografia/Pasted%20image%2020260423141115.png)
- **(N : M) o (Muchos a Muchos):** En donde las instancias de una entidad se relacionan con las instancias de otra entidad. ![](../../Bibliografia/Pasted%20image%2020260423141503.png)
Cuando el nombre de la relación se coloca dentro del rombo, es necesario que la cardinalidad de la relación se documente de forma gráfica, utilizando para ello las "patas de gallo" en el extremo de la linea de relación, y que simbolizan "muchas" instancias de ese lado de la misma.
La cardinalidad mínima de una relación es una estrategia mediante la cual es posible declarar rangos de valores admitidos a ambos lados de la relación.
Para esto utilizaremos dos símbolos sobre la línea de relación, y en donde el ovalo implicara que el mínimo de relaciones será de 0, y una línea interceptando la relación, la cual indicara que el mínimo de relaciones será de 1.![](../../Bibliografia/Pasted%20image%2020260423141702.png)

**Atributos de una Relación:** En algunas relaciones los atributos se grafican como óvalos conectados a las entidades a las que describen, los cuales contienen los nombres de los atributos de la relación nomenclados con mayúsculas y minúsculas. Cuando las entidades tienen muchos atributos se vuelve compleja la grafica, por lo que en esas circunstancias se puede enumerar los mismos en forma de tabla separados del modelo. ![](../../Bibliografia/Pasted%20image%2020260423142036.png)

**Entidades Débiles:** El modelo ER define un tipo especial de Entidad denominada Débil, la cual no puede existir en la BD a menos que también exista otra denominada Entidad Fuerte, a la cual debe su existencia.![](../../Bibliografia/Pasted%20image%2020260423142152.png)
**Relación de tipo Rol:** Es el papel o función que desempeña un tipo de entidad en una interrelación tipo. Los roles suelen ser implícitos, pero puede ser util distingurlos si se necesita aclarar el significado de una interrelación. Un caso típico que se necesita precisar el rol de cada tipo de entidad participante es cuando existe una **interrelación reflexiva**.  ![](../../Bibliografia/Pasted%20image%2020260423142717.png)
Debe distinguirse entre grado de la interrelación y **cardinalidad del rol**. El **cardinalidad del rol** se define mediante el rango (min:MAX), entendiéndose el mínimo de instancias de ese rol y el máximo en dicha interrelación.

## Notaciones de Cardinalidad (Usaremos la de Chen)

![](../../Bibliografia/Pasted%20image%2020260423142901.png)

## Ejemplo E-R

![](../../Bibliografia/Pasted%20image%2020260423144404.png)
![](../../Bibliografia/Pasted%20image%2020260423144418.png)

## TÉCNICA PARA EL MODELADO DE DATOS UTILIZANDO DIAGRAMAS ENTIDAD RELACIÓN

No es la única técnica pero sí la más utilizada. Consiste en los siguientes pasos:
1. Se parte de una descripción textual del problema o sistema de información a automatizar (los requisitos).
2. Se hace una lista de los sustantivos y verbos que aparecen. Los sustantivos son posibles entidades o atributos. Los verbos son posibles relaciones.
3. Analizando las frases se determina la cardinalidad de las relaciones y otros detalles.
4. Se elabora el diagrama (o diagramas) entidad-relación.
5. Se completa el modelo con listas de atributos y una descripción de otras restricciones que no se pueden reflejar en el diagrama.
El modelado de datos no acaba con el uso de esta técnica. Son necesarias otras técnicas para lograr un modelo directamente implementable en una BD, brevemente:
- Transformación de relaciones múltiples en binarias.
- Normalizacion de una base de datos de relaciones.
- Conversión en tablas (en caso de utilizar una base de datos relacional).


# UNIDAD 4: TRANSFORMACIÓN DEL MODELO E-R AL MODELO RELACIONAL
---
## Transformación de las Entidades
Todas las **entidades fuertes** presentes en el modelo E/R se transforman en tablas en el modelo relacional, manteniendo el número y tipo de los atributos, así como las claves primarias.
Las **entidades débiles** también se convierten en tablas en el modelo relacional, manteniendo el número y tipo de los atributos, pero su clave primaria se forma por la composición de su clave primaria (si la tuviera) con la clave primaria de la entidad fuerte de la cual depende (Clave Foránea).
Ejemplo: ![](../../Bibliografia/Pasted%20image%2020260423145718.png)
Si existen **Atributos compuestos**: Se transforma en atributos sencillos (campos) que componen el atributo compuesto, desapareciendo éste como tal de la tabla resultante.
![](../../Bibliografia/Pasted%20image%2020260423145815.png)
**Atributos multivaluados** -puede tomar varios valores, marcado en el diagrama con doble ovalo-: Se crea una nueva relación formada con la clave primaria de la entidad y el atributo multivaluado, siendo ambos integrantes de la clave primaria de la nueva tabla.![](../../Bibliografia/Pasted%20image%2020260423145941.png)
![](../../Bibliografia/Pasted%20image%2020260423150015.png)
La entidad débil arrastra la clave de la entidad fuerte de la cual depende, la relación débil no se traduce en ninguna tabla en el modelo relacional, al resultar innecesaria.
El modelo relacional quedaría de la siguiente manera: ![](../../Bibliografia/Pasted%20image%2020260423150110.png)

## Transformación de las relaciones uno a uno

Si en la relación binaria, las dos entidades participan con cardinalidad máxima y mínima igual a uno, entonces:
- Si las dos entidades tienen distinto identificador o clave primaria, entonces cada entidad se transforma en una tabla con clave principal correspondiente al identificador de la entidad respectiva.
- En una de las tablas vinculadas si se agrega como clave ajena o foránea el identificador o clave primaria de la otra tabla con la cual está relacionada.
- Desde el punto de vista teórico, es indistinto en cual de las entidades relacionadas colocamos la clave foránea, pero desde un punto de vista practico, no nos puede convenir mas una forma en particular.
![](../../Bibliografia/Pasted%20image%2020260423150511.png)
![](../../Bibliografia/Pasted%20image%2020260423150544.png)

## Transformación de las relaciones uno a muchos (1:N) - Relación Padre-Hijo

Si en la relación binaria 1:N, la entidad padre esta del lado uno de la relación y la entidad hijo del lado muchos.
Si la entidad hija, lo hace también con cardinalidad mínima uno:
- Cada entidad se transforma en una tabla cuya clave primaria es el identificador o clave primaria de la entidad correspondiente.
- La clave de la entidad padre pasa como clave foránea de la entidad hija.
- Si la relación tuviera atributos, estos pasan a formar parte de la tabla correspondiente a la entidad hija.
![](../../Bibliografia/Pasted%20image%2020260423150754.png)
![](../../Bibliografia/Pasted%20image%2020260423150806.png)

## Transformación de las relaciones muchos a muchos (N:M)

- Cada entidad se transforma en una tabla y donde se asigna como clave primaria el identificador o clave primaria de la entidad correspondiente.
- Se construye una nueva tabla correspondiente a la relación, que tendría los atributos correspondientes a la relación y cuya clave estará formada por la composición de los identificadores o claves primarias de las entidades que participan en la relación.
![](../../Bibliografia/Pasted%20image%2020260423151030.png)
![](../../Bibliografia/Pasted%20image%2020260423151045.png)

## Transformación de las relaciones reflexivas

Para transformar una relación reflexiva al modelo relacional, suponer que se trata de una relación binaria con la particularidad que las dos entidades son iguales y aplicando las reglas de los apartados 2 a 4.
![](../../Bibliografia/Pasted%20image%2020260423151201.png)
![](../../Bibliografia/Pasted%20image%2020260423151221.png)

## Formato a utilizar

![](../../Bibliografia/Pasted%20image%2020260423151302.png)

## Ejemplo de E-R a MR

![](../../Bibliografia/Pasted%20image%2020260423151334.png)

# UNIDAD 5: ÁLGEBRA RELACIONAL
---
**Relación**: Recordemos que, en el MR, una relación es **"una tabla bidimensional en donde cada renglón o tupla, tiene datos que pertenecen a alguna cosa o a una parte de esta, y donde cada columna o atributo de esta tabla describen a la ocurrencia"**
![](../../Bibliografia/Pasted%20image%2020260423152200.png)

**Álgebra Relacional:** Es un conjunto de operaciones que describen paso a paso como calcular una respuesta sobre las relaciones componiendo un lenguaje formal basado en operadores y que utiliza para ello relaciones.
Tanto los operandos como los resultados son relaciones, por lo que la salida de una operación puede ser la entrada de otra operación, esto permitiéndonos anidar expresiones del álgebra.
![](../../Bibliografia/Pasted%20image%2020260423152437.png)
El álgebra relacional es un álgebra en la cual:
- Sus operandos son relaciones (instancias) o variables que representan relaciones.
- Sus operadores están diseñados para hacer las tareas más comunes que se necesitan para manipular relaciones en una base de datos.
El resultado es que el álgebra relacional se puede utilizar como un lenguaje de consulta.
El álgebra relacional es similar al algebra que hasta hoy hemos aprendido, solo que en esta los valores utilizados representan datos.
Es un álgebra cerrada, el resultado de una o más operaciones relacionales es siempre una relación.
Las tuplas de una relación se pueden considerar elementos de un conjunto y por lo tanto, las operaciones que se pueden realizar en conjuntos también se pueden realizar en relaciones.

## Tipificación

El álgebra relacional esta compuesta por dos tipos de operaciones, cuya característica distintiva es el número de relaciones que necesita. Así vemos que se tipifican en:
1. **UNARIAS**: Necesitan de solo una relación para realizar la operación.
2. **BINARIAS**: Requieren dos relaciones como argumento del operador.
Por otra parte, podemos agrupar a los operadores de la siguiente manera:
- **Básicos**: NO puede ser definido en términos de otros operadores.
- **Adicionales**: Si bien puede ser definido en términos de otros operadores, se los implementa para agilizar las búsquedas para consultas que suelen ser frecuentes.

## Listado y Clasificación de los Operadores

![](../../Bibliografia/Pasted%20image%2020260423153410.png)

Para comenzar el estudio de los operadores del AR, se presentan las tablas de estudio tomadas como ejemplos, con su Estructura: 
![](../../Bibliografia/Pasted%20image%2020260423154041.png)
![](../../Bibliografia/Pasted%20image%2020260423154055.png)

## Operadores UNARIOS

### Operador SELECCIÓN

El operador Selección simbolizado mediante $\sigma$, extrae tuplas a partir de una relación que satisfagan una restricción dada.
Simbologia: $\sigma_{\text{[condición]}}(Relación)$
Cuando este operador es implementado en SQL, se encuentra asociado a las palabras reservadas FROM y WHERE, las cuales brindan la condición que se debe cumplir.
![](../../Bibliografia/Pasted%20image%2020260423155209.png)

### Operador PROYECCIÓN

El operador Proyección simbolizado mediante $\pi$, extrae atributos (columnas) específicos de una relación.
Simbologia: $\pi_{\text{[lista de atributos]}}(Relación)$
El resultado será una nueva relación con las columnas (atributos) seleccionados, escogiendo los atributos de las columnas de la relación que cumplan con la condición establecida como parámetro.![](../../Bibliografia/Pasted%20image%2020260423155700.png)

## Operadores BINARIOS

### Operador UNIÓN

La UNIÓN de dos relaciones está formada por la adición de tuplas de una relación con los de una segunda relación que produce una tercera.
El orden en el que aparecen las tuplas en la tercera relación no es importante, pero se deben eliminar los que estén duplicados.
Se denota por $A + B$ o $A \cup B$
Para que esta relación tenga sentido, las relaciones deben ser compatibles, esto es: 
1. Cada relación debe tener el mismo número de atributos.
2. Los atributos en las columnas correspondientes deben provenir del mismo dominio (GRADO).
![](../../Bibliografia/Pasted%20image%2020260423160202.png)

### Operador DIFERENCIA

La diferencia de dos relaciones, simbolizada como $-$, es una tercera relación que contiene tuplas que están presentes en la primera relacion, pero no en la segunda.
Restricciones: Las relaciones deben ser compatibles en la UNION.
![](../../Bibliografia/Pasted%20image%2020260423213116.png)

### Operador INTERSECCIÓN

La INTERSECCIÓN de dos relaciones, simbolizada mediante $\cap$, es una tercera relación que contiene las tuplas que aparecen tanto en la primera como en la segunda relación.
Las relaciones deben ser compatibles en la UNIÓN
**La intersección es un operador derivado** pues puede ser definido de la siguiente manera:
$$R \cap S = R - (R-S)$$
![](../../Bibliografia/Pasted%20image%2020260423213405.png)

### Operador PRODUCTO

El producto de dos relaciones, también conocido como el producto cartesiano, es la concatenación de cada tupla de una relación con cada tupla de la segunda relación.
El producto de la **relación A** (con **m** tuplas) y la **relación B** (con **n** tuplas), dará como resultado una tabla de **m** veces **n** tuplas. Así es que $A \times B$  es igual a **A** veces **B**.
$$Grado(A) + Grado(B) y Cardinalidad(A)*Cardinalidad(B)$$
![](../../Bibliografia/Pasted%20image%2020260423213826.png)
![](../../Bibliografia/Pasted%20image%2020260423213840.png)

## Operadores COMPUESTOS

### Operador JOIN $\Join$

El operador de **Enlace** o **JOIN** es el operador más usado para combinar tablas. La combinación de tablas es importante debido a que la mayoría de las bases de datos tienen la información distribuida en muchas tablas.
El operador Enlace o JOIN **difiere del operador Producto** porque **requiere de una condición de coincidencia sobre las tuplas de dos tablas**. La mayoría de las tablas se combinan de esa forma.
El operador JOIN construye una nueva tabla al combinar las tuplas de dos tablas que coinciden con una condición de **enlace**. Comúnmente la condición de enlace especifica que dos tuplas tengan un valor idéntico en una o más columnas.
Es una **combinación del PRODUCTO, SELECCIÓN y PROYECCIÓN** (Posible). Por ello, **es un operador derivado**.
La asociación de dos relaciones **A** y **B**, opera de la siguiente manera:
1. Debo realizar el PRODUCTO de $A \times B$. Normalización de la relación resultante.
2. SELECCIÓN en función del criterio. Normalización de la relación resultante.
3. Elimina atributos de acuerdo a criterios específicos, mediante la operación de PROYECCIÓN **(Posible)**.
![](../../Bibliografia/Pasted%20image%2020260423214635.png)
![](../../Bibliografia/Pasted%20image%2020260423214651.png)
![](../../Bibliografia/Pasted%20image%2020260423214705.png)![](../../Bibliografia/Pasted%20image%2020260423214717.png)![](../../Bibliografia/Pasted%20image%2020260423214745.png)
![](../../Bibliografia/Pasted%20image%2020260423214751.png)
![](../../Bibliografia/Pasted%20image%2020260423214802.png)![](../../Bibliografia/Pasted%20image%2020260423214831.png)

### Operador COCIENTE

Dadas dos relaciones R y S, en donde R tiene $m1+m2$ columnas y S tiene $m2$ columnas, el operador **COCIENTE (notado $R / S$)** está formado por las **($m2-m1$) tuplas a** tal que para toda **tupla $m2$ tupla b en S** se cumpla que la **tupla $ab$ se encuentre en R**.
El operador COCIENTE es derivado debido a que puede ser definido en términos de otros operadores:
$T_1 \leftarrow \pi_{\text{(A1,A2,...,A(m1-m2))}}R$
$T_2 \leftarrow \pi_{\text{(A1,A2,...,A(m1-m2))}}((T_1 \times S) -R)$
$T \leftarrow T_1 - T_2$
![](../../Bibliografia/Pasted%20image%2020260423215443.png)
![](../../Bibliografia/Pasted%20image%2020260423215502.png)


## Ejemplos Finales

![](../../Bibliografia/Pasted%20image%2020260423215549.png)
![](../../Bibliografia/Pasted%20image%2020260423215558.png)
![](../../Bibliografia/Pasted%20image%2020260423215606.png)
![](../../Bibliografia/Pasted%20image%2020260423215615.png)
![](../../Bibliografia/Pasted%20image%2020260423215623.png)

---


