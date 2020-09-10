package com.chen.library.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.UUID;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;

public class ImageUtil {
	public static void main(String[] args) throws IOException {
		int x = 0;
		int y = 0;// 左上

		int w = 2560;
		int h = 3072;// 右下
		String src = "E:/3.BMP";
		String prefixName = src.substring(0, src.lastIndexOf("."));
		  //imgScale(src, prefixName,5.0);
		  imgThumb(src, prefixName, w, h, 0.8f);
		// imgSourceRegion("d:/1.bmp", "d:/", x, y, x + w, y + h, 768, 576,
		// true);
	}

	/**
	 * 指定大小进行缩放 若图片横比width小，高比height小，不变 若图片横比width小，高比height大，高缩小到height，图片比例不变
	 * 若图片横比width大，高比height小，横缩小到width，图片比例不变
	 * 若图片横比width大，高比height大，图片按比例缩小，横为width或高为height
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输出源
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @throws IOException
	 */
	public static void imgThumb(String source, String output, int width, int height, float quality) throws IOException {
		Thumbnails.of(source).size(width, height).outputQuality(quality).outputFormat("jpg").toFile(output);
	}

	public static void imgThumb(String source, String output, int width, int height, float quality, String suffix)
			throws IOException {
		Thumbnails.of(source).size(width, height).outputQuality(quality).outputFormat(suffix).toFile(output);
	}

	/**
	 * 指定大小进行缩放
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输出源
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @throws IOException
	 */
	public static void imgThumb(File source, String output, int width, int height, float quality) throws IOException {
		Thumbnails.of(source).size(width, height).outputQuality(quality).outputFormat("jpg").toFile(output);
	}

	/**
	 * 按照比例进行缩放
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输出源
	 * @throws IOException
	 */
	public static void imgScale(String source, String output, double scale) throws IOException {
		Thumbnails.of(source).scale(scale).outputFormat("jpg").toFile(output);
	}

	public static void imgScale(File source, String output, double scale) throws IOException {
		Thumbnails.of(source).scale(scale).outputFormat("jpg").toFile(output);
	}

	/**
	 * 不按照比例，指定大小进行缩放
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输出源
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param keepAspectRatio
	 *            默认是按照比例缩放的,值为false 时不按比例缩放
	 */
	public static void imgNoScale(String source, String output, int width, int height, boolean keepAspectRatio)
			throws IOException {
		Thumbnails.of(source).size(width, height).keepAspectRatio(keepAspectRatio).outputFormat("jpg").toFile(output);
	}

	public static void imgNoScale(File source, String output, int width, int height, boolean keepAspectRatio)
			throws IOException {
		Thumbnails.of(source).size(width, height).keepAspectRatio(keepAspectRatio).outputFormat("jpg").toFile(output);
	}

	/**
	 * 旋转 ,正数：顺时针 负数：逆时针
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输出源
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param rotate
	 *            角度
	 */
	public static void imgRotate(String source, String output, int width, int height, double rotate)
			throws IOException {
		Thumbnails.of(source).size(width, height).rotate(rotate).outputFormat("jpg").toFile(output);
	}

	public static void imgRotate(File source, String output, int width, int height, double rotate) throws IOException {
		Thumbnails.of(source).size(width, height).rotate(rotate).outputFormat("jpg").toFile(output);
	}

	/**
	 * 水印
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输入源
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param position
	 *            水印位置 Positions.BOTTOM_RIGHT o.5f
	 * @param watermark
	 *            水印图片地址
	 * @param transparency
	 *            透明度 0.5f
	 * @param quality
	 *            图片质量 0.8f
	 */
	public static void imgWatermark(String source, String output, int width, int height, Position position,
			String watermark, float transparency, float quality) throws IOException {
		Thumbnails.of(source).size(width, height).watermark(position, ImageIO.read(new File(watermark)), transparency)
				.outputQuality(0.8f).outputFormat("jpg").toFile(output);
	}

	public static void imgWatermark(File source, String output, int width, int height, Position position,
			String watermark, float transparency, float quality) throws IOException {
		Thumbnails.of(source).size(width, height).watermark(position, ImageIO.read(new File(watermark)), transparency)
				.outputQuality(0.8f).outputFormat("jpg").toFile(output);
	}

	/**
	 * 裁剪图片
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输出源
	 * @param position
	 *            裁剪位置
	 * @param x
	 *            裁剪区域x
	 * @param y
	 *            裁剪区域y
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param keepAspectRatio
	 *            默认是按照比例缩放的,值为false 时不按比例缩放
	 */
	public static void imgSourceRegion(String source, String output, Position position, int x, int y, int width,
			int height, boolean keepAspectRatio) throws IOException {
		Thumbnails.of(source).sourceRegion(position, x, y).size(width, height).keepAspectRatio(keepAspectRatio)
				.outputFormat("jpg").toFile(output);
	}

	public static void imgSourceRegion(File source, String output, Position position, int x, int y, int width,
			int height, boolean keepAspectRatio) throws IOException {
		Thumbnails.of(source).sourceRegion(position, x, y).size(width, height).keepAspectRatio(keepAspectRatio)
				.outputFormat("jpg").toFile(output);
	}

	/**
	 * 按坐标裁剪
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输出源
	 * @param x
	 *            起始x坐标
	 * @param y
	 *            起始y坐标
	 * @param x1
	 *            结束x坐标
	 * @param y1
	 *            结束y坐标
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param keepAspectRatio
	 *            默认是按照比例缩放的,值为false 时不按比例缩放
	 */
	public static void imgSourceRegion(String source, String output, int x, int y, int x1, int y1, int width,
			int height, boolean keepAspectRatio) throws IOException {
		Thumbnails.of(source).sourceRegion(x, y, x1, y1).size(width, height).keepAspectRatio(keepAspectRatio)
				.toFile(output);
	}

	public static void imgSourceRegion(File source, String output, int x, int y, int x1, int y1, int width, int height,
			boolean keepAspectRatio) throws IOException {
		Thumbnails.of(source).sourceRegion(x, y, x1, y1).size(width, height).keepAspectRatio(keepAspectRatio)
				.outputFormat("jpg").toFile(output);
	}

	/**
	 * 转化图像格式
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输出源
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param format
	 *            图片类型，gif、png、jpg
	 */
	public static void imgFormat(String source, String output, int width, int height, String format)
			throws IOException {
		Thumbnails.of(source).size(width, height).outputFormat(format).toFile(output);
	}

	public static void imgFormat(File source, String output, int width, int height, String format) throws IOException {
		Thumbnails.of(source).size(width, height).outputFormat(format).outputFormat("jpg").toFile(output);
	}

	/**
	 * 输出到OutputStream
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输出源
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @return toOutputStream(流对象)
	 */
	public static OutputStream imgOutputStream(String source, String output, int width, int height) throws IOException {
		OutputStream os = new FileOutputStream(output);
		Thumbnails.of(source).size(width, height).outputFormat("jpg").toOutputStream(os);
		return os;
	}

	public static OutputStream imgOutputStream(File source, String output, int width, int height) throws IOException {
		OutputStream os = new FileOutputStream(output);
		Thumbnails.of(source).size(width, height).outputFormat("jpg").toOutputStream(os);
		return os;
	}

	/**
	 * 输出到BufferedImage
	 *
	 * @param source
	 *            输入源
	 * @param output
	 *            输出源
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param format
	 *            图片类型，gif、png、jpg
	 * @return BufferedImage
	 */
	public static BufferedImage imgBufferedImage(String source, String output, int width, int height, String format)
			throws IOException {
		BufferedImage buf = Thumbnails.of(source).size(width, height).outputFormat("jpg").asBufferedImage();
		ImageIO.write(buf, format, new File(output));
		return buf;
	}

	public static BufferedImage imgBufferedImage(File source, String output, int width, int height, String format)
			throws IOException {
		BufferedImage buf = Thumbnails.of(source).size(width, height).outputFormat("jpg").asBufferedImage();
		ImageIO.write(buf, format, new File(output));
		return buf;
	}

	// 获得图片的base64码
	@SuppressWarnings({ "deprecation", "restriction" })
	public static String getImageBase(String src) throws IOException {

		if (src == null || src == "") {
			return "";
		}
		int w = 2560;
		int h = 3072;// 右下
		String prefixName = src.substring(0, src.lastIndexOf("."))+UUID.randomUUID();
		imgThumb(src, prefixName, w, h, 0.8f);
		String arcName = prefixName + ".jpg";
		File file = new File(arcName);
	
		if (!file.exists()) {
			return "";
		}
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("restriction")
		Encoder encoder = Base64.getEncoder();
		String result = encoder.encodeToString(data);
		if(file.exists())
		file.delete();
		
		return result;
		// Decoder decoder = Base64.getDecoder();
		// byte[] result = decoder.decode(str);

	}

	// 链接url下载图片
	private static void downloadPicture(String urlList, String path) {
		URL url = null;
		try {
			url = new URL(urlList);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());

			FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int length;

			while ((length = dataInputStream.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			Encoder encoder = Base64.getEncoder();
			String encode = encoder.encodeToString(buffer);// 返回Base64编码过的字节数组字符串
			System.out.println(encode);
			fileOutputStream.write(output.toByteArray());
			dataInputStream.close();
			fileOutputStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
