package pattern.factorymethod;

public class Run {
    public static void run(){
        Menu menuA = new AmericaMenu();
        Menu menuJ = new JapanMenu();

        System.out.println(menuA.createOrNull(CupSize.LARGE).getSizeMl());
        System.out.println(menuJ.createOrNull(CupSize.LARGE).getSizeMl());
    }
}
