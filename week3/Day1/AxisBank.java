package week3.Day1;

public class AxisBank extends BankInfo {
	// Print the deposit amount
	public void deposit() {
		System.out.println("Deposit amount : 125000");
	}

	public static void main(String[] args) {
		AxisBank obj = new AxisBank();
		obj.fixed();
		obj.saving();
		obj.deposit();
		BankInfo info = new BankInfo();
		info.deposit();
	}

}
