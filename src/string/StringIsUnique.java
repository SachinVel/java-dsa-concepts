package string;

/*

    Question : To check whether the string has only unique characters without using extra space.
    Approach :
       1. use a variable as hashset to store previous ooccurance of characters.
       2. For example, If a is present, the first bit in that variable is set.
       3. This variable is called bit vector.
 */
public class StringIsUnique {

    public static void main(String args[]){
        String str = "abcd";
        int vector = 0;
        boolean isUnique = true;
        for( char chr : str.toCharArray() ){
            int charBit = (int)chr-'a';
            if( (vector&(1<<charBit))>0 ){
                isUnique = false;
                break;
            }
            vector |= 1<<charBit;
        }

        System.out.println(12&4);
    }

}
