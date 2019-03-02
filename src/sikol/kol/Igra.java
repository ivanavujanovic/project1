package sikol.kol;

public abstract class Igra {
	private Igrac [] igraci;
	private static enum Stanje {NIJE_ZAPOCETA, U_TOKU};
	private Stanje stanje = Stanje.NIJE_ZAPOCETA;
	private int ukupanBroj;
	private int brojIgraca = 0;
	private int maxT;
	private int t;
	
	public Igra(int ukupanbroj, int maxT){
		igraci = new Igrac[ukupanbroj];
		this.ukupanBroj = ukupanbroj;
		this.maxT = maxT;
		
		
	
	}
	
	public synchronized void prijavise(Igrac i){
		if(this.istiTip(i)) {
			try{
				this.proveri();
				brojIgraca ++;
				this.dodaj(i);
				
			}
			catch(Exception e) {}
		}
	}
	
	public abstract boolean istiTip(Igrac i);
	private void proveri() throws InterruptedException {
		while(stanje == Stanje.U_TOKU || brojIgraca > this.ukupanBroj){
			wait();
		}
		if(stanje == Stanje.NIJE_ZAPOCETA && brojIgraca < ukupanBroj ){
			notifyAll();
		}
	}
	
	private void dodaj (Igrac i){
		int brojac;
		for(brojac=0;brojac<igraci.length;brojac++){
			if(igraci[brojac] == null) {
				igraci[brojac]= i;
				return;
			}
		}
		brojIgraca++;
		if(brojIgraca == 1) t = (int) Math.random()*maxT;
		if(brojIgraca == ukupanBroj) {
			stanje = Stanje.U_TOKU;
			}		
	}
	
	public synchronized void zavrsi(Igrac igrac){
		for(int i=0;i<brojIgraca;i++){
			if(igraci[i] ==igrac) this.izbaci(i);
		}
	}
	
	public void izbaci(int i){
		igraci[i] = null; 
		this.brojIgraca--;
		if(brojIgraca == 0){
			stanje = Stanje.NIJE_ZAPOCETA;
			t = 0;
			notifyAll();
		}
	}
	
	
	
	public synchronized Stanje stanje(){return stanje;}
	public synchronized int trajanje(){return t;}
	public abstract String naziv();
	
	public synchronized String toString(){
		StringBuffer s = new StringBuffer();
		s.append(naziv()).append(" - ")
		.append(stanje()).append('\n');
		for(int i=0; i< igraci.length;i++){
			if(igraci[i] != null) s.append(igraci[i]);
			else s.append("prazno");
		}
		return s.toString();
	}
	
}
