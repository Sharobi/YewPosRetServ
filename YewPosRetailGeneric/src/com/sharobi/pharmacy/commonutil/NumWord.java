/**
 * 
 */
package com.sharobi.pharmacy.commonutil;


/**
 * @author habib
 *
 */
public class NumWord {
	
	String string;
	String a[] = { " ", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
			"Eight", "Nine", };

	String b[] = { "Hundred", "Thousand", "Lakh", "Crore"
	};

	String c[] = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
			"Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen", };

	String d[] = {
			"Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninty" };
	
	public String convertNumToWord(String num) {

		int c = 1;
		int rm;
		int number = Integer.parseInt(num);
		String decimal = null;
		
		if(number == 0){
			return "Zero";
		}
		
		string = "";
		while (number != 0) {
			switch (c) {
			case 1:
				rm = number % 100;
				pass(rm);
				if (number > 100 && number % 100 != 0) {
					display("");
				}
				number /= 100;

				break;

			case 2:
				rm = number % 10;
				if (rm != 0) {
					display(" ");
					display(b[0]);
					display(" ");
					pass(rm);
				}
				number /= 10;
				break;

			case 3:
				rm = number % 100;
				if (rm != 0) {
					display(" ");
					display(b[1]);
					display(" ");
					pass(rm);
				}
				number /= 100;
				break;

			case 4:
				rm = number % 100;
				if (rm != 0) {
					display(" ");
					display(b[2]);
					display(" ");
					pass(rm);
				}
				number /= 100;
				break;

			case 5:
				rm = number % 100;
				if (rm != 0) {
					display(" ");
					display(b[3]);
					display(" ");
					pass(rm);
				}
				number /= 100;
				break;

			}
			c++;
		}

		
		return string;
	}

	public void pass(int number) {
		int rm, q;
		if (number < 10) {
			display(a[number]);
		}

		if (number > 9 && number < 20) {
			display(c[number - 10]);
		}

		if (number > 19) {
			rm = number % 10;
			if (rm == 0) {
				q = number / 10;
				display(d[q - 2]);
			} else {
				q = number / 10;
				display(a[rm]);
				display(" ");
				display(d[q - 2]);
			}
		}
	}

	public void display(String s) {
		String t;
		t = string;
		string = s;
		string += t;
		
	}

	public static void main(String args[]) {

		NumWord num = new NumWord();
		System.out.println("num.convertNumToWord(0)" + num.convertNumToWord("10045875"));
		
	}

}
