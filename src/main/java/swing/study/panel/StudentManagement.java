package swing.study.panel;

import java.util.List;

public class StudentManagement {  //////여기에 점수도 들어가있어야한다!!!! 한꺼번에 3과목이어야하니까 배열이나 리스트로 받아오기!!!!!!!!!!!!!!
	private int stdNo; //학번
	private String stdName; //이름
	private String deptName;  //학과이름
	private int grade;  //학년	
	private String stateName;  //학적구분

	private String militaryName; //병역구분(미필 등)
	
	private String idNo;	//주민번호
	private String hpNo;	//휴대폰번호
	private String dayNighShift;	//주야
	
	
	
	
	
	public StudentManagement(int stdNo) {
		this.stdNo = stdNo;
	}





	public StudentManagement(int stdNo, String stdName, String deptName, int grade, String stateName,
			String militaryName, String idNo, String hpNo, String dayNighShift) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.deptName = deptName;
		this.grade = grade;
		this.stateName = stateName;
		this.militaryName = militaryName;
		this.idNo = idNo;
		this.hpNo = hpNo;
		this.dayNighShift = dayNighShift;
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





	public String getDeptName() {
		return deptName;
	}





	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}





	public int getGrade() {
		return grade;
	}





	public void setGrade(int grade) {
		this.grade = grade;
	}





	public String getStateName() {
		return stateName;
	}





	public void setStateName(String stateName) {
		this.stateName = stateName;
	}





	public String getMilitaryName() {
		return militaryName;
	}





	public void setMilitaryName(String militaryName) {
		this.militaryName = militaryName;
	}





	public String getIdNo() {
		return idNo;
	}





	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}





	public String getHpNo() {
		return hpNo;
	}





	public void setHpNo(String hpNo) {
		this.hpNo = hpNo;
	}





	public String getDayNighShift() {
		return dayNighShift;
	}





	public void setDayNighShift(String dayNighShift) {
		this.dayNighShift = dayNighShift;
	}





	@Override
	public String toString() {
		return String.format(
				"StudentManagement [stdNo=%s, stdName=%s, deptName=%s, grade=%s, stateName=%s, militaryName=%s, idNo=%s, hpNo=%s, dayNighShift=%s]",
				stdNo, stdName, deptName, grade, stateName, militaryName, idNo, hpNo, dayNighShift);
	}
	
//수정중
//	private  List<StudentScore> studentScore;  //성적(과목 1,2,3)
//	private  List<GradeConvertion> gradeConvertion;
	//end
	
	
	
	
	

//	@Override
//	public String toString() {
//		return String.format(
//				"StudentManagement [stdNo=%s, stdName=%s, deptCode=%s, grade=%s, stateCode=%s, militaryCode=%s, idNo=%s, hpNo=%s, dayNighShift=%s, studentScore=%s, gradeConvertion=%s]",
//				stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo, dayNighShift, studentScore,
//				gradeConvertion);
//	}






	
	
	
	

	
}
