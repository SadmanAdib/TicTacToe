package Tests;

import org.junit.Test;
import sample.ForestTheme;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForestThemeTest {
    @Test
    void getCurrentTheme() {
        ForestTheme forrestTheme = new ForestTheme();
        assertEquals("forest", forrestTheme.getCurrentTheme());
    }

    @Test
    void isClassic() {
        ForestTheme forrestTheme = new ForestTheme();
        assertEquals(false, forrestTheme.isClassic());
    }

    @Test
    void isForrest() {
        ForestTheme forrestTheme = new ForestTheme();
        assertEquals(true, forrestTheme.isForrest());
    }

    @Test
    void isHighContrast() {
        ForestTheme forrestTheme = new ForestTheme();
        assertEquals(false, forrestTheme.isHighContrast());
    }

}
