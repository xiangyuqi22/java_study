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
 * 图片处理工具类
 * </PRE>
 *
 * 项目名称：stbrecorder</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月7日
 * @author xiangning
 * @since JDK1.8
 */
@SuppressWarnings("all")
public class ImageUtils {
	
	/**
	 * 缓存图标
	 */
	private static Map<String,ImageIcon> imageIconMap = new HashMap<String,ImageIcon>();
	

	private final static Class NOMAL_IMAGE_DIR_CLASS = Img.class;

	/**
	 * url读取文件超时时间默认20秒
	 */
	private final static int URL_READ_TIMEOUT = 20000;
	/**
	 * url连接超时时间默认5秒
	 */
	private final static int URL_CONNECTION_TIMEOUT = 5000;

	/**
	 * 图片缺失时默认显示
	 */
	private final static String notFoundFileName = "img_not_find.png";
	
	/**
	 * 主动绘制的图片大小，用尺寸将它与别的图片进行区分，这样虽然不严谨，但是是目前找到的一个办法
	 */
	public static final int imageSize = 99;
	//百度ai识别图片参数要求最短边至少15px
	private final static int MIN = 15;
	//最长边最大4096px
	private final static int MAX = 4096;
	//文字描述图片的高度
	private final static int WORD_HEIGHT = 60;
	//图片缩放的固定高度
	private final static int IMG_HEIGHT = 200;
	
	private static BufferedImage notFoundImage;
	/**
	 * getImageFromeClass:(指定类名，得到当前类所在路径下的图片)
	 * 
	 * @author xiangning
	 *
	 * @param cla
	 *            跟图片同包路径下的类任意类或接口都可以
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static Image getImage(String fileName, Class clazz) {
		try {
			BufferedImage image = ImageIO.read(clazz.getResource(fileName));
			return image;
		} catch (Exception e) {
			System.out.println("文件读取失败，文件名：" + fileName + e);
		}
		try {
			// 如果当前文件不存在，为了不返回null导致后面异常出错，在这里就选择默认图片
			return ImageIO.read(NOMAL_IMAGE_DIR_CLASS.getResource(notFoundFileName));
		} catch (Exception e) {
			// 如果默认图片也不存在，那么直接绘制一张图片
			return null;
		}
	}

	/**
	 * getImageFromNormalDir:(得到com.cattsoft.eomsteam.cmpt.web.stbrecorder.ui.img路径下的图片)
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
	 * getIconFromClassPath:(指定类名，得到当前类所在路径下的图标)
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
			System.out.println("文件读取失败，文件名：" + fileName + e);
		}
		try {
			// 如果当前文件不存在，为了不返回null导致后面异常出错，在这里就选择默认图片
			return transImageToIcon(ImageIO.read(NOMAL_IMAGE_DIR_CLASS.getResource(notFoundFileName)));
		} catch (Exception e) {
			// 如果默认图片也不存在，那么直接绘制一张图片
			return transImageToIcon(null);
		}
	}

	/**
	 * getImageFromNormalDir:(得到com.cattsoft.eomsteam.cmpt.web.stbrecorder.ui.img路径下的图标)
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
	 * getImageByURL:(根据url获取图片对象)
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
			System.out.println("URL文件读取失败=" + url);
			try {
				// 如果当前文件不存在，为了不返回null导致后面异常出错，在这里就选择默认图片
				return ImageIO.read(NOMAL_IMAGE_DIR_CLASS.getResource(notFoundFileName));
			} catch (Exception e1) {
				// 如果默认图片也不存在，那么直接绘制一张图片
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
	 * getImageByURL:(根据url获取图标对象)
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
			System.out.println("URL文件读取失败=" + url);
			try {
				// 如果当前文件不存在，为了不返回null导致后面异常出错，在这里就选择默认图片
				return getImageIcon(NOMAL_IMAGE_DIR_CLASS.getResource(notFoundFileName).getPath());
//				return transImageToIcon(ImageIO.read(NOMAL_IMAGE_DIR_CLASS.getResource(notFoundFileName)));
			} catch (Exception e1) {
				// 如果默认图片也不存在，那么直接绘制一张图片
				return transImageToIcon(null);
			}
		} finally {
			GlobalUtils.closeStream(inputStream);
		}
	}

	/**
	 * getImageStream:(获取url图片流)
	 * 
	 * @author xiangning
	 *
	 * @param url
	 *            网络图片地址，必须 以http/https开头
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
			System.out.println("获取网络图片出现异常，图片路径为：" + url);
		}
		return null;
	}

	/**
	 * writeImageToLocalDir:(写入图片到文件)
	 * 
	 * @author xiangning
	 *
	 * @param image
	 *            图片对象
	 * @param filePath
	 *            文件名，包含文件路径和文件名。如果有同名文件，则会被覆盖
	 * @throws Exception
	 */
	public static void writeImageToLocalDir(Image image, String filePath) {
		
	}
	
	public static void writeImageToLocalDir(ImageIcon icon, String filePath) {
		writeImageToLocalDir((BufferedImage)icon.getImage(), filePath);
	}

	/**
	 * 图片设置圆角
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
	 * 图片设置圆角
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
	 * 图片切圆角
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
	 * 绘制透明图形
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static Image drawTransparent(BufferedImage image, int width, int height) throws IOException {
		// 创建BufferedImage对象
		if (image == null) {
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		}
		// 获取Graphics2D
		Graphics2D g2d = image.createGraphics();

		// 增加下面代码使得背景透明
		image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
		// 释放对象
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
	 * 调整bufferedimage大小
	 * @param source
	 *            BufferedImage 原始image
	 * @param targetW
	 *            int 目标宽
	 * @param targetH
	 *            int 目标高
	 * @param flag
	 *            boolean 是否同比例调整
	 * @return BufferedImage 返回新image
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
	 * resizeBufferedImage:(等比缩放图片)
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
	 * resizeImageIcon:(得到指定大小的ICON)
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
	 * resizeImageIcon:(等比缩放icon)
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
	 * cut:(裁剪图片)
	 * @author zhongjie
	 *
	 * @param filePath 图片路径
	 * @param x 起始点的X坐标
	 * @param y 起始点的Y坐标
	 * @param width 截取的宽度
	 * @param height 截取的高度
	 * @return
	 */
	public static Image cut(String filePath, double x, double y, double width, double height) {
		BufferedImage bufferedImage = null;
		try {
			//读取图片
			bufferedImage = ImageIO.read(new File(filePath));
			bufferedImage = cut(bufferedImage, x, y, width, height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("裁剪图片失败");
		}
		return bufferedImage;
	} 
	
	/**
	 * cut:(裁剪图片)
	 * @author zhongjie
	 *
	 * @param filePath 图片路径
	 * @param x 起始点的X坐标
	 * @param y 起始点的Y坐标
	 * @param width 截取的宽度
	 * @param height 截取的高度
	 * @return
	 */
	public static BufferedImage cut(Image image, double x, double y, double width, double height) {
		BufferedImage bufferedImage = null;
		try {
			//读取图片
			bufferedImage = (BufferedImage) image;
			//获取图片的宽度，高度
			int w = bufferedImage.getWidth();
			int h = bufferedImage.getHeight();
			int cutWidth = (int) (w * width);
			int cutHeight = (int) (h * height);
			//将起始点坐标百分比转化成int
			int xCoordinates = (int) (w * x);
			int yCoordinates = (int) (h * y);
			//如果截取的宽度+起始点的x超过图片的原宽度则取起始点到宽度边界的最大值
			if(cutWidth + xCoordinates > w) {
				cutWidth = w - xCoordinates;
			}
			//同理
			if(cutHeight + yCoordinates > h) {
				cutHeight = h - yCoordinates;
			}
			//百度ai识别图片参数要求最短边至少15px，最长边最大4096px
			width = getboundaryValue(cutWidth);
			height = getboundaryValue(cutHeight);
			//截取图片
			bufferedImage = bufferedImage.getSubimage(xCoordinates, yCoordinates, cutWidth, cutHeight);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("裁剪图片失败");
		}
		return bufferedImage;
	} 
	
	/**
	 * getboundaryValue:(不在百度ai识别图片参数要求最短边至少15px，最长边最大4096px，取边界值)
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
	 * imageSynthesis:(合成图片)ps:图片统一缩放高度为200
	 * @author zhongjie
	 *
	 * @param filePathOne 第一张图片位置
	 * @param filePathTwo 第二张图片位置
	 * @param leftStrings 第一张图片文字描述数组
	 * @param rightStrings 第二张图片文字描述数组
	 * @return
	 */
	public static Image imageSynthesis(String filePathOne, String filePathTwo, String[] leftStrings, String[] rightStrings) {
		BufferedImage bufferedImageOne, bufferedImageTwo, imageNew = null;
		
		try {
			bufferedImageOne = ImageIO.read(new File(filePathOne));
			bufferedImageTwo = ImageIO.read(new File(filePathTwo));
	        int height = bufferedImageOne.getHeight();// 图片高度
	        int height2 = bufferedImageTwo.getHeight();// 图片高度
	        double h1 = (double)IMG_HEIGHT/height; 
	        bufferedImageOne = (BufferedImage)resizeBufferedImage(bufferedImageOne, h1);
	        height = bufferedImageOne.getHeight();
	        double h2 = (double)IMG_HEIGHT/height2;
	        bufferedImageTwo = (BufferedImage)resizeBufferedImage(bufferedImageTwo, h2);
	        height2 = bufferedImageTwo.getHeight();
	        //获取缩放后图片的宽度
	        int width = bufferedImageOne.getWidth();// 图片宽度
	        int width2 = bufferedImageTwo.getWidth();// 图片宽度
	        // 从图片中读取RGB
	         int[] ImageArrayOne = new int[width * height];
	         ImageArrayOne = bufferedImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);
	        // 对第二张图片做相同的处理
	        int[] ImageArrayTwo = new int[width2 * height2];
	        ImageArrayTwo = bufferedImageTwo.getRGB(0, 0, width2, height2, ImageArrayTwo, 0, width2);
	        //读取画好的空白图片中RGB
	        BufferedImage blankImage = getNewImage(null, IMG_HEIGHT, Math.max(height, height2) + WORD_HEIGHT);
			int[] imageArray = new int[blankImage.getWidth() * blankImage.getHeight()];
			imageArray = blankImage.getRGB(0, 0, blankImage.getWidth(), blankImage.getHeight(), imageArray, 0, blankImage.getWidth());
			//读取左下角图片中的RGB
			BufferedImage leftLowerImage = getNewImage(leftStrings, width, WORD_HEIGHT);
			int[] leftLowerImageArray = new int[leftLowerImage.getWidth() * leftLowerImage.getHeight()];
			leftLowerImageArray = leftLowerImage.getRGB(0, 0, leftLowerImage.getWidth(),
					leftLowerImage.getHeight(), leftLowerImageArray, 0, leftLowerImage.getWidth());
			//读取右下角图片中的RGB
			BufferedImage rightLowerImage = getNewImage(rightStrings, width2, WORD_HEIGHT);
			int[] rightLowerImageArray = new int[rightLowerImage.getWidth() * rightLowerImage.getHeight()];
			rightLowerImageArray = rightLowerImage.getRGB(0, 0, rightLowerImage.getWidth(),
					rightLowerImage.getHeight(), rightLowerImageArray, 0, rightLowerImage.getWidth());
	        //合成图片
	        imageNew = new BufferedImage(width + width2 + IMG_HEIGHT, Math.max(height, height2) + WORD_HEIGHT, BufferedImage.TYPE_INT_RGB);
	        // 设置左上半部分的RGB
	        imageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);
	        // 设置左下半部分的RGB
	        imageNew.setRGB(0, height, width, WORD_HEIGHT, leftLowerImageArray, 0, width);
	        // 设置中间空白部分的RGB
	        imageNew.setRGB(width, 0, blankImage.getWidth(), blankImage.getHeight(), imageArray, 0, blankImage.getWidth());
	        // 设置右上半部分的RGB
            imageNew.setRGB(width + IMG_HEIGHT, 0, width2, height2, ImageArrayTwo, 0, width2);
            // 设置右下半部分的RGB
            imageNew.setRGB(width + IMG_HEIGHT, height2, rightLowerImage.getWidth(), WORD_HEIGHT, rightLowerImageArray, 0, width2);
            return imageNew;		
        }catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return imageNew;
    }
	/**
	 * getNewImage:(画图)
	 * @author zhongjie
	 *
	 * @param strings 要显示的文字数组可以传null(空白图片)
	 * @param width 图片宽度
	 * @param height 图片高度
	 * @return
	 */
	public static BufferedImage getNewImage(String[] strings,int width, int height) {
		// 生成中间空白图片
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
		g2d.dispose();// 释放资源
		return image;
	}
	
	/**
	 * getImageIcon:(获取非缓冲的图片对象)
	 * @author xiangning
	 *
	 * @param path
	 * @return
	 */
	public static ImageIcon getImageIcon(String path) {
		return  new ImageIcon(Toolkit.getDefaultToolkit().getImage(path));
	}
	
	
	
}
