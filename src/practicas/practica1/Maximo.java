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

public class Maximo {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, Text>{

    //private final static IntWritable one = new IntWritable(1);
    private Text clave = new Text("clave");

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
        context.write(clave, value); /* value: hola    24 */
    }
  }

  public static class IntSumReducer
       extends Reducer<Text, Text, Text, Text> {

    public void reduce(Text key, Iterable<Text> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int max = 0;
      Text valMax = new Text();
      for (Text val : values) {
    	  /* Pasar val a string */
    	  String valor = val.toString();
    	  /* Hacer split para coger el número */
    	  int indx   = valor.lastIndexOf('\t'); /* No son espacios sino tabulaciones */
    	  String aux = valor.substring(indx + 1);
    	  int veces = Integer.parseInt(aux);
    	  
    	  /* comprobar mayor y guardar en valMax */
    	  if (veces > max) {
    		  valMax = new Text(val);
    		  max = veces;
    	  }
      }
      context.write(key, valMax); /* que   19429 */
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(Maximo.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
