# About
Project created in the course Hibernate with Java.

## Requirements
* JDK 17
* Maven 3.8.x
* MySQL 8

## Steps to Setup
1. Create the database
```
CREATE DATABASE condominium CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci;

USE condominium;

CREATE TABLE condominiums (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE utf8mb3_general_ci;

INSERT INTO condominiums VALUES (1, 'DEFAULT');

CREATE TABLE syndics (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(80) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE utf8mb3_general_ci;

CREATE TABLE syndics_condominiums (
  id_syndic INTEGER NOT NULL,
  id_condominium INTEGER NOT NULL,
  PRIMARY KEY (id_syndic, id_condominium),
  FOREIGN KEY (id_syndic) REFERENCES syndics(id),
  FOREIGN KEY (id_condominium) REFERENCES condominiums(id)
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE tenants (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(80) NOT NULL,
  id_condominium INTEGER NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_condominium) REFERENCES condominiums(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE utf8mb3_general_ci;

CREATE TABLE tenants_dependents (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(80) NOT NULL,
  id_tenant BIGINT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(id_tenant) REFERENCES tenants(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE utf8mb3_general_ci;
```

2. Clone the application
```
git clone https://github.com/erosvitor/template-condominium.git
```

3. Run the project
To run this project you need execute the unit tests.

## License
This project is under license from MIT. For more details, see the LICENSE file.

