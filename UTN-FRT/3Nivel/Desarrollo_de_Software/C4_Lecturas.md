#  Resumen de Lectura: [Unidad 1](Unidad%201.md) (Clase 4)

> [!INFO]  Fuente
> **Libro:** Pro Git, 2da Edición.
> **Capítulo:** 5 y 6.

### Capitulo 5 "Git en entornos Distribuidos"

A diferencia de los Sistemas Centrailzados de Control de Versiones, la naturaleza distribuida de Git permite mucha más flexibilidad en la manera de colaborar en proyectos.

## Flujos de Trabajo Centralizado

En sistemas centralizados habitualmente solo hay un modelo de colaboración, un repositorio o punto central que acepta código y todos sincronizan su trabajo con el. 
![](../../../Pasted%20image%2020260413201459.png)
Si dos desarrolladores clonan desde el punto central, y ambos hacen cambios, soo el primer desarrollador en subir sus cambios lo podrá hacer sin problemas, el segundo debe fusionar el trabajo del primero antes de subir sus cambios, para no sobreescribir los cambios del primero.

## Flujo de Trabajo Administrador-Integración

Debido a que Git permite tener múltiples repositorios remotos, es posible tener un flujo de trabajo donde cada desarrollador tenga acceso de escritura a su propio repositorio público y acceso de lectura a todos los demás. Este escenario a menudo incluye un repositorio canónico que representa el proyecto "oficial". Para contribuir a ese proyecto creas tu propio clon público del proyecto y haces un pull con tus cambios. Luego, puede enviar una solicitud al administrador del proyecto principal para que agregue los cambios. Entonces, el administrador agrega el repositorio como remoto, prueba los cambios localmente, los combina en su rama y los envía al repositorio.
![](../../../Pasted%20image%2020260413201852.png)
Este es un flujo de trabajo muy común con herramientas basadas en hubs, donde es fácil hacer un fork de un proyecto e introducir los cambios en este fork para que todos puedan verlos. Una de las principales ventajas de este enfoque es que el contribuidor puede continuar realizando cambios y el administrador principal del repositorio puede incorporar los cambios en cualquier momento. Los contribuidores no tienen que esperar a que el proyecto incorpore sus cambios.

## Flujo de Tabajo Dictador-Tenientes

Es una variante del flujo de múltiples repositorios. Generalmente es utilizado por grandes proyectos con cientos de colaboradores (Ejemplo famoso el kernel de Linux). Varios administradores de integración están a cargo de ciertas partes del repositorio. Se les llaman "tenientes". Todos los tenientes tienen un gerente de integración conocido como el "dictador benévolo". El repositorio del dictador benevolente sirve como el repositorio de referencia del cual todos los colaboradores necesitan realizar pull.
![](../../../Pasted%20image%2020260413202355.png)


## Contribuyendo a un Proyecto

Debido a que Git es muy flexible, las personas pueden trabajar juntas de muchas maneras, y es problemático describir como deberían contribuir: cada proyecto es un poco diferente. Algunas de las variables involucradas son conteo de contribuyentes activos, flujo de trabajo elegido, acceso de confirmación y posiblemente el método de contribución externa.
Nuestra primera variable es el conteo de contribuyentes activos,  conforme tengamos más desarrolladores, nos encontraremos con más problemas para asegurarnos de que el código se aplique de forma limpia o se pueda fusionar fácilmente. Los cambios que enviemos pueden quedar obsoletos o severamente interrumpidos por el trabajo que se fusionó mientras trabajábamos o mientras los cambios estaban esperando a ser aprobados o aplicados.
La siguiente variable es el flujo de trabajo en uso para el proyecto, ¿es centralizado con cada desarrollador teniendo el mismo acceso de escritura a la linea de código principal?¿el proyecto tiene un mantenedor?¿están todos los parches revisados por pares y aprobados?¿estamos involucrados en ese proceso?¿hay una sistema de tenientes en su lugar, y tiene que enviar su trabajo primero?
El siguiente problema es el acceso de confirmación. El flujo de trabajo requerido para contribuir a un proyecto es muy diferente si tenemos acceso de escritura al proyecto que si no lo tiene. Si no tenemos acceso de escritura, ¿como prefiere el proyecto aceptar el trabajo contribuido?¿incluso tiene una política?¿cuánto trabajo estamos contribuyendo a la vez?¿con qué frecuencia contribuimos?

## Pautas de Confirmación

En primer lugar, no se desea enviar ningún error de espacios en blanco. Git proporciona una manera fácil de verificar esto: antes de comprometerse, ejecutando `git diff --check` identificamos posibles errores de espacio en blanco y nos lo enumera. Si ejecutamos ese comando antes de continuar, podemos ver si está a punto de cometer errores de espacio en blanco que pueden molestar a otros desarrolladores.
A continuación, intentemos hacer de cada commit un conjunto de cambios lógicamente separado, si se puede tratar de hacer cambios digeribles, no pushear un cumulo de trabajo grande de golpe, incluso podemos utilizar el área de etapas para dividir el trabajo en al menos una confirmación por cuestión, con un mensaje útil por confirmación. Si algunos de los cambios modiifcan el mismo archivo, intentemos utilizar `git add --patch` para representar parcialmente los archivos.
Lo ultimo a tener en cuenta es el mensaje de compromiso. Tener el habito de crear mensajes de calidad hace que usar y colaborar con Git sea mucho más fácil. Como regla general, sus mensajes deben comenzar con una sola línea que no supere los 50 caracteres y que describa el conjunto d ecambios de forma concisa, seguido de una linea en blanco, seguida de una explicación más detallada.
![](../../../Pasted%20image%2020260413203941.png)


## Pequeño equipo privado
![](../../../Pasted%20image%2020260413204805.png)

## Equipo privado administrado
![](../../../Pasted%20image%2020260413204914.png)

## Proyecto público bifurcado

Contribuir a proyectos públicos es un poco diferente. Como no tenemos los permisos para actualizar directamente las ramas en el proyecto, debemos obtener el trabajo de otra manera. 
La siguiente parte trata de proyectos que prefieren aceptar parches contribuidos por correo electrónico.
En primer lugar, es probable que deseemos clonar el repositorio principal, crear una rama de tema para el parche o la serie de parches en que planeamos contribuir y hacer nuestro trabajo allí. La secuencia se ve básicamente así: 
![](../../../Pasted%20image%2020260413205506.png)
Podemos usar `rebase -i` para reducir el trabajo a una unica confirmacion, o reorganizar le trabajo en las confirmaciones para que el desarrollador pueda revisar el parche más fácilmente.
Cuando finalicemos el trabajo en la rama y estemos listos para contribuir con los mantenedores vamos a la página original del proyecto y hacemos click en el botón "FORK", creando nuestro propio fork escribible del proyecto. Luego debemos agregar esta nueva URL de repositorio como segundo control remoto, en este caso llamado myfork: `git remote add myfork (url)`
Entonces necesitamos impulsar nuestro trabajo a esa nueva URL. Es más facil impulsar la rama de tema en la que se esta trabajando hasta su repositorio, en lugar de fusionarse con la rama principal y aumentarla. `git push -u myfork featureA`
Cuando nuestro trabajo ha sido empujado al fork, debemos notificar al mantenedor, a menudo se denomina solicitud de extracción y podemos generarlo a través del sitio web, se puede ejecutar el comando `git request-pull` y enviar por correo electrónico la salida al mantenedor del proyecto de forma manual.
El comando `request-pull` toma la rama base en la que se desea que se saque su rama de tema y la URL del repositorio de Git de la que se desea que extraigan, y genera un resumen de todos los cambios que estamos solicitando.

## Manteniendo un proyecto

Además de saber cómo contribuir de manera efectiva a un proyecto debemos saber cómo mantenerlo. Eso puede comprender desde aceptar y aplicar parches generados vía `format-patch` enviados por correo, hasta integrar cambios en ramas remotas para repositorios que añadimos como remotos a nuestro proyectos.

## Trabajando en ramas puntuales

Cuando estamos pensando en integrar nuevo trabajo, generalmente es una buena idea probarlo en una rama puntual (topic branch), una rama temporal específicamente creada para probar ese nuevo trabajo. De esta forma, es fácil ajustar un parche individualmente y abandonarlo si no funciona hasta que tengamos el tiempo de retomarlo. Si creamos una rama simple con un nombre relacionado con el trabajo que vamos a probar, como `ruby_client` o algo igualmente descriptivo, podemos recordarlo fácilmente si tenemos que abandonarlo y retomarlo posteriormente. El responsable del mantenimiento del proyecto GIt también tiende a usar una nomenclatura con este formato - como `sc/ruby_client`, donde `sc` es la abreviatura de la persona que envió el trabajo.

## Aplicando parches recibidos por e-mail

Si recibimos por correo un parche que necesitamos integrar en nuestro proyecto, debemos aplicarlo en la rama puntual para evaluarlo. Hay dos formas de aplicar un parche, veamos cuales son:

## Aplicando parches con `apply`
Si recibimos el parche de alguien que lo generó con `git diff` o con el comando Unix `diff` (no recomendado) podemos aplicarlo con el comando `git apply`, suponiendo que guardamos el parche en `/tmp/patch-ruby-client.patch` podemos aplicarlo así: `git apply /tmp/patch-ruby-client.patch` 
Esto modifica los archivos en nuestro directorio de trabajo. Es casi idéntico al ejecutar un comando `patch -p1` para aplicar el parche, aunque es más paranoico y acepta menos coincidencias aproximadas que patch. Tambien puede manejar archivos nuevos, borrados y renombrados si están descritos en formato `git diff` mientras que `patch` no puede hacerlo.
También podemos usar `git apply` para comprobar si un parche se aplica de forma limpia antes de aplicarlo realmente - podemos ejecutar `git apply --check` indicando el parche.

## Aplicando un parche con `am`
Si el colaborador es un usuario de Git y conoce lo suficiente como para usar el comando `format-patch` para generar el parche, entonces el trabajo es más sencillo, puesto que el parche ya contiene información del autor y un mensaje de commit. Si podemos, animemos a nuestros colaboradores a usar `format-patch` en lugar de `diff`.
Para aplicar un parche generado con `format-patch`, usamos `git am`. Técnicamente, `git am` se construyó para leer de un archivo de mbox.
Es posible que el parche no se aplique limpiamente, quizas nuestra rama principal es muy diferente de la rama a partir de la cual se creó el parche, o el parche depende de otro parque que aún no hemos aplicado. En ese caso, el proceso `git am` fallará y nos preguntará que hacer, esos problemas se solucionan de la misma forma que `merge` o `rebase`, editamos el archivo para resolver el conflicto, preparamos y ejecutamos `git am --resolved`

## Decidiendo qué introducir
A menudo es útil obtener una lista de todos los commits de una rama que no están en nuestra rama principal. Podemos excluir de dicha lista los commits de la rama principal anteponiendo la opción `--not` al nombre de la rama

## Etiquetando las versiones
Cuando lanzamos una versión, y queremos etiquetarla para poder generarla más adelante en cualquier momento, podemos crear una nueva etiqueta. Si decidimos firmar la etiqueta como responsable de mantenimiento, el etiquetado seria algo asi:
![](../../../Pasted%20image%2020260413213249.png)
Si firmamos nuestras etiquetas podemos tener problemas a la hora de distribuir la clave PGP Publica usada para firmarlas. El responsable de mantenimiento del proyecto Git ha conseguido solucionar este problema incluyendo su clave publica como un objeto binario en el repositorio, añadiendo a continuación una etiqueta que apunta directamente a dicho contenido. Para hacer esto, puedes averiguar que clave necesitas lanzando el comando `gpg --list-keys`
Ahora ya podemos importar directamente la clave en la base de datos de Git, exportandola y redirigiéndola a través del comando `git hash-object`.
Una vez que tenemos los contenidos de la clave en Git, podemos crear una etiqueta que apunte directamente a dicha clave indicando el nuevo valor SHA-1 que devolvió el comando hash-object.

## Generando un número de compilación
Como Git no genera una serie de números monótamente creciente como v123 o similar con cada commit, si queremos tener un nombre más comprensible para un commit, podemos ejecutar el comando `git describe`.

## Preparando una versión
Una cosa que podemos hacer es crear un archivo con la ultima instantánea del código para las pobres almas que no usan Git. El comando es `git archive`
![](../../../Pasted%20image%2020260413213730.png)
Si alguien abre el archivo tar, obtiene la última instantánea de tu proyecto bajo un directorio project.


# Capitulo 6: GitHub

## Creación y configuración de la cuenta
Lo primeros que necesitamos hacer es crear una cuenta de usuario, elegimos nuestro nombre de usuario, correo, contraseña y creamos la cuenta.
GitHub proporciona toda su funcionalidad en cuentas gratuitas, podemos tener tantos proyectos públicos como privados ilimitados. La unica limitación es que en cada uno de nuestros proyectos privados solo podemos tener un máximo de tres colaboradores. Los planes de pago de GitHub te permiten tener algunas herramientas extras, pero no es algo que veremos en el libro.

## Acceso SSH
Desde ya, podemos acceder a los repositorios Git mediante el protocolo HTTPS, identificándonos con el usuario y la contraseña que elegimos. Sin embargo para simplificar el clonado de proyectos públicos no necesitamos crear una cuenta.
Si preferimos utilizar SSH, necesitamos configurar una clave pública.

## Tu icono
También, si lo deseamos podemos reemplazar nuestro avatar con una imagen de nuestra elección.

## Tus direcciones de correo
La forma con la que GitHub identifica tus contribuciones a Git es mediante la direccion de correo electrónico. Si tenemos varias direcciones diferentes en nuestras contribuciones y queremos que GitHub sepa que son de tu cuenta, necesitas añadirlas todas en el apartado Emails de la sección administración.

## Autentificación de dos pasos
Finalmente, y para mayor seguridad, deberías configurar el 2FA.

Participando en Proyectos
Bifurcación (fork) de proyectos.
Si queremos participar en un proyecto existente, en el que no tenemos permisos de escritura, podemos hacerle un fork.
Para bifurcar un proyecto, visitamos la página del mismo y pulsamos sobre el botón "Fork", en unos segundos nos redireccionarán a una página nueva de proyecto en nuestra cuenta y con nuestra propia copia del código fuente.

## El flujo de Trabajo en GitHub
GitHub está diseñando alrededor de un flujo de trabajo de colaboración específico, centrado en las solicitaciones de integración (pull request). El funcionamiento habitual es el siguiente:
![](../../../Pasted%20image%2020260413215211.png)

Esto es básicamente, el flujo de trabajo del Responsable de Integración visto en Flujo de Trabajo Administrador-Integración, pero en lugar de usar el correo para comunicarnos y revisar los cambios, lo que se hace es usar las herramientas web de GitHub.

## Creación del Pull Request
Comenzamos pulsando el botón Fork, y en la copia comenzar a trabajar, la clonamos localmente, creamos una rama, realizamos el cambio sobre el código fuente y finalmente enviamos esos cambios a GitHub.
![](../../../Pasted%20image%2020260413215604.png)
Ahora, si miramos nuestra bifurcación en GitHub, veremos que aparece un aviso de creación de la rama y nos dará la oportunidad de hacer una solicitud de integración con el proyecto original.
![](../../../Pasted%20image%2020260413215913.png)
Si pulsamos en el botón verde, veremos una pantalla que permite crear un titulo y una descripcion para darle al propietario original una buena razón para tenerla en cuenta.
Tambien veremos la lista de commits de la rama que están "por delante" de la rama master y un "diff unificado" de los cambios que se aplicarían si se fusionasen con el proyecto original.
![](../../../Pasted%20image%2020260413220027.png)
Cuando seleccionemos el botón create pull request, el propietario del proyecto recibirá una notificación de que alguien sugiere un cambio 
junto a un enlace donde está toda la información.

## Evolución del Pull Request
En este punto, el propietario puede revisar el cambio sugerido e incorporarlo al proyecto, o bien rechazarlo o comentarlo.
![](../../../Pasted%20image%2020260413220651.png)
El propietario puede revisar el "diff" y dejar un comentario pulsando en cualquier linea del "diff", cuando el responsable hace el comentario, la persona que solicitó la integración recibirán una notificación.
Cualquiera puede añadir sus propios comentarios. 
![](../../../Pasted%20image%2020260413220757.png)
El participante puede ver ahora qué tiene que hacer para que sea aceptado su cambio. Con suerte será poco trabajo. Mientras que con el correo electronico tendrias que revisar los cambios y reenviarlos, en GitHub puedes, simplemente, enviar un nuevo commit a la rama y subirla.
![](../../../Pasted%20image%2020260413220856.png)
Es interesante notar que si pulsamos en "Files Changed", verás el "diff unificado", es decir, los cambios que se introducirán en la rama principal si la otra rama fuera fusionada.
Otra cosa interesante es que GitHub también comprueba si el Pull Request se fusionaría limpiamente, dando entonces un botón para hacerlo.

## Pull Requests Avanzados

## Pull Requests como parches
Hay que entender que muchos proyectos no tienen idea de que los Pull Request sean colas de parches perfectos que se pueden aplicar limpiamente en orden, como sucede con los proyectos basados en listas de correo. Casi todos los proyectos de GitHub consideran las ramas de Pull Request como conversaciones evolutivas acerca de un cambio propuesto, culminando en un "diff" unificado que se aplica fusionando.

## Manteniendonos actualizados
Si el pull request se queda anticuado, lo normal es corregirlo para que el responsable pueda fusionarlo fácilmente.
![](../../../Pasted%20image%2020260413221702.png)
Si vemos algo parecido a Pull request que no puede fusionarse limpiamente, seguramente prefieras corregir la rama de forma que se vuelva verde denuevo y el responsable no tenga trabajo extra con ella.
Tienes dos opciones para hacer esto. Por un lado podemos reorganizar (rebase) la rama con el contenido de la rama master o bien podemos fusionar la rama objetivo en la tuya.
Muchos desarrolladores eligen la segunda opción.
![](../../../Pasted%20image%2020260413221828.png)

## Markdown
El formato Markdown es como escribir en texto plano pero que luego se convierte en texto con formato. 
En GitHub se añaden algunas cosas a la sintaxis básica del Markdown, son útiles al tener relacion con los pull requests o las incidencias.
La prmera caracteristica añadida son las listas de tareas, podemos crear una lista de tareas así: ![](../../../Pasted%20image%2020260413222601.png)
Además se mostraran esas listas de tareas como metadatos de las páginas que las muestran.
También se pueden añadir fragmentos de código a los comentarios. Esto resulta útil para mostrar algo que nos gustaria probar antes de ponerlo en un commit de nuestra rama.
![](../../../Pasted%20image%2020260413222702.png)
![](../../../Pasted%20image%2020260413222710.png)

Citas, si estámos respondiendo a un comentario grande, pero solo a una parte podemos citarlo.
![](../../../Pasted%20image%2020260413222738.png)
![](../../../Pasted%20image%2020260413222748.png)
Tambien podemos agregar emojis ![](../../../Pasted%20image%2020260413222826.png)
También podemos añadir enlaces con imágenes en el formato Markdown a los comentarios.

## Mantenimiento de un proyecto
## Creación de un repositorio
Vamos a crear un nuevo repositorio, tocamos en "New Repository" o bien desde el botón "+" en la barra de botones cercano al nombre de usuario.
![](../../../Pasted%20image%2020260413222959.png)![](../../../Pasted%20image%2020260413223014.png)
Tenemos que darle un nombre al proyecto, dado que al crearlo no tendra contenido, GitHub nos mostrará instrucciones para crear el repositorio Git, o para conectarlo a un proyecto existente.

## Añadir Colaboradores
Si estamos trabajando con otras personas y queremos darle acceso de escritura debemos añadirlos como colaboradores.

## Gestión de los Pull Requests
Ahora que tenemos un proyecto con algo de código, veremos que pasa cuando alguien hace un pull request.

## Notificaciones por correo electronico.
Cuando alguien realiza un cambio en el código y te crea un Pull Request, debes recibir una notificación por correo electrónico avisándote, con un aspecto similar a Notificación por correo de nuevo Pull Request.
![](../../../Pasted%20image%2020260413223254.png)

## Referencias de Pull Request
Si tenemos muchos Pull Request y no queremos añadir un montón de remotos o hacer muchos cada vez, hay un pequeño truco que GitHub te permite. Es un poco avanzado y lo veremos en detalle después.
En GitHub tenemos que las ramas de Pull Request son una especie de pseudo-ramas del servidor. De forma predeterminada no las obtendrás cuando hagas un clonado, pero hay una forma algo oscura de acceder a ellos.
Para demostrarlo, usaremos un comando de bajo nivel llamado `ls-remote`. Este comando no se suele usar en el día a día de GIt pero es útil para ver las referencias presentes en el servidor.
Si ejecutamos este comando sobre el repositorio "blink" que se uso anteriormente obtendremos una lista de ramas, etiquetas y otras referencias del repositorio.
![](../../../Pasted%20image%2020260413223554.png)
Por supuesto, si estamos en nuestro repositorio y tecleamos `git ls-remote origin` podemos ver algo similar pero para el remoto etiquetado como origin.
Si el repositorio está en GitHub y tenemos Pull Requests abiertos, tendremos estas referencias con el prefijo `refs/pull`. Básicamente, son ramas, pero ya que no están bajo `refs/heads/`, no las obtendrás normalmente cuando clonas o te bajas el repositorio del servidor, ya que el proceso de obtención las ignora.
Hay dos referencias por cada Pull Requests, la que termina en `/heads` apunta exactamente al último commit de la rama del Pull Request. Así si alguien abre un Pull Request en el repositorio y su rama se llama `bug-fix` apuntando al commit `a5a775`, en nuestro repositorio no tendremos una rama `bug-fix` pero tendremos el `pull/<pr#>/head` apuntando a `a5a775`. Esto significa que podemos obtener fácilmente cada Pull Request sin tener que añadir un monton de remotos.
Ahora podemos obtenerlo directamente.
![](../../../Pasted%20image%2020260413224427.png)

## Menciones y notificaciones
En cualquier comentario si comenzamos una palabra anteponiendo "@" podemos realizar una mencion a un usuario colaborador.

## Archivos Especiales
## README
Puede estar en varios formatos, con los nombres "README","README.md", "README.asciidoc" y alguno más. Cuando GitHub detecta su presencia en el proyecto, lo muestra en la página principal, con el renderizado que corresponda a su formato.

## CONTRIBUTING
Si tenemos un archivo con este nombre y cualquier extensión, se mostrará algo como APertura de un Pull Request cuando existe el archivo Contributing, cuando se intente abrir un pull request.
![](../../../Pasted%20image%2020260413224856.png)

## Administración del proyecto
Por lo general, no hay muchas cosas que administrar en un proyecto concreto, pero hay un par de cosas que pueden ser interesantes.

## Cambiar la rama predeterminada
Si usamos como rama predeterminada una que no sea "master", por ejemplo para que sea objetivo de los Pull Request, podemos cambiarla en las opciones de configuración del repositorio.
![](../../../Pasted%20image%2020260413225005.png)

## Transferencia de un proyecto
Si queremos transferir la propiedad de un proyecto a otro usuario u organización, hay una opción para ello.


## Scripting en GItHub

## Enganches (Hooks)
Las secciones Hooks y Services, de la pagina de administración del repositorio en GIthub, es la forma más simple de hacer que GitHub interactúe con sistemas externos.

## Servicios
En primer lugar, echaremos un ojo a los Servicios. Ambos, enganches y servicios, pueden configurarse desde la sección Settings del repositorio, el mismo sitio donde vimos que podíamos añadir colaboradores. Bajo la opción "Webhooks and Services"
![](../../../Pasted%20image%2020260413225451.png)
Hay muchos servicios que podemos elegir, muchos de ellos para integrarse en otros sistemas de código abierto o comerciales. Muchos son servicios de integración continua, gestores de incidencias y fallos, salas de charla y sistemas de documentación.

## Hooks
Si necesitamos algo más concreto o queremos integrarlo con un servicio o sitio no incluido en la lista podemos usar el sistema de enganches, indicamos una URL y GitHub enviara una peticion HTTP a dicha URL cada vez que suceda el evento que queramos.