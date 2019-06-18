package other.basic.util;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.Window;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import windowbuilder.image.Img;

/**
 * <PRE>
 * ͼƬ��������
 * </PRE>
 *
 * ��Ŀ���ƣ�stbrecorder</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��7��
 * @author xiangning
 * @since JDK1.8
 */
@SuppressWarnings("all")
public class ImageUtils {
	
	/**
	 * ����ͼ��
	 */
	private static Map<String,ImageIcon> imageIconMap = new HashMap<String,ImageIcon>();
	

	private final static Class NOMAL_IMAGE_DIR_CLASS = Img.class;

	/**
	 * url��ȡ�ļ���ʱʱ��Ĭ��20��
	 */
	private final static int URL_READ_TIMEOUT = 20000;
	/**
	 * url���ӳ�ʱʱ��Ĭ��5��
	 */
	private final static int URL_CONNECTION_TIMEOUT = 5000;

	/**
	 * ͼƬȱʧʱĬ����ʾ
	 */
	private final static String notFoundFileName = "img_not_find.png";
	
	/**
	 * �������Ƶ�ͼƬ��С���óߴ罫������ͼƬ�������֣�������Ȼ���Ͻ���������Ŀǰ�ҵ���һ���취
	 */
	public static final int imageSize = 99;
	//�ٶ�aiʶ��ͼƬ����Ҫ����̱�����15px
	private final static int MIN = 15;
	//������4096px
	private final static int MAX = 4096;
	//��������ͼƬ�ĸ߶�
	private final static int WORD_HEIGHT = 60;
	//ͼƬ���ŵĹ̶��߶�
	private final static int IMG_HEIGHT = 200;
	
	private static BufferedImage notFoundImage;
	/**
	 * getImageFromeClass:(ָ���������õ���ǰ������·���µ�ͼƬ)
	 * 
	 * @author xiangning
	 *
	 * @param cla
	 *            ��ͼƬͬ��·���µ����������ӿڶ�����
	 * @param fileName
	 *            �ļ���
	 * @return
	 */
	public static Image getImage(String fileName, Class clazz) {
		try {
			BufferedImage image = ImageIO.read(clazz.getResource(fileName));
			return image;
		} catch (Exception e) {
			System.out.println("�ļ���ȡʧ�ܣ��ļ�����" + fileName + e);
		}
		try {
			// �����ǰ�ļ������ڣ�Ϊ�˲�����null���º����쳣�����������ѡ��Ĭ��ͼƬ
			return ImageIO.read(NOMAL_IMAGE_DIR_CLASS.getResource(notFoundFileName));
		} catch (Exception e) {
			// ���Ĭ��ͼƬҲ�����ڣ���ôֱ�ӻ���һ��ͼƬ
			return null;
		}
	}

	/**
	 * getImageFromNormalDir:(�õ�com.cattsoft.eomsteam.cmpt.web.stbrecorder.ui.img·���µ�ͼƬ)
	 * 
	 * @author xiangning
	 *
	 * @param fileName
	 * @return
	 */
	public static Image getImage(String fileName) {
		return ImageUtils.getImage(fileName, ImageUtils.NOMAL_IMAGE_DIR_CLASS);
	}

	/**
	 * getIconFromClassPath:(ָ���������õ���ǰ������·���µ�ͼ��)
	 * 
	 * @author xiangning
	 *
	 * @param cla
	 * @param fileName
	 * @return
	 */
	public static ImageIcon getIcon(String fileName, Class clazz) {
		String key = fileName + "_" + clazz.getName() + "_" +  "icon";
		ImageIcon imageIcon = imageIconMap.get(key);
		try {
			if(imageIcon == null) {
				imageIcon = new ImageIcon(clazz.getResource(fileName));
				imageIconMap.put(key, imageIcon);
			}
			return imageIcon;
		} catch (Exception e) {
			System.out.println("�ļ���ȡʧ�ܣ��ļ�����" + fileName + e);
		}
		try {
			// �����ǰ�ļ������ڣ�Ϊ�˲�����null���º����쳣�����������ѡ��Ĭ��ͼƬ
			return transImageToIcon(ImageIO.read(NOMAL_IMAGE_DIR_CLASS.getResource(notFoundFileName)));
		} catch (Exception e) {
			// ���Ĭ��ͼƬҲ�����ڣ���ôֱ�ӻ���һ��ͼƬ
			return transImageToIcon(null);
		}
	}

	/**
	 * getImageFromNormalDir:(�õ�com.cattsoft.eomsteam.cmpt.web.stbrecorder.ui.img·���µ�ͼ��)
	 * 
	 * @author xiangning
	 *
	 * @param fileName
	 * @return
	 */
	public static ImageIcon getIcon(String fileName) {
		return ImageUtils.getIcon(fileName, ImageUtils.NOMAL_IMAGE_DIR_CLASS);
	}

	/**
	 * getImageByURL:(����url��ȡͼƬ����)
	 * 
	 * @author xiangning
	 *
	 * @param url
	 * @return
	 */
	public static Image getImageByURL(String url) {
		InputStream inputStream = null;
		try {
			inputStream = ImageUtils.getImageStream(url);
			BufferedImage image = ImageIO.read(inputStream);
			return image;
		} catch (Exception e) {
			System.out.println("URL�ļ���ȡʧ��=" + url);
			try {
				// �����ǰ�ļ������ڣ�Ϊ�˲�����null���º����쳣�����������ѡ��Ĭ��ͼƬ
				return ImageIO.read(NOMAL_IMAGE_DIR_CLASS.getResource(notFoundFileName));
			} catch (Exception e1) {
				// ���Ĭ��ͼƬҲ�����ڣ���ôֱ�ӻ���һ��ͼƬ
				return drawAImageNotFound();
			}
		} finally {
			GlobalUtils.closeStream(inputStream);
		}
	}

	private static Image drawAImageNotFound() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * getImageByURL:(����url��ȡͼ�����)
	 * 
	 * @author xiangning
	 *
	 * @param url
	 * @return
	 */
	public static ImageIcon getIconByURL(String url) {
		InputStream inputStream = null;
		try {
			inputStream = ImageUtils.getImageStream(url);
			Image image = ImageIO.read(inputStream);
			return transImageToIcon(image);
		} catch (Exception e) {
			System.out.println("URL�ļ���ȡʧ��=" + url);
			try {
				// �����ǰ�ļ������ڣ�Ϊ�˲�����null���º����쳣�����������ѡ��Ĭ��ͼƬ
				return getImageIcon(NOMAL_IMAGE_DIR_CLASS.getResource(notFoundFileName).getPath());
//				return transImageToIcon(ImageIO.read(NOMAL_IMAGE_DIR_CLASS.getResource(notFoundFileName)));
			} catch (Exception e1) {
				// ���Ĭ��ͼƬҲ�����ڣ���ôֱ�ӻ���һ��ͼƬ
				return transImageToIcon(null);
			}
		} finally {
			GlobalUtils.closeStream(inputStream);
		}
	}

	/**
	 * getImageStream:(��ȡurlͼƬ��)
	 * 
	 * @author xiangning
	 *
	 * @param url
	 *            ����ͼƬ��ַ������ ��http/https��ͷ
	 * @return
	 */
	public static InputStream getImageStream(String url) {
		InputStream inputStream = null;
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setReadTimeout(ImageUtils.URL_READ_TIMEOUT);
			connection.setConnectTimeout(ImageUtils.URL_CONNECTION_TIMEOUT);
			connection.setRequestMethod("GET");
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				inputStream = connection.getInputStream();
				return inputStream;
			}
		} catch (IOException e) {
			System.out.println("��ȡ����ͼƬ�����쳣��ͼƬ·��Ϊ��" + url);
		}
		return null;
	}

	/**
	 * writeImageToLocalDir:(д��ͼƬ���ļ�)
	 * 
	 * @author xiangning
	 *
	 * @param image
	 *            ͼƬ����
	 * @param filePath
	 *            �ļ����������ļ�·�����ļ����������ͬ���ļ�����ᱻ����
	 * @throws Exception
	 */
	public static void writeImageToLocalDir(Image image, String filePath) {
		
	}
	
	public static void writeImageToLocalDir(ImageIcon icon, String filePath) {
		writeImageToLocalDir((BufferedImage)icon.getImage(), filePath);
	}

	/**
	 * ͼƬ����Բ��
	 * 
	 * @param srcImage
	 * @param radius
	 * @param border
	 * @param padding
	 * @return
	 * @throws IOException
	 */
	public static Image setRadius(Image image1, int radius, int border, int padding)
			throws IOException {
		BufferedImage srcImage = (BufferedImage)image1;
		int width = srcImage.getWidth();
		int height = srcImage.getHeight();
		int canvasWidth = width + padding * 2;
		int canvasHeight = height + padding * 2;

		BufferedImage image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gs = image.createGraphics();
		gs.setComposite(AlphaComposite.Src);
		gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gs.setColor(Color.WHITE);
		gs.fill(new RoundRectangle2D.Float(0, 0, canvasWidth, canvasHeight, radius, radius));
		gs.setComposite(AlphaComposite.SrcAtop);
		gs.drawImage(setClip(srcImage, radius), padding, padding, null);
		if (border != 0) {
			gs.setColor(Color.GRAY);
			gs.setStroke(new BasicStroke(border));
			gs.drawRoundRect(padding, padding, canvasWidth - 2 * padding, canvasHeight - 2 * padding, radius, radius);
		}
		gs.dispose();
		return image;
	}

	/**
	 * ͼƬ����Բ��
	 * 
	 * @param srcImage
	 * @return
	 * @throws IOException
	 */
	public static Image setRadius(Image image1) throws IOException {
		BufferedImage srcImage = (BufferedImage)image1;
		int radius = (srcImage.getWidth() + srcImage.getHeight()) / 6;
		return setRadius(srcImage, radius, 2, 5);
	}

	/**
	 * ͼƬ��Բ��
	 * 
	 * @param srcImage
	 * @param radius
	 * @return
	 */
	public static Image setClip(BufferedImage srcImage, int radius) {
		int width = srcImage.getWidth();
		int height = srcImage.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gs = image.createGraphics();

		gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gs.setClip(new RoundRectangle2D.Double(0, 0, width, height, radius, radius));
		gs.drawImage(srcImage, 0, 0, null);
		gs.dispose();
		return image;
	}

	/**
	 * ����͸��ͼ��
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static Image drawTransparent(BufferedImage image, int width, int height) throws IOException {
		// ����BufferedImage����
		if (image == null) {
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		}
		// ��ȡGraphics2D
		Graphics2D g2d = image.createGraphics();

		// �����������ʹ�ñ���͸��
		image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
		// �ͷŶ���
		g2d.dispose();
		return image;

	}


	
	private static ImageIcon transImageToIcon(Image image) {
		if (image == null) {
			return null;
		}
		return new ImageIcon(image);
	}

	/**
	 * resizeBufferedImage:()
	 * 
	 * @author xiangning 
	 * ����bufferedimage��С
	 * @param source
	 *            BufferedImage ԭʼimage
	 * @param targetW
	 *            int Ŀ���
	 * @param targetH
	 *            int Ŀ���
	 * @param flag
	 *            boolean �Ƿ�ͬ��������
	 * @return BufferedImage ������image
	 */
	public static Image resizeBufferedImage(BufferedImage source, int targetW, int targetH, boolean flag) {
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		if (flag && sx > sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else if (flag && sx <= sy) {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}
		if (type == BufferedImage.TYPE_CUSTOM) { // handmade
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else {
			target = new BufferedImage(targetW, targetH, type);
		}
		Graphics2D g = target.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}
	
	
	/**
	 * resizeBufferedImage:(�ȱ�����ͼƬ)
	 * @author xiangning
	 *
	 * @param source
	 * @param proportion
	 * @return
	 */
	public static Image resizeBufferedImage(Image image, double proportion) {
		BufferedImage source = (BufferedImage)image;
		if(proportion<=0) {
			proportion = 1;
		}
		int width = (int)(source.getWidth() * proportion);
		int height = (int)(source.getHeight() * proportion);
		return resizeBufferedImage(source, width, height, true);
		
	}
	
	
	
	
	/**
	 * resizeImageIcon:(�õ�ָ����С��ICON)
	 * @author xiangning
	 *
	 * @param icon
	 * @param width
	 * @param height
	 */
	public static ImageIcon resizeImageIcon(ImageIcon icon,int width,int height) {
		if(width == 0 ) {
			width = icon.getIconWidth();
		}
		if(height == 0 ) {
			height = icon.getIconHeight();
		}
		icon.setImage(icon.getImage().getScaledInstance(
				width,
				height, 
				Image.SCALE_FAST));
		return icon;
	}
	
	/**
	 * resizeImageIcon:(�ȱ�����icon)
	 * @author xiangning
	 *
	 * @param icon
	 * @param Percentage
	 */
	public static ImageIcon resizeImageIcon(ImageIcon icon,double proportion) {
		if(proportion<=0) {
			proportion = 1;
		}
		icon.setImage(icon.getImage().getScaledInstance(
				(int)(icon.getIconWidth() * proportion),
				(int)(icon.getIconHeight() * proportion), 
				Image.SCALE_FAST));
		return icon;
	}
	
	/**
	 * cut:(�ü�ͼƬ)
	 * @author zhongjie
	 *
	 * @param filePath ͼƬ·��
	 * @param x ��ʼ���X����
	 * @param y ��ʼ���Y����
	 * @param width ��ȡ�Ŀ��
	 * @param height ��ȡ�ĸ߶�
	 * @return
	 */
	public static Image cut(String filePath, double x, double y, double width, double height) {
		BufferedImage bufferedImage = null;
		try {
			//��ȡͼƬ
			bufferedImage = ImageIO.read(new File(filePath));
			bufferedImage = cut(bufferedImage, x, y, width, height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�ü�ͼƬʧ��");
		}
		return bufferedImage;
	} 
	
	/**
	 * cut:(�ü�ͼƬ)
	 * @author zhongjie
	 *
	 * @param filePath ͼƬ·��
	 * @param x ��ʼ���X����
	 * @param y ��ʼ���Y����
	 * @param width ��ȡ�Ŀ��
	 * @param height ��ȡ�ĸ߶�
	 * @return
	 */
	public static BufferedImage cut(Image image, double x, double y, double width, double height) {
		BufferedImage bufferedImage = null;
		try {
			//��ȡͼƬ
			bufferedImage = (BufferedImage) image;
			//��ȡͼƬ�Ŀ�ȣ��߶�
			int w = bufferedImage.getWidth();
			int h = bufferedImage.getHeight();
			int cutWidth = (int) (w * width);
			int cutHeight = (int) (h * height);
			//����ʼ������ٷֱ�ת����int
			int xCoordinates = (int) (w * x);
			int yCoordinates = (int) (h * y);
			//�����ȡ�Ŀ��+��ʼ���x����ͼƬ��ԭ�����ȡ��ʼ�㵽��ȱ߽�����ֵ
			if(cutWidth + xCoordinates > w) {
				cutWidth = w - xCoordinates;
			}
			//ͬ��
			if(cutHeight + yCoordinates > h) {
				cutHeight = h - yCoordinates;
			}
			//�ٶ�aiʶ��ͼƬ����Ҫ����̱�����15px��������4096px
			width = getboundaryValue(cutWidth);
			height = getboundaryValue(cutHeight);
			//��ȡͼƬ
			bufferedImage = bufferedImage.getSubimage(xCoordinates, yCoordinates, cutWidth, cutHeight);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("�ü�ͼƬʧ��");
		}
		return bufferedImage;
	} 
	
	/**
	 * getboundaryValue:(���ڰٶ�aiʶ��ͼƬ����Ҫ����̱�����15px��������4096px��ȡ�߽�ֵ)
	 * @author zhongjie
	 *
	 * @param value
	 * @return
	 */
	public static int getboundaryValue(int value) {
		if(value <= MIN) {
			value = MIN;
		}
		if(value >= MAX) {
			value = MAX;
		}
		return value;
	}
	
	
	/**
	 * imageSynthesis:(�ϳ�ͼƬ)ps:ͼƬͳһ���Ÿ߶�Ϊ200
	 * @author zhongjie
	 *
	 * @param filePathOne ��һ��ͼƬλ��
	 * @param filePathTwo �ڶ���ͼƬλ��
	 * @param leftStrings ��һ��ͼƬ������������
	 * @param rightStrings �ڶ���ͼƬ������������
	 * @return
	 */
	public static Image imageSynthesis(String filePathOne, String filePathTwo, String[] leftStrings, String[] rightStrings) {
		BufferedImage bufferedImageOne, bufferedImageTwo, imageNew = null;
		
		try {
			bufferedImageOne = ImageIO.read(new File(filePathOne));
			bufferedImageTwo = ImageIO.read(new File(filePathTwo));
	        int height = bufferedImageOne.getHeight();// ͼƬ�߶�
	        int height2 = bufferedImageTwo.getHeight();// ͼƬ�߶�
	        double h1 = (double)IMG_HEIGHT/height; 
	        bufferedImageOne = (BufferedImage)resizeBufferedImage(bufferedImageOne, h1);
	        height = bufferedImageOne.getHeight();
	        double h2 = (double)IMG_HEIGHT/height2;
	        bufferedImageTwo = (BufferedImage)resizeBufferedImage(bufferedImageTwo, h2);
	        height2 = bufferedImageTwo.getHeight();
	        //��ȡ���ź�ͼƬ�Ŀ��
	        int width = bufferedImageOne.getWidth();// ͼƬ���
	        int width2 = bufferedImageTwo.getWidth();// ͼƬ���
	        // ��ͼƬ�ж�ȡRGB
	         int[] ImageArrayOne = new int[width * height];
	         ImageArrayOne = bufferedImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);
	        // �Եڶ���ͼƬ����ͬ�Ĵ���
	        int[] ImageArrayTwo = new int[width2 * height2];
	        ImageArrayTwo = bufferedImageTwo.getRGB(0, 0, width2, height2, ImageArrayTwo, 0, width2);
	        //��ȡ���õĿհ�ͼƬ��RGB
	        BufferedImage blankImage = getNewImage(null, IMG_HEIGHT, Math.max(height, height2) + WORD_HEIGHT);
			int[] imageArray = new int[blankImage.getWidth() * blankImage.getHeight()];
			imageArray = blankImage.getRGB(0, 0, blankImage.getWidth(), blankImage.getHeight(), imageArray, 0, blankImage.getWidth());
			//��ȡ���½�ͼƬ�е�RGB
			BufferedImage leftLowerImage = getNewImage(leftStrings, width, WORD_HEIGHT);
			int[] leftLowerImageArray = new int[leftLowerImage.getWidth() * leftLowerImage.getHeight()];
			leftLowerImageArray = leftLowerImage.getRGB(0, 0, leftLowerImage.getWidth(),
					leftLowerImage.getHeight(), leftLowerImageArray, 0, leftLowerImage.getWidth());
			//��ȡ���½�ͼƬ�е�RGB
			BufferedImage rightLowerImage = getNewImage(rightStrings, width2, WORD_HEIGHT);
			int[] rightLowerImageArray = new int[rightLowerImage.getWidth() * rightLowerImage.getHeight()];
			rightLowerImageArray = rightLowerImage.getRGB(0, 0, rightLowerImage.getWidth(),
					rightLowerImage.getHeight(), rightLowerImageArray, 0, rightLowerImage.getWidth());
	        //�ϳ�ͼƬ
	        imageNew = new BufferedImage(width + width2 + IMG_HEIGHT, Math.max(height, height2) + WORD_HEIGHT, BufferedImage.TYPE_INT_RGB);
	        // �������ϰ벿�ֵ�RGB
	        imageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);
	        // �������°벿�ֵ�RGB
	        imageNew.setRGB(0, height, width, WORD_HEIGHT, leftLowerImageArray, 0, width);
	        // �����м�հײ��ֵ�RGB
	        imageNew.setRGB(width, 0, blankImage.getWidth(), blankImage.getHeight(), imageArray, 0, blankImage.getWidth());
	        // �������ϰ벿�ֵ�RGB
            imageNew.setRGB(width + IMG_HEIGHT, 0, width2, height2, ImageArrayTwo, 0, width2);
            // �������°벿�ֵ�RGB
            imageNew.setRGB(width + IMG_HEIGHT, height2, rightLowerImage.getWidth(), WORD_HEIGHT, rightLowerImageArray, 0, width2);
            return imageNew;		
        }catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return imageNew;
    }
	/**
	 * getNewImage:(��ͼ)
	 * @author zhongjie
	 *
	 * @param strings Ҫ��ʾ������������Դ�null(�հ�ͼƬ)
	 * @param width ͼƬ���
	 * @param height ͼƬ�߶�
	 * @return
	 */
	public static BufferedImage getNewImage(String[] strings,int width, int height) {
		// �����м�հ�ͼƬ
        BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(240,240,240));
		g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
		g2d.setColor(new Color(35,122,228));
		Font font = new Font("microsoft yahei", Font.PLAIN, 24);
		g2d.setFont(font);
		if(strings == null || strings.length == 0) {
			g2d.drawString("", 0, 0);
		}else {
			for (int i = 0; i < strings.length; i++) {
				g2d.drawString(strings[i], (width - 24 * (strings[i].length())) / 2, i * 24 +24);
			}
		}
		g2d.dispose();// �ͷ���Դ
		return image;
	}
	
	/**
	 * getImageIcon:(��ȡ�ǻ����ͼƬ����)
	 * @author xiangning
	 *
	 * @param path
	 * @return
	 */
	public static ImageIcon getImageIcon(String path) {
		return  new ImageIcon(Toolkit.getDefaultToolkit().getImage(path));
	}
	
	
	
}
