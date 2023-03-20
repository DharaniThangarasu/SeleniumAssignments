package week3.day2;

public abstract class AndroidTV implements Android {
	@Override
	public void openApp() {
		System.out.println("Open the application");
	}
	public abstract void connectToNet();
	public void usb()
	{
		System.out.println("Connect to USB");
	}
}
