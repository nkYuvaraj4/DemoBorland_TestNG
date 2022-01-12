package com.qa.Utilities;
import java.awt.*;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class nonWebUtil {
	
	public static void copyPaste(String str) throws AWTException {
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_C);
	}
	
	public static void setStringToClipBoard(String str1) {
		StringSelection ss = new StringSelection(str1);
	}
}