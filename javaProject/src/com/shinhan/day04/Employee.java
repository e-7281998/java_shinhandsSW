package com.shinhan.day04;

import java.util.Objects;

public class Employee  implements Comparable<Employee>{
	private String name;
	private String titl;
	private int baseSalary;
	private int totalSalary;

	public Employee(String name, String title, int baseSalary) {
		this.name = name;
		this.titl = title+"님";
		this.baseSalary = baseSalary;
		getTotalSalary();
	}

	public void getTotalSalary() {

		//문자열 비교 : 문자열.equals("비교대상");
		if (titl.equals("부장님")) {
			totalSalary = (int)(baseSalary + baseSalary * 0.25);
		} else if (titl.equals("과장님")) {
			totalSalary = (int)(baseSalary + baseSalary * 0.15);
		} else {
			totalSalary = (int)(baseSalary + baseSalary * 0.05);
		}
	}

	public void print() {
		System.out.println(titl + " 직급의 " + name + "의 본봉은 " + baseSalary + "원 이고 총 급여는 " + totalSalary + " 원 입니다.");
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", titl=" + titl + ", baseSalary=" + baseSalary + ", totalSalary="
				+ totalSalary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, titl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && Objects.equals(titl, other.titl);
	}

	@Override
	public int compareTo(Employee o) {
		int result = name.compareTo(o.name) * -1;
		int result2 = baseSalary - o.baseSalary *-1;
		if(result2 == 0)	return titl.compareTo(o.titl);
		if(result == 0) return result2;
		return result;
	}


	
	
	

}
