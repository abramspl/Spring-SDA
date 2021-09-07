package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor // konstruktor wieloparametrowy
@NoArgsConstructor // utworzy się konstruktor bezparametrowy
@Entity(name = "orders") // zmiana nazwy tabeli na orders (słowo 'order' nie zadziała)
public class Order {

    //adnotacje encji nad polami
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;         // id produktu
    private String productName; // nazwa produktu
    private Integer quantity;     // ilość produktu
}
