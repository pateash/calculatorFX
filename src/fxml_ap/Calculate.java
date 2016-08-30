/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_ap;

/**
 *
 * @author ashish_patel
 */
public class Calculate {
    
    public static double calculate(double a,String op2,String operator) throws Exception{
      
        double b=Double.parseDouble(op2);
        switch(operator){
            case "+":
                return a+b;
                case "-":
                    return a-b;
                case "*":
                    return a*b;
                case "/":
                    return a/b;
                default:
                    return 0;
      }
  }
    public static double solve(String[] operators,String [] operands) throws Exception{
        System.out.println("solve is caled  "+operands.length+" "+operators.length);
     if(!(operands.length==1&&operators.length==0)&&operators.length!=operands.length){
         System.out.println("throwing exception");
         throw new Exception();
        
     }
         double leftOp=0.0;
     leftOp=Double.parseDouble(operands[0]);
        
     System.out.println("Left operator is "+leftOp);
        for (int i = 1; i < operands.length; i++) {
            String op=operators[i];
            if(op.length()!=1)
                throw new Exception();
            leftOp=Calculate.calculate(leftOp, operands[i], op);
        System.out.println("Left operator is "+leftOp);
           
        }
        
     
     return leftOp;
    }
}
