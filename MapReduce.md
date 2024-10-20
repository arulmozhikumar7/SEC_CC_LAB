# Simple Word Count Program Using MapReduce in Java

## Objective
To create a simple MapReduce program that counts the occurrences of each word in a text file.

## Prerequisites
- Apache Hadoop installed and configured.
- Java Development Kit (JDK) installed.
- Eclipse IDE installed.

## Steps

### Step 1: Create Java Project in Eclipse

1. **Open Eclipse** and create a new Java Project.
   - Navigate to **File -> New -> Java Project**.
   - Enter the project name as `WordCount`, select **JavaSE-1.8**, and click the **Finish** button.

2. **Add Hadoop JAR Files** to the Project:
   - Right-click on the `WordCount` project in the Package Explorer and select **Properties**.
   - Under **Libraries**, click on **Add External JARs**.
   - From the Hadoop installed directory (`/usr/local/hadoop`), add the following JAR files:
     1. `hadoop-common-2.7.7.jar` from `/usr/local/hadoop/share/hadoop/common`
     2. `common-cli-1.2.jar` from `/usr/local/hadoop/share/hadoop/common/lib`
     3. `hadoop-mapreduce-client-core-2.7.7.jar` from `/usr/local/hadoop/share/hadoop/mapreduce`

### Step 2: Create Package and Class

1. **Create a New Package**:
   - Right-click on the `src` folder → **New** → **Package**.
   - Enter the package name as `WordCount` and click on the **Finish** button.

2. **Create a New Class**:
   - Right-click on the package `WordCount` → **New** → **Class**.
   - Name the class `WordCount.java` and click on the **Finish** button.

### Step 3: Write the Java Code

1. Copy and paste the following code into `WordCount.java`:

   ```java
   package WordCount;

   import java.io.IOException;
   import java.util.StringTokenizer;
   import org.apache.hadoop.conf.Configuration;
   import org.apache.hadoop.fs.Path;
   import org.apache.hadoop.io.IntWritable;
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Job;
   import org.apache.hadoop.mapreduce.Mapper;
   import org.apache.hadoop.mapreduce.Reducer;
   import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
   import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

   public class WordCount {

       public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
           private final static IntWritable one = new IntWritable(1);
           private Text word = new Text();

           public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
               StringTokenizer itr = new StringTokenizer(value.toString());
               while (itr.hasMoreTokens()) {
                   word.set(itr.nextToken());
                   context.write(word, one);
               }
           }
       }

       public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
           private IntWritable result = new IntWritable();

           public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
               int sum = 0;
               for (IntWritable val : values) {
                   sum += val.get();
               }
               result.set(sum);
               context.write(key, result);
           }
       }

       public static void main(String[] args) throws Exception {
           Configuration conf = new Configuration();
           Job job = Job.getInstance(conf, "word count");
           job.setJarByClass(WordCount.class);
           job.setMapperClass(TokenizerMapper.class);
           job.setCombinerClass(IntSumReducer.class);
           job.setReducerClass(IntSumReducer.class);
           job.setOutputKeyClass(Text.class);
           job.setOutputValueClass(IntWritable.class);
           FileInputFormat.addInputPath(job, new Path(args[0]));
           FileOutputFormat.setOutputPath(job, new Path(args[1]));
           System.exit(job.waitForCompletion(true) ? 0 : 1);
       }
   }
   ```

2. **Check for Errors**: Make sure there are no errors in the code.

### Step 4: Export the Project as a JAR File

1. Right-click on the `WordCount` project → **Export**.
2. Select **JAR file** option under **Java**.
3. Click **Next**. Uncheck all other resources, then provide the path for exporting the `.jar` file (choose any path but remember it for running the jar file later).
4. Keep the following options selected:
   - Export generated class files and resources
   - Include directory entries
5. Click **Next** and then **Finish**.

### Step 5: Create Input Text File

1. Create a text file named `input.txt` with the following content:

   ```
   hi how are you
   welcome to velammal engineering college
   We are from computer science department
   ```

### Step 6: Set Up Hadoop

1. Place the `input.txt` file in the Hadoop filesystem (HDFS):

   ```bash
   hadoop fs -mkdir /input
   hadoop fs -put input.txt /input
   ```

### Step 7: Run the MapReduce Job

1. Run the MapReduce job using the following command:

   ```bash
   hadoop jar /path/to/your/WordCount.jar WordCount /input/input.txt /output
   ```

   Replace `/path/to/your/WordCount.jar` with the actual path where you exported the JAR file.

### Step 8: View the Output

1. To see the word counts, use the following command:

   ```bash
   hadoop fs -cat /output/part-r-00000
   ```

### Expected Output

The output will display the count of each word:

```
hi 1
how 1
are 2
you 1
welcome 1 
to 1
velammal 1
engineering 1 
college 1
We 1
from 1
computer 1
science 1
department 1
```