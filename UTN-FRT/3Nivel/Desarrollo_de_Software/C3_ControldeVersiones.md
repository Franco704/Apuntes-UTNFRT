Clonamos el repositorio mediante `git clone [url]`
En la parte dos comenzamos creando la rama "development", mediante el comando `git branch development`
Creamos y saltamos a la rama bugfix/consumos. `git checkout -b bugfix/consumos`

Luego de editar el código (de la misma manera que se hizo el [C1_Depuracion](C1_Depuracion.md)), agregamos las correcciones mediante `git add .` y hacemos el commit `git commit -m "Punto 3"`
Ahora debemos fusionar bugfix/consumos con development. Nos movemos a la rama destino `git checkout development` y mergeamos `git merge bugfix/consumos`. 
Ahora nos toca realizar el punto 6 y 7 (lo de la clase Marca).  Una vez que modificamos todas las clases involucradas hacemos un `git add .` y `git commit -m "Punto 7"`
Para inspeccionar las ramas remotas utilizamos `git branch -r`
![](../../../Pasted%20image%2020260412163056.png)
Ahora tenemos que descargar la rama remota feature/marcas mediante `git fetch origin feature/marcas` y nos movemos a dicha rama con `git checkout feature/marcas`.
Ahora como estamos en feature/marcas traemos los cambios de development mediante `git merge development`
Al intentar hacer el merge tenemos un conflicto por el archivo Marca.java, comenzamos abriendo dicho archivo donde veremos las marcas que Git insertó. Como nos pidieron que prevalezcan los cambios de la rama feature/marcas borraremos las lineas de los marcadores <<<< HEAD, ===== y >>>> development, como la rama activa es la que tiene los cambios que no hicimos borramos los cambios que hicimos en el anterior commit.
Cuando ya hicimos los arreglos necesarios para el merge agregamos los archivos y hacemos el commit con el conflicto resuelto con el `git commit -m "Punto 11"`

Para la parte 3 tenemos que realizar dos modificaciones: una nueva ventana para poder ingresar un nuevo vehiculo y un menú principal para elegir entre listar y agregar.