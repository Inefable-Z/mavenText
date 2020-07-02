package com.example.MyTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 下载图片
 * @author EDZ
 *
 */
public class DownPage extends Thread {
	public volatile static boolean exit = false;

	public static void main(String args[]) throws IOException, InterruptedException {
		final String fname = "E:/综合/图片/官网手游/";
		DownPage thread = new DownPage();
		// createDir(fname);
		final String[] url = { "http://work.92hwan.com/static/uploads/game/2020051916572454267.png",
				"http://work.92hwan.com/static/uploads/game/2020051916573282354.jpg",
				"http://work.92hwan.com/static/uploads/game/2020051916573347896.jpg",
				"http://work.92hwan.com/static/uploads/game/2020051916573347896.jpg",
				"http://work.92hwan.com/static/uploads/game/2020051916573536733.jpg",
				"http://work.92hwan.com/static/uploads/game/2020051916573655035.jpg" };
		ExecutorService pool = Executors.newFixedThreadPool(6);

		for (int i = 0; i < url.length; i++) {
			String type = url[i].toString();
			int flag = type.lastIndexOf(".");
			final String PageType = type.substring(flag + 1, type.length());
			final int index = i;
			pool.execute(new Runnable() {
				public void run() {
					try {
						if ("png".equals(PageType)) {
							download(url[index], "第" + index + "图片.png", fname, index);
						}
						if ("jpg".equals(PageType)) {
							download(url[index], "第" + index + "图片.jpg", fname, index);
						}
						if ("gif".equals(PageType)) {
							download(url[index], "第" + index + "图片.gif", fname, index);
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			});

		}

		/*
		 * String img = "img"; boolean flag = DownPage.fileToZip(fname, fname1, img); if
		 * (flag) { System.out.println("文件打包成功!"); } else {
		 * System.out.println("文件打包失败!"); } thread.sleep(5000); thread.exit = true; File
		 * file = new File(fname);
		 */
		// deleteAllFilesOfDir(file);

	}

//此方法实现文件夹的删除

	public static void deleteAllFilesOfDir(File path) {
		if (!path.exists())
			return;
		if (path.isFile()) {
			path.delete();
			return;
		}
		File[] files = path.listFiles();
		for (int i = 0; i < files.length; i++) {
			deleteAllFilesOfDir(files[i]);
			System.out.println("删除图片" + files[i]);
		}
		path.delete();

	}

//此方法实现文件夹的压缩
	/*
	 * public static boolean fileToZip(String sourceFilePath, String zipFilePath,
	 * String fileName) { boolean flag = false; File sourceFile = new
	 * File(sourceFilePath); FileInputStream fis = null; BufferedInputStream bis =
	 * null; FileOutputStream fos = null; ZipOutputStream zos = null;
	 * 
	 * if (sourceFile.exists() == false) { System.out.println("待压缩的文件目录：" +
	 * sourceFilePath + "不存在."); } else { try { File zipFile = new File(zipFilePath
	 * + "/" + fileName + ".zip"); if (zipFile.exists()) {
	 * System.out.println(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
	 * } else { File[] sourceFiles = sourceFile.listFiles(); if (null == sourceFiles
	 * || sourceFiles.length < 1) { System.out.println("待压缩的文件目录：" + sourceFilePath
	 * + "里面不存在文件，无需压缩."); } else { fos = new FileOutputStream(zipFile); zos = new
	 * ZipOutputStream(new BufferedOutputStream(fos)); byte[] bufs = new byte[1024 *
	 * 10]; for (int i = 0; i < sourceFiles.length; i++) { // 创建ZIP实体，并添加进压缩包
	 * ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
	 * zos.putNextEntry(zipEntry); // 读取待压缩的文件并写进压缩包里 fis = new
	 * FileInputStream(sourceFiles[i]); bis = new BufferedInputStream(fis, 1024 *
	 * 10); int read = 0; while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
	 * zos.write(bufs, 0, read); } } flag = true; } } } catch (FileNotFoundException
	 * e) { e.printStackTrace(); throw new RuntimeException(e); } catch (IOException
	 * e) { e.printStackTrace(); throw new RuntimeException(e); } finally { // 关闭流
	 * try { if (null != bis) bis.close(); if (null != zos) zos.close(); } catch
	 * (IOException e) { e.printStackTrace(); throw new RuntimeException(e); } } }
	 * return flag; }
	 */

//此方法实现图片下载

	protected static void download(String url, String string, String fname, int index) throws IOException {
// TODO Auto-generated method stub
		URL u = new URL(url);
		URLConnection con = u.openConnection();
		System.out.println("开始下载第" + index + " 图片");
		try {
			con.setConnectTimeout(20 * 1000);
			con.setReadTimeout(10 * 1000);
		} catch (Exception e) {
			System.out.println("第" + index + "下载失败");
		}
		try {
			InputStream is = con.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			File sf = new File(fname);
			/*
			 * if (!sf.exists()) { sf.mkdir(); } else { System.out.println("下载失败"); }
			 */
			OutputStream os = new FileOutputStream(sf.getPath() + "\\" + string);
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);

			}
			System.out.println("下载第" + index + "图片完成");
			os.close();
			is.close();
		} catch (Exception e) {
		}

	}

//此方法实现文件夹得创建

	/*
	 * public static boolean createDir(String fname) { File dir = new File(fname);
	 * if (dir.exists()) { System.out.println("创建目录" + fname + "失败，目标目录已存在！");
	 * return false; } // 判断字符串是否以‘/’作为分隔符 if (!fname.endsWith(File.separator))
	 * fname = fname + File.separator; // 创建单个目录 if (dir.mkdirs()) {
	 * System.out.println("创建目录" + fname + "成功！"); return true; } else {
	 * System.out.println("创建目录" + fname + "成功！"); return false; } }
	 */
}