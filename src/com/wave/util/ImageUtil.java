package com.wave.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import javax.imageio.ImageIO;
public class ImageUtil {
   
    public static void abscut(String srcImageFile) {
    	//初始的坐标x，y 
        try {
        	System.out.println("图片的地址和文件名："+srcImageFile);
            Image img;
            ImageFilter cropFilter;
            // 读取源图像
            BufferedImage bi = ImageIO.read(new File(srcImageFile));
            int srcWidth = bi.getWidth(); // 源图宽度
            int srcHeight = bi.getHeight(); // 源图高度
           
            int destLength;
            int x=0,y=0;
            if(srcHeight<srcWidth){
            	destLength=srcHeight;
            	x=(srcWidth-srcHeight)/2;
            }else{
            	destLength=srcWidth;
            	y=(srcHeight-srcWidth)/2;
            }
            
            	 
            
            System.out.println("srcWidth= " + srcWidth + "\tsrcHeight= "
                    + srcHeight);
            System.out.println("destLength:"+destLength);
            
                Image image = bi.getScaledInstance(srcWidth, srcHeight,Image.SCALE_DEFAULT);//获取缩放后的图片大小
                cropFilter = new CropImageFilter(x, y, destLength, destLength);//裁剪的起始点的座标,宽和高
                img = Toolkit.getDefaultToolkit().createImage(
                        new FilteredImageSource(image.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(destLength, destLength,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, null); // 绘制截取后的图
                g.dispose();
                // 输出为文件
                ImageIO.write(tag, "JPEG", new File(srcImageFile));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public static void main(String[] args) {
        abscut("E:\\a.jpg");
        System.out.println("切割成功");
    }}