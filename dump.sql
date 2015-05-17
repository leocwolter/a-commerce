DROP DATABASE IF EXISTS acommerce;

CREATE DATABASE acommerce;

USE acommerce;

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  `number` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `complement` varchar(255) NOT NULL,
  `zipCode` varchar(255) NOT NULL,
  `cnpj` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  `publisher_id` int(11) NOT NULL,
  `synopsis` varchar(255) NOT NULL,
  `toc` varchar(255) NOT NULL,
  `length` int(11) NOT NULL,
  `language` varchar(255) NOT NULL,
  CONSTRAINT FOREIGN KEY (publisher_id) REFERENCES publisher(id),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL UNIQUE,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `book_category` (
	`book_id` int(11) NOT NULL,
	`category_id` int(11) NOT NULL,
    CONSTRAINT FOREIGN KEY (book_id) REFERENCES book(id),
    CONSTRAINT FOREIGN KEY (category_id) REFERENCES category(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  `number` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `complement` varchar(255) NOT NULL,
  `zipCode` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `birthDay` date NOT NULL,
  `biography` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `book_author` (
	`book_id` int(11) NOT NULL,
	`author_id` int(11) NOT NULL,
    CONSTRAINT FOREIGN KEY (book_id) REFERENCES book(id),
    CONSTRAINT FOREIGN KEY (author_id) REFERENCES author(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`creationDate` date NOT NULL,
	`owner_id` int(11) NOT NULL,
    CONSTRAINT FOREIGN KEY (owner_id) REFERENCES `user`(id),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ordered_book` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`order_id` int(11) NOT NULL,
	`book_id` int(11) NOT NULL,
	`quantity` int(11) NOT NULL,
    CONSTRAINT FOREIGN KEY (order_id) REFERENCES `order`(id),
    CONSTRAINT FOREIGN KEY (book_id) REFERENCES book(id),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	