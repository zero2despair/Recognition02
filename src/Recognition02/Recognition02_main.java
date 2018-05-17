package Recognition02;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifyOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;

public class Recognition02_main {

	public static void mai(String[] args){

	VisualRecognition service = new VisualRecognition("2018-05-17");
	service.setApiKey("j16011");

	InputStream imagesStream=null;
	try{
		imagesStream = new FileInputStream("img/GODBOY.jpg");
	}catch (FileNotFoundException e){
		e.printStackTrace();
	}
	ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
	  .imagesFile(imagesStream)
	  .imagesFilename("fruitbowl.jpg")
	  .threshold((float) 0.6)
	  .owners(Arrays.asList("IBM"))
	  .build();
	ClassifiedImages result = service.classify(classifyOptions).execute();
	System.out.println(result);

	}
}
