package string;

/*
    Question :
        The input is URL with space. So the space must be replaced with '%20' ASCII characters.
        The input will have fixed length. So the operation must take in-place.

    Approach :
        1. start from backside and when space is encountered add '%20' instead of original space.
 */
public class URLify {

    public static void urlify(char[] inputURL ){

        int curInd = inputURL.length-1;
        while( curInd>=0 && inputURL[curInd]==' ' ){
            --curInd;
        }
        int writeInd = inputURL.length-1;
        while( curInd>=0 ){
            if( inputURL[curInd]==' '){
                inputURL[writeInd--] = '0';
                inputURL[writeInd--] = '2';
                inputURL[writeInd--] = '%';
            }else{
                inputURL[writeInd--] = inputURL[curInd];
            }
            --curInd;
        }
    }

    public static void main(String args[]){
        String url = "Mr John Smith    ";
        char[] input = url.toCharArray();
        urlify(input);
        System.out.println(new String(input));
    }

}
