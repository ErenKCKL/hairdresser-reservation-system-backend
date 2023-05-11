package ashina.hairdresserreservation.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    /**
     Category Entity Class
     This class represents the Category entity in the Hairdresser Reservation System.
     It maps the Category entity to the corresponding database table and provides
     fields for storing the entity's attributes.
     Annotations used:
     @Data: Lombok annotation to generate getters, setters, and other utility methods.
     @Entity: Indicates that this class is a JPA entity, used for mapping to the database table.
     @Table: Specifies the name of the database table that this entity maps to.
     @NoArgsConstructor: Lombok annotation to generate a no-argument constructor.
     @AllArgsConstructor: Lombok annotation to generate a constructor with all arguments.
     The class contains the following fields:
     id: The unique identifier of the Category entity (primary key).
     categoryTitle: The title of the category.
     The fields are annotated with JPA annotations for mapping to the database table columns
     and specifying their properties, such as @Id for primary key, @GeneratedValue for
     auto-incrementing the primary key, and @Column for mapping to a specific column.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category_title")
    private String categoryTitle;

}
