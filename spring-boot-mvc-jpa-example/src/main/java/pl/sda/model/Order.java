package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor // konstruktor wieloparametrowy
@NoArgsConstructor // utworzy się konstruktor bezparametrowy
@Entity(name = "orders") // zmiana nazwy tabeli na orders (słowo 'order' nie zadziała)
public class Order {

    //adnotacje encji nad polami
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                                             // id produktu

    @Size(min = 2, max = 5, message = "Size must be min 2 max 5")   // nazwa produktu musi się składać od 2 do 5 znaków
    private String productName;                                     // nazwa produktu

    @Min(value = 1, message = "Ilość nie może być mniejsza od 1")
    private Integer quantity;                                       // ilość produktu
}
