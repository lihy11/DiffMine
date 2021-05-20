###  infomation 
method del:
-java.io.File.exists()
method add：
+java.io.File.isFile()
###  support count
project count : 5
commit count : 10
###  code
ProjectName: 28966-ringojs
CommitID: fb154b9a4c2c90cae952450a81f32c4ef18b4cb8
CommitMsg: Significant optimization in [FileResource|FileRepository].exists()

FilePath: src/org/ringojs/repository/FileResource.java**
```diff
     public boolean exists() {
-        // resource doesn't exist if it is a directory
-        return file.exists() && !file.isDirectory();
+        // not a resource if it's a directory
+        return file.isFile();
```
ProjectName: 11642-jacoco
CommitID: d0a73edd41a29f4c0ffabae15d7c023a37df976f
CommitMsg: Check whether source reference actually is a file (#941)

A corner case has been reported where `SourceFile` class file
attribute is empty, what causes `FileNotFoundException` with
message `Is a directory` during report generation. Instead of
throwing exception such cases should be handled as missing file.
FilePath: org.jacoco.report/src/org/jacoco/report/DirectorySourceFileLocator.java**
```diff
 		final File file = new File(directory, path);
-		if (file.exists()) {
+		if (file.isFile()) {
```
ProjectName: 11670-maven
CommitID: d639132f0b0cb91da8cceb4f60d3f7a1c2d95f83
CommitMsg: o Fixed file checks

git-svn-id: https://svn.apache.org/repos/asf/maven/components/trunk@729517 13f79535-47bb-0310-9956-ffa450edef68

FilePath: maven-project/src/main/java/org/apache/maven/profiles/DefaultMavenProfilesBuilder.java**
```diff
 
-        if ( profilesXml.exists() )
+        if ( profilesXml.isFile() )
```
ProjectName: 11670-maven
CommitID: d639132f0b0cb91da8cceb4f60d3f7a1c2d95f83
CommitMsg: o Fixed file checks

git-svn-id: https://svn.apache.org/repos/asf/maven/components/trunk@729517 13f79535-47bb-0310-9956-ffa450edef68

FilePath: maven-project/src/main/java/org/apache/maven/project/builder/impl/DefaultProjectBuilder.java**
```diff
             
-            return f.exists();
+            return f.isFile();
```
ProjectName: 11670-maven
CommitID: d639132f0b0cb91da8cceb4f60d3f7a1c2d95f83
CommitMsg: o Fixed file checks

git-svn-id: https://svn.apache.org/repos/asf/maven/components/trunk@729517 13f79535-47bb-0310-9956-ffa450edef68

FilePath: maven-project/src/main/java/org/apache/maven/project/builder/impl/DefaultProjectBuilder.java**
```diff
 
-        if ( !parentFile.exists() )
+        if ( !parentFile.isFile() )
```
ProjectName: 11670-maven
CommitID: d639132f0b0cb91da8cceb4f60d3f7a1c2d95f83
CommitMsg: o Fixed file checks

git-svn-id: https://svn.apache.org/repos/asf/maven/components/trunk@729517 13f79535-47bb-0310-9956-ffa450edef68

FilePath: maven-project/src/main/java/org/apache/maven/project/builder/PomClassicDomainModel.java**
```diff
     {
-        return projectDirectory != null && new File(projectDirectory, "pom.xml").exists();
+        return projectDirectory != null && new File(projectDirectory, "pom.xml").isFile();
```
ProjectName: 19464-gpslogger
CommitID: d3c429ddb5adf8e063920473bb1d11587040f056
CommitMsg: Merge branch 'issue-594' into customurlplus

FilePath: gpslogger/src/main/java/com/mendhak/gpslogger/loggers/gpx/Gpx10FileLogger.java**
```diff
             try {
-                if (!gpxFile.exists()) {
+                if (!gpxFile.isFile()) {
```
ProjectName: 19464-gpslogger
CommitID: f1a49d04058ba3f91491d38f42fdc0b933140896
CommitMsg: Using isfile instead of exists

FilePath: gpslogger/src/main/java/com/mendhak/gpslogger/loggers/gpx/Gpx10FileLogger.java**
```diff
             try {
-                if (!gpxFile.exists()) {
+                if (!gpxFile.isFile()) {
```
ProjectName: 6682-byte-buddy
CommitID: 838148dd9b735651720094e59f7ce10c1fe7880f
CommitMsg: Capture wrong file type in checks.

FilePath: byte-buddy-dep/src/main/java/net/bytebuddy/dynamic/DynamicType.java**
```diff
             try {
-                if (!targetJar.exists() && !targetJar.createNewFile()) {
+                if (!targetJar.isFile() && !targetJar.createNewFile()) {
```
ProjectName: 6682-byte-buddy
CommitID: 838148dd9b735651720094e59f7ce10c1fe7880f
CommitMsg: Capture wrong file type in checks.

FilePath: byte-buddy-dep/src/main/java/net/bytebuddy/dynamic/DynamicType.java**
```diff
         public File toJar(File file, Manifest manifest) throws IOException {
-            if (!file.exists() && !file.createNewFile()) {
+            if (!file.isFile() && !file.createNewFile()) {
```
