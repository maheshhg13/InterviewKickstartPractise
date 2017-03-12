package warmup.test;

public class atoi {
    static int atoiIK(String str) {
        int number = 0;
        str = str.trim();
        boolean isNegative = false;
        while(true && str.length()>0){
            if(str.charAt(0)=='-'){
                isNegative = true;
                str = str.substring(1);
                break;
            }else if(str.charAt(0)=='+'){
                str = str.substring(1);
                break;
            }else{
               int candidate = str.charAt(0)-'0';
               if((candidate<0 || candidate>9)){
                    str = str.substring(1);
                }else{
                    break;
                } 
            } 
        }
        
        char[] data = str.toCharArray();
        for(char c:data){
            int candidate = c-'0';
            if(candidate<0 || candidate>9){
                break;
            }
            number = number*10 + candidate;
        }
        return (isNegative?(-1*number):number);

    }
    public static void main(String[] args){
    	System.out.println(atoiIK(" + 413"));
    }
}
