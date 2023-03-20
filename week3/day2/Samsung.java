package week3.day2;

public class Samsung extends AndroidTV {
	@Override
	public void playVideo() {
		System.out.println("Play the video");
	}
	@Override
	public void connectToNet() {
		System.out.println("Connect to the network");
		
	}
	public static void main(String[] args) {
		Samsung obj = new Samsung();
		obj.openApp();
		obj.playVideo();
		obj.usb();
		obj.connectToNet();
	}

	
}
