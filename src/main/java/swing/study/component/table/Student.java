package swing.study.component.table; //논리적사고력 필요! 코드를 그대로 가져다쓰면안된당. 이해하고써야함!

public class Student {
	private int stdNo;
	private String stdName;
	private int kor;
	private int eng;
	private int math;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int stdNo) {
		this.stdNo = stdNo;
	}

	public Student(int stdNo, String stdName, int kor, int eng, int math) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return kor + eng + math;
	}

	public double getAvg() {
		return getTotal() / 3D;
	}

	@Override
	public String toString() {
		return String.format(
				"Student [stdNo=%s, stdName=%s, kor=%s, eng=%s, math=%s, getStdNo()=%s, getTotal()=%s, getAvg()=%s]",
				stdNo, stdName, kor, eng, math, getStdNo(), getTotal(), getAvg());
	}

}
