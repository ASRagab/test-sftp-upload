name := "test-sftp-upload"

version := "0.0.1"

scalaVersion := "2.11.12"

resolvers += "Spark Packages Repo" at "https://dl.bintray.com/spark-packages/maven"

libraryDependencies ++= Seq(
        "org.apache.spark" %% "spark-sql"  % "2.3.2",
        "org.apache.spark" %% "spark-core" % "2.3.2",
        "com.jcraft"        % "jsch"       % "0.1.55",
        "org.scalatest"    %% "scalatest"  % "3.0.5" % "test",
        "com.springml"     %% "spark-sftp" % "1.1.3"
        )

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

