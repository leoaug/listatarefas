package listatarefas.util;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WebServiceUtil {
	private static Client client = Client.create();
	
	public static List <?> requisicaoGET(String url) throws Exception {
	
		WebResource wr = client.resource(url);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<?>>(){}.getType());
		
	}
	
	public static Integer requisicaoPOST(String url,String jsonInput){
		
		WebResource webResource = client.resource(url);

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, jsonInput);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
			
		} else{
			System.out.println("Output from Server .... \n");
		}

		return response.getStatus();
		
		
	}
	
	public static String requisicaoDELETE(String url,String jsonInput){
		
		WebResource webResource = client.resource(url);

		ClientResponse response = webResource.type("application/json").delete(ClientResponse.class, jsonInput);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
			
		} else{
			System.out.println("Output from Server .... \n");
		}

		return response.getEntity(String.class);
		
		
	}

}
