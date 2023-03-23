package exam.answer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class Prob4 {

	public static void main(String[] args) {
		Product[] prodList = { new Product("NT450R5E-K24S", 500000, "삼성전자"),
				new Product("15UD340-LX2CK", 400000, "LG전자"), new Product("G2-K3T32AV", 600000, "HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();

	}

	// 특정 금액 이상만 저장
	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		HashSet<Product> plist = new HashSet<>();
		for (Product pro : plist) {
			if (pro.getPrice() >= price) {
				plist.add(pro);
				System.out.println(pro);
			}
		}
		return plist;
	}

	// makeHashSet으로 부터 받은 hashset정보 출력
	private static void makeFile(HashSet<Product> resultList) {
		try (// try() 에 넣으면, 조건 끝난 후 스트림이 자동으로 닫힘
				FileOutputStream fos = new FileOutputStream("data.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			for (Product pro : resultList) {
				oos.writeObject(pro);
			}
		} catch (IOException e) {

		}

	}

	private static void readFile() {

		try (FileInputStream fis = new FileInputStream("data.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);)
		{
			while(true) {
				try {
					Object obj = ois.readObject();
					if(obj instanceof Product pro) {
						System.out.println(pro);
					}
				}catch (EOFException e) {

				}
					
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Product implements Serializable {
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
		return "Product [model_name=" + model_name + ", price=" + price + ", company=" + company + "]";
	}

}