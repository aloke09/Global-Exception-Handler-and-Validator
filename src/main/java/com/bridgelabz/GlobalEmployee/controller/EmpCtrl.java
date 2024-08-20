package com.bridgelabz.GlobalEmployee.controller;

import com.bridgelabz.GlobalEmployee.DTO.responseDTO;
import com.bridgelabz.GlobalEmployee.except.CustomeExept;
import com.bridgelabz.GlobalEmployee.globalexpt.Global;
import com.bridgelabz.GlobalEmployee.model.Employee;
import com.bridgelabz.GlobalEmployee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpCtrl
{
    @Autowired
    EmpService service;

    @PostMapping("/employees")
    public responseDTO<Employee> add(@RequestBody Employee e) {
        responseDTO<Employee> response = new responseDTO<>();
        try {

            Employee ee = service.insert(e);
            response.setStatus(HttpStatus.OK.name());
            response.setMessage("Employee added successfully!");
            response.setData(ee);
        } catch (CustomeExept ex) {
//            response.setStatus(HttpStatus.BAD_REQUEST.name());
//            response.setMessage(ex.getMessage());
//            response.setData(null);
            response=new Global().handleCustomExceptioninput(ex);
        }
        return response;
    }
    @GetMapping("/emp/{id}")
    public responseDTO<Employee> getById(@PathVariable int id)  {

        responseDTO<Employee> response = new responseDTO();
        Employee result = null;
        try
        {
            result = service.getById(id);
            response.setStatus(HttpStatus.OK.name());
            response.setMessage("Employee Fetched");
            response.setData(result);
            System.out.println(result);
        }
        catch(CustomeExept e)
        {
            response=new Global().handleCustomExceptionById(e);
        }
        return response;
    }

    @GetMapping("/emp")
    public responseDTO<List<Employee>> getAll()
    {
        responseDTO<List<Employee>> response=new responseDTO<>();
        List<Employee> all = null;
        try
        {
            all = service.getAll();
            response.setStatus(HttpStatus.OK.name());
            response.setMessage("All Employee Fetched");
            response.setData(all);
            System.out.println(all);
        }
        catch (CustomeExept ex)
        {
            response.setStatus(HttpStatus.BAD_REQUEST.name());
            response.setMessage(ex.getMessage());
//            response.setData();
            System.out.println(all);
        }

        return response;//service.getAll();
    }

    @PutMapping("/emp")
    public responseDTO<Employee> updateById(@RequestBody Employee employee)
    {
        responseDTO<Employee> response=new responseDTO<>();
        Employee update = null;
        try
        {
            update = service.update(employee);
            response.setStatus(HttpStatus.OK.name());
            response.setMessage("Employee details updated");
            response.setData(update);
            System.out.println(update);
        }
        catch (CustomeExept ex)
        {
//            response.setStatus(HttpStatus.BAD_REQUEST.name());
//            response.setMessage(ex.getMessage());
//            response.setData(update);
//            System.out.println(update);
            response=new Global().handleCustomExceptionUpdateById(ex);
        }
        return response;
    }

    @DeleteMapping("/emp/{id}")
    public responseDTO<Employee> delById(@PathVariable int id)
    {
        responseDTO<Employee> response=new responseDTO<>();
        String s = "";
        try
        {
            s = service.deleteById(id);
            response.setStatus(HttpStatus.OK.name());
            response.setMessage("Employee details deleted");
//            response.setData(s);
            System.out.println(s);
        }
        catch (CustomeExept ex)
        {
//            response.setStatus(HttpStatus.BAD_REQUEST.name());
//            response.setMessage(ex.getMessage());
////            response.setData(s);
//            System.out.println(s);
            response=new Global().handleCustomExceptionDelById(ex);
        }
        return  response;
    }
}
