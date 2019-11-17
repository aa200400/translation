import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.service.YTranslateApiImpl;

import java.util.Random;
import java.util.Set;

public class MainClass {
    public static YTranslateApiImpl api = new YTranslateApiImpl("YOUR_API_KEY");
    public static void main(String... args) {
        translate();
    }

    public static void translate() {
        Set<Language> myHashSet = api.languageApi().all().languages();
        int size = myHashSet.size();
        Language selected = null;
        String text = "text to be translated";
        for (int j = 0; j < 10; j++) {
            int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
            int i = 0;

            for (Language obj : myHashSet) {
                if (i == item)
                    selected = obj;
                i++;
            }
            text = api.translationApi().translate(text,selected).toString();
        }
        System.out.println(api.translationApi().translate(text,Direction.of(selected,Language.EN)));
    }
}
