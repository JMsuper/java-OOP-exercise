import org.example.app.Topping;
import org.example.app.ToppingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestTopping {

    @Test
    void getType(){
        Topping mozza = Topping.MOZZARELLA;
        System.out.println(mozza.getType());
        Assertions.assertEquals(ToppingType.CHEESE,mozza.getType());

        Topping chicken = Topping.CHICKEN;
        System.out.println(chicken.getType());
        Assertions.assertEquals(ToppingType.MEAT,chicken.getType());
    }
}
