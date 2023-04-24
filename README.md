# Conexion-Java-MariaDB
### Belén Gamero Garcia y Edgar López Hernández

# Conexión simple usando JDBC

Lo primero que tenemos que hacer es crear un nuevo proyecto en IntelliJ de la siguiente forma.

![image](https://user-images.githubusercontent.com/91567318/234019836-87795257-12e6-4441-a342-163cda7eae91.png)

Después lo que tenemos que hacer es crear el archivo DBManager y dejarlo como en la imagen siguiente, lo que debemos modificar es la base de datos, el usuario, contraseña por los que coincidan con la base de datos ya creada en Mariadb.

![image](https://user-images.githubusercontent.com/91567318/234020181-6225bb31-ba48-401f-840f-d9020cf83d6d.png)

Después nos movemos al archivo Pom.xml y añadimos esto.

MariaDB

![image](https://user-images.githubusercontent.com/91567318/234020277-83d4fe5f-730c-406d-98a2-d787baa3ebd4.png)

SQL

![image](https://user-images.githubusercontent.com/91567318/234020458-8851fcf7-d8e0-462e-a6d7-10dcf9d44a2e.png)

Añadimos lo siguiente en el Main.

MariaDB

![image](https://user-images.githubusercontent.com/91567318/234020535-d275cc6a-b9e2-4ad2-a89d-1e27af7934ab.png)

SQL
Lo que debemos modificar es la base de datos, el usuario, contraseña por los que coincidan con la base de datos ya creada en SQL.

![image](https://user-images.githubusercontent.com/91567318/234020636-02e9cbde-f8b9-47b0-89d6-47fef7419309.png)

Lo ejecutamos y debería funcionar correctamente.

![image](https://user-images.githubusercontent.com/91567318/234020723-956da34e-3f5f-4499-b0d0-7cf269983823.png)

# Conexión usando JPA
Primero, asegúrate de tener las dependencias necesarias en tu proyecto, que son:

- MariaDB JDBC driver
- Hibernate JPA implementation
- Javax Persistence API

A continuación, crea una clase de entidad para representar una tabla en tu base de datos:

![image](https://user-images.githubusercontent.com/91567318/234020877-36270edb-a8cd-4c63-b563-9e303b0d2eea.png)

Luego, configura tu unidad de persistencia en un archivo persistence.xml en la carpeta META-INF de tu proyecto. Asegúrate de agregar la información de conexión a tu base de datos MariaDB:

![image](https://user-images.githubusercontent.com/91567318/234021469-ecf0fa5c-9568-475e-ba05-ee57ff6b9d6d.png)

Después añadimos lo siguiente al Mein

![image](https://user-images.githubusercontent.com/91567318/234021551-9c1c9152-b8d4-4aea-9297-21023ed8c920.png)

Lo ejecutamos e introducimos los valores deseados

![image](https://user-images.githubusercontent.com/91567318/234021606-654f0e4c-d600-45e1-b014-d9880c6fa4a8.png)

Iremos a la base de datos para ver si los datos se insertaron correctamente

![image](https://user-images.githubusercontent.com/91567318/234021814-796cb095-8d56-43af-b0fc-7ae32bb34e5e.png)

