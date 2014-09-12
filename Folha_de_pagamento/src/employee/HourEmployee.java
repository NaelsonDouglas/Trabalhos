package employee;

public class HourEmployee extends Employee {
	
	
	private double hour_work_cost;
	
	


	
	
	public HourEmployee(String _name, int _labor_type, boolean _sindicalist, double hour_cost) {
		super(_name, _labor_type, _sindicalist, "17/06/1993 08:40", 18); //datas recebendo inline para teste
		this.setHour_work_cost(hour_cost);		
	}
	
	
	public double getHour_work_cost() {
		return this.hour_work_cost;
	}

	public void setHour_work_cost(double hour_work_cost) {
		this.hour_work_cost = hour_work_cost;
	}	
	
	
	
	public double getTime_worked_today() {
		return this.time_worked_today;
	}


	

	
	
	@Override
	public void setAmount_owned() {
		this.amount_owned = ((this.getTime_worked_today()/8) * this.getHour_work_cost()) + ((this.getTime_worked_today()%8) * 1.5*this.getHour_work_cost());
	}	


	public static void main(String[] args){
		Employee teste = new HourEmployee("Abdul Lathef Al Khaliffa", 1, true, 10);		
		teste.CallsetCheckin_time("00:00");
		teste.CallsetCheckout_time("08:00");		
		teste.printInfo();		
	}
}

