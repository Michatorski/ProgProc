package org.iesfm.ioc;

import org.iesfm.ioc.readers.CompanyReader;
import org.iesfm.ioc.readers.DepartmentReader;
import org.iesfm.ioc.readers.EmployeeReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Scanner;

@org.springframework.context.annotation.Configuration
public class CompanyConfiguration {

    @Bean
    public Menu menu (Scanner scanner, EmployeeReader employeeReader,
                      CompanyReader companyReader){
        return new Menu(scanner, employeeReader, companyReader);
    }

    @Bean
    public EmployeeReader employeeReader(Scanner scanner){
        return new EmployeeReader(scanner);
    }

    @Bean
    public DepartmentReader departmentReader(Scanner scanner, EmployeeReader employeeReader){
        return new DepartmentReader(scanner, employeeReader);
    }

    @Bean
    public CompanyReader companyReader (Scanner scanner, DepartmentReader departmentReader){
        return new CompanyReader( scanner, departmentReader);
    }

    @Bean
    public Scanner scanner (){
        return new Scanner(System.in);
    }

}
