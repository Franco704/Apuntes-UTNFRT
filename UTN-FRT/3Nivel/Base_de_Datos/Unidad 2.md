---
materia: Base de Datos
unidad: 2
---
# 💾 Unidad 2: Almacenamiento y RAID

## 💽 RAID
> [!INFO] Redundant Array of Independent Disks
> Significa "matriz redundante de discos independientes".

**¿Qué es RAID?**
Es un método de combinación de varios discos duros para formar una única unidad lógica en la que se almacenan los datos de forma redundante. Consta de dos o más discos que funcionan como un único dispositivo.

**¿Cómo trabaja?**
- Los datos se desglosan en fragmentos y se escriben en varios discos de forma simultánea.
- Protege los datos contra el fallo de una unidad de disco duro.
- Mantiene el servidor activo y en funcionamiento hasta que se sustituya la unidad defectuosa.

**Usos de RAID:**
- La utilización de sistemas de almacenamiento tolerantes al fallo es imprescindible actualmente en la configuración de un servidor de datos.
- Los datos deben estar disponibles en todo momento y asegurados contra incidencias.

### Niveles de RAID
* **RAID 0 (Disk Striping):** *"La más alta transferencia, pero sin tolerancia a fallos"*. Es conocido como separación o fraccionamiento. Los datos se desglosan en pequeños segmentos y se distribuyen entre varias unidades. No ofrece tolerancia al fallo.
* **RAID 1 (Mirroring):** *"Redundancia. Más rápido que un disco y más seguro"*. Se basa en la utilización de discos adicionales sobre los que se realiza una copia en todo momento de los datos que se están modificando. Se usa el 50% del disco.
* **RAID 0+1 / RAID 0/1 o RAID 10:** Combinación de los arrays anteriores, proporciona velocidad y tolerancia al fallo a la vez. Cada bloque es una copia exacta del otro (RAID 1), y dentro de cada bloque la escritura de datos se realiza en modo de bloques alternos (RAID 0). *Nota: No se suele usar.*
* **RAID 5:** *"Acceso independiente con paridad distribuida"*. **Es el más usado.** Optimiza la capacidad del sistema permitiendo una utilización de hasta el 80% del conjunto de discos. Es la solución más económica por megabyte, ofrece la mayor relación de precio, rendimiento y disponibilidad. Requiere mínimamente 3 discos.

---

## 🌐 Tecnologías de Almacenamiento en Red

### SAN (Storage Area Network)
Red de alta velocidad que conecta servidores con dispositivos de almacenamiento masivo.
- Surgen de la necesidad de capacidad de almacenamiento para aplicaciones tales como *Data Warehouse*, *Data Mining*, internet y Multimedia.
- Permite hacer backup de más datos en menos tiempo.
- Es una subred, separada de la red principal especializada en Almacenamiento.
- Se construye sobre una unidad de Fibra.

### NAS (Network Attached Storage)
Es el nombre dado a una tecnología de almacenamiento dedicada a compartir la capacidad de almacenamiento de un computador con computadoras personales o servidores clientes a través de una red físicamente TCP/IP, haciendo uso de un Sistema Operativo optimizado para dar acceso con alguno de sus protocolos como ser FTP o TFTP.

### Cloud Storage (Almacenamiento en la Nube)
Es un modelo de almacenamiento de datos basado en redes, donde los datos están alojados en espacios de almacenamiento virtualizados, por lo general aportado por terceros.

[Clase 2026-04-07](20260407.md)