package savepassprogram;

import org.junit.*;
import java.util.HashMap;
import java.util.ArrayList;

public class testEntry {
  @Test 
  //create a hash of entries
  HashMap<String,ArrayList<String>> entryHash = new HashMap<>();
  
  //create one entry
  ArrayList<String> facebookAccount = new ArrayList<>();
  facebookAccount.add("kimpham107@gmail.com");
  facebookAccount.add("Facebook96");
  entryHash.put("Facebook",facebookAccount);
  
}
