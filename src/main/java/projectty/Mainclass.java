package projectty;

import java.util.Scanner;

public class Mainclass {
	public static void main(String[] args) throws Exception {

		User us = new User();
		UerCRUD uu = new UerCRUD();
		Feedback ff = new Feedback();

		Scanner sc = new Scanner(System.in);

		boolean b = true;
		while (b) {
			System.out.println("1.Signup  2.Login  3.Logout");
			int a = sc.nextInt();

			switch (a) {
			case 1: {
				System.out.println("Enter the SL no");
				int slno = sc.nextInt();
				System.out.println("Enter the First name");
				String first_name = sc.next();
				System.out.println("Enter the Last name");
				String last_name = sc.next();
				System.out.println("Enter the Gender");
				String gender = sc.next();
				System.out.println("Enter the Phone");
				long phone = sc.nextLong();
				System.out.println("Enter the DOB");
				String DOB = sc.next();
				System.out.println("Enter the email");
				String email = sc.next();
				System.out.println("Enter the password");
				String password = sc.next();

				{
					System.out.println("1.Submit  2.Exit");
					int d = sc.nextInt();
					switch (d) {
					case 1: {
						us.setSlno(slno);
						us.setFirst_name(first_name);
						us.setLast_name(last_name);
						us.setGender(gender);
						us.setPhone(phone);
						us.setDOB(DOB);
						us.setEmail(email);
						us.setPassword(password);

						uu.Signup(us);

						break;
					}
					case 2: {

						break;
					}
					}
				}
				break;
			}

			case 2: {
				System.out.println("Enter the email");
				String email = sc.next();
				System.out.println("Enter the password");
				String password = sc.next();

				boolean ans = uu.Login(email, password);

				if (ans == true) {
					System.out.println("Login Successfull\n\n");

					System.out.println("enter the status");
					String feedback = sc.nextLine();
					feedback += sc.nextLine();

					System.out.println("Status upload successfully");
					uu.Status(email);

				} else {
					System.out.println("Invalid email or Password");

				}
				break;

			}

			case 3: {
				System.out.println("Thank you");
				break;
			}

			default:
				System.out.println("ivalid entry");

				b = false;
			}

		}
	}
}
