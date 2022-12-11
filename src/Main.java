import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String phoneNumber = "23";
        List<String> res = LetterCombinationPhoneLetter(phoneNumber);
        System.out.println("Hello world!");
    }

    private static List<String> LetterCombinationPhoneLetter(String phoneNumber) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        if (phoneNumber.length() == 0) return res;
        backtrack(0,path,phoneNumber,res);
        return res;



    }

    private static void backtrack(int index,StringBuilder path,String phoneNumber,List<String> res) {
        Map<Character,String> map = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",
                '6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
        if (path.length() == phoneNumber.length()) {
            res.add(path.toString());
            return;
        }
        String possibleLetter = map.get(phoneNumber.charAt(index));
        for (char ch : possibleLetter.toCharArray()) {
            path.append(ch);
            backtrack(index+1,path,phoneNumber,res);
            path.deleteCharAt(path.length()-1);
        }



    }


}