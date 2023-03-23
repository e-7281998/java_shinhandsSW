package com.shinhan.day12;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;

import com.shinhan.day05.Account;

public class IOTest {
	public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException {
		f11();
	}
	
	private static void f11() {
		String fileName = "src/com/shinhan/day12/scoreData.txt";
		File f = new File(fileName);
		
		System.out.println(f.lastModified());
		Date d = new Date(f.lastModified());
		System.out.println(d);
		System.out.println("파일의 사이즈:" + f.length());
		System.out.println(f.isFile() ? "파일임" : "파일이아님");
	}

	private static void f10() throws IOException, ClassNotFoundException {
		//객체 쓰기
		FileOutputStream fw = new FileOutputStream("serialiaaekldat.dat");	//원래 사람이 읽으라고 만든 파일 아님...
		ObjectOutputStream oos = new ObjectOutputStream(fw) ;
		
		oos.writeObject(new Account("123-123", "강3"));
		oos.writeObject(new Account("123-124", "강2"));
		oos.writeObject(new Account("123-122", "강1"));

		
		oos.close();
		fw.close();
		
		//객체 읽기
		FileInputStream fi = new FileInputStream("serialiaaekldat.dat");
		ObjectInputStream ois = new ObjectInputStream(fi);
		//다시 Student로 형변환해야 읽을 ㅜㅅ 있음
		Account s1 = (Account)ois.readObject();
		Account s2 = (Account)ois.readObject();
		Account s3 = (Account)ois.readObject();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		fi.close();
	}

	private static void f9() throws IOException, ClassNotFoundException {
		//객체 쓰기
		FileOutputStream fw = new FileOutputStream("serialiaaekldat.dat");	//원래 사람이 읽으라고 만든 파일 아님...
		ObjectOutputStream oos = new ObjectOutputStream(fw) ;
		
		oos.writeObject(new Student("탬1", 100,99));
		oos.writeObject(new Student("탬2", 100,99));
		oos.writeObject(new Student("탬3", 100,99));
		
		oos.close();
		fw.close();
		
		//객체 읽기
		FileInputStream fi = new FileInputStream("serialiaaekldat.dat");
		ObjectInputStream ois = new ObjectInputStream(fi);
		//다시 Student로 형변환해야 읽을 ㅜㅅ 있음
		Student s1 = (Student)ois.readObject();
		Student s2 = (Student)ois.readObject();
		Student s3 = (Student)ois.readObject();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		fi.close();
	}
	

	private static void f8() throws IOException {
		FileWriter fw = new FileWriter("print.txt");
		PrintWriter  pw  = new PrintWriter(fw);
		
		pw.print(false);
		pw.print("false");
		pw.write(1000);
		pw.write("zhd");
		
		//자바랑 가까운 쪽 먼저 닫기
		pw.close();
		fw.close();
	}

	private static void f7() throws IOException {
		OutputStream fw = new FileOutputStream("prinitiveDate.txt");
		//자바의 기본타입을 저장하고 그대로 읽고자 한다.
		DataOutputStream dos = new DataOutputStream(fw);
		dos.writeInt(110);
		dos.writeInt(200);
		dos.writeBoolean(true);
		dos.writeDouble(3.14);
		dos.writeChar('A');
		dos.close();
		
		InputStream fr = new FileInputStream("prinitiveDate.txt");
		DataInputStream dis = new DataInputStream(fr);
		int a = dis.readInt();
		int b = dis.readInt();
		boolean c = dis.readBoolean();
		double d = dis.readDouble();
		char e = dis.readChar();
		
		System.out.println(a + 1);
		System.out.println(b);
		System.out.println(c ? "true" : "false");
		System.out.println(d +1);
		System.out.println(Character.toLowerCase(e));
		
		dis.close();
		fw.close();
		fr.close();
	}

	private static void f6() throws IOException {
		String fileName = "src/com/shinhan/day12/scoreData.txt";
		Path path = Paths.get(fileName);
		Files.lines(path).forEach(row -> { // Files.lines : 스트림 얻을 수 있음. 여기까지가 스트림임
			System.out.print(row.replace("/", "\t"));
			String[] arr = row.split("/");
			int total = 0;
			for (int i = 1; i < arr.length; i++) {
				try {
					total += Integer.parseInt(arr[i]);
				}catch(NumberFormatException e) {}
			}
			System.out.println("\t" + total + "\t" + total / (arr.length - 1));
		});
	}

	// 보조 스트림 끼워서 한 줄씩 읽기 :BufferedReader : 버퍼 찰 때까지 기다렸다가 읽음
	private static void f5() throws IOException {
		String path = "src/com/shinhan/day12/scoreData.txt"; // 상대경로 //현재경로를 현재 프로젝트로 읽음 : javaProject
		FileReader fr = new FileReader(path);
		// 한 줄 씩 읽을 수 있도록 해줌..
		BufferedReader br = new BufferedReader(fr);
		String row;
		String title = br.readLine();
		System.out.println(title.replaceAll("/", "\t") + "\t" + "총점" + "\t" + "평균");
		while ((row = br.readLine()) != null) {
			System.out.print(row.replace("/", "\t"));
			String[] arr = row.split("/");
			int total = 0;
			for (int i = 1; i < arr.length; i++) {
				total += Integer.parseInt(arr[i]);
			}
			System.out.println("\t" + total + "\t" + total / (arr.length - 1));
		}
		br.close();
		fr.close();
	}

	private static void f4() throws URISyntaxException {
		// 1.class기준
//		Path path = Paths.get(IOTest.class.getResource("data.txt").toURI());
//		Path path = Paths.get(IOTest.class.getResource("Example.class").toURI());
//		System.out.println(path);
		// 2.절대경로 /로 시작한다.
		// Path path =
		// Paths.get(StreamTest3.class.getResource("/com/shinhan/day11/data.txt").toURI());
		// 3.상대경로는 현재위치를 기준으로한다.
		// 다음은 현재의 절대경로를 얻는다.
		Path path = Paths.get(""); // 1)
		System.out.println(path.toAbsolutePath());
		// String absolute = System.getProperty("user.dir")+"/data.txt";//2)
		// Path path = Paths.get(absolute);
//		String s = path.toAbsolutePath().toString();
//		path =Paths.get(s+"/data.txt");
//		System.out.println("현재 작업 경로: " + s);
//		System.out.println(Charset.defaultCharset());		
	}

	// 파일 일고, 쓰기
	private static void f3() throws IOException {
		String path = "src/com/shinhan/day11/data.txt"; // 상대경로 //현재경로를 현재 프로젝트로 읽음 : javaProject
		FileReader fr = new FileReader(path); // 한글 안깨짐
		FileWriter fw = new FileWriter("data2.txt");
		int i;
		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
			fw.write((char) i);
		}

		fw.close();
		fr.close();
	}

	private static void f2() throws IOException {
		String path = System.getProperty("user.dir"); // 현재 작업중인 경로
		path += "/src/com/shinhan/day11/data.txt"; // 절대경로
		System.out.println(path);
		FileInputStream f1 = new FileInputStream(path);
		// 보조 스트림 : Stream을 Reader로 바꿔주는 역할
		InputStreamReader ir = new InputStreamReader(f1);
		int i;
		while ((i = ir.read()) != -1) { // -1은 EOF를 뜻함 : end of file
			System.out.print((char) i);
		}
		ir.close();
		f1.close(); // 자원 반납
		System.out.println("f2 end");
	}

	private static void f1() throws IOException {
		// InputStream, OutputStream : 1byte씩 //Reader, Writer : 2byte 처리
		// FileInputStream, FileOutputStream //FileReader, FileWriter

		// 한글은 깨짐 : 1byte씩 읽어서
		InputStream is = System.in; // 표준 입력 : 키보드임. 변경가능
		byte[] arr = new byte[100];
		int i = is.read(arr); // i는 read한 number of byte
//		System.out.println(i);	//1이 int로 49	//13:enter //10: nextline으로 넘어감 
		System.out.println(i);
		System.out.println(Arrays.toString(arr));

		for (int a = 0; a < i - 2; a++) {
			System.out.print((char) arr[a]);
		}
	}
}
