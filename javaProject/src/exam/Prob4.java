package exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.shinhan.day05.Account;

public class Prob4 {

	public static void main(String[] args) {
		Product[] prodList = {
				new Product("NT450R5E-K24S",500000,"삼성전자"),
				new Product("15UD340-LX2CK",400000,"LG전자"),
				new Product("G2-K3T32AV",600000,"HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
		
	}

	//특정 금액 이상만 저장
	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		Set<Product> set  = new HashSet<>();
		for(int i=0; i< prodList.length; i++) {
			if(prodList[i].getPrice() >= price) {
				set.add(prodList[i]);
			}
		}
		return (HashSet<Product>) set;
	}

	//makeHashSet으로 부터 받은 hashset정보 출력
	private static void makeFile(HashSet resultList)  {
			resultList.stream().forEach(s -> System.out.println(s));
			try {
				FileOutputStream fw = new FileOutputStream("data.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fw) ;
								
//				oos.writeObject(resultList.stream().forEach(s ->System.out.println(s));
				oos.close();
				fw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	private static void readFile()  {
		
		try {
			FileInputStream fi = new FileInputStream("data.txt");
			ObjectInputStream ois = new ObjectInputStream(fi);
			try {
				Product p = (Product)ois.readObject();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			ois.close();
			fi.close();

		} catch (IOException e1) {
			e1.printStackTrace();
			
		}
		
	}

}


class Product implements Serializable{
	private String model_name;
	private int price;
	private String company;
	
	
	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}


	public String getModel_name() {
		return model_name;
	}


	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price
				+ ", company=" + company + "]";
	}
	
	

}