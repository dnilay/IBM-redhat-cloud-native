package com.example.app;

import java.util.Scanner;
import java.util.UUID;

import com.example.Employee;
import com.example.Manager;
import com.example.Todo;

public class App {
	private static Scanner scanner = new Scanner(System.in);

	/*
	 * private Todo[] todos;
	 * 
	 * { todos=new Todo[2]; }
	 */

	public static void main(String args[]) {
		App app = new App();
		try {
			
		} 
		catch(Exception e) {
			// TODO: handle finally clause
		}
		finally {
			
		}
		/*
		 * for(int i=0;i<2;i++) { try { System.out.print("ToDo Desc: "); String
		 * tempDesc=scanner.next(); System.out.print("isCompleted? "); boolean
		 * tempIsCompleted=scanner.nextBoolean(); app.todos[i]=new
		 * Todo(UUID.randomUUID().toString(), tempDesc, tempIsCompleted);
		 * 
		 * 
		 * } catch (ArrayIndexOutOfBoundsException e) {
		 * System.err.println("array index out of bound exception."); } } for(int
		 * i=0;i<=5;i++) { try {
		 * 
		 * System.out.println(app.todos[i]);
		 * 
		 * } catch (ArrayIndexOutOfBoundsException e) {
		 * //System.out.println("Array Index Out Of Bound.");
		 * 
		 * }
		 * 
		 * }
		 */
		/*
		 * Employee employee = null; Manager manager = new Manager(); if(employee==null)
		 * { throw new NullPointerException("Null Pointer Exception Occured"); }
		 * app.check(manager);
		 */
		/*
		 * try { app.check(employee);
		 * 
		 * } catch (NullPointerException e) { e.printStackTrace(); }
		 */
		
		// app.check(employee);

		app.div(100, 0);
	}

	private void check(Employee o)throws NullPointerException {
	
		//	int a = 100 / 0;
			if (o instanceof Manager) {
				Manager manager = (Manager) o;
				System.out.println("Manager" + manager.toString());
			} else {
				System.out.println(o.toString());
			}

		}
	
	private void div(int a,int b)throws ArithmeticException
	{
		System.out.println(a/b);
	}
	
	

		
	}


