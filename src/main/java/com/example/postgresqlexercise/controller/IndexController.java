package com.example.postgresqlexercise.controller;

import com.example.postgresqlexercise.connection.HibernateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController extends HttpServlet {

    HibernateUtils hibernateUtils = new HibernateUtils();

    @RequestMapping("/")
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/showResults", method = RequestMethod.GET)
    public String showResults(HttpServletRequest request) {
        hibernateUtils.listIndexes(request.getParameter("choosen"));
        request.setAttribute("indexes", hibernateUtils.listToJsp);
        return "/showResults";
    }
}
