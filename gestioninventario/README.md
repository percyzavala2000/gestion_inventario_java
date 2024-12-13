# Gestión de Inventario

Este proyecto es un sistema de gestión de inventario desarrollado en Java. Permite la gestión de productos, categorías, personas y usuarios.

## Características

- **Gestión de productos**: Crear, leer, actualizar y eliminar productos.
- **Gestión de categorías**: Crear, leer, actualizar y eliminar categorías.
- **Gestión de personas**: Crear, leer, actualizar y eliminar personas.
- **Gestión de usuarios**: Crear, leer, actualizar y eliminar usuarios.
- Implementación de pilas y colas para la gestión de personas.

## Tecnologías Utilizadas

- **Java 8**
- **MySQL**
- **JDBC**
- **Git**

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- **basedatos**: Contiene las clases de acceso a datos.
- **entidades**: Contiene las clases de entidades del negocio.
- **presentacion**: Contiene las clases de presentación.
- **utilidades**: Contiene las clases de utilidades.

## Instalación y Ejecución

Sigue estos pasos para instalar y ejecutar el proyecto:

1. Clona el repositorio utilizando el siguiente comando:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   ```

2. Importa el proyecto en un IDE como **Eclipse** o **NetBeans**.

3. Configura la conexión a la base de datos en el archivo `Conexion.java`:
   - Proporciona las credenciales correctas para tu base de datos MySQL.

4. Ejecuta la aplicación desde el archivo `Main.java`.

## Contribuciones

¡Las contribuciones son bienvenidas! Si deseas contribuir al proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad o corrección de errores:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza los cambios necesarios y haz commit de ellos:
   ```bash
   git commit -m "Descripción de los cambios"
   ```
4. Envía tus cambios al repositorio remoto:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Abre un pull request en el repositorio original.