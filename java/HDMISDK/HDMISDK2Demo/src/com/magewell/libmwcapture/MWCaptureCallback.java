package com.magewell.libmwcapture;

public interface MWCaptureCallback {
	public void OnVideoCapture(byte[] pbFrame, int cbFrame, long u64TimeStamp);
	public void OnAudioCapture(byte[] pbFrame, int cbFrame, long u64TimeStamp);
}
