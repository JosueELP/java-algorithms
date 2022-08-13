public class Palindrom {
    public static void main(String[] args) {

        String word = "anita lava la tina";

        System.out.println(word);
        word = word.toLowerCase();
        System.out.println(word);
        word = word.replace(" ", "");
        System.out.println(word);

        String result = "IT'S A PALYNDROM";

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(word.length() - (i + 1));
            if(word.charAt(i) != c){
                result = "IT'S NOT A PALYNDROM";
                break;
            }
        }

        System.out.println(result);

    }
}
