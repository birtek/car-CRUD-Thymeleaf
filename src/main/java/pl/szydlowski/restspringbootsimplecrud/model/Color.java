package pl.szydlowski.restspringbootsimplecrud.model;

public enum Color {

    BLUE("blue"),
    WHITE("white"),
    GRAY("gray"),
    BLACK("black"),
    RED("red");

    private String displayColor;

    Color(String dispalyColor){
        this.displayColor = dispalyColor;
    }

    public String getDisplayColor(){
        return displayColor;
    }
}
