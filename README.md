# Tech Points 
## Spring Data Rest
### Embedded H2 Database configuration
In application.properties, define the datasources as below. 
```
spring.h2.console.enabled = true
spring.datasource.platform = h2
spring.datasource.url = jdbc:h2:file./dtaa/TestData.db
```
### Entity
```
@Entity
@ID
@PrePresist
```
### JPA Repository and Data Rest
```
@RepositoryRestResource(collectionResourceRel = "items", path = "items)
public interface ItemRepo extends JpaRepository<Item, Integer> {
}
```
