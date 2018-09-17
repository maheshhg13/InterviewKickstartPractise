package Microsoft;

public class AddNumbersInString {
	public int addNumbers(String s){
		int result = 0;
		if(s==null || s.length()==0){
			return result;
		}
		s = s.trim();
		s = s.toLowerCase();
		int lastIndex = 0;
		String intermediate = "";
		boolean isMinus = false;
		for(int i=0;i<s.length();i++){
			for(int j=3;j<=5;j++){
				if(i+j>s.length()){
					break;
				}
				String temp = get(s.substring(i, i+j));
				
				if(temp!=null){
					if(temp.equals("-")){
						intermediate+="-"; 
						isMinus = true;
					}else if(lastIndex==(i-1) || intermediate.isEmpty() || isMinus){
						intermediate+=temp;
						lastIndex = i+j-1;
						isMinus = false;
					}else{
						intermediate+="+"+temp;
						lastIndex = i+j-1;
						isMinus = false;
					}
					i = i+j-1;
					break;
				}
			}
		}
		System.out.println(intermediate);
		
		isMinus = false;
		int currnum = 0;
		for(int i=0; i<intermediate.length(); i++){
			if(intermediate.charAt(i) == '-'){
				if(isMinus) {result -= currnum;} else {result += currnum;}
				isMinus=true;
				currnum=0;
			} else if(intermediate.charAt(i) == '+'){
				if(isMinus) {result -= currnum;} else {result += currnum;}
				isMinus=false;
				currnum=0;
			} else {
				currnum = currnum*10 + Integer.parseInt(intermediate.charAt(i)+"");
			}
		}
		if(isMinus) {result -= currnum;} else {result += currnum;}
		return result;
		
		
	}

	private String get(String s) {
		System.out.println("Got: "+s);
		switch(s){
		case "zero": return "0";
		case "one": return "1";
		case "two":  return "2";
		case "three": return "3";
		case "four": return "4";
		case "five": return "5";
		case "six": return "6";
		case "seven": return "7";
		case "eight": return "8";
		case "nine": return "9";
		case "minus": return "-";
		default: return null;
		}
	}
	public static void main(String[] args) {
		//AddNumbersInString temp = new AddNumbersInString();
		//System.out.println(temp.addNumbers("xyzonexyztwothreeeabrminusseven"));
		System.out.println(Integer.parseInt("-2"));
	}
}
