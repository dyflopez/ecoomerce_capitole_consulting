# ecoomerce_capitole_consulting

## Tecnologías:


- [SWAGGER (OpenAPI)]: Se utiliza para exponer el servicio y documentar correctamente el API. La URL de conexión es http://localhost:8080/swagger-ui.html
- [H2]: Base de datos en memoria.
- [FLYWAY]: Esta tecnología nos ayuda a crear una ruta de migración que es administrada desde el backend y nos ayuda a tener un mejor control de versiones a nivel de base de datos.
- [Docker]: Se dockeriza el servicio y se realizan configuraciones por medio de variables de entorno para poder manejar datos que cambian entre ambientes.
- [Test (JUnit)]: Se generan dos tipos de test para la aplicación. El primero son los casos en el archivo de prueba y el segundo son unos test de comportamientos para los 3 tipos de escenarios que podrían ocurrir.
- [Manejador de Excepciones]: Manejador de Excepciones: Se crea un manejador de excepciones para poder controlar los distintos tipos de excepciones y crear excepciones personalizadas.


## Pasos para construir y dockerizar la aplicación:

- mvn clean
- mvn package
- docker build -t img_ecommerce_capiline:V1 .
- docker run -d -p 8080:8080 --env-file .env --name ms-ecommerce img_ecommerce_capiline:V1


Gracias 
