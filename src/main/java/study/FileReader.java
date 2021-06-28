package study;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public String read() throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();

		try (Scanner scanner = new Scanner(new File("test.txt"))) {
			while (scanner.hasNextLine()) {
				sb.append(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}

		return sb.toString();
	}
}
