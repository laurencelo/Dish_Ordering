package db;
/**
 * 
 * @author mehra
 * MYSQL database schema :coursedatabase
 * user :coursedatabase_admin
 * pass :Test1234
 * 
 */

/** 
 * Table code for user and dish:
 * CREATE TABLE user (userID int, password varchar(50), PRIMARY KEY (userID));
INSERT INTO user (userID, password) VALUES (1, 'user1'), (2, 'user2');


CREATE TABLE dish (name varchar(20), inventory int, price double, PRIMARY KEY (name));
INSERT INTO dish (name, inventory, price) VALUES ('dish1', 1, 1.11), ('dish2', 2, 2.22), ('dish3', 3, 3.33);
 */
public interface MyDB {

	String USER="root";
	String PASS="Test1234";
	String CONN_URL="jdbc:mysql://127.0.0.1:3306/coursedatabase";
	
	
}
/**
CREATE TABLE `customer` (
`userId` char(20) NOT NULL,
`password` char(10) DEFAULT NULL,
`name` char(20) DEFAULT NULL
)


jdbc:mysql://127.0.0.1:3306/coursedatabase?user=coursedatabase_admin

*/
