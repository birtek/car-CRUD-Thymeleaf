package pl.szydlowski.restspringbootsimplecrud.model;

public enum Color {

    BLUE("Blue"),
    WHITE("White"),
    GRAY("Gray"),
    BLACK("Black"),
    RED("Red");

    private String displayColor;

    Color(String displayColor){
        this.displayColor = displayColor;
    }

    public String getDisplayColor(){
        return displayColor;
    }

}
