---
materia: Desarrollo de Software
unidad: 1
tipo: #practica/ejercicio
---
#  Ejercicio 2: Control de Versiones (Git)

> [!INFO]  Preparación Inicial
> Comenzamos el trabajo práctico instalando la herramienta Git. En mi caso ya la tengo instalada nativamente en mi distribución de Linux.
> 
> ![Instalación](../../Bibliografia/Pasted%20image%2020260408114143.png)

---

## Parte 2: Repositorio Local

1. Creamos el directorio junto con el archivo necesario (En mi caso utilizando los comandos `mkdir` y `touch`).
2. Iniciamos el repositorio de git mediante el uso del comando: 
   `git init`
3. Revisamos el estado del archivo mediante el uso del comando: 
   `git status HolaDesarrolloDeSoftware.txt`
4. Agregamos el seguimiento del archivo (Staging) mediante: 
   `git add HolaDesarrolloDeSoftware.txt`
5. Hacemos el commit al archivo *stageado*, mediante el comando: 
   `git commit -m "Punto 5 Completo"`

![Parte 2 Consola](../../Bibliografia/Pasted%20image%2020260408115338.png)

---

## Parte 3: Clonación y configuraciones avanzadas

1. Creamos los directorios necesarios y clonamos el repositorio del enunciado mediante: 
   `git clone https://github.com/dsw-frt-utn/dsw2026-ej02`
   ![Clonado](../../Bibliografia/Pasted%20image%2020260408115814.png)

2. Descargamos el `.zip` adjuntado en la tarea.
3. Descomprimimos el `.zip` en el directorio de trabajo.
   ![Unzip](../../Bibliografia/Pasted%20image%2020260408120013.png)

4. Hacemos uso de `git status` para controlar el estado actual de la carpeta:
   ![Git Status](../../Bibliografia/Pasted%20image%2020260408120330.png)

5. **Configuración del `.gitignore`:** Ahora debemos jugar un poco con las expresiones regulares para conseguir ignorar ciertos tipos de archivos. En orden:
   6. Necesitamos que todos los archivos que contengan `#trash` seguidos de cualquier combinación sean excluidos. Ya que comienza por un `#` (que normalmente es un comentario), utilizaremos `\` al inicio para escaparlo. Nos quedaría: `\#trash*`.
   7. El archivo `#trash.gb` NO debe ser excluido. Ya que en el paso anterior excluimos todos los archivos que empiecen por `#trash`, aplicaremos un `!` para crear una excepción sobre este archivo en particular. Nos quedaría: `!\#trash.gb`.
      ![Trash ignore](../../Bibliografia/Pasted%20image%2020260408122028.png)
   8. Ya que necesitamos excluir los directorios `temp` y `Temp` (puede empezar con "t" minúscula o "T" mayúscula), lo realizaremos de la siguiente manera: `[tT]emp/`.
   9. Para excluir la carpeta bin simplemente indicamos el directorio: `bin/`.
   10. Debemos excluir todos los archivos del formato `.vsp`, por lo que no importa el nombre del archivo, únicamente su extensión. Nos quedará: `*.vsp`.
      ![Extensiones ignore](../../Bibliografia/Pasted%20image%2020260408122614.png)

11. Ya que tenemos configurado correctamente el `.gitignore` podemos hacer un `git add .` general sin problemas.
12. Hacemos un commit para registrar la adición masiva: `git commit -m "Punto 7"`. 
   ![Commit general](../../Bibliografia/Pasted%20image%2020260408123435.png)

13. Luego de modificar el último párrafo del archivo `analysis.txt`, revisamos las diferencias exactas de lo que se modificó mediante: `git diff analysis.txt`.
   ![Git diff](../../Bibliografia/Pasted%20image%2020260408124126.png)

14. Agregamos el archivo y hacemos un commit para guardar el cambio.
   ![Commit diff](../../Bibliografia/Pasted%20image%2020260408124235.png)

15. Eliminamos el archivo tanto del disco como del registro de Git con `git rm`.
    ![Git rm](../../Bibliografia/Pasted%20image%2020260408124412.png)

16. Para recuperar el archivo desde el *Staging Area* utilizamos: `git restore --staged <archivo>`.
17. Para restaurar el archivo físicamente en nuestro directorio de trabajo utilizamos: `git restore <archivo>`.
    ![Git restore](../../Bibliografia/Pasted%20image%2020260408124656.png)

18. Realizamos el cambio de nombre de un archivo mediante el comando `git mv <original> <nuevo>` y realizamos el commit. 
    ![Git mv](../../Bibliografia/Pasted%20image%2020260408124956.png)

19. Revisamos el historial de registro simplificado mediante: `git log --oneline`. 
    ![Git log](../../Bibliografia/Pasted%20image%2020260408125155.png)