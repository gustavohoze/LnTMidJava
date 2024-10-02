package main;

import java.util.*;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	static ArrayList<Karyawan> karyawans = new ArrayList<>();
	
	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String generateCode(){
		String code = "";
		while(code.length()<2) {	
			code += alphabet.charAt(rd.nextInt(alphabet.length()));
		}
		code += "-";
			int randInt = rd.nextInt(9999);
		return code += String.format("%04d", randInt);
	}
	
	public static boolean isNotDupe(ArrayList<Karyawan> karyawan, String code) {
		for(Karyawan k : karyawan) {
			if(k.getCode() == code) {
				return false;
			}
		}
		return true;
	}
	
	public static String generateUnique(ArrayList<Karyawan> karyawan, Karyawan karyawans) {
		String code;
		do {
			code = generateCode();
		}while(isNotDupe(karyawan, code) != true);
		return code;
	}	
	
	public static void menu() {
		System.out.println("1. Insert data karyawan");
		System.out.println("2. View data karyawan");
		System.out.println("3. Update data karyawan");
		System.out.println("4. Delete data karyawan");
		System.out.println("5. Exit");
	}

	public static void main(String[] args) {
		int option = 0;
		int optionUpdate = 0;
		int optionDelete = 0;
		String employeeCode = "";
		String employeeName = "";
		String employeeGender = "";
		String employeeRole = "";
		int employeeSalary;
		
		while(option !=5) {
			menu();
			System.out.print(">> ");
			try {
				option = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}
			sc.nextLine();
			Collections.sort(karyawans, Comparator.comparing(Karyawan::getName));
			switch(option) {
				case 1:
					do{
						System.out.print("Input nama karyawan [>=3]: ");
						employeeName = sc.nextLine();
					}while(employeeName.length()<3);
					
					
					do {
						System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case sensitive): ");
						employeeGender = sc.nextLine();
					}while(!employeeGender.equals("Perempuan") && !employeeGender.equals("Laki-laki") );
					
					do {
						System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case sensitive): ");
						employeeRole = sc.nextLine();
					}while(!employeeRole.equals("Manager") && !employeeRole.equals("Supervisor") &&  !employeeRole.equals("Admin"));
					employeeSalary = rd.nextInt(9999, 99999);
					Karyawan karyawanFactory = new Karyawan(null, employeeName, employeeGender, employeeRole, employeeSalary);
					employeeCode = generateUnique(karyawans, karyawanFactory);
					karyawanFactory.setCode(employeeCode);
					karyawans.add(karyawanFactory);
					System.out.printf("Berhasil menambahkan karaywan dengan id %s \n" , employeeCode);
					if(karyawans.size() % 3 == 1 && karyawans.size() != (1 | 2 | 3)) {
						for(Karyawan k : karyawans) {
							if(k.getRole() == "Admin") {
								k.setSalary(k.getSalary() * 105 / 100);
							}else if(k.getRole() == "Supervisor") {
								k.setSalary(k.getSalary() * 1075 / 1000);
							}else {
								k.setSalary(k.getSalary() * 110 / 100);
							}
							
						}
					}
					break;
				case 2:
					if(karyawans.size()>0) {
						int i =0;
						for(Karyawan karyawan : karyawans) {
							++i;
							System.out.println(i + ". " +karyawan.getCode() + " - " + karyawan.getName() + " - " + karyawan.getRole() + " - "+ karyawan.getGender() + " - " + karyawan.getSalary());
						}
					}
					break;
				case 3:
					if(karyawans.size()>0) {
						int i=0;
						for(Karyawan karyawan : karyawans) {
							++i;
							System.out.println(i + ". " + karyawan.getCode() + " - " + karyawan.getName() + " - " + karyawan.getRole() + " - "+ karyawan.getGender() + " - " + karyawan.getSalary());
						}
						
						do {
							System.out.print("Input nomor karyawan yang ingin diupdate >> ");
							try {
								optionUpdate = sc.nextInt();
							} catch (Exception e) {
								// TODO: handle exception
							}
							sc.nextLine();
							
							
						}while(optionUpdate > karyawans.size());
						Karyawan curr = karyawans.get(optionUpdate - 1);
						do{
							System.out.print("Input nama karyawan [>=3]: ");
							employeeName = sc.nextLine();
						}while(employeeName.length()<3 && !employeeName.equals("0"));
						
						do {
							System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case sensitive): ");
							employeeGender = sc.nextLine();
						}while(!employeeGender.equals("Perempuan") && !employeeGender.equals("Laki-laki") && !employeeGender.equals("0"));
						
						do {
							System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case sensitive): ");
							employeeRole = sc.nextLine();
							
						}while(!employeeRole.equals("Manager") && !employeeRole.equals("Supervisor") &&  !employeeRole.equals("Admin") && !employeeRole.equals("0"));
						
						if(!employeeName.equals("0")) {
							curr.setName(employeeName);
						}else {
							curr.setName(curr.getName());
						}
						
						if(!employeeGender.equals("0")) {
							curr.setGender(employeeGender);
						}else {
							curr.setGender(curr.getGender());
						}
						
						if(!employeeRole.equals("0")) {
							curr.setRole(employeeRole);
						}else {
							curr.setRole(curr.getRole());
						}
						
						System.out.println("Berhasil mengupdate karyawan dengan id " + curr.getCode());
					}
					

					break;
				case 4:
					if(karyawans.size() > 0) {
						for(Karyawan k: karyawans) {
							int i=0;
							for(Karyawan karyawan : karyawans) {
								++i;
								System.out.println(i + ". " + karyawan.getCode() + " - " + karyawan.getName() + " - " + karyawan.getRole() + " - "+ karyawan.getGender() + " - " + karyawan.getSalary());
							}
						}
						do {
							System.out.print("Input nomor karyawan yang ingin dihapus >> ");
							try {
								optionDelete = sc.nextInt();
							} catch (Exception e) {
								// TODO: handle exception
							}
							sc.nextLine();
						}while(optionDelete > karyawans.size());
						karyawans.remove(optionDelete - 1);
					}
					
					break;
				default:
					break;
			}
			
			

		}
		
		
		
		
		
		
	}

}
