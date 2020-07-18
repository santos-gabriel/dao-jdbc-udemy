package aplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("== TEST 1: seller findById");
		Seller seller = sellerDao.findById(3);
		System.out.print(seller);
		
		System.out.println("\n== TEST 1: seller findByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(n -> System.out.println(n));
		
		System.out.println("\n== TEST 1: seller findByAll");
		list = sellerDao.findAll();
		list.forEach(n -> System.out.println(n));
		
		System.out.println("\n===TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = "+ newSeller.getId());
		
		System.out.println("\n===TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n===TEST 6: seller delete ===");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete competed ");
		sc.close();
		
	}

}
