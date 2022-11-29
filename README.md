# LSEG-task4

**To avoid errors, you need to add the path to the libraries from folder "libraries" in each project. 
add "jsoup-1.15.3.jar" and "aspose.cells-22.101.jar" manualy**

Project 4 work the same like Project 2; 
1. We get file with storm data to PC. And Convert to XLS format. (data_without_formating.xls)
2. We are operating in xls file by HSSFWorkbook and get or compare values from Cells.
Finally we get 4 rows with name of the storm and maximum speed per year. 

![image](https://user-images.githubusercontent.com/57364788/204183703-7b22c300-4ffe-42e4-baa3-87e0ba2a6e32.png)

Aspose lib to convert txt to xls. (https://products.aspose.com/cells/java/conversion/txt-to-xls/)

Maven:
<dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>5.2.1</version>
        </dependency>

        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>5.2.1</version>
        </dependency>

        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-to-slf4j</artifactId>
            <version>2.8.2</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.7.32</version>
        </dependency>

        <dependency>
            <groupId>com.sun.xml.bind</groupId>
            <artifactId>jaxb-core</artifactId>
            <version>2.3.0.1</version>
        </dependency>
        <dependency>
            <groupId>javax.xml.bind</groupId>
            <artifactId>jaxb-api</artifactId>
            <version>2.3.1</version>
        </dependency>
        <dependency>
            <groupId>com.sun.xml.bind</groupId>
            <artifactId>jaxb-impl</artifactId>
            <version>2.3.1</version>
        </dependency>
        <dependency>
            <groupId>org.javassist</groupId>
            <artifactId>javassist</artifactId>
            <version>3.25.0-GA</version>
        </dependency>
