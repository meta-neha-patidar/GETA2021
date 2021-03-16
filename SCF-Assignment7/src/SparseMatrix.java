import java.util.*;

/*
 * @author Neha Patidar
 */
public class SparseMatrix {
	final int[][] sparseMatrix;
	final int noOfRows, noOfColumns, noOfNoneZeros;
	
	/*
	 * Parameterized constructor
	 * @param matrix
	 */
	
	SparseMatrix(int nonZero,int [][]matrix){
		
		this.sparseMatrix = new int[nonZero][3];
		this.noOfRows = matrix.length;
		int tempVar = 0;
		if(noOfRows != 0){
			this.noOfColumns = matrix[0].length;
			
			for(int rowIndex = 0; rowIndex < noOfRows; rowIndex++){
				for(int colIndex = 0; colIndex < matrix[0].length; colIndex++){
					if(matrix[rowIndex][colIndex] != 0){
						sparseMatrix[tempVar][0] = rowIndex;
						sparseMatrix[tempVar][1] = colIndex;
						sparseMatrix[tempVar][2] = matrix[rowIndex][colIndex];
						tempVar++;
					}
				}
			}	
		}
		else{
			this.noOfColumns = 0;
		}
		this.noOfNoneZeros = tempVar;
	}
	/*
	 *@return this.sparseMatrix
	 */
	public int[][] getSparse(){
		return this.sparseMatrix;
	}
	/*
	 * transpose of the matrix
	 * @return transposeMatrix
	 */
	public int[][] getTranspose(){
		int [][] transposeMatrix =null;
		if(noOfRows == noOfColumns){
			transposeMatrix = new int[noOfNoneZeros][3];
			for(int index = 0; index < noOfNoneZeros; index++){
				// swap row no with column no
				transposeMatrix[index][0] = sparseMatrix[index][1];
				transposeMatrix[index][1] = sparseMatrix[index][0];
				transposeMatrix[index][2] = sparseMatrix[index][2];
			}
		}
		return transposeMatrix;
	}
	static boolean isSymmetricalMatrix(int array[][]){
		if(array == null || array.length == 0){
			System.out.println("Operation can't perform");
			return false;
		}
		if(array.length != array[0].length){
			return false;
		}
		for(int row = 0;row < array.length; row++){
			for(int col = 0; col < array[0].length; col++){
				if(array[row][col] != array[col][row]){
					return false;
				}
			}
		}
		
		return true;
	}
	
	/*
	 * @param matrix1, matrix2
	 * @return resultMatrix
	 */
	public static int[][] addMatrices(int[][] matrix1,int[][]matrix2){
		int resultMatrix [][] = null;
		
		if(matrix1 != null && matrix2 != null){
			if(matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length){
				resultMatrix = new int[matrix1.length][matrix1[0].length];
				for(int rowIndex = 0; rowIndex < matrix1.length; rowIndex++){
					for(int colIndex = 0; colIndex < matrix1[rowIndex].length; colIndex++){
						resultMatrix[rowIndex][colIndex] = matrix1[rowIndex][colIndex] + matrix2[rowIndex][colIndex];
					}
				}
			}
		}
		return resultMatrix;
	}
	
	/*
	 * @param matrix1, matrix2
	 * @return resultMatrix
	 */
	public static int[][] multiplyMatrices(int[][]matrix1, int[][]matrix2){
		int [][] resultMatrix = null;
		if(matrix1 != null && matrix2 != null){
			if(matrix1[0].length == matrix2.length){
				resultMatrix = new int[matrix1.length][matrix2[0].length];
				for(int rowIndex = 0; rowIndex < matrix1.length; rowIndex++){
					for(int  rowColInd = 0; rowColInd < matrix2.length; rowColInd++){
						resultMatrix[rowIndex][rowColInd] = 0;
						for(int colIndex = 0;colIndex < matrix2[0].length; colIndex++){
							resultMatrix[rowIndex][rowColInd] += matrix1[rowIndex][colIndex] * matrix2[colIndex][rowColInd];
						}
					}
				}
			}
		}
		return resultMatrix;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 0 to stop performing any operation");
		System.out.println("Enter 1 to perform transpose the sparse matrix");
		System.out.println("Enter 2 to check if matrix is symmetric or not");
		System.out.println("Enter 3 to add two matrix");
		System.out.println("Enter 4 to multiply 2 matrix");
		int operationCase = scanner.nextInt();
		while(operationCase != 0){
			if(operationCase == 1){
				//getTranspose()
				int rows, columns, array[][];
				System.out.println("Enter Number of rows and columns");
				rows = scanner.nextInt();
				columns = scanner.nextInt();
				array = new int[rows][columns];
				int nonZero = 0;
				for(int rowIndex = 0; rowIndex < rows; rowIndex++){
					for(int columnIndex = 0;columnIndex < columns; columnIndex++){
						array[rowIndex][columnIndex] = scanner.nextInt();
						if(array[rowIndex][columnIndex] != 0){
							nonZero++;
						}
					}
				}
				SparseMatrix object = new SparseMatrix(nonZero,array);
				int [][]sparse = object.getSparse();
				for(int i = 0 ; i < sparse.length;i++){
					for(int j = 0; j < 3;j++){
						System.out.print(sparse[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println("Transpose");
				int[][] transpose = object.getTranspose();	
				for(int i = 0 ; i < transpose.length;i++){
					for(int j = 0; j < 3;j++){
						System.out.print(transpose[i][j] + " ");
					}
					System.out.println();
				}
			}
			else if (operationCase == 2){
				// isSymmetricalMatrix()
				int rows, columns, array[][];
				System.out.println("Enter Number of rows and columns");
				rows = scanner.nextInt();
				columns = scanner.nextInt();
				array = new int[rows][columns];
				int nonZero = 0;
				for(int rowIndex = 0; rowIndex < rows; rowIndex++){
					for(int columnIndex = 0;columnIndex < columns; columnIndex++){
						array[rowIndex][columnIndex] = scanner.nextInt();
						if(array[rowIndex][columnIndex] != 0){
							nonZero++;
						}
					}
				}
				
				System.out.println("Given matrix a symmetric or not : " + isSymmetricalMatrix(array));
			}else if(operationCase == 3){
				
				int rows1, columns1, array1[][], rows2, columns2, array2[][];
				System.out.println("Enter Number of rows and columns for first matrix : ");
				rows1 = scanner.nextInt();
				columns1 = scanner.nextInt();
				array1 = new int[rows1][columns1];
				System.out.println("Enter the elements in first matrix: ");
				for(int rowIndex = 0; rowIndex < rows1; rowIndex++){
					for(int columnIndex = 0;columnIndex < columns1; columnIndex++){
						array1[rowIndex][columnIndex] = scanner.nextInt();
					}
				}
				System.out.println("Enter Number of rows and columns for second matrix");
				rows2 = scanner.nextInt();
				columns2 = scanner.nextInt();
				array2 = new int[rows1][columns1];
				System.out.println("Enter the elements in first matrix: ");
				for(int rowIndex = 0; rowIndex < rows2; rowIndex++){
					for(int columnIndex = 0;columnIndex < columns2; columnIndex++){
						array2[rowIndex][columnIndex] = scanner.nextInt();
					}
				}
				
				int addedMatrix[][] = addMatrices(array1, array2);
				for(int rowIndex = 0; rowIndex < addedMatrix.length; rowIndex++){
					for(int columnIndex = 0;columnIndex < addedMatrix[0].length; columnIndex++){
						System.out.print(addedMatrix[rowIndex][columnIndex] + " ");
					}
					System.out.println();
				}
				
			}else if (operationCase == 4){
				
				int rows1, columns1, array1[][], rows2, columns2, array2[][];
				System.out.println("Enter Number of rows and columns for first matrix : ");
				rows1 = scanner.nextInt();
				columns1 = scanner.nextInt();
				array1 = new int[rows1][columns1];
				System.out.println("Enter the elements in first matrix: ");
				for(int rowIndex = 0; rowIndex < rows1; rowIndex++){
					for(int columnIndex = 0;columnIndex < columns1; columnIndex++){
						array1[rowIndex][columnIndex] = scanner.nextInt();
					}
				}
				System.out.println("Enter Number of rows and columns for second matrix");
				rows2 = scanner.nextInt();
				columns2 = scanner.nextInt();
				array2 = new int[rows1][columns1];
				System.out.println("Enter the elements in first matrix: ");
				for(int rowIndex = 0; rowIndex < rows2; rowIndex++){
					for(int columnIndex = 0;columnIndex < columns2; columnIndex++){
						array2[rowIndex][columnIndex] = scanner.nextInt();
					}
				}
				
				int multiplyedMatrix[][] = multiplyMatrices(array1,array2);
				for(int rowIndex = 0; rowIndex < multiplyedMatrix.length; rowIndex++){
					for(int columnIndex = 0;columnIndex < multiplyedMatrix[0].length; columnIndex++){
						System.out.print(multiplyedMatrix[rowIndex][columnIndex] + " ");
					}
					System.out.println();
				}
			}else{
				System.out.println("Enter valid operation case");
			}
			System.out.println("Enter operation case from 0 to 4");
			operationCase = scanner.nextInt();
		}
		
		
	}

}
