#Install custom jar locally (open cmd in project file)

mvn install:install-file -Dfile=lib/CustomComponents.jar -DgroupId=custom.style -DartifactId=customComponents -Dversion=1.0.0 -Dpackaging=jar

To use custom components in NetBeans GUI Builder, go to Tools > Palette > Swing Components, and import the JAR file manually using “Add from JAR”.
