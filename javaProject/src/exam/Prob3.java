package exam;

//완료
class Prob3 {
	public static void main(String args[]) {
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();
	}
}

class PhoneCharge {
	private String user;
	private int call;
	private int sms;
	private int data;
	private int total;

	public PhoneCharge(String user, int call, int sms, int data) {
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;

	}

	public int calcCharge() {
		int callFee;	
		int smsFee;
		int dataFee;
		
		callFee = call*10;
		if(call >= 200)
			callFee *= 2;
		
		smsFee = sms * 20;
		if(sms >= 300)
			smsFee *= 4;
		
		dataFee = data * 1000;
		if(data >= 7)
			dataFee *=2;
		
		total = callFee + smsFee + dataFee;
		
		return total;
	}

	public void printCharge() {
		System.out.println(user + " 사용자는 이번달에 사용하신 전화요금이 "+calcCharge() +"원입니다.");
	}

}
