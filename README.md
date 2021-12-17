# microservicio-productos
microservicio productos java 11 Spring Boot
Este proyecto tiene un video tutorial que puedes seguir por youtube
Cada video de youtube corresponde con un TAG

- [Capítulo 1: Creación proyecto Spring](https://youtu.be/pzlanOdUMvc)
- [Capítulo 2: Creación Clase Producto](https://youtu.be/NiiBpUAMlyk)
- [Capítulo 3: Creación Repository de JPA para ORM](https://youtu.be/PxCA7KqhKKY)
- [Capítulo 4: Testing Junit Repository](https://youtu.be/HI4JYQ28Cns)
- [Capítulo 5: Crear API RestFull: Listar Productos](https://youtu.be/Q4Ozb4rniyw)
- [Capítulo 6: Documentar API RestFull con OpenApi](https://youtu.be/CGRNiCLAlnQ)
- [Capítulo 7: API Rest: Detalle Producto](https://youtu.be/XueRsjTgjx8)
- [Capítulo 8: API Rest: Eliminar Producto](https://youtu.be/AtBd546QxO8)
- [Capítulo 9: API Rest: Crear Producto](https://youtu.be/zHyIM_tDizg)
- [Capítulo 10: API Rest: Validar Producto](https://youtu.be/FgZUNUMLIyU)
- [Capítulo 11: API Rest: Modificar Producto](https://youtu.be/JSuo9vLS-IY)


##API Documentación

[http://localhost:5000/swagger-ui.html](http://localhost:5000/swagger-ui.html)
![metodos de la Api](https://raw.githubusercontent.com/anderuraga/microservicio-productos/master/screenshot_api.png)


##Docker

Crear fichero Dockerfile

```
FROM openjdk:11
COPY "./target/producto-0.0.1-SNAPSHOT.jar" app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
```

Crear Imagen
```
docker build -t servicio .
```

Arrancar el contenedor
```
docker run --rm -p 5000:8080 servicio
```




