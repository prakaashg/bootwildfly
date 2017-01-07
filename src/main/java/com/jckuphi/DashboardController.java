package com.jckuphi;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jckuphi.dao.IDashboardDao;

@Controller
public class DashboardController {

	@Autowired
	IDashboardDao dao;
	
    @RequestMapping("/dashboard")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("batterystatus", dao.getLatestMonitorStatus());
        return "dashboard";
    }

}
