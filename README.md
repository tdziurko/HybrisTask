<h1>Hybris Task</h1>
<h1>----------------------------------------------------</h1>

//FIXME: Missing command to create proper database: 
e.g.:

    create database blog_development character set utf8 collate utf8_polish_ci;


call this sql in order to create appropriate tables:<br/>
<br/>
CREATE  TABLE users ( <br/>
  username VARCHAR(45) NOT NULL ,<br/>
  password VARCHAR(45) NOT NULL ,<br/>
  enabled TINYINT NOT NULL DEFAULT 1 ,<br/>
  PRIMARY KEY (username)<br/>
);<br/>
CREATE TABLE user_roles (<br/>
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,<br/>
  username VARCHAR(45) NOT NULL,<br/>
  ROLE VARCHAR(45) NOT NULL,<br/>
  PRIMARY KEY (user_role_id),<br/>
  UNIQUE KEY uni_username_role (ROLE,username),<br/>
  KEY fk_username_idx (username),<br/><br/>
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)<br/>
);<br/>
CREATE TABLE notes (<br/>
   id INT NOT NULL auto_increment,<br/>
   title VARCHAR(30) NOT NULL,<br/>
   content TEXT NOT NULL,<br/>
   user_id VARCHAR(45) NOT NULL,<br/>
   date DATETIME NOT NULL,<br/>
   PRIMARY KEY (id)<br/>
);<br/>
CREATE TABLE comments (<br/>
   id INT NOT NULL auto_increment,<br/>
   email VARCHAR(30) NOT NULL,<br/>
   content TEXT NOT NULL,<br/>
   note_id INT NOT NULL,<br/>
   date DATE NOT NULL,<br/>
   PRIMARY KEY (id)<br/>
);<br/>
CREATE TABLE tag_note(<br/>
   id INT NOT NULL auto_increment,<br/>
   note_id INT NOT NULL,<br/>
   tag_id INT NOT NULL,<br/>
   PRIMARY KEY (id)<br/>
);<br/>
CREATE TABLE tags(<br/>
   id INT NOT NULL auto_increment,<br/>
   tag VARCHAR(30) NOT NULL,<br/>
   PRIMARY KEY (id)<br/>
);<br/>
<br/>
create User with role "USER", for example:<br/>
INSERT INTO users(username,password,enabled) VALUES ('Admin','admin', 1);<br/>
INSERT INTO user_roles (username, ROLE) VALUES ('Admin', 'ROLE_USER');<br/>

You should deploy it with  url as something/HybrisTask/ - it should be default url, for example, when You run this project in Eclipse, You should open it in localhost:8080/HybrisTask/


<br/>
<br/>
<br/>
<a href="http://spring.io/"><img src='http://www.jorambarrez.be/blog/wp-content/oss-logo-spring.png'></a>
