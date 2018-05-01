package augustovictor.receipt.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int amount;
    @ManyToOne
    private Recipe recipes;

    @OneToOne(fetch = FetchType.EAGER) // Fetch included for demonstration purposes only since it is default on this relationship
    private UnitOfMeasure unitOfMeasure;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
