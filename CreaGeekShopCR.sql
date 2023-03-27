/*Las líneas 2 y 3 están en comentarios, para usarse así la primera vez... luego de eso se quitan los comentarios para que todo funcione bien, en las siguientes ejecuciones */
drop schema geekfactory;
drop user administrador;

/*Se crea la base de datos */
CREATE SCHEMA geekfactory ;
/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'administrador'@'%' identified by 'Geekfactorycr_2023!.';
/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on geekfactory.* to 'administrador'@'%';
flush privileges;

create table geekfactory.categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_categoria)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

create table geekfactory.tematica (
  id_tematica INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_tematica)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE geekfactory.articulo (
  id_articulo INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  id_tematica INT NOT NULL,
  descripcion VARCHAR(1600) NOT NULL,
  precio double NOT NULL,
  imagen varchar(150),
  PRIMARY KEY (`id_articulo`),
  foreign key fk_articulo_categoria (id_categoria) references categoria(id_categoria),
  foreign key fk_articulo_tematica (id_tematica) references tematica(id_tematica)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;


INSERT INTO geekfactory.categoria (id_categoria,nombre) values
(1,'camisa'),
(2,'sueter'),
(3,'jogger');

INSERT INTO geekfactory.tematica (id_tematica,nombre) values
(1,'Marvel'),
(2,'DC'),
(3,'Anime');

INSERT INTO geekfactory.articulo (id_articulo,id_categoria,id_tematica,descripcion,precio,imagen) values
(1,1,1,'camisa1',12000,'/ImgArticulos/camisaMarvel.jpg'),
(2,1,2,'camisa2',12000,'/ImgArticulos//camisaDC.jpg'),
(3,1,3,'camisa3',12000,'/ImgArticulos/camisaAnime.jpg'),
(4,2,1,'sueter1',18500,'/ImgArticulos/sueterMarvel.jpg'),
(5,2,2,'sueter2',18500,'/ImgArticulos/sueterDC.jpg'),
(6,2,3,'sueter3',18500,'/ImgArticulos/sueterAnime.jpg'),
(7,3,1,'jogger1',20500,'/ImgArticulos/joggerMarvel.jpg'),
(8,3,2,'jogger2',20500,'/ImgArticulos/joggerDC.jpg'),
(9,3,3,'jogger3',20500,'/ImgArticulos/joggerAnime.jpg');