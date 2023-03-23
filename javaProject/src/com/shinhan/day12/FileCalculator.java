package com.shinhan.day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCalculator {
	public static void main(String[] args) {

		try {
			new FileCalculator().addCalculateResult("data.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void addCalculateResult(String inputFileName) throws Exception {
		// FileInputStream, FileReader
		// 보조 stream 이용 : DataInputStream, BufferedReader

		//스트림은 스트림 보조를, 리더는 리더 보조를 사용해야 함.
		//실패 : DataOutputStream으로 저장후 DataInputStream가능
		//FileInputStream fi = new FileInputStream(inputFileName); 
		//DataInputStream dis = new DataInputStream(fi); //FileInputStream로 읽고, 보조 스트림인 dataInputStream을 이용
		
		FileReader fi = new FileReader(inputFileName);
		BufferedReader br = new BufferedReader(fi);
		
		String s;	//int형으로 읽기위해
		int sum =0, multiply=1;
		while((s = br.readLine()) != null) {	//파일 읽기 시작
			int n = Integer.parseInt(s);
			sum += n;
			multiply *= n;
			System.out.println(n);
		}
		System.out.println(sum + "----------" + multiply);
		br.close();	//자바와 가까운 것 먼저 닫기
		fi.close();
		
		//파일을 출력 목적으로 열기
		FileWriter fw = new FileWriter(inputFileName, true);	//append여부
		BufferedWriter bw = new BufferedWriter(fw);
		bw.newLine();
		bw.write(sum+"");
		bw.newLine();
		bw.write(multiply+"");
		
		bw.close();
		fw.close();
	}

}
