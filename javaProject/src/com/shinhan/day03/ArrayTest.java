package com.shinhan.day03;

import java.util.Arrays;

//cmd > bin > java com/shinhan/day03/ArrayTest 100 200
//이때 100, 200은 매개변수임
//매개변수가 몇개인지 모르기 때문에 main에서 args를 배열로 받음
//명령행 매개변수라고 함.
public class ArrayTest {

	public static void main(String[] args) {
		System.out.println(args.length);
		
		if(args.length < 2) {
			//main빠지기
			//return;
			
			//프로그램 종로
			System.exit(0); 	//0:정상종료 -1: 비정상종료
		}
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println(a+b);
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
	}

	private static void f6() {
		//배열 복사하기
		int arr1[]= new int[] {100, 30, 50, 20};
		int arr2[] = new int[10];
		int arr3[] = new int[10];
		
		for(int i=0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		
		//arr1의 0번째부터 arr3의 0번째에 arr1.length만큼 복사해라
		//원본, 원본시작, 복사, 복사저장시작, 복사할 길이
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.out.println(Arrays.toString(arr2));
	}

	private static void f5() {
		//선언과 생성...자동 초기화
		int arr[] = new int[5];
		
		//선언과 생성...초기화 설정 시 길이는 생략
		int arr2[] = new int[]{100, 20, 30};
		int arr3[] = {100, 20, 30};	//선언과 초기화 같이 진행 시 new dataType[] 생략 가능
		
		//선언과 초기화 따로 진행 시 new dataType[] 필수!
		int arr4[];
		arr4 = new int[] {30,40,20};
		
		//2차원 배열 초기화
		int arr5[][] = new int [][] {{2,4,5,},{3,44,5,5}};
		
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		System.out.println("===========================");
		//2차원 배열은 위와같이 출력시 [0][0]의 주소가 출력됨
		for(int[] aa:arr5) {
				System.out.println(Arrays.toString(aa));
		}
		
	}

	private static void f4() {
		//가변 배열
		int[] arr2[];
		arr2 = new int[3][];
		
		arr2[0] = new int[3];
		arr2[1] = new int[4];
		arr2[2] = new int[2];
		
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.printf(" %d",arr2[i][j]);
			}
			System.out.println();
		}
			
	}

	private static void f3() {
		//2차원 배열
		
		//1.배열 선언
		int[][] arr1;
		int[] arr2[];
		int arr3[][];
		
		//2.배열 생성 ... 배열 길이 필수
		arr1 = new int [3][4];
		arr2 = new int[3][];
		arr3 = new int[3][];
		
//		3. 배열 사용
		System.out.println(arr1[0][0]);
		System.out.println(arr2[0]);
		
		//기본for
//		for(int i=0; i<arr1.length; i++) {
//			for(int j=0; j<arr1[i].length; j++) {
//				System.out.printf("%d행 %d열 = %d", i, j, arr1[i][j]);
//				System.out.println();
//			}
//		}
		
		for(int[] aa:arr1) {	//2차원 배열인 상태
			for(int bb:aa) {	//1차원 배열에 들어온 상태
				System.out.printf(bb + "\t");
			}
			System.out.println();
		}
		
	}

	private static void f2() {
		int scores[];
		scores = new int[26];
		scores[0] = 100;
		scores[1] = 90;
		scores[2] = 80;
		
		int total = 0;
		
		//일반 for
		for(int index=0;index < scores.length-1; index++) {
			total += scores[index];
		}
		System.out.println(total);

		total = 0;
		//항상for, 확장for => for(타입 변수 : 배열)
		for(int score:scores) {
			total += score;
		}
		
		System.out.println(total);
		
	}

	private static void f1() {
		//배열 : 하나의 이름으로 같은 타입의 Heap에 연속공간을 만드는 자료구조
		//연속공간이기 때문에 속도가 빠름.
		//1. 배열 변수 선언
		int[] arr1 = null;
		int arr2[];
		double[] arr3;
		boolean[] arr4;
		String arr5[];
		
		//2. 배열 생성... 배열의 개수는 필수. 생성시 자동초기화됨.
		//초기화 값 ) 정수:0 , 실수: 0.0, boolean:false, 객체:null
		arr1 = new int[5];
		arr3 = new double[6];
		arr4 = new boolean[4];
		arr5 = new String[5];
		
		//3. 배열 사용
		
		System.out.println(arr1[0]);
		//Arrays.toString : 배열 모두 돌아라
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(arr5));
		
	}

}
