package com.shinhan.day05;

//상속 = 기존class(변경가능) + 생성자, field와 method 추가
public class CheckingAccount extends Account {
	
	String cardNo;
	
	//만약 부모의 default 생성자를 삭제하게 되면 나의 default생성자를 호출하게 되고, 내 생성자의 super()를 호출하게 되는데 그러면 오류남.
	//부모의 super()를 호출해야 하기 때문이다.
	//그렇기 때문에 default 생성자는 빈 값이라도 남겨두는 것이 좋다. 0
	
	CheckingAccount(String accNo, String owner, int balance, String cardNo) {
		//부모 필드가 private일 경우 다음과 같이 super를 통해 생성 시 접근 가능
		super(accNo, owner, balance);	//명시적으로 부모 생성자를 호출
		this.cardNo = cardNo;
	}
	
	public int pay(String cardNo, int amount) {
		
			if(this.cardNo.equals(cardNo)) {
				return withdraw(amount);
			}else {
				System.out.println("카드번호 오류");
				return 0;
			}
			
	}
	
	void test() {
		//상속받은 필드 사용가능
//		System.out.println(accNo);
//		System.out.println(owner);
//		System.out.println(balance);
		System.out.println(getAccNo());
		System.out.println(getOwner());
		System.out.println(getBalance());
		setAccNo("8888");
		setOwner("kkk");
		setBalance(8000);
		
		//상속받은 메소드 사용 가능
		deposit(1);
		withdraw(2);
	}

}
