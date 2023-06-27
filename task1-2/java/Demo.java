import java.io.*;
import java.util.*;

import static javax.swing.JOptionPane.showInputDialog;

public class Demo {

    public Demo (){
        createTranslator();
    }

    private Map<String,String> translator = new HashMap<>();

    public void createTranslator(){
        translator.put("Our","наша");
        translator.put("Earth","земля");
        translator.put("so","так");
        translator.put("beautiful","прекрастна");
        translator.put("There","тут");
        translator.put("lot","багато");
        translator.put("blue","голубий");
        translator.put("rivers","ріки");
        translator.put("lakes","озера");
        translator.put("oceans","океан");
        translator.put("full","повний");
        translator.put("wonders","чудес");
        translator.put("high","висока");
        translator.put("mountains","гори");
        translator.put("covered","накрити");
        translator.put("with","з");
        translator.put("snow","сніг");
        translator.put("wonderful","чудовий");
        translator.put("fields","поля");
        translator.put("forests","ліса");
        translator.put("and","і");
        translator.put("different","різні");
        translator.put("plants","рослини");
        translator.put("animals","тварини");
    }

    public void addTranslator(){
        String englishWord = "";
        String translatorInUk = "";
        try {
            englishWord =String.valueOf(showInputDialog("Input words in English: "));
            translatorInUk = String.valueOf(showInputDialog("Input translator: "));
        }catch (NumberFormatException e){
            showInputDialog(null,"Error number format");
        }
        catch (NullPointerException e){
            showInputDialog(null,"Ok");
        }
        translator.put(englishWord,translatorInUk);
    }

    public void saveTranslator(File file){
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(String.valueOf(translator));
            writer.close();
        }catch (IOException e){
            showInputDialog(null,"Error file not found");
        }
    }

    public File englishText(){
        File file = new File("English.in.txt");
        String text = "";
        try {
            FileWriter writer = new FileWriter(file);
            text = String.valueOf(showInputDialog(null,"Enter text"));
            writer.write(text);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return file;
    }

    public File ukrainianText(File eng) {
        List<String> noTranslation= new ArrayList<>();
        File file = new File("Ukrainian.out.txt");
        String text ="";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(eng));
            text = reader.readLine();
            reader.close();
            if (text.charAt(text.length()-1)!=' '){
                text +=" ";
            }
            int a =0;
            System.out.println(text);
            FileWriter writer = new FileWriter(file);
            int m =0;
            for (int i = 0;i<text.length();i++){
                if(text.charAt(i) == ' '){
                    for(Map.Entry<String, String> entry: translator.entrySet()){
                        m++;
                        if (text.substring(a,i).equals(entry.getKey())) {
                            System.out.print(entry.getValue() + " ");
                            writer.write(entry.getValue() + " ");
                            break;
                        }
                    }
                    if (m==translator.size()){
                        noTranslation.add("Не дано переклад даного слова " + text.substring(a,i));
                    }
                    a =i+1;
                    m=0;
                }
            }
            writer.write("\n");
            writer.write(String.valueOf(noTranslation));
            System.out.println();
            System.out.println(text);
            writer.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public Map<String, String> getTranslator() {
        return translator;
    }
}
