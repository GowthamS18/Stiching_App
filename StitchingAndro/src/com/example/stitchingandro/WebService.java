package com.example.stitchingandro;

import javax.sql.DataSource;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.R.string;

public class WebService<DataTable> {
	//Namespace of the Webservice - can be found in WSDL
	private static String NAMESPACE = "http://tempuri.org/";
	//Webservice URL - WSDL File location	
	public static final String URLimg = "http://192.168.43.252:32768/logo/";
	private static final String URL = "http://192.168.43.252:32768/Service.asmx";//Make sure you changed IP address
	//SOAP Action URI again Namespace + Web method name
	private static String SOAP_ACTION = "http://tempuri.org/";

	public static String UpdateStatus(String p1,String p2,String p3,String webMethName) {
		String registerStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo pi1 = new PropertyInfo();
		PropertyInfo pi2 = new PropertyInfo();
		PropertyInfo pi3 = new PropertyInfo();
		pi1.setName("p1");		
		pi1.setValue(p1);	
		pi1.setType(String.class);
		request.addProperty(pi1);
		
		pi2.setName("p2");
		pi2.setValue(p2);
		pi2.setType(String.class);		//Add the property to request object
		request.addProperty(pi2);		
		
		pi3.setName("p3");
		pi3.setValue(p3);
		pi3.setType(String.class);		//Add the property to request object
		request.addProperty(pi3);		
		
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			registerStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return registerStatus;
	}
	public static String AddMeasurements(String p1,String p2,String p3,String p4,String p5,String p6,String webMethName) {
		String registerStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo pi1 = new PropertyInfo();
		PropertyInfo pi2 = new PropertyInfo();
		PropertyInfo pi3 = new PropertyInfo();
		PropertyInfo pi4 = new PropertyInfo();
		PropertyInfo pi5 = new PropertyInfo();
		PropertyInfo pi6 = new PropertyInfo();
		
		pi1.setName("p1");		
		pi1.setValue(p1);	
		pi1.setType(String.class);
		request.addProperty(pi1);
		
		pi2.setName("p2");
		pi2.setValue(p2);
		pi2.setType(String.class);		//Add the property to request object
		request.addProperty(pi2);
		
		pi3.setName("p3");		//Set dataType
		pi3.setValue(p3);		//Set dataType
		pi3.setType(String.class);		//Add the property to request object
		request.addProperty(pi3);
		
		pi4.setName("p4");		// Set Value
		pi4.setValue(p4);		// Set dataType
		pi4.setType(String.class);		// Add the property to request object
		request.addProperty(pi4);
		
		pi5.setName("p5");		// Set Value
		pi5.setValue(p5);		// Set dataType
		pi5.setType(String.class);		// Add the property to request object
		request.addProperty(pi5);
	
		pi6.setName("p6");		// Set Value
		pi6.setValue(p6);		// Set dataType
		pi6.setType(String.class);		// Add the property to request object
		request.addProperty(pi6);
		
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			registerStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return registerStatus;
	}
	
	public static String AddPayments(String p1,String p2,String p3,String p4,String p5,String p6,String p7,String p8,String webMethName) {
		String registerStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo pi1 = new PropertyInfo();
		PropertyInfo pi2 = new PropertyInfo();
		PropertyInfo pi3 = new PropertyInfo();
		PropertyInfo pi4 = new PropertyInfo();
		PropertyInfo pi5 = new PropertyInfo();
		PropertyInfo pi6 = new PropertyInfo();
		PropertyInfo pi7 = new PropertyInfo();
		PropertyInfo pi8 = new PropertyInfo();
		
		pi1.setName("p1");		
		pi1.setValue(p1);	
		pi1.setType(String.class);
		request.addProperty(pi1);
		
		pi2.setName("p2");
		pi2.setValue(p2);
		pi2.setType(String.class);		//Add the property to request object
		request.addProperty(pi2);
		
		pi3.setName("p3");		//Set dataType
		pi3.setValue(p3);		//Set dataType
		pi3.setType(String.class);		//Add the property to request object
		request.addProperty(pi3);
		
		pi4.setName("p4");		// Set Value
		pi4.setValue(p4);		// Set dataType
		pi4.setType(String.class);		// Add the property to request object
		request.addProperty(pi4);
		
		pi5.setName("p5");		// Set Value
		pi5.setValue(p5);		// Set dataType
		pi5.setType(String.class);		// Add the property to request object
		request.addProperty(pi5);
	
		pi6.setName("p6");		// Set Value
		pi6.setValue(p6);		// Set dataType
		pi6.setType(String.class);		// Add the property to request object
		request.addProperty(pi6);
		
		pi7.setName("p7");		// Set Value
		pi7.setValue(p7);		// Set dataType
		pi7.setType(String.class);		// Add the property to request object
		request.addProperty(pi7);
	
		pi8.setName("p8");		// Set Value
		pi8.setValue(p8);		// Set dataType
		pi8.setType(String.class);		// Add the property to request object
		request.addProperty(pi8);
		
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			registerStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return registerStatus;
	}
	
	public static String AddOrder(String p1,String p2,String p3,String p4,String p5,String p6,String webMethName) {
		String registerStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo pi1 = new PropertyInfo();
		PropertyInfo pi2 = new PropertyInfo();
		PropertyInfo pi3 = new PropertyInfo();
		PropertyInfo pi4 = new PropertyInfo();
		PropertyInfo pi5 = new PropertyInfo();
		PropertyInfo pi6 = new PropertyInfo();		
		pi1.setName("p1");		
		pi1.setValue(p1);	
		pi1.setType(String.class);
		request.addProperty(pi1);
		
		pi2.setName("p2");
		pi2.setValue(p2);
		pi2.setType(String.class);		//Add the property to request object
		request.addProperty(pi2);
		
		pi3.setName("p3");		//Set dataType
		pi3.setValue(p3);		//Set dataType
		pi3.setType(String.class);		//Add the property to request object
		request.addProperty(pi3);
		
		pi4.setName("p4");		// Set Value
		pi4.setValue(p4);		// Set dataType
		pi4.setType(String.class);		// Add the property to request object
		request.addProperty(pi4);
		
		pi5.setName("p5");		// Set Value
		pi5.setValue(p5);		// Set dataType
		pi5.setType(String.class);		// Add the property to request object
		request.addProperty(pi5);
				
		pi6.setName("p6");		// Set Value
		pi6.setValue(p6);		// Set dataType
		pi6.setType(String.class);		// Add the property to request object
		request.addProperty(pi6);
					
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			registerStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return registerStatus;
	}
	
	public static String register(String p1,String p2,String p3,String p4,String p5,String p6,String p7,String p8,String p9,String webMethName) {
		String registerStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo pi1 = new PropertyInfo();
		PropertyInfo pi2 = new PropertyInfo();
		PropertyInfo pi3 = new PropertyInfo();
		PropertyInfo pi4 = new PropertyInfo();
		PropertyInfo pi5 = new PropertyInfo();
		PropertyInfo pi6 = new PropertyInfo();
		PropertyInfo pi7 = new PropertyInfo();
		PropertyInfo pi8 = new PropertyInfo();
		PropertyInfo pi9 = new PropertyInfo();
		PropertyInfo pi10 = new PropertyInfo();
	
		pi1.setName("p1");		
		pi1.setValue(p1);	
		pi1.setType(String.class);
		request.addProperty(pi1);
		
		pi2.setName("p2");
		pi2.setValue(p2);
		pi2.setType(String.class);		//Add the property to request object
		request.addProperty(pi2);
		
		pi3.setName("p3");		//Set dataType
		pi3.setValue(p3);		//Set dataType
		pi3.setType(String.class);		//Add the property to request object
		request.addProperty(pi3);
		
		pi4.setName("p4");		// Set Value
		pi4.setValue(p4);		// Set dataType
		pi4.setType(String.class);		// Add the property to request object
		request.addProperty(pi4);
		
		pi5.setName("p5");		// Set Value
		pi5.setValue(p5);		// Set dataType
		pi5.setType(String.class);		// Add the property to request object
		request.addProperty(pi5);
				
		pi6.setName("p6");		// Set Value
		pi6.setValue(p6);		// Set dataType
		pi6.setType(String.class);		// Add the property to request object
		request.addProperty(pi6);
		
		
		pi7.setName("p7");		// Set Value
		pi7.setValue(p7);		// Set dataType
		pi7.setType(String.class);		// Add the property to request object
		request.addProperty(pi7);
		
		pi8.setName("p8");		// Set Value
		pi8.setValue(p8);		// Set dataType
		pi8.setType(String.class);		// Add the property to request object
		request.addProperty(pi8);
				
		pi9.setName("p9");		// Set Value
		pi9.setValue(p9);		// Set dataType
		pi9.setType(String.class);		// Add the property to request object
		request.addProperty(pi9);
		
			
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			registerStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return registerStatus;
	}
	

	public static String vendorregister(String p1,String p2,String p3,String p4,String p5,String p6,String p7,String p8,String p9,String p10,String p11,String p12,String webMethName) {
		String registerStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo pi1 = new PropertyInfo();
		PropertyInfo pi2 = new PropertyInfo();
		PropertyInfo pi3 = new PropertyInfo();
		PropertyInfo pi4 = new PropertyInfo();
		PropertyInfo pi5 = new PropertyInfo();
		PropertyInfo pi6 = new PropertyInfo();
		PropertyInfo pi7 = new PropertyInfo();
		PropertyInfo pi8 = new PropertyInfo();
		PropertyInfo pi9 = new PropertyInfo();
		PropertyInfo pi10 = new PropertyInfo();
		PropertyInfo pi11 = new PropertyInfo();
		PropertyInfo pi12 = new PropertyInfo();
		
		pi1.setName("p1");		
		pi1.setValue(p1);	
		pi1.setType(String.class);
		request.addProperty(pi1);
		
		pi2.setName("p2");
		pi2.setValue(p2);
		pi2.setType(String.class);		//Add the property to request object
		request.addProperty(pi2);
		
		pi3.setName("p3");		//Set dataType
		pi3.setValue(p3);		//Set dataType
		pi3.setType(String.class);		//Add the property to request object
		request.addProperty(pi3);
		
		pi4.setName("p4");		// Set Value
		pi4.setValue(p4);		// Set dataType
		pi4.setType(String.class);		// Add the property to request object
		request.addProperty(pi4);
		
		pi5.setName("p5");		// Set Value
		pi5.setValue(p5);		// Set dataType
		pi5.setType(String.class);		// Add the property to request object
		request.addProperty(pi5);
				
		pi6.setName("p6");		// Set Value
		pi6.setValue(p6);		// Set dataType
		pi6.setType(String.class);		// Add the property to request object
		request.addProperty(pi6);
		
		
		pi7.setName("p7");		// Set Value
		pi7.setValue(p7);		// Set dataType
		pi7.setType(String.class);		// Add the property to request object
		request.addProperty(pi7);
		
		pi8.setName("p8");		// Set Value
		pi8.setValue(p8);		// Set dataType
		pi8.setType(String.class);		// Add the property to request object
		request.addProperty(pi8);
				
		pi9.setName("p9");		// Set Value
		pi9.setValue(p9);		// Set dataType
		pi9.setType(String.class);		// Add the property to request object
		request.addProperty(pi9);
		
		pi10.setName("p10");		// Set Value
		pi10.setValue(p10);		// Set dataType
		pi10.setType(String.class);		// Add the property to request object
		request.addProperty(pi10);
		
		pi11.setName("p11");		// Set Value
		pi11.setValue(p11);		// Set dataType
		pi11.setType(String.class);		// Add the property to request object
		request.addProperty(pi11);
		
		pi12.setName("p12");		// Set Value
		pi12.setValue(p12);		// Set dataType
		pi12.setType(String.class);		// Add the property to request object
		request.addProperty(pi12);
		
			
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			registerStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return registerStatus;
	}
	
	
	public static String confirmorder(String p1,String p2,String p3,String p4,String p5,String p6,String webMethName) {
		String registerStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);	
		PropertyInfo pi1 = new PropertyInfo();
		PropertyInfo pi2 = new PropertyInfo();
		PropertyInfo pi3 = new PropertyInfo();	
		PropertyInfo pi4 = new PropertyInfo();
		PropertyInfo pi5 = new PropertyInfo();
		PropertyInfo pi6 = new PropertyInfo();	
	
		pi1.setName("p1");		
		pi1.setValue(p1);	
		pi1.setType(String.class);
		request.addProperty(pi1);
		
		pi2.setName("p2");
		pi2.setValue(p2);
		pi2.setType(String.class);		//Add the property to request object
		request.addProperty(pi2);
		
		pi3.setName("p3");		//Set dataType
		pi3.setValue(p3);		//Set dataType
		pi3.setType(String.class);		//Add the property to request object
		request.addProperty(pi3);
		

		pi4.setName("p4");		
		pi4.setValue(p4);	
		pi4.setType(String.class);
		request.addProperty(pi4);
		
		pi5.setName("p5");
		pi5.setValue(p5);
		pi5.setType(String.class);		//Add the property to request object
		request.addProperty(pi5);
		
		pi6.setName("p6");		//Set dataType
		pi6.setValue(p6);		//Set dataType
		pi6.setType(String.class);		//Add the property to request object
		request.addProperty(pi6);
		
		
			
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			registerStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return registerStatus;
	}
	
	public static String logincheck(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();
		
		
		// Set Username
		unamePI.setName("username");
		// Set Value
		unamePI.setValue(username);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);
				
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return loginStatus;
	}
	
	

	public static String getVendors(String p1,String p2,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo param1 = new PropertyInfo();
		PropertyInfo param2 = new PropertyInfo();
		
		param1.setName("p1");
		param1.setValue(p1);
		param1.setType(String.class);
		request.addProperty(param1);
				
		param2.setName("p2");
		param2.setValue(p2);
		param2.setType(String.class);
		request.addProperty(param2);
		
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return loginStatus;
	}
	
	public static String getList(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();
		
		
		// Set Username
		unamePI.setName("p1");
		// Set Value
		unamePI.setValue(username);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);
				
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return loginStatus;
	}
	
	
	public static String stulogincheck(String username,String password,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();
		
		
		// Set Username
		unamePI.setName("username");
		// Set Value
		unamePI.setValue(username);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);
		//Set Password
		passPI.setName("password");
		//Set dataType
		passPI.setValue(password);
		//Set dataType
		passPI.setType(String.class);
		//Add the property to request object
		request.addProperty(passPI);
		
		
		
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return loginStatus;
	}
	
	public static String getusers(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
PropertyInfo user = new PropertyInfo();
		
		
		// Set Username
		user.setName("username");
		// Set Value
		user.setValue(username);
		// Set dataType
		user.setType(String.class);
		// Add the property to request object
		request.addProperty(user);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return loginStatus;
	}
	
	public static String getuser(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
PropertyInfo user = new PropertyInfo();
		
		
		// Set Username
		user.setName("username");
		// Set Value
		user.setValue(username);
		// Set dataType
		user.setType(String.class);
		// Add the property to request object
		request.addProperty(user);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return loginStatus;
	}
	

	
	public static String updateLocation(String p1,String p2,String p3,String p4,String p5,String p6,String webMethName) 
	{
		String loginStatus ="";
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		 PropertyInfo pI1=new PropertyInfo();
		 PropertyInfo pI2=new PropertyInfo();
		 PropertyInfo pI3=new PropertyInfo();
		 PropertyInfo pI4=new PropertyInfo();
		 PropertyInfo pI5=new PropertyInfo();
		 PropertyInfo pI6=new PropertyInfo();
		 	        
		pI1.setName("p1");		
		pI1.setValue(p1);			
		pI1.setType(String.class);			
		request.addProperty(pI1);
		
		pI2.setName("p2");		
		pI2.setValue(p2);			
		pI2.setType(String.class);			
		request.addProperty(pI2);
		
		pI3.setName("p3");		
		pI3.setValue(p3);			
		pI3.setType(String.class);			
		request.addProperty(pI3);
		
		pI4.setName("p4");		
		pI4.setValue(p4);			
		pI4.setType(String.class);			
		request.addProperty(pI4);
		
		pI5.setName("p5");		
		pI5.setValue(p5);			
		pI5.setType(String.class);			
		request.addProperty(pI5);
		
		pI6.setName("p6");		
		pI6.setValue(p6);			
		pI6.setType(String.class);			
		request.addProperty(pI6);
				
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		try 
		{
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			loginStatus = response.toString();
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return loginStatus;
	}
	
	
	
	
	//get notification
	public static String getnot(String name,String webMethName) 
	{
		String loginStatus ="";
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		 PropertyInfo p1=new PropertyInfo();
		
		p1.setName("vecno");		
		p1.setValue(name);			
		p1.setType(String.class);			
		request.addProperty(p1);
				
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		try 
		{
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			loginStatus = response.toString();
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return loginStatus;
	}
}