package dateP;

public class Date {
	/* Data fields */
	private int YEAR;
	private int MONTH;
	private int DAY;
	
	/* String correspondent used for displaying months */
	String[] MONTHNAMES = {"January", "February", "March", "April", 
			"May", "June", "July", "August", "September", 
			"October", "November", "December"};

	//
	// CONSTRUCTOR 
	//
	public Date(int year, int month, int day) { 
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	/**
	 * Check validity of the day when creating a new Date. 
	 * DAY must be greater or equal to 1 and
	 *   - less or equal to 31 for months with 31 days
	 *   - less or equal to 30 for months with 30 days, 
	 *   - less or equal to 29 for February if YEAR is leap
	 *   - less or equal to 30 for February if YEAR is non-leap
	 */	
	private void setDay(int day) {
		if (day < 1) {
			throw new IllegalArgumentException( "DAY must greater or equal to 1." );
		}
		if (day > 31){
			throw new IllegalArgumentException( "DAY must less or equal to 31." );
		}
		if (isThirtyDayMonth() && day > 30) {
			throw new IllegalArgumentException( "DAY must less than 30 for month " + monthName());
		}
		if (isFebruary() && isLeapYear() && day > 29) {
			throw new IllegalArgumentException( "DAY must less than 29 for month " + monthName() + " on a leap year.");
		}	
		if (isFebruary() && !isLeapYear() && day > 28) {
			throw new IllegalArgumentException( "DAY must less than 28 for month " + monthName() + " on a non leap year.");
		}
		this.DAY = day;
	}

	/**
	 * Check validity of the month when creating a new Date. MONTH must be between 1 and 12.
	 */
	private void setMonth(int month) {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException( "MONTH must be between 1 and 12." );
		}
		this.MONTH = month;
	}

	/**
	 * Check validity of the year when creating a new Date. YEAR must be greater than 0
	 */
	private void setYear(int year) {
		if (year < 0) {
			throw new IllegalArgumentException( "YEAR must be greater or equal to 0." );
		}
		this.YEAR = year;
	}

	
	// GETTERS and SETTERS
	public int getYEAR() {
		return YEAR;
	}

	public void setYEAR(int yEAR) {
		YEAR = yEAR;
	}

	public int getMONTH() {
		return MONTH;
	}

	public void setMONTH(int mONTH) {
		MONTH = mONTH;
	}

	public int getDAY() { 
		return DAY;
	}

	public void setDAY(int dAY) {
		DAY = dAY;
	}

	// Class methods
	/**
	 * Returns the date of the day following that date.
	 * 
	 */
	public Date nextDate() {
		int nextYear = YEAR, nextMonth = MONTH, nextDay = DAY+1;
		if (isEndOfMonth()) {
			nextDay = 1;
			if (MONTH == 12) {
				nextYear++;
				nextMonth = 1;
			} else {
				nextMonth++;
			}
		} 
		return new Date(nextYear, nextMonth, nextDay);
	}

	/**
	 * 
	 * Check if the date is a end of a month.
	 */
	private boolean isEndOfMonth() {
		boolean leap = isLeapYear();
		if (DAY == 31 || (DAY == 30 && isThirtyDayMonth()) || 
				(isFebruary() && ((DAY == 29 && leap) || (DAY == 28 && !leap))))
			return true;
		else return false;
	}


	/**
	 * returns true if MONTH is February.
	 */	
	private boolean isFebruary() {
		return this.MONTH == 2;
	}

	/**
	 * returns true if MONTH has 30 days.
	 */	
	private boolean isThirtyDayMonth() {
		if (this.MONTH == 4 || this.MONTH == 6 || this.MONTH == 9 || this.MONTH == 11)
			return true;
		else return false;
	}

	/**
	 * returns true if YEAR is leap.
	 * A leap year is divisible by 4 unless it is a century year. In that case, it must be divisible by 400.
	 */	
	public boolean isLeapYear() {
		if (YEAR % 100 == 0) {
			return YEAR % 400 == 0;
		}
		return YEAR % 4 == 0;
	}
 
	/**
	 * Returns the name of MONTH
	 */
	private String monthName() {
		return MONTHNAMES[MONTH-1];
	}
	
	public String toString() {
		return YEAR + "/" + monthName() + "/" + DAY;
	}
	
	public boolean equals(Object obj) {
		if (! (obj instanceof Date)) return false;
		Date od = (Date)obj;
		return YEAR == od.getYEAR() && MONTH == od.getMONTH()  && DAY == od.getDAY();
	}

}
