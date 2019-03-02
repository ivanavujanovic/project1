package sikol.kol;

public class ObrazovnaIgra extends Igra {
	private String naziv;
	
	public ObrazovnaIgra (int ukupanBroj, int maxT, String naziv){
		super(ukupanBroj, maxT);
		this.naziv = naziv;
	}
	
	@Override
	public boolean istiTip(Igrac i) {
		// TODO Auto-generated method stub
		if(i instanceof Ucenik) return true;
		return false;
	}

	@Override
	public String naziv() {
		// TODO Auto-generated method stub
		return this.naziv;
	}

}
