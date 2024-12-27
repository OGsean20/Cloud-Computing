package com.rest.jersey.calculator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;


@Path("/calc") 
@Consumes(MediaType.APPLICATION_JSON) 
public class ServerCalc {
	
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
	
	@GET
	@Path("/sqrt/{a}")
	@Produces(MediaType.TEXT_XML)
	//Invocation string: http://localhost:8080/Calculator/calc/sqrt/{a}
	public String sqrt(@PathParam("a") double a, @PathParam("b") double b) {
		return "<?xml version=\"1.0\"?>\n" +
		           "<calc>\n" +
		           "  <operand>\n" +
		           "    <a>" + a + "</a>\n" +
		           "  </operand>\n" +
		           "  <operation>sqrt</operation>\n" +
		           "  <result>\n" +
		           "     <c>" + Math.sqrt(a) + "</c>\n" +
		           "  </result>\n" +
		           "</calc>";
	}
	
	@GET
	@Path("/pow/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	// Invocation string: http://localhost:8080/Calculator/calc/pow/{a}/{b}
	public String pow(@PathParam("a") double a, @PathParam("b") double b) {
	    return "<?xml version=\"1.0\"?>\n" +
	           "<calc>\n" +
	           "  <operands>\n" +
	           "    <a>" + a + "</a>\n" +
	           "    <b>" + b + "</b>\n" +
	           "  </operands>\n" +
	           "  <operation>pow</operation>\n" +
	           "  <result>\n" +
	           "     <c>" + Math.pow(a, b) + "</c>\n" +
	           "  </result>\n" +
	           "</calc>";
	}
	
	@GET
	@Path("/fac/{a}")
	@Produces(MediaType.TEXT_XML)
	// Invocation string: http://localhost:8080/Calculator/calc/fac/4
	public String fac(@PathParam("a") int a) {
	    
	    int result = 1;
	    for (int i = 1; i <= a; i++) {
	        result *= i;
	    }
	    
	    return "<?xml version=\"1.0\"?>\n" +
	           "<calc>\n" +
	           "  <operand>\n" +
	           "    <a>" + a + "</a>\n" +
	           "  </operand>\n" +
	           "  <operation>fac</operation>\n" +
	           "  <result>\n" +
	           "     <c>" + result + "</c>\n" +
	           "  </result>\n" +
	           "</calc>";
	}

	@GET
	@Path("/sin/{a}")
	@Produces(MediaType.TEXT_XML)
	// Invocation string: http://localhost:8080/Calculator/calc/sin/{a}
	public String sin(@PathParam("a") double a) {
	    return "<?xml version=\"1.0\"?>\n" +
	           "<calc>\n" +
	           "  <operand>\n" +
	           "    <a>" + a + "</a>\n" +
	           "  </operand>\n" +
	           "  <operation>sin</operation>\n" +
	           "  <result>\n" +
	           "     <c>" + Math.sin(a) + "</c>\n" +
	           "  </result>\n" +
	           "</calc>";
	}

	@GET
	@Path("/cos/{a}")
	@Produces(MediaType.TEXT_XML)
	// Invocation string: http://localhost:8080/Calculator/calc/cos/{a}
	public String cos(@PathParam("a") double a) {
	    return "<?xml version=\"1.0\"?>\n" +
	           "<calc>\n" +
	           "  <operand>\n" +
	           "    <a>" + a + "</a>\n" +
	           "  </operand>\n" +
	           "  <operation>cos</operation>\n" +
	           "  <result>\n" +
	           "     <c>" + Math.cos(a) + "</c>\n" +
	           "  </result>\n" +
	           "</calc>";
	}

	@GET
	@Path("/tan/{a}")
	@Produces(MediaType.TEXT_XML)
	// Invocation string: http://localhost:8080/Calculator/calc/cos/{a}
	public String tan(@PathParam("a") double a) {
	    return "<?xml version=\"1.0\"?>\n" +
	           "<calc>\n" +
	           "  <operand>\n" +
	           "    <a>" + a + "</a>\n" +
	           "  </operand>\n" +
	           "  <operation>tan</operation>\n" +
	           "  <result>\n" +
	           "     <c>" + Math.tan(a) + "</c>\n" +
	           "  </result>\n" +
	           "</calc>";
	}
}
