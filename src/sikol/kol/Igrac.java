package sikol.kol;

public abstract class Igrac implements Runnable {
	protected Thread nit = new Thread(this);
	private String ime;
	private Igra igra;
	private int minT, maxT;
	
	public Igrac(String ime, Igra igra, int minT, int maxT){
		this.ime = ime;
		this.setIgra(igra);
		this.minT = minT;
		this.maxT = maxT;
		nit.start();
	}
	@Override
	public void run() {
		try{
		while(!nit.interrupted())
			{
			getIgra().prijavise(this);
			igraj();
			getIgra().zavrsi(this);
			nit.sleep((int) (minT+ Math.random()*(maxT-minT)));
			}
		
		}
		catch(Exception e){}
	}
	
	public abstract void igraj() throws Exception;
	public String toString(){
		return ime;
	}
	public Igra getIgra() {
		return igra;
	}
	public void setIgra(Igra igra) {
		this.igra = igra;
	}

}
