package com.example.employee_crud.Service;

import com.example.employee_crud.Entity.Department;
import com.example.employee_crud.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    public DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }

    //Create
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    //Get

    public List<Department> getDepartment(){
        return departmentRepository.findAll();
    }

    //getbyid
    public Department getById(Integer id){
        return departmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Department not found"));
    }

    //Delete

    public void deleteDepartment(Integer id){
        Department department=departmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Department not found"));
        departmentRepository.delete(department);
    }

    //put
    //Update
    public Department updateDepartment(Integer id,Department department){
        Department existingDepartment=departmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Department not found"));

        existingDepartment.setName(department.getName());
        existingDepartment.setLocation(department.getLocation());

        return departmentRepository.save(existingDepartment);

    }

    // PATCH - Partial Update
    public Department patchDepartment(Integer id, Department department) {

        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        if (department.getName() != null) {
            existingDepartment.setName(
                    department.getName()
            );
        }

        if (department.getLocation() != null) {
            existingDepartment.setLocation(
                    department.getLocation()
            );
        }

        return departmentRepository.save(existingDepartment);
    }
}
