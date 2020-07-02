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
 * ����ͼƬ
 * @author EDZ
 *
 */
public class DownPage extends Thread {
	public volatile static boolean exit = false;

	public static void main(String args[]) throws IOException, InterruptedException {
		final String fname = "E:/�ۺ�/ͼƬ/��������/";
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
							download(url[index], "��" + index + "ͼƬ.png", fname, index);
						}
						if ("jpg".equals(PageType)) {
							download(url[index], "��" + index + "ͼƬ.jpg", fname, index);
						}
						if ("gif".equals(PageType)) {
							download(url[index], "��" + index + "ͼƬ.gif", fname, index);
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			});

		}

		/*
		 * String img = "img"; boolean flag = DownPage.fileToZip(fname, fname1, img); if
		 * (flag) { System.out.println("�ļ�����ɹ�!"); } else {
		 * System.out.println("�ļ����ʧ��!"); } thread.sleep(5000); thread.exit = true; File
		 * file = new File(fname);
		 */
		// deleteAllFilesOfDir(file);

	}

//�˷���ʵ���ļ��е�ɾ��

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
			System.out.println("ɾ��ͼƬ" + files[i]);
		}
		path.delete();

	}

//�˷���ʵ���ļ��е�ѹ��
	/*
	 * public static boolean fileToZip(String sourceFilePath, String zipFilePath,
	 * String fileName) { boolean flag = false; File sourceFile = new
	 * File(sourceFilePath); FileInputStream fis = null; BufferedInputStream bis =
	 * null; FileOutputStream fos = null; ZipOutputStream zos = null;
	 * 
	 * if (sourceFile.exists() == false) { System.out.println("��ѹ�����ļ�Ŀ¼��" +
	 * sourceFilePath + "������."); } else { try { File zipFile = new File(zipFilePath
	 * + "/" + fileName + ".zip"); if (zipFile.exists()) {
	 * System.out.println(zipFilePath + "Ŀ¼�´�������Ϊ:" + fileName + ".zip" + "����ļ�.");
	 * } else { File[] sourceFiles = sourceFile.listFiles(); if (null == sourceFiles
	 * || sourceFiles.length < 1) { System.out.println("��ѹ�����ļ�Ŀ¼��" + sourceFilePath
	 * + "���治�����ļ�������ѹ��."); } else { fos = new FileOutputStream(zipFile); zos = new
	 * ZipOutputStream(new BufferedOutputStream(fos)); byte[] bufs = new byte[1024 *
	 * 10]; for (int i = 0; i < sourceFiles.length; i++) { // ����ZIPʵ�壬����ӽ�ѹ����
	 * ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
	 * zos.putNextEntry(zipEntry); // ��ȡ��ѹ�����ļ���д��ѹ������ fis = new
	 * FileInputStream(sourceFiles[i]); bis = new BufferedInputStream(fis, 1024 *
	 * 10); int read = 0; while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
	 * zos.write(bufs, 0, read); } } flag = true; } } } catch (FileNotFoundException
	 * e) { e.printStackTrace(); throw new RuntimeException(e); } catch (IOException
	 * e) { e.printStackTrace(); throw new RuntimeException(e); } finally { // �ر���
	 * try { if (null != bis) bis.close(); if (null != zos) zos.close(); } catch
	 * (IOException e) { e.printStackTrace(); throw new RuntimeException(e); } } }
	 * return flag; }
	 */

//�˷���ʵ��ͼƬ����

	protected static void download(String url, String string, String fname, int index) throws IOException {
// TODO Auto-generated method stub
		URL u = new URL(url);
		URLConnection con = u.openConnection();
		System.out.println("��ʼ���ص�" + index + " ͼƬ");
		try {
			con.setConnectTimeout(20 * 1000);
			con.setReadTimeout(10 * 1000);
		} catch (Exception e) {
			System.out.println("��" + index + "����ʧ��");
		}
		try {
			InputStream is = con.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			File sf = new File(fname);
			/*
			 * if (!sf.exists()) { sf.mkdir(); } else { System.out.println("����ʧ��"); }
			 */
			OutputStream os = new FileOutputStream(sf.getPath() + "\\" + string);
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);

			}
			System.out.println("���ص�" + index + "ͼƬ���");
			os.close();
			is.close();
		} catch (Exception e) {
		}

	}

//�˷���ʵ���ļ��еô���

	/*
	 * public static boolean createDir(String fname) { File dir = new File(fname);
	 * if (dir.exists()) { System.out.println("����Ŀ¼" + fname + "ʧ�ܣ�Ŀ��Ŀ¼�Ѵ��ڣ�");
	 * return false; } // �ж��ַ����Ƿ��ԡ�/����Ϊ�ָ��� if (!fname.endsWith(File.separator))
	 * fname = fname + File.separator; // ��������Ŀ¼ if (dir.mkdirs()) {
	 * System.out.println("����Ŀ¼" + fname + "�ɹ���"); return true; } else {
	 * System.out.println("����Ŀ¼" + fname + "�ɹ���"); return false; } }
	 */
}