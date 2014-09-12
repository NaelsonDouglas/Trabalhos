package employee;
import java.util.Date; //Pacote para o programa entender datas
import java.text.ParseException;
import java.text.SimpleDateFormat; //Pacote para o programa converter uma entrada "yyyy/MM/dd HH:mm:ss" em um tipo Date


public abstract class Employee {	
	 private String name;
	 protected double amount_owned;
	 private int labor_type; 
	 private boolean sindicalist;	 
	 private Date admission_day;
	 private int payment_day;
	 private Date checkin_time;
	 private Date checkout_time;
	 protected double time_worked_today;
	 
	 
	 
	//Construtor
	public Employee(String _name, int _labor_type, boolean _sindicalist, String _admission_day, int _payment_day)
	 {
		 setName(_name);		 
		 setLabor_type(_labor_type);
		 setSindicalist(_sindicalist);
		 callSetAdmission_day(_admission_day);
		 setPayment_day(_payment_day);
	 }
	
	//Gets e sets
	public void setName(String _name)
	{
		this.name = _name;
	}
	
	public String getName()
	{
		return name;
	}
	

	public String getLabor_type() {
		switch (labor_type)
		{
		case (1) : return "Horista"; 
		case (2) : return "Assalariado";
		case (3) : return "Comissionados";
		}
		return null;		
	}

	public void setLabor_type(int labor_type) {
		this.labor_type = labor_type;
	}

	public boolean getSindicalist() {
		return sindicalist;
	}

	public void setSindicalist(boolean sindicalist) {
		this.sindicalist = sindicalist;
	}

	
	//Recebe uma string no modelo dd-MM-yyy hh:mm, converte ela para simpleDateFormat e em seguida converte para Date(recebe valores em milise
	public boolean callSetAdmission_day(String input) 
	{
		SimpleDateFormat input_on_simple_date = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		try {
			Date date_admission = input_on_simple_date.parse(input);
			setAdmission_day(date_admission);
			return true; //O retorno serve para dizer se a entrada estava bem formatada
		} catch (ParseException e) {			
			e.printStackTrace();
			return false;
		}			
	}
	
	public void setAdmission_day(Date admission_day) {
		this.admission_day = admission_day;
	}
	
	public Date getAdmission_day() {
		return admission_day;
	}
	
		
	public void setPayment_day(int payment_day) {
		this.payment_day = payment_day;
	}	

	public int getPayment_day() {
		return payment_day;
	}
	
	
	
	
	public boolean CallsetCheckin_time(String _checkin_hour)
	{
		SimpleDateFormat input_on_simple_date = new SimpleDateFormat("hh:mm");
		try {
			Date _checkin_time = input_on_simple_date.parse(_checkin_hour);
			this.setCheckin_time(_checkin_time);
			return true; //O retorno serve para dizer se a entrada estava bem formatada
		} catch (ParseException e) {			
			e.printStackTrace();
			return false;
		}		
		
	}
	
	public boolean CallsetCheckout_time(String _checkout_hour)
	{
		SimpleDateFormat input_on_simple_date = new SimpleDateFormat("hh:mm");
		try {
			Date _checkout_time = input_on_simple_date.parse(_checkout_hour);
			this.setCheckout_time(_checkout_time);			
			return true; //O retorno serve para dizer se a entrada estava bem formatada
		} catch (ParseException e) {			
			e.printStackTrace();
			return false;
		}		
		
	}
	
	public double getWorked_time_today() {
		return time_worked_today;
	}

	public void setWorked_time_today(double _worked_time_today) {
		this.time_worked_today = _worked_time_today;
		
	}
	
	public Date getCheckin_time() {
		return checkin_time;
	}

	public void setCheckin_time(Date checkin_time) {
		this.checkin_time = checkin_time;
	}

	public Date getCheckout_time() {
		return checkout_time;
	}

	public void setCheckout_time(Date checkout_time) {
		this.checkout_time = checkout_time;
		
		double time_checkout = checkout_time.getTime(); //Esse get retorna a quantiade de milisecs entre a data de checkin e uma outra data lá dos anos 70 
		double time_checkin = this.checkin_time.getTime();
		double diff = time_checkout - time_checkin;
		this.setTime_worked_today(diff);
		this.setAmount_owned();
		//Converte a diferença entre o tempo de entrada e saída de milisecs para horas.
		diff = ((diff / (1000*60*60)) % 24);
		this.setAmount_owned();
		double rest =  (diff%1) * 0.6;
		diff = (int) diff;
		diff += rest;		
		this.setWorked_time_today(diff); //Da set na quantidade de horas trabalhadas	
		
		this.setAmount_owned();
	}
	
	//Fim dos gets e sets	
	public abstract void setAmount_owned();
	
	public double getAmount_owned() {
		return this.amount_owned;
	}
	
		
	
	public void printInfo()
	{
		System.out.println("Nome: "+getName()+
							"\nRegimento: "+getLabor_type()+
							(getSindicalist()  ? "\nAfiliado ao sindicato" : "\nNão afiliado ao sindicato")+
							"\nData de admissão: "+admission_day.toString()+
							"\nData de pagamento: "+this.payment_day+
							"\nTrabalhou "+this.getWorked_time_today()+" horas hoje"+							
							"\nDinheiro a ser pago:"+this.getAmount_owned());
	}

	public double getTime_worked_today() {
		return this.time_worked_today;		
	}
	
	public void setTime_worked_today(double _time_worked_today) {
		this.time_worked_today = _time_worked_today;
	}	



}













