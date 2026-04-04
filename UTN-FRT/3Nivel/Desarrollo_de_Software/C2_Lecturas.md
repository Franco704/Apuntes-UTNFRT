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