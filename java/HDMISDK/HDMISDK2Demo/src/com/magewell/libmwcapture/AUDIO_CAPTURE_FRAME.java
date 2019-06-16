package com.magewell.libmwcapture;

public class AUDIO_CAPTURE_FRAME {
	public int cFrameCount;
	public int iFrame;
	public int dwSyncCode;
	public int dwReserved;
	public long llTimestamp;
	public int adwSamples[];
	
	public AUDIO_CAPTURE_FRAME(){
		}
}
