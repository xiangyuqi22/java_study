package com.magewell.libmwcapture;

public class VIDEO_CAPTURE_STATUS {
	public long pvContent;
	public boolean bPhysicalAddress;
	public int iFrame;
	public boolean bFrameCompleted;
	public int cyCompleted;
	public int cyCompletedPrev;
	
	public VIDEO_CAPTURE_STATUS(long pvContent, boolean bPhysicalAddress, int iFrame, boolean bFrameCompleted,
			int cyCompleted, int cyCompletedPrev) {
		this.pvContent = pvContent;
		this.bPhysicalAddress = bPhysicalAddress;
		this.iFrame = iFrame;
		this.bFrameCompleted = bFrameCompleted;
		this.cyCompleted = cyCompleted;
		this.cyCompletedPrev = cyCompletedPrev;
	}
}
