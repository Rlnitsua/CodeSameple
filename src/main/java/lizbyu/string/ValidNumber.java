package lizbyu.string;

public class ValidNumber {
	public boolean isNumber(String s) {
		// delete first and last blank
		if(s.trim().isEmpty()){
			return false;
		}
		s = s.trim();
		
		try{
			Double.parseDouble(s);
		}catch(Exception intE){
			return false;
		}
		
		if(s.endsWith("f") || s.endsWith("d") || s.endsWith("D") || s.endsWith("F")){
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new ValidNumber().isNumber("2e10"));
		System.out.println(new ValidNumber().isNumber("1 "));
		System.out.println(new ValidNumber().isNumber(".1"));
		System.out.println(new ValidNumber().isNumber("3."));
		System.out.println(new ValidNumber().isNumber(".."));
		System.out.println(new ValidNumber().isNumber("2.."));
		System.out.println(new ValidNumber().isNumber("0.8"));
		System.out.println("  a b ".trim());
		Integer.valueOf("08");
		System.out.println("0.8".replace(".", ""));
	}
}
