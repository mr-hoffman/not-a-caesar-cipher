class Main {
  public static void main(String[] args) {
    System.out.println();
		Cipher cipher1 = new Cipher(4, 5);
		System.out.println(cipher1.encryptMessage("Hilbert Wolves"));

		System.out.println();

		Cipher cipher2 = new Cipher(3, 2);
		System.out.println(cipher2.encryptMessage("Robots"));

		System.out.println();

		Cipher cipher3 = new Cipher(6, 2);
		System.out.println(cipher3.encryptMessage("My country 'tis of thee, Sweet land of liberty. Of thee I sing."));
		
		System.out.println();
		System.out.println("Ha - take that you cheater!");

  }
}