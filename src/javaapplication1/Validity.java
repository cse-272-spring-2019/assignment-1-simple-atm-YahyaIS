
package javaapplication1;

import java.util.HashMap;

public class Validity {
    HashMap usersNumbers;
    ATM atm =new ATM();
    double money;
    public Validity() {
        
        usersNumbers = new HashMap();
        usersNumbers.put("11111",0.0);
        usersNumbers.put("12222", 0.0);
        usersNumbers.put("12233", 0.0);
        usersNumbers.put("22222", 0.0);     
    }
    
    public boolean checkValidity(String cardNumber){
        return usersNumbers.containsKey(cardNumber);
    }

    
    
    
    
    
   }

