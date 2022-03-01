package sample;

public class ClassicTheme {
    String currentTheme;
    boolean isClassicTheme = true;
    boolean isForrestTheme = false;
    boolean isHighContrastTheme = false;
    public ClassicTheme(){
        currentTheme="classic";
    }

    public String getCurrentTheme() {
        return currentTheme;
    }

    public boolean isClassic(){
        return isClassicTheme;
    }

    public boolean isForrest(){
        return isForrestTheme;
    }

    public boolean isHighContrast(){
        return isHighContrastTheme;
    }


}
