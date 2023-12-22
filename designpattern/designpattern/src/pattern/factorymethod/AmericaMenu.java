package pattern.factorymethod;

public class AmericaMenu extends Menu{
    @Override
    public Cup createOrNull(CupSize size){
        switch (size){
            case SMALL:
                return new Cup(355);
            case MEDIUM:
                return new Cup(477);
            case LARGE:
                return new Cup(888);
            default:
                assert (false) : "Unhandled CupSize: " + size;
                return null;
        }
    }
}
