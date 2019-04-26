package Errors;

public class LexerException extends CompilerExc {

  private String msg;

  public LexerException(String s) {
     msg = s;
     System.out.println("ERROR léxico");
       }

  public String toString() {
     return msg;
       }
}
