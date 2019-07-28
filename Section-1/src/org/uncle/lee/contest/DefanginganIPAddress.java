package org.uncle.lee.contest;

public class DefanginganIPAddress {
	public String defangIPaddr(String address) {
		return address.replace(".", "[.]");
	}
	
	public static void main(String[] args) {
		DefanginganIPAddress defanginganIPAddress = new DefanginganIPAddress();
		System.out.println(defanginganIPAddress.defangIPaddr("1.1.1.1"));
		System.out.println(defanginganIPAddress.defangIPaddr("255.100.50.0"));
	}
}
