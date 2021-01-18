package driver;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.*;
import java.io.*;


public class Curl extends Command {
	public String getNameFromURL(String input) {
		String[] temp = input.split("/");
		String temp2 = temp[temp.length-1];
		String name = "";
		for(int i =0;i<temp2.length();i++) {
			if(temp2.charAt(i) == '.') {
				break;
			}
			name = name + temp2.charAt(i);
		}
		if(Finder.isDuplicateName(name, Command.cwd.address) == 1 
				&& IsValidName.checkValidName(name) == false) {
			return name;
		}
		return "";
	}
	public static boolean isUrlValid(String url) {
	    try {
	       URL obj = new URL(url);
	       obj.toURI();
	       return true;
	    } catch (MalformedURLException e) {
	       return false;
	    } catch (URISyntaxException e) {
	       return false;
	    }
	 }
	    public void execute(ArrayList<String> input)  {

	    	if(isUrlValid(input.get(0))) {
		        try {
			            URL url = new URL(input.get(0));
				        BufferedReader read = new BufferedReader(
				        new InputStreamReader(url.openStream()));
				
				        String content = "";
				        String i;
				        while ((i = read.readLine()) != null) {
				            content = content + i + "\n";
			        	}
				        read.close();
				        content = content ;
				        Echo file = new Echo();
				        if(getNameFromURL(input.get(0)).equals("")== false) {
					        file.outFileNotExist(Command.cwd.address,
					        		getNameFromURL(input.get(0)), '"'+content+'"');
					        }
				        }
		        catch (IOException e)
		        {   System.out.print("error");
		            e.printStackTrace();
		        }
	    	}
	    	else {
	    		System.out.println("invalid url");
	    	}
	    }
}
	


