package com.magewell.libmwcapture;

import java.nio.ByteBuffer;
import javax.swing.JApplet;

public class LibMWCapture {
	static {
		System.loadLibrary("LibMWCaptureJni");
	}
	
	public static native boolean InitNative();
	public static native void ExitNative();
	public static native long GetJavaWnd(JApplet applet);
	
	public static native boolean MWCaptureInitInstance();
	public static native void MWCaptureExitInstance();
	
	public static native long MWGetFourcc(String strColorFormat);
	public static native int MWGetChannelCount();
	
	public static native long MWOpenChannelByIndex(int nChannelIndex);
	public static native void MWCloseChannel(long hChannel);
	
	public static native boolean MWStartVideoCapture(long hChannel, long hEvent);
	public static native boolean MWStopVideoCapture(long hChannel);
	
	public static native boolean MWStartAudioCapture(long hChannel);
	public static native boolean MWStopAudioCapture(long hChannel);
	
	
	public static native long MWCreateVideoCapture(long hChannel, int nWidth, int nHeight, int nFourcc, int nFrameDuration, MWCaptureCallback callback);
	public static native boolean MWDestoryVideoCapture(long hVideo);
	
	public static native long MWCreateAudioCapture(long hChannel, int captureNode, int dwSamplesPerSec, int wBitsPerSample, int wChannels, MWCaptureCallback callback);
	public static native boolean MWDestoryAudioCapture(long hAudio);
	
	//public static native VIDEO_SIGNAL_STATUS MWGetVideoSignalStatus(long hChannel);
	//public static native VIDEO_BUFFER_INFO MWGetVideoBufferInfo(long hChannel);
	//public static native VIDEO_FRAME_INFO MWGetVideoFrameInfo(long hChannel, int nIndex);
	public static native VIDEO_CAPTURE_STATUS MWGetVideoCaptureStatus(long hChannel);
	
	public static native boolean MWCaptureVideoFrameToVirtualAddress(long hChannel, int nFrame, ByteBuffer pbBuffer, long cbFrame, long cbStride, 
			boolean bBottomUp, long dwFourcc, int nWidth, int nHeight);
			
	public static native boolean MWCaptureAudioFrame(long hChannel, AUDIO_CAPTURE_FRAME audioFrame);
	
	public static native long MWGetDeviceTime(long hChannel);
	public static native boolean MWScheduleTimer(long hChannel, long hTimer, long llExpireTime);
	public static native long MWRegisterTimer(long hChannel, long hEvent);
	public static native boolean MWUnregisterTimer(long hChannel, long hEvent);
	public static native long MWRegisterNotify(long hChannel, long hEvent, long llEnableBits);
	public static native boolean MWUnregisterNotify(long hChannel, long hEvent);
	
	//JNI ---- MWFOURCC API
	public static native long FOURCC_CalcImageSize(long dwFourcc, int nWidth, int nHeight, long cbStride);
	public static native long FOURCC_CalcMinStride(long dwFourcc, int nWidth, long dwAlign);
	
	//JNI ---- Windows API
	public static native long CreateEvent();
	public static native boolean SetEvent(long hEvent);
	public static native boolean CloseHandle(long hEvent);
	public static native long WaitForMultipleObjects(int nEventIndex, long[] hEventArr, boolean bWaitAll, long dwMilliseconds);
	public static native long WaitForSingleObject(long hEvent, long dwMilliseconds);
	
	//JNI ---- D3D Renderer API
	public static native long MWCreateD3DRenderer(int nWidth, int nHeight, long dwFourcc, long hWnd);
	public static native void MWDestroyD3DRenderer(long hVideoRenderer);
	public static native boolean MWD3DRendererPushFrame(long hVideoRenderer, ByteBuffer videoBuffer, int cbStride);
	
	//JNI ---- DSound Renderer API
	public static native long MWCreateDSoundRenderer(int nSamplesPerSec, int nChannels, int nSamplesPerFrame, int nBufferFrameCount);
	public static native void MWDestroyDSoundRenderer(long hAudioRenderer);
	public static native boolean MWDSoundRendererPushFrame(long hAudioRenderer, int[] samples);
	public static native boolean MWDSoundRendererPushFrame2(long hAudioRenderer, byte[] samples);
}
