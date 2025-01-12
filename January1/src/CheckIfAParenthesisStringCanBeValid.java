import java.util.*;
// ps: https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
// time complexity o(n)
// space complexity o(n)
// parenthesis

public class CheckIfAParenthesisStringCanBeValid {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n%2==1){
            return false;
        }
        Stack<Integer> open = new Stack<>();
        Stack<Integer> openclose = new Stack<>();
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0'){
                openclose.push(i);
            }else if(s.charAt(i)=='('){
                open.push(i);
            }else if(s.charAt(i)==')'){
                if(!open.isEmpty()){
                    open.pop();
                }else if(!openclose.isEmpty()){
                    openclose.pop();
                }else{
                    return false;
                }
            }
        }
        while(!open.isEmpty() && !openclose.isEmpty() && open.peek()<openclose.peek()){
            open.pop();
            openclose.pop();
        }
        if(open.isEmpty()){
            return true;
        }
        return false;
    }
}
