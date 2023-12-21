package academy.pocu.comp2500.assignment2;

import lombok.Getter;

public class Stamp extends Product{

    @Getter
    private String text;

    public Stamp(StampSize stampSize, Color stampColor, String text) {
        super(stampColor,stampSize.getPrice(),stampSize.getWidth(),stampSize.getHeight());
        this.color = stampColor;
        this.text = text;
    }

    public String getDisplayName() {
        return String.format("Stamp (%d mm x %d mm)", getWidth(), getHeight());
    }
}
