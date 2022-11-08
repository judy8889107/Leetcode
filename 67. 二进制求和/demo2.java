import java.util.*;
/**
 * 执行用时：1 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了 90.45%  的用户
 * 題解：
 * 將較大string assign給a, 小的就是b, 若相等就沒差
 * 將答案(result)設定為比較大的那個string, 先讓那個string 轉為 char array
 * 然後先看有無carry 決定 result 值的變化
 * 後面將result和 min string 相加, carry的判斷在前面carry有做了
 * 這裡特別注意，也許剛好carry, carry+result[i] = 0, 又是carry, 那下面跟min string相加不會改變carry的值
 * 下面唯一設定carry為true的情況只有11
 * 其他01,10,00,都不能確定,有可能0是因為 carry+result[i] = 0, 0 在和minstr[j]相加, 這時候就要沿用carray值
 */
class Solution {
    public String addBinary(String a, String b) {

        // Swap String a to max String
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
            
        }
        
        char[] result = a.toCharArray();
        boolean carry = false;
        
        for (int i = result.length-1, j = b.length()-1; i > -1; i--, j--) {

            
            if( j < 0){
                if(!carry) break;
                if(result[i] == '1'){
                    result[i] = '0';
                    carry = true;
                }else{
                    result[i] = '1';
                    carry = false;
                    break;
                }
                continue;
            }
            if(carry){
                if(result[i] == '1'){
                    result[i] = '0';
                }else{
                    result[i] = '1';
                    carry = false;
                }
            }
            if(result[i] == b.charAt(j)){ // 00, 11
                if(result[i] == '1'){ //11
                    result[i] = '0';
                    carry = true;
                }else{
                    result[i] = '0';
                }
            }else{ // 10,01
                result[i] = '1';
            }
            // System.out.println("t: "+String.valueOf(result));
            
        }

        String ans = String.valueOf(result);
        if(carry) ans = '1'+ans;

        // System.out.println(ans);
        return ans;
    }
}

public class demo2 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        String s1, s2;
        while (sc.hasNextLine()) {
            s1 = sc.nextLine().replace("\"", "");
            s2 = sc.nextLine().replace("\"", "");
            System.out.printf("a: %s, b: %s\n", s1, s2);
            System.out.println("ans: "+solution.addBinary(s1, s2));
            

        }
    }

}
