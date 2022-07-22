/*
* Parse + validate strings for a simple language as follows :
* input -> "add(1,3)"
* input -> "sub(1,3)"
* operations take only 2 params. commands may be nested.
* ie. add(sub(3,4), 1) sub(add(238943, 2343), add(1, sub(323, 43)))
* if an error is detected, report the column and what the error was
*/

public class Evaluate {
    public static void main(String args[]) {
      System.out.println(evaluate("sub(add(238943, 2343), add(1, sub(323, 43)))"));
    }
    public static int evaluate(String input){
        input = input.trim();
        int count = 0;
        int openingParanthesis = -1;
        int closingParanthesis = -1;
        int comma = -1;
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '(' ){
                if(count == 0 && openingParanthesis == -1)
                    openingParanthesis = i;
                count++;
            }else if(ch == ')'){
                count--;
                if(count == 0)
                    closingParanthesis = i;
            }
            if(ch == ',' && count ==1){
                comma = i;
            }
        }
        if(openingParanthesis == -1 && closingParanthesis == -1 && comma == -1 )
            return Integer.parseInt(input);
        String operand =  input.substring(0, openingParanthesis);
        int operand1 = evaluate(input.substring(openingParanthesis+1, comma));
        int operand2 = evaluate(input.substring(comma+1, closingParanthesis));
        if(operand.equals("add")){
            return operand1+operand2;
        }else if(operand.equals("sub")){
             return operand1-operand2;
        }else{
          throw new IllegalArgumentException("Not valid operation");
        }
    }
}
