package api.endpoint;

public class Routes {
/*
 * swagger url https://petstore.swagger.io/v2
 * create - https://petstore.swagger.io/v2/user
 * get/retrieve - https://petstore.swagger.io/v2/user/{username}
 * put/update - https://petstore.swagger.io/v2/user/{username}
 * delete - https://petstore.swagger.io/v2/user/{username}
 */
	public static String base_url = "https://petstore.swagger.io/v2";
	//User module
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String put_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//store module
	// here add store module url's
	
	//pet module
	//here add pet module url's
}
