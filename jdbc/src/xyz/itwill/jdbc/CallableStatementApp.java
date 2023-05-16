package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/*
CREATE OR REPLACE PROCEDURE DELETE_STUDENT(VNO IN STUDENT.NO%TYPE -> DELETE_STUDENT 프로시저명 (매개변수 IN 데이터타입,...)
    ,VNAME OUT STUDENT.NAME%TYPE) IS
BEGIN -> 실행 구문 작성
    SELECT NAME INTO VNAME FROM STUDENT WHERE NO=VNO;
    IF SQL%FOUND THEN -> SQL에서 위 SELECT절이 있다면 
        DELETE FROM STUDENT WHERE NO=VNO; -> 학생 테이블에서 NO이 NVO인 것 삭제
        COMMIT; -> 커밋
    END IF;
EXCEPTION -> 예외처리 구문 작성
    WHEN OTHERS THEN -> 여러가지 문제가 발생했을 경우
        VNAME := NULL; -> VNAME을 NULL로 
END;
/
*/

//키보드로 학번을 입력받아 STUDENT 테이블에 저장된 학생정보 중 해당 학번의 학생정보를 삭재하는
//JDBC 프로그램 작성 - 저장 프로시저를 호출하여 학생정보를 삭제 처리
public class CallableStatementApp {
	public static void main(String[] args) throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 삭제>>");
		System.out.println("학번 입력 >> ");
		
		int no=Integer.parseInt(in.readLine());
		
		System.out.println("=========================================================================");
		
		Connection con=ConnectionFactory.getConnection();
		
		/*
			Connection.prepareCall(String sql) : 저장 프로시저를 호출하는 명령을 전달하여 실행하기 위한 CallableStatement 객체를 반환하는 메소드
				=> 저장 프로시저를 호출하는 명령 - {call 저장프로시저명(?,?,...)} 
				=> 저장 프로시저 호출 시 사용한 ? 기호에는 반드시 setXXX() 메소드를 호출하여 값을 전달하거나 registerOutParameter() 메소드를 호출하여 값을 제공받아 사용
		*/
		String sql="{call delete_student(?,?)}";
		CallableStatement cstmt=con.prepareCall(sql);
		
		//CallableStatement.setXXX(int parameterIndex, XXX value) : 저장 프로시저의 IN 모드의 매개변수 중 IN 모드의 매개변수에 값을 전달하기 위한 메소드
		cstmt.setInt(1, no);
		
		/*
			CallableStatement.registerOutParameter(int parameterIndex, int sqlType) : 저장 프로시저에서 사용한 매개변수 중 OUT 모드의 매개변수에 저장된 값을 제공받기 위한 메소드
				=> sqlType : SQL 자료형 - Types 클래스의 상수 사용
		*/	   
		cstmt.registerOutParameter(2, Types.NVARCHAR);
		
		//CallableStatement.execute() : 저장 프로시저를 호출하는 명령을 전달하여 실행하는 메소드
		cstmt.execute();
		
		//Callablestatement.getXXX(int parameterIndex) : 저장 프로시저에서 사용한 매개변수에중 OUT 모드의 매개변수에 저장된 값을 반환하는 메소드
		String name=cstmt.getString(2);
		
		if(name==null) {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		}else {
			System.out.println("[메세지]"+name+"님을 삭제하였습니다.");
		}
		
		ConnectionFactory.close(con, cstmt);
	}
}












