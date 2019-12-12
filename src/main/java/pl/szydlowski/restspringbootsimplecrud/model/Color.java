package pl.szydlowski.restspringbootsimplecrud.model;

public enum Color {

    BLUE("blue"),
    WHITE("white"),
    GRAY("gray"),
    BLACK("black"),
    RED("red");

    private String displayColor;

    Color(String displayColor){
        this.displayColor = displayColor;
    }

    public String getDisplayColor(){
        return displayColor;
    }

    @Override
    public String toString() {
        return
                "displayColor='" + displayColor + '\''
                ;
    }
}
