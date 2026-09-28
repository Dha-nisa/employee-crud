package com.example.employee_crud.Controller;

import com.example.employee_crud.Entity.Department;
import com.example.employee_crud.Service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    public DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department){
       return departmentService.createDepartment(department);

    }

    @GetMapping
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Integer id){
        return departmentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id){
      departmentService.deleteDepartment(id);
      return ResponseEntity.ok("Successfully Deleted");
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Integer id,@RequestBody Department department){
        return departmentService.updateDepartment(id,department);
    }

    @PatchMapping("/{id}")
    public Department patchDepartment(@PathVariable Integer id,Department department){
        return departmentService.patchDepartment(id,department);
    }


}
