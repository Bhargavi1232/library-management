import javax.swing.*;
import java.util.*;

public class numberguessinggame{
    public static void main(String[] args){
        int randomnumber=(int)(Math.random()*100+1);
        int user=0;
        System.out.println("THE CORRECT GUESS:"+randomnumber);
         int count=1;
        while(user!=randomnumber){
            String res=JOptionPane.showInputDialog(null,"Guess a number b/w 1 and 100","Number Guessing Game",3);
            user=Integer.parseInt(res);
            JOptionPane.showMessageDialog(null,""+Guess(user, randomnumber, ++count)+points(++count));
        }
    }
    public static String Guess(int user,int randomnumber,int count){
        if(count>6){
            return "You cann't attempt more than 5 times";
        }

        if(user<=0 || user >100){
            
            return "Your guess should be b/w 1 and 100";
        }
        else if(user==randomnumber){
           
            return "Correct \n Total Guesses:"+count;        }
        else if(user>randomnumber){
           
            return "Your guess is high,try again,\n Try Number:"+count;
        }
        else if(user<randomnumber){
           
            return "Your guess is low,try again, \n Try Number:"+count;
        }
        else{
            return "Your guess is incorrect \n Try Number:"+count;
        }
    }

    public static String points(int count){
       if(count>4 && count <6)
            return "\n 30 points";
        else if(count>3 && count<=4)
            return "\n you missed 50 points";
        else
            return "\n you got 89 points";
    }
}