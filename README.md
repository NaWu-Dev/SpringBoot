# Projects Info
## SpringDataRest
Application to manage the To Do List. 
```
Spring boot, H2 Database, JPA, Rest Data, 
```
## SpringJpa
Application to manage the Books.
```
Spring boot, H2 Database, JPA, JPA Query, 
```
# Tech Points 
## Embedded H2 Database configuration
In application.properties, define the datasources as below. 
```
spring.h2.console.enabled = true
spring.datasource.platform = h2
spring.datasource.url = jdbc:h2:file./dtaa/TestData.db
```
Initialize a Database using JPA and enable automatically modify the shcema and add new additions upon restart. The standard Hibernate property values are none, validate, update, create and create-drop.
```
spring.jpa.hibernate.ddl-auto = update 
```
## Entity
```
@Entity
@ID
@PrePresist
```
## JPA Repository and Data Rest
```
@RepositoryRestResource(collectionResourceRel = "items", path = "items)
public interface ItemRepo extends JpaRepository<Item, Integer> {
}
```
## Complex JPA Query 
How to use JPA Query to achieve the SQL Union. For example. 
```
public interface BookRepo extends JpaRepository<Book, Integer> {
    @Query("SELECT x FROM Book x WHERE " +
            "(x.status, x.publishDate) in " +
            "(SELECT j.status, j.publishDate FROM Book j WHERE j.status=?1) " +
            "or (x.status, x.publishDate) in " +
            "(SELECT k.status, k.publishDate FROM Book k WHERE k.publishDate >= sysdate-1) ")
    List<Book> findAllWithStatusAndPublishedInYear(String status);
}
```
