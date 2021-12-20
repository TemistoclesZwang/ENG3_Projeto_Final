package br.com.eng3.springbootfirebase.Fbase.model;
import javax.persistence.Entity;

@Entity
public class Room {
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
