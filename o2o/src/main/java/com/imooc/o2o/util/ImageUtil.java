package com.imooc.o2o.util;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.text.Position;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.o2o.dto.ImageHolder;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

public class ImageUtil {
	private static String basePath=Thread.currentThread().
			getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r=new Random();
	public static void main(String[] args) throws IOException{
		
		Thumbnails.of(new File("D:/D/spring boot/spring boot项目实战视频1/SSM到Spring Boot-从零开发校园商铺平台/image_owner/xiaohuangren.jpg"))
		.size(200,200).watermark(Positions.BOTTOM_RIGHT,
				ImageIO.read(new File(basePath+"/watermark.jpg")),0.25f).outputQuality(0.8f)
.toFile("D:/D/spring boot/spring boot项目实战视频1/SSM到Spring Boot-从零开发校园商铺平台/image_owner/xiaohuangren_new.jpg");
	}
	
public static String generateThumbnail(ImageHolder thumbnail/*CommonsMultipart*//*InputStream thumbnailInputStream,String fileName*/, String targetAddr) {
		String realFileName = /*FileUtil.*/getRandomFileName();//获取随机名
		String extension = getFileExtension(/*fileName*/thumbnail.getImageName());//获取扩展名
		makeDirPath(targetAddr);//创建目录
		String relativeAddr = targetAddr + realFileName + extension;//获取相对路径
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage()/*thumbnailInputStream*//*.getInputStream()*/).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT,
					ImageIO.read(new File(basePath+"/watermark.jpg")),0.25f)
			.outputQuality(0.25f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}
		
	/*生成随机文件名，当前年月日小时分钟秒钟+五位随机数*/
	public static String getRandomFileName(){
		//获取随机的五位数
		int rannum=r.nextInt(89999)+10000;
		String nowTimeStr=sDateFormat.format(new Date());
		return nowTimeStr+rannum;
	}
	
	/*public static String generateNormalImg(CommonsMultipartFile thumbnail, String targetAddr) {
		String realFileName = FileUtil.getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getInputStream()).size(337, 640).outputQuality(0.5f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}*/

	/*处理详情图，并返回新生成图片的相对值路径*/
	public static /*List<String>*/String generateNormalImg
	(/*List<CommonsMultipartFile> imgs*/ImageHolder thumbnail, String targetAddr) 
	{
		//获取不重复的随机名
		String realFileName=getRandomFileName();
		//获取文件的扩展名如png jpg等
		String extension=getFileExtension(thumbnail.getImageName());
		//如果目标路径不存在，则自动创建
		makeDirPath(targetAddr);
		//获取文件存储的相对路径(带文件名)
		String relativeAddr = targetAddr + realFileName + extension;//获取相对路径
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage()/*thumbnailInputStream*//*.getInputStream()*/).size(337, 640)
			.watermark(Positions.BOTTOM_RIGHT,
					ImageIO.read(new File(basePath+"/watermark.jpg")),0.9f)
			.outputQuality(0.9f).toFile(dest);
		} catch (IOException e) {
			//Logger.error(e.toString());
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
		/*int count = 0;
		List<String> relativeAddrList = new ArrayList<String>();
		if (imgs != null && imgs.size() > 0) {
			makeDirPath(targetAddr);
			for (CommonsMultipartFile img : imgs) {
				String realFileName = FileUtil.getRandomFileName();
				String extension = getFileExtension(img);
				String relativeAddr = targetAddr + realFileName + count + extension;
				File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
				count++;
				try {
					Thumbnails.of(img.getInputStream()).size(600, 300).outputQuality(0.5f).toFile(dest);
				} catch (IOException e) {
					throw new RuntimeException("创建图片失败：" + e.toString());
				}
				relativeAddrList.add(relativeAddr);
			}
		}
		return relativeAddrList;*/
	}

	/*创建目标路径所涉及到的目录，即/home/work/xiangze/xxx.jpg,
	那么Home work xiangze这三个文件夹都得自动创建*/
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/*获取输入文件流的扩展名*/
	private static String getFileExtension(/*CommonsMultipart*/String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	/*storePath是文件的路径还是目录的路径
	如果是文件路径则删除该文件
	如果是目录路径则删除该目录下的所有文件*/
	public static void deleteFileOrPath(String storePath){
		File fileOrPath=new File(PathUtil.getImgBasePath()+storePath);
		if(fileOrPath.exists()){
			if(fileOrPath.isDirectory()){//目录路径
				File files[]=fileOrPath.listFiles();
				for(int i=0;i<files.length;i++){
					files[i].delete();
				}
			}
			fileOrPath.delete();//文件的删除
		}
	}
}
