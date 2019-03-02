package sikol.kol;

public class Ucenik extends Igrac {

	
	public Ucenik(String ime, Igra igra, int minT, int maxT) {
		super(ime, igra, minT, maxT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void igraj() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep((int) this.getIgra().trajanje());
	}

}
