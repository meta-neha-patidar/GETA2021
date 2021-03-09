package assignment2.seatallocation;


import assignment2.queue.QueueOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

/*
 * @author Neha Patidar
 * @since 09-03-2021
 */
public class StudentClass {
	private List<String> programChoice;
	private String name;
	private QueueOperation <StudentClass> queue;
	private Map<String, Integer> program = new HashMap<String, Integer>();
	private Map<String, String> seatAllotments = new HashMap<String, String>();
	private String filename = ".\\Data\\ProgrameSheet.xls";
	private Workbook wb;
	
	/*
	 * default constructor
	 */
	StudentClass(){}
	
	/*
	 * parameterised constructor
	 * @param nameOfStudent, studentsChoice
	 */
	StudentClass(String nameOfStudent, List<String> studentsChoice){
		this.name = nameOfStudent;
		this.programChoice = studentsChoice;
	}
	public List<String> getProgramsPref() {
		return programChoice;
	}
	public String getName() {
		return name;
	}
	
	public void readInputsFromSheet() throws EncryptedDocumentException, IOException{
		InputStream file = new FileInputStream(filename);
		wb = WorkbookFactory.create(file);
		
		Sheet studentSheet = wb.getSheet("StudentSheet");
		
		int noOfStudents = studentSheet.getLastRowNum();
		
		queue = new QueueOperation <StudentClass> (noOfStudents);
		
		for(int rowIndex = 1 ; rowIndex <= noOfStudents; rowIndex++){
			
			List<String> studBranchPre = new ArrayList<String>();
			
			Row row = studentSheet.getRow(rowIndex);
			int noOfChoices = row.getLastCellNum();
			String studentName = row.getCell(0).toString();
			
			for(int colIndex = 1; colIndex < noOfChoices; colIndex++){
				studBranchPre.add(row.getCell(colIndex).getStringCellValue());
			}
			queue.enqueue(new StudentClass(studentName, studBranchPre));
			//System.out.println("Student name " + studentName);
		}
		Sheet collegeSheet = wb.getSheet("CollegeProgramSheet");
		
		for(int index = 1; index <= collegeSheet.getLastRowNum(); index++){
			String programName = collegeSheet.getRow(index).getCell(0).getStringCellValue();
			int noOfSeats = (int)collegeSheet.getRow(index).getCell(1).getNumericCellValue();
			program.put(programName, noOfSeats);
			//System.out.println(programName+noOfSeats);
		}
		file.close();
		
	}
	
	public void processData(){
		while(!queue.isEmpty()){
			StudentClass studentClass = queue.dequeue();
			for(String programName: studentClass.getProgramsPref()){
				int noOfSeats = program.get(programName);
				
				if(noOfSeats >= 1){
					seatAllotments.put(studentClass.getName(), programName);
					program.replace(programName, noOfSeats -1);
					
					System.out.println(studentClass.getName()+programName);
					break;
				}
			}
			if(!seatAllotments.containsKey(studentClass.getName()))
				seatAllotments.put(studentClass.getName(), "Seat Not alloted");
		}
	}
	
	public void writeOutputsToSheet() throws IOException{
		Sheet seatAllote = wb.getSheet("SeatsAllotedData");
		if(seatAllote == null){
			seatAllote = wb.createSheet("SeatsAllotedData");
		}
		int rowIndex = 0;
		Row rowName = seatAllote.createRow(rowIndex++);
		
		rowName.createCell(0).setCellValue("NameOfStudent");
		rowName.createCell(1).setCellValue("Branch Alloted");
		
		for(String name : seatAllotments.keySet()){
			Row row = seatAllote.createRow(rowIndex++);
			row.createCell(0).setCellValue(name);
			row.createCell(1).setCellValue(seatAllotments.get(name));
		}
		
		FileOutputStream outPutFile = new FileOutputStream(filename);
		wb.write(outPutFile);
		outPutFile.close();
		wb.close();
		
	}
	
	public static void main(String[] args){
		StudentClass object = new StudentClass();
		try {
			System.out.println("input read=============");
			object.readInputsFromSheet();
			System.out.println("dataProcess============");
			object.processData();
			System.out.println("outputFileCreating=====");
			object.writeOutputsToSheet();
			System.out.println("completed.=============");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
