package com.designpattern.adapterpattern;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月25日
 * @author xiangning
 * @since JDK1.8
 */
public class Adapter extends MediaAdapter{

	@Override
	public void play(String fileName) {
		try {
			super.play(fileName);
		} catch (NullMediaException e) {
			if(fileName.toUpperCase().endsWith(".3D")) {
				mediaPlayer = new ThreeDPlayer();
			}
			if(!super.verifyData(fileName)) {
				throw new NullMediaException("不可播放文件");
			}
		}
		
	}
	
	

}
