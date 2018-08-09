package com.pagoda.buffer;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class BufferMovingCircle extends NoBufferMovingCircle {
	Graphics doubleBuffer=null;
	
	public void init(){
		super.init();
		doubleBuffer=scream.getGraphics();
	}
	
	public void paint(Graphics g){
		doubleBuffer.setColor(Color.white);
		doubleBuffer.fillRect(0, 0, 200, 100);
		dreawCircle(doubleBuffer);
		g.drawImage(scream, 0,0,this);
		
	}

	
	
}
