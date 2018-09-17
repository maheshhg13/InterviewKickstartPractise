import java.util.NoSuchElementException;
 import java.util.Stack;
 public class ExpressionTree 
 {

private final String postfix;
private TreeNode root;

/**
 * Takes in a valid postfix expression and later its used to construct the expression tree.
 * The posfix expression, if invalid, leads to invalid results 
 * 
 * @param postfix   the postfix expression.
 */
public ExpressionTree(String postfix) 
{
    if (postfix == null) { throw new NullPointerException("The posfix should not be null"); }
    if (postfix.length() == 0)  { throw new IllegalArgumentException("The postfix should not be empty"); } 
    this.postfix = postfix;
}

private static class TreeNode 
{
    TreeNode left;
    char ch;
    TreeNode right;

    TreeNode(TreeNode left, char ch, TreeNode right) {
        this.left = left;
        this.ch = ch;
        this.right = right;
    }
}


private boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
}


/**
 * Constructs an expression tree, using the postfix expression
 */
public void createExpressionTree() 
{
    final Stack<TreeNode> nodes = new Stack<TreeNode>();
    for (int i = 0; i < postfix.length(); i++) 
    {
        char ch  = postfix.charAt(i);
        if (isOperator(ch)) 
        {
           TreeNode rightNode = nodes.pop();
           TreeNode leftNode = nodes.pop();
           nodes.push(new TreeNode(leftNode, ch, rightNode));
        } else if (!Character.isWhitespace(ch))
        {
            nodes.add(new TreeNode(null, ch, null));
        }
    }
    root = nodes.pop();
}
/**
 * Returns the infix expression
 * 
 * @return  the string of infix.
 */
public String infix() 
{
    if (root == null) 
    {
        throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
    }
    final StringBuilder infix = new StringBuilder();
    inOrder(root, infix);
    return infix.toString();
}

private void inOrder(TreeNode node, StringBuilder infix) {
    if (node != null) {
        inOrder(node.left, infix);
        infix.append(node.ch);
        inOrder(node.right, infix);
    }
}
public Double evaluate(String postfix)
{
    Stack<Double> s = new Stack<Double>();
    char[] chars = postfix.toCharArray();
    int N = chars.length;
    for(int i = 0; i < N; i++)
    {
        char ch = chars[i];
        if(isOperator(ch))
        {
            switch(ch)
            {
            case '+': s.push(s.pop() + s.pop());     break;
            case '*': s.push(s.pop() * s.pop());     break;
            case '-': s.push(-s.pop() + s.pop());    break;
            case '/': s.push(1 / s.pop() * s.pop()); break;
            }
        }
        else if(Character.isDigit(ch)) 
        {
            s.push(0.0);
            while (Character.isDigit(chars[i]))
                s.push(10.0 * s.pop() + (chars[i++] - '0'));
    }
    } 
        return s.pop();

    }
    }