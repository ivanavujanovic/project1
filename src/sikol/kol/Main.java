package sikol.kol;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Igra igra = new ObrazovnaIgra(2,1000, "KVIZ");
			int brIgraca = 5;
			Igrac [] igraci = new Igrac [brIgraca];
			for(int i=0; i< igraci.length;i++){
				igraci[i] = new Ucenik("ucenik_"+i, igra,100*i, 200+100*i);}
			Thread.sleep(1000);
			System.out.println(igra);
			for(int i=0;i<brIgraca;i++){
				igraci[i].nit.interrupt();
			}
		}
		catch(Exception e) {}
	}

}
