# microservicio-productos
microservicio productos java 11 Spring Boot
Este proyecto tiene un video tutorial que puedes seguir por youtube
Cada video de youtube corresponde con un TAG

1. [Capítulo 1: Creación proyecto Spring](https://youtu.be/pzlanOdUMvc)
2. [Capítulo 2: Creación Clase Producto](https://youtu.be/NiiBpUAMlyk)


import.sql

insert into product (id, nombre ) VALUES ( 1, 'melon' );
insert into product (id, nombre ) VALUES ( 2, 'fresa' );
insert into product (id, nombre ) VALUES ( 3, 'kiwi' );

application.properties

logging.level.org.hibernate.tool.hbm2ddl=DEBUG
logging.level.org.hibernate.SQL=DEBUG


@Entity


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(nullable = false)


@Repository
extends JpaRepository<Product, Integer> 