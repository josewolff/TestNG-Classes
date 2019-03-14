package utils;

public class SetUpUrls {

    public static void initUrlS(){
        String host = GlobalVariables.host;
        GlobalVariables.apiGetAllUsers = host + "api/users/";
        GlobalVariables.apiCreateNewUser = host + "api/users/add/";
        GlobalVariables.apiDeleteUsers = host + "api/users/remove/";
    }
}
