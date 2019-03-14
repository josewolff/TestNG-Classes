package generateXmlFile;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.hubspot.jinjava.Jinjava;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by josea.wolff on 3/14/19.
 */
public class GenerateTestNGFile {

    public static void main (String[] args) throws IOException {
        String env = args[0];
        String groupsToRun = args[1];
        Map<String, Object> context = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String testNgTemplatePath = System.getProperty("user.dir") + "/src/main/resources/template.xml";
        System.out.println("\n#############################################################\n");
        System.out.println("\t\t\t\t Reading .deploy/" + env + ".yml\n" );
        System.out.println("#############################################################\n");
        ConfigurationFile configurations = mapper.readValue(new File(".deploy/" + env + ".yml"), ConfigurationFile.class);
        context.put("env", configurations.getEnv());
        context.put("host", configurations.getHost());
        context.put("groupsToRun", groupsToRun.split(","));
        String testNgFile = renderTemplate(context, testNgTemplatePath);
        writeFile(testNgFile, "testng.xml");
    }


    private static String renderTemplate(Map<String, Object> context, String path) {
        Jinjava jinjava = new Jinjava();
        String renderedTemplate = "";
        try {
            File file = new File(path);
            String template = FileUtils.readFileToString(file);
            renderedTemplate = jinjava.render(template, context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderedTemplate;
    }


    private static void writeFile(String renderedTemplate, String fileName) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(renderedTemplate);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
