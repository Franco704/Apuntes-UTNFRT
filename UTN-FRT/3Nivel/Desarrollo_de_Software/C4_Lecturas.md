# Resumen de Lectura: [Unidad 1](Unidad%201.md) (Clase 4)

> [!INFO] Fuente
> **Libro:** Pro Git, 2da Edición.
> **Capítulo:** 5 y 6.

---

## Capítulo 5: Git en entornos Distribuidos

A diferencia de los Sistemas Centralizados de Control de Versiones, la naturaleza distribuida de Git permite mucha más flexibilidad en la manera de colaborar en proyectos.

### Flujos de Trabajo Centralizado

En sistemas centralizados habitualmente solo hay un modelo de colaboración: un repositorio o punto central que acepta código y todos sincronizan su trabajo con él. 

![](Bibliografia/Pasted%20image%2020260413201459.png)

> [!WARNING] Cuidado con las sobreescrituras
> Si dos desarrolladores clonan desde el punto central y ambos hacen cambios, solo el primer desarrollador en subir sus cambios lo podrá hacer sin problemas. El segundo **debe fusionar el trabajo del primero** antes de subir sus cambios para no sobreescribir el trabajo ajeno.

### Flujo de Trabajo Administrador-Integración

Debido a que Git permite tener múltiples repositorios remotos, es posible tener un flujo de trabajo donde cada desarrollador tenga acceso de escritura a su propio repositorio público y acceso de lectura a todos los demás. 

Este escenario a menudo incluye un repositorio canónico que representa el proyecto "oficial". 
1. Para contribuir a ese proyecto, creas tu propio clon público del proyecto y haces un `pull` con tus cambios. 
2. Luego, puedes enviar una solicitud al administrador del proyecto principal para que agregue los cambios. 
3. Entonces, el administrador agrega tu repositorio como remoto, prueba los cambios localmente, los combina en su rama y los envía al repositorio oficial.

![](Bibliografia/Pasted%20image%2020260413201852.png)

> [!TIP] Ventajas de este modelo
> Este es un flujo de trabajo muy común con herramientas basadas en hubs, donde es fácil hacer un *fork* de un proyecto e introducir los cambios en este *fork* para que todos puedan verlos. El contribuidor puede continuar realizando cambios y el administrador principal del repositorio puede incorporar los cambios en cualquier momento sin frenar el flujo de trabajo de nadie.

### Flujo de Trabajo Dictador-Tenientes

Es una variante del flujo de múltiples repositorios, generalmente utilizado por grandes proyectos con cientos de colaboradores (el ejemplo más famoso es el kernel de Linux). 

* **Tenientes:** Varios administradores de integración que están a cargo de ciertas partes específicas del repositorio.
* **Dictador Benévolo:** El gerente de integración de todos los tenientes. El repositorio del dictador benévolo sirve como el repositorio de referencia (oficial) del cual todos los colaboradores necesitan realizar `pull`.

![](Bibliografia/Pasted%20image%2020260413202355.png)

---

### Contribuyendo a un Proyecto

Debido a que Git es muy flexible, las personas pueden trabajar juntas de muchas maneras, y es problemático describir cómo *deberían* contribuir: cada proyecto es un poco diferente. Algunas de las variables involucradas son:

* **Conteo de contribuyentes activos:** Conforme tengamos más desarrolladores, nos encontraremos con más problemas para asegurarnos de que el código se aplique de forma limpia o se pueda fusionar fácilmente.
* **Flujo de trabajo elegido:** ¿Es centralizado? ¿El proyecto tiene un mantenedor? ¿Están todos los parches revisados por pares y aprobados? ¿Hay una sistema de tenientes en su lugar?
* **Acceso de confirmación:** El flujo requerido es muy diferente si tenemos acceso de escritura al proyecto que si no lo tenemos. Si no lo tenemos, ¿cómo prefiere el proyecto aceptar el trabajo contribuido? ¿Con qué frecuencia se contribuye?

### Pautas de Confirmación (Commits)

1. **Evitar errores de espacios en blanco:** Git proporciona una manera fácil de verificar esto. Antes de comprometerte, ejecuta `git diff --check`. Esto identifica posibles errores de espacio en blanco y los enumera, evitando molestias a otros desarrolladores.
2. **Cambios lógicamente separados:** Intenta hacer de cada commit un conjunto de cambios digeribles, no pushear un cúmulo de trabajo grande de golpe. Puedes utilizar el área de preparación (*staging area*) para dividir el trabajo en al menos una confirmación por cuestión, usando `git add --patch` para preparar parcialmente los archivos.
3. **Calidad del mensaje del commit:** Tener el hábito de crear mensajes de calidad hace que colaborar con Git sea mucho más fácil.

> [!NOTE] Regla de Oro para Mensajes de Commit
> Como regla general, tus mensajes deben comenzar con una sola línea que **no supere los 50 caracteres** y que describa el conjunto de cambios de forma concisa. A esto le debe seguir una línea en blanco, y posteriormente una explicación más detallada.

![](Bibliografia/Pasted%20image%2020260413203941.png)

#### Pequeño equipo privado
![](Bibliografia/Pasted%20image%2020260413204805.png)

#### Equipo privado administrado
![](Bibliografia/Pasted%20image%2020260413204914.png)

---

### Proyecto Público Bifurcado (Forked)

Contribuir a proyectos públicos es un poco diferente. Como no tenemos los permisos para actualizar directamente las ramas en el proyecto, debemos proponer el trabajo de otra manera.

Secuencia habitual para aportar mediante parches/forks:
1. Clonar el repositorio principal.
2. Crear una rama de tema (topic branch) para el parche o la serie de parches con los que planeamos contribuir, y hacer nuestro trabajo allí. 
   *(Opcional)*: Podemos usar `rebase -i` para reducir el trabajo a una única confirmación o reorganizarlo para que el revisor pueda leer el parche más fácilmente.

![](Bibliografia/Pasted%20image%2020260413205506.png)

3. Ir a la página original del proyecto y hacer clic en **"FORK"**, creando nuestro propio fork escribible.
4. Agregar esta nueva URL de repositorio como segundo remoto (ej. `myfork`): 
   `git remote add myfork <url>`
5. Impulsar nuestra rama de tema al fork: 
   `git push -u myfork featureA`
6. Generar una solicitud de extracción (*Pull Request*). Si el proyecto prefiere correos, se puede ejecutar `git request-pull` y enviar por correo electrónico la salida al mantenedor de forma manual. Este comando genera un resumen de todos los cambios que estamos solicitando.

---

### Manteniendo un Proyecto

Además de saber cómo contribuir, debemos saber cómo mantener un proyecto. Esto abarca desde aceptar parches vía `format-patch` por correo, hasta integrar ramas remotas de repositorios que añadimos.

#### Trabajando en ramas puntuales (Topic Branches)
Al integrar nuevo trabajo, es buena idea probarlo en una rama temporal específica. De esta forma, es fácil ajustar un parche individualmente o abandonarlo si no funciona. 
* *Nomenclatura recomendada:* `nombre_del_colaborador/nombre_del_tema` (Ejemplo: `sc/ruby_client`).

#### Aplicando parches recibidos por e-mail

Hay dos formas principales de evaluar e integrar parches recibidos:

**1. Aplicando parches con `apply`**
Si el parche se generó con `git diff`, se aplica con `git apply`. Ejemplo:
`git apply /tmp/patch-ruby-client.patch`
Esto modifica los archivos en el directorio de trabajo (similar a `patch -p1`, pero más estricto y capaz de manejar archivos nuevos/borrados/renombrados).
* *Tip:* Usa `git apply --check /tmp/patch-ruby-client.patch` para comprobar si un parche se aplicará limpiamente antes de ejecutarlo.

**2. Aplicando un parche con `am` (Recomendado)**
Si el colaborador generó el parche con `format-patch`, el trabajo es más sencillo porque ya contiene información del autor y un mensaje de commit.
* Se aplica con: `git am` (originalmente construido para leer archivos *mbox*).
* Si falla por conflictos, el proceso se pausa. Se resuelve como un `merge` o `rebase`: editas el archivo, lo preparas y ejecutas `git am --resolved`.

#### Decidiendo qué introducir
Para obtener una lista de todos los commits de una rama que *no* están en nuestra rama principal, podemos usar el modificador `--not`. Ejemplo: comparar una rama puntual excluyendo lo que ya está en master.

#### Etiquetando las versiones (Tags)
Cuando lanzamos una versión, podemos crear una etiqueta. 
![](Bibliografia/Pasted%20image%2020260413213249.png)

> [!INFO] Etiquetas Firmadas
> Si decides firmar tus etiquetas, necesitarás distribuir tu clave PGP Pública. Puedes incluir tu clave pública como un objeto binario en el repositorio usando `git hash-object` (tras listar tus claves con `gpg --list-keys`) y crear una etiqueta que apunte directamente a ese SHA-1.

#### Generando un número de compilación
Como Git no genera números correlativos automáticamente (tipo v1, v2, v3...), puedes usar el comando `git describe` para generar un nombre comprensible y único para un commit específico.

#### Preparando una versión (Release)
Para empaquetar una instantánea del código para personas que no usan Git, utilizamos `git archive`.
![](Bibliografia/Pasted%20image%2020260413213730.png)
Esto genera, por ejemplo, un archivo `.tar` o `.zip` con el estado actual del proyecto limpio.

---

## Capítulo 6: GitHub

### Creación y Configuración de la Cuenta

GitHub proporciona toda su funcionalidad principal en cuentas gratuitas, permitiendo proyectos públicos y privados ilimitados (con limitación de colaboradores en los privados para planes gratis).

* **Acceso SSH:** Si prefieres utilizar SSH en lugar de HTTPS, necesitas configurar una clave pública en tu cuenta.
* **Tu icono / Correos:** Puedes personalizar tu avatar y vincular múltiples direcciones de correo (útil para que GitHub identifique todas tus contribuciones de Git, independientemente del correo que usaste en local).
* **Seguridad:** Es altamente recomendable configurar la Autentificación de Dos Pasos (2FA).

---

### Participando en Proyectos

#### Bifurcación (Fork) de proyectos
Para participar en un proyecto sin permisos de escritura, debes hacer un *fork*. Solo visita la página del proyecto y pulsa el botón **"Fork"**. Esto creará una copia del código fuente en tu cuenta.

#### El flujo de Trabajo en GitHub
GitHub está diseñado alrededor de un flujo de colaboración centrado en los **Pull Requests** (Solicitudes de Integración).

![](Bibliografia/Pasted%20image%2020260413215211.png)

> [!NOTE] Recordatorio
> Esto es básicamente el flujo de trabajo del Responsable de Integración (visto en el Capítulo 5), pero sustituyendo el intercambio de correos electrónicos por las herramientas web y visuales de GitHub.

#### Creación del Pull Request
1. Haces un Fork.
2. Clonas localmente, creas una rama, realizas el cambio y haces *push* a tu repositorio en GitHub.
![](Bibliografia/Pasted%20image%2020260413215604.png)
3. En GitHub aparecerá un aviso de la nueva rama con un botón para **"Compare & pull request"**.
![](Bibliografia/Pasted%20image%2020260413215913.png)
4. Al pulsar el botón verde, añades un título y descripción justificando el cambio. Podrás ver el "diff unificado" de los cambios propuestos.
![](Bibliografia/Pasted%20image%2020260413220027.png)
5. Al crearlo, el propietario del proyecto recibirá una notificación.

#### Evolución del Pull Request
El propietario puede revisar el cambio, incorporarlo, comentarlo o rechazarlo.
![](Bibliografia/Pasted%20image%2020260413220651.png)

Los comentarios se pueden dejar línea por línea directamente en el código ("diff").
![](Bibliografia/Pasted%20image%2020260413220757.png)

Si hay que hacer correcciones, el colaborador solo tiene que hacer nuevos commits en su rama local y hacer *push*. El Pull Request en GitHub se actualizará automáticamente con los nuevos cambios.
![](Bibliografia/Pasted%20image%2020260413220856.png)

#### Pull Requests como Parches y Mantenimiento
Casi todos los proyectos de GitHub consideran las ramas de Pull Request como **conversaciones evolutivas**, no como parches perfectos a la primera.

Si un Pull Request se queda anticuado y surgen conflictos, el colaborador debe:
* Hacer *Rebase* de su rama con la rama `master` del original.
* O bien, fusionar la rama objetivo en la suya propia para arreglar los conflictos localmente y volver a subir.
![](Bibliografia/Pasted%20image%2020260413221702.png)
![](Bibliografia/Pasted%20image%2020260413221828.png)

---

### Markdown en GitHub (GFM)

GitHub utiliza un formato enriquecido de Markdown que incluye características extra muy útiles:
* **Listas de tareas:** ![](Bibliografia/Pasted%20image%2020260413222601.png)
* **Fragmentos de código:** Para mostrar bloques de código en los comentarios.
  ![](Bibliografia/Pasted%20image%2020260413222702.png)
  ![](Bibliografia/Pasted%20image%2020260413222710.png)
* **Citas Específicas:** Permiten citar y responder a partes concretas de un comentario largo.
  ![](Bibliografia/Pasted%20image%2020260413222738.png)
  ![](Bibliografia/Pasted%20image%2020260413222748.png)
* **Emojis:** ![](Bibliografia/Pasted%20image%2020260413222826.png)

---

### Mantenimiento de un Proyecto en GitHub

#### Creación y Configuración Básica
Para crear un nuevo repositorio, usa el botón **"+"** o **"New Repository"**.
![](Bibliografia/Pasted%20image%2020260413222959.png) ![](Bibliografia/Pasted%20image%2020260413223014.png)
* **Colaboradores:** Puedes dar acceso directo de escritura a otras personas desde la configuración del repositorio.
* **Notificaciones por correo:** Recibirás correos cuando te abran un Pull Request.
![](Bibliografia/Pasted%20image%2020260413223254.png)

#### Referencias de Pull Request Avanzadas (`ls-remote`)
En GitHub, las ramas de los Pull Requests son pseudo-ramas ocultas en el servidor que el clonado por defecto ignora. 
Con el comando `git ls-remote origin` puedes ver todas las referencias del servidor.
![](Bibliografia/Pasted%20image%2020260413223554.png)

Los Pull Requests tienen el prefijo `refs/pull/`. Puedes obtener (`fetch`) un PR específico directamente configurando tu archivo Git o llamando al comando exacto sin necesidad de agregar un control remoto (*remote*) por cada persona que contribuya.
![](Bibliografia/Pasted%20image%2020260413224427.png)

#### Archivos Especiales
* **`README.md`:** Se renderiza automáticamente en la página principal del proyecto.
* **`CONTRIBUTING.md`:** Si existe, GitHub mostrará un aviso enlazando a este archivo cuando alguien intente abrir un Issue o Pull Request, guiándolos sobre cómo prefieres recibir las contribuciones.
![](Bibliografia/Pasted%20image%2020260413224856.png)

#### Administración del Proyecto
* **Cambiar la rama predeterminada:** Puedes elegir que la rama principal sea otra distinta a `master` (ej. `main` o `develop`).
![](Bibliografia/Pasted%20image%2020260413225005.png)
* **Transferir propiedad:** Puedes ceder el proyecto a otra organización o usuario.

#### Scripting en GitHub (Hooks y Servicios)
Desde la configuración (*Settings* -> *Webhooks and Services*) puedes integrar GitHub con sistemas externos.
![](Bibliografia/Pasted%20image%2020260413225451.png)
* **Servicios:** Integraciones prefabricadas con sistemas de CI/CD, gestores de tickets, chats, etc.
* **Hooks (Enganches):** Más genéricos; configuras una URL y GitHub enviará una petición HTTP (payload) cada vez que suceda un evento específico (ej. un *push* o un nuevo *Pull Request*).