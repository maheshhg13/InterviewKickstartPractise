  import java.util.Scanner;
      public class ExpressionTester{

       public static void main(String[] args) 
      {
    Scanner sc = new Scanner(System.in);
    while(true)
    {
    System.out.println("");
    String pf = sc.nextLine();
    ExpressionTree eT = new ExpressionTree(pf);
    eT.createExpressionTree();
    System.out.println("The infix: " + eT.infix() );
    System.out.println(eT.evaluate(pf));
    }

    }
    }
      