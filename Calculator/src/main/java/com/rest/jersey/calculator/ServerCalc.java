package com.rest.jersey.calculator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/calc") 
@Consumes(MediaType.APPLICATION_JSON) 
public class ServerCalc {

	@GET 
	@Produces(MediaType.APPLICATION_JSON) 
	//Invocation string: http://localhost:8080/Calculator/calc?a=6&b=7&op=add
	public Response Calculator(@QueryParam("a") double a, @QueryParam("b") double b, @QueryParam("op") String op) throws JSONException {
		JSONObject json = new JSONObject();
		double c;
		switch(op)
	    {
	        case "+":
	        case "add":
	            c = a + b;
	            break;
	        case "-":
	        case "sub":
	            c = a - b;
	            break;
	        case "*":
	        case "mul":
	            c = a * b;
	            break;
	        case "/":
	        case "div":
	            if (b==0) {
	        		return Response.status(400).entity("400 Arithmetic exception: division by zero error").build();	
	            } 
	            else {c = a / b;};
	            break;
	        case "sqrt":
	        	if (a < 0) {
	        		return Response.status(400).entity("400 Arithmetic exception: Negative number for square root").build();
	        	}
	        	c = Math.sqrt(a);
	        	break;
	        case "pow": // Power
	        	c = Math.pow(a, b);
	        	break;
	        case "fac": // Factorial
	        	if (a < 0 || a != (int)a) {
                    return Response.status(400).entity("400 Arithmetic exception: Factorial is only defined for non-negative integers").build();
                }
                c = fac((int)a);
                break;
	        case "sin":
                c = Math.sin(a); 
                break;
            case "cos":
                c = Math.cos(a); 
                break;
            case "tan":
                c = Math.tan(a); 
                break;
            case "log":
                if (a <= 0) {
                    return Response.status(400).entity("400 Arithmetic exception: Logarithm undefined for non-positive numbers").build();
                }
                c = Math.log10(a); 
                break;
            case "ln": // Natural logarithm
                if (a <= 0) {
                    return Response.status(400).entity("400 Arithmetic exception: Natural logarithm undefined for non-positive numbers").build();
                }
                c = Math.log(a); 
                break;
	        default:
        		return Response.status(400).entity("400 Invalid Operator").build();	
	    }
		json.put("a", a);
		json.put("b", b);
		json.put("op", op);
		json.put("c", c);
		String result = ""+json;
		return Response.status(200).entity(result).build();	
	}
	
    private int fac(int n) {
        if (n == 0) return 1;
        return n * fac(n - 1);
    }

	@GET
	@Path("/sub/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	//Invocation string: http://localhost:8080/Calculator/calc/sub/5/9
	public String sub(@PathParam("a") double a, @PathParam("b") double b) {
		return  "<?xml version=\"1.0\"?>\n" +
				"<calc>\n" +
				"  <operands>\n" +
			    "    <a>" + a + "</a>\n" +
			    "    <b>" + b + "</b>\n" +
				"  </operands>\n" +
			    "  <operation>sub</operation>\n" +
				"  <result>\n" +
			    "     <c>" + (a - b) + "</c>\n" +
				"  </result>\n" +
			    "</calc>";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/add/{a}/{b}")
	//Invocation string: http://localhost:8080/Calculator/calc/add/{a}/{b}
	public String add(@PathParam("a") double a, @PathParam("b") double b) {
		return  "<?xml version=\"1.0\"?>\n" +
				"<calc>\n" +
				"  <operands>\n" +
			    "    <a>" + a + "</a>\n" +
			    "    <b>" + b + "</b>\n" +
				"  </operands>\n" +
			    "  <operation>add</operation>\n" +
				"  <result>\n" +
			    "     <c>" + (a + b) + "</c>\n" +
				"  </result>\n" +
			    "</calc>";
	}
	
	@GET
	@Path("/mul/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	//Invocation string: http://localhost:8080/Calculator/calc/mul/{a}/{b}
	public String mul(@PathParam("a") double a, @PathParam("b") double b) {
		return  "<?xml version=\"1.0\"?>\n" +
				"<calc>\n" +
				"  <operands>\n" +
			    "    <a>" + a + "</a>\n" +
			    "    <b>" + b + "</b>\n" +
				"  </operands>\n" +
			    "  <operation>mul</operation>\n" +
				"  <result>\n" +
			    "     <c>" + (a * b) + "</c>\n" +
				"  </result>\n" +
			    "</calc>";
	}

	@GET
	@Path("/div/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	//Invocation string: http://localhost:8080/Calculator/calc/div/{a}/{b}
	public String div(@PathParam("a") double a, @PathParam("b") double b) {
		return  "<?xml version=\"1.0\"?>\n" +
				"<calc>\n" +
				"  <operands>\n" +
			    "    <a>" + a + "</a>\n" +
			    "    <b>" + b + "</b>\n" +
				"  </operands>\n" +
			    "  <operation>mul</operation>\n" +
				"  <result>\n" +
			    "     <c>" + (a / b) + "</c>\n" +
				"  </result>\n" +
			    "</calc>";
	}
	
}
