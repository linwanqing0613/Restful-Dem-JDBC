# Movie - Restful API 
功能實作: CRUD(Movie), Spring Security, 登入登出(Security內建),
         帳號權限, 簡易單元測試

帳號權限(以下權限須從SQL新增權限):
GUEST -> 可以使用/users/hello 查看 Authentication
NORMAL_MEMBER -> 可以使用 /Movie以下的路徑(只有GET)
ADMIN -> 全部都可以使用
## 功能

- [x] 註冊帳號 - PUT - ```http://localhost:8080/users/register```	
	- [x] {<br>
		  "id":"test",<br>
		  "email":"test5@gmail.com",<br>
		  "password":"555"<br>
		}
- [x] 新增電影 - POST - ```http://localhost:8080/Movie```
	- [x] {<br>
			"title": "Movie test",<br>
			"director": "Director test",<br>
			"release_year": 2024,<br>
		}

- [x] 刪除電影 - DELETE - ```http://localhost:8080/Movie/{電影編號}```
- [x] 更新電影 - PUT - ```http://localhost:8080/Movie/{電影編號} ```
- [x] 查詢電影 - GET - ```http://localhost:8080/Movie/{電影編號}```

## 安裝

> 請務必依據你的專案來調整內容。

### 取得專案

```bash
git clone git@github.com:linwanqing0613/Restful-Demo-JDBC.git
```

### 安裝Maven套件

```bash
<dependencies>
		<!-- WEB -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!-- H2 -->
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<!-- MYSQL -->
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<!-- JPA -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<!-- Spring Security -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<!-- lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.24</version>
			<scope>provided</scope>
		</dependency>
</dependencies>
```

### 環境變數設定 application.properties
main
```bash
spring.application.name="專案名稱"

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/"資料庫名稱"?serverTimezone=Asia/Taipei&characterEncoding=utf-8
spring.datasource.username="資料庫帳號"
spring.datasource.password="密碼"

spring.jackson.time-zone="時區代碼"
spring.jackson.date-format="時間格式"
```
test
```bash
# H2 Database
spring.datasource.url=jdbc:h2:mem:testdb;MODE=MySQL
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.sql.init.mode=always
spring.jpa.hibernate.ddl-auto=none
```
## 資料夾說明
- [x] main
	- [x] Config - Spring Security設定檔放置處
	- [x] Controller - 控制器放置處
	- [x] Dao - Repository放置處
	- [x] Modul - 電影模組放置處
	- [x] Service - 服務放置處
- [x] test 單元測試
	- [x] Controller - Controller層單元測試
	- [x] Service - Service層單元測試

## 專案技術

- IntelliJ
- Java 17
- Spring Boot version 3.2.4
- MYSQL
- JPA


