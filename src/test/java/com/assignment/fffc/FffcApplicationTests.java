package com.assignment.fffc;

import com.assignment.fffc.model.Column;
import com.assignment.fffc.services.FormatConverter;
import com.assignment.fffc.processors.CSVMetadataProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FffcApplicationTests {

	@Autowired
	private FormatConverter formatConverter;

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldConvertFileFormat() throws Exception{

		File sampleOutput = new File("src/test/resources/files/sample-output.txt");
		File formattedFile = formatConverter.convert("src/test/resources/files/metadata.txt", "src/test/resources/files/data.txt", "src/test/resources/files/output.txt","csv");
		assert Arrays.equals(Files.readAllBytes(sampleOutput.toPath()), Files.readAllBytes(formattedFile.toPath()));
	}
}

