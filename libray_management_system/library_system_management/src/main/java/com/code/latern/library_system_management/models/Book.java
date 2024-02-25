package com.code.latern.library_system_management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min=3,max=30,message = "title should be in the range of 3 to 30")
    private String title;
    @Size(min = 5,max = 50,message = "author should be in the range of 5 to 50")
    private String author;
    @Min(value = 100,message = "cost should be minimum value of 100")
    @Max( value = 10000,message = "cost should be maximum value of 10000")
    private int cost;
    @Size(min = 5,max = 50,message = "category should be range of 5 to 50")
    private String category;

    private String publishedDate;

    private int availableQuantity;

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
