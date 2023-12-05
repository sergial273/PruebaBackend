# Pueba Backend
## Como ejecutar
Para ejecutar, crear imagen de docker on el comando:

docker run --name my-mysql -p 33060:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql

A continuación, abrir mysql workbench i connectar con la base de datos que se enceutrna el localhost:33060 con usuario: root y contraseña: password.

Ejecutar en ella el archivo que se encuentra en el repo en resources/bd.sql

A continuación, abrir el proyecto con spring y ejecutar.
