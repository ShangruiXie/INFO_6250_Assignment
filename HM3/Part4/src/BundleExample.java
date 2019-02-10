import java.util.ListResourceBundle;

public class BundleExample extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"animals.cat", "cat"},
            {"animals.dog", "dog"},
            {"animals.bird", "bird"},
    };
}
