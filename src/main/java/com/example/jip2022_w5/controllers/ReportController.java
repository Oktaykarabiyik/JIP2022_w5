package com.example.jip2022_w5.controllers;

import com.example.jip2022_w5.dto.UserDTO;
import com.example.jip2022_w5.entities.User;
import com.example.jip2022_w5.service.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/createPdf",method = RequestMethod.GET)
    public String showPdfPage() throws JRException, FileNotFoundException {
        String path="C:\\Users\\Oktay\\Desktop";
        List<User> userList = reportService.getAllUsers();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user:userList) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setBirthday(user.getBirthday());
            userDTO.setSexsmall(user.getSexsmall());
            userDTOList.add(userDTO);
        }

        File file= ResourceUtils.getFile("classpath:User.jrxml");
        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(userDTOList);
        Map<String,Object>parameters=new HashMap<>();
        parameters.put("createdBy","User Report");
        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameters,dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\users.pdf");


        return "listUser";
    }
}
