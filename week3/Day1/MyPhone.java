package week3.Day1;

public class MyPhone  extends Iphone{
	public void sendSms() {
		System.out.println("Send a voice message");
	}
	public static void main(String[] args) {
		MyPhone phone = new MyPhone();
		phone.startApp();
		phone.increaseVolume();
		phone.shutDown();
		phone.makeCall();
		phone.sendSms();
		Iphone iphone = new Iphone();
		iphone.sendSms();
	}

}
