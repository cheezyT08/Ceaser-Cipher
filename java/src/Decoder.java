package javaCeaserCiferDecoder2;

//@author Torin

public class Decoder {
	
	public static String decode(String s, int shift) {
	//////////INITIALIZE_VARIABLES///////////
      int currantOp = 0, currantNum = 0;
      
      char[] input = new char[s.length()];
      char[] output = new char[s.length()];
      boolean[] upCase = new boolean[s.length()];
      
      for(int i = 0; i < s.length(); i++) {
          input[i] = s.charAt(i);
      }
      for(int i = 0; i < s.length(); i++) {
    	  if(Character.isUpperCase(input[i])) {
    		  upCase[i] = true;
    	  } else {
    		  upCase[i] = false;
    	  }
    	  input[i] = Character.toLowerCase(input[i]);
      }
      
      ///////////MAIN_CODE///////////
      for(int j = 0; j < s.length(); j++) {
          if(input[j] > 96 && input[j] < 123) {
              currantNum = (int)((input[j] - shift) - 96);
              currantOp = shift;
              if(currantNum < 1) {
                  currantOp -= 26;
              }else if(currantNum > 25) {
                  currantOp += 26;
              }
              output[j] = (char)(input[j] - currantOp);
          }
      }
      ///////////DEBUGGING_VARS///////////
      /*
      System.out.println("\n//////DEBUGING VARS//////\n");
      for(var j = 0; j < inputString.length(); j++) {
          System.out.print(inputString.charAt(j));
          System.out.print(" to ");
          System.out.print(output[j]);
          System.out.println(" " + j);
      }
      System.out.println("\ncurrantNum = " + currantNum);
      System.out.println("input = " + inputString);
      System.out.println("shift = " + shift);
      System.out.println("currantOp = " + currantOp);
      */        
             
      
      /////////////OUTPUT_CODE////////////
      String outS = "";
      for(var i = 0; i < input.length; i++) {
    	  if(upCase[i]) {
    		  outS += Character.toUpperCase(output[i]);
    	  } else {
    		  outS += output[i];
    	  }
      }
      return outS;
	}
	
}
