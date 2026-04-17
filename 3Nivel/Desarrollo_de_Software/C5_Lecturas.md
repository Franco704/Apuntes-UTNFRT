# Resumen de Lectura: Clase 5 (Unidad 2)

Para la clase 5 tenemos diversos materiales para leer, tanto en formato video como en formato de texto. Voy a realizar un resumen del material según la guía de la U2.

![](Bibliografia/Pasted%20image%2020260416201658.png)

## ¿Qué es .NET?

.NET es una plataforma de desarrollo gratis, de código abierto y multiplataforma.

* **Lenguajes que soporta:** C#, F#, Visual Basic.
* **Herramientas:** Visual Studio, Visual Studio Code.

> [!TIP] Recomendación
> La recomendación para iniciar es C# y VSCode.

**¿Qué se puede programar con .NET?**
Podemos desarrollar programas web, aplicaciones para celulares y escritorio, aplicaciones de la nube, internet de las cosas y APIs.

### ¿Cuál es la diferencia entre .NET y .NET Framework?

**.NET**
* Funciona en Linux, macOS y Windows.
* Es de código abierto y acepta contribuciones de la comunidad.
* Es donde toda la innovación ocurre, soporta más tipos de aplicaciones y entrega un mejor performance.
* No viene incluido con el SO.
* Recomendado para desarrolladores nuevos.

**.NET Framework**
* Solo funciona en Windows.
* El código fuente está disponible pero no acepta contribuciones.
* Solamente tiene arreglos de bugs de confiabilidad y seguridad.
* Incluida en Windows y actualizada por las actualizaciones de Windows.

*(Los siguientes videos enseñan a instalar .NET en VS Code y como agregar un package, no los voy a incluir en el resumen).*

---

## Introducción a .NET

Como ya aprendimos, .NET es una plataforma para desarrolladores de código abierto, gratuita y multiplataforma. Podemos ejecutar programas escritos en varios lenguajes y se basa en un entorno de ejecución de alto rendimiento usado en producción por muchas aplicaciones a gran escala.

La plataforma está diseñada para ofrecer productividad, rendimiento, seguridad y confiabilidad. Proporciona administración automática de memoria mediante un recolector de elementos no utilizados. Es seguro para tipos y seguro para memoria, usa un compilador de lenguaje gc y estricto. Ofrece simultaneidad a través de los elementos primitivos `async`/`await` y `Task`.

### Puntos de Diseño:
* La productividad es una pila completa con tiempo de ejecución.
* El código seguro es el modelo de proceso principal, mientras que el código no seguro permite optimizaciones más manuales.
* Se admite código estático y dinámico.
* La interoperabilidad de código nativo y los intrínsecos de hardware son de bajo costo y alta fidelidad.
* El código es portátil entre plataformas.
* La adaptación entre dominios de programación está habilitada con implementaciones especializadas del modelo de programación de uso general.
* Los estándares del sector como OpenTelemetry y gRPC se prefieren a las soluciones a medida.

### Componentes:
* **Runtime:** ejecuta el código de la aplicación.
* **Biblioteca:** proporcionan funcionalidad de utilidad como el análisis de JSON.
* **Compilador:** compila código fuente en código ejecutable.
* **SDK y otras herramientas:** permiten compilar y supervisar aplicaciones con flujos de trabajo modernos.
* **Pilas de aplicaciones:** como ASP.NET Core y Windows forms que permiten escribir aplicaciones.

> [!NOTE] Sobre C#
> C# está orientado a objetos y el entorno de ejecución admite la orientación del objeto. C# requiere recolección de basura y el tiempo de ejecución proporciona un recolector de basura de seguimiento. Las bibliotecas dan forma a esas funcionalidades en conceptos y modelos de objetos que permiten a los desarrolladores escribir algoritmos de forma productiva en flujos de trabajo intuitivos.

El sistema de tipos ofrece una amplitud significativa, atendiendo de forma similar a la seguridad, la descriptividad, el dinamismo y la interoperabilidad nativa.
La reflexión es un paradigma de "programas como datos", lo que permite que una parte de un programa realice consultas dinámicas e invoque otra, en términos de ensamblados, tipos y miembros. Especialmente útil para las herramientas y modelos de programación enlazados en tiempo de ejecución.

---

## Estrategia de lenguaje de Microsoft .NET

Como dijimos anteriormente la plataforma nos permite el uso de 3 lenguajes distintos:
* **C#:** Un lenguaje de uso general multiplataforma, amplia compatibilidad con el ecosistema y todas las cargas de trabajo de .NET. Basado en POO, incorpora características de otros paradigmas. La mayoría del entorno de ejecución y las bibliotecas de .NET se escriben en C#, y los avances en C# suelen beneficiar a todos los desarrolladores de .NET.
* **F#:** Lenguaje conciso, sólido y eficaz basado en expresiones e inmutable de forma predeterminada, centrado en el poder expresivo, simplicidad y elegancia.
* **Visual Basic:** Posee un largo historial como un lenguaje accesible que favorece la claridad sobre la brevedad, más que nada está para desarrollo para windows. El lenguaje con el tiempo se volvió más estable y es orientado a objetos.

---

## Implementaciones de .NET

Cada implementación de .NET incluye:
* Uno o más entornos de ejecución.
* Una biblioteca de clases.
* Opcionalmente, uno o más marcos de trabajo de la aplicación.
* Opcionalmente, herramientas de desarrollo.

Hay tres implementaciones principales de .NET:
1. **.NET (Core):** Es la implementación principal, se basa en una sola base de código que admite varias plataformas y muchas cargas de trabajo, como aplicaciones de escritorio de Windows y aplicaciones de consola multiplataforma, servicios en la nube y sitios web. .NET 10 es la versión más reciente de esta implementación a día de hoy.
2. **.NET Framework:** Es la implementación .NET original que existe desde 2002. Las versiones 4.5 y posteriores implementan .NET Standard, de forma que el código que tiene como destino .NET Standard se puede ejecutar en esas versiones de .NET Framework. Contiene API específicas de Windows adicionales.
3. **Mono:** Una implementación multiplataforma de .NET Framework. Es el entorno de ejecución que ha impulsado las aplicaciones de Xamarin en Android, macOS, iOS, tvOS y watchOS. También proporciona juegos creados con el motor de Unity.

---

## Bibliotecas de clases de .NET

Son el concepto de biblioteca compartida, permiten crear componentes de funcionalidad útil en módulos que pueden usar varias aplicaciones. Hay tres tipos de bibliotecas que podemos usar:
* **De clases específicas de la plataforma:** tienen acceso a todas las API de una plataforma pero solo las pueden usar las aplicaciones y bibliotecas destinadas a esa plataforma.
* **De clases portátiles:** tienen acceso a un subconjunto de las API y puede usarse en aplicaciones y bibliotecas que se destinan a varias plataformas.
* **De clases de .NET Standard:** son una fusión del concepto de específico de plataforma y portátil en un modelo único que ofrece lo mejor de ambos mundos.

---

## .NET Estándar

Es una especificación formal de las API en .NET que están disponibles en varias implementaciones de .NET. Su motivación era establecer una mayor uniformidad en el ecosistema de .NET, .NET 5 y versiones posteriores.
.NET Standard tiene versiones, cada nueva versión agrega más API. Cuando una biblioteca se compila con una determinada versión de .NET Estándar, se puede ejecutar en cualquier implementación de .NET que implemente esa versión de .NET Estándar o superior.

> [!TIP] Recomendación de Versión
> Se nos recomienda seleccionar el **.NET Standard 2.0**. La mayoría de bibliotecas de uso general no deben necesitar API fuera de .NET Standard 2.0.

Hay dos reglas de control de versiones principales:
* **Aditivo .NET:** las versiones estándar son círculos lógicos concéntricos, las versiones superiores incorporan todas las API de versiones anteriores.
* **Inmutable:** una vez entregadas, las versiones de .NET Standard se congelan.

---

## Versiones y soporte para .NET

Actualmente se admiten las siguientes versiones de .NET:
* **.NET 10** (Compatibilidad a largo plazo): admitida hasta noviembre de 2028.
* **.NET 9** (Compatibilidad con términos estándar): admitida hasta noviembre de 2026.
* **.NET 8** (Compatibilidad a largo plazo): admitida hasta noviembre de 2026.

Las versiones principales (8 y 9) incluyen nuevas características, nueva superficie de API pública y correcciones de errores.
Las versiones secundarias (como 9.0.1) también incluyen nuevas características, área expuesta de API pública y correcciones de errores, también pueden tener cambios importantes. La diferencia entre las versiones principales está en la magnitud de los cambios, ésta es menor.

---

## Glosario de .NET

* **AOT:** Compilador Ahead of Time, convierte a código máquina, ocurre antes de que la aplicación se ejecute y normalmente se realiza en un equipo diferente.
* **Modelo de aplicación:** Una API específica de la carga de trabajo.
* **ASP.NET:** Un término genérico que hace referencia tanto a la implementación original de ASP.NET como ASP.NET Core.
* **ASP.NET Core:** Implementación multiplataforma, de alto rendimiento y de código abierto de ASP.NET.
* **Ensamblado:** Un archivo `.dll` o `.exe` que puede contener una colección de API a la que puede llamarse mediante aplicaciones u otros ensamblados.
* **BCL:** Biblioteca de clases base, un conjunto de bibliotecas que conforman los espacios de nombres de `System.*`, es un marco de nivel inferior de uso general donde se compilan marcos de trabajo de la aplicación de nivel superior.
* **CLR:** Common Language Runtime, suele hacer referencia al entorno de ejecución de .NET Framework o al entorno de ejecución de .NET.
* **CoreCLR:** Common Language Runtime para .NET.
* **CoreRT:** no es una máquina virtual (como CLR), no incluye las funciones para generar y ejecutar código sobre la marcha, sin embargo incluye la GC y la capacidad para la identificación de tipos en tiempo de ejecución y la reflexión.
* **Multiplataforma:** Capacidad para desarrollar y ejecutar una aplicación que se puede usar en varios sistemas operativos diferentes.
* **Ecosistema:** Todo el software en tiempo de ejecución, las herramientas de desarrollo y los recursos de la comunidad que se usan para compilar y ejecutar aplicaciones de una tecnología determinada.
* **Marco de trabajo:** Una colección completa de API que facilita el desarrollo y la implementación de aplicaciones que se basan en una tecnología concreta.
* **GC:** Recolector de elementos no utilizados.
* **IL:** Lenguaje intermedio.
* **JIT:** Compilador Just-In-Time.

---

> [!INFO] Fuente
> **Libro:** Microsoft Visual C# Step by Step, tenth edition.
> **Capítulo:** 1. (hasta pág 24)
> ![PDF CAP 1](Bibliografia/VCSBS_Cap1.pdf)

## Escribiendo nuestro primer programa en C#

La manera más simple de aprender a programar es escribir el programa clásico del "Hola Mundo", para ello el primer capitulo nos enseñará a realizarlo con el editor de código más avanzado de toda la era "NOTEPAD" (o usando nano si sos de linux). Luego de crear las carpetas para alojar el proyecto de hola mundo, crearemos el archivo `Programa.cs` donde escribiremos la siguiente sentencia:
```csharp
System.Console.WriteLine("Hola Mundo!");
```
_(Con esto de paso aprendemos que la extensión de los programas en C# es `.cs`)_.

Ahora tenemos que crear un nuevo archivo `Hello.csproj` en la misma carpeta, donde colocaremos el siguiente texto:
```xml
<Project Sdk="Microsoft.NET.Sdk">
	<PropertyGroup>
		<OutputType>Exe</OutputType>
		<TargetFramework>net6.0</TargetFramework>
	</PropertyGroup>
</Project>
```
Eso es un ejemplo de un archivo de proyecto, las herramientas de linea de comando de .NET utilizaran ese archivo para compilar el código en una aplicación ejecutable.

Desde la terminal realizamos un `dotnet run`, que si es la primera vez que lo utilizamos descargará e instalará algunas librerías para poder compilar. También podemos usar las herramientas de la CLI para crear un proyecto. Desde la carpeta iniciamos el .NET CLI con `dotnet new console`, nos abrirá una consola en la que mediante `dir` podemos listar el contenido de la carpeta. Nos creará un archivo de proyecto que si abrimos con otra herramienta (notepad o vim) veremos el mismo contenido que nosotros hicimos a mano anteriormente. También nos generó el archivo del programa que posee una codificación ligeramente más compleja para lograr lo mismo:
```csharp
using System;

namespace HelloWorld2
{
	class Program
	{
		static void Main(string[] args)
		{
			Console.WriteLine("Hello World!");
		}
	}
}
```
> [!NOTE] Sintaxis y Detalles
> 
> - Podemos notar que su sintaxis es muy similar a Java.
>     
> - C# es un lenguaje fuertemente tipado, tenemos que escribir `Main` con la M mayúscula.
>     
> - Los comentarios se realizan mediante `//` para la misma línea o `/* */` para múltiples líneas.
>     

El resto del capítulo enseña cosas muy básicas sobre Visual Studio 2022 que voy a pasar de largo, puesto que es el uso básico de un IDE genérico.