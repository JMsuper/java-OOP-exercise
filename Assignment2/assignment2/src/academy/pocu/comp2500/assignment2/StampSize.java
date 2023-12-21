package academy.pocu.comp2500.assignment2;

import lombok.Getter;

@Getter
public enum StampSize {
    SMALL(40,30,2300),
    MEDIUM(50,20,2300),
    LARGE(70,40,2600);

    private final int width;
    private final int height;
    private final int price;
    StampSize(int width, int height, int price){
        this.width = width;
        this.height = height;
        this.price = price;
    }

}
