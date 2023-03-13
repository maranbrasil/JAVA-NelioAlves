package com.example.nelioalvesjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {

	public static Employee employee;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter number of employees");
		int number = sc.nextInt();
		System.out.println("Please enter with following information");

		List<Employee> list = new ArrayList<>(); // inicializaçao da lista de empregados

		for (int i = 0; i < number; i++) { // para preencher a lista com os dados de cada um dos empregados utilizo o for, pois ele verifica quanto funcionarios serão inseridos e itera para que cada um deles seja preenchido
			System.out.printf("Employee #%d:", i + 1);
			System.out.println();
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			Employee employee = new Employee(id, name, salary); //instancio um novo empregado usando o new
			list.add(employee); // adiciono a lista usando o .add
		}

		System.out.print("Enter the id of an employee to increase Salary: ");
		int id = sc.nextInt();

		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null); // utilizo um stream pra pesquisar a lista. E para cada elemento da lista, ouseja, para cada employee eu verifico se o id dele é igual ao id capturado anteriormente. Ai retorno o promeiro que for encontradoe  se nao for encontrado retorno null

		if (emp == null) {
			System.out.println("The typed id does not exist");
		} else { // caso encontre o id do funcionario executa o código de incremento de salario
			System.out.print("Enter de percentage of increasing for that employee");
			Double incrPercentage = sc.nextDouble();
			emp.calcSalaryIncrease(incrPercentage); // Se emp retornou algo diferente de null entao tem um funcionario ali, com todos os atributos e metodos dele. Batao entao usar emp.metodo para incluir a porcentagem de valor sobre o salario
		}

		for (Employee obj : list) {
			System.out.printf("%d, %s, %.2f", obj.getId(), obj.getName(), obj.getSalary());
			System.out.println();
		}

		sc.close();
	}

	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}