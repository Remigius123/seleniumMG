package HelperComponents;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class makeDir {
	public static void makeDirectory() {
		Date now = new Date();
		//dd-MM-yy HH:mm:ss
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
		String time = dateFormat.format(now);
		File dir = new File("./Reports/"+time);
		dir.mkdir();
	}
}
