package org.system;

public class Desktop extends Computer {
	/*
	 * Prints the size of the desktop
	 */
	public void desktopSize() {
		System.out.println("Desktop size : 15.6-inch HD Ultraslim Anti-Glare non-touch screen");
	}

	public static void main(String[] args) {
		Desktop desk = new Desktop();
		desk.computerModel();
		desk.desktopSize();
	}

}
