import java.util.ArrayList;
import java.util.Arrays;

public class Stringing {

    public String reverse(String str) {
        String result = "";
        String word = "";

        for (int index = str.length() - 1; index >= 0; index--) {
            char cha = str.charAt(index);
            if (cha != ' ') {
                word = cha + word;
                } else {
                result += word + " ";
                word = "";
            }
        }
        result += word;
        return result;
    }
}

