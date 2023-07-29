package day0717.Work;

public class Work0717{
	
	public void multiplication(int dan) throws MultiplicationException {
		
		if(dan < 2 || dan > 9) {
			//지정한 범위를 벗어날 경우 예외를 강제로 발생
			throw new MultiplicationException();
		}
		
		System.out.printf("%5d단\n",dan);
		for(int i = 1; i < 10; i++) {
			System.out.printf("%d x %d = %d\n", dan, i, dan*i);
		}
	}
	
	public void useMultiplication() {
		try {
			multiplication(10);			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
