/* File Input */
var file = sc.textFile("hdfs://master:54310/books")

/** map */
var map = file.flatMap(line => line.split(" ")).map(word => (word,1));

/** reduce */
var counts = map.reduceByKey(_+_);

/* save the output to file */
counts.saveAsTextFile("hdfs://master:54310/books/SparkOutput")
