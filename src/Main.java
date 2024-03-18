import java.util.Scanner;
import java.lang.Math;



public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int inNumber = s.nextInt();
        s.nextLine();


        int[] alphabet = new int[26];
        int[] alphabetSave = new int[26];
        int[] alphabetWeight = new int[26];
        for(int i = 0; i < 26; i++){
            alphabet[i] = 0;
            alphabetSave[i] = 0;
            alphabetWeight[i] = 0;
        }

        String[] inString = new String[inNumber];
        int tempLength;
        char tempChar;
        int tempCharInt;


        for (int i = 0; i < inNumber; i++) {
            inString[i] = s.nextLine();
        }


        for(int i = 0; i < inNumber; i++){
            tempLength = inString[i].length();

            for(int k = 0; k < tempLength; k++){
                tempChar = inString[i].charAt(k);
                tempCharInt = (int)tempChar - 65;
                alphabet[tempCharInt] += (int)Math.pow(10,(tempLength - (k+1)));
            }

        }


        tempCharInt = 0;  //사용된 알파벳 갯수
        for(int i = 0; i < 26; i++){
            if(alphabet[i] != 0){
                tempCharInt++;
            }
        }

        int countT;
        int count = 0;
        for(int i = 0; i < tempCharInt; i++) {     //알파벳 가치 구함
            tempLength = 0; //가장 큰 숫자 임시 저장
            for (int k = 0; k < 26; k++) {
                if (alphabet[k] > tempLength) {
                    tempLength = alphabet[k];
                }
            }

            countT = 0;
            for (int k = 0; k < 26; k++) {
                if(alphabet[k] == tempLength){
                    alphabetSave[k] = tempLength;
                    alphabet[k] = -1;
                    countT++;
                }
            }

            if(countT != 1){
                count += (countT - 1);
            }
            for (int k = 0; k < 26; k++) {
                if(alphabetSave[k] == tempLength) {
                    countT--;
                    alphabetWeight[k] = 9 - (i + count - countT);
                }
            }
        }


        int sum = 0;
        for(int i = 0; i < 26; i++){
            sum += alphabetSave[i]*alphabetWeight[i];
        }

        System.out.printf("%d", sum);

    }


}
