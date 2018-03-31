package TextFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile {

	public static String fileName = "D:\\Testfile.txt";
	public static String content = "Writing first line in the text file";
	static FileWriter fw;
	static BufferedWriter bw;

	public static void main(String[] args) {

		File file = new File(fileName);
		try {
			file.createNewFile();

			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(content);

		} catch (IOException e) {

			e.printStackTrace();
		}

		finally {

			try {

				if (bw != null)
					bw.flush();

				if (fw != null)
					fw.flush();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
