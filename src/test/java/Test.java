import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Test {
	public static void main(String[] args) {

		File pdfFile = new File(
				"/Users/shreeram/eclipse-workspace/SeleniumBasics/src/test/java/PhonePe_Transaction_Statement.pdf");
		double sum = 0;
		double sum1 = 0;
		int count = 1;
		String firstLine = "";

		try (PDDocument doc = PDDocument.load(pdfFile)) {

			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(doc);
			String[] lines = text.split("\\R");
			for (String line : lines) {
				if (line.contains("Debit INR") && line.length() > 10) {
					System.out.println("Length of line is " + line.length());
					firstLine = line.trim();
					System.out.println("Output is " + firstLine);
					sum += Double.parseDouble(firstLine.substring(10).trim());
				} else if (line.contains("Debit INR") && line.length() == 10) {
					firstLine = line.trim();
					System.out.println("Output ELSE " + firstLine);
					sum1 += Double.parseDouble(firstLine.substring(10).trim());
					// find this line's index in the lines[] array so we can read the next line
					int idx = -1;
					for (int j = 0; j < lines.length; j++) {
						if (lines[j].equals(line)) {
							idx = j;
							break;
						}
					}

					if (idx != -1 && idx + 1 < lines.length) {
						String nextLine = lines[idx + 1].trim();
						// keep only digits, comma and dot, then remove commas
						String num = nextLine.replaceAll("[^0-9.,]", "").replaceAll(",", "");
						if (!num.isEmpty()) {
							try {
								sum1 += Double.parseDouble(num);
							} catch (NumberFormatException e) {
								System.err.println("Could not parse number from line: " + nextLine);
							}

						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Total Debit Amount: " + sum);
		System.out.println("Total SUM1 Amount: " + sum1);
	}
}
