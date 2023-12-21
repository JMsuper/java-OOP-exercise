package academy.pocu.comp2500.assignment2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Product {
    protected Color color;

    @Getter
    @Setter
    protected DeliveryMethod deliveryType;

    @Getter
    protected int price;

    @Getter
    private int width;
    @Getter
    private int height;

    public Product(Color color, int price, int width, int height){
        this.color = color;
        this.price = price;
        this.width = width;
        this.height = height;
        this.deliveryType = DeliveryMethod.PICKUP;

    }
}
