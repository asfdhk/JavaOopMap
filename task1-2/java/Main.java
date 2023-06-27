import java.io.File;

public class Main {
    public static void main(String[] args) {
        Demo demo = new Demo();
        File words = new File("Еranslator.txt");
        demo.ukrainianText(demo.englishText());
    }
}
