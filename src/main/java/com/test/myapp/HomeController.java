package com.test.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	
	@RequestMapping(value="formPage", method = RequestMethod.GET)
	public String processForm(HttpServletRequest request,Model model)
	{
	
		String questions = request.getParameter("questions");
		
		String answers = request.getParameter("answers");
		
		String comment = request.getParameter("comment");
		
		model.addAttribute("questions", questions);
		
		model.addAttribute("answers", answers);
		
		return "successTest";
		
	}
	
	@RequestMapping(value="myForm", method = RequestMethod.GET)
	public String processForm()
	{
		return "myForm";
	}

	@RequestMapping(value="listQuestions", method= RequestMethod.GET)
	public String listAllQuestions(Model model)
	{    try
	   {
		Class.forName("com.mysql.jdbc.Driver");
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Questions&Answers","root","admin"); 
		
		String selectCommand = "select questions,answers from QuestionsAnswers";
		
		Statement selectStatement = cnn.createStatement();
		
		ResultSet rs =selectStatement.executeQuery(selectCommand); 
		
		String output = "<table border=1>";
		
		while(rs.next()==true)
		{
			
			output+="<tr>";
			output+="<td>"+rs.getString(1)+"</td>";
			output+="<td>"+rs.getString(2)+"</td>";
			output+="</tr>";
					
			
		}
		
		output+="</table>";
		
		model.addAttribute("qtable", output);
		
		return "questions";
	   }
	
	catch (Exception e)
	{
		// to do:
		// add this view: errorPage
		return "errorPage";
		
	}
	}
	
	
}
