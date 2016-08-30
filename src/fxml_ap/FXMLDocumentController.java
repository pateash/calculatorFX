/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_ap;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author ashish_patel
 */
public class FXMLDocumentController implements Initializable {
    @FXML private TextField field;
    boolean flushable=true;
    String lastAns="";
    String operator="";
    @FXML private void processNum(ActionEvent event) {
        //if after flushable an operator comes then we have to append the operator to the last ans
        // so that the user  could be able to work with the last ans 
       operator= ((Button)event.getSource()).getText();
        if(!flushable || operator.equals("+")||  operator.equals("-")||  operator.equals("*")||  operator.equals("/")){
           if(flushable){
               field.setText(lastAns+((Button)event.getSource()).getText());
             flushable=false;
           }
               else
             field.setText(field.getText()+((Button)event.getSource()).getText());
           
           
        }
        else{
          field.setText(((Button)event.getSource()).getText());
            flushable=false;
           
        }
       
    }
    
    @FXML private void processOperator(ActionEvent event) {
        operator=((Button)event.getSource()).getText();
      
  
        if(operator.equals("AC")){
            field.setText("");
          return;
          }
        else if(operator.equals("=")){
             if(flushable){
                 System.out.println("it was flushable");
              field.setText(lastAns);
             return;
          }
     
            if(field.getText().equals("")){
                showAlert();
               return;
            }
            String[] operands=field.getText().split("[*/+-]+");
            String[] operators=field.getText().split("[0-9.]+");
              for (String s: operands)
            System.out.println(s);
        for (String s: operators)
            System.out.println(s);
      
      
            //System.out.println("outside try");
            try{
                
            //    System.out.println("inside try");
        double ans=Calculate.solve(operators, operands);
           lastAns=String.format("%.4f",ans);      
        System.out.println("ans is "+ans);
        field.setText(field.getText()+" = "+String.format("%.4f",ans));
         flushable=true;
            }catch(Exception e){
                System.out.println("exception comes");
              showAlert();
            }
        }
    }
    @FXML private void showMenuAbout(ActionEvent e){
        String s="Developed by Ashish Patel\n Git-github.com/ashishpatel0720\nFacebook -fb.com/ashishpatel0720";
        Alert a=new Alert(Alert.AlertType.INFORMATION,s , ButtonType.CLOSE);
        a.setHeaderText("About");
        a.setTitle("about");
        
        a.show();
    }
    @FXML private void processFieldAction(ActionEvent event){
        System.out.println("Action event is called");
         if(flushable){
                 System.out.println("it was flushable");
              field.setText(lastAns);
             return;
          }
     
            if(field.getText().equals("")){
                showAlert();
               return;
            }
            String[] operands=field.getText().split("[*/+-]+");
            String[] operators=field.getText().split("[0-9.]+");
              for (String s: operands)
            System.out.println(s);
        for (String s: operators)
            System.out.println(s);
      
      
            //System.out.println("outside try");
            try{
                
            //    System.out.println("inside try");
        double ans=Calculate.solve(operators, operands);
           lastAns=String.format("%.4f",ans);      
        System.out.println("ans is "+ans);
        field.setText(field.getText()+" = "+String.format("%.4f",ans));
         flushable=true;
            }catch(Exception e){
                System.out.println("exception comes");
              showAlert();
            }
        
    }
    @FXML private void showMenuWorking(ActionEvent e){
        String s="this calculator work on LEFT TO RIGHT procedure,\nit does not follow typical BODMAS rules";
        Alert a=new Alert(Alert.AlertType.INFORMATION,s , ButtonType.CLOSE);
        a.setHeaderText("Working");
        a.setTitle("working");
        
        a.show();
    }
    @FXML private void showMenuClose(ActionEvent e){
        System.exit(0);
    }
     @FXML private void showMenuClear(ActionEvent e){
     field.setText("");
     }
  
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
private void showAlert(){
      Alert a=new Alert(Alert.AlertType.ERROR,"Invalid Input",ButtonType.OK);
      a.show();
}    
    
}
