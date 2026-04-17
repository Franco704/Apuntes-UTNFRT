#  Resumen de Lectura: [Unidad 1](Unidad%201.md) (Clase 3)

> [!INFO]  Fuente
> **Libro:** Pro Git, 2da Edición.
> **Capítulo:** 3.

## Ramificaciones en Git
## ¿Qué es una rama?

Una rama Git es simplemente un apuntador móvil apuntando a un commit. La rama por defecto de Git es la rama `master`. Con la primera confirmación de cambios que realicemos, se creará esta rama principal `master` apuntando a dicha confirmación.

## Crear una Rama Nueva
Cuando creamos una nueva rama se crea un nuevo apuntador para moverlo libremente. Se realiza mediante el comando `git branch [nombre]`
Mediante el apuntador especial HEAD git sabe en que rama estamos en este momento. En git el apuntador apunta a la rama local en la que estamos en ese momento, con el comando `git branch` solamente creamos una nueva rama, no saltamos a dicha rama.

## Cambiar de Rama
Para saltar de una rama a otra tenemos que utilizar el comando `git checkout [nombre]`
Si realizamos un commit unicamente avanzara la rama en la que estamos posicionados.

## Procedimientos Básicos para Ramificar y Fusionar
Supongamos un flujo de trabajo como el siguiente:
	1. Trabajamos en un sitio web.
	2. Creamos una rama para un nuevo tema sobre el cual trabajaremos
	3. Realizamos algo de trabajo en esa rama
En ese momento, recibimos una llamada avisándonos de un problema critico a resolver y realizamos lo siguiente:
1. Volvemos a la rama de producción original.
2. Creamos una nueva rama para el problema critico y lo resolvemos trabajando ahí.
3. Tras las pertinentes pruebas, fusionamos (merge) esa rama y la enviamos (push) a la rama de producción.
4. Volvemos a la rama del tema anterior a la llamada y continuamos nuestro trabajo.

## Procedimientos Básicos de Ramificación
Supongamos que estamos trabajando en un proyecto que ya posee un par de commits realizados, decidimos trabajar en el problema #53, para crear una nueva rama y saltar a ella con un solo comando utilizaremos `git checkout -b [rama]`
Entonces recibimos un llamado avisándonos de otro problema y debemos resolverlo. Al usar git no necesitamos mezclar el nuevo problema con los cambios que ya realizamos en el problema #53 ni tampoco perder tiempo revirtiendo esos cambios par poder trabajar sobre el contenido que está en producción. Basta con saltar de nuevo a la rama `master` y continuar trabajando a partir de alli.
Antes de poder hacer eso debemos tener en cuenta si tenemos cambios aun no confirmados, Git no nos permitirá saltar a otra rama con la que podríamos tener conflictos. 
Por ahora como tenemos confirmados todos los cambios podemos saltar a la rama `master` sin problemas mediante `git checkout master`
A continuación es momento de resolver el problema urgente. Vamos a crear una nueva rama `hotfix`, sobre la que trabajaremos hasta resolverlo. Podemos realizar las pruebas oportunas, asegurarnos de que la solución es correcta e incorporar los cambios a la rama master para ponerlos en producción. Esto se hace con el comando `git merge [rama_hotfix]`

## Procedimientos Básicos de Fusión
Supongamos que nuestro trabajo con el problema #53 ya está completo y listo para fusionarlo con la rama `master`. Realizamos el `git merge` que diferirá al que realizamos con `hotfix`. En este caso, el registro de desarrollo diverge debido a que la confirmación en la rama actual no es ancestro directo de la rama que fusionaremos. Git tiene cierto trabajo extra que hacer, realizará una fusión a tres bandas, utilizando las dos instantáneas apuntadas por el extremo de cada una de las ramas y por el ancestro común a ambas.
![](../../../Pasted%20image%2020260409213749.png)
En lugar de simplemente avanzar el apuntador de la rama, Git creara una nueva snapshot resultante de la fusión a tres bandas y creara automáticamente una nueva confirmacion de cambios que apnuta a ella. Git es quien determina automáticamente el mejor ancestro común para realizar la fusion.
Ya podriamos borrar la rama iss53 con `git branch -d iss53`.

## Principales Conflictos que Pueden Surgir en las Fusiones
En algunas ocasiones, los procesos de fusión no suelen ser fluidos. Si en nuestro trabajo hicimos modificaciones en una misma porción que fue modificada en otro problema veremos con conflicto como el siguiente:
![](../../../Pasted%20image%2020260409214738.png)
Git no crea automaticamente una nueva fusión confirmada, sino que hace una pausa en el proceso, esperando a que resolvamos el conflicto. Para ver que archivos permanecen sin fusionar en un determinado momento conflictivo utilizaremos el comando `git status`
![](../../../Pasted%20image%2020260409214833.png)
Todo aquello que sea conflictivo y no se haya podido resolver, se marca como "sin fusonar". Git añade a los archivos conflictivos unos marcadores especiales de resolución de conflictos que te guiarán cuando abras manualmente los archivos implicados y los edites para corregirlos.
![](../../../Pasted%20image%2020260409214955.png)
Donde nos dice que la version en HEAD contiene lo indicado en la parte superior del bloque y que la versión en iss53 contiene el resto, lo indicado en la parte inferior del bloque. Para resolver el conflicto debemos elegir manualmente el contenido de uno o de otro lado. POr ejemplo, podemos optar por cambiar el bloque, dejandolo así:
![](../../../Pasted%20image%2020260409215253.png)
Esta correcion contiene un poco de ambas partes y se han eliminado completamente las lineas <<<<<<, ===== y >>>>>>. Tras resolver los bloques conflictivos lanzamos `git add` para marcar cada archivo modificado.
Si en lugar de resolver directamente preferimos utilizar una herramienta grafica podemos usar el comando `git mergetool`.
![](../../../Pasted%20image%2020260409215515.png)
Tras salir de la herramienta de fusionado, Git preguSUrgirntará si hemos resuelto todos los conflictos y la fusión ha sido satisfactoria. Si le indicamos que así fue, Git maracara como preparado el archivo que acabamos de modificar.

## Gestión de Ramas
El comando `git branch` tiene más funciones que la de crear y borrar ramas. Si lolanzamos sin parámetros obtenemos una lista de las ramas presentes en el proyecto, con un indicador "*" en la rama activa en ese momento. Para ver la última confirmación d ecambios en cada rama podemos utilizar el comando `git branch -v`
Otra opcion útil para averiguar el estado de las ramas es filtrarlas y mostrar solo aquellas que fueron o no fusionadas con la rama actualmente activa. Mediante `git branch --merged` y `git branch --no-merged` respectivamente

## Flujos de Trabajo Ramificados
# Ramas de Largo Recorrido
Muchos desarrolladores que usan git llevan un flojo de trabajo en el cual mantienen en la rama master unicamente el codigo totalmente estable y teniendo otras ramas paralelas denominadas "desarrollo" o "siguiente" en cuales trabajan y realizan pruebas. También es habitual incorporarle ramas puntuales (ramas temporales).
Ramas Puntuales: Son útiles en proyectos de cualquier tamaño. Ua rama puntual es aquella rama de corta duración que abres para un tema o para una funcionabilidad determinada.

# Ramas Remotas
Las ramas remotas son referencias al estado de las ramas en repositorios remotos. Son ramas locales que no podemos mover; se mueven automaticamente cuando establecemos comunicaciones en la red. Las ramas remotas funcionan como marcadores para recordarte en qué estado se encontraban tus repositorios remotos la ultima vez que conecaste con ellos.
Suelen referenciarse como "(remoto)/(rama)"

# Publicar
Cuando queremos compartir una rama con el resto del mundo, debemos llevarla (pish) a un remoto donde tengamos permisos de escritura. `git push (remoto) (rama)`

# Hacer Seguimiento a las Ramas
Al activar (checkout) una rama local a partir de una rama remota, se crea autompáticamente lo que podmeos denominar una "rama de seguimiento" (trackin branch). Las ramas de seguimiento son ramas locales que tienen una relacion directa con alguna rama remota. SI estamos en una rama de seguimiento y tecleamos el comando `git pull`, Git sabe de cual servidor recuperar y fusionar datos.

# Traer y Fusionar
A pesar de que el comando `git fetch` trae todos los cambios que no tenemos del servidor, esto no modifica nuestro directorio de trabajo. Simplemente obtenemos los datos y dejara que nosotros mismos los fusionemos. Sin embargo existe un comando `git pull`, el cual básicamente hace un `git fetch` seguido de un `git merge`

# Eliminar Ramas Remotas
Si queremos borrar una rama, como por ejemplo serverfix podemos utilizar: `git push origin --delete serverfix`

# Reorganizar el Trabajo Realizado
En git tenemos dos formas de integrar los cambios de una rama en otra: la fusion y la reorganización.
Reorganización Básica: Mediante el comando `git rebase` podemos capturar todos los cambios confirmados en una rama y reaplicarlos sobre otra

# Algunas Reorganizaciones Interesantes
Tambien podemos aplicar una reorganizacion sobre otra cosa además de sobre la rama de reorganización. Por ejemplo, si ramificamos una rama puntual (server) para añadir algunas funcionalidades al proyecto, y luego confirmamos los cambios. Despues volvemos a la rama original para hacer algunos cambios en la parte cliente (rama client) y confirmar tambien esos cambios, por ultimo volvemos a la rama server y hacemos algunos cambios más
![](../../../Pasted%20image%2020260409221125.png)
Imaginemos que decidimos incorporar los cambios del lado cliente sobre el proyecto principal para hacer un lanzamiento de versión; pero no queremos lanzar aun los cambios del laod de servidor. Podemos agarrar los cambios del cliente que no estan en server (C8 y C9) y reaplicarlos sobre la rama principal mediante la opción `--onto` del comando `git base`: `git base --onto master server cliente`
Ahora supongamos que decidimos traerlos tambien sobre la rama server. Podemos reorganizar (rebase)la rama server sobre la rama master sin necesidad siquiera de comprobarlo previamente mediante el comando `git rebase [rama-base] [rama-puntual]`. Esto vuelca el trabajo de server sobre el de master. Luego avanzamos rápidamente la rama base `git checkout master` `git marge server`
Y por último eliminamos las ramas client y server: `git branch -d client` `git branch -d server`

## Los Peligros de Reorganizar

> [!IMPORTANTE]
> **Nunca reorganices confirmaciones de cambio (commits) que hayas enviado (push) a un repositorio publico**