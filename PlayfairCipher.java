import java.util.*;
class PlayfairCipher{
    public static char [][]matrix = new char[5][5]; 
    public static String Process(String txt,boolean encrypt){
        StringBuilder sb = new StringBuilder();
        String text = PrepareText(txt);
        for(int i=0;i<text.length();i+=2){
            int [] p1 = findpos(text.charAt(i));
            int [] p2 = findpos(text.charAt(i+1));
            //SAME ROW
            if(p1[0]==p2[0]){
                sb.append(matrix[p1[0]][(p1[1]+(encrypt?1:4))%5]);
                sb.append(matrix[p2[0]][(p2[1]+(encrypt?1:4))%5]);
            }
            //SAME COLUMN
            else if(p1[1]==p2[1]){
                sb.append(matrix[(p1[0]+(encrypt?1:4))%5][p1[1]]);
                sb.append(matrix[(p2[0]+(encrypt?1:4))%5][p2[1]]);
            }else {
                sb.append(matrix[p1[0]][p2[1]]);
                sb.append(matrix[p2[0]][p1[1]]);
            }
        }
        return sb.toString();
    }
    public static void CreateMatrix(String key){
        key = key.toUpperCase().replace("J","I");
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for(char c: (key+alphabet).toCharArray()) set.add(c);
        int i = 0;
        for (char c: set) matrix[i/5][i++%5] = c;
    }
    public static String PrepareText(String txt){
        txt = txt.toUpperCase().replace("J","I").replaceAll("[^A-Z]","");
        StringBuilder prepared = new StringBuilder();
        for(int i =0 ;i< txt.length();i++){
            char current = txt.charAt(i);
            prepared.append(current);
            if(i+1<txt.length()&& current == txt.charAt(i+1)){
                prepared.append('X');
            }
        }
        if(prepared.length()%2!=0){
            prepared.append('X');
        }
        return prepared.toString();
    }
    private static int[] findpos(char c){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(matrix[i][j]==c) return new int[]{i,j};
            }
        }
        return null;
    }
    public static void main(String[] args){
        String key = "security";
        CreateMatrix(key);
        String plaintext = "cryptography";
        String encryptedmsg = Process(plaintext,true);
        System.out.println(encryptedmsg);
        String decryptedmsg = Process(encryptedmsg,false);
        System.out.println(decryptedmsg);
    }
}