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

create table geekfactory.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20),
  password varchar(200),
PRIMARY KEY (id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

create table geekfactory.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE geekfactory.favorito (
  id_favorito INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  id_articulo INT NOT NULL,
  PRIMARY KEY (`id_favorito`),
  foreign key fk_favorito_usuario (id_usuario) references usuario(id_usuario),
  foreign key fk_favorito_articulo (id_articulo) references articulo(id_articulo)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;


CREATE TABLE geekfactory.factura (
  id_factura INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  fecha varchar(20),
  PRIMARY KEY (`id_factura`),
  foreign key fk_factura_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE geekfactory.venta (
  id_venta INT NOT NULL AUTO_INCREMENT,
  id_factura INT NOT NULL,
  id_articulo INT NOT NULL,
  cantidad INT,
  talla varchar(20),
  PRIMARY KEY (`id_venta`),
  foreign key fk_venta_factura (id_factura) references factura(id_factura),
  foreign key fk_venta_articulo (id_articulo) references articulo(id_articulo)  
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
(1,1,1,'Camiseta de Marvel Avengers conmemorativa a Stan Lee.',12000,'/ImgArticulos/camisaMarvel.jpg'),
(2,1,2,'Camiseta de DC, Superman, Wonder Woman, y Batman.',12000,'/ImgArticulos//camisaDC.jpg'),
(3,1,3,'Camiseta de Rey Ayanami de Evangelion.',12000,'/ImgArticulos/camisaAnime.jpg'),
(4,2,1,'Hoodie con el logo de Marvel.',18500,'/ImgArticulos/sueterMarvel.jpg'),
(5,2,2,'Hoddie con el logo de Batman.',18500,'/ImgArticulos/sueterDC.jpg'),
(6,2,3,'Hoodie de Ichikaru Ramen, de Naruto.',18500,'/ImgArticulos/sueterAnime.jpg'),
(7,3,1,'Jogger de Spider Man.',20500,'/ImgArticulos/joggerMarvel.jpg'),
(8,3,2,'Combo de jogger+hoodie de Batman.',20500,'/ImgArticulos/joggerDC.jpg'),
(9,3,3,'Jogger de One Piece.',20500,'/ImgArticulos/joggerAnime.jpg');