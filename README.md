spark-shell-deps
================
A simple script to build a jar with all dependencies needed for your Spark shell session.

Motivation
----------
To encourage Spark and Scala usage for those who may not have used either before.  

One of the challenges of using the spark-shell for data exploration is adding libraries once you get beyond basic functionality. Especially if you are newer to Scala or Java and have not used tools like Maven or Gradle to resolved dependencies before. This script aims to eliminate that overhead and create a single jar with all the dependencies you need.

Once some polish is added to this implementation it should ease exploratory work in the Spark-shell.

>*Note*:
>   This project uses [Gradle](http://www.gradle.org). You must install [Gradle(2.2)](http://www.gradle.org/downloads).
>   If you would rather not install Gradle locally you can use the [Gradle Wrapper](http://www.gradle.org/docs/current/userguide/gradle_wrapper.html) by replacing all refernces to ```gradle``` with ```gradlew```.


Make the Jar
------------
1. Add any dependencies you like to the config.gradle file.
2. Execute ```gradle build``` to build a jar with all dependencies. The generated jar will be in './build/libs/'

>*Note*:
>   At this point you can copy the jar manually wherever you need. However, deploy functionality was added for convenience. See below.

Using the Jar
-----------
When executing ```spark-shell``` add the ```--jars``` argument with the path to the generated jar.

Ex: ```spark-shell --jars ~/spark-shell-deps/spark-shell-deps-*.jar```


Deploy Locally
--------------
1. Set the localDeployPath in the config.gradle file.
2. Execute ```gradle deployLocal``` to copy the jar to the specified location.


Deploy Remotely
---------------
1. Set the remoteDeployHost, remoteDeployUser, and remoteDeployPath in the config.gradle file.
2. Execute ```gradle deployRemote``` to copy the jar to the specified host and location.
3. When prompted enter the shh password for the specified user account.
4. Wait for the jar to upload


Check for dependency updates
-----------------------------
Execute ```gradle dependencyUpdates``` to list dependencies with new versions available.


Customize
---------
You can change any functionality by editing the build.gradle script. However this requires some knowledge of Gradle and the plugins used. See links below.


Key Spark Links:
----------------
- [Programming Guide](http://spark.apache.org/docs/latest/programming-guide.html)
- [Configuration Guide](http://spark.apache.org/docs/latest/configuration.html)
- [Downloads](http://spark.apache.org/downloads.html)


Default Libraries:
------------------
- [Commons Lang](http://commons.apache.org/proper/commons-lang/)
- [Commons Math](http://commons.apache.org/proper/commons-math/)
- [Joda-Time](http://www.joda.org/joda-time/)
- [OpenCSV](http://opencsv.sourceforge.net/)
- [Breeze](https://github.com/scalanlp/breeze)
- [Chalk](https://github.com/scalanlp/chalk)
- [Lucene Snowball](http://lucene.apache.org/core/3_0_3/api/contrib-snowball/)
- [Core NLP](http://nlp.stanford.edu/software/corenlp.shtml)

Gradle Plugins Used:
--------------------
- [SSH Plugin](https://gradle-ssh-plugin.github.io/)
- [Versions Plugin](https://github.com/ben-manes/gradle-versions-plugin)


TODO:
-----
- Add shell script to (using gradlew) eliminate need for Gradle calls/knowledge.
- Test on windows
- Find better way to reference artifact in Gradle
- Review README
