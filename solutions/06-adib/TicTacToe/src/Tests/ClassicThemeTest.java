package Tests;

import org.junit.Test;
import sample.ClassicTheme;

import static org.junit.Assert.assertEquals;

public class ClassicThemeTest {
    @Test
    void getCurrentTheme() {
        ClassicTheme classicTheme = new ClassicTheme();
        assertEquals("classic", classicTheme.getCurrentTheme());
    }

    @Test
    void isClassic() {
        ClassicTheme classicTheme = new ClassicTheme();
        assertEquals(true, classicTheme.isClassic());
    }

    @Test
    void isForrest() {
        ClassicTheme classicTheme = new ClassicTheme();
        assertEquals(false, classicTheme.isForrest());
    }

    @Test
    void isHighContrast() {
        ClassicTheme classicTheme = new ClassicTheme();
        assertEquals(false, classicTheme.isHighContrast());
    }

}
