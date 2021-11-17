package org.iesfm.ioc;

import org.iesfm.ioc.readers.CompanyReader;
import org.iesfm.ioc.readers.DepartmentReader;
import org.iesfm.ioc.readers.EmployeeReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {

    private final static Logger log = LoggerFactory.getLogger(Menu.class);

    private Scanner scanner;

    private EmployeeReader employeeReader;
    private CompanyReader companyReader;

    public Menu(Scanner scanner, EmployeeReader employeeReader, CompanyReader companyReader) {
        this.scanner = scanner;
        this.employeeReader = employeeReader;
        this.companyReader = companyReader;
    }

    public void run() {
        boolean exit = false;

        Company company = companyReader.readCompany();
        while (!exit) {
            log.info("Bienvenido! Escoge una de estas opciones:");
            log.info("1.Lista los departamentos");
            log.info("2.Añadir empleados al departamento");
            log.info("3.Introducir datos del empleado");
            log.info("4.Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    for (Department department : company.getDepartments()) {
                        log.info(department.toString());
                    }
                    break;
                case 2:
                    log.info("introduce el nombre del departamento:");
                    String departmentName = scanner.nextLine();
                    log.info("introduce el empleado");
                    Employee employee = employeeReader.read();
                    company.addEmployeeToDepartment(departmentName, employee);
                    break;
                case 3:
                    log.info("introduce el nombre del departamento:");
                    String departmentNameToDelete = scanner.nextLine();
                    company.deleteDepartment(departmentNameToDelete);

                case 4:
                    exit = true;
                    break;
            }
        }

    }
}
