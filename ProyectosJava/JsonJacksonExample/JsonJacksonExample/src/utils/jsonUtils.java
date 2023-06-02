package utils;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import modelo.Address;
import modelo.Employee;
import modelo.People;
import modelo.Persona;

public class jsonUtils {


    public static Employee LeerEmpleadoFromJsonFile(String relativePathFile)
    {

        //File ficheroEmpleado = new File("src/recursos/employee.txt");
		File ficheroEmpleado = new File(relativePathFile);
        //byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));
		
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		//convert json string to object
		Employee emp = null;
        try {
			// con el obj maper leo el valor del fichero y le digo que el ficheroempleado debe unirlo a Employee.class
            emp = objectMapper.readValue(ficheroEmpleado, Employee.class);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        System.out.println("Employee Object\n"+emp);
        return emp;
		 
    }



	public static List<Employee> LeerListEmpleadoFromJsonFile(String relativePathFile)
	{
		File ficheroEmpleado = new File(relativePathFile);

		ObjectMapper objectMapper = new ObjectMapper();

		List<Employee> listaEmpleados = null;
		try {
            listaEmpleados = objectMapper.readValue(ficheroEmpleado,  new TypeReference<List<Employee>>(){});
        } catch (IOException e) {
            
            e.printStackTrace();
        }

		return listaEmpleados;
	}

	/**
	 * Convierte un objeto en un Json
	 */
    public static void convertToJson()
    {
        try 
        {
            ObjectMapper objectMapper = new ObjectMapper();
            //convert Object to json string
            Employee emp1 = createEmployee();
            //configure Object mapper for pretty print
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        
            
			//Puedo imprimirlo por consola 
            //writing to console, can write to any output stream such as file
            //StringWriter stringEmp = new StringWriter();
            //Sacar por consola el Json
            //objectMapper.writeValue(stringEmp, emp1);
            //System.out.println("Employee JSON is\n"+stringEmp);

			//Puedo guardarlo en un fichero
            File fileEmp1 = new File("JsonJacksonExample/src/recursos/empleado1.txt");
            objectMapper.writeValue(fileEmp1, emp1);
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public static Employee createEmployee() {

		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Alfonso");
		emp.setPermanent(false);
		emp.setPhoneNumbers(new long[] { 123456, 987654 });
		emp.setRole("Manager");

		Address add = new Address();
		add.setCity("Bangalore");
		add.setStreet("BTM 1st Stage");
		add.setZipcode(560100);
		emp.setAddress(add);

		List<String> cities = new ArrayList<String>();
		cities.add("Los Angeles");
		cities.add("New York");
		emp.setCities(cities);

		Map<String, String> props = new HashMap<String, String>();
		props.put("salary", "1000 Rs");
		props.put("age", "28 years");
		emp.setProperties(props);

		return emp;
	}


	public static People leerFicheroPersonas()
	{
		//File ficheroEmpleado = new File("src/recursos/employee.txt");
		File ficheroPersona = new File("JsonJacksonExample/src/recursos/Personas.json");
        //byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));
		
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		//convert json string to object
		People people = null;
        try {
			// con el obj maper leo el valor del fichero y le digo que el ficheroempleado debe unirlo a Employee.class
            people = objectMapper.readValue(ficheroPersona, People.class);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        System.out.println("Employee Object\n"+people);
        return people;
	}



	public static void crearFicheroPersonas(People persona2) 
	{
		try
		{
			
			File ficheroNuevaPersona = new File("JsonJacksonExample/src/recursos/persona24.txt");

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);


			mapper.writeValue(ficheroNuevaPersona, persona2);
		}
		catch(Exception ex)
        {
            System.out.println(ex);
        }
	}


	public static void crearFicheroDiccionario(HashMap<String, Persona> diccionarioPersonas) 
	{
		try
		{
			
			File ficheroNuevaDiccionario = new File("JsonJacksonExample/src/recursos/diccionarioPersona.json");

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);


			mapper.writeValue(ficheroNuevaDiccionario, diccionarioPersonas);
		}
		catch(Exception ex)
        {
            System.out.println(ex);
        }
	}



	public static void leerFicheroPersonas2() {
		//File ficheroEmpleado = new File("src/recursos/employee.txt");
		File ficheroPersona = new File("JsonJacksonExample/src/recursos/Personas.json");
        //byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));
		
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		//convert json string to object
		People people = null;
        try {
			// con el obj maper leo el valor del fichero y le digo que el ficheroempleado debe unirlo a Employee.class
            people = objectMapper.readValue(ficheroPersona, People.class);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        System.out.println("Employee Object\n"+people);
        return people;
	}

	



    // public static HashMap<String, Persona> leerDiccionarioPersona() {
    //     return null;
    // }
	

    /*
    	
		//writing to console, can write to any output stream such as file
		StringWriter stringEmp = new StringWriter();
		objectMapper.writeValue(stringEmp, emp1);
		System.out.println("Employee JSON is\n"+stringEmp);
		
		
		//converting json to Map
		byte[] mapData = Files.readAllBytes(Paths.get("data.txt"));
		Map<String,String> myMap = new HashMap<String, String>();
		
		myMap = objectMapper.readValue(mapData, HashMap.class);
		System.out.println("Map is: "+myMap);
		//another way
		myMap = objectMapper.readValue(mapData, new TypeReference<HashMap<String,String>>() {});
		System.out.println("Map using TypeReference: "+myMap);
		
		//read JSON like DOM Parser
		JsonNode rootNode = objectMapper.readTree(jsonData);
		JsonNode idNode = rootNode.path("id");
		System.out.println("id = "+idNode.asInt());
		JsonNode phoneNosNode = rootNode.path("phoneNumbers");
		Iterator<JsonNode> elements = phoneNosNode.elements();
		while(elements.hasNext()){
			JsonNode phone = elements.next();
			System.out.println("Phone No = "+phone.asLong());
		}
		
		//update JSON data
		((ObjectNode) rootNode).put("id", 500);
		//add new key value
		((ObjectNode) rootNode).put("test", "test value");
		//remove existing key
		((ObjectNode) rootNode).remove("role");
		((ObjectNode) rootNode).remove("properties");
		objectMapper.writeValue(new File("updated_emp.txt"), rootNode);
        */
    
}
