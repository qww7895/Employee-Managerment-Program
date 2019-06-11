package wageManagementSystem;

public class Calculator {
	private int level;
	Calculator(){

	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int income() {
		int incomeVal = level*100*12;
		if(incomeVal<=1200) {
			incomeVal -= incomeVal*6/100;
			return incomeVal;
		}else if(incomeVal<=2400) {
			incomeVal -= incomeVal*15/100;
			return incomeVal;
		}else if(incomeVal<=3600) {
			incomeVal -= incomeVal*24/100;
			return incomeVal;
		}else if(incomeVal<=4800) {
			incomeVal -= incomeVal*35/100;
			return incomeVal;
		}else {
			incomeVal -= incomeVal*38/100;
			return incomeVal;
		}
	}
}
